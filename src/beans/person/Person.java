package beans.person;

import java.io.Serializable;


public class Person implements Serializable {
	public enum Status {
	    STUDENT	(1, "Etudiant"),
	    TEACHER	(2, "Enseignant"),
	    EXTERIOR(3, "Extérieur");

		private final int id;
	    private final String text;

	    private Status(final int id, final String text) {
	    	this.id = id;
	        this.text = text;
	    }
	    
	    @Override
	    public String toString() {
	        return text;
	    }
	    
	    public int getID() {
	    	return id;
	    }
	}

	private static final long serialVersionUID = 1L;

	private int id;

	private String 	firstname,
					lastname,
					birthDate,
					emailAddress;
	
	private Status status;
	
	public Person() {
		id = 0;
		firstname = "";
		lastname = "";
		birthDate = "";
		emailAddress = "";
		status = Status.STUDENT;
	}

	/* Getters */
	public int 		getId() 						{ return id; 					}
	public String 	getFirstname() 					{ return firstname; 			}
	public String 	getLastname() 					{ return lastname; 				}
	public String 	getBirthDate() 					{ return birthDate; 			}
	public String 	getEmailAddress() 				{ return emailAddress; 			}
	public String 	getStatus() 					{ return status.toString();		}
	public int 		getStatusID() 					{ return status.getID();		}

	/* Setters */
	public void 	setId(int id) 					{ this.id = id; 				}
	public void 	setFirstname(String firstname) 	{ this.firstname = firstname; 	}	
	public void 	setLastname(String lastname) 	{ this.lastname = lastname; 	}
	public void 	setBirthDate(String birth)		{ this.birthDate = birth; 		}
	public void 	setEmailAddress(String email) 	{ this.emailAddress = email; 	}
	
	public void 	setStatusID(int statusID) {
		if(statusID == 1)
			this.status = Status.STUDENT;
		else if(statusID == 2)
			this.status = Status.TEACHER;
		else
			this.status = Status.EXTERIOR;
	}
}