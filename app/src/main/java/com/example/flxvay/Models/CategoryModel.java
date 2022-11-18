package com.example.flxvay.Models;

public class CategoryModel {

    int Category_image;
    String Category_Name;
    String Color;

    public CategoryModel(int category_image, String category_Name, String color) {
        Category_image = category_image;
        Category_Name = category_Name;
        Color = color;
    }

    public int getCategory_image() {
        return Category_image;
    }

    public void setCategory_image(int category_image) {
        Category_image = category_image;
    }

    public String getCategory_Name() {
        return Category_Name;
    }

    public void setCategory_Name(String category_Name) {
        Category_Name = category_Name;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }
}
