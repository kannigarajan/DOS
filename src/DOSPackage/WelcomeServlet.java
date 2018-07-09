package DOSPackage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.ArrayList;  

public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BufferedReader bufReader = null;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
   ArrayList<String> ProductSearch(String productName){
	   ArrayList<String> list = new ArrayList<String>();
	   String fileName = "";
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
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 this.doPost(request, response);
	}
}