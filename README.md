#December20

## Build:
* Gradle build `gradlew clean build`

* Build docker image `docker build -f Dockerfile -t rohitanand650/demo .`

* Login and push docker image to [dockerhub](http://hub.docker.com), after you have created an account there and have a repository.
   
   `docker login` 
   `docker push rohitanand650/demo`

## Running docker 
* Command line
 `docker run -p 8083:8080 demo`

* Docker-compose

 `docker-compose up -d` // start, -d is for detached mode in background
 `docker-compose down` // stop 
 
## Deploying demo app to kubernetes

Deployment

     `cd kubernetes`
     `kubectl apply -f demo_deployment.yaml`

## Test API endpoint

* Endpoint `<host>:<port>/hello`
 
* Access pod without service - port forwarding 
    Refer [this](https://stackoverflow.com/questions/40767164/expose-port-in-minikube)
    
    Syntax: `kubectl port-forward POD_NAME HOST_PORT:POD_PORT`
    
    e.g. `kubectl port-forward demo-app-deployment-649565d868-h576h 8081:8080`

* Access service - NodePort

  Create service 
  `kubectl apply -f demo_service.yaml`

  `<minikube-ip>:nodePort`  doesn't work.
  Check [this](https://stackoverflow.com/questions/62375642/minikube-ip-returns-127-0-0-1-kubernetes-nodeport-service-not-accessable)     
  
  Run `minikube service demo-app-service --url`
  
  This will print the exposed host:port
  e.g. `http://127.0.0.1:50905`
  
  Try endpoint `http://127.0.0.1:50905/hello`
  

## Minikube 
    
* Start Minikube 
    `minikube start`

* Start Minikube dashboard
    `minikube dashboard`
    
  Running this will automatically open the dashboard URL in browser.
  URL would also be displayed on the command line terminal.
  
## Set minikube limits 

* Let's say we would like to set it to use 6 CPU and 8 GB memory
   
   `minikube config set cpus 6`
   
   `minikube config set memory 8192`
    
    To apply above config:
   
   `minikube delete`
   
   `minikube start`


* Minikube memory issues 
   
   Check [this](https://stackoverflow.com/questions/64995076/why-kubernete-pod-reports-insufficient-memory-even-if-there-are-free-memory-on) 

   And, also check [this](https://github.com/kubernetes/minikube/issues/8892)

## kubectl

* Get nodes 
    `kubectl get nodes`

* Get pods 
    
    `kubectl get pods`
    
   More details
    `kubectl get pods -o wide` 

* Get deployments 

    `kubectl get deployments`

* Get service 
    
    `kubectl get svc`

* Get everything 
    `kubectl get all`

* Delete pods/deployments/services

    `kubectl delete pods <pod_name>`
    
    `kubectl delete deployments <deployment_name>`
    
    `kubectl delete svc <svc_name>`
    
   Delete all pods 
    `kubectl delete --all pods`  


