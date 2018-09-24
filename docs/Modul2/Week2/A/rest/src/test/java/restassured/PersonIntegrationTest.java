package restassured;

import entity.Person;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertNotNull;

public class PersonIntegrationTest
{    
    public PersonIntegrationTest()
    {
    }
    
    @BeforeClass
    public static void setUpBeforeAll()
    {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 7777; //Change in pom.xml
        RestAssured.basePath = "/rest";
        RestAssured.defaultParser = Parser.JSON;
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void serverIsRunning()
    {
        given().
        when().get().
        then().statusCode(200);
    }
    
    @Test
    public void postGetDeletePerson()
    {
        Person person = new Person("Kurt", "Williams", 12344321);
        
        given()
        .contentType("application/json")
        .body(person)
        .when()
        .post("/api/person")
        .then()
        .body("phoneNumber", notNullValue())
        .body("lastName", equalTo("Williams"));
        
        given()
        .contentType(ContentType.JSON)
        .when()
        .get("/api/person/" + person.getFirstName() + "/" + person.getLastName())
        .then()
        .body("phoneNumber", notNullValue())
        .body("lastName", equalTo("Williams"));

        given()
        .contentType(ContentType.JSON)
        .body(person)
        .when()
        .delete("/api/person")
        .then()
        .body("firstName", equalTo("Kurt"));
    }
}