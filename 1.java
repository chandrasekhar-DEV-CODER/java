pipeline {
    agent any  // Runs on any available agent

    environment {
        APP_NAME = "MyApp"
    }

    stages {
        stage('Checkout') {
            steps {
                echo "Checking out the code..."
                git url: 'https://github.com/example/repo.git', branch: 'main'
            }
        }

        stage('Build') {
            steps {
                echo "Building the application..."
                sh 'mvn clean install'  // Example build command for a Java project
            }
        }

        stage('Test') {
            steps {
                echo "Running tests..."
                sh 'mvn test'  // Running unit tests
            }
        }

        stage('Deploy') {
            steps {
                echo "Deploying application..."
                sh './deploy.sh'  // Example deployment script
            }
        }
    }

    post {
        success {
            echo 'Pipeline execution successful!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}
