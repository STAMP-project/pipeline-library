package eu.stamp.ci

@Grab('org.eclipse.mylyn.github:org.eclipse.egit.github.core:5.3.0.201903061415-rc1')
import org.eclipse.egit.github.core.PullRequest
import org.eclipse.egit.github.core.service.PullRequestService
import org.eclipse.egit.github.core.Repository
import org.eclipse.egit.github.core.client.GitHubClient
import org.eclipse.egit.github.core.service.RepositoryService

class Client {

    def createPullRequest() {
        GitHubClient client = new GitHubClient();
        client.setOAuth2Token("prova");
        RepositoryService repoService = new RepositoryService(client);
        PullRequestService service = new PullRequestService(client);
    }
}