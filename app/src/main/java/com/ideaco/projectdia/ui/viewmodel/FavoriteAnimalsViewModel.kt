package com.ideaco.projectdia.ui.viewmodel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ideaco.projectdia.data.repository.AnimalRepository
import com.ideaco.projectdia.ui.model.AnimalResponse
import com.ideaco.projectdia.utils.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.DisposableSubscriber
import javax.inject.Inject

@HiltViewModel
class FavoriteAnimalsViewModel @Inject constructor(
    private val animalRepository: AnimalRepository
) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private val favoriteAnimalsLiveData = MutableLiveData<ViewState<List<AnimalResponse>>>()

    fun getFavoriteAnimals() {
        compositeDisposable.add(
            animalRepository.getFavoriteAnimal()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSubscriber<List<AnimalResponse>>() {
                    override fun onNext(t: List<AnimalResponse>?) {
                        t?.let {
                            if(it.isNotEmpty()){
                                favoriteAnimalsLiveData.value = ViewState.success(t)
                            }else{
                                favoriteAnimalsLiveData.value = ViewState.empty("No data found")
                            }
                        }
                    }

                    override fun onError(t: Throwable?) {
                        t?.message?.let{
                            favoriteAnimalsLiveData.value = ViewState.error(it, null)
                        }

                    }

                    override fun onComplete() {

                    }

                })
        )
    }

    fun getFavoriteAnimalsLiveData(): MutableLiveData<ViewState<List<AnimalResponse>>> =
        favoriteAnimalsLiveData

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
        compositeDisposable.dispose()
    }
}