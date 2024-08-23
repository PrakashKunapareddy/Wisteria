Feature: Login Functionality for MobiWise SuperAdmin Login

  As a SuperAdmin of MobiWise
  SuperAdmin should be able to login into the account
  and can access the account related features of SuperAdmin

  Scenario Outline: Successful Login with valid username and password
    Given Entered a valid <username> <password>
    When  Clicked on the sign in button
    And  Validate login <expected_output> <valid_username>
#    And Click on the forgot password and enter <valid_username>

    Examples:
      | username           | password          | expected_output       | valid_username |
      | "dummy"            | "1234567890"      | "Projects"            | "superadmin"   |
      | "Mobilewise@123"   | "mobiwise@123   " | "Invalid Username!"   | "superadmin"   |
      | "Invalid Username" | "invalidPassword" | "Invalid Username!"   | "superadmin"   |
      | "dummy"            | "abcd"            | "Incorrect Password!" | "superadmin"   |
#      | ""                 | "abcd"            | "Invalid Username!"  | "superadmin"   |
#      | "ABCD"             | ""                | "Invalid Username!"   | "superadmin"   |
#      | ""                 | ""                | "Invalid Username!"   | "superadmin"   |

