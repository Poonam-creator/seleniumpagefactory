import com.bdd.pagefactory.page_elements.AddToBasketPage;
import com.bdd.pagefactory.page_elements.HomePage;
import com.bdd.pagefactory.page_elements.ProductDescriptionPage;
import com.bdd.pagefactory.page_elements.ResultsPage;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class RegressionTestsSuits extends Hooks {
    HomePage homePage = new HomePage();
    ResultsPage resultsPage = new ResultsPage();
    ProductDescriptionPage productDescriptionPage = new ProductDescriptionPage();
    AddToBasketPage addToBasketPage = new AddToBasketPage();

    public void seachProductTest(){

        homePage.openBrowser();
        homePage.search("Laptops");
        String actualurl = homePage.getUrl();
        Assert.assertEquals
                ("https://www.currys.co.uk/gbuk/search-keywords/xx_xx_xx_xx_xx/cables/xx-criteria.html", actualurl);
    }


    public void selectDepFrmSuggetionsTest(){
        String searchterm = "cables";
        homePage.search(searchterm);
        homePage.selectDepartmentFromSuggetions(searchterm);
        resultsPage.getThumbNail();
       String actualTitle =  resultsPage.pageTitle();
       Assert.assertEquals("cables",actualTitle);
    }
    @Test
    public void selectPrdctFrmSuggetionsTest(){
        //homePage.openBrowser();
        String searchterm = "cables";
        homePage.search(searchterm);
        homePage.selectProductFromSuggetions(searchterm);
        String actual = resultsPage.getThumbNail();

        Assert.assertEquals("cables",actual);

    }
    @Test
    public void selectPriceTest(){
        String priceRange = "£499.00 - £699.00";
        List<String> expectedList = Arrays.asList(priceRange.replace("£","").split("-"));
        Double min = Double.parseDouble(expectedList.get(0));
        Double max = Double.parseDouble(expectedList.get(1));

        homePage.search("Laptops");
        String actual = resultsPage.getThumbNail();
        resultsPage.selectPrice(priceRange);
        resultsPage.selectAnyProduct();
        productDescriptionPage.addToBasket();
        productDescriptionPage.continueToBasket();
        addToBasketPage.productInBasket();
        Assert.assertEquals("Laptops",actual);

    }


}
