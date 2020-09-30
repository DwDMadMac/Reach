node {
    stage('Preparation') {
        cleanWs()
        git credentialsId: 'EzeGithub', url: 'https://github.com/ProjectEzenity/Reach.git'
        mvnHome = tool 'ciMaven'
    }

    stage('Build') {
        echo 'Execute maven'
        // Phases: validate compile test-compile test package integration install deploy
        sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean deploy"
        javadoc javadocDir: 'Reach/javadoc', keepAll: false
    }

    stage('Results') {
        junit 'Reach/target/surefire-reports/*.xml'
        archive 'target/*.jar'
    }
}