pipeline {
    agent any

    tools {
        // Names must match Manage Jenkins > Tools exactly
        maven 'Maven3'
        jdk   'JDK17'
    }

    environment {
        APP_PORT = '8080'
        JAR_NAME = 'crud-demo.jar'
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build Jar') {
            steps {
                bat 'mvn -B clean package'
            }
        }

        stage('Run App') {
            steps {
                bat """
                    for /f "tokens=5" %%p in ('netstat -aon ^| findstr :%APP_PORT%') do taskkill /F /PID %%p 2>nul
                    start "crud-demo" /B java -jar target\\%JAR_NAME% > app.log 2>&1
                """
            }
        }

        stage('Health Check') {
            steps {
                bat """
                    timeout /t 5
                    curl -s -o NUL -w "%%{http_code}" http://localhost:%APP_PORT%/api/products
                """
            }
        }

        stage('Confirm & Stop') {
            steps {
                script {
                    input message: 'App is up and verified. Stop it now?', ok: 'Stop it'
                }
                bat """
                    for /f "tokens=5" %%p in ('netstat -aon ^| findstr :%APP_PORT%') do taskkill /F /PID %%p
                """
            }
        }
    }

    post {
        success {
            echo 'Pipeline finished successfully.'
        }
        failure {
            echo 'Pipeline failed. Check the logs above.'
        }
    }
}