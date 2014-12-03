 package entities;

import discount.Discount;
import discount.Discountable;
import java.io.Serializable;
import java.util.Date;
import java.util.Random;

public class Product implements Serializable, Discountable{

    private String name, URLimage, description;
    private int ID;
    private final double pricePerUnit;
    private double price;
    private Discount discount;
    private Date date;

    public Date getDate() {
        return date;
    }

    public Product(String name, int ID, String URLimage, String description, double pricePerUnit) {
        this.name = name;
        this.URLimage = URLimage;
        this.description = description;
        this.ID = ID;
        this.pricePerUnit = pricePerUnit;
        this.date = setDate();
        this.price = pricePerUnit;
    }
    
    public double getPricePerUnit () {
        return this.pricePerUnit;
    }
    
    public void setPrice (Double price) {
        this.price = price;
    }
    
    @Override
    public Discount getDiscount() {
        return this.discount;
    }
    
    @Override
    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
    
    public double getPrice() {
        return price;
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

    private Date setDate() {
        Random r = new Random();
        return new Date(2014, r.nextInt((12 - 1) + 1) + 1, r.nextInt((28 - 1) + 1) + 1);
    }

}
