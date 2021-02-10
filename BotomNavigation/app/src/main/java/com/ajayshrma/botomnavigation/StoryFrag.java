package com.ajayshrma.botomnavigation;

import android.app.ActionBar;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.ajayshrma.botomnavigation.adapter.special_item_adapter;
import com.ajayshrma.botomnavigation.adapter.subscription_adapter;
import com.ajayshrma.botomnavigation.adapter.ytadapter;
import com.ajayshrma.botomnavigation.fragments.DescFragment;
import com.ajayshrma.botomnavigation.fragments.todaymenufrag;
import com.ajayshrma.botomnavigation.models.Subscription_Model;
import com.ajayshrma.botomnavigation.models.special_item_model;
import com.ajayshrma.botomnavigation.models.ytmodel;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.interfaces.ItemClickListener;
import com.denzcoskun.imageslider.models.SlideModel;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.squareup.picasso.Picasso;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;


public class StoryFrag extends Fragment {
Toolbar toolbar;
ImageSlider mainslider;
ImageButton imageButton,offersbtn,discountbtn,menubtn,combobtn;
TextView textView;
DatabaseReference mspecial_item_database;
Button special_item_rate,special_item_rate2;
ImageView image_template,image_template2;
RecyclerView special_recycler;
    DatabaseReference databaseReference;
    special_item_adapter special_adapter;
    ProgressBar progressBar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {





        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.story_frag, container, false);
        mainslider=view.findViewById(R.id.image_slider);
        toolbar=view.findViewById(R.id.toolbar);
        combobtn=view.findViewById(R.id.combo_id);

        offersbtn=view.findViewById(R.id.offers_id);
        discountbtn=view.findViewById(R.id.discountbox_id);
        menubtn=view.findViewById(R.id.dailymenu_id);
        special_item_rate=view.findViewById(R.id.special_item_rate_id);
        image_template=view.findViewById(R.id.templateid);
        progressBar = view.findViewById(R.id.spin_kit);

        CheckInternet();

        menubtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment todaymenufrag = new todaymenufrag();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.storyfragment,new todaymenufrag()).addToBackStack(null).commit();

            }
        });
//
//        YouTubePlayerView youTubePlayerView =view.findViewById(R.id.youtube_player_view);
//        getLifecycle().addObserver(youTubePlayerView);
//
//        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
//            @Override
//            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
//                String videoId = "4OBLAW7oQYo";
//                youTubePlayer.loadVideo(videoId, 0);
//            }
//        });



        special_recycler = view.findViewById(R.id.specialrecycler);
        special_recycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        FirebaseRecyclerOptions<special_item_model> options =
                new FirebaseRecyclerOptions.Builder<special_item_model>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("special_item"), special_item_model.class)
                        .build();


        special_adapter=new special_item_adapter(options);
        special_recycler.setAdapter(special_adapter);
        progressBar.setVisibility(View.GONE);
        special_recycler.setVisibility(View.VISIBLE);









        final List<SlideModel>remoteimages=new ArrayList<>();

        FirebaseDatabase.getInstance().getReference().child("slider")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for(DataSnapshot data: dataSnapshot.getChildren())
                            remoteimages.add(new SlideModel(data.child("url").getValue().toString(),data.child("title").getValue().toString(), ScaleTypes.FIT));

                            mainslider.setImageList(remoteimages,ScaleTypes.FIT);


                            mainslider.setItemClickListener(new ItemClickListener() {
                                @Override
                                public void onItemSelected(int i) {
                                    Toast.makeText(getContext(),remoteimages.get(i).getTitle().toString(), Toast.LENGTH_SHORT).show();
                                }
                            });
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

        return view;
    }

    private void CheckInternet() {
//        boolean internet = isInternetAvailable();
//        if(internet){
//
//            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//            builder.setMessage("Please check internet!!");
//            builder.setCancelable(false);
//            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialogInterface, int i) {
//                    getActivity().finish();
//                    System.exit(0);
//                }
//
//
//            });
//            builder.setNegativeButton("Retry", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialogInterface, int i) {
//                    CheckInternet();
//                }
//            });
//
//            AlertDialog dialog = builder.create();
//            dialog.show();
//
//        }

    }
//
//    private boolean isInternetAvailable() {
//        try {
//            InetAddress ipAddr = InetAddress.getByName("google.com");
//            //You can replace it with your name
//            return !ipAddr.equals("");
//
//        } catch (Exception e) {
//            return false;
//        }
//    }


    @Override
    public void onStart() {
        super.onStart();
        special_adapter.startListening();
    }



    @Override
    public void onStop() {
        super.onStop();
        special_adapter.stopListening();
    }

    @Override
    public void onResume() {
        super.onResume();
        CheckInternet();

    }
}