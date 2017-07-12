package com.example.utsav.newlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class CarActivity extends AppCompatActivity {
    private static final String TAG = "CarActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);
        try {

        }catch (Exception e){
            Log.e(TAG,e.getMessage());
        }
    }
}
