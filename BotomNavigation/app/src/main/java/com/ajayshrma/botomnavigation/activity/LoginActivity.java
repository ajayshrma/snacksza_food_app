package com.ajayshrma.botomnavigation.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.ajayshrma.botomnavigation.HomeFrag;
import com.ajayshrma.botomnavigation.MainActivity;
import com.ajayshrma.botomnavigation.R;
import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;


public class LoginActivity extends AppCompatActivity {
    EditText phoneNO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        phoneNO = findViewById(R.id.usr_no);
        Button phoneAuth_btn = findViewById(R.id.send_otp);
//
//        ImageView imageView = findViewById(R.id.loginimage);
//        Glide.with(this)
//                .load(R.drawable.logingif)
//                .into(imageView);
//
//
        phoneAuth_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
//                String number = phoneNO.getText().toString().trim();
//
//                if (TextUtils.isEmpty(number) || number.length() < 10 || number.length() > 10) {
//                    phoneNO.setError("Valid Number Required");
//                    phoneNO.requestFocus();
//                } else {
//                    String PhoneNo = "+" + "91" + number;
//
//                    Intent i = new Intent(LoginActivity.this, OtpActivity.class);
//                    i.putExtra("Number", PhoneNo);
//                    startActivity(i);
//                }
            }
        });

    }

//    @Override
//    public void onStart() {
//        super.onStart();
//        // Check if user is signed in (non-null) and update UI accordingly.
//        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
//            Intent intent = new Intent(this, MainActivity.class);
//            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//
//            startActivity(intent);
//        }
//
//    }


}