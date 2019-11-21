package com.bdd.pagefactory.page_elements;

import com.bdd.pagefactory.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends DriverManager {
    public static String searchitem;


    public void search(String item){

    searchitem = item;
    entersearchitem(item);
    clickonbutton();

    }

   // @FindBy(id = "search")
    private WebElement boxsearchtxt;

    public void entersearchitem(String item){
       // boxsearchtxt.sendKeys(item);
        driver.findElement(By.id("search")).sendKeys(item);

    }

   // @FindBy(css = ".dc-search-fieldset__submit-button")
    private WebElement clickbtn;

    public void clickonbutton()
    {
        driver.findElement(By.cssSelector(".dc-search-fieldset__submit-button")).click();
       // clickbtn.click();
    }
}
