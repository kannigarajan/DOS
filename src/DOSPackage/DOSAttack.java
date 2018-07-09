package DOSPackage;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  This class implements DOS Attack in the server, it will stop tomcat
 *  @author KannigaNatarajan
 *  @version 3.0
 */
@WebServlet("/DOSAttack")
public class DOSAttack extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
    
    /**
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     * @param request the request
     * @param response the response
     * @throws ServletException the servlet exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    //Djava.net.preferIPv4Stack=true
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	            try {
				   String filename = "/home/auzmor/Desktop/tomcat/bin/catalina.sh stop";
				   Process child = Runtime.getRuntime().exec(filename);
				   System.out.println(filename+""+child);
	            }catch(IOException e) {
				System.out.println("exception occured"+e);
			}

	}

	/**
	 * Do post will call doGet method internally to run stand alone
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
