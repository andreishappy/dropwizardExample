package app;

import com.google.common.base.Optional;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.PrincipalImpl;
import io.dropwizard.auth.basic.BasicCredentials;

import java.security.Principal;

/**
 * Created by andrei on 05/11/15.
 */
public class PhonebookAuthenticator implements  Authenticator<BasicCredentials, PrincipalImpl> {
    @Override
    public Optional<PrincipalImpl> authenticate(BasicCredentials credentials) throws AuthenticationException {
        if (credentials.getUsername().equals("andy") && credentials.getPassword().equals("andy")) {
            PrincipalImpl principal = new PrincipalImpl(credentials.getUsername());
            return Optional.fromNullable(principal);
        }

        return Optional.absent();
    }
}