 pipeline {
    agent any

    stages {

        stage('Clone') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/NITHISHVAIBHAV08/EXAM-EVALUATION-SYSTEM',
                    credentialsId: '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'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Docker Build') {
            steps {
                bat 'docker build -t exam-app .'
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                bat 'kubectl apply -f deployment.yaml'
            }
        }

    }
}
