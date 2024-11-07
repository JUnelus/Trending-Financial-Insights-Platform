pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh 'mvn -f backend/kafka-service/pom.xml clean install'
                sh 'mvn -f backend/api-service/pom.xml clean install'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test -f backend/kafka-service/pom.xml'
                sh 'mvn test -f backend/api-service/pom.xml'
            }
        }
        stage('Deploy') {
            steps {
                sh 'docker-compose up -d --build'
            }
        }
    }
}
