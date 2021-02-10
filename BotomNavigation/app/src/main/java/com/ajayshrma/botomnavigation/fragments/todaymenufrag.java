package com.ajayshrma.botomnavigation.fragments;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ajayshrma.botomnavigation.HomeFrag;
import com.ajayshrma.botomnavigation.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;


public class todaymenufrag extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";




    private String mParam1;
    private String mParam2;

    ImageButton backtofragbtn;
    ImageView dimage,Limage;
    TextView dinnerdesc,lunchdesc;
    private DatabaseReference mDatabase;


    public todaymenufrag() {
        // Required empty public constructor
    }


    public static todaymenufrag newInstance(String param1, String param2) {
        todaymenufrag fragment = new todaymenufrag();
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
      View view= inflater.inflate(R.layout.fragment_todaymenufrag, container, false);

        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

      dinnerdesc=view.findViewById(R.id.dinermenu);
      lunchdesc=view.findViewById(R.id.lunchmenu);
      dimage = view.findViewById(R.id.dinnerimage);
      Limage=view.findViewById(R.id.lunchimage);

      backtofragbtn=view.findViewById(R.id.backarrowbtn);



// ...
        mDatabase = FirebaseDatabase.getInstance().getReference().child("todaymenu");

        mDatabase.child("Dinner")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String menu = snapshot.child("Ddesc").getValue(String.class);

                        dinnerdesc.setText(menu);

                      String imgurl = snapshot.child("Dimage").getValue(String.class);

                        Picasso.get()
                               .load(imgurl)
                               .fit()
                               .into(dimage);

                    }


                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


mDatabase.child("Lunch")
        .addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String menu1 =snapshot.child("Ldesc").getValue(String.class);
                lunchdesc.setText(menu1);

                String imgurl1 = snapshot.child("Limage").getValue(String.class);

                Picasso.get()
                        .load(imgurl1)
                        .fit()
                        .into(Limage);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



      return view;
    }

}