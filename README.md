#December20

##Build:
Gradle build
    gradlew clean build
Docker Image build    
    docker build -f Dockerfile -t rohitanand650/demo .
Push Image 
    Docker login:
        docker login
    Docker Push:    
        docker push rohitanand650/demo

##Run:
Run a Docker image:
    docker run -p 8083:8080 demo

##Running by docker-compose
 docker-compose up -d // -d is for detached mode in background
 docker-compose down //To stop
 
##Deploy to kubernetes
     kubectl apply -f kubernetes\demoapp.yaml
     kubectl apply -f kubernetes\demoservice.yaml


##Test an API
 Curl command
     curl localhost:8083/hello
     
     
 
##Todo: 
* create dockerfile
* create documentation of steps
* logback
* create endpoint 
* add log statement
* k8s:// create document file inside this readme file
*     deployment yaml
*     service yaml
* ship log to elastic search/kibana 
* add a metric(to check no of calls/ response times/status codes/ failure rates )git 
* ship metric to prometheus/grafana
* docker compose postgres
* check any api queries
* add typesafe config
* db credentials read from config


