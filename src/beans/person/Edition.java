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
        urlPatterns = {"/edition", "/supprimer"}
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
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
    		throws IOException, ServletException {

    	HttpSession session = request.getSession();
    	int id = 0;
    	
    	System.out.println(request.getParameter("id"));
    	
    	if(request.getParameter("id") == null) {
    		System.out.println(request.getServletPath());
    		if(request.getServletPath() == "/supprimer") {
	    		pm.delete(id);
		        session.setAttribute("persons", pm.findAll());
	    		request.getRequestDispatcher("lister.jsp").forward(request, response);
	    	}
	    	else {	
	    		session.setAttribute("person", null); // TODO: refaire en mieux
	    		request.getRequestDispatcher("edition.jsp").forward(request, response);
	    	}
    	}
    	else {
	    	id = Integer.parseInt(request.getParameter("id"));
    		session.setAttribute("isNew", false);
	    	    	
	    	Person person = pm.retrieve(id);
	    	session.setAttribute("person", person);
	    	
	    	request.getRequestDispatcher("edition.jsp").forward(request, response);
    	}
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    		  throws IOException, ServletException {
    	
    	Person 		person 		= new Person();
        Validation 	validation 	= new Validation();
    		  
        // récupération d'un paramètre de la requête
    	String id = request.getParameter("id");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String birthdate = request.getParameter("birthdate");
        String emailaddress = request.getParameter("emailaddress");
        
        person.setId(Integer.parseInt(id));
        person.setFirstname(firstname);
        person.setLastname(lastname);
        person.setBirthDate(birthdate);
        person.setEmailAddress(emailaddress);
        
        HttpSession session = request.getSession();
    	session.setAttribute("person", person);
        
        pm.check(person, validation);
        
        if(!validation.isValid()) {
            session.setAttribute("validation", validation);
            request.getRequestDispatcher("edition.jsp").forward(request, response);
        }
	    else {	        
	        /* Exemple, à supprimer */
	        Person p2 = new Person();
	        p2.setId(0);
	        p2.setFirstname("Nicolas");
	        p2.setLastname("Léotier");
	        p2.setBirthDate("1992-02-02");
	        p2.setEmailAddress("nicolas@leotier.fr");
	        pm.save(p2);
	        /* Fin Exemple */
	        
	        pm.save(person);
	        
	        session.setAttribute("persons", pm.findAll());
	        request.getRequestDispatcher("lister.jsp").forward(request, response);
	    }
    }
    
    public void service()  { }
}