def cloneLastStableVersion(String foldername = "oldVersion") {
	cloneCommitVersion(getLastStableCommitVersion(),foldername);
}

String getLastStableCommitVersion(){
	// OR use variable GIT_PREVIOUS_SUCCESSFUL_COMMIT

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

def pullRequest(String token, String repositoryName, String repositoryOwner, String pullRequestTitle, String pullRequestBody, String branchSource, String branchDestination, String proxyHost=null, Integer proxyPort=null) {
	new eu.stamp.ci.GitHubPullRequest().createPullRequest(token, repositoryName,repositoryOwner,pullRequestTitle,
			pullRequestBody, branchSource, branchDestination, proxyHost, proxyPort)
}

// push example	
//https://github.com/jenkinsci/pipeline-examples/tree/master/pipeline-examples/push-git-repo
