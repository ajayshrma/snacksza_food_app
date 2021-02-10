package com.ajayshrma.botomnavigation.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.arch.core.executor.TaskExecutor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.ajayshrma.botomnavigation.MainActivity;
import com.ajayshrma.botomnavigation.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.concurrent.TimeUnit;

public class OtpActivity extends AppCompatActivity {
    EditText usr_otp;
    Button verify_usr_otp;
    String verificationId;
    String mOtp;
    String ph_no;
     FirebaseAuth myAuth;
    FirebaseFirestore fstore;
    ProgressBar progressBar;
    public static final String TAG = "TAG";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);


        verify_usr_otp = findViewById(R.id.verify_otp);
        usr_otp = findViewById(R.id.phone_otp);

        //id of edit text where otp is insert
        usr_otp = findViewById(R.id.phone_otp);

        // id of button to verify otp
        verify_usr_otp = findViewById(R.id.verify_otp);

        myAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();


        progressBar = findViewById(R.id.progressBar);



        verify_usr_otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mOtp = usr_otp.getText().toString().trim();
//                ph_no = getIntent().getStringExtra("Number");
//                sendVerificationCode(ph_no);
//                progressBar.setVisibility(View.VISIBLE);
//                verifyCode(mOtp);
            }
        });


    }
//
//    private void sendVerificationCode(String ph_no) {
//
//    }
//
//    private void verifyCode(String code) {
//        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, code);
//
//        signInWithPhoneAuthCredential(credential);
//    }
//
//
//
//
//
//
//
//    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallBack = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
//
//
//        @Override
//        public void onVerificationCompleted(PhoneAuthCredential credential) {
//
//            String code = credential.getSmsCode();
//            progressBar.setVisibility(View.GONE);
//
//            signInWithPhoneAuthCredential(credential);
//        }
//
//        @Override
//        public void onVerificationFailed(FirebaseException e) {
//            Toast.makeText(OtpActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
//
//            progressBar.setVisibility(View.GONE);
//
//        }
//
//        @Override
//        public void onCodeSent(@NonNull String s,
//                @NonNull PhoneAuthProvider.ForceResendingToken token) {
//            verificationId = s;
//            progressBar.setVisibility(View.GONE);
//
//        }
//    };
//
//    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential)
//
//    {
//
//        myAuth.signInWithCredential(credential)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            Toast.makeText(OtpActivity.this, "Phone Verified." + myAuth.getCurrentUser().getUid(), Toast.LENGTH_SHORT).show();
//                            checkUserProfile();
//                        } else {
//                            Toast.makeText(OtpActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
//                            progressBar.setVisibility(View.GONE);
//                        }
//                        }
//                });
//
//    }
//
//
//    private void checkUserProfile() {
//        DocumentReference docRef = fstore.collection("users").document(myAuth.getCurrentUser().getUid());
//        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//            @Override
//            public void onSuccess(DocumentSnapshot documentSnapshot) {
//                if (documentSnapshot.exists()) {
//                    Intent intent = new Intent(OtpActivity.this,MainActivity.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                    startActivity(intent);
//                } else {
//                    //Toast.makeText(Register.this, "Profile Do not Exists.", Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(getApplicationContext(), UsrprofileActivity.class));
//                    finish();
//                }
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Toast.makeText(OtpActivity.this, "Profile Do Not Exists", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//
//        if(myAuth.getCurrentUser() != null) {
//            progressBar.setVisibility(View.VISIBLE);
//            checkUserProfile();
//        }
//    }

}


