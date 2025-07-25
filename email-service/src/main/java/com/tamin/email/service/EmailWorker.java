package com.tamin.email.service;


import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import org.springframework.stereotype.Component;
import io.camunda.zeebe.spring.client.annotation.ZeebeWorker;

@Component
public class EmailWorker {

    @ZeebeWorker(type = "send-email")
    public void handleJob(final ActivatedJob job, final JobClient client) {
        String recipient = job.getVariablesAsMap().get("recipient").toString();
        String subject = job.getVariablesAsMap().get("subject").toString();
        String body = job.getVariablesAsMap().get("body").toString();

        System.out.println("📨 ارسال ایمیل به: " + recipient);
        System.out.println("موضوع: " + subject);
        System.out.println("متن: " + body);

        client.newCompleteCommand(job.getKey())
                .variables("{\"status\":\"email-sent\"}")
                .send()
                .join();
    }
}
