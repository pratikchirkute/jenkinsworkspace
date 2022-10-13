pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v /root/.m2:/root/.m2'
        }
    }

    stages {
        // stage('WebUI') {
        //     steps {
        //         sh 'mvn test -Dsuite=testSuite.xml -pl WebUI_AUT'
        //     }
        // }

        stage('API') {
            steps {
                sh 'mvn test -Dtest=REST_ASSURED_Test -pl API_AUT'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
    }
}
