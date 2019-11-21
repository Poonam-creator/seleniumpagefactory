import com.bdd.pagefactory.page_elements.HomePage;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

public class RegressionTestsSuits {
    HomePage homePage = new HomePage();
   // HomePage homePage = PageFactory.initElements(driver,HomePage.class);

    @Test
    public void seachProduct(){
        homePage.openBrowser();
        homePage.search("Laptops");
    }
}
