package com.bdd.pagefactory.step_def;

import com.bdd.pagefactory.page_elements.HomePage;
import com.bdd.pagefactory.page_elements.ResultsPage;
import cucumber.api.java.en.*;

import static com.bdd.pagefactory.page_elements.HomePage.searchitem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Searchsteps {
    HomePage homePage = new HomePage();
    ResultsPage resultsPage = new ResultsPage();

    @Given("^I am on homepage$")
    public void i_am_on_homepage() {
        homePage.openBrowser();
        String actualUrl = homePage.getUrl();
        assertThat(actualUrl,is(endsWith("/gbuk/index.html")));
          }

    @When("^I search for \"([^\"]*)\"$")
    public void i_search_for(String searchitem) {
        homePage.search(searchitem);
       }


    @Then("^I can see desire products$")
    public void i_can_see_desire_products() {
        String actual = homePage.getUrl();
        String thumbnail = resultsPage.getThumbNail();
        System.out.println(actual);
        assertThat(thumbnail,is(equalToIgnoringCase(searchitem)));

    }
    @Then("^I can filter priceRange$")
    public void i_can_filter_priceRange()  {
        resultsPage.selectPrice("£299.00 - £499.00");
        }

    @Then("^select any product$")
    public void select_any_product()  {
        resultsPage.selectAnyProduct();
    }

}
