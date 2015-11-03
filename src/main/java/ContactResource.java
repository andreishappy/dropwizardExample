import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by andrei on 03/11/15.
 */

@Path("/contact")
@Produces(MediaType.APPLICATION_JSON)
public class ContactResource {

    @GET
    @Path("/{id}")
    public Response getContact(@PathParam("id") int id) {
        String payload = "{ contact_id: " + id + ", name: \"Dummy Name\", phone: \"70968584783\" }";
        return Response
                .ok(payload)
                .build();
    }

    @POST
    public Response createContact(
            @FormParam("name") String name,
            @FormParam("phone") String phone) {
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
            @PathParam("id") String id,
            @FormParam("name") String name,
            @FormParam("phone") String phone) {
        return Response
                .ok("{contact_id: "+ id +", name: \""+ name +"\",phone: \""+ phone +"\" }")
                .build();
    }
}
