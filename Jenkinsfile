pipeline {
    agent none

    environment {
        // Shared environment variables
        COMPOSE_FILE = 'docker-compose.yml'
    }

    stages {
        stage('Test Backend') {
            parallel {
                stage('User Service') {
                    agent {
                        docker {
                            image 'maven:3.9.6-eclipse-temurin-17'
                            args '-v $HOME/.m2:/root/.m2'
                        }
                    }
                    steps {
                        dir('services/user-service') {
                            sh 'mvn test'
                        }
                    }
                }
                stage('Product Service') {
                    agent {
                        docker {
                            image 'maven:3.9.6-eclipse-temurin-17'
                            args '-v $HOME/.m2:/root/.m2'
                        }
                    }
                    steps {
                        dir('services/product-service') {
                            sh 'mvn test'
                        }
                    }
                }
                stage('Media Service') {
                    agent {
                        docker {
                            image 'maven:3.9.6-eclipse-temurin-17'
                            args '-v $HOME/.m2:/root/.m2'
                        }
                    }
                    steps {
                        dir('services/media-service') {
                            sh 'mvn test'
                        }
                    }
                }
            }
        }

        stage('Test Frontend') {
            agent {
                docker {
                    // Node image with Chrome installed for Headless testing
                    image 'trion/ng-cli-karma:17.3.0' 
                }
            }
            steps {
                dir('frontend') {
                    sh 'npm install'
                    // Run tests in headless mode, single run
                    sh 'ng test --watch=false --browsers=ChromeHeadless'
                }
            }
        }

        stage('Build Images') {
            agent any
            steps {
                sh 'docker compose build'
            }
        }

        stage('Deploy') {
            agent any
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
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}
