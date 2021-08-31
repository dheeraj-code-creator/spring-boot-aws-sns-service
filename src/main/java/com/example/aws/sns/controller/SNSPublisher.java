package com.example.aws.sns.controller;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SNSPublisher {

    String TOPIC_ARN = "arn:aws:sns:us-east-1:365609404781:my-first-topic";
    @Autowired
    private AmazonSNSClient amazonSNSClient;

    @GetMapping("/sendNotification")
    public String publishMessageToTopic() {
        PublishRequest publishRequest = new PublishRequest(TOPIC_ARN, buildEmailBody(), "Deployment successfull");
        amazonSNSClient.publish(publishRequest);
        return "Notification send Successfully";
    }

    private String buildEmailBody() {
        return "Dear Developers: You have succesfully deployed your project";
    }
}
