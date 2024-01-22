pipeline {
    agent any

    stages {
        stage('Clonar Repositorio') {
            steps {
                script {
                    // Clonar el repositorio
                    checkout scm
                }
            }
        }

        stage('Compilar y Empaquetar') {
            steps {
                script {
                    // Compilar y empaquetar con Maven
                    sh 'mvn clean package'
                }
            }
        }

        stage('Ejecutar Pruebas Unitarias') {
            steps {
                script {
                    // Ejecutar pruebas unitarias con Maven y JUnit
                    sh 'mvn test'
                }
            }
        }

        stage('Ejecutar Pruebas de Integración') {
            steps {
                script {
                    // Ejecutar pruebas de integración con Cucumber y Selenium
                    sh 'mvn clean test -Pintegration-tests'
                }
            }
        }

        stage('Desplegar') {
            steps {
                // Agrega aquí los comandos para desplegar tu aplicación si es necesario
            }
        }
    }

    post {
        success {
            // Pasos a seguir si el pipeline es exitoso
            echo 'El pipeline se ejecutó exitosamente.'
        }

        failure {
            // Pasos a seguir si el pipeline falla
            echo 'El pipeline ha fallado. Revisar los resultados y corregir.'
        }
    }
}
