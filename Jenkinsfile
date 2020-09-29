node {
    stage('Build') {
        git url: 'https://github.com/ProjectEzenity/Reach.git'
        withMaven {
            sh "mvn clean install"
        }
    }
}