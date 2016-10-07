package bus;

import java.util.HashMap;
import java.util.Map;

import beans.person.Person;
import beans.validation.Validation;

public class PersonManager {

    final private Map<Integer, Person> persons;

    public PersonManager() {
    	persons = new HashMap<>();
    }

    public Map<Integer, Person> findAll() {
        return persons;
    }

    public void save(Person p) {
        persons.put(p.getId(), p);
    }
    
    public Person retrieve(int id) {
    	return persons.get(id);
    }
    
    public void delete(int id) {
    	persons.remove(id);
    }

    public void check(Person p, Validation validation) {    	
        if(!validation.lastnameValid(p.getLastname()))
        	validation.putValidationMessage("Le nom est obligatoire.", false, "lastname");
        
        if(!validation.mailValid(p.getEmailAddress()))
        	validation.putValidationMessage("L'adresse mail est invalide.", false, "emailaddress");
    }
}