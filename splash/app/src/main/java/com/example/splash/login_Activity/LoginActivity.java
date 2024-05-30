package com.example.splash.login_Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.splash.Main2Activity;
import com.example.splash.MainActivity;
import com.example.splash.R;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.Login;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;

public class LoginActivity extends AppCompatActivity {
    TextView signupActivity;
    EditText emailLogin,passowrdLogin;
    Button login,loginButton,fb_btn,login_button;
    TextView forgotPassowrd;
    private FirebaseAuth mAuth;
    CallbackManager callbackManager;
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser!=null){
            Intent i = new Intent(LoginActivity.this,userinformationActivity.class);
            startActivity(i);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginButton=findViewById(R.id.login_button);
        //Id find out
        emailLogin = findViewById(R.id.txtEmail);
        passowrdLogin = findViewById(R.id.txtPassword);
        signupActivity = findViewById(R.id.bbSignUp);
        login = findViewById(R.id.bLogin);
        forgotPassowrd = findViewById(R.id.forgotPassword);
        mAuth = FirebaseAuth.getInstance();
         fb_btn=findViewById(R.id.fb_btn);
         fb_btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 login_button.performClick();
             }
         });
        login_button=findViewById(R.id.login_button);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        callbackManager = CallbackManager.Factory.create();
        //Set Click Listner on Signup Button
        signupActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this,signup.class);
                startActivity(i);
            }
        });


        //Set Click Listner on Signup Button
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mailLogin = emailLogin.getText().toString();
                String password = passowrdLogin.getText().toString();

                if(TextUtils.isEmpty(mailLogin)){
                    Toast.makeText(LoginActivity.this, "Enter Email", Toast.LENGTH_SHORT).show();
                }
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(LoginActivity.this, "Enter Password", Toast.LENGTH_SHORT).show();
                }
                else{

                    //Sign in Process
                    mAuth.signInWithEmailAndPassword(mailLogin, password)
                            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (!task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        //   startActivity(new Intent(MainActivity.this,home.class));
                                        Toast.makeText(LoginActivity.this, "Galat h", Toast.LENGTH_SHORT).show();
                                    } else {
                                        checkIfEmailVerified();
                                        // If sign in fails, display a message to the user.
                                        // Toast.makeText(MainActivity.this, "Check Password Or Email", Toast.LENGTH_SHORT).show();
                                    }

                                    // ...
                                }
                            });

                }
            }
        });

        forgotPassowrd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,Forgot_Email.class));
            }
        });



    }

    private void checkIfEmailVerified() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if (user.isEmailVerified()) {
            // user is verified, so you can finish this activity or send user to activity which you want.
            finish();
            startActivity(new Intent(LoginActivity.this, userinformationActivity.class));
            Toast.makeText(LoginActivity.this, "Successfully logged in", Toast.LENGTH_SHORT).show();
        } else {
            // email is not verified, so just prompt the message to the user and restart this activity.
            // NOTE: don't forget to log out the user.
            FirebaseAuth.getInstance().signOut();
            Toast.makeText(this, "Verify", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(LoginActivity.this, userinformationActivity.class));
            //restart this activity

        }


        callbackManager = CallbackManager.Factory.create();

        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        // App code
                        startActivity(new Intent(LoginActivity.this,userinformationActivity.class));
                        Toast.makeText(LoginActivity.this, "Hogya", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancel() {
                        // App code
                        Toast.makeText(LoginActivity.this, "Cancle kr dia", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        // App code
                        Toast.makeText(LoginActivity.this, exception.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    }






