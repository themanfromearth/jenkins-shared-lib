#!/usr/bin/env groovy

def call() {
    pipeline {
        stages {
            stage('Test') {
                steps {
                    script {

                        echo "Testing"
                        createJiraTicket summary: "test me"
                    }
                }
            }

        }
    }
}
