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
                        createJiraTicket([summary: "Summary", description: "Description",
                                          team: "inventory-management", application: "stock-hold"]) {
                            echo "i am insid of create jira issu"
                        }
                    }
                }
            }

        }
    }
}
