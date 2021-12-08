pipeline {
agent any
stages{
/* Cloning the git branch*/
stage('Clone repository') {
        steps {
            git branch: 'master',
                credentialsId: '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',
                url: 'https://github.com/pravinchavan1992/juiceshop.git'

            sh "ls -lat"
        }
}
	
/* Execute the pytest script. Even on faliure proceed to next step */
stage('Execute script') {
steps{
        catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
            sh 'mvn clean install -Dtarget=local'
        }
}
}

}
}
