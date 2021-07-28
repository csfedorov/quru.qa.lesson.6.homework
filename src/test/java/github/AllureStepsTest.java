package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AllureStepsTest {
    GitHubSteps gitHubSteps = new GitHubSteps();
    private static final String REPO_NAME = "eroshenkoam/allure-example";

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    public void findIssueTest() {
        gitHubSteps
                .openMainPage()
                .searchRepository(REPO_NAME)
                .openRepository(REPO_NAME)
                .openIssues()
                .verifyIssueName("Listeners NamedBy");
    }
}
