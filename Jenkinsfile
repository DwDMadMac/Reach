pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "ciMaven"
    }

    stages {
        stage('Preparation') {
            steps {
                echo 'Preparation...'
                cleanWs()
                git credentialsId: 'EzeGithub', url: 'https://github.com/ProjectEzenity/Reach.git'
            }
        }

        stage('Build') {
            steps {
                echo 'Execute maven...'
                // Phases: validate compile test-compile test package integration install deploy
                sh "mvn clean install"
                javadoc javadocDir: 'target/apidocs', keepAll: false
            }
        }
    }
}