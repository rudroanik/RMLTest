package com.example.rmltest.View.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rmltest.R;

public class LandingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if (getUser().equals("N/A") || getUser().equals(null)) {
                    Intent intent = new Intent(LandingActivity.this, LoginActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();

                } else {
                    Intent intent = new Intent(LandingActivity.this, HomeActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                }
            }
        }, 2000);
    }

    public String getUser() {
        SharedPreferences sharedPref = getSharedPreferences("login", Context.MODE_PRIVATE);
        return sharedPref.getString("userName", "N/A");
    }
}