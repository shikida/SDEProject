node {
  stage('SCM') {
    checkout scm
  }
  stage('SonarQube Analysis') {
    def mvn = tool 'Default Maven';
    withSonarQubeEnv() {
      sh "${mvn}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=shikida_SDEProject_AY0S93MPEGZAQf9pkjTA -Dsonar.projectName='SDEProject'"
    }
  }
}
