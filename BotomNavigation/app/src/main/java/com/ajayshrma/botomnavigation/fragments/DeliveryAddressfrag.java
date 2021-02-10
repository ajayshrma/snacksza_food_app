package com.ajayshrma.botomnavigation.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.ajayshrma.botomnavigation.R;
import com.ajayshrma.botomnavigation.adapter.deliveryadapter;
import com.ajayshrma.botomnavigation.models.deliverymodel;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;


public class DeliveryAddressfrag extends Fragment {

    deliveryadapter adapter;
    RecyclerView recyclerView;
   // ShimmerFrameLayout mShimmerViewContainer;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DeliveryAddressfrag() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static DeliveryAddressfrag newInstance(String param1, String param2) {
        DeliveryAddressfrag fragment = new DeliveryAddressfrag();
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
       View view=inflater.inflate(R.layout.fragment_delivery_addressfrag, container, false);

       // mShimmerViewContainer =view.findViewById(R.id.shimmer_view_container);


        recyclerView=view.findViewById(R.id.rcv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        FirebaseRecyclerOptions<deliverymodel> options =
                new FirebaseRecyclerOptions.Builder<deliverymodel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Deliveryarea"),deliverymodel.class)
                        .build();


        adapter=new deliveryadapter(options);
        recyclerView.setAdapter(adapter);


       return view;
    }
    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();



    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }


    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {

        inflater.inflate(R.menu.serachmenu,menu);
        MenuItem item = menu.findItem(R.id.search);

        SearchView searchView = (SearchView)item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s)
            {
                processsearch(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s)
            {
                processsearch(s);
                return false;
            }
        });

         super.onCreateOptionsMenu(menu,inflater);
    }

    private void processsearch(String s)
    {

        FirebaseRecyclerOptions<deliverymodel> options =
                new FirebaseRecyclerOptions.Builder<deliverymodel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Deliveryarea").orderByChild("add").startAt(s).endAt(s +"\uf8ff"),deliverymodel.class)
                        .build();

        adapter=new deliveryadapter(options);
        adapter.startListening();
        recyclerView.setAdapter(adapter);

    }


}