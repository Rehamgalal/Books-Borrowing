package com.example.reham.booksborrowing.Data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by reham on 3/26/2019.
 */

public class VolumeInformation {
    @SerializedName("title")
    private String title;
    @SerializedName("authors")
    private String[] Author;
    @SerializedName("publisher")
    String Publisher;
    @SerializedName("description")
    String Description;
    @SerializedName("pageCount")
    String pageCount;
    @SerializedName("categories")
    String[] Categories;
    @SerializedName("imageLinks")
    ImageLinks imageLinks;
    @SerializedName("language")
    String language;
    @SerializedName("previewLink")
    String previewLink;
    @SerializedName("averageRating")
    String averageRating;
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String[] author) {
        Author = author;
    }

    public void setPublisher(String publisher) {
        Publisher = publisher;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setPageCount(String pageCount) {
        this.pageCount = pageCount;
    }

    public void setCategories(String[] categories) {
        Categories = categories;
    }

    public void setImageLinks(ImageLinks imageLinks) {
        this.imageLinks = imageLinks;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setPreviewLink(String previewLink) {
        this.previewLink = previewLink;
    }

    public void setAverageRating(String averageRating) {
        this.averageRating = averageRating;
    }

    public String getTitle() {
        return title;
    }

    public String[] getAuthor() {
        return Author;
    }

    public String getPublisher() {
        return Publisher;
    }

    public String getDescription() {
        return Description;
    }

    public String getPageCount() {
        return pageCount;
    }

    public String[] getCategories() {
        return Categories;
    }

    public ImageLinks getImageLinks() {
        return imageLinks;
    }

    public String getLanguage() {
        return language;
    }

    public String getPreviewLink() {
        return previewLink;
    }

    public String getAverageRating() {
        return averageRating;
    }
}
