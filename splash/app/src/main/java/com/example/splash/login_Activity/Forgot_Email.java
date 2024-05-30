package com.example.splash.login_Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.splash.MainActivity;
import com.example.splash.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Forgot_Email extends AppCompatActivity {
    EditText mail;
    Button forgotButton;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot__email);


        mail = findViewById(R.id.txtEmailForgot);
        forgotButton = findViewById(R.id.bbforgot);
        mAuth = FirebaseAuth.getInstance();

        forgotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mail.getText().toString();
                mAuth.getInstance().sendPasswordResetEmail(email)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {

                                    Toast.makeText(Forgot_Email.this, "Reset Passowrd Sent to Mail", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(Forgot_Email.this, MainActivity.class));

                                }
                            }
                        });
            }
        });

    }
}
