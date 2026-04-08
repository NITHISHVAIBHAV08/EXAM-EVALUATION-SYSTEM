pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    environment {
        DOCKER_IMAGE = "exam-app"
    }

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
                bat 'docker build -t %DOCKER_IMAGE% .'
            }
        }

        stage('Docker Cleanup (Optional)') {
            steps {
                bat 'docker rm -f exam-container || exit 0'
            }
        }

        stage('Docker Run (Optional Test)') {
            steps {
                bat 'docker run -d -p 8081:8080 --name exam-container %DOCKER_IMAGE%'
            }
        }

        stage('Check Kubernetes Connection') {
            steps {
                bat 'kubectl get nodes'
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                bat 'kubectl apply -f deployment.yaml'
            }
        }

    }

    post {
        success {
            echo '✅ FULL PIPELINE SUCCESS 🎉'
        }
        failure {
            echo '❌ PIPELINE FAILED - CHECK ABOVE LOGS'
        }
    }
}
