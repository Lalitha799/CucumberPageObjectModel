package stepDefs;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.CheckOutPage;
import pages.LoginPage;
import pages.ProductListPage;

public class OrderStepDef {
	
	WebDriver driver=TestBase.getDriver();
	LoginPage loginPage;
	ProductListPage listPage;
	CartPage cartPage;
	CheckOutPage checkOutPage;
	
	
	public OrderStepDef()
	{
		loginPage=new LoginPage(driver);
		listPage=new ProductListPage(driver);
		cartPage=new CartPage(driver);
		checkOutPage=new CheckOutPage(driver);
	}

	@Given("User is on login Page")
	public void user_is_on_login_page() {
	   TestBase.openUrl("https://www.saucedemo.com/");
	}

	@When("User enters {string} and {string}")
	public void user_enters_and(String strUser, String strPwd) {
		
		   loginPage.loginIntoApp(strUser, strPwd);
	   	}

	@Then("User should be on Home page")
	public void user_should_be_on_home_page() {
	    Assert.assertTrue(listPage.isOnProducts());
	}


	@When("User add Item to cart")
	public void user_add_item_to_cart() {
	   listPage.addToCart();
	}

	@Then("Item must be added")
	public void item_must_be_added() {
	  
		listPage.viewCart();
		Assert.assertTrue(cartPage.isItemAdded());
	}

	@Given("User is on cart page")
	public void user_is_on_cart_page() {
	   
		listPage.viewCart();
	}

	@When("User do checkout")
	public void user_do_checkout() {
        cartPage.checkoutItems();
	}

	@Then("Should navigate to Checkout page")
	public void should_navigate_to_checkout_page() {
	  
		 checkOutPage.provideDetails();
	}


}
