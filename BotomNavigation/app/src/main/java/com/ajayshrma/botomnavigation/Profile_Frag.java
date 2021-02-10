package com.ajayshrma.botomnavigation;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.ajayshrma.botomnavigation.activity.LoginActivity;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Profile_Frag extends Fragment {

    ImageButton backtofragbtn;
    public static final String TAG = "TAG";
    FirebaseAuth firebaseAuth;
    FirebaseFirestore fStore;
    String mname, mphone;
    TextView name, phoneno;
    Button logout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile_, container, false);
//
//        backtofragbtn=view.findViewById(R.id.backarrowbtn);
//
//        name =view.findViewById(R.id.setnameid);
//        phoneno =view.findViewById(R.id.setphonenoid);
//        logout =view.findViewById(R.id.logout);
//
//        firebaseAuth = FirebaseAuth.getInstance();
//        fStore = FirebaseFirestore.getInstance();
//
//
//        backtofragbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                onBackPressed();
//            }
//        });
//
//
//        DocumentReference docRef = fStore.collection("users").document(firebaseAuth.getCurrentUser().getUid());
//        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//            @Override
//            public void onSuccess(DocumentSnapshot documentSnapshot) {
//                if (documentSnapshot.exists()) {
//                    mname = documentSnapshot.getString("first");
//                    mphone = firebaseAuth.getCurrentUser().getPhoneNumber();
//
//                    name.setText(mname);
//                    phoneno.setText(mphone);
//                } else {
//                    Log.d(TAG, "Retrieving Data: Profile Data Not Found ");
//                }
//            }
//        });
//
//        logout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                FirebaseAuth.getInstance().signOut();
//                Intent intent = new Intent(getActivity(), LoginActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                startActivity(intent);
//            }
//        });
        return view;


    }

//    public void onBackPressed()
//    {
//        AppCompatActivity activity=(AppCompatActivity)getContext();
//        activity.getSupportFragmentManager().beginTransaction()
//                .replace(R.id.fragment_container,new HomeFrag()).commit();
//
//    }
}