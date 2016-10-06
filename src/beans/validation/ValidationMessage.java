package beans.validation;

public class ValidationMessage {

	private Boolean valid;
	private String 	message;
	
	/* Getters */
	public Boolean 	isValid() 						{ return valid; 				}
	public String 	getMessage() 					{ return message;				}
	
	/* Setters */
	public void 	isValid(Boolean valid)			{ this.valid = valid; 			}
	public void 	setMessage(String message) 		{ this.message = message; 		}
}
