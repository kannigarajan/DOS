package DOSPackage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;


class ProductSearchTest {
	WelcomeServlet test = new WelcomeServlet();
	@Test
	void passTest() {
		ArrayList<String> list = new ArrayList<String>();
	    list = test.ProductSearch("Dairy Products");
		assertEquals("[Ghee, Butter, Milk, Sweet]", list.toString());
		}
	@Test
    void failTest() {
    	ArrayList<String> list = new ArrayList<String>();
	    list = test.ProductSearch("Dairy Products");
		assertEquals("[Ghee, Butter, Milk, Sweet22333]", list.toString());
    }
	@Test
	void exceptionTest(){
		ArrayList<String> list = new ArrayList<String>();
	    list = test.ProductSearch("not found");
		assertEquals("[]", list.toString());
	}
	
}
