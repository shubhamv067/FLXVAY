package com.example.flxvay.Models;

public class CartModel {

    int Cart_Image;
    String Cart_Title;
    String Cart_Shop_Name;
    String Cart_Price;

    public CartModel(int cart_Image, String cart_Title, String cart_Shop_Name, String cart_Price) {
        Cart_Image = cart_Image;
        Cart_Title = cart_Title;
        Cart_Shop_Name = cart_Shop_Name;
        Cart_Price = cart_Price;
    }

    public int getCart_Image() {
        return Cart_Image;
    }

    public void setCart_Image(int cart_Image) {
        Cart_Image = cart_Image;
    }

    public String getCart_Title() {
        return Cart_Title;
    }

    public void setCart_Title(String cart_Title) {
        Cart_Title = cart_Title;
    }

    public String getCart_Shop_Name() {
        return Cart_Shop_Name;
    }

    public void setCart_Shop_Name(String cart_Shop_Name) {
        Cart_Shop_Name = cart_Shop_Name;
    }

    public String getCart_Price() {
        return Cart_Price;
    }

    public void setCart_Price(String cart_Price) {
        Cart_Price = cart_Price;
    }
}
