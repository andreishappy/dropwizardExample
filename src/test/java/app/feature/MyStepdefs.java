package app.feature;

import app.RunCukesTest;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import javax.ws.rs.core.Response;

import static app.RunCukesTest.RULE;

/**
 * Created by andrei on 06/11/2015.
 */
public class MyStepdefs {
    private Response lastResponse;

    @Before
    public void setUp() {
        System.out.println("Trying to start server");
        System.out.println("hello");
        RULE.getTestSupport().before();
        System.out.println("After access");
    }


    @When("^I try to create a new user with the name: (.+)$")
    public void createUser(String name) {
    }


    @Then("^The request succeeds$")
    public void theRequestSucceeds() throws Throwable {
    }
}
