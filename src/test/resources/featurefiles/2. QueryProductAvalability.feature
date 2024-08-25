Feature: Product Availability

  Scenario Outline: Query Product Availability
    Given Enter a valid <GmailUsername> <GmailPassword> and Login to Gmail
    When Enter a valid <GorgiasUsername> <GorgiasPassword> and Login to Gorgias
    And Click on All Tickets
    And Navigate to Gmail and Send mail to enquiry Product Availability <Query> <SKUID>
    And Open Gorgias Website and Assert the Template <Query> <ItemAvailability>

    Examples:
      | GmailUsername                  | GmailPassword  | GorgiasUsername                         | GorgiasPassword    | Query                  | SKUID        | ItemAvailability |
      | "Wisteriaautomation@gmail.com" | "Wisteria@123" | "saiprakash.kunapareddy@vassarlabs.com" | "Vassar@123456789" | "Product Availability" | "136-111137" | "InStock"        |
      | "Wisteriaautomation@gmail.com" | "Wisteria@123" | "saiprakash.kunapareddy@vassarlabs.com" | "Vassar@123456789" | "Product Availability" | "106-111199" | "OutOfStock"     |
