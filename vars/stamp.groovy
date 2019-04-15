def info(message) {
    echo "INFO: ${message}"
}

def lastStableVersion() {
    echo "${currentBuild.previousBuild.fullDisplayName}"
}