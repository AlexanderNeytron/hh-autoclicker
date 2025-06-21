package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;

import java.util.List;

@Slf4j
public class MainPage {
    private final String button = "a[data-qa='vacancy-serp__vacancy_response']";

    public MainPage clickButton(WebDriver driver, int maxClicks) {
        int clicks = 0;
        int scroll = 0;
        List<WebElement> buttons = driver.findElements(By.cssSelector(button));
        log.info("Найдено кнопок: {}", buttons.size());
        for (WebElement button : buttons) {
            if (clicks >= maxClicks) break;
            try {
                if (button.isDisplayed() && button.isEnabled()) {
                    button.click();
                    clicks++;
                    log.info("Клик по кнопке {}", clicks);
                    Thread.sleep(5000);
                }
            } catch (ElementClickInterceptedException | StaleElementReferenceException e) {
                continue;
            } catch (Exception e) {
                log.info("Ошибка при клике" + e.getMessage());
            }
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 1000)");
            scroll++;
            if (scroll > 10) break;
        }
        return this;
    }
}
