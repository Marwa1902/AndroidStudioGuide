package com.uos.myapplication;

public class TV_Shows {
    private String show_title;
    private String year;
    private String ratings;
    private String genre;
    private int image;


    //to get constructors, just second click and get constructor
    public void setTitle(String title) {
        this.show_title = title;
    }

    public void setYear(String year){this.year = year;}

    public void setRating(String rating) {
        this.ratings = rating;
    }

    public TV_Shows(String genre) {
        this.genre = genre;
    }

    public void setImage_id(int image_id) {
        this.image = image_id;
    }


    public TV_Shows(String title, String year, String rating, String genre, int image_id) {
        this.show_title = title;
        this.year = year;
        this.ratings = rating;
        this.genre = genre;
        this.image = image_id;
    }

    public String getTitle() {

        return show_title;
    }

    public String getYear(){
        return year;}

    public String getRating() {

        return ratings;
    }

    public String getGenre() {
        return genre;
    }

    public int getImage_id() {
        return image;
    }
}
