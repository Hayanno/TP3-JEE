package beans.person;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.validation.Validation;
import bus.PersonManager;

@WebServlet(
		name = "edition",
        description = "Servlet d'édition d'une personne",
        urlPatterns = "/edition"
)

public class Edition extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	PersonManager pm;

    // initialisation de la servlet
    public void init() throws ServletException {
        pm = new PersonManager();
    }

    // destruction de la servlet
    public void destroy() { }
    
    public void doGet() { }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    		  throws IOException, ServletException {
    	
    	Person 		person = new Person();
        Validation 	validation = new Validation();
    		  
        // récupération d'un paramètre de la requête
    	String id = request.getParameter("id");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("birthdate");
        String birthdate = request.getParameter("lastname");
        String emailaddress = request.getParameter("emailaddress");
        
        person.setId(Integer.parseInt(id));
        person.setFirstname(firstname);
        person.setLastname(lastname);
        person.setBirthDate(birthdate);
        person.setEmailAddress(emailaddress);
        
        HttpSession session = request.getSession();
        
        pm.check(person, validation);
        
        if(!validation.isValid()) {
        	System.out.println("pas valide");
        	session.setAttribute("p", person);
            session.setAttribute("v", validation);
            request.getRequestDispatcher("edition.jsp").forward(request, response);
        }
	    else {
	        pm.save(person);
	        session.setAttribute("pm", pm);
	        request.getRequestDispatcher("person.jsp").forward(request, response);
	    }
    }
    
    public void service()  { }
}