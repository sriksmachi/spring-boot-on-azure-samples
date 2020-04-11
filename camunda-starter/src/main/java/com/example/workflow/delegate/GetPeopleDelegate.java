package com.example.workflow.delegate;

import com.example.workflow.httpclient.UsersClient;
import com.example.workflow.model.UserModel;
import com.example.workflow.rest.OrderController;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component("getPeopleDelegate")
public class GetPeopleDelegate implements JavaDelegate {

    Logger logger = LoggerFactory.getLogger(GetPeopleDelegate.class);

    @Autowired
    private UsersClient usersClient;

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        List<UserModel> users = usersClient.GetUsers();

        // get first user - mocking authentication context
        String user = users.get(0).getAlias();
        execution.setVariable("assignee", user);
    }
}
