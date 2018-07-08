

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;  
import javax.servlet.RequestDispatcher;  

public class DOSClientServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String[] username = {"user1","user2","user3","user4","user5"};
	String[] password = {"admin@123","admin@234","admin@345","admin@456","admin@456"};
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		response.setContentType("text/html");  

		PrintWriter out = response.getWriter();  
        
	    String userName=request.getParameter("username");  
	    String passWord=request.getParameter("userpass");  
	    for(int k=0;k<5;k++) {
	    if(userName.equals(username[k])&& passWord.equals(password[k])){  
	        RequestDispatcher rd=request.getRequestDispatcher("SearchProduct.html");  
            rd.forward(request,response);  
	    	out.println("Logged in successfully");
	    	break;
	    }
	    } 
	        out.print("Sorry username or password error");  
	        RequestDispatcher rd=request.getRequestDispatcher("index.html");  
	        rd.include(request,response);  
	          
	    out.close();  
	    } 
	}

