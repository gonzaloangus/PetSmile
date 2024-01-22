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

        stage('Configurar JDK y Maven') {
            steps {
                script {
                    // Configurar JDK y Maven
                    tool 'JDK8'
                    tool 'Maven'
                }
            }
        }

        stage('Compilar y Ejecutar Pruebas') {
            steps {
                script {
                    // Compilar y ejecutar pruebas
                    withMaven(
                        maven: 'Maven',
                        jdk: 'JDK8',
                        mavenSettingsConfig: 'config-settings'
                    ) {
                        sh 'mvn clean test'
                    }
                }
            }
        }

        stage('Desplegar') {
            steps {
                script {
                    // Puedes agregar acciones de implementación o notificación aquí
                    echo 'Despliegue exitoso'
                }
            }
        }
    }

    post {
        success {
            echo '¡Pruebas exitosas! Puedes proceder con el despliegue.'
        }

        failure {
            echo 'Las pruebas fallaron. Revisa los resultados y realiza correcciones si es necesario.'
        }
    }
}
