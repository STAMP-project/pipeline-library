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


