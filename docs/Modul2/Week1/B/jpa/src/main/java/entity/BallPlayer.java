package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BallPlayer extends Person 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;    
    private String club;
    private String position;
    private int jerseyNumber;        
   
    public Long getId()
    {
        return id;
    }
}