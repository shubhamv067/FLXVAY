package com.example.flxvay.Models;

public class AddressModel {
    String Address;
    private Boolean selected;


    public AddressModel(String address, Boolean selected) {
        Address = address;
        this.selected = selected;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }
}
