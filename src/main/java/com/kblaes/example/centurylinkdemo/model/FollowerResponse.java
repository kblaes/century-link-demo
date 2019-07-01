package com.kblaes.example.centurylinkdemo.model;

import java.util.List;

public class FollowerResponse {
    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    List<User> followers;
}
