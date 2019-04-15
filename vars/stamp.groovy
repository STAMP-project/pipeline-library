def info(message) {
    echo "INFO: ${message}"
}

def lastStableVersion() {
    def changes = "Changes:\n"
	build = currentBuild.previousBuild
	while(build != null && (build.result != 'SUCCESS' || (build.result == 'SUCCESS' && build.changeSets == null) ) ) {
    	changes += "In ${build.id}:\n"
    	for (changeLog in build.changeSets) {
        	for(entry in changeLog.items) {
        		echo entry.commitId
            	for(file in entry.affectedFiles) {
                	changes += "* ${file.path}\n"
            	}
        	}
	    }
    	build = build.previousBuild
	}

	echo changes
	echo build.id
}