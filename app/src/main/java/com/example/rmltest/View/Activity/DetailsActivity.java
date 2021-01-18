package com.example.rmltest.View.Activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.rmltest.Model.Post;
import com.example.rmltest.R;
import com.example.rmltest.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {

    Post post;
    ActivityDetailsBinding binding;

    @SuppressLint({"WrongConstant", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details);
        if (getIntent().getExtras() != null) {

            post = getIntent().getExtras().getParcelable("postDetails");
            binding.userId.setText("Post id: " + post.getId());
            binding.title.setText(String.format("Post Title: %s", post.getTitle()));
            binding.description.setText(String.format("Description: %s", post.getBody()));

        }

        binding.logout.setOnClickListener(v -> {
            logout();
            startActivity(new Intent(DetailsActivity.this,LoginActivity.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));
            finish();
        });

    }

    public void logout(){
        SharedPreferences sharedPref = getSharedPreferences("login", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.remove("userName");
        editor.apply();
    }
}