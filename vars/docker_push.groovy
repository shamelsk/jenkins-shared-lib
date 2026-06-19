def call(Map config = [:]) {

    def imageName = config.imageName ?: error("imageName is required")
    def imageTag = config.imageTag ?: "latest"
    def credentialsId = config.credentialsId ?: "docker-hub-credentials"

    echo "Pushing Docker image: ${imageName}:${imageTag}"

    withCredentials([
        usernamePassword(
            credentialsId: credentialsId,
            usernameVariable: 'DOCKER_USERNAME',
            passwordVariable: 'DOCKER_PASSWORD'
        )
    ]) {

        sh """
            echo "\$DOCKER_PASSWORD" | docker login \
            -u "\$DOCKER_USERNAME" \
            --password-stdin

            docker push ${imageName}:${imageTag}
        """
    }
}
