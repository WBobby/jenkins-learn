import hudson.model.*;
 
println env.JOB_NAME
println env.BUILD_NUMBER

class Global{
	static String name = "Bobby"
	static String id = "001"
}

println Global.name

pipeline{
	environment{
		Name = Global.name
	}
	
    agent any
    stages{
	stage("deleteDir") {
	    steps{
		script{
			sh("echo $Name")
			sh("echo ${Global.name})
		    sh("ls -al ${env.WORKSPACE}")
		    sh("mkdir -p abc")
		    sh("ls -al ${env.WORKSPACE}")
		    deleteDir()  // clean up current work directory
		    sh("ls -al ${env.WORKSPACE}")
		}
	    }
	}
    }
}
 
 

