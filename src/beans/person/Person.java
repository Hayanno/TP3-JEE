package beans.person;

import java.io.Serializable;

/**
 * 
 * Merci BEN T'ES TROP FORT
 * @author Nicolas Léotier
 *
 */
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;

	private String 	firstname,
					lastname,
					birthDate,
					emailAddress;
	
	public Person() {
		id = 0;
		firstname = "";
		lastname = "";
		birthDate = "";
		emailAddress = "";
	}

	/* Getters */
	public int 		getId() 						{ return id; 					}
	public String 	getFirstname() 					{ return firstname; 			}
	public String 	getLastname() 					{ return lastname; 				}
	public String 	getBirthDate() 					{ return birthDate; 			}
	public String 	getEmailAddress() 				{ return emailAddress; 			}

	/* Setters */
	public void 	setId(int id) 					{ this.id = id; 				}
	public void 	setFirstname(String firstname) 	{ this.firstname = firstname; 	}	
	public void 	setLastname(String lastname) 	{ this.lastname = lastname; 	}
	public void 	setBirthDate(String birth)		{ this.birthDate = birth; 		}
	public void 	setEmailAddress(String email) 	{ this.emailAddress = email; 	}
}