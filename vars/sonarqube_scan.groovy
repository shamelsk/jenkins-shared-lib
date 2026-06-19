def call() {
echo "Running SonarQube Analysis..."

```
withSonarQubeEnv('sonarqube') {
    sh 'mvn sonar:sonar'
}
```

}
