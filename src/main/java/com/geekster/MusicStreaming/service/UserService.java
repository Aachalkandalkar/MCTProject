package com.geekster.MusicStreaming.service;

import com.geekster.MusicStreaming.models.User;
import com.geekster.MusicStreaming.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    IUserRepo iUserRepo;


    public User getUserByUsername(String username) {
        return iUserRepo.findByUsername(username);
    }
}
