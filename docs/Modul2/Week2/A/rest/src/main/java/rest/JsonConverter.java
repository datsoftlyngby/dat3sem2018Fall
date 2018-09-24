package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Person;
import java.util.List;

public class JsonConverter
{    
    public static Person getPersonFromJson(String json)
    {
        return new Gson().fromJson(json, Person.class);
    }
    
    public static String getJSONFromPerson(Person person)
    {
        return new Gson().toJson(person);
    }  

    public static String getJSONFromPersons(List<Person> persons)
    {
        return new Gson().toJson(persons);
    }      
}