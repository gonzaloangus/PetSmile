pipeline{
    
    agent any
    steages{
        
        stage ('Build'){
            step{
                echo "estapa Build no diponinle"
            }
             stage ('Tests'){
            step{
                "estapa Test no diponinle"
            }
            stag ('Depoy'){
                
                steps{
                    
                    sh "docker-compose down -v"
                    sh "docker-componse up -d --build"
                }

            }

           }
        }

    }

}
