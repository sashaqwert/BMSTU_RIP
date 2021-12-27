package ru.sccraft.bmstulabs.rip.animals

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface POST_RestApi {

    @Headers("Content-Type: application/json")
    @POST("animals/")
    fun addAnimal(@Body animalData: Animal): Call<Animal>
}