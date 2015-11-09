package app.feature;

import app.RunCukesTest;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static app.RunCukesTest.RULE;

import static org.junit.Assert.assertEquals;

/**
 * Created by andrei on 06/11/2015.
 */
public class MyStepdefs {
    private Response response;

    @Before
    public void setUp() {
        System.out.println("Trying to start server");
        System.out.println("hello");
        RULE.getTestSupport().before();
        System.out.println("After access");
    }


    @When("^I try to create a new user with the name: (.+)$")
    public void createUser(String name) {
        Client client = ClientBuilder.newClient();
        String targetURL = "http://localhost:8080/contact/1";
        Invocation.Builder invocationBuilder = client.target(targetURL).request(MediaType.APPLICATION_JSON_TYPE);
        response = invocationBuilder.get();
    }


    @Then("^The request succeeds$")
    public void theRequestSucceeds() throws Throwable {
        assertEquals(response.getStatus(), 200);
    }
}
