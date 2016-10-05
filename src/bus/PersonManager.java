package bus;

import java.util.Collection;
import java.util.Map;

import beans.person.Person;

public class PersonManager {

    final private Map<Integer, Person> persons;

    public PersonManager() {
        throw new IllegalStateException("Not yet implemented");
    }

    public Collection<Person> findAll() {
        throw new IllegalStateException("Not yet implemented");
    }

    public void save(Person p) throws Exception { 	
        persons.put(1, p);
    }

    public void check(Person p) throws Exception {
        if(p.getLastname() == null)
        	throw new IllegalArgumentException("Name is required.");
    }

}