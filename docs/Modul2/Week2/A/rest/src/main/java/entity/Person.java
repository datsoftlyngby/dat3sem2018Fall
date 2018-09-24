package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Person implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String firstName;
    private String lastName;
    private int phoneNumber;
        
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Address> addresses = new ArrayList();

    public Person()
    {
    }

    public Person(String firstName, String lastName, int phoneNumber)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public int getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public List<Address> getAddresses()
    {
        return addresses;
    }

    public void setAddresses(ArrayList<Address> addresses)
    {
        this.addresses = addresses;
    }
    
    public void addAddress(Address address)
    {
        this.addresses.add(address);
    }

    @Override
    public String toString()
    {
        return "Person{" + "firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + '}';
    }
}
