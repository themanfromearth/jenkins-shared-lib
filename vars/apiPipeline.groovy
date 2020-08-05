def call() {
    pipeline {
        stages {
            stage('Test') {
                steps {
                    script {
                        echo "Testing"
                    }
                }
            }

        }
    }
}
