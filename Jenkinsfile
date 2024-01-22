pipeline {
    agent any
    
    environment {
        M2_HOME = tool 'Maven'
        PATH = "$M2_HOME/bin:$PATH"
    }

    stages {
        stage('Setup') {
            steps {
                script {
                    // Configurar variables de entorno y otras configuraciones
                    sh 'echo "Configurando variables de entorno y herramientas"'
                }
            }
        }

        stage('Build') {
            steps {
                script {
                    // Construir el proyecto Maven
                    sh 'mvn clean install'
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    // Ejecutar pruebas unitarias y automatizadas
                    sh 'mvn test'
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    // Implementar o realizar acciones posteriores
                    sh 'echo "Implementando o realizando acciones posteriores"'
                }
            }
        }
    }

    post {
        always {
            // Acciones que se ejecutan siempre, independientemente del resultado del pipeline
            echo 'Finalizando el pipeline'
        }
        success {
            // Acciones que se ejecutan solo si el pipeline tiene éxito
            echo 'El pipeline se ejecutó exitosamente'
        }
        failure {
            // Acciones que se ejecutan solo si el pipeline falla
            echo 'El pipeline ha fallado'
        }
    }
}
