package com.example.rmltest.Http;

import com.example.rmltest.Model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("posts")
    Call<List<Post>> getPosts();

}
