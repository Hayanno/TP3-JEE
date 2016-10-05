package beans.person;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(
		name = "edition",
        description = "Servlet d'édition d'une personne",
        urlPatterns = "/edition"
)

public class Edition extends HttpServlet {
	Person p = null;

    // initialisation de la servlet
    public void init() throws ServletException {
        p = new Person();
    }

    // destruction de la servlet
    public void destroy() { }
    
    public void doGet() { }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    		  throws IOException, ServletException {
    	
    	p = new Person();
    		  
        // récupération d'un paramètre de la requête
    	String id = request.getParameter("id");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("birthdate");
        String birthdate = request.getParameter("lastname");
        String emailaddress = request.getParameter("emailaddress");
        
        p.setId(Integer.parseInt(id));
        p.setFirstname(firstname);
        p.setLastname(lastname);
        p.setBirthDate(birthdate);
        p.setEmailAddress(emailaddress);
        
        HttpSession session = request.getSession();
        session.setAttribute("person", p);
        request.getRequestDispatcher("person.jsp").forward(request, response);
    }
    
    public void service()  { }
}