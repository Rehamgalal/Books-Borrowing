package com.example.reham.booksborrowing.Data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by reham on 3/26/2019.
 */

public class Items {
   @SerializedName("volumeInfo")
    VolumeInformation volumeInformation;
   @SerializedName("id")
   String id;
   @SerializedName("imageLinks")
   ImageLinks imageLinks;
    public void setVolumeInformation(VolumeInformation volumeInformation) {
        this.volumeInformation = volumeInformation;
    }

    public VolumeInformation getVolumeInformation() {
        return volumeInformation;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setImageLinks(ImageLinks imageLinks) {
        this.imageLinks = imageLinks;
    }

    public ImageLinks getImageLinks() {
        return imageLinks;
    }
}
