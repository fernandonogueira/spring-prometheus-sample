#!/usr/bin/env bash

mvn package

docker build -t spring-prometheus-sample .
docker tag spring-prometheus-sample fernandonogueira/spring-prometheus-sample:0.3

docker push fernandonogueira/spring-prometheus-sample:0.3
