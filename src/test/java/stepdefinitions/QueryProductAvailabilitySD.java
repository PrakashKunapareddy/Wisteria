package stepdefinitions;

import com.vassarlabs.projectname.driver.WebdriverInitializer;
import com.vassarlabs.projectname.page.LoginToGmailAndGorgias;
import com.vassarlabs.projectname.page.QueryProductAvailability;
import io.cucumber.java.en.And;

import java.awt.*;

public class QueryProductAvailabilitySD {

    QueryProductAvailability QPA = new QueryProductAvailability(WebdriverInitializer.getDriver());

    public QueryProductAvailabilitySD() throws AWTException {
    }

    @And("Click on All Tickets")
    public void clickOnAllTickets() throws Throwable {
        QPA.clickOnALlTickets();
    }

    @And("Navigate to Gmail and Send mail to enquiry Product Availability {string} {string}")
    public void navigateToGmailAndSendMailToEnquiryProductAvailability(String Query,String SKUID) throws Throwable {
        QPA.clickOnSentMailAndAccessProductAvailabilityThread(Query, SKUID);
    }

    @And("Open Gorgias Website and Assert the Template {string} {string}")
    public void openGorgiasWebsiteAndAssertTheTemplate(String Query,String ItemAvailability) throws InterruptedException {
        QPA.openGorgiasAndAccessMail(Query,ItemAvailability);
    }
}
