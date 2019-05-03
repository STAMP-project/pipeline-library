package eu.stamp.ci

@Grab('org.eclipse.mylyn.github:org.eclipse.egit.github.core:5.3.0.201903061415-rc1')
@Grab(group='com.google.code.gson', module='gson', version='2.3.1')
import org.eclipse.egit.github.core.PullRequest
import org.eclipse.egit.github.core.service.PullRequestService
import org.eclipse.egit.github.core.Repository
import org.eclipse.egit.github.core.client.GitHubClient
import org.eclipse.egit.github.core.service.RepositoryService
import org.eclipse.egit.github.core.PullRequestMarker

class Client {

    def createPullRequest(String tocken, String repositoryName, String repositoryOwner, String pullRequestTitle,
			String pullRequestBody, String branchSource, String branchDestination) {
        GitHubClient client = new GitHubClient();
        client.setOAuth2Token(tocken);

        RepositoryService repoService = new RepositoryService(client);
		Repository repository = repoService.getRepository(repositoryOwner, repositoryName);

		PullRequestService service = new PullRequestService(client);

		PullRequest request = new PullRequest();
		request.setTitle(pullRequestTitle);
		request.setBody(pullRequestBody);

		request.setHead(new PullRequestMarker().setRef(branchSource).setLabel(branchSource));
		request.setBase(new PullRequestMarker().setRef(branchDestination).setLabel(branchDestination));

		PullRequest pr = service.createPullRequest(repository, request);
    }
}