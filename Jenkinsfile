pipeline {
    agent any

    stages {
        stage('Clone') {
            steps {
                git 'https://github.com/NITHISHVAIBHAV08/EXAM-EVALUATION-SYSTEM'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t exam-app .'
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                sh 'kubectl apply -f deployment.yaml'
                sh 'kubectl apply -f service.yaml'
            }
        }
    }
}
