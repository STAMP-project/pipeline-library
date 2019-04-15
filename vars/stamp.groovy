def info(message) {
    echo "INFO: ${message}"
}

def lastStableVersion() {
    echo "fullDisplayName: ${currentBuild.previousBuild.fullDisplayName}"
}