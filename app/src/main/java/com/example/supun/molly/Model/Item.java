package com.example.supun.molly.Model;

/**
 * Created by supun on 27/06/17.
 */

public class Item {
    private boolean selected;
    private double price;
    private String description;

    public Item(double price, String description,boolean selected) {
        this.price = price;
        this.description = description;
        this.selected=selected;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
