package com.example.rmltest.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.rmltest.Model.Post;
import com.example.rmltest.Repository.HomeRepository;

import java.util.List;

/**
 * Created by Anik Roy on 1/18/2021.
 */
public class HomeViewModel extends AndroidViewModel {

    private HomeRepository homeRepository;

    public HomeViewModel(@NonNull Application application) {
        super(application);
        homeRepository = new HomeRepository(application);
    }

    public LiveData<List<Post>> getPosts(){

        return homeRepository.getPosts();
    }
}
