Create cluster:

    kind create cluster --config=k8s/kind-config.yaml

install ingress nginx plugin
    
    kubectl apply -f https://raw.githubusercontent.com/kubernetes/ingress-nginx/main/deploy/static/provider/kind/deploy.yaml


Check nginx plugin status

    kubectl wait --namespace ingress-nginx \
        --for=condition=ready pod \
        --selector=app.kubernetes.io/component=controller \
        --timeout=90s

---

Apply database config

    kubectl apply -f k8s/db-config.yaml

Apply spring service config
    
    kubectl apply -f k8s/backend-config.yaml
---
Note:
Check db pod is ready

    kubectl exec -it cats-db-7fbbf98c9f-n26mg -- psql -h localhost -U admin --password -p 5432 catsdb

Call API
    
POST

    curl --location 'http://localhost:8888/cats-api/api/cats' \
    --header 'Content-Type: application/json' \
    --data '{
    "name": "Bradley Bashirian",
    "birthDay": "2000-01-01"
    }'

GET

    curl --location 'http://localhost:8888/cats-api/api/cats'