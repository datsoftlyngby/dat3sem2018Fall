package facade;

import entity.Person;
import entity.PersonDTO;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FacadePersonTest
{
    EntityManagerFactory emf;
    FacadePerson fp;
    
    public FacadePersonTest()
    {
        fp = new FacadePerson(Persistence.createEntityManagerFactory("jpapuTest"));
        fp.addPerson(new Person("Dan", "Mark", 7654332));
        fp.addPerson(new Person("Kaj", "Olsen", 3456543));
        fp.addPerson(new Person("Jens", "Madsen", 8585888));
    }
    
    @BeforeClass
    public static void setUpClass()
    {
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
    public void testGetPerson()
    {
        System.out.println("getPerson");
        assertEquals("Dan", fp.getPerson(new Person("Dan", "Mark", 76543321)).getFirstName());
    }

    @Test
    public void testGetPersons()
    {
        System.out.println("getPerson");
        assertTrue(fp.getPersons().contains(new PersonDTO("Dan", "Mark", 7654332)));
    }

    @Test
    public void testAddPerson()
    {
        System.out.println("addPerson");
        fp.addPerson(new Person("Joe", "West", 345654));
        assertTrue(fp.getPersons().contains(new PersonDTO("Joe", "West", 345654)));
    }
}