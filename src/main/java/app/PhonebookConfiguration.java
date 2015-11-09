package app;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.Max;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;


/**
 * Created by andrei on 03/11/15.
 */
public class PhonebookConfiguration extends Configuration {
    @JsonProperty
    @NotEmpty
    private String message;

    @JsonProperty
    @Max(10)
    private int messageRepetitions;

    @JsonProperty
    private String additionalMessage = "This is optional";

    public String getMessage() {
        return message;
    }

    public int getMessageRepetitions() {
        return messageRepetitions;
    }

    public String getAdditionalMessage() {
        return additionalMessage;
    }
}
