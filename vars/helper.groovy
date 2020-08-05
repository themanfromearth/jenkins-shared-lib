#!/usr/bin/env groovy

def call(cluster, numInstances, Map envVars) {

    echo cluster
    echo numInstances
    echo envVars.NEW_RELIC_ENVIRONMENT

}