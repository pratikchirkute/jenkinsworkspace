pipeline {
    agent {
        docker {
            ‘maven:3-alpine’
        }
    }
    stages {
        stage('API Automation') {
            steps {
                sh 'node --version'
                echo 'Stage1: API automation..'
            }
        }
        stage('WebUI Automation') {
            steps {
                echo 'Stage2: UI automation..'
            }
        }
    }
}