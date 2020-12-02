package com.example.listview_recyclerview.listview;

public class family {
    private String name;
    private String guanxi;
    private  int imageId;
    private boolean ischecked = false;

    public boolean getisIschecked() {
        return ischecked;
    }

    public void setIschecked(boolean ischecked) {
        this.ischecked = ischecked;
    }

    public family(String name, String guanxi, int imageId, boolean ischecked) {

        this.name = name;
        this.guanxi = guanxi;
        this.imageId = imageId;
        this.ischecked=ischecked;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGuanxi(String guanxi) {
        this.guanxi = guanxi;
    }

    public void setImageId(int imageId) {
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
