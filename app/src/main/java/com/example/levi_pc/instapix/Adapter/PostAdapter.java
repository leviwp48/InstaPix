package com.example.levi_pc.instapix.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.levi_pc.instapix.Model.PostModel;
import com.example.levi_pc.instapix.Post;
import com.example.levi_pc.instapix.R;
import com.parse.GetDataCallback;
import com.parse.ParseException;
import com.parse.ParseFile;

import org.w3c.dom.Text;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    private Context context;
    private List<Post> posts;

    public PostAdapter(Context context, List<Post> posts) {
        this.context = context;
        this.posts = posts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_post, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Post post = posts.get(i);
        viewHolder.bind(post);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        private List<Post> mPosts;
        ImageView ivProfilePic;
        TextView tvHandle;
        TextView tvDescription;
        ImageButton ibOptions;
        ImageView ivPostPic;
        ImageButton ibLike;

         public ViewHolder(View itemView) {
            super(itemView);
            tvHandle = itemView.findViewById(R.id.tvHandle);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            ivPostPic = itemView.findViewById(R.id.ivPostPic);
            ivProfilePic = itemView.findViewById(R.id.ivProfilePic);
         }
         public void bind(Post post) {
             // TODO: bind the view elements to the post
             tvHandle.setText(post.getUser().getUsername());
             ParseFile image = post.getImage();
             if (image != null) {
                 Glide.with(context).load(image.getUrl()).into(ivPostPic);
             }
             tvDescription.setText(post.getDescription());
         }
    }
}
