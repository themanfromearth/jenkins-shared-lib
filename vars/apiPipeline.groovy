#!/usr/bin/env groovy

def call(Map pipelineParams) {
    pipeline {
        agent any

        stages {
            stage('Test') {
                steps {
                    script {

                        for (deployment in pipelineParams.deployments["dev"]) {

                            def testIssue = [fields: [ project: [key: 'TM'],
                                                       summary: 'New JIRA Created from Jenkins.',
                                                       description: 'New JIRA Created from Jenkins.',
                                                       issuetype: [name: 'Task']]]

                            jiraNewIssue issue: testIssue, site: 'JIRA T'

                            echo response.successful.toString()
                            echo response.data.toString()


//                            def additionalEnvVars = deployment.envVars ?: []
//                            def initialEnvVars = [
//                                    CLUSTER               : "cluster",
//                                    SPRING_PROFILES_ACTIVE: "springProfileActive",
//                                    ENVIRONMENT           : "environment",
//                                    APPLICATION_NAME      : "appName",
//                                    SERVICE_NAME          : "serviceName",
//                                    NEW_RELIC_ENVIRONMENT : "environment"
//                            ]
//                            def envVars = initialEnvVars + additionalEnvVars
//                            helper("dev", 2, envVars)
                        }
                    }
                }
            }

        }
    }
}
