pipeline {
    agent any
    tools{
       maven 'Maven'
    }
    environment {
           MAVEN_HOME = tool name: 'Maven', type: 'maven'
           PATH = "${env.PATH}:${tool name: 'Maven', type: 'maven'}/bin"
           GIT_SSL_NO_VERIFY = "1"

    }
    stages {
        stage('Checkout') {
            steps {
               retry(3) {
                   checkout([$class: 'GitSCM',
                           branches: [[name: '*/master']],
                           extensions: [[$class: 'CloneOption', timeout: 30]],
                           userRemoteConfigs: [[url: 'https://github.com/18383363691/jekinsTest.git']]
                   ])
               }
            }
        }

        stage('Build') {
            steps {
                 sh "${MAVEN_HOME}/bin/mvn clean package" //构建maven项目
            }
        }
        stage('Deploy') {
            steps {
               sh "java -jar target/jekinsTest-0.0.1-SNAPSHOT.jar"

            }
        }
    }
}