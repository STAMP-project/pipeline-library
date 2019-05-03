package eu.stamp.ci

@Grab('org.eclipse.mylyn.github:org.eclipse.egit.github.core:5.3.0.201903061415-rc1')
import org.eclipse.egit.github.core.PullRequest
import org.eclipse.egit.github.core.Repository
import org.eclipse.egit.github.core.client.GitHubClient
import org.eclipse.egit.github.core.service.RepositoryService

void createPullRequest() {
    GitHubClient client = new GitHubClient();
    // client.setOAuth2Token();
    client.setHeaderAccept("application/vnd.github.machine-man-preview+json");
}
