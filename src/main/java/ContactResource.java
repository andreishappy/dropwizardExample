import org.eclipse.jetty.server.Authentication;
import org.skife.jdbi.v2.DBI;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;

/**
 * Created by andrei on 03/11/15.
 */

@Path("/contact")
@Produces(MediaType.APPLICATION_JSON)
public class ContactResource {
    private final ContactDAO contactDAO;

    public ContactResource(DBI jdbi) {
        contactDAO = jdbi.onDemand(ContactDAO.class);
    }


    @GET
    @Path("/{id}")
    public Response getContact(@PathParam("id") int id) {
        System.out.println("Called getContact");
        System.out.println(contactDAO);
        System.out.println(id);
        Contact contact = contactDAO.getContactById(id);
        System.out.println("Contact gotten");
        if (contact != null) {
            return Response
                    .ok(contact)
                    .build();
        } else {
            return Response
                    .noContent()
                    .build();
        }
    }

    @POST
    public Response createContact(Contact contact) throws URISyntaxException {
        return Response.ok().build();
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
    public Response updateContact(@PathParam("id") int id, Contact contact) {
        return Response
                .ok(new Contact(id, contact.getFirstName(), contact.getLastName(), contact.getPhone()))
                .build();
    }
}
