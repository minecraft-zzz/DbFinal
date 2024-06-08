package com.example.dbcoursefinalproject.entity;

public class Film {
    String workId;
    String orderding;
    String title;
    String region;
    String language;
    String type;
    int startyear;
    int runtimeMinutes;
    String genres;
    String url;
    float rating;
    String filmImg;
    int isAdult;
    int numberOfGraders;

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    public String getOrderding() {
        return orderding;
    }

    public void setOrderding(String orderding) {
        this.orderding = orderding;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getStartyear() {
        return startyear;
    }

    public void setStartyear(int startyear) {
        this.startyear = startyear;
    }

    public int getRuntimeMinutes() {
        return runtimeMinutes;
    }

    public void setRuntimeMinutes(int runtimeMinutes) {
        this.runtimeMinutes = runtimeMinutes;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getFilmImg() {
        return filmImg;
    }

    public void setFilmImg(String filmImg) {
        this.filmImg = filmImg;
    }

    public int getIsAdult() {
        return isAdult;
    }

    public void setIsAdult(int isAdult) {
        this.isAdult = isAdult;
    }

    public int getNumberOfGraders() {
        return numberOfGraders;
    }

    public void setNumberOfGraders(int numberOfGraders) {
        this.numberOfGraders = numberOfGraders;
    }

    @Override
    public String toString() {
        return "Film{" +
                "workId='" + workId + '\'' +
                ", orderding='" + orderding + '\'' +
                ", title='" + title + '\'' +
                ", region='" + region + '\'' +
                ", language='" + language + '\'' +
                ", type='" + type + '\'' +
                ", startyear=" + startyear +
                ", runtimeMinutes=" + runtimeMinutes +
                ", genres='" + genres + '\'' +
                ", url='" + url + '\'' +
                ", rating=" + rating +
                ", filmImg='" + filmImg + '\'' +
                ", isAdult=" + isAdult +
                ", numberOfGraders=" + numberOfGraders +
                '}';
    }
}
