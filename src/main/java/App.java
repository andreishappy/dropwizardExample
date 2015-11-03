import io.dropwizard.setup.Bootstrap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;

/**
 * Created by andrei on 03/11/15.
 */
public class App extends Application<Configuration> {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main( String[] args ) throws Exception{
        new App().run(args);
    }

    @Override
    public void initialize(Bootstrap<Configuration> b) {}

    @Override
    public void run(Configuration configuration, Environment environment) throws Exception {
        logger.info("Method App#run() called");
        System.out.println( "Hello world, by Dropwizard!" );
    }
}
