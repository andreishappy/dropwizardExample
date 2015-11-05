import org.glassfish.jersey.client.ClientResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by andrei on 04/11/15.
 */
@Produces(MediaType.APPLICATION_JSON)
@Path("/client")
public class ClientResource {
    private final Client client;

    public ClientResource(Client client) {
        this.client = client;
    }

    @GET
    @Path("/showContact/{id}")
    public String showContact(@QueryParam("id") int id) {
        WebTarget contactResource = client.target("http://localhost:8080/contact/" + id);
        Contact c = contactResource.request().get(Contact.class);
        String output = "ID: "+ id
                +"\nFirst name: " + c.getFirstName()
                + "\nLast name: " + c.getLastName()
                + "\nPhone: " + c.getPhone();
        return output;
    }

    @GET
    @Path("/newContact")
    public Response newContact(@QueryParam("firstName") String firstName, @QueryParam("lastName") String lastName, @QueryParam("phone") String phone) {
        WebTarget contactResource = client.target("http://localhost:8080/contact/");
        Response response = contactResource.request(MediaType.APPLICATION_JSON).post(Entity.entity(new Contact(0, firstName, lastName, phone), MediaType.APPLICATION_JSON_TYPE));

        if (response.getStatus() == 201) {
            // Created
            return Response.status(302).entity("The contact was created successfully! The new contact can be found at " + response.getHeaders().getFirst("Location")).build();
        }
        else {
            // Other Status code, indicates an error
            return Response.status(422).entity(response).build();
        }
    }

    @GET
    @Path("/deleteContact/{id}")
    public Response deleteContact(@QueryParam("id") int id) {
        WebTarget contactResource = client.target("http://localhost:8080/contact/" + id);
        contactResource.request().delete();
        return Response.noContent().entity("Contact was deleted!").build();
    }
}
