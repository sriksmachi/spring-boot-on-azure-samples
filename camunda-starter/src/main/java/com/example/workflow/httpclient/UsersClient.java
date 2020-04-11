package com.example.workflow.httpclient;

import com.example.workflow.model.UserModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Component
@FeignClient(url = "https://springbootsample-users.azurewebsites.net/users/", name = "usersClient")
public interface UsersClient {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<UserModel> GetUsers();
}
