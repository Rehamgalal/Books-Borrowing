package com.example.reham.booksborrowing.Data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by reham on 3/25/2019.
 */

public class Book {
    @SerializedName("items")
    private List<Items> items;

    public void setItems(List<Items>items) {
        this.items = items;
    }

    public List<Items> getItems() {
        return items;
    }
}
