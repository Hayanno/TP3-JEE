package beans.validation;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
	
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	
	private Map<String, ValidationMessage> validationMessages;
	
	public Validation() {
		validationMessages = new HashMap<>();
	}
	
	public String getValidationMessage(String inputName) {
		ValidationMessage vm = validationMessages.get(inputName);
		
		if(vm == null)
			return "";
		
		return vm.getMessage();
	}
	
	public void putValidationMessage(String message, Boolean valid, String inputName) {
		ValidationMessage validationMessage = new ValidationMessage();
		validationMessage.isValid(false);
		validationMessage.setMessage(message);
		
		validationMessages.put(inputName, validationMessage);
	}
	
	public boolean isValid() {
		if(validationMessages == null || validationMessages.isEmpty())
			return true;
		
		for (Map.Entry<String, ValidationMessage> vm : validationMessages.entrySet()) {			
			if(!vm.getValue().isValid())
				return false;
		}
		
		return true;
	}
	
	public boolean mailValid(String mail) {
		if(mail == null || mail.isEmpty())
			return false;
		
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(mail);
		
        return matcher.find();
	}
	
	public boolean lastnameValid(String lastname) {
		return lastname != null && !lastname.isEmpty();
	}
}
