package com.example.springsamples.users;

import com.microsoft.applicationinsights.TelemetryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UsersController {

    Logger logger = LoggerFactory.getLogger(UsersController.class);

    private  UsersService usersService;

    @Autowired
    private  OrdersClient ordersClient;

    @Autowired
    TelemetryClient client;

    public  UsersController(UsersService usersService, OrdersClient ordersClient)
    {
        this.usersService = usersService;
        this.ordersClient = ordersClient;
    }

    @GetMapping("/")
    public ResponseEntity<List<UserModel>> getUsers()
    {
        Optional<List<UserModel>> users;
        users =  Optional.of(this.usersService.getAllUsers());

        logger.debug("Received users: " + users.get().size() + "from database");
        return new ResponseEntity<List<UserModel>>(users.orElseGet(() -> null), HttpStatus.OK);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<UserOrdersModel>> getUserOrders(@RequestParam(name="id") String id)
    {
        Optional<List<UserOrdersModel>> userOrders = ordersClient.getUserOrders(id);
        userOrders.ifPresent(userOrdersModels -> logger.debug("Received user orders: " + userOrdersModels.size() + "from orders service"));
        return new ResponseEntity<List<UserOrdersModel>>(userOrders.orElseGet(() -> null), HttpStatus.OK);
    }

}
