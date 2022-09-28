# remote-statefun-demo
A minimal deployment demo of Flink Stateful Functions on AWS Lambda as remote functions

## How to use

In `remote` directory, follow https://github.com/apache/flink-statefun-playground/tree/main/deployments/aws-lambda, upload the jar file to aws, and set the AWS Lambda endpoint


In `local` directory, edit the AWS Lambda endpoint in `module.yaml`, and

```
docker-compose down
docker-compose build
docker-compose up -d statefun-worker
```

and you can ingest stream into remote Lambda stateful functions by

```
docker-compose exec kafka kafka-console-producer --broker-list kafka:9092 --topic query --property parse.key=true --property key.separator=:
>5:{"query_id":"5", "user_id": "1", "content": "go remote statefun!"}
```
