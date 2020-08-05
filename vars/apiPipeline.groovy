#!/usr/bin/env groovy

def callback() {
    echo "hello you"
}

def call(Map pipelineParams) {
    pipeline {
        agent any

        stages {
            stage('Test') {
                steps {
                    script {
                        echo pipelineParams.param
                        echo "Testing..."
                        createJiraTicket(summary: "test me", callback)
                        echo "Done"
                    }
                }
            }

        }
    }
}
