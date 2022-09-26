package com.webFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.Locale;

public class Web extends baseClass{
    WebDriver driver;
    public WebDriver getDriver() throws IOException {
        driver = null;
        String browser = getProperty("browser");

        System.out.println("##################"+System.getProperty("os.name")+"########################");
        switch (browser){
            case "chrome":
                if (System.getProperty("os.name").toLowerCase().contains("windows")){
                    System.setProperty("webdriver.chrome.driver",getProperty("webdriver.chrome.driver.win"));
                }
                else if (System.getProperty("os.name").toLowerCase().contains("linux")){
                    System.setProperty("webdriver.chrome.driver",getProperty("webdriver.chrome.driver.lin"));
                }

                driver = new ChromeDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver",getProperty("webdriver.chrome.driver"));
                driver = new ChromeDriver();
                break;
        }
        return driver;

    }

    public void launchUrl(String url) throws IOException {
        driver = getDriver();
        driver.get(url);
    }

    public void quitDriver() throws IOException {
        driver.quit();
    }

}
