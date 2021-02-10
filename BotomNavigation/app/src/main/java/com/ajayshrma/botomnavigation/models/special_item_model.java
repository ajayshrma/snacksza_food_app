package com.ajayshrma.botomnavigation.models;

public class special_item_model  {

    String item_name,Rate,template,Timing,foodpht;

    public special_item_model(String item_name, String rate, String template, String timing , String foodpht) {
        this.item_name = item_name;
        Rate = rate;
        this.template = template;
        Timing = timing;
        this.foodpht = foodpht;

    }

    public String getFoodpht() {
        return foodpht;
    }

    public void setFoodpht(String foodpht) {
        this.foodpht = foodpht;
    }

    public special_item_model() {
    }


    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getRate() {
        return Rate;
    }

    public void setRate(String rate) {
        Rate = rate;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getTiming() {
        return Timing;
    }

    public void setTiming(String timing) {
        Timing = timing;
    }
}
