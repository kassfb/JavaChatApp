properties([disableConcurrentBuilds()])

pipeline {
    agent { 
        label 'master'
        }
    options {
        buildDiscarder(logRotator(numToKeepStr: '10', artifactNumToKeepStr: '10'))
        timestamps()
    }
    stages {
        stage("start docker-compose") {
            steps {
                echo " ============== start building images =================="
                //sh 'sudo docker-compose build'
                //sh 'sudo docker-compose up -d'
                //echo " ============== finish building images =================="
            }
        }
        stage("finish docker-compose") {
                steps {
                    echo " ============== finish building images =================="
                }
        }
    }
}
