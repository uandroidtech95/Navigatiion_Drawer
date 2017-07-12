package com.example.utsav.newlayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class OrvitoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orvito);
    }

    public void onControl(View view) {
        startActivity(new Intent(this, com.example.utsav.newlayout.CarActivity.class));
    }

    public void onView(View view) {
        startActivity(new Intent(this, com.example.utsav.newlayout.MapActivity.class));
    }
}
