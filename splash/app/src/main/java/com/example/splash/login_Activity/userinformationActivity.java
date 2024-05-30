package com.example.splash.login_Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.splash.login_Activity.all_pojo_class.CountryData;
import com.example.splash.R;

public class userinformationActivity extends AppCompatActivity {
Spinner spin;
Button nexT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userinformation);
        spin=findViewById(R.id.spin);
nexT=findViewById(R.id.next);

        spin.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, CountryData.countryNames));
nexT.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent= new Intent(userinformationActivity.this, HomeActivity.class);
        startActivity(intent);
    }
});

    }
}
