package com.ajayshrma.botomnavigation.fragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ajayshrma.botomnavigation.HomeFrag;
import com.ajayshrma.botomnavigation.R;
import com.ajayshrma.botomnavigation.StoryFrag;
import com.bumptech.glide.Glide;

import org.w3c.dom.Text;


public class Specialitem_Detailfrag extends Fragment {

    Button continue_to_addres;
    ImageView foodphtid;
    TextView item_nameid,item_timing,item_rate;


    public String item_name,Rate,template,Timing,foodpht;

    public Specialitem_Detailfrag() {
        // Required empty public constructor
    }

    public Specialitem_Detailfrag(String item_name, String foodpht, String rate, String timing) {
        this.item_name=item_name;
        this.foodpht=foodpht;
        this.Rate=rate;
        this.Timing=timing;
    }


       @Override
       public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view =  inflater.inflate(R.layout.fragment_specialitem__detailfrag, container, false);
       item_nameid=view.findViewById(R.id.itemrateid);
       item_rate=view.findViewById(R.id.itemrateid);
       foodphtid=view.findViewById(R.id.foodphtid);
       item_timing=view.findViewById(R.id.timing_item_id);

       item_nameid.setText(item_name);
       item_rate.setText(Rate);
       item_timing.setText(Timing);

       Glide.with(getContext()).load(foodpht).into(foodphtid);

       return view;

    }

}
