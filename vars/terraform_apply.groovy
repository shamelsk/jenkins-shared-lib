def call() {
    echo "Applying Terraform Infrastructure..."
    sh 'terraform apply -auto-approve'
}
