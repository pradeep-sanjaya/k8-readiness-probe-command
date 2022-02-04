# Build jar
```
mvn clean compile package -DskipTests
```
# Build docker image
```
docker build -t k8-readiness-probe:1.0 .
```

# Deploy to k8
```
kubectl apply -f k8-readiness-command.yml

## get pods
kubectl get pods

## ssh into pod
kubectl exec -it k8-readiness-probe /bin/sh

## delete pod
kubectl delete pod k8-readiness-probe
```