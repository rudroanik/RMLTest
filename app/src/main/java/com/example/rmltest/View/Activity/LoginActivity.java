package com.example.rmltest.View.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.rmltest.R;
import com.example.rmltest.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        onClick();
    }

    private void onClick() {
        binding.loginBtn.setOnClickListener(v -> {
            validation();
        });
    }

    private void validation() {
        if (TextUtils.isEmpty(binding.signInPhoneEmilEt.getText())) {
            binding.signInPhoneEmilEt.setError("Enter user name");
            binding.signInPhoneEmilEt.requestFocus();
        } else if (TextUtils.isEmpty(binding.signInPasswordEt.getText())) {
            binding.signInPasswordEt.setError("Enter password");
            binding.signInPasswordEt.requestFocus();
        } else {
            String USERNAME = "Anik";
            String PASSWORD = "1234";
            if (binding.signInPhoneEmilEt.getText().toString().equalsIgnoreCase(USERNAME) && binding.signInPasswordEt.getText().toString().equalsIgnoreCase(PASSWORD)) {
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                saveLoginInfo(USERNAME);
                finish();
            }else {
                Toast.makeText(this,"Incorrect User name or password",Toast.LENGTH_SHORT).show();
            }
        }
    }


    public void saveLoginInfo(String username) {
        SharedPreferences sharedPref = getSharedPreferences("login", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("userName", username);
        editor.apply();
    }


}