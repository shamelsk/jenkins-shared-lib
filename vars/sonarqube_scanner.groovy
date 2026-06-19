# For Node.js, Python, and generic projects:
def call(String sonarServer, String projectName, String projectKey) {

    echo "Running SonarQube Scanner..."

    withSonarQubeEnv(sonarServer) {
        sh """
            sonar-scanner \
            -Dsonar.projectName=${projectName} \
            -Dsonar.projectKey=${projectKey}
        """
    }
}
