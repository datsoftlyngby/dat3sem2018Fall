package jpacontrol;

import entity.Address;
import entity.Person;
import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;

public class Populate
{
    public static void main(String[] args)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory( "jpapu" );
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        Person p = new Person("Dan", "Mark", 5554321);
        p.setMember(false);
        em.persist(p);
        p = new Person("Mark", "Benson", 5557878);
        p.setMember(true);
        em.persist(p);
        p = new Person("Ben", "Winter", 5551112);
        em.persist(p);
        
        Address a = new Address("Yellow Road 1", "Berlin");
        p.addAddress(a);
        a.setPerson(p);
        em.persist(a);  
        
        em.getTransaction().commit();
        em.close();
    }
}