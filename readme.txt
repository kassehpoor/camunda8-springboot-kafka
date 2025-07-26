to run project in root folder:

docker-compose up --build -d

docker pull openjdk:21-jdk-slim

docker ps -a

docker-compose logs kafka
docker-compose logs operate

-------------------------------------------------------------------------------
🌐 Local URLs for Services

Service	                Description	                  URL
Zookeeper               Manages Kafka brokers	          localhost:2181
Kafka	                Message broker	                  localhost:9092
Kafka UI                                                  localhost:8089
Zeebe	                Workflow engine	                  localhost:26500
Operate	                Zeebe workflow monitoring UI	  http://localhost:8081
Tasklist                Zeebe human task UI	          http://localhost:8082
Discovery Server	Microservice registry	          http://localhost:8761
Gateway Server	        Entry point for microservices     http://localhost:8080
Workflow Orchestrator	Manages workflow logic	          http://localhost:8085
Email Service	        Handles email logic	          http://localhost:8092
Payment Service	        Handles payment transactions      http://localhost:8093