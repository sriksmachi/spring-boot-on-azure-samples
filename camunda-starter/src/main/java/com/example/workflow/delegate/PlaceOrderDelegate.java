package com.example.workflow.delegate;

import com.example.workflow.httpclient.OrdersClient;
import com.example.workflow.model.OrderModel;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component("placeOrderDelegate")
public class PlaceOrderDelegate implements JavaDelegate {

    @Autowired
    RuntimeService runtimeService;

    @Autowired
    OrdersClient ordersClient;

    Logger logger = LoggerFactory.getLogger(PlaceOrderDelegate.class);

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        String restaurant = (String)execution.getVariable("restaurant");
        String order = (String)execution.getVariable("orderDescription");
        String address = (String)execution.getVariable("address");
        String assignee = (String)execution.getVariable("assignee");
        OrderModel orderModel = new OrderModel();

        orderModel.setAddress(address);
        orderModel.setAlias(assignee);
        orderModel.setRestaurant(restaurant);
        orderModel.setOrderDescription(order);
        orderModel.setOrder_date(java.time.LocalDate.now().toString());

        ordersClient.createOrder(orderModel);

        logger.info("Place Order Delegate Called with: " + restaurant
                + " order " + order
                + " address " + address
        );
    }
}
