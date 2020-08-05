#!/usr/bin/env groovy

def call(Map pipelineParams) {
    pipeline {
        agent any

        stages {
            stage('Test') {
                steps {
                    script {
                        echo pipelineParams.param
                        echo "Testing..."
                        createJiraTicket(summary: "test me")
                        echo "Done"
                    }
                }
            }

        }
    }
}
