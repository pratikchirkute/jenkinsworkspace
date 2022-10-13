pipeline {
    agent {
        docker {
            image 'markhobson/maven-firefox:jdk-8'
            args '-v /root/.m2:/root/.m2'
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
