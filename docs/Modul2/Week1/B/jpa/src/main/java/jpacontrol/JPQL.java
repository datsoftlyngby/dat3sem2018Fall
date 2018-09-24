package jpacontrol;

import entity.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JPQL {
    public static void main(String[] args)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory( "jpapu" );
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        //NamedQuery
        Query Nquery = em.createNamedQuery("findAllPersonsByFirstName");
        Nquery.setParameter("firstName", "Dan"); 
        List<Person> persons = Nquery.getResultList(); 
        for(Person p:persons)
        {
            System.out.println("Person with first name 'Dan' : " + p);
        }

        //DynamicQuery1
        Query Dquery1 = em.createQuery("SELECT p FROM Person p");
        List<Person> personslist = Dquery1.getResultList();
        for(Person p:personslist)
        {
            System.out.println("Persons : " + p);
        }

        //DynamicQuery2
        Query DQuery2 = em.createQuery("Select UPPER(p.firstName) from Person p");
        List<String> firstNames = DQuery2.getResultList();
        for(String firstName : firstNames)
        {
            System.out.println("Person : " + firstName);
        }
      
        //DynamicQuery3
        Query DQuery3 = em.createQuery("Select MAX(p.phoneNumber) from Person p");
        int result = (int) DQuery3.getSingleResult();
        System.out.println("Max phoneNumber : " + result);
        
        //DynamicQuery4
        Query DQuery4 = em.createQuery("SELECT p FROM Person p JOIN p.addresses a WHERE a.city = :city");
        DQuery4.setParameter("city", "Berlin");
        List<Person> personsInCity = DQuery4.getResultList();
        for(Person person : personsInCity)
        {
            System.out.println("Person : " + person);
        }

        em.getTransaction().commit();        
        em.close();
    }
}