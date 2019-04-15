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
	if (build != null){
    	for (changeLog in build.changeSets) {
        	for(entry in changeLog.items) {
				echo "${entry.commitId} by ${entry.author} on ${new Date(entry.timestamp)}: ${entry.msg}"
        	}
	    }		
	}
	
}
