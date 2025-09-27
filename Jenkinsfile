pipeline {
    agent {
       docker{
                 image 'docker:dind'  // 使用Docker-in-Docker镜像
                 args '--privileged
                       -v /usr/bin/docker:/usr/bin/docker
                       -v /var/run/docker.sock:/var/run/docker.sock
                       -e DOCKER_TLS_CERTDIR=""'  // 禁用TLS验证
                 registryUrl 'https://index.docker.io/v1/'
                 registryCredentialsId 'docker-creds'
       }
    }
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
                 script{
                    sh 'docker version'
                    def image=docker.build("simple-web:latest")
                 }
            }
        }
        stage('Deploy') {
            steps {
            //   sh "nohup java -jar target/jekinsTest-0.0.1-SNAPSHOT.jar" returnStatus: true
                script{
                    sh 'docker rm -f simple-web ||true'
                    docker.image("simple-web:latest").run("-d -p 8081:8081 --name simple-web")
                }

            }
        }
    }
}