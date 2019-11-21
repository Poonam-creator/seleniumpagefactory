package com.bdd.pagefactory.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class DriverManager {

    public static WebDriver driver;

    public DriverManager(){
        PageFactory.initElements(driver , this);
    }
    public void openBrowser(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.currys.co.uk/gbuk/index.html");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(5000,TimeUnit.SECONDS);

    }

    public void closeBrowser(){
        driver.quit();
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }
}
