# EFK - Elasticsearch, Fluentd, Kibana 

## Elasticsearch
* Elasticsearch deployment    
   
   `cd kubernetes`
   
   `kubectl create -f elasticsearch_deployment.yaml`
    
   Port forward 
    
   `kubectl port-forward <elasticsearch-pod-name> 9200:9200`

* Elasticsearch service
    
  `kubectl create -f elasticsearch_service.yaml`
  
   NodePort
   
  `minikube service elasticsearch --url`    



* Create namespace 
   
  You can create namespace and then use `-n <namespace>` while running deployments/services etc.

   `kubectl create namespace logging`
   
   
## Kibana 

* Run deployment and service     
    
    `kubectl apply -f kubernetes/kibana.yaml`
    
  NodePort
    
     `minikube service kibana --url`

## FluentD

* Configure RBAC 
    `kubectl apply -f kubernetes/fluentd_rbac.yaml`
    
* Run daemon    
    `kubectl apply -f kubernetes/fluentd_daemon.yaml `


## Reference 

[EFK logging](https://mherman.org/blog/logging-in-kubernetes-with-elasticsearch-Kibana-fluentd/)
