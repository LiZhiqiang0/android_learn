package com.example.myapplication2;

public class PersonInfo {
    private String name;
    private int imageId;
    private String detail;

    public PersonInfo(String name, int imageId, String detail){
        this.name=name;
        this.imageId=imageId;
        this.detail = detail;
    }
    public String getName(){
        return name;
    }
    public int getImageId(){
        return imageId;
    }
    public String getDetail(){
        return detail;
    }
}
