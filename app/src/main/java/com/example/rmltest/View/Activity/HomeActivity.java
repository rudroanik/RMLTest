package com.example.rmltest.View.Activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.rmltest.Model.Post;
import com.example.rmltest.R;
import com.example.rmltest.View.Adapter.PostAdapter;
import com.example.rmltest.ViewModel.HomeViewModel;
import com.example.rmltest.databinding.ActivityHomeBinding;

import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;
    private HomeViewModel homeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        homeViewModel = new ViewModelProvider(HomeActivity.this).get(HomeViewModel.class);
        binding.progressBar.setVisibility(View.VISIBLE);

        loadPostData();
    }

    private void loadPostData() {

        homeViewModel.getPosts().observe(this, postList -> {
            if (postList.size() > 0) {
                binding.progressBar.setVisibility(View.GONE);
                binding.rvPost.setVisibility(View.VISIBLE);
                initAdapter(postList);
            }
        });
    }


    private void initAdapter(List<Post> postList) {
        PostAdapter adapter = new PostAdapter(postList, this);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.rvPost.setLayoutManager(mLayoutManager);
        binding.rvPost.setAdapter(adapter);

    }
}