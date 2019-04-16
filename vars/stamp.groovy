def info(message) {
    echo "INFO: ${message}"
}

def lastStableVersion() {
	// gest last sable build with a changeSets
	build = currentBuild.previousBuild
	while(build != null && (build.result != 'SUCCESS' || (build.result == 'SUCCESS' && build.changeSets == null) ) ) {
    	build = build.previousBuild
	}

	// get last commit id
	// TODO get commit from the project repo
	if (build != null){
		def lastcommit = null;
		def lastcommitTimestamp = null;
    	for (changeLog in build.changeSets) {
        	for(entry in changeLog.items) {
        		if (lastcommitTimestamp == null || lastcommitTimestamp < new Date(entry.timestamp)){
        			lastcommitTimestamp = new Date(entry.timestamp);
        			lastcommit = entry.commitId;
        		}
        	}
	    }
	echo  "BUILD_ID: ${build.id} COMMIT_ID: ${lastcommit}" 
	}
	dir ('oldVersion') {
		 checkout([
         $class: 'GitSCM',
		 branches: [[ name: '3805f324']]
		 //,
         //doGenerateSubmoduleConfigurations: scm.doGenerateSubmoduleConfigurations,
         //extensions: scm.extensions,
         //userRemoteConfigs: scm.userRemoteConfigs
    	])
	}
}
