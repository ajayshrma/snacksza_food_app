package com.example.splash.login_Activity.all_pojo_class;

public class user {
int imageview;
String text;


    public user(int imageview, String texts){
    this.imageview=imageview;
    this.text=texts;

}


    public int getImageview() {
        return imageview;
    }

    public void setImageview(int imageview) {
        this.imageview = imageview;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
