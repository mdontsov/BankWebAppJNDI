package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    protected WebDriver webDriver;

    public DriverFactory() {
        System.setProperty("webdriver.chrome.driver", "bin/chromedriverWIN.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--dns-prefetch-disable");
        webDriver = new ChromeDriver(chromeOptions);
        webDriver.manage().window().maximize();
    }
}