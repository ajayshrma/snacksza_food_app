package com.ajayshrma.botomnavigation.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ajayshrma.botomnavigation.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;


public class FoodTiming extends Fragment {

    TextView Dinner_time,Lunch_time,Breakfast_time;
    TextView Dtitle,Ltitle,Btitle;
    private DatabaseReference mDatabase;
    public FoodTiming() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_food_timing, container, false);

        Dtitle=view.findViewById(R.id.DinnerTimingid);
        Ltitle=view.findViewById(R.id.lunchtimingid);
        Btitle=view.findViewById(R.id.breakfastTimingid);

        Dinner_time=view.findViewById(R.id.Dtimeid);
        Lunch_time=view.findViewById(R.id.Ltimeid);
        Breakfast_time=view.findViewById(R.id.Btimeid);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("fooddeliverytiming");

        mDatabase.child("evening")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String title =snapshot.child("title").getValue(String.class);

                        Dtitle.setText(title);

                        String time = snapshot.child("timing").getValue(String.class);

                        Dinner_time.setText(time);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });



        mDatabase.child("afternoon")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String title =snapshot.child("title").getValue(String.class);

                        Ltitle.setText(title);

                        String time = snapshot.child("timing").getValue(String.class);

                        Lunch_time.setText(time);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });



        mDatabase.child("morning")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String title =snapshot.child("title").getValue(String.class);

                        Btitle.setText(title);

                        String time = snapshot.child("timing").getValue(String.class);

                        Breakfast_time.setText(time);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Log.d("warning", "oncancelled");

                    }
                });


        return view;





    }


}