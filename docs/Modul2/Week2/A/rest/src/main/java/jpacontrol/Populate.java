package jpacontrol;

import entity.Address;
import entity.Person;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Populate
{
    public static void main(String[] args)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpapu");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        Address a1 = new Address("Some Road 1", "Berlin");
        Address a2 = new Address("No Road 2", "New York");
        
        Person p1 = new Person("Mike", "Summer", 76999);
        p1.addAddress(a1);
        p1.addAddress(a2);
        a1.addPerson(p1);
        a2.addPerson(p1);
        em.persist(p1);
        
        Person p2 = new Person("George", "Winter", 74569);
        p2.addAddress(a1);
        p2.addAddress(a2);
        a1.addPerson(p2);
        a2.addPerson(p2);
        em.persist(p2);
        
        em.getTransaction().commit();
        em.close();
        
        
        
    }
}
