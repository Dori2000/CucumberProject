Feature: One Al

  #@Input
  Scenario: Test 1
    Given one al home page is opened
    Then click on 'Llogaria ime' button
    And type 'test' on 'E-Mail' pop-up input text form
    And type 'test' on 'Password' pop-up input text form
    Then click on 'Hyr' button
    And check the following error message is shown
      | Të dhënat e vendosura për të hyrë në Llogaria ime janë gabim. |

  #@Input
  Scenario: Test 2
    Given one al home page is opened
    Then click on 'Llogaria ime' button
    And type ' ' on 'E-Mail' pop-up input text form
    And type ' ' on 'Password' pop-up input text form
    And check the following error message is shown
      | Emri i përdoruesit është i detyrueshëm |

  #@Input
  Scenario: Test 3
    Given one al home page is opened
    And check the following terms & conditions info is shown
      | Ky website përdor “cookies”. Duke lundruar në website ju pranoni përdorimin e këtij informacioni nga ana jonë. |
    Then click on 'Prano' button
    And check terms & conditions info is not shown anymore