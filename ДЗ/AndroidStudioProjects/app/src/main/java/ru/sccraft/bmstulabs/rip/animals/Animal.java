package ru.sccraft.bmstulabs.rip.animals;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Animal {
    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("animal_name")
    @Expose
    private String animal_name;

    @SerializedName("animal_type")
    @Expose
    private String animal_type;

    @SerializedName("animal_photo")
    @Expose
    private String animal_photo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnimal_name() {
        return animal_name;
    }

    public String getAnimal_type() {
        return animal_type;
    }

    public String getAnimal_photo() {
        return animal_photo;
    }

    public void setAnimal_name(String animal_name) {
        this.animal_name = animal_name;
    }

    public void setAnimal_type(String animal_type) {
        this.animal_type = animal_type;
    }

    public void setAnimal_photo(String animal_photo) {
        this.animal_photo = animal_photo;
    }

    @NonNull
    @Override
    public String toString() {
        return animal_name + "\n" + animal_type;
    }
}
