pipeline {
    agent any

  stage('Clone') {
    steps {
        git branch: 'main',
            url: 'https://github.com/NITHISHVAIBHAV08/EXAM-EVALUATION-SYSTEM',
            credentialsId: 'github-creds'
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
