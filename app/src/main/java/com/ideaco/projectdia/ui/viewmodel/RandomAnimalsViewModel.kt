package com.ideaco.projectdia.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ideaco.projectdia.data.remote.AnimalRemoteDataSource
import com.ideaco.projectdia.data.repository.AnimalRepository
import com.ideaco.projectdia.data.service.AnimalService
import com.ideaco.projectdia.retrofit.AnimalRetrofit
import com.ideaco.projectdia.ui.model.AnimalResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class RandomAnimalsViewModel: ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    private val randomAnimalsLiveData = MutableLiveData<List<AnimalResponse>>()

    private var animalService: AnimalService = AnimalRetrofit.animalService
    private var animalRemoteDataSource: AnimalRemoteDataSource = AnimalRemoteDataSource(animalService)
    private var animalRepository: AnimalRepository = AnimalRepository(animalRemoteDataSource)

    fun getRandomAnimals(number: Int){
        compositeDisposable.add(
            animalRepository.getRandomAnimals(number)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<AnimalResponse>>() {
                    override fun onSuccess(t: List<AnimalResponse>) {
                        randomAnimalsLiveData.value = t
                    }
                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }
                })
        )
    }

    fun getRandomAnimalsLiveData(): MutableLiveData<List<AnimalResponse>> {
        return randomAnimalsLiveData
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
        compositeDisposable.dispose()
    }
}