# AUDIT MR-Jenk

## PART - ACTION - Functional

### ACTION - Download the project and trigger a Jenkins build. Observe if the pipeline runs as expected.

### Q? - Does the pipeline initiate and run successfully from start to finish?

### ACTION - Trigger some intentional build errors and observe Jenkins' response.

### Q? - Does Jenkins respond appropriately to build errors?

### ACTION - Examine the automated testing step.

### Q? - Are tests run automatically during the pipeline execution? Does the pipeline halt on test failure?

### ACTION - Make a minor change in the source code, commit, and push. Observe if the pipeline is triggered automatically.

### Q? - Does a new commit and push automatically trigger the Jenkins pipeline?

### ACTION - Check the deployment process.

### Q? - Is the application deployed automatically after a successful build? Is there a rollback strategy in place?

## PART - ACTION - Security

### ACTION - Examine the permissions on the Jenkins dashboard.

### Q? - Are permissions set appropriately to prevent unauthorized access or changes?

### ACTION - Review how sensitive data (like API keys, passwords) is managed in Jenkins.

### Q? - Is sensitive data secured using Jenkins secrets or environment variables?

## PART - ACTION - Code Quality and Standards

### ACTION - Examine the Jenkinsfile or the build configuration.

### Q? - Is the code/script well-organized and understandable? Are there any best practices being ignored?

### ACTION - Look into the test report formats and outputs.

### Q? - Are test reports clear, comprehensive, and stored for future reference?

### ACTION - Check for notifications setup.

### Q? - Are notifications triggered on build and deployment events? Are they informative?

## PART - ACTION - Bonus

### ACTION - Examine if parameterized builds are implemented.

### Q? - +Are there options for customizing the build run with different parameters?

### ACTION - Examine the distributed builds (if implemented).

### Q? - +Are multiple agents utilized effectively for distributed builds?
