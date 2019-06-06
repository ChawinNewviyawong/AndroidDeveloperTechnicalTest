package com.example.androiddevelopertechnicaltest.model;

import android.net.Uri;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("avatar_url")
    String userImg;
    @SerializedName("name")
    String name;
    @SerializedName("login")
    String userName;
    @SerializedName("followers")
    String numFollowers;
    @SerializedName("following")
    String numFollowing;
    @SerializedName("bio")
    String bio;
    @SerializedName("location")
    String location;
    @SerializedName("url")
    String url;
    String userFollow;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumFollowers() {
        return numFollowers;
    }

    public void setNumFollowers(String numFollowers) {
        this.numFollowers = numFollowers;
    }

    public String getNumFollowing() {
        return numFollowing;
    }

    public void setNumFollowing(String numFollowing) {
        this.numFollowing = numFollowing;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserFollow() {
        return userFollow;
    }

    public void setUserFollow(String userFollow) {
        this.userFollow = userFollow;
    }
}
