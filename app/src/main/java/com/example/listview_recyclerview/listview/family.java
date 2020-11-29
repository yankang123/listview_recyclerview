package com.example.listview_recyclerview.listview;

public class family {
    private String name;
    private String guanxi;
    private  int imageId;

    public family(String name, String guanxi, int imageId) {

        this.name = name;
        this.guanxi = guanxi;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public String getGuanxi() {
        return guanxi;
    }

    public int getImageId() {
        return imageId;
    }
}
