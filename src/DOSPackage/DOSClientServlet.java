package DOSPackage;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;  
import javax.servlet.RequestDispatcher;  

/**
 * The Class DOSClientServlet get a user name and password from index.html for authentication check
 * 
 * @author KannigaNatarajan
 * @version 3.0
 */
public class DOSClientServlet extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** 
	 * Initialization of user name and password
	 */
	String[] username = {"user1","user2","user3","user4","user5"};
	String[] password = {"admin@123","admin@234","admin@345","admin@456","admin@456"};
	
	/**
	 * This method get a request and check user name and password validation
	 *
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     * @param request the request
     * @param response the response
     * @throws ServletException the servlet exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
	
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
	
	/** 
	 * This method for calling post method internally
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 * @param request the request
     * @param response the response
     * @throws ServletException the servlet exception
     * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 this.doPost(request, response);
	}
	}

