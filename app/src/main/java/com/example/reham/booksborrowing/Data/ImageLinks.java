package com.example.reham.booksborrowing.Data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by reham on 3/26/2019.
 */

public class ImageLinks {
    @SerializedName("smallThumbnail")
    String smallThumbnail;
    @SerializedName("thumbnail")
    String thumbnail;
    @SerializedName("small")
    String small;
    @SerializedName("medium")
    String medium;
    @SerializedName("large")
    String large;

    public void setSmallThumbnail(String smallThumbnail) {
        this.smallThumbnail = smallThumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getSmallThumbnail() {
        return smallThumbnail;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getLarge() {
        return large;
    }

    public String getMedium() {
        return medium;
    }

    public String getSmall() {
        return small;
    }
}
