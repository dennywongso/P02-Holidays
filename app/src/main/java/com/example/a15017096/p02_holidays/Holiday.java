package com.example.a15017096.p02_holidays;

/**
 * Created by 15017096 on 27/4/2017.
 */

public class Holiday {
    private String name;
    private String date;
    private String image;


    public Holiday(String name, String date, String image){
        this.name = name;
        this.date = date;
        this.image = image;
    }

    public String getName(){
        return name;
    }
    public String getDate(){
        return date;
    }
    public String getImage(){
        return image;
    }
}
