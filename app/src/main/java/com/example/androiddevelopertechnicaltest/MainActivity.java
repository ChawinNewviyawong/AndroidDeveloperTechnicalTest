package com.example.androiddevelopertechnicaltest;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.androiddevelopertechnicaltest.model.User;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    SwipeRefreshLayout swipeRefreshLayout;
    ListView listView;
    ListUserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Github user");
        swipeRefreshLayout = findViewById(R.id.swipe_refresh);
        listView = findViewById(R.id.user_list);

        getUsers();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                TextView textView = view.findViewById(R.id.user_name);
                intent.putExtra("USERNAME", textView.getText().toString());
                startActivity(intent);
            }
        });

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // do something
                getUsers();
            }
        });
    }

    private void getUsers(){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String url = "https://api.github.com/users?since=0";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        User[] users = gson.fromJson(response, User[].class);

                        userAdapter = new ListUserAdapter(getApplicationContext(), users);
                        listView.setAdapter(userAdapter);
                        Log.i("GET getUsers", response);
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue.add(stringRequest);
    }
}
