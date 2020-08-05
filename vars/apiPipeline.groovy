#!/usr/bin/env groovy

def call(Map pipelineParams) {
    pipeline {
        agent any

        stages {
            stage('Test') {
                steps {
                    script {
                        echo pipelineParams.param
                        echo pipelineParams.param2
                        createJiraTicket(summary: "test me") {
                            echo "i am insid of create jira issu"
                        }
                    }
                }
            }

        }
    }
}
