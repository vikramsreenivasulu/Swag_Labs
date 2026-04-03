package Utility;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClass {

    public static String url = "https://www.saucedemo.com/";
    public static WebDriver driver;

    public static void startDriver() {

        ChromeOptions options = getChromeOptions();
        driver = new ChromeDriver(options);

        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
    }

    // ✅ Missing method add chesam
    public static ChromeOptions getChromeOptions() {

        ChromeOptions options = new ChromeOptions();

        options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
        options.setExperimentalOption("useAutomationExtension", false);

        options.addArguments("--disable-autofill");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");
        options.addArguments("--ignore-ssl-errors=yes");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-translate");

        Map<String, Object> prefs = new HashMap<>();

        // already you added
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);

        // 🔥 ADD THESE (important)
        prefs.put("profile.password_manager_leak_detection", false);
        prefs.put("profile.default_content_setting_values.notifications", 2);

        options.setExperimentalOption("prefs", prefs);

        return options;
    }

	public static void Sleep() throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(2000);
	}
}