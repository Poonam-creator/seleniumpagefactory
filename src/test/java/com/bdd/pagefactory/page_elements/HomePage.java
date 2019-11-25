package com.bdd.pagefactory.page_elements;

import com.bdd.pagefactory.driver.DriverManager;
import com.bdd.pagefactory.utils.RandomnumberHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static junit.framework.TestCase.fail;

public class HomePage extends DriverManager {

   // @FindBy(id = "search")
    private WebElement boxsearchtxt;

   // @FindBy(css = ".dc-search-fieldset__submit-button")
    private WebElement clickbox;


    public static String searchitem;


    public void search(String item){
     driver.findElement(By.id("search")).clear();
     driver.findElement(By.id("search")).clear();
    searchitem = item;
    entersearchitem(item);
    clickonbutton();

    }


    public void entersearchitem(String item){
       // boxsearchtxt.sendKeys(item);
        driver.findElement(By.id("search")).sendKeys(item);
    }



    public void clickonbutton()
    {
       driver.findElement(By.cssSelector(".dc-search-fieldset__submit-button")).click();
       // clickbox.click();
    }


    public void selectDepartmentFromSuggetions(String item){
        driver.findElement(By.className("dc-search-suggestions__suggestion dc-search-suggestions__suggestion--term"));
    }

    public void selectProductFromSuggetions(String item){
        driver.findElement(By.className("dc-search-suggestions__suggestion dc-search-suggestions__suggestion--sayt\""));
    }

    public void selectPrdctFrmSuggetions(String item , By by){
        List<WebElement> suggetions = driver.findElements(by);
        int listsize = suggetions.size();
        if(listsize == 0){
            fail("no product in suggetions");}
        int randomIndex = new RandomnumberHelper().randomNumberGenerator(listsize);
        WebElement selectedElement = suggetions.get(randomIndex);
        String selectedSuggetion = selectedElement.getText();
        selectedElement.click();
    }

}
