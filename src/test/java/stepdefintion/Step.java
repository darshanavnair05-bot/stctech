package stepdefintion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Step {
	WebDriver driver;
	@Given ("user is on the SauceDemo login page")
	public void userisonloginpage () {
		driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
	}

	
    @When ("user enters valid username and password")
    public void entersvalidceredentials () {
    	driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
    	driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
    }
    
    @And ("clicks on the login button")
    public void userclicksloginbutton () {
    	driver.findElement(By.id("login-button")).click();
    	
    }
    @Then ("user should be redirected to the home page")
    public void validation () {
	
    	 String url = driver.getCurrentUrl();
		 if(url.contains("inventory")) {
			 System.out.println("Login Successfull");
		 }
		 else {
			 System.out.println("Login is not successfull");
		 }
}
    @When ("user adds three products to the cart")
    public void addsthreeproducts () {
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
		driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
	}
    @And ("user removes one product from the cart")
    public void removesoneproductfromthecart () {
    	driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt")).click();
	
}
    @And ("user goes to the cart page")
    public void usergoestothecartpage () {
    	driver.findElement(By.className("shopping_cart_link")).click();
}
    @And ("user proceeds to checkout")
    public void proceedstocheckout () {
		driver.findElement(By.id("checkout")).click();
		driver.findElement(By.id("first-name")).sendKeys("Darshana");
		driver.findElement(By.id("last-name")).sendKeys("V");
		driver.findElement(By.id("postal-code")).sendKeys("682306");
		driver.findElement(By.id("continue")).click();

}
    @And ("user clicks the finish button")
    public void finish () {
    	driver.findElement(By.xpath("//button[@id='finish']")).click();
	
}
    @Then ("user clicks on back to home button")
    public void backtohomebutton () {
		driver.findElement(By.xpath("//button[@id='back-to-products']")).click();
		String url1 = driver.getCurrentUrl();
		 if(url1.contains("inventory")) {
			 System.out.println("user reached back to home successfully");
		 }
		 else {
			 System.out.println("user not reached to home");
		 }


	
}
    @And ("browser is closed")
    public void closed () {
    	driver.quit();
}


}
