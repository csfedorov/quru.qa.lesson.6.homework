package github;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;

public class GitHubSteps {

    @Step("Open main page")
    public GitHubSteps openMainPage() {
        open("https://github.com");
        return this;
    }

    @Step("Find repository [{repository}]")
    public GitHubSteps searchRepository(String repository) {
        SelenideElement searchInput = $x("//input[@name='q']");
        searchInput.click();
        searchInput.setValue(repository).pressEnter();
        return this;
    }

    @Step("Open repository [{repositoryName}]")
    public GitHubSteps openRepository(String repositoryName) {
        $(linkText(repositoryName)).click();
        return this;
    }

    @Step("Open issues")
    public GitHubSteps openIssues() {
        $x("//span[@data-content='Issues']").click();
        return this;
    }

    @Step("Verify issue: [{issueName}]")
    public GitHubSteps verifyIssueName(String issueName) {
        $x("//div[@aria-label='Issues']//a[text()='" + issueName +"']").shouldBe(visible);
        return this;
    }
}
