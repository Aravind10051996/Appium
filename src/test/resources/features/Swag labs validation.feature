Feature: Login Logout scenarios with different users

  @Android @IOS @Smoke
  Scenario: Login Test
    Given App is launched
    And I sign in the Application
    Then I click on first available cart
    Then I click on the view to cart and remove
