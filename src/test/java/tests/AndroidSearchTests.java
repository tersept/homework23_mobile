package tests;

import com.codeborne.selenide.Configuration;
import drivers.BrowserstackMobileDriver;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;


public class AndroidSearchTests {

    @Test
    void searchTest() {
        Configuration.browser = BrowserstackMobileDriver.class.getName();
        Configuration.browserSize = null;

        open();

        $(AppiumBy.accessibilityId("Search Wikipedia")).click();
        $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("BrowserStack");
        $$(AppiumBy.className("android.widget.TextView")).shouldHave(sizeGreaterThan(0));

        closeWebDriver();
    }

}