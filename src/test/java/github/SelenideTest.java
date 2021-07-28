package github;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;

public class SelenideTest {
    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    public void findIssueTest() {
        open("https://github.com");
        SelenideElement searchInput = $x("//input[@name='q']");
        searchInput.click();
        searchInput.setValue("eroshenkoam/allure-example").pressEnter();
        $(linkText("eroshenkoam/allure-example")).click();
        $x("//span[@data-content='Issues']").click();
        $("#issue_68_link").shouldHave(text("Listeners NamedBy"));
    }
}
