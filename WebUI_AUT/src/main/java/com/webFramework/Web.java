package com.webFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.IOException;

public class Web extends baseClass{
    WebDriver driver;

    public Web(){
        //default constructor
    }

    public Web (WebDriver webDriver){
        driver = webDriver;
    }
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
            case "firefox":
                FirefoxBinary firefoxBinary = new FirefoxBinary();
                firefoxBinary.addCommandLineOptions("--headless");
                firefoxBinary.addCommandLineOptions("--no-sandbox");
                System.setProperty("webdriver.gecko.driver", getProperty("webdriver.gecko.driver"));
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setBinary(firefoxBinary);
                driver = new FirefoxDriver(firefoxOptions);
                break;
            default:
                System.setProperty("webdriver.chrome.driver",getProperty("webdriver.chrome.driver"));
                driver = new ChromeDriver();
                break;
        }
        return driver;

    }


}
