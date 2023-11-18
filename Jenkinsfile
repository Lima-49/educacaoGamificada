pipeline {
  agent any
  stages {
    stage("verify tooling") {
      steps {
        bat '''
          docker version
          docker info
          docker compose version
          curl --version
          '''
      }
    }

    stage('Start container') {
      steps {
        bat 'docker compose up -d --no-color --wait'
        bat 'docker compose ps'
      }
    }
    stage('Run tests against the container') {
      steps {
        bat 'curl http://localhost:9090'
      }
    }
  }

}