package com.ajayshrma.botomnavigation;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.ajayshrma.botomnavigation.adapter.subscription_adapter;
import com.ajayshrma.botomnavigation.fragments.FoodTiming;
import com.ajayshrma.botomnavigation.fragments.Specialitem_Detailfrag;
import com.ajayshrma.botomnavigation.fragments.todaymenufrag;
import com.ajayshrma.botomnavigation.models.Subscription_Model;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.net.InetAddress;

import static android.content.Context.CONNECTIVITY_SERVICE;


public class HomeFrag extends Fragment {
    subscription_adapter adapter;
    Button btn;
    CardView myorderclk;
    RecyclerView recyclerView;
    ProgressBar progressBar;
    TextView textView,textView2day;
    ShimmerFrameLayout layout;
    DatabaseReference databaseReference;
    TextView custom_order_id;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

       View view= inflater.inflate(R.layout.fragment_home, container, false);

        // Check for Internet Connection
        if (isConnected()) {
            Toast.makeText(getActivity(), "Internet Connected", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "No Internet Connection", Toast.LENGTH_SHORT).show();
        }
    
       
       
       myorderclk=view.findViewById(R.id.myorderclick);

        textView2day=view.findViewById(R.id.twoday);
        progressBar = view.findViewById(R.id.spin_kit);

        textView=view.findViewById(R.id.pluss);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment todaymenufrag = new todaymenufrag();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.homefragment,new todaymenufrag()).addToBackStack(null).commit();

            }
        });



        myorderclk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Order_TabLayout.class);
                startActivity(intent);
            }
        });



        custom_order_id=view.findViewById(R.id.customorderid);
        custom_order_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment FoodTiming = new FoodTiming();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.homefragment,new FoodTiming()).addToBackStack(null).commit();

            }
        });


        recyclerView = view.findViewById(R.id.rclview);
          recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));


        FirebaseRecyclerOptions<Subscription_Model> options =
                new FirebaseRecyclerOptions.Builder<Subscription_Model>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Subscription"), Subscription_Model.class)
                        .build();


        adapter=new subscription_adapter(options);
        recyclerView.setAdapter(adapter);







return view;

    }


    private boolean isConnected() {
        boolean connected = false;
        try {
            ConnectivityManager cm = (ConnectivityManager)getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo nInfo = cm.getActiveNetworkInfo();
            connected = nInfo != null && nInfo.isAvailable() && nInfo.isConnected();
            return connected;
        } catch (Exception e) {
            Log.e("Connectivity Exception", e.getMessage());
        }
        return connected;
    }



    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
        recyclerView.setVisibility(View.VISIBLE);


    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onResume() {
        super.onResume();

    }


        }
