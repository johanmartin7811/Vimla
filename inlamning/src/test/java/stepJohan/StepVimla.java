package stepJohan;



import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import common.WaitMethods;
import common.mailCreator;
import common.userNameCreator;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class StepVimla {

	private WebDriver driver;
	WaitMethods project = new WaitMethods();
	userNameCreator creat = new userNameCreator();
	mailCreator creator = new mailCreator();



	@Before
	public void i_open_the_page() {
		System.out.println("");
		System.out.println("Vimla startas");
		System.out.println("");
	}

	@After
	public void i_close_my_register() {
		System.out.println("");
		System.out.println("Vimla stängs");
		System.out.println("");
		driver.quit();

	}


	@Given("I open register page vimla")
	public void i_open_register_page_vimla()  {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://forumet.vimla.se/register");

	}

	@Given("I have clicked the cookie button")
	public void i_have_clicked_the_cookie_button() {
		project.click(driver, By.id("cookie-continue-btn"));
	}


	@Given("I have entered a mail {string} into the register")		
	public void i_have_entered_a_mail_into_the_register(String mail)  {
		if(mail.contentEquals("Johanmartin")) {
			mail = creator.createMail();
			project.sendKeys(driver,By.cssSelector("input[id='email']"),mail);
		}
		else {
			project.sendKeys(driver,By.cssSelector("input[id='email']"),mail);
		}
	}


	@Given("I enter a username {string} into the register")
	public void i_enter_a_username_into_the_register(String userName)  {
		if(userName.contentEquals("Johan M")) {
			userName = creat.createRandomUserName();
			project.sendKeys(driver,By.cssSelector("input[id=username]"),userName);
		}
		else  {
			project.sendKeys(driver, By.cssSelector("input[id=username]"), userName);
		}


	}


	@Given("I enter a password {string} into the register")
	public void i_enter_a_password_into_the_register(String passWord)  {
		project.sendKeys(driver, By.cssSelector("input[id=password]"), passWord);


	}


	@Given("I enter the same password again {string} into to register")
	public void i_enter_the_same_password_again_into_to_register(String passWord)  {
		if(passWord.contentEquals("Torska")) {
			project.sendKeys(driver, By.cssSelector("input[id=password-confirm]"), passWord);
		}
		else {
			project.sendKeys(driver, By.cssSelector("input[id=password-confirm]"), passWord);
		}
	}


	@When("I click register")
	public void i_click_register() throws InterruptedException  {
		project.click(driver, By.id("register"));
		Thread.sleep(2000);


	}


	@Then("I test if user can register on vimla {string}")
	public void i_test_if_user_can_register_on_vimla(String vimla)   {
		if(vimla.contentEquals("first")){
			Assert.assertTrue("Ditt konto kunde inte hittas, men skapades", driver.findElement(By.id("user_label")).getText().equals("JO"));

		}else if (vimla.contentEquals("secound")) {
			Assert.assertTrue("Fel längd på namnet", driver.findElement(By.id("username-notify")).getText().equals("Användarnamnet är för långt"));

		}else if (vimla.contentEquals("third")) {
			Assert.assertTrue("Lösenorden är likadana.", driver.findElement(By.id("password-confirm-notify")).getText().equals("Lösenorden är inte likadana. Var god skriv dem på nytt."));

		}else if (vimla.contentEquals("fourth"))  {
			Assert.assertTrue("Denna mail finns inte registerad på ett forumkonto ", driver.findElement(By.id("email-notify")).getText().equals("Denna mailadress finns redan registrerad på ett forumkonto"));
		}


	}

}












