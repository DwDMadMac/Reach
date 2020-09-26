pipeline{
    agent any
    node {
        stages{
            stage('Build') {
                git url: 'https://github.com/ProjectEzenity/Reach.git'
                withMaven {
                    sh "mvn -B -DskipTests clean package"
                }
            }
        }
    }
}