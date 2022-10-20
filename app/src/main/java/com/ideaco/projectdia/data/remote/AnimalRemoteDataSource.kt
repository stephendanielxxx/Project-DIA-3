package com.ideaco.projectdia.data.remote

import com.ideaco.projectdia.data.service.AnimalService
import com.ideaco.projectdia.ui.model.AnimalResponse
import io.reactivex.Single

class AnimalRemoteDataSource(private val animalService: AnimalService) {
    //Opsi 1
    fun getRandomAnimal(): Single<AnimalResponse> {
        return animalService.getRandomAnimal()
    }

    fun getRandomAnimals(number: Int): Single<List<AnimalResponse>> {
        return animalService.getRandomAnimals(number)
    }

    //Opsi 2
//    fun getRandomAnimal(): Single<AnimalResponse> = animalService.getRandomAnimal()

}