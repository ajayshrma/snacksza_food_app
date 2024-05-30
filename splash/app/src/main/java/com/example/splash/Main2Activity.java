package com.example.splash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.splash.login_Activity.HomeActivity;
import com.example.splash.login_Activity.LoginActivity;
import com.example.splash.login_Activity.all_pojo_class.progrmmingAdapter;
import com.example.splash.login_Activity.all_pojo_class.user;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<user>list;
    RecyclerView.Adapter adapter;
    Button button;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        recyclerView=findViewById(R.id.programmingList);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, LinearLayout.HORIZONTAL));
        list=new ArrayList<>();
        recyclerView.setHasFixedSize(true);
         list.add(new user(R.drawable.aj,""));
         list.add(new user(R.drawable.aj1,""));
        list.add(new user(R.drawable.aj2,""));
         adapter = new progrmmingAdapter(list,this);
         recyclerView.setAdapter(adapter);
         button=findViewById(R.id.btn1);
         button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent = new Intent(Main2Activity.this, LoginActivity.class);
                 startActivity(intent);
             }
         });

    }
}
