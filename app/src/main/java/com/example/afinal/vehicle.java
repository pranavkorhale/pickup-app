package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class vehicle extends AppCompatActivity {

    Button btnwith,btnwithout;


//here we give option driver or customer
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle);

        btnwith=findViewById(R.id.btnwith);
        btnwithout=findViewById(R.id.btnwithout);

        btnwith.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentwith = new Intent(vehicle.this,com.example.afinal.nextwith.class);
                startActivity(intentwith);
            }
        });

        btnwithout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentwithout=new Intent(vehicle.this,com.example.afinal.withoutvehicle.class);
                startActivity(intentwithout);

            }
        });


    }
}
