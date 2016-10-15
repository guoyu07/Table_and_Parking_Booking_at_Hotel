package com.example.root.tableandparkingbookingathotel;

/**
 * Created by root on 10/15/16.
 */
public class Album {
    private String name;
    private int review;
    private int thumbnail;

    public Album() {
    }

    public Album(String name, int review, int thumbnail) {
        this.name = name;
        this.review = review;
        this.thumbnail = thumbnail;
    }

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReview() {
        return review;
    }

    public void setReview(int review) {
        this.review = review;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
