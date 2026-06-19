def call() {
    echo "Displaying Agent Environment Information..."

    sh '''
        echo "===== GIT ====="
        git --version

        echo "===== JAVA ====="
        java -version

        echo "===== MAVEN ====="
        mvn -version

        echo "===== DOCKER ====="
        docker --version

        echo "===== DOCKER COMPOSE ====="
        docker compose version

        echo "===== PYTHON ====="
        python3 --version

        echo "===== TERRAFORM ====="
        terraform version

        echo "===== KUBECTL ====="
        kubectl version --client

        echo "===== ANSIBLE ====="
        ansible --version
    '''
}
