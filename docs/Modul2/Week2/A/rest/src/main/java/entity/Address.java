package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Address implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String street;
    private String city;
    
    @ManyToMany(mappedBy = "addresses")
    private List<Person> persons = new ArrayList();

    public Address()
    {
    }

    public Address(String street, String city)
    {
        this.street = street;
        this.city = city;
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

    public List<Person> getPersons()
    {
        return persons;
    }

    public void setPersons(ArrayList<Person> persons)
    {
        this.persons = persons;
    }
    
    public void addPerson(Person person)
    {
        this.persons.add(person);
    }

    @Override
    public String toString()
    {
        return "Address{" + "street=" + street + ", city=" + city + '}';
    }
}
