package com.ideaco.projectdia.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ideaco.projectdia.room.model.AnimalEntity
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
interface AnimalDao {
    @Query("select * from animal")
    fun getFavoriteAnimals(): Flowable<List<AnimalEntity>>

    @Insert
    fun insertAnimal(animalEntity: AnimalEntity): Single<Long>
}