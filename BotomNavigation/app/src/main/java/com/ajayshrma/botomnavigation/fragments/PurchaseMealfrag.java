package com.ajayshrma.botomnavigation.fragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.ajayshrma.botomnavigation.HomeFrag;
import com.ajayshrma.botomnavigation.R;
import com.bumptech.glide.Glide;


public class PurchaseMealfrag extends Fragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PurchaseMealfrag() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static PurchaseMealfrag newInstance(String param1, String param2) {
        PurchaseMealfrag fragment = new PurchaseMealfrag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_purchase_mealfrag, container, false);
        ImageButton backtofragbtn=view.findViewById(R.id.backarrowbtn);
        ImageView imageView = view.findViewById(R.id.paymentgif);
        Glide.with(this)
                .load(R.drawable.paymentpng)
                .into(imageView);


        backtofragbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        return view;


    }

    public void onBackPressed()
    {
        AppCompatActivity activity=(AppCompatActivity)getContext();
        activity.getSupportFragmentManager().beginTransaction()
                .replace(R.id.purchasefragid,new DeliveryAddressfrag()).addToBackStack(null).commit();

    }

}