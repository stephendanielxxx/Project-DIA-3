package com.ideaco.projectdia.data.local

import com.ideaco.projectdia.room.AnimalDao
import com.ideaco.projectdia.room.model.AnimalEntity
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

class AnimalLocalDataSource @Inject constructor(private val animalDao: AnimalDao) {

    fun getFavoriteAnimals(): Flowable<List<AnimalEntity>> {
        return animalDao.getFavoriteAnimals()
    }

    fun insertAnimal(animalEntity: AnimalEntity): Single<Long> {
        return animalDao.insertAnimal(animalEntity)
    }

}