import org.openqa.selenium.WebDriver;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class TestUniqueMehdi {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",   "./chromedriver.exe");
        Map<String, Object> prefs = new HashMap<>();
        // permet tous les cookies pour Chrome, en deux étapes :
        // 1 - allow all cookies
        prefs.put("profile.default_content_setting_values.cookies", 1);
        // 2 - bloque seulement les cookies tiers : non
        prefs.put("profile.block_third_party_cookies", false);
        // Meme chose, pour Firefox
        prefs.put("network.cookie.cookieBehavior", 0);
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("window-size=1920x1080", "--headless");
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }


    @Test
    @DisplayName("Test unique Mehdi")
    public void TestUniqueMehdi() {
        driver.get("http://www.google.fr");
        driver.manage().window().maximize();
        }
}
