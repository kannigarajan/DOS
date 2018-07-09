package DOSPackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import org.apache.log4j.Logger;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;  

/**
 * The Class WelcomeServlet get a product name from HTML page and shows the result 
 * 
 * @author KannigaNatarajan
 * @version 3.0
 */
public class WelcomeServlet extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The bufreader for reading file initializing to null
	 */
	BufferedReader bufReader = null;
	final static Logger logger = Logger.getLogger(WelcomeServlet.class);
	
	/*
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 * @param request the request
     * @param response the response
     * @throws ServletException the servlet exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("Entering the First Dopost Method");
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	    String productName = request.getParameter("productname");
	    ArrayList<String> list = new ArrayList<String>();
	    list = this.ProductSearch(productName);;
	    out.println(
	            "<html>\n" +
	               "<head><title>products </title></head>\n" +
	              "<style>"+
	            "form {"+
	                "width: 300px;"+
	                "margin: 300 auto;"+
	            "}"+
	           " </style>" +
	               "<body bgcolor = \"#f0f0f0\">\n" +
	               "<form>"+
	                  "<h3> Available Products are :</h3>\n"
	                 );
	    for(int n=0;n<list.size();n++) {
	    out.println(
	                  "<li> "+ list.get(n)+ "</li>"
	    );}
	    out.print(
	               "</form>"+
	               "</body>" +
	            "</html>"
	         );
	   
	    out.close();  
	}
   
   /**
    * Product search.
    *
    * @param productName the product name
    * @return the array list
    */
   ArrayList<String> ProductSearch(String productName){
	   ArrayList<String> list = new ArrayList<String>();
	   String fileName = "";
	   Path currentRelativePath = Paths.get("");
	   String s = currentRelativePath.toAbsolutePath().normalize().toString();
	   System.out.println("Current relative path is: " + s);
	 
	   if(productName.equals("Dairy Products")) {
		   fileName = "/home/auzmor/Desktop/DOSAttack/src/dairy.txt";
	   }else if(productName.equals("Stationary Items")) {
		   fileName = "/home/auzmor/Desktop/DOSAttack/src/stationary.txt";
	   }else if(productName.equals("Grocery Items")) {
		   fileName = "/home/auzmor/Desktop/DOSAttack/src/grocery.txt";
	   }else if(productName.equals("Kitchen Items")) {
		   fileName = "/home/auzmor/Desktop/DOSAttack/src/kitchen.txt";
	   }else if(productName.equals("Plastic Items")) {
		   fileName = "/home/auzmor/Desktop/DOSAttack/src/plastic.txt";
	   }else {
		   fileName = "/home/auzmor/Desktop/DOSAttack/src/empty.txt";
	   }
		   try {
			bufReader = new BufferedReader(new FileReader(fileName));
            String line = bufReader.readLine(); 
	    	while (line != null && !(line.isEmpty())) { 
	    		list.add(line);
	    		line = bufReader.readLine(); }
	           } catch (IOException i) {
	             System.out.println(i);
	           }
	return list;
	   }
   
   /* (non-Javadoc)
    * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 this.doPost(request, response);
	}
}
