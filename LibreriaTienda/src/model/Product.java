package model;

import java.io.Serializable;

public class Product implements Serializable {

    private String name, URLimage, description;
    private int ID;
    private double prize;

    public Product(String name, int ID, String URLimage, String description, double prize) {
        this.name = name;
        this.URLimage = URLimage;
        this.description = description;
        this.ID = ID;
        this.prize = prize;
    }

    public double getPrize() {
        return prize;
    }

    public String getName() {
        return name;
    }

    public String getURLimage() {
        return URLimage;
    }

    public String getDescription() {
        return description;
    }

    public int getID() {
        return ID;
    }

}
