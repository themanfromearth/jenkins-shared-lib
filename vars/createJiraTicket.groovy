#!/usr/bin/env groovy


class RcvGlobals {
    static Map defaults = [application: null, description: "", project: 'TM']
}

def call(Map config) {
    def merged = RcvGlobals.defaults + config
    withEnv(['JIRA_SITE=JIRA']) {
        def issue = [fields: [project    : [key: merged.project],
                              summary    : merged.summary,
                              description: merged.description,
                              labels     : [merged.team, getApplication(merged.application)],
                              issuetype  : [id: '3'],
        ]]
        response = jiraNewIssue issue: issue
        return response.data.key.toString()
    }
}

def getApplication(def application) {
    if (application == null) {
        try {
            def tokens = env.JOB_NAME.tokenize("/") as String[]
            return tokens[0]
        } catch (Throwable ignored) {
            print("Unable to parse application from job name: ${env.JOB_NAME}.\n" +
                    "Please manually pass in the application name as a parameter\n" +
                    "Defaulting application name to \"unknown\" in jira ticket")

            return "unknown"
        }
    } else {
        return application
    }
}