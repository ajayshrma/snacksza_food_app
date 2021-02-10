package com.ajayshrma.botomnavigation.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.ajayshrma.botomnavigation.MainActivity;
import com.ajayshrma.botomnavigation.R;
import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class UsrprofileActivity extends AppCompatActivity {
    EditText usr_name,usr_whatsno;
    public static final String TAG = "TAG";
    String userID;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore fstore;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usrprofile);


        ImageView imageView = findViewById(R.id.usrpic);
        Glide.with(this)
                .load(R.drawable.accgif)
                .into(imageView);



        button = findViewById(R.id.udr);
        usr_name=findViewById(R.id.usr_nameid);
        usr_whatsno=findViewById(R.id.usr_phone_noid);


        fstore = FirebaseFirestore.getInstance();
        firebaseAuth = firebaseAuth.getInstance();
        userID=firebaseAuth.getCurrentUser().getUid();




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                DocumentReference docRef = fstore.collection("users").document(userID);
//                Map<String,Object> user = new HashMap<>();
//                user.put("first",usr_name.getText().toString());
//                user.put("last",usr_whatsno.getText().toString());
//
//                docRef.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
//                    @Override
//                    public void onSuccess(Void aVoid) {
//                        Log.d(TAG, "onSuccess: User Profile Created." + userID);
//                        Toast.makeText(UsrprofileActivity.this, "Account created", Toast.LENGTH_SHORT).show();
//                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
//                        finish();
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Log.d(TAG, "onFailure: Failed to Create User " + e.toString());
//                    }
//                });
//
//
//
//            }

            }
        });


    }
}