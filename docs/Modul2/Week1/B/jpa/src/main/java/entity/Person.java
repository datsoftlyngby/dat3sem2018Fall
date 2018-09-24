package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
//@Table(name="tbl_person")
@NamedQuery(name = "findAllPersons", query = "SELECT p FROM Person p")
@NamedQueries(
{
@NamedQuery(name = "findAllPersonsByFirstName", query="Select p from Person p where p.firstName = :firstName"),
@NamedQuery(name = "findAllPersonsByPhoneNumber", query = "SELECT p FROM Person p WHERE p.phoneNumber = :phoneNumber")
})

public class Person implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private int phoneNumber;
    @Column(columnDefinition = "TINYINT")
    private boolean member;

    @Temporal(TemporalType.DATE)
    private Date creationDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date expirationDate;
    @Temporal(TemporalType.TIME)
    private Date startTime;
    
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

    public boolean isMember()
    {
        return member;
    }

    public void setMember(boolean member)
    {
        this.member = member;
    }

    public Date getCreationDate()
    {
        return creationDate;
    }

    public void setCreationDate(Date creationDate)
    {
        this.creationDate = creationDate;
    }

    public Date getExpirationDate()
    {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate)
    {
        this.expirationDate = expirationDate;
    }

    public Date getStartTime()
    {
        return startTime;
    }

    public void setStartTime(Date startTime)
    {
        this.startTime = startTime;
    }
    
    //OneToOneUni
    /*
    @OneToOne
    private Address address;
    */
    
    //OneToOneBi
    /*
    @OneToOne
    private Address address;
    */

    //OneToOne
    /*
    public Address getAddress()
    {
        return address;
    }
    public void setAddress(Address address)
    {
        this.address = address;
    }
    */
    
    //OneToManyUni
    /*
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Person_ID")
    private List<Address> addresses = new ArrayList();
    */
    
    //OneToManyBi
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses = new ArrayList();
    
    //ManyToMany
    /*
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Address> addresses = new ArrayList();
    */
    
    public void addAddress(Address a)
    {
        addresses.add(a);
    }
    
    public String getAddresses()
    {
        return addresses.toString().replace("[", "").replace("]", "").replace(", ", ",");
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person))
        {
            return false;
        }
        Person other = (Person) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "Person{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + '}';
    }
}