package jpacontrol;

import entity.Person;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Find
{
    public static void main(String[] args)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory( "jpapu" );
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        
        Long id = 1l;
        
        System.out.println("Person - First name: " + em.find(Person.class, id).getFirstName() );
        System.out.println("Person - Phone: " + em.find(Person.class, id).getPhoneNumber() );
        
        em.getTransaction().commit();
        em.close();
    }
}
