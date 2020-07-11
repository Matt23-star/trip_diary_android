package com.example.map;

public class Team {
    private String name;
    private int imageid;

    public Team(String name , int imageid)
    {
        this.name = name;
        this.imageid = imageid;
    }
    public String getName()
    {
        return name;
    }
    public int getImageid()
    {
        return imageid;
    }

}