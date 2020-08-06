#!/usr/bin/env groovy

def call(cluster = "", numInstances = 1, envVars = []) {

    echo cluster
    echo numInstances
    echo envVars.NEW_RELIC_ENVIRONMENT

}