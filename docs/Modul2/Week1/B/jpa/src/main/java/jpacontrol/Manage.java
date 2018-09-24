package jpacontrol;

import entity.Person;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Manage
{
    public static void main(String[] args)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory( "jpapu" );
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        Person p1 = new Person("Dan", "Mark", 5554321);
        em.persist(p1);
        p1.setPhoneNumber(77777777);
        p1.setId(34l);
        //em.detach(p1);
        p1.setPhoneNumber(323232);
        
        Person p2 = new Person("Joe", "Williams", 6435551);
        em.merge(p2);
        p2.setPhoneNumber(222222);
        p2.setId(66l);
        
        /*
        Person p3 = em.find(Person.class, 2l);
        p3.setPhoneNumber(99999999);
        //p3.setId(444l);
        em.detach(p3);
        p3.setPhoneNumber(56565656);
        p3.setId(444l);
        */
        
        /*
        em.remove(p);
        
        Person p = em.find(Person.class, 1l);
        em.remove(p);
        
        Person ppp = em.find(Person.class, 2);
        ppp.setFirstName("Oleg");
        
        Address a = new Address("Low Road 12","Birmingham");
        a.setPerson(ppp);
        ppp.addAddress(a);
        a = new Address("First Road 987","London");
        a.setPerson(ppp);
        ppp.addAddress(a);
        
        //em.remove(ppp);
        */
        
        em.getTransaction().commit();        
        em.close();
    }
}