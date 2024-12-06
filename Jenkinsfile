pipeline {
    agent any

    environment {
        ANGULAR_BUILD_DIR = "C:/Users/dorsa/Desktop/Projet Devops/Frontend-devops/test/dist/enicar" // Dossier de build Angular
        BACKEND_JAR = "C:/Users/dorsa/Desktop/Projet Devops/Backend-devops/target/myapp.jar"   // Emplacement du JAR Spring Boot
        DEPLOY_USER = "dorsa"                       // Utilisateur Jenkins (Dorsaf)
        DEPLOY_SERVER = "localhost"                // Adresse locale pour le déploiement
        ANGULAR_DEPLOY_DIR = "C:/Users/dorsa/Desktop/Projet Devops/Frontend-devops/test/deploy"  // Dossier local de déploiement pour Angular
        BACKEND_DEPLOY_DIR = "C:/Users/dorsa/Desktop/Projet Devops/Backend-devops/target/deploy"  // Dossier local pour déployer Spring Boot
    }

    stages {
        stage('Checkout Code') {
            steps {
                echo 'Cloning repository...'
                checkout scm
            }
        }

        stage('Build Angular') {
            steps {
                echo 'Building Angular application...'
                dir('frontend') { // Aller dans le dossier du projet Angular
                    bat '''
                    npm install
                    npm run build --prod
                    '''
                }
            }
        }

        stage('Build Spring Boot') {
            steps {
                echo 'Building Spring Boot application...'
                dir('backend') { // Aller dans le dossier du projet Spring Boot
                    bat './mvnw clean package -DskipTests' // Compile le JAR sans exécuter les tests
                }
            }
        }

        stage('Test Angular') {
            steps {
                echo 'Running Angular tests...'
                dir('frontend') {
                    bat 'npm test'
                }
            }
        }

        stage('Test Spring Boot') {
            steps {
                echo 'Running Spring Boot tests...'
                dir('backend') {
                    bat './mvnw test'
                }
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying application locally...'
                // Déploiement sur les dossiers locaux via copy
                bat '''
                mkdir ${ANGULAR_DEPLOY_DIR}
                mkdir ${BACKEND_DEPLOY_DIR}
                xcopy /E /I ${ANGULAR_BUILD_DIR} ${ANGULAR_DEPLOY_DIR}
                copy ${BACKEND_JAR} ${BACKEND_DEPLOY_DIR}
                '''
            }
        }
    }

    post {
        always {
            echo 'Pipeline execution completed!'
        }
        success {
            echo 'Pipeline executed successfully!'
        }
        failure {
            echo 'Pipeline failed. Check logs for errors.'
        }
    }
}
