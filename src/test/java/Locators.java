import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class Locators {
    //Test Case 1: Movie Title Check
    public static By movieTitleMainPage =new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Deadpool & Wolverine\")");
    public static By movieTitleMoviePage =new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Deadpool & Wolverine\")");
    public static By backButtonMoviePage =new AppiumBy.ByAndroidUIAutomator("new UiSelector().className(\"android.widget.Button\").instance(0)");

    //Test case 2: Release date
    public static By menuFilterButton =new AppiumBy.ByAndroidUIAutomator("new UiSelector().className(\"android.widget.Button\").instance(2)");
    public static By releaseDateRatioButton =new AppiumBy.ByAndroidUIAutomator("new UiSelector().className(\"android.widget.RadioButton\").instance(5)");
    public static By exitMenuFilterButton =new AppiumBy.ByAndroidUIAutomator("new UiSelector().className(\"android.widget.Button\").instance(0)");
    public static By firstMovieReleaseDate =new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"2031-12-17\")");
    public static By resetFiltersButton =new AppiumBy.ByAndroidUIAutomator("new UiSelector().className(\"android.widget.Button\").instance(1)");

}
