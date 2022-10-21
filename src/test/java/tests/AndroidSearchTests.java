package tests;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;


public class AndroidSearchTests extends TestBase {

    @Test
    void searchTest() {
        step("Type search", () -> {
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("BrowserStack");
        });
        step("Verify content found", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
    }
    //Resource-Id	org.wikipedia.alpha:id/search_close_btn

    @Test
    void headerMenuTest() {
//        step("Return home", () -> {
//            $(AppiumBy.id("org.wikipedia.alpha:id/search_close_btn")).click();
//        });
        step("Click on header menu", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/view_list_card_header_menu")).click();
        });
        step("Verify menu", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/title"))
                        .shouldHave(texts("Hide this card")));
    }
}