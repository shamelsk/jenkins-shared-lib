def call(Map config = [:]) {

    def sourceImage   = config.sourceImage ?: error("sourceImage is required")
    def imageName     = config.imageName ?: error("imageName is required")
    def imageTag      = config.imageTag ?: "latest"
    def credentialsId = config.credentialsId ?: "dockerHubCred"

    echo "Tagging and pushing Docker image: ${imageName}:${imageTag}"

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

            docker tag ${sourceImage}:${imageTag} ${imageName}:${imageTag}

            docker push ${imageName}:${imageTag}

            docker logout
        """
    }
}
