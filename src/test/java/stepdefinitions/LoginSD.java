package stepdefinitions;

import com.vassarlabs.projectname.driver.WebdriverInitializer;
import com.vassarlabs.projectname.page.LoginToGmailAndGorgias;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.awt.*;

public class LoginSD {

    LoginToGmailAndGorgias loginPage = new LoginToGmailAndGorgias(WebdriverInitializer.getDriver());

    public LoginSD() throws AWTException {
    }

    @Given("Enter a valid {string} {string} and Login to Gmail")
    public void enter_a_valid_and_login_to_gmail(String GmailUN, String GmailPW) throws Throwable{
       loginPage.GmailLogin(GmailUN,GmailPW);
    }


    @When("Enter a valid {string} {string} and Login to Gorgias")
    public void enterAValidGorgiasUsernameGorgiasPasswordAndLoginToGorgias(String GorgiasUN, String GorgiasPW) throws Throwable{
        loginPage.GorgiasLogin(GorgiasUN,GorgiasPW);
    }

}
