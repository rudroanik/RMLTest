package com.example.rmltest.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.rmltest.Http.ApiClient;
import com.example.rmltest.Http.ApiInterface;
import com.example.rmltest.Model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Anik Roy on 1/18/2021.
 */
public class HomeRepository {

    ApiInterface apiInterface;
    MutableLiveData<List<Post>> postList;

    public HomeRepository(Application application) {

        apiInterface = ApiClient.getBaseClient().create(ApiInterface.class);
        postList = new MutableLiveData<>();
    }

    public LiveData<List<Post>> getPosts() {
        Call<List<Post>> call = apiInterface.getPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.isSuccessful()) {
                    postList.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });

        return postList;
    }
}
