#!/usr/bin/env groovy

def callback() {
    echo "hello you"
}

def call() {
    pipeline {
        agent any

        stages {
            stage('Test') {
                steps {
                    script {
                        echo "Testing..."
                        createJiraTicket(summary: "test me", callback)
                        echo "Done"
                    }
                }
            }

        }
    }
}
