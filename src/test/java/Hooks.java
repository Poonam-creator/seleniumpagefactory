import com.bdd.pagefactory.driver.DriverManager;
import org.junit.Before;

public class Hooks {

    DriverManager driverManager = new DriverManager();

    @Before
    public void setUp(){
        driverManager.openBrowser();
    }
   // @After
    public void tearDown(){
        driverManager.closeBrowser();
    }

}
