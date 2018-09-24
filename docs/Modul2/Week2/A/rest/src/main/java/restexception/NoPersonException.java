package restexception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class NoPersonException extends WebApplicationException
{
    public NoPersonException(String message)
    {
        super(Response.status(406).entity(message).build());
    }
    
}
