package bus;

import java.util.HashSet;

import beans.person.Person;
import beans.validation.Validation;

public class PersonManager {

    final private HashSet<Person> persons;

    public PersonManager() {
    	persons = new HashSet<Person>();
    }

    public HashSet<Person> findAll() {
        return persons;
    }

    public void save(Person p) {
        persons.add(p);
    }

    public void check(Person p, Validation validation) {    	
        if(!validation.lastnameValid(p.getLastname()))
        	validation.putValidationMessage("Le nom est obligatoire.", false, "lastname");
        
        if(!validation.mailValid(p.getEmailAddress()))
        	validation.putValidationMessage("L'adresse mail est invalide.", false, "emailaddress");
    }
}