#!/usr/bin/env groovy

def call(cluster = "", numInstances = 1, envVars = []) {


    print("${cluster} - ${numInstances} - ${envVars.NEW_RELIC_ENVIRONMENT}")

}