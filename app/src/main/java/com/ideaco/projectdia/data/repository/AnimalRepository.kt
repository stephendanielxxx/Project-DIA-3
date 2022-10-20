package com.ideaco.projectdia.data.repository

import com.ideaco.projectdia.data.remote.AnimalRemoteDataSource
import com.ideaco.projectdia.ui.model.AnimalResponse
import io.reactivex.Single

class AnimalRepository (private val animalRemoteDataSource: AnimalRemoteDataSource) {
    fun getRandomAnimal(): Single<AnimalResponse> {
        return animalRemoteDataSource.getRandomAnimal()
    }

    fun getRandomAnimals(number: Int): Single<List<AnimalResponse>>{
        return animalRemoteDataSource.getRandomAnimals(number)
    }
}