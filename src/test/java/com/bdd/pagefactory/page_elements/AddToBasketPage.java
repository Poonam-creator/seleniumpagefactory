package com.bdd.pagefactory.page_elements;

import com.bdd.pagefactory.driver.DriverManager;
import org.openqa.selenium.By;

public class AddToBasketPage extends DriverManager {

    public String productInBasket(){
        return driver.findElement(By.className("productTitle")).getText();
    }

}
