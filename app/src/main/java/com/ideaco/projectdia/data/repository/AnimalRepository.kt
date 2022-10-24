package com.ideaco.projectdia.data.repository

import com.ideaco.projectdia.data.local.AnimalLocalDataSource
import com.ideaco.projectdia.data.remote.AnimalRemoteDataSource
import com.ideaco.projectdia.room.model.AnimalEntity
import com.ideaco.projectdia.ui.model.AnimalResponse
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

class AnimalRepository @Inject constructor(
    private val animalRemoteDataSource: AnimalRemoteDataSource,
    private val animalLocalDataSource: AnimalLocalDataSource
) {
    fun getRandomAnimal(): Single<AnimalResponse> {
        return animalRemoteDataSource.getRandomAnimal()
    }

    fun getRandomAnimals(number: Int): Single<List<AnimalResponse>> {
        return animalRemoteDataSource.getRandomAnimals(number)
    }

    fun insertAnimal(animalResponse: AnimalResponse): Single<Long> {
        val animalEntity = AnimalEntity(name = animalResponse.name, image = animalResponse.imageLink)
        return animalLocalDataSource.insertAnimal(animalEntity)
    }

    fun getFavoriteAnimal(): Flowable<List<AnimalResponse>>{
        return animalLocalDataSource.getFavoriteAnimals().map {
            toAnimalResponses(it)
        }
    }

    private fun toAnimalResponse(animalEntity: AnimalEntity): AnimalResponse {
        return AnimalResponse(animalEntity.name, "", "", "",
            "", "","", "", "", "",
        "", "", animalEntity.image, "")
    }

    private fun toAnimalResponses(animalEntities: List<AnimalEntity>): List<AnimalResponse>{
        return animalEntities.map {
            toAnimalResponse(it)
        }.toList()
    }

}