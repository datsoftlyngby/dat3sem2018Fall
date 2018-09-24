# Restful webservices
[Github project with full project code for all examples](https://github.com/HartmannDemoCode/Sem3/tree/master/restDemo)  

[Gist here with some code example used in this text](https://gist.github.com/Thomas-Hartmann/71217b04a3c1d95702adba813aff99b2.js)   

[Get all the detailed documentation here](https://jersey.github.io/documentation/latest/jaxrs-resources.html)  

### Exercises
 * [Exercise Day1](https://docs.google.com/document/d/1IKTh5aFDzg9d3A2Kt6rRZsLAW-9PfvoXyLmyjCp0I4E/edit?usp=sharing) Basic ReSTful webservice.
  * [Exercise Day2](https://docs.google.com/document/d/1CduP9YD5wn43oxjNQ6Lo_DUQwpnv3aiu3NGGHaeV2Ec/edit?usp=sharing) REST api with DTOs
  * [Exercise Day3](https://docs.google.com/document/d/1-aBZ_BGX1LTCWFjCM_EWB7XnoUDEiWPsAam3RjyZQg0/edit?usp=sharing) Error handling
  * [StudyPoint Exercise](https://docs.google.com/document/d/1aqJx93Y9fROeYq6xbneWoBstVeDXIn00vimT0AWqaPk/edit?usp=sharing)

### Web service
A web service is a programming api that is accesible over the internet and are available 24/7.  

Web Services that conform to the REST architectural style, or RESTful web services, provide interoperability between computer systems on the Internet. REST-compliant web services allow the requesting systems to access and manipulate textual representations of web resources by using a uniform and predefined set of stateless operations. 
 
On databases we refer to CRUD operations. The equivalent operations in restful webservices are the HTTP methods POST, GET, UPDATE and DELETE.
## 5 guiding principles
REST stands for: REpresentational State Transfer  
**Representational**: Clients  possess  the  information  necessary  to  identify, modify, or delete a web resource  
**State** All resource state information is stored on the client.  
**Transfer** system state is passed from the client to the server (usualy with HTTP).  
1. **Client–server architecture**
    - The principle behind the client–server constraints is the separation of concerns. Separating the user interface concerns from the data storage concerns improves the portability of the user interface across multiple platforms. It also improves scalability by simplifying the server components. Perhaps most significant to the Web, however, is that the separation allows the components to evolve independently, thus supporting the Internet-scale requirement of multiple organizational domains
2. **Statelessness**
    - The client–server communication is constrained by no client context being stored on the server between requests. Each request from any client contains all the information necessary to service the request, and session state is held in the client. 
3. **Cacheability**
    - As on the World Wide Web, clients and intermediary routers etc. can cache responses. Responses must therefore, implicitly or explicitly, define themselves as cacheable or not to prevent clients from getting stale or inappropriate data in response to further requests. Well-managed caching partially or completely eliminates some client–server interactions, further improving scalability and performance
4. **Layered system**
    - A client cannot ordinarily tell whether it is connected directly to the end server, or to an intermediary along the way. Intermediary servers can improve system scalability by enabling load balancing and by providing shared caches. They can also enforce security policies.
5. **Uniform interface**
  - The uniform interface constraint is fundamental to the design of any REST service. It simplifies and decouples the architecture, which enables each part to evolve independently. The four constraints for this uniform interface are
    - **Resource identification in requests**
      - Individual resources are identified in requests, for example using URIs in Web-based REST systems. The resources themselves are conceptually separate from the representations that are returned to the client. For example, the server could send data from its database as HTML, XML or as JSON—none of which are the server's internal representation. The url shoulld uniquely point to a particular ressource like: `https://example.com/api/user/45` 
    - **Resource manipulation through representations**
      - The client manipulates resources through sending representations to the server usually a JSON object containing the content that it would like to add, delete, or modify. In REST, the server has full control of the resources, and is responsible for making any changes. When a client wishes to make changes to resources, it sends the server a representation of what it would like the resulting resource to look like. The server takes the request as a suggestion, but still has ultimate control.. A request for a ressource to a restful webservice could look like this: `https://someserver.com/customer/123`. By always providing the id we can uniquely identify the resource.
    - **Self-descriptive messages**
      - Each message includes enough information to describe how to process the message. For example, which parser to invoke can be specified by a media type. This is typically done using a `Media Type` like JSON, plain text, XML or HTML. 

sources [wikipedia](https://en.wikipedia.org/wiki/Representational_state_transfer) and [kevin Sookocheff](https://sookocheff.com/post/api/on-choosing-a-hypermedia-format/)
## Request examples  
Get all cars from the server:
```
GET http://example.com/cars
```  
Create a new car on the server sending some form data
```
POST http://example.com/car
Data:
    name = volvo   
    color = red 
```  
Update and existing car with id: 123 to have a new name and color
```
PUT http://example.com/car/123
Data:
    name = New  car name
    color = blue
```
Delete a car on the server with id: 123
```
DELETE http://example.com/car/123
```

## JSON response examples
###### GET (all)
The request: `GET http://example.com/cars`  
The response:  
```
{'cars': [
    {'id': 1, 'name':'volvo','color':'red'},
    {'id': 2, 'name':'vw','color':'blue'},
    ...
]}
```
###### GET (specific)
The request: `GET http://example.com/car/123`  
The response:`{'id': 123, 'name':'toyota','color':'green'}`


###### POST
The request: `POST http://example.com/car/ Data: name=volvo color=yellow`  
The response: `{'id': 124, 'name':'volvo','color':'yellow'}`  

###### PUT
The request: `PUT http://example.com/car/123 Data: name = audi  color = black`
The response: `{'id': 123, 'name':'audi','color':'black'}`  


###### DELETE  
The request: `DELETE http://example.com/car/123`  
The response: `{'id': 123, 'name':'audi','color':'black'}`
###### GET (car drivers) if car 123 has multiple drivers 
The request: `GET http://example.com/car/123/drivers`  
The response:`{'drivers': [{'id': 21, 'name':'Hanne Hassing','Phone':'22334455'},{'id': 27, 'name':'Helge Hastrup','Phone':'21324354'}]}`

### With parameters 2 ways
With query string: `http://example.com/car/123/drivers?filter=female`  

In semantic url `http://example.com/car/123/drivers/filter/female`

### HTTP status codes
The 4 levels of status codes are:
- 2xx = Success
- 3xx = Redirect
- 4xx = User error
- 5xx = Server error

##### Most common status codes
- Success codes
  - 200 - OK (the default)
  - 201 - Created
  - 202 - Accepted (often used for delete requests)
- Error codes
  - 400 - Bad Request (generic user error/bad data)
  - 401 - Unauthorized (this area requires you to log in)
  - 404 - Not Found (bad URL)
  - 405 - Method Not Allowed (wrong HTTP method)
  - 409 - Conflict (i.e. trying to create the same resource with a PUT request)
  - 500 - Generic server error.

### Practical guide in netbeans
We will use the JAX-RS specifications in java to create restful webservices in this semester. Specifically we will use the Jersey api that implements the JAX-RS specification. 

1. Create a new Maven web project in netbeans
2. Create a new package under Source Packages called e.g: "rest" 
3. Rigth click package -> New -> Other -> Web services -> Restful Web service from Pattern -> next -> 
     - Path = <name of entity to expose: eg: 'person'>
     - MIME Type = application/json
     
     -> finish.
4. Open ApplicationConfig.java -> change to class annotation to `@javax.ws.rs.ApplicationPath("api")` 
     
5. Open your new <Something>Ressource.java file and write your rest methods in here. Start implementing the GET method that is already there so it just returns a String ala: "Helle from your web service".
e.g:
```java
"{\"message\":\"Hello from Rest service\"}";
```
6. Open pom.xml and insert into the dependencies section: 
```xml
<dependency>
    <groupId>com.sun.jersey</groupId>
    <artifactId>jersey-bundle</artifactId>
    <version>1.19.4</version>
</dependency>
```
7. Clean and build project and run the project.
8. Open a browser og Postman and make a request to your ressource ala: GET `http://localhost:8084/restDemo/api/person`

### Important annotations
- @Path("somepath/in/here/{parameter}") // Can be used on both class and method level
- @GET, @POST, @PUT, @DELETE // Method level
- @Produces(MediaType.APPLICATION_JSON)  
- @Consumes(MediaType.APPLICATION_JSON)  
- @PathParam("id") int id // used inside method argument list when parameter comes from semantic url `https://example.com/api/customer/123`.   
- @QueryParam("id") int id // used inside method arugment list when paramter comes from query string `https://example.com/api/customer?id=123`.  



### API authentication (red students) 
In normal web applications, handling authentication is usually handled by accepting a username and password, and saving the user ID in the session. The user's browser saves a cookie with ID of the session. When the user visits a page on the site that requires authentication, the browser sends the cookie, the app looks up the session by the ID (if it hasn't expired), and since the user ID was saved in the session, the user is allowed to view the page.

But in restful api we store no session data on the server. Instead we can use tokenbased authentication. This is outside the scope of this class, but if you are interested you can read more [here](https://jwt.io/introduction/).

[Working with JWT using jersey](https://stackoverflow.com/questions/26777083/best-practice-for-rest-token-based-authentication-with-jax-rs-and-jersey).

## Serialization with gson
Gson is a Java library that can be used to convert Java Objects into their JSON representation. It can also be used to convert a JSON string to an equivalent Java object

##### dependency in pom.xml:
```
<dependency>
  <groupId>com.google.code.gson</groupId>
  <artifactId>gson</artifactId>
  <version>2.8.5</version>
</dependency>
```
Example java entity class for Customer:
```java
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private int age;
    ...
}
```
Then we can do:
```
Gson gson = new GsonBuilder().setPrettyPrinting().create();
...
String jsonCustomer = gson.toJson(new Customer(1,"Oluf Palme",96));
System.out.println(jsonCustomer);
```
Result: 
```
{
  "id": 1,
  "name": "Oluf Palme",
  "age": 96
}
```
## Deserialization with gson
When we get data from the client - typically as form parameters it can be send in json format to the server and can be deserialized to java objects in the following way:

```java
 public Response postCustomer(String content) {
        Customer newCustomer = gson.fromJson(content, Customer.class);
        System.out.println("newCustomer: "+newCustomer);
        addCustomer(newCustomer);
        return Response.ok().entity(gson.toJson(newCustomer)).build();
}
```
To test this use a POST request with Postman.  

## Serialization with bidirectional relationship
When we have 2 java classes that has a reference to each other we have a bidirectional relationship. Eg. an employee and a project. An employee can be assigned to many projects and a project can have many imployess.  
In the **Employee.java** code:
```java
private List<Project> projects;
```  

and in the **Project.java** code:
```java
private List<Employee> employees;
```  
##### The Problem
The above scenario makes it difficult to serialize the object collections to json. 

This is because when going through the list of **employees** writing out every instanse field to text, then we reach a list of **projects** and going through the **projects** in the list we hit the list of **employees** and when going through that we get to the list of **projects** and ... so it goes forever and ever and ever....

Even if it is just a single object reference we get in trouble like a Customer that has a reference to a City and a City that has a collection of customers.

```
Exception in thread "main" Exception in thread "main" java.lang.StackOverflowError
	at com.google.gson.stream.JsonWriter.writeDeferredName(JsonWriter.java:401)
	at com.google.gson.stream.JsonWriter.value(JsonWriter.java:527)
	at com.google.gson.internal.bind.TypeAdapters$7.write(TypeAdapters.java:232)
	at com.google.gson.internal.bind.TypeAdapters$7.write(TypeAdapters.java:217)
	at com.google.gson.internal.bind.TypeAdapterRuntimeTypeWrapper.write(TypeAdapterRuntimeTypeWrapper.java:69)
	at com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$1.write(ReflectiveTypeAdapterFactory.java:125)
	at com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$Adapter.write(ReflectiveTypeAdapterFactory.java:243)
	at com.google.gson.internal.bind.TypeAdapterRuntimeTypeWrapper.write(TypeAdapterRuntimeTypeWrapper.java:69)
	at com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$1.write(ReflectiveTypeAdapterFactory.java:125)
	at com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$Adapter.write(ReflectiveTypeAdapterFactory.java:243)
	at com.google.gson.Gson$FutureTypeAdapter.write(Gson.java:976)
    ...
```
##### The solution
Break the chain!  
One way to do this is by designing specific DTOs (Data Transfer Object) that can wrap the data in the Customer and City objects and create a text representations of e.g. the City instead of the object reference that exists in the original Customer class.  
See the full CustomerDTO class and a tester method in the [gist here](https://gist.github.com/Thomas-Hartmann/71217b04a3c1d95702adba813aff99b2.js)

```java
public class CustomerDTO {
    private Integer id;
    private String name;
    private int age;
    private String city; //Changed type here from City to String

    public CustomerDTO(Customer customer) {
        this.name = customer.getName();
        this.age = customer.getAge();
        this.city = customer.getCity().getName(); //HERE WE BREAK
    }
```
##### Second solution
Mark a field that we do not want to include as part of the object serialization with the keyword `transient`. This means that it will be ignored in the serialization process. In our previous example we could use it in the City class to mark the customer list like this: 

```java
@OneToMany(cascade = CascadeType.ALL, mappedBy = "city")
private transient List<Customer> customerList = new ArrayList();
``` 
The result would be that when serialization runs it will skip this field and we would be able to serialize our customer object without the stackoverflow exception.

## Errorhandling
A rest api fail because 1 of 2 things happend
1. a client makes a request to server, that it does not know how to handle
    - Like a non-existing uri
    - wrong content type
    - wrong HTTP method
    - etc
2. The server throws an exception like NullPointerException or CustomerNotFoundException etc.  

In case of 1: return a 4xx error  
In case of 2: return a 5xx error   

### Change java exceptions to json response
3 different ways to do it
1. (green) Using the build-in JAX-RS Exception: 'WebApplicationException'  
2. (yellow) Creating an Exception DTO and use gson to parse it to json fomat  
3. (red) Use an ExceptionMapper

##### 1 Using the WebApplicationException
```java
@GET
    @Path("/test/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer getCustomer(@PathParam("id") int id) {
        Customer cust = findCustomer(id);
        if (cust == null){
           throw new WebApplicationException(Response.Status.NOT_FOUND); //look for 404 not found in the browsers network tab.
        }
        return cust;
    }
```
It is of cause possible to extend the WebApplicationException in order to reflect specific errors ala:  

```java
public class CustomNotFoundException extends WebApplicationException {
 
  /**
  * Create a HTTP 404 (Not Found) exception.
  */
  public CustomNotFoundException() {
    super(Responses.notFound().build());
  }
 
  /**
  * Create a HTTP 404 (Not Found) exception.
  * @param message the String that is the entity of the 404 response.
  */
  public CustomNotFoundException(String message) {
    super(Response.status(Responses.NOT_FOUND).
    entity(message).type("text/plain").build());
  }
}
```
##### 2 Create an Exception DTO
```java
public class ExceptionDTO {
    private int code;
    private String message;
    private String description;
    private String stackTrace;
    public ExceptionDTO(Throwable ex, int code, boolean debug) {
        this.code = code;
        this.message = ex.getMessage();
        this.description = ex.getMessage();
        if (debug) {
            StringWriter sw = new StringWriter();
            ex.printStackTrace(new PrintWriter(sw));
            this.stackTrace = sw.toString();
        }
    }
}
```  
And use it like this:  
```java
@GET
    @Path("/test/ex")
    @Produces(MediaType.APPLICATION_JSON)
    public String testExceptionDTO() {
        try {
            throw new NumberFormatException("Number must be an integer");
        } catch (NumberFormatException e) {
            ExceptionDTO exDTO = new ExceptionDTO(e, 406, true);
            return gson.toJson(exDTO);
        }
        
    }
```
###### Exception Mapper
```java
@Provider
public class CustomerNotFoundExceptionMapper implements ExceptionMapper<CustomerNotFoundException> {

    @Context
    ServletContext context;
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public Response toResponse(CustomerNotFoundException ex) {
        boolean isDebug = context.getInitParameter("debug").equals("true");
        ExceptionDTO err = new ExceptionDTO(ex, 404, isDebug);
        err.setDescription("You tried to call...");

        return Response.status(404)
                .entity(gson.toJson(err))
                .type(MediaType.APPLICATION_JSON).
                build();
    }
}
```

And use it in the rest api like this:
```java
@GET
    @Path("/test/exmap")
    @Produces(MediaType.APPLICATION_JSON)
    public String testExceptionMapper() throws CustomerNotFoundException {
            throw new CustomerNotFoundException("No customer for you I'm sorry");
    }
```

## Testing restful webservice api
...  

If you have time you can get started [here](https://www.logicbig.com/tutorials/java-ee-tutorial/jax-rs/jax-rs-unit-testing.html)

