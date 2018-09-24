package restexception;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class RuntimeExceptionMapper implements ExceptionMapper<RuntimeException>
{
    @Context
    ServletContext context;
    
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
    @Override
    public Response toResponse(RuntimeException e)
    {
        boolean debug = context.getInitParameter("debug").equals("true");
        
        ExceptionError ee = new ExceptionError(e, 404, debug);
        ee.setDescription("Tried to call...");
        ee.setMessage("internal server problem, very sorry");
        
        return Response.status(404).entity(gson.toJson(ee)).type(MediaType.APPLICATION_JSON).build();
    }
    
}
