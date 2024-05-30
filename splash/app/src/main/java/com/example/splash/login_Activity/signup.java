package com.example.splash.login_Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.splash.MainActivity;
import com.example.splash.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class signup extends AppCompatActivity {
    Button signUp;
    private FirebaseAuth firebaseAuth;
    EditText Email,Password,PasswordAgain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Initialize Firebase Auth
        signUp = findViewById(R.id.bbSignUp);
        Email = findViewById(R.id.txtEmailSignUp);
        Password = findViewById(R.id.txtPasswordSignUp);
        PasswordAgain = findViewById(R.id.txtPasswordAgain);


        firebaseAuth = FirebaseAuth.getInstance();

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mailSign = Email.getText().toString();
                String passSign = Password.getText().toString();
                String passAgain = PasswordAgain.getText().toString();


                if(TextUtils.isEmpty(mailSign)){
                    Toast.makeText(signup.this, "Enter Proper Mail", Toast.LENGTH_SHORT).show();
                }
                if(TextUtils.isEmpty(passSign) || passSign.length() < 6){
                    Toast.makeText(signup.this, "Enter correct passowrd", Toast.LENGTH_SHORT).show();
                }

               /* if(passSign!=passAgain){
                    Toast.makeText(signup.this, "Passowrd Didn't Match", Toast.LENGTH_SHORT).show();
                }*/

                else{
                    firebaseAuth.createUserWithEmailAndPassword(mailSign,passSign)
                            .addOnCompleteListener(signup.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        //    Toast.makeText(signup.this, "SignUp", Toast.LENGTH_SHORT).show();
                                        //   startActivity(new Intent(signup.this,home.class));

                                        sendVerificationEmail();
                                    }else{
                                        //   Toast.makeText(signup.this, "Regester fail", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });





                }



            }
        });



    }

    private void sendVerificationEmail()
    {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        user.sendEmailVerification()
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            // email sent


                            // after email is sent just logout the user and finish this activity
                            FirebaseAuth.getInstance().signOut();
                            startActivity(new Intent(signup.this, LoginActivity.class));
                            finish();
                        }
                        else
                        {
                            // email not sent, so display message and restart the activity or do whatever you wish to do
                            Toast.makeText(signup.this, "Email not send", Toast.LENGTH_SHORT).show();
                            //restart this activity
                            overridePendingTransition(0, 0);
                            finish();
                            overridePendingTransition(0, 0);
                            startActivity(getIntent());

                        }
                    }
                });

    }
}

