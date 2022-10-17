pipeline {
    agent {
        docker {
            image 'selenium/node-firefox-debug:latest'
        }
    }
    stages {
        stage('WebUI') {
            steps {
                script {
                    try {
                        sh 'mvn test -Dsuite=testSuite.xml -pl WebUI_AUT'
                   } catch (err) {
                        echo err.getMessage()
                    }
                    echo currentBuild.result
                }
            }
        }

        stage('API') {
            steps {
                script {
                    try {
                        sh 'mvn test -Dtest=REST_ASSURED_Test -pl API_AUT'
                   } catch (err) {
                        echo err.getMessage()
                    }
                    echo currentBuild.result
                }
            }
        }
    }
}
