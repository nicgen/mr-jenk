pipeline {
    agent any

    environment {
        COMPOSE_FILE = 'docker-compose.yml'
        COMPOSE_PROJECT_NAME = 'mr-jenk'
    }

    stages {
        stage('Test Backend') {
            parallel {
                stage('User Service') {
                    steps {
                        dir('services/user-service') {
                            sh 'mvn test'
                        }
                    }
                }
                stage('Product Service') {
                    steps {
                        dir('services/product-service') {
                            sh 'mvn test'
                        }
                    }
                }
                stage('Media Service') {
                    steps {
                        dir('services/media-service') {
                            sh 'mvn test'
                        }
                    }
                }
            }
        }

        stage('Test Frontend') {
            environment {
                CHROME_BIN = '/usr/bin/google-chrome-stable'
            }
            steps {
                dir('frontend') {
                    sh 'npm install'
                    // Run tests using the local ng installed by npm
                    sh 'npm run test -- --watch=false --browsers=ChromeHeadlessNoSandbox'
                }
            }
        }

        stage('Build Images') {
            steps {
                sh 'docker compose build'
            }
        }

        stage('Deploy') {
            steps {
                // Deploy locally by restarting containers
                sh 'docker compose up -d'
            }
        }
    }

    post {
        always {
            cleanWs()
        }
        success {
            echo 'Pipeline succeeded!'
            mail to: "${env.ADMIN_EMAIL}", // Set this in Jenkins Global configuration
                 subject: "✅ Build Succeeded: ${currentBuild.fullDisplayName}",
                 body: """
                 Great news! The build was successful.
                 
                 Project: ${env.JOB_NAME}
                 Build Number: ${env.BUILD_NUMBER}
                 URL: ${env.BUILD_URL}
                 """
        }
        failure {
            echo 'Pipeline failed!'
            mail to: "${env.ADMIN_EMAIL}", // Set this in Jenkins Global configuration
                 subject: "❌ Build Failed: ${currentBuild.fullDisplayName}",
                 body: """
                 The build has failed. Please investigate.
                 
                 Project: ${env.JOB_NAME}
                 Build Number: ${env.BUILD_NUMBER}
                 URL: ${env.BUILD_URL}
                 
                 Check the console logs for errors.
                 """
        }
    }
}
