package com.example.splash.login_Activity.all_pojo_class;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.splash.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class programAdapter2 extends RecyclerView.Adapter<programAdapter2.programViewHolder>{


    List<user_second> data;
    Context context;

    public programAdapter2( List<user_second> data ,Context context){

        this.context = context;
        this.data =data;

    }

    @NonNull
    @Override
    public programViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.demo, parent, false);
        return new programViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull programViewHolder holder, int position) {
              user_second user_seconds = data.get(position);
              holder.textView0.setText(user_seconds.getText0());
              holder.textView1.setText(user_seconds.getText1());

         Picasso.get().load(user_seconds.getImageviews()).into(holder.imageViews);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class programViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViews;
        TextView textView0,textView1,textView2;
        public programViewHolder(@NonNull View itemView) {
            super(itemView);
            textView0=itemView.findViewById(R.id.valid_txt);
            textView1=itemView.findViewById(R.id.price_txt);
            imageViews = itemView.findViewById(R.id.imageDemo);
           // textView2=itemView.findViewById(R.id.discount_btn);
        }
    }

    public static class Profile_add {
        public String id;
        public String shop_Name;
        public String cost;
        public String address;
        public String Number;
        public String Shop_Detail;
        public String timing;
        public String offer_period;

        public Profile_add(String id,String shop_Name,String cost,String address,String Shop_Detail,String Number,String timing,String offer_period) {
            this.id=id;
             this.shop_Name=shop_Name;
             this.cost=cost;
            this.address=address;
            this.Number=Number;
            this.Shop_Detail=Shop_Detail;
            this.timing=timing;
            this.offer_period=offer_period;

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

        public String payment_option;
        public String discount_on;

    }
}
