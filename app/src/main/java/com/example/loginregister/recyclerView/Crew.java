package com.example.loginregister.recyclerView;
//Guest recyclerview
public class Crew {
    String name;
    String category;

    String paymentStatus;



    public Crew(String name, String category, String paymentStatus) {
        this.name = name;
        this.category = category;
        this.paymentStatus = paymentStatus;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }




}