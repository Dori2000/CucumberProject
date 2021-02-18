Feature: 1 - Cucumber + Selenium scenarios

  #@Input
  Scenario:Test 1
    Given the main page is opened
    Then make sure ad pop-up is closed
    And check the following categories are shown under menu list
      | Input Forms             |
      | Date pickers            |
      | Table                   |
      | Progress Bars & Sliders |
      | Alerts & Modals         |
      | List Box                |
      | Others                  |

  #@Input
  Scenario:Test 2
    Given the main page is opened
    Then make sure ad pop-up is closed
    Then click on 'Input Forms' list sub-element
    And check the following sub categories are shown under 'Input Forms'
      | Simple Form Demo       |
      | Checkbox Demo          |
      | Radio Buttons Demo     |
      | Select Dropdown List   |
      | Input Form Submit      |
      | Ajax Form Submit       |
      | JQuery Select dropdown |

  #@Input
  Scenario:Test 3
    Given the main page is opened
    Then make sure ad pop-up is closed
    Then click on 'Input Forms' list sub-element
    And click on 'Simple Form Demo' sub-item of 'Input Forms' item
    Then type '20' on 'Enter a' input text form
    Then type '30' on 'Enter b' input text form
    And click the 'Get Total' button
    And check the following result is shown under 'Two Input Fields' panel
      | Total a + b = 50 |

  #@Input
  Scenario:Test 4
    Given the main page is opened
    Then make sure ad pop-up is closed
    Then click on 'Input Forms' list sub-element
    And click on 'Simple Form Demo' sub-item of 'Input Forms' item
    Then type 'test' on 'Enter message' input text form
    And click the 'Show Message' button
    And check the following result is shown under 'Single Input Field' panel
      | Your Message: test |

  #@Input
  Scenario:Test 5
    Given the main page is opened
    Then make sure ad pop-up is closed
    Then click on 'Input Forms' list sub-element
    And click on 'Checkbox Demo' sub-item of 'Input Forms' item
    And click the 'Check All' button
    Then make sure all options are 'checked'
    And click the 'Uncheck All' button
    Then make sure all options are 'unchecked'

  #@Input
  Scenario:Test 6
    Given the main page is opened
    Then make sure ad pop-up is closed
    Then click on 'Input Forms' list sub-element
    And click on 'Radio Buttons Demo' sub-item of 'Input Forms' item
    And click the 'Male' radio button
    And click the 'Get Checked value' button
    And check the following result is shown under 'Radio Button Demo' panel
      | Radio button 'Male' is checked |

  #@Input
  Scenario:Test 7
    Given the main page is opened
    Then make sure ad pop-up is closed
    Then click on 'Alerts & Modals' list sub-element
    And click on 'Javascript Alerts' sub-item of 'Alerts & Modals' item
    And click the 'Click me!' button
    Then check alert has the following text
      | I am an alert box! |
    Then 'accept' the alert

  #@Input
  Scenario:Test 8
    Given the main page is opened
    Then make sure ad pop-up is closed
    Then click on 'Alerts & Modals' list sub-element
    And click on 'Javascript Alerts' sub-item of 'Alerts & Modals' item
    And click the 'Click for Prompt Box' button
    Then enter 'test' on alter input field
    Then 'accept' the alert
    And check the following result is shown under 'Java Script Alert Box' panel
      | You have entered 'test' ! |