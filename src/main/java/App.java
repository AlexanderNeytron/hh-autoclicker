import config.Config;
import config.DriverFactory;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.MainPage;
import utils.UrlBuilder;

public class App {
    public static void main(String[] args) {
        WebDriver driver = new DriverFactory().create();
        Config config = new Config();
        UrlBuilder urlBuilder = new UrlBuilder();
        String url = urlBuilder.buildSearchUrl(config);
        driver.get(url);
        LoginPage loginPage = new LoginPage();
        loginPage.clickButton(driver);
    }
}
