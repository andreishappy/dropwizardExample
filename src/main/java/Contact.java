import com.fasterxml.jackson.annotation.JsonIgnore;
import io.dropwizard.validation.ValidationMethod;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by andrei on 04/11/15.
 */
public class Contact {

    private final int id;

    @NotBlank
    @Length(min = 1, max = 10)
    private final String firstName;

    @NotBlank
    private final String lastName;

    @NotBlank
    private final String phone;

    public Contact() {
        this.id = 0;
        this.firstName = null;
        this.lastName = null;
        this.phone = null;
    }

    public Contact(
            int id,
            String firstName,
            String lastName,
            String phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }


    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    @ValidationMethod(message = "John Doe is not a valid person!")
    @JsonIgnore
    public boolean isValidPerson() {
        return !(firstName.equals("John") && lastName.equals("Doe"));
    }
}
