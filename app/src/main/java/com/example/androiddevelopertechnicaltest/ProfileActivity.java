package com.example.androiddevelopertechnicaltest;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.androiddevelopertechnicaltest.model.User;
import com.google.gson.Gson;

public class ProfileActivity extends AppCompatActivity {

    ImageView profileImg;
    TextView profileName;
    TextView profileLogin;
    TextView profileFollower;
    TextView profileFollowing;
    TextView profileBio;
    TextView profileLocation;
    TextView profileUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        Intent intent = getIntent();
        String username = intent.getStringExtra("USERNAME");
        setTitle(username);
        profileImg = findViewById(R.id.user_img);
        profileName = findViewById(R.id.user_name);
        profileLogin = findViewById(R.id.user_login);
        profileFollower = findViewById(R.id.num_follower);
        profileFollowing = findViewById(R.id.num_following);
        profileBio = findViewById(R.id.bio_detail);
        profileLocation = findViewById(R.id.location_detail);
        profileUrl = findViewById(R.id.url_detail);

        getProfile(username);

    }

    private void getProfile(String username) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String url = "https://api.github.com/users/" + username;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        User user = gson.fromJson(response, User.class);

                        Glide.with(getApplicationContext()).load(user.getUserImg()).centerCrop().into(profileImg);
                        profileName.setText(user.getName());
                        profileLogin.setText("@" + user.getUserName());
                        profileFollower.setText(user.getNumFollowers());
                        profileFollowing.setText(user.getNumFollowing());
                        profileBio.setText(user.getBio());
                        profileLocation.setText(user.getLocation());
                        profileUrl.setText(user.getUrl());
                        Log.i("GET getUsers", response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue.add(stringRequest);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
