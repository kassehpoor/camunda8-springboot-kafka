package com.tamin.Workflow.Orchestrator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
این سرویس فایل‌هایbpmn. رو به Zeebe broker deploy می‌کنه.
for example, the email-service doesn't need to include BPMN files, since it simply waits to receive and handle tasks from Zeebe — it does not start workflow processes itself.
 */
@SpringBootApplication
public class WorkflowOrchestratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkflowOrchestratorApplication.class, args);
	}

}
