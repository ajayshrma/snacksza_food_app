package com.ajayshrma.botomnavigation.models;

import android.content.res.ColorStateList;

public class Subscription_Model
{

    String Title,Desc,Rate,Validity,Tiffins,Viewdetail;



    public Subscription_Model(String title, String desc, String rate , String validity, String tiffins, String viewdetail)
    {
        Title = title;
        Desc = desc;
        Rate = rate;
        Validity = validity;
        Tiffins = tiffins;
        Viewdetail = viewdetail;
    }

    public Subscription_Model()
    {

    }



    public String getViewdetail() {
        return Viewdetail;
    }

    public void setViewdetail(String viewdetail) {
        Viewdetail = viewdetail;
    }

    public String getValidity() {
        return Validity;
    }

    public void setValidity(String validity) {
        Validity = validity;
    }


    public String getTiffins() {
        return Tiffins;
    }

    public void setTiffins(String tiffins) {
        Tiffins = tiffins;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDesc() {
    return Desc;
}

    public void setDesc(String desc) {
        Desc = desc;
    }

    public String getRate() {
        return Rate;
    }

    public void setRate(String rate) {
        Rate = rate;
    }
}
