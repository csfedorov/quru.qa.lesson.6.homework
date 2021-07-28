package github;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class AllureLambdaTest {
    private static final String REPO_NAME = "eroshenkoam/allure-example";

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    public void findIssueTest() {
        step("Open main page", () -> open("https://github.com"));

        step("Find repository: " + REPO_NAME, () -> {
            SelenideElement searchInput = $x("//input[@name='q']");
            searchInput.click();
            searchInput.setValue(REPO_NAME).pressEnter();
        });
        step("Open repository: " + REPO_NAME, () -> $(linkText("eroshenkoam/allure-example")).click());
        step("Open issues", () -> $x("//span[@data-content='Issues']").click());

        String issueName = "Listeners NamedBy";
        step("Verify issue: " + issueName, () -> {
            $("#issue_68_link").shouldHave(text(issueName));
        });
    }
}
