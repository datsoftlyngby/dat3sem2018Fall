package rest;

import restexception.NoPersonException;
import facade.FacadePerson;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Person;
import entity.PersonDTO;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import restexception.ExceptionError;

@Path("person")
public class RESTPerson
{
    @Context
    private UriInfo uriInfo;
    @Context
    private ServletContext servletContext;

    Gson gson;
    FacadePerson fp = new FacadePerson(Persistence.createEntityManagerFactory("jpapu"));
    
    public RESTPerson()
    {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersons()
    {
        String json = gson.toJson(fp.getPersons());
        
        return Response.ok(json).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postPerson(String json)
    {
        Person p = gson.fromJson(json, Person.class);
        fp.addPerson(p);
        return Response.ok(json).build();
    }
    
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePerson(String json)
    {
        Person p = gson.fromJson(json, Person.class);
        
        if(fp.deletePerson(p) != null)
        {
            return Response.ok(json).build();
        }
        else
        {
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity("{}").build();
        }        
    }
    
    @Path("{firstName}/{lastName}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPerson(String json, @PathParam("firstName") String firstName, @PathParam("lastName") String lastName)
    {
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        
        PersonDTO pdto = fp.getPerson(person);
        
        if(pdto != null)
        {
           return Response.ok(gson.toJson(pdto)).build();
        }
        else
        {
            // 0
            //return Response.status(Response.Status.NOT_ACCEPTABLE).entity("{}").build();
            
            // 1
            //throw new WebApplicationException(Response.status(406).entity("{\"message\":\"There is no person\"}").build());
            //throw new NoPersonException("{\"message\":\"There is no person\"}");
            
            // 2
            try
            {
                throw new NumberFormatException("Number must be an integer");
            }
            catch(NumberFormatException e)
            {
                ExceptionError ee = new ExceptionError(e, 500, servletContext.getInitParameter("debug").equals("true"));
                String eejson = gson.toJson(ee);
                return Response.status(500).entity(eejson).build();  
            }
            
            // 3
            //throw new RuntimeException("Some runtime exception occured");                       
        }       
    }    
}