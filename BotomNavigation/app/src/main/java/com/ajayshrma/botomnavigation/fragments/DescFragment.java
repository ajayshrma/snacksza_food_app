package com.ajayshrma.botomnavigation.fragments;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.ajayshrma.botomnavigation.HomeFrag;
import com.ajayshrma.botomnavigation.R;


public class DescFragment extends Fragment {

    Button continue_to_addres;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    public String Title,Rate,Validity,Tiffins;

    TextView textViewtitle,textViewvalidity,textViewrate,textViewtiffins;
    ImageButton backtofragbtn;

    public DescFragment() {
        // Required empty public constructor
    }




    public DescFragment(String title, String rate, String validity, String tiffins) {
       this.Title = title;
       this.Rate = rate;
       this.Validity=validity;
       this.Tiffins=tiffins;
    }


    public static DescFragment newInstance(String param1, String param2) {
        DescFragment fragment = new DescFragment();
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
       View view =  inflater.inflate(R.layout.fragment_desc, container, false);

       continue_to_addres=view.findViewById(R.id.continue_to_addres);

       continue_to_addres.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               Fragment DeliveryAddressfrag = new DeliveryAddressfrag();
               getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.descriptionfrag,new DeliveryAddressfrag()).addToBackStack(null).commit();

           }
       });

        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

       backtofragbtn=view.findViewById(R.id.backarrowbtn);


       textViewtitle=view.findViewById(R.id.setid_title);
        textViewrate=view.findViewById(R.id.setid_rate);
        textViewtiffins=view.findViewById(R.id.setid_tiffins);
        textViewvalidity=view.findViewById(R.id.setid_validity);



        textViewtitle.setText(Title);
        textViewrate.setText(Rate);
        textViewtiffins.setText(Tiffins);
        textViewvalidity.setText(Validity);

        return view;


    }

}