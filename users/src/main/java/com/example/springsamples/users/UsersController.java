package com.example.springsamples.users;

import com.microsoft.applicationinsights.TelemetryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UsersController {

    private  UsersService usersService;

    @Autowired
    TelemetryClient client;

    public  UsersController(UsersService usersService)
    {
        this.usersService = usersService;
    }

    @GetMapping
    public ResponseEntity<List<UserModel>> getUsers()
    {
        Optional<List<UserModel>> users;
        users =  Optional.of(this.usersService.getAllUsers());
        return new ResponseEntity<List<UserModel>>(users.orElseGet(() -> null), HttpStatus.OK);
    }
}
