package com.example.splash;

public class profile_add_pojo {
  String id;
  String  shop_Name;
  String cost;
  String address;
  String Number;
  String Shop_Detail;
  String timing;
  String offer_period;
  String payment_option;
  String discount_on;

  public profile_add_pojo(String id,String shop_Detail,String shop_Name,String cost,String address,String Number,String timing,String offer_period,String payment_option,String discount_on){
      this.id=id;
      this.shop_Name=shop_Name;
      this.cost=cost;
      this.address=address;
      this.Number=Number;
      this.Shop_Detail=shop_Detail;
      this.timing=timing;
      this.offer_period=offer_period;
      this.payment_option=payment_option;
      this.discount_on=discount_on;
  }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShop_Name() {
        return shop_Name;
    }

    public void setShop_Name(String shop_Name) {
        this.shop_Name = shop_Name;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getShop_Detail() {
        return Shop_Detail;
    }

    public void setShop_Detail(String shop_Detail) {
        Shop_Detail = shop_Detail;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public String getOffer_period() {
        return offer_period;
    }

    public void setOffer_period(String offer_period) {
        this.offer_period = offer_period;
    }

    public String getPayment_option() {
        return payment_option;
    }

    public void setPayment_option(String payment_option) {
        this.payment_option = payment_option;
    }

    public String getDiscount_on() {
        return discount_on;
    }

    public void setDiscount_on(String discount_on) {
        this.discount_on = discount_on;
    }
}
