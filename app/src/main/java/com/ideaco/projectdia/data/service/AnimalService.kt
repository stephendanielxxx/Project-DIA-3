package com.ideaco.projectdia.data.service

import com.ideaco.projectdia.ui.model.AnimalResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AnimalService {
    @GET("/animals/rand")
    fun getRandomAnimal(): Single<AnimalResponse>

    @GET("/animals/rand/{number}")
    fun getRandomAnimals(@Path("number") number: Int): Single<List<AnimalResponse>>
}