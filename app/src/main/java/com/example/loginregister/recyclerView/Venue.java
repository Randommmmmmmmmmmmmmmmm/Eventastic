package com.example.loginregister.recyclerView;

//Venue recyclerview
public class Venue {
    String vname;
    String vlocation;
    String vpayment;



    public Venue(String vname, String vlocation, String vpayment) {
        this.vname = vname;
        this.vlocation = vlocation;
        this.vpayment = vpayment;

    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public String getVlocation() {
        return vlocation;
    }

    public void setVlocation(String vlocation) {
        this.vlocation = vlocation;
    }

    public String getVpayment() {
        return vpayment;
    }

    public void setVpayment(String vpayment) {
        this.vpayment = vpayment;
    }


}
