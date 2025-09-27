pipeline {
    agent any

    environment {
        PATH = tool 'Maven'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch:'master',url:'https://github.com/18383363691/jekinsTest.git' // 修改为你的仓库 URL
            }
        }
        stage('Build') {
            steps {
             def MAVEN_HOME = tool name: 'Maven', type: 'maven'
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