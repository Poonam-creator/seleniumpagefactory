import com.bdd.pagefactory.driver.DriverManager;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

    DriverManager driverManager = new DriverManager();

    @Before
    public void setUp(){
        driverManager.openBrowser();
    }
    @After
    public void tearDown(){
        driverManager.closeBrowser();
    }

}
