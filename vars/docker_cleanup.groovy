def call() {
    echo "Cleaning Docker resources..."
    sh 'docker system prune -af'
}
