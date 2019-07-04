package edu.apium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class GmailTest {

    private AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.1");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Lenovo A2010-a");
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testExample() {
        driver.get("https://www.gmail.com");
        WebElement username = driver.findElement(By.name("Email"));
        username.sendKeys("orest.zhmurkevych.secondary@gmail.com");
        WebElement password = driver.findElement(By.name("Passwd"));
        password.sendKeys("passwordfortest");
        WebElement signIn = driver.findElement(By.name("signIn"));
        signIn.click();
    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
    }
}