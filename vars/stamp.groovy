def cloneLastStableVersion(String foldername = "oldVersion") {
	cloneCommitVersion(getLastStableCommitVersion(),foldername);
}

String getLastStableCommitVersion(){
	// gest last sable build with a changeSets
	build = currentBuild.previousBuild
	while(build != null && (build.result != 'SUCCESS' || (build.result == 'SUCCESS' && build.changeSets == null) ) ) {
    	build = build.previousBuild
	}
	// get last commit id
	// TODO get commit from the project repo
	def lastcommit = null;
	if (build != null){
		def lastcommitTimestamp = null;
    	for (changeLog in build.changeSets) {
        	for(entry in changeLog.items) {
        		if (lastcommitTimestamp == null || lastcommitTimestamp < new Date(entry.timestamp)){
        			lastcommitTimestamp = new Date(entry.timestamp);
        			lastcommit = entry.commitId;
        		}
        	}
	    }
	echo  "LAST STABLE BUILD_ID: ${build.id} COMMIT_ID: ${lastcommit}"
	}
	return lastcommit
}

def cloneCommitVersion(String commitVersion, String foldername) {
		// clone last stable build
	if (commitVersion != null){
		dir (foldername) {
			// clone last version
			checkout scm
			// revert to commit version
		 	checkout([
         	$class: 'GitSCM',
		 	branches: [[ name: "${commitVersion}"]]
    		])
		}
	}
}

def pullRequest() {
	new eu.stamp.ci.Client().createPullRequest()
}
