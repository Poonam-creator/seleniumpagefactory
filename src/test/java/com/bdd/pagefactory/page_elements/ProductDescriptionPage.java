package com.bdd.pagefactory.page_elements;

import com.bdd.pagefactory.driver.DriverManager;
import org.openqa.selenium.By;

public class ProductDescriptionPage extends DriverManager {
    public void addToBasket(){
        driver.manage().deleteAllCookies();
        driver.findElement(By.className("Button-hYXUXp fIBPaH")).click();
    }

    public void continueToBasket(){
        driver.findElement(By.className("Button-hYXUXp sc-htoDjs fFDyiO")).click();
    }
}
