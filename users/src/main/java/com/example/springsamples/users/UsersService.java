package com.example.springsamples.users;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UsersService {
    List<UserModel> getAllUsers();
}
