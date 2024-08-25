Feature: Login

  Scenario Outline: Successful Login with valid username and password in both Gmail and Gorgias
    Given Enter a valid <GmailUsername> <GmailPassword> and Login to Gmail
    When Enter a valid <GorgiasUsername> <GorgiasPassword> and Login to Gorgias

    Examples:
      | GmailUsername                  | GmailPassword  | GorgiasUsername                         | GorgiasPassword    |
      | "Wisteriaautomation@gmail.com" | "Wisteria@123" | "saiprakash.kunapareddy@vassarlabs.com" | "Vassar@123456789" |
