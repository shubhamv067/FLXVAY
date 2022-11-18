package com.example.flxvay.Models;

public class HorizontalScrollProductModel {

    int ProductImage;
    String ProductPrice;
    String ProductTitle;

    public HorizontalScrollProductModel(int productImage, String productPrice, String productTitle) {
        ProductImage = productImage;
        ProductPrice = productPrice;
        ProductTitle = productTitle;
    }

    public int getProductImage() {
        return ProductImage;
    }

    public void setProductImage(int productImage) {
        ProductImage = productImage;
    }

    public String getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(String productPrice) {
        ProductPrice = productPrice;
    }

    public String getProductTitle() {
        return ProductTitle;
    }

    public void setProductTitle(String productTitle) {
        ProductTitle = productTitle;
    }
}
