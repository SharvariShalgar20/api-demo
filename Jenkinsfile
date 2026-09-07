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
                    for /f "tokens=5" %%p in ('netstat -aon ^| findstr :%APP_PORT% ^| findstr LISTENING') do taskkill /F /PID %%p 2>nul
                    start "crud-demo" /B java -jar target\\%JAR_NAME% > app.log 2>&1
                    exit /b 0
                """
            }
        }

        stage('Health Check') {
            steps {
                bat """
                    setlocal enabledelayedexpansion
                    set STATUS=000
                    for /L %%i in (1,1,10) do (
                        ping -n 3 127.0.0.1 >nul
                        for /f %%c in ('curl -s -o NUL -w "%%{http_code}" http://localhost:%APP_PORT%/api/products') do set STATUS=%%c
                        if "!STATUS!"=="200" goto :done
                        echo Waiting for app... attempt %%i, status !STATUS!
                    )
                    :done
                    echo Final status: !STATUS!
                    if not "!STATUS!"=="200" exit /b 1
                """
            }
        }

        stage('Confirm & Stop') {
            steps {
                script {
                    input message: 'App is up and verified. Stop it now?', ok: 'Stop it'
                }
                bat """
                    for /f "tokens=5" %%p in ('netstat -aon ^| findstr :%APP_PORT% ^| findstr LISTENING') do taskkill /F /PID %%p
                    exit /b 0
                """
            }
        }
    }

    post {
        success {
            echo '✅ Pipeline finished successfully.'
        }
        failure {
            echo '❌ Pipeline failed. Check the logs above.'
        }
    }
}