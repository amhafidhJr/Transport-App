package com.example.transportbooking.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("fullname")
    @Expose
    private String fullname = "";

    @SerializedName("address")
    @Expose
    private String address = "";

    @SerializedName("email")
    @Expose
    private String email = "";

    @SerializedName("phoneNo")
    @Expose
    private String phoneNo = "";

    @SerializedName("seats")
    @Expose
    private String seats = "";

    public User() {
    }




    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public String getFullname() {
        return fullname;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddress() {
        return address;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }


    public User(String fullname, String address, String email,  String phoneNo, String seats) {
        this.fullname = fullname;
        this.address = address;
        this.email = email;
        this.phoneNo = phoneNo;
        this.seats = seats;

    }

}
