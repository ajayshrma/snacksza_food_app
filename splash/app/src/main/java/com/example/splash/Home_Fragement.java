package com.example.splash;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

import com.example.splash.login_Activity.all_pojo_class.programAdapter2;
import com.example.splash.login_Activity.all_pojo_class.progrmmingAdapter;
import com.example.splash.login_Activity.all_pojo_class.user_second;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home_Fragement extends Fragment {
ViewFlipper flp;
ImageView imageView;
RecyclerView recyclerView;
    List<user_second> list = new ArrayList<>();
    RecyclerView.Adapter adapters;
    public Home_Fragement() {


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home__fragement, container, false);
        recyclerView = view.findViewById(R.id.recycler);
        flp = view.findViewById(R.id.flip);
         imageView=view.findViewById(R.id.sale);
         imageView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 demo_frag frag =new demo_frag();
                 getFragmentManager().beginTransaction().replace(R.id.fragmenthome,frag).commit();
             }
         });


        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, LinearLayout.HORIZONTAL));
         list.add(new user_second(R.drawable.fit1,"Valid till 31 jul 2019","save 120/-", ""));
        list.add(new user_second(R.drawable.hordisc1,"Valid till 31 jul 2019","Rs-250 onwards ", ""));
        list.add(new user_second(R.drawable.jeans,"Valid till 31 jul 2019","Rs-200 onwards ", ""));
        list.add(new user_second(R.drawable.fit1,"Valid till 31 jul 2019","Rs-200 onwards ", ""));
        adapters = new programAdapter2(list, getContext());
        recyclerView.setAdapter(adapters);



        int[] images={R.drawable.hortemp,R.drawable.hordisc1,R.drawable.hortemp2,};
        for(int image:images)
        {
            flipper(image);

        }




        return view;
    }
    public void flipper(int image){
        ImageView imageView=new ImageView(getContext());
        imageView.setBackgroundResource(image);
        flp.addView(imageView);
        flp.setFlipInterval(4800);
        flp.setAutoStart(true);
        flp.setInAnimation(getContext(),android.R.anim.slide_in_left);
        flp.setOutAnimation(getContext(),android.R.anim.slide_out_right);


    }

}