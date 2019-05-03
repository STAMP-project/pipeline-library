# pipeline-library
A Jenkins Pipeline Shared Library for the CD Acceleration with STAMP-project tools

## Getting started
To use Jenkins Pipeline Shared Library, you will need:
- [Jenkins 2.x](https://jenkins.io/download/) or later (older versions back to 1.642.3 may work but are not recommended)
- [Pipeline plugin](https://plugins.jenkins.io/workflow-aggregator), which is installed as part of the "suggested plugins"

### Using Libraries
To install Jenkins Pipeline Shared Library follow the [official guide](https://jenkins.io/doc/book/pipeline/shared-libraries/#using-libraries).

### Library Functions

#### cloneLastStableVersion(String foldername)

Clone in the specified folder the previous stable version of the project (as defined in Jenkins scm section).

#### String getLastStableCommitVersion()

Get [SHA-1](https://git-scm.com/docs/gitglossary#def_SHA1) [Commit](https://git-scm.com/docs/gitglossary#Documentation/gitglossary.txt-aiddefcommitacommit) of the previous stable version of the project

#### cloneCommitVersion(String commitVersion, String foldername)

Clone in the specified folder the specified commitVersion of the project (as defined in Jenkins scm section).

#### pullRequest(String token, String repositoryName, String repositoryOwner, String pullRequestTitle, String pullRequestBody, String branchSource, String branchDestination, String proxyHost=null, Integer proxyPort=null)

Create a pull request in a github repository.
- token: [github token](https://help.github.com/en/articles/creating-a-personal-access-token-for-the-command-line)
- repositoryName: name of the repository
- repositoryOwner: owner of the repository
- pullRequestTitle: title of the Pull Request
- pullRequestBody: description body of the Pull Request
- branchSource: branch source
- branchDestionation: branch destination
- proxyHost (optional): host of the proxy
- proxyPort (optional): port of the proxy
