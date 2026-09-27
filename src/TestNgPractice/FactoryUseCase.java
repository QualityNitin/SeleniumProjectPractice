package TestNgPractice;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class FactoryUseCase 
{
	
	 	String username;

	    public FactoryUseCase(String username) {
	        this.username = username;
	    }

	    @Test
	    public void addToCartTest() {
	        System.out.println("Running test for: " + username);
	    }
	    
	    @Factory
	    public Object[] createUsers() {

	        return new Object[] {
	            new FactoryUseCase("standard_user"),
	            new FactoryUseCase("locked_out_user")
	        };
	    }
}
