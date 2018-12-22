pipeline {
    agent any
    tools {
        maven 'Apache Maven 3.5.2'
    }
    stages {
        stage('Load properties') {
            steps {
                script {
                    checkout scm
                    def constants = load '$JENKINS_HOME/.lpdm/docker-env'
                    def storePass = constants.store
                    echo "${storePass}"
                }
            }
        }
        stage('Checkout') {
            steps {
                git 'https://github.com/vyjorg/LPDM-Store'
            }
        }
        stage('Tests') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/**/*.xml'
                }
                failure {
                    error 'The tests failed'
                }
            }
        }
        stage('Push to DockerHub') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Deploy') {
            steps {
                sh 'docker stop LPDM-StoreMS || true && docker rm LPDM-StoreMS || true'
                sh 'docker pull vyjorg/lpdm-store:latest'
                sh 'docker run -d --name LPDM-StoreMS -p 28084:28084 --link LPDM-StoreDB --restart always --memory-swappiness=0  -e "JAVA_TOOL_OPTIONS=-Djasypt.encryptor.password=${properties.store}" vyjorg/lpdm-store:latest'
            }
        }
    }
}
