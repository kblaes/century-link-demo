package com.kblaes.example.centurylinkdemo.service;

import com.kblaes.example.centurylinkdemo.model.FollowerResponse;
import com.kblaes.example.centurylinkdemo.model.User;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class GitFollowerService {
    String apiRoot = "https://api.github.com";

   public List<User> getFollowers(String login) {
       List<User> followers =  getFollowersFromGithub(login);
       for (User user:followers) {
           user.setFollowers(getFollowersFromGithub(user.getLogin()));
           for (User nestedUser: user.getFollowers()) {
               nestedUser.setFollowers(getFollowersFromGithub(nestedUser.getLogin()));
           }
       }
       return followers;
    }



    public List<User> getFollowersFromGithub(String login){
        List<User> followers = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<User>> response = restTemplate.exchange(
                apiRoot + "/users/" + login + "/followers",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<User>>() {
                }
        );
        if (response.getBody().size() < 5) {
            followers = response.getBody();
        } else {
            followers = response.getBody().subList(0, 4);
        }

        return followers;
    }

}
