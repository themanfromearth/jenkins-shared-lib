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
                        createJiraTicket([summary: "Summary", description: "Description",
                                 team: "inventory-management", application: "stock-hold"]) {
                            echo "i am insid of create jira issu"
                        }
                        echo "Done"
                    }
                }
            }

        }
    }
}
