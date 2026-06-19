def call(String project, String imageTag, String dockerHubUser) {
    echo "Removing image ${dockerHubUser}/${project}:${imageTag}"
    sh "docker rmi ${dockerHubUser}/${project}:${imageTag}"
}
