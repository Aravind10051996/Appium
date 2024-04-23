package stepdefinitions;


import io.cucumber.java.en.Then;
import org.junit.Assume;

import java.text.ParseException;


public class NavigationBarsteps {
	ContextSteps contextSteps;

	public NavigationBarsteps(ContextSteps contextSteps) {
		this.contextSteps = contextSteps;
	}

	@Then("I click on first available cart")
	public void click_on_first_available_cart(){
		contextSteps.navigationBarAction.click_on_first_available_cart();
	}

	@Then("I click on the view to cart and remove")
	public void click_on_the_view_to_cart_and_remove(){
		contextSteps.navigationBarAction.click_on_the_view_to_cart_and_remove();
	}
}
