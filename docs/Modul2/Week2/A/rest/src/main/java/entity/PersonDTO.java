package entity;

import java.util.Objects;

public class PersonDTO
{
    private String firstName;
    private String lastName;
    private int phoneNumber;

    public PersonDTO(String firstName, String lastName, int phoneNumber)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
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

    @Override
    public int hashCode()
    {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.firstName);
        hash = 79 * hash + Objects.hashCode(this.lastName);
        hash = 79 * hash + this.phoneNumber;
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final PersonDTO other = (PersonDTO) obj;
        if (this.phoneNumber != other.phoneNumber)
        {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName))
        {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "PersonDTO{" + "firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + '}';
    }
}
