import io.dropwizard.setup.Bootstrap;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import javax.ws.rs.client.Client;

/**
 * Created by andrei on 03/11/15.
 */
public class App extends Application<PhonebookConfiguration> {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main( String[] args ) throws Exception{
        new App().run(args);
    }

    @Override
    public void initialize(Bootstrap<PhonebookConfiguration> b) {}

    @Override
    public void run(PhonebookConfiguration configuration, Environment environment) throws Exception {
        logger.info("Method App#run() called");
        final Client client = new JerseyClientBuilder().build();

        environment.jersey().register(new ClientResource(client));
        environment.jersey().register(new ContactResource(environment.getValidator()));
    }
}
