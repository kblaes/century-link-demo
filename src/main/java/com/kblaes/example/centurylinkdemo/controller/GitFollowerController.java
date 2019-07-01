package com.kblaes.example.centurylinkdemo.controller;

import com.kblaes.example.centurylinkdemo.model.User;
import com.kblaes.example.centurylinkdemo.service.GitFollowerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GitFollowerController {
    GitFollowerService service = new GitFollowerService();

    @RequestMapping(path="/followers", method= RequestMethod.GET)
    List<User> getFollowers(@RequestParam(value="userId") String userId){
       return service.getFollowers(userId);
    }
}
