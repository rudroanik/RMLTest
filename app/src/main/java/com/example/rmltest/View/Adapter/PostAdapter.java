package com.example.rmltest.View.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rmltest.Model.Post;
import com.example.rmltest.R;
import com.example.rmltest.View.Activity.DetailsActivity;
import com.example.rmltest.databinding.ItemPostBinding;

import java.util.List;

/**
 * Created by Anik Roy on 1/18/2021.
 */
public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    private final List<Post> posts;
    private final Context context;

    public PostAdapter(List<Post> posts, Context context) {
        this.posts = posts;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPostBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_post, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post post = posts.get(position);

        holder.postBinding.id.setText(String.valueOf(post.getId()));
        holder.postBinding.title.setText(post.getTitle());
        holder.postBinding.description.setText(post.getBody());

        holder.itemView.setOnClickListener(v -> {
            context.startActivity(new Intent(context, DetailsActivity.class).putExtra("postDetails",post));
        });
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ItemPostBinding postBinding;

        public ViewHolder(ItemPostBinding postBinding) {
            super(postBinding.getRoot());
            this.postBinding = postBinding;
        }
    }
}
