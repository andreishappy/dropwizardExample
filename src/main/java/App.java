import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;

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

        // Create a DBI factory and build a JDBI instance
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory
                .build(environment, configuration.getDataSourceFactory(), "mysql");
        // Add the resource to the environment
        environment.jersey().register(new ContactResource(jdbi));
    }
}
