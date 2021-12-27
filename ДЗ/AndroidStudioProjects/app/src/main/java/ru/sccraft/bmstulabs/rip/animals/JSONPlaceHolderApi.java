package ru.sccraft.bmstulabs.rip.animals;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JSONPlaceHolderApi {
    @GET("/animals")
    public Call<List<Animal>> getAllAnimals();
}
