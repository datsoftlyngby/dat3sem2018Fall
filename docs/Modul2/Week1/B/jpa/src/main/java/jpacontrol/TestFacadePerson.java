package jpacontrol;

import entity.Person;
import facade.FacadePerson;
import javax.persistence.Persistence;

public class TestFacadePerson
{
    public static void main(String[] args)
    {
        FacadePerson fp = new FacadePerson( Persistence.createEntityManagerFactory( "jpapu" ) );
        
        System.out.println("GetPerson : " + fp.getPerson(3l).getFirstName() );
        
        System.out.println("GetPersons : " + fp.getPersons());
        
        System.out.println("AddPerson : " + fp.addPerson(new Person("Simon", "Wall", 5554637)));
        
        System.out.println("DeleteCustomer : " + fp.deletePerson(1l));
        
        Person p = fp.getPerson(3l);
        p.setFirstName("Alan");
        System.out.println("EditCustomer : " + fp.editPerson(p));
        
        System.out.println("GetCustomers : " + fp.getPersons() );
    }
}