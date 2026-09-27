package TestNgPractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FactoryUseCaseToCompareDataProvider {
	
	String username;
	
    public FactoryUseCaseToCompareDataProvider(String username) {
        this.username = username;
        System.out.println("Constructor called for user: " + username);
    }

    @Test
    public void addToCartTest() {
        System.out.println("Running test for: " + username);
    }
    
    
    
}
