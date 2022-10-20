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

class RandomAnimalViewModel: ViewModel() {
    private var randomAnimalLiveData = MutableLiveData<AnimalResponse>()
    private val compositeDisposable = CompositeDisposable()

    private var animalService: AnimalService = AnimalRetrofit.animalService
    private var animalRemoteDataSource: AnimalRemoteDataSource = AnimalRemoteDataSource(animalService)
    private var animalRepository: AnimalRepository = AnimalRepository(animalRemoteDataSource)

    fun getRandomAnimal(){
        compositeDisposable.add(
            animalRepository.getRandomAnimal()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<AnimalResponse>(){
                    override fun onSuccess(t: AnimalResponse) {
                        randomAnimalLiveData.value = t
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }

                })
        )
    }

    fun getRandomAnimalLiveData(): MutableLiveData<AnimalResponse> = randomAnimalLiveData

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
        compositeDisposable.dispose()
    }

}