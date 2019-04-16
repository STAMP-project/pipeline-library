def cloneLastStableVersion(String foldername = "oldVersion") {
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
	echo  "LAST STABLE BUILD_ID: ${build.id} COMMIT_ID: ${lastcommit}" 
	}
	// clone last stable build
	if (lastcommit != null){
		dir (foldername) {
		 	checkout([
         	$class: 'GitSCM',
		 	branches: [[ name: lastcommit]]
    		])
		}
	}
}
