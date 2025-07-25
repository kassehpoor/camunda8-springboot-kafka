package com.tamin.Workflow.Orchestrator;

// اینجا با شنود پیام های کافکا میاد فرآیندهای بی پی ام ان رو از طریق زی بی جی آر پی سی به جریان میاندازه

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.camunda.zeebe.client.ZeebeClient;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class KafkaEventListener {

    private final ZeebeClient zeebeClient;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public KafkaEventListener(ZeebeClient zeebeClient) {
        this.zeebeClient = zeebeClient;
    }

    @KafkaListener(topics = "order-events", groupId = "camunda-consumer")
    public void onMessage(String message) throws Exception {
        JsonNode json = objectMapper.readTree(message);
        String orderId = json.path("orderId").asText();
        String customerId = json.path("customerId").asText();

        zeebeClient.newCreateInstanceCommand()
                .bpmnProcessId("process-payments")
                .latestVersion()
                .variables(Map.of(
                        "orderId", orderId,
                        "customerId", customerId
                ))
                .send()
                .join();

        System.out.println("🚀 Process started for orderId=" + orderId);
    }
}
