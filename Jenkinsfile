#!groovy
// Check ub1 properties
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
                sh 'docker-compose up -d'
            }
        }
    }
}
