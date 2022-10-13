pipeline {
    agent {
        docker {
            image 'markhobson:maven-firefox'
            args '-v /root/.m2:/root/.m2'
        }
    }
    stages {
        stage('WebUI') {
            steps {
                sh 'mvn test -Dsuite=testSuite.xml -pl WebUI_AUT'
            }
        }

        stage('API') {
            steps {
                sh 'mvn test -Dtest=REST_ASSURED_Test -pl API_AUT'
            }
            post {
                always {
                    junit 'API_AUT/target/surefire-reports/*.xml'
                }
            }
        }
    }
}
