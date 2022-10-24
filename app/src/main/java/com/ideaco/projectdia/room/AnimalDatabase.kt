package com.ideaco.projectdia.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ideaco.projectdia.room.model.AnimalEntity

@Database(entities = [AnimalEntity::class], version = 1)
abstract class AnimalDatabase: RoomDatabase() {
    abstract fun animalDao(): AnimalDao
}