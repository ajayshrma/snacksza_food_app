package com.ajayshrma.botomnavigation.models;

public class todaymenu_model {

    String Ddesc,Dimage,Ldesc,Limage;

    public todaymenu_model(String ddesc, String dimage, String ldesc, String limage) {
        Ddesc = ddesc;
        Dimage = dimage;
        Ldesc = ldesc;
        Limage = limage;
    }

    public todaymenu_model()
    {

    }

    public String getDdesc() {
        return Ddesc;
    }

    public void setDdesc(String ddesc) {
        Ddesc = ddesc;
    }

    public String getDimage() {
        return Dimage;
    }

    public void setDimage(String dimage) {
        Dimage = dimage;
    }

    public String getLdesc() {
        return Ldesc;
    }

    public void setLdesc(String ldesc) {
        Ldesc = ldesc;
    }

    public String getLimage() {
        return Limage;
    }

    public void setLimage(String limage) {
        Limage = limage;
    }
}
