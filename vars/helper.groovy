#!/usr/bin/env groovy

def call(Map params) {

    echo params.cluster
    echo params.envVars
    echo params.numInstances

}