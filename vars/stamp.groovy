def info(message) {
    echo "INFO: ${message}"
}

def lastStableVersion() {
    def changes = "Changes:\n"
	build = currentBuild
	while(build != null && build.result != 'SUCCESS') {
    	changes += "In ${build.id}:\n"
    	for (changeLog in build.changeSets) {
        	for(entry in changeLog.items) {
            	for(file in entry.affectedFiles) {
                	changes += "* ${file.path}\n"
            	}
        	}
	    }
    	build = build.previousBuild
	}
	echo changes
}