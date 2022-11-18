package com.example.flxvay.Models;

public class MyOrderModel {
    int Order_Image;
    String Order_Title;
    String Order_Shop_Name;
    String Order_Price;

    public MyOrderModel(int order_Image, String order_Title, String order_Shop_Name, String order_Price) {
        Order_Image = order_Image;
        Order_Title = order_Title;
        Order_Shop_Name = order_Shop_Name;
        Order_Price = order_Price;
    }

    public int getOrder_Image() {
        return Order_Image;
    }

    public void setOrder_Image(int order_Image) {
        Order_Image = order_Image;
    }

    public String getOrder_Title() {
        return Order_Title;
    }

    public void setOrder_Title(String order_Title) {
        Order_Title = order_Title;
    }

    public String getOrder_Shop_Name() {
        return Order_Shop_Name;
    }

    public void setOrder_Shop_Name(String order_Shop_Name) {
        Order_Shop_Name = order_Shop_Name;
    }

    public String getOrder_Price() {
        return Order_Price;
    }

    public void setOrder_Price(String order_Price) {
        Order_Price = order_Price;
    }
}
