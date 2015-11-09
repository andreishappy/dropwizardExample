package app;

import cucumber.api.junit.Cucumber;
import io.dropwizard.testing.junit.DropwizardAppRule;
import org.junit.After;
import org.junit.ClassRule;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(Cucumber.class)
public class RunCukesTest {
    private final static Logger logger = LoggerFactory.getLogger(RunCukesTest.class);

    @ClassRule
    public static final DropwizardAppRule RULE = new DropwizardAppRule(App.class, "config.yml");

    @After
    public void tearDown(){
        logger.info("Stopped Dropwizard Jetty Test Server");
        RunCukesTest.RULE.getTestSupport().after();
    }
}