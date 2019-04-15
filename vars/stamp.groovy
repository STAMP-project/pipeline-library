def info(message) {
    echo "INFO: ${message}"
}

def lastStabelVersion() {
    echo ${currentBuild.previousBuild.fullDisplayName}
}