def call(String manifestFile = "deployment.yaml") {
    echo "Deploying to Kubernetes..."
    sh "kubectl apply -f ${manifestFile}"
}
