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

    @Autowired
    private AmazonSNSClient snsClient;

    String TOPIC_ARN="arn:aws:sns:us-east-1:365609404781:my-first-topic" ;

    @GetMapping("/sendNotification")
    public String publishMessageToTopic(){
        PublishRequest publishRequest=new PublishRequest(TOPIC_ARN,buildEmailBody(),"Notification: Network connectivity issue");
        snsClient.publish(publishRequest);
        return "Notification send successfully !!";
    }

    private String buildEmailBody(){
        return "Dear Employee ,\n" +
                "\n" +
                "\n" +
                "Connection down Bangalore."+"\n"+
                "All the servers in Bangalore Data center are not accessible. We are working on it ! \n" +
                "Notification will be sent out as soon as the issue is resolved. For any questions regarding this message please feel free to contact IT Service Support team";
    }
}
