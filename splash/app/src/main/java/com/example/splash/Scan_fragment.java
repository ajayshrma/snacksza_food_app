package com.example.splash;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


/**
 * A simple {@link Fragment} subclass.
 */
public class Scan_fragment extends Fragment {
    private Button scan_btn;

    public Scan_fragment() {


        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_scan_fragment, container, false);
       scan_btn=view.findViewById(R.id.scan_btn);
       scan_btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               IntentIntegrator integrator=new IntentIntegrator(getActivity());
               integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
               integrator.setPrompt("Scan");
               integrator.setCameraId(0);
               integrator.setBarcodeImageEnabled(false);
               integrator.setBarcodeImageEnabled(false);
               integrator.initiateScan();
           }
       });
        return view;

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if(result.getContents() == null) {
                Toast.makeText(getActivity(), "you cancel the scan", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getActivity(), result.getContents(), Toast.LENGTH_SHORT).show();
            }
        }
        else {
            super.onActivityResult(requestCode, resultCode, data);

        }


    }

}
