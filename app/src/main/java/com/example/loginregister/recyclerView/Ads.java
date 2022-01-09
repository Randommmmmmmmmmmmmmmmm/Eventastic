package com.example.loginregister.recyclerView;

//Ads recyclerview
public class Ads {
    String aname;
    String acategory;
    String astatus;



    public Ads(String aname, String acategory, String astatus) {
        this.aname = aname;
        this.acategory = acategory;
        this.astatus = astatus;

    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getAcategory() {
        return acategory;
    }

    public void setAcategory(String acategory) {
        this.acategory = acategory;
    }

    public String getAstatus() {
        return astatus;
    }

    public void setAstatus(String astatus) {
        this.astatus = astatus;
    }


}
