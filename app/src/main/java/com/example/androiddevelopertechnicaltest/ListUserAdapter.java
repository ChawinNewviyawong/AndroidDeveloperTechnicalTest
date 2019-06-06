package com.example.androiddevelopertechnicaltest;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.androiddevelopertechnicaltest.model.User;

import java.util.List;

public class ListUserAdapter extends BaseAdapter {

    Context mContext;
    User[] users;

    User user;

    public ListUserAdapter(Context mContext, User[] users) {
        this.mContext = mContext;
        this.users = users;
    }

    @Override
    public int getCount() {
        return users.length;
    }

    @Override
    public Object getItem(int position) {
        return users[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertView == null) convertView = layoutInflater.inflate(R.layout.listview_user, parent, false);

        user = users[position];

        ImageView imageView = convertView.findViewById(R.id.user_img);
        Glide.with(convertView).load(user.getUserImg()).centerCrop().into(imageView);

        TextView textView = convertView.findViewById(R.id.user_name);
        textView.setText(user.getUserName());

        Button button = convertView.findViewById(R.id.user_follow);

        return convertView;
    }
}
