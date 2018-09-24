package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address implements Serializable
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    private String street;
    private String city;
    
    public Address()
    {
    }

    public Address(String street, String city)
    {
        this.street = street;
        this.city = city;
    }

    public long getId()
    {
        return id;
    }
    
    public String getStreet()
    {
        return street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }
    
    //@OneToOne(mappedBy = "address")
    private Person person;
    
    //OneToManyBi
    /*
    @ManyToOne
    */
    
    //Bi
    public Person getPerson()
    {
        return person;
    }

    public void setPerson(Person p)
    {
        this.person = p;
    }
    
    //ManyToMany
    /*
    @ManyToMany(mappedBy = "addresses")
    private List<Person> persons  = new ArrayList();
    
    public List<Person> getPersons()
    {
        return persons;
    }

    public void addPerson(Person p)
    {
        persons.add(p);
    }
    */
}
