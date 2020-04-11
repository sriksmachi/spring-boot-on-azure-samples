package com.example.workflow.httpclient;

import com.example.workflow.model.OrderModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(url = "https://springbootsample-orders.azurewebsites.net/orders/", name = "ordersClient")
@Component
public interface OrdersClient {

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String createOrder(OrderModel orderModel);
}
