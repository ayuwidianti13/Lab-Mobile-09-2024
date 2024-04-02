package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ImageView ivProfile = findViewById(R.id.iv_profile);
        TextView tvProfile = findViewById(R.id.Tv_profile);
        TextView tvAngkaFollowers = findViewById(R.id.Tv_followers);
        TextView tvAngkaFollowing = findViewById(R.id.Tv_following);
        ImageView ivPost = findViewById(R.id.iv_post);

        Intent intent = getIntent();

        Instagram instagram = intent.getParcelableExtra("instagram");

        ivProfile.setImageResource(instagram.getImageprofile());
        ivPost.setImageResource(instagram.getImagefeed());
        tvProfile.setText(instagram.getNama());
        tvAngkaFollowers.setText(String.valueOf(instagram.getFollowers()));
        tvAngkaFollowing.setText(String.valueOf(instagram.getFollowing()));

        ivPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, PostinganActivity.class);
                intent.putExtra("instagram",instagram);
                startActivity(intent);
            }
        });

        ivProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, StoryActivity.class);
                intent.putExtra("instagram", instagram);
                startActivity(intent);
            }
        });
    }
}
