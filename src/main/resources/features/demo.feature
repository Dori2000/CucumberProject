Feature: Nopcommerce page

  Background:
  Given the page with 'https://demo.nopcommerce.com/' is opened
    When we click 'Log in' button from home page

  @Input
  Scenario: Check navigation buttons
    Then check that the following links are shown
      | Register | Log in | Wishlist (0) | Shopping cart (0) |

  @Input
  Scenario: Register user
    And we click 'Register' button from login page
    And we type 'Ledjon' in the 'First name:' input field
    And we type 'Ledjon' in the 'Last name:' input field
    And we type 'ledjon@gmail.com' in the 'Email:' input field
    And we type 'Ledjon' in the 'Password:' input field
    And we type 'Ledjon' in the 'Confirm password:' input field
    And we click 'Register User' button from login page
    Then check the following message is shown on login page
      | Your registration completed |

    #@Input
  Scenario: Log in as user
    And we type 'ledjon@gmail.com' in the 'Email:' input field
    And we type 'Ledjon' in the 'Password:' input field
    When we click 'Log in' button from login page
    Then check the following message is shown on login page
      | Welcome to our store |

  @Input
  Scenario Outline: Register user
    And we click 'Register' button from login page
    And we type '<firstName>' in the 'First name:' input field
    And we type '<lastName>' in the 'Last name:' input field
    And we type 'ledjon@gmail.com' in the 'Email:' input field
    And we type 'Ledjon' in the 'Password:' input field
    And we type 'Ledjon' in the 'Confirm password:' input field
    Examples:
      | firstName | lastName |
      | Ledjon    | Cili     |
      | test      | test     |
      | test      | test     |