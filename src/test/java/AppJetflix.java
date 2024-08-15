import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;

public class AppJetflix {

    AndroidDriver driver;
    AppiumDriverLocalService service;

    @BeforeTest
    public void Start() throws MalformedURLException {
        service = new AppiumServiceBuilder().usingPort(4723).withIPAddress("0.0.0.0").build();
        service.start();

        URI uri = URI.create("http://0.0.0.0:4723");
        URL url = uri.toURL();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setDeviceName("sdk_gphone64_arm64");
        options.setApp(System.getProperty("user.dir") + "/Apps/app-debug.apk");
        options.setCapability("waitPluginTimeout", Duration.ofSeconds(10));

        driver = new AndroidDriver(url, options);
    }

    @Test
    public void scenarioMovieTitle(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement movieElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.movieTitleMainPage));
        String movieNameHomeScreen = movieElement.getText();
        movieElement.click();

        WebElement movieNameDetailsElement = driver.findElement(Locators.movieTitleMoviePage);
        String movieNameDetailsScreen = movieNameDetailsElement.getText();

        Assert.assertEquals(movieNameHomeScreen, movieNameDetailsScreen, "Movie name does not match!");
        WebElement backButton =driver.findElement(Locators.backButtonMoviePage);
        backButton.click();

    }

    @Test
    public void scenarioReleaseDate() {
        LocalDate currentDate = LocalDate.now();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement menuFilter = wait.until(ExpectedConditions.elementToBeClickable(Locators.menuFilterButton));
        menuFilter.click();

        WebElement releaseDateOption = wait.until(ExpectedConditions.elementToBeClickable(Locators.releaseDateRatioButton));
        releaseDateOption.click();

        WebElement exitFilter = driver.findElement(Locators.exitMenuFilterButton);
        exitFilter.click();

        WebElement releaseDate =driver.findElement(Locators.firstMovieReleaseDate);
        LocalDate movieReleaseDate =LocalDate.parse(releaseDate.getText());

        Assert.assertTrue(currentDate.isBefore(movieReleaseDate),"Movie already released!");

        menuFilter.click();
        WebElement resetButton=driver.findElement(Locators.resetFiltersButton);
        resetButton.click();
        exitFilter.click();

    }


    @AfterTest
    public void Finish() {
        if (driver != null) {
            driver.quit();
        }
        service.stop();
    }
}
