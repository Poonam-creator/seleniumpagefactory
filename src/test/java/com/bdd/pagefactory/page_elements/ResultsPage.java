package com.bdd.pagefactory.page_elements;

import com.bdd.pagefactory.driver.DriverManager;
import com.bdd.pagefactory.utils.RandomnumberHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.fail;

public class ResultsPage extends DriverManager {

    public String getThumbNail(){
        return driver.findElement(By.className("current")).getText();
    }


    public String pageTitle(){
        return driver.findElement(By.className("pageTitle")).getText();
    }

    public String selectAnyProduct(){
        List<WebElement> elementList = driver.findElements(By.className("productTitle"));
        if(elementList.size() == 0){
            fail("no product found for" + HomePage.searchitem );
        }
        int productCount = elementList.size();
        int randomNumber = new RandomnumberHelper().randomNumberGenerator(productCount);
        String selectedProduct = elementList.get(randomNumber).getText();
        elementList.get(randomNumber).click();
        return selectedProduct;
    }

    public void selectPrice(String priceRange){
        int counter = 0;
        List<WebElement> priceList = driver.findElements(By.className("dc-checkbox-label"));
        for(WebElement pricelists : priceList){
            if(pricelists.getText().equalsIgnoreCase(priceRange)){
                counter++;
                pricelists.click();
                break;
            }
        }
        if(counter == 0){
            fail("no product available for" + priceRange);
        }
        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        }
    public List<Double> getAllProductPrtices() {
        List<Double> collectedprices = new ArrayList<Double>();

        List<WebElement> priceWebelements = driver.findElements(By.cssSelector(".price"));
        for (WebElement pricewebelement : priceWebelements) {
            String priceInString = pricewebelement.getText().replace("£", "");
            Double priceInDouble = Double.parseDouble("priceInString");
            collectedprices.add(priceInDouble);
        }
        if(collectedprices.size() == 0){
            fail("nothing collected may be price = 0");
        }
            return collectedprices;}
    }

