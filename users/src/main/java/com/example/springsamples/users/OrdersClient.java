package com.example.springsamples.users;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@FeignClient(name="orders", url="https://springbootsample-orders.azurewebsites.net")
@Component
public interface OrdersClient {

    @RequestMapping(method = RequestMethod.GET, value = "/orders?id={id}", consumes = "application/json")
    public Optional<List<UserOrdersModel>> getUserOrders(@RequestParam("id") String id);
}
