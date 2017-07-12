package com.example.utsav.newlayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class DanceActivity extends AppCompatActivity {
    private static final String TAG = "DanceActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dance);
//        android.app.ActionBar actionBar=getActionBar();
//        actionBar.setTitle("Buy Ticket");
//
//        actionBar.show();


    }

    public void onBuy(View view) {
        startActivity(new Intent(this,OrvitoActivity.class));
    }
}
