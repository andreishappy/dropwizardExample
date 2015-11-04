import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by andrei on 03/11/15.
 */

@Path("/contact")
@Produces(MediaType.APPLICATION_JSON)
public class ContactResource {
    private final Validator validator;

    public ContactResource(Validator validator) {
        this.validator = validator;
    }

    @GET
    @Path("/{id}")
    public Response getContact(@PathParam("id") int id) {
        return Response
                .ok(new Contact(1, "Andy", "Peters", "00123012"))
                .build();
    }

    @POST
    public Response createContact(Contact contact) {
        Set<ConstraintViolation<Contact>> violations = validator.validate(contact);
        if (violations.size() > 0) {
            ArrayList<String> validationMessages = new ArrayList<>();
            for (ConstraintViolation<Contact> violation : violations) {
                validationMessages.add(violation.getPropertyPath().toString() + ": " + violation.getMessage());
            }

            return Response
                    .status(Status.BAD_REQUEST)
                    .entity(validationMessages)
                    .build();
        }
        return Response
                .created(null)
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteContact(
            @PathParam("id") int id) {
        return Response
                .noContent()
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response updateContact(
            @PathParam("id") int id,
            @FormParam("firstName") String firstName,
            @FormParam("lastName") String lastName,
            @FormParam("phone") String phone) {
        return Response
                .ok(new Contact(id, firstName, lastName, phone))
                .build();
    }
}
