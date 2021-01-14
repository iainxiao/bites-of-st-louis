package org.launchcode.bitesofstlouis.Models;

import javax.persistence.Entity;


public class Restaurants {

    private String name;
    private String address;
    private Integer price;
    private Integer rating;

    public Restaurants() {
    }

    public Restaurants(String aName, String anAddress, Integer aPrice, Integer aRating) {
       super();
       this.name = aName;
       this.address = anAddress;
       this.price = aPrice;
       this.rating = aRating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "name: " + name + " " +
                "address: " + address + " " +
                "price: " + price + " " +
                "rating: " + rating;
    }
}