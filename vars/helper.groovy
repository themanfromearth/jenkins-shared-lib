#!/usr/bin/env groovy

def call(Map params) {

    echo params.cluster
    echo params.numInstances
    echo params.envVars.NEW_RELIC_ENVIRONMENT

}