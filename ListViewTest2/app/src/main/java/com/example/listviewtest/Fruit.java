package com.example.listviewtest;

public class Fruit {
    private String name;
    private Integer imageId;

    public Fruit() {
    }

    public Fruit(String name, Integer imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }
}
