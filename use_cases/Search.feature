Feature: Search about suitable home

  Background: The System has a repository of homes with their specifications (type-material-placement-pets-amenities-price-area-bedrooms-bathrooms-leaselength)
    Given  the following home is a data in the system

      | Property    | value                            |
      | ID          | 01                               |
      | Type        | House                            |
      | Material    | Wood                             |
      | Placement   | Village                          |
      | Pets        | No                               |
      | Amenities   | GarageParking,FirePlace,Elevator |
      | Price       | 510                              |
      | Area        | 150                              |
      | Bedrooms    | 3                                |
      | Bathrooms   | 2                                |
      | Leaselength | 6                                |

    And the following home is a data in the system

      | Property    | value     |
      | ID          | 02        |
      | Type        | Apartment |
      | Material    | Brick     |
      | Placement   | City      |
      | Pets        | No        |
      | Amenities   | Elevator  |
      | Price       | 230       |
      | Area        | 120       |
      | Bedrooms    | 4         |
      | Bathrooms   | 2         |
      | Leaselength | 12        |


  Scenario Outline: Search about home by specific type (apartment/house)
    When I search about home by type "<type>" specification
    Then A list of homes that matches specifications "<result>" should be returned and printed on the console
    And An Email with a list of search results will be sent to "maysam.m.mousa@gmail.com" customer email
    Examples:
      | type      | result |
      | House     | 01     |
      | Apartment | 02     |

  Scenario Outline: Search home by material
    When I search about home by material "<material>"
    Then A list of homes that matches specifications "<result>" should be returned and printed on the console
    And An Email with a list of search results will be sent to "maysam.m.mousa@gmail.com" customer email

    Examples:
      | material | result |
      | Wood     | 01     |
      | Brick    | 02     |

  Scenario Outline: Search home by placement
    When I search about home by placement as "<place>"
    Then A list of homes that matches specifications "<result>" should be returned and printed on the console
    And An Email with a list of search results will be sent to "maysam.m.mousa@gmail.com" customer email

    Examples:
      | place   | result |
      | Village | 01     |
      | City    | 02     |


  Scenario Outline: Search about home by allow pets
    When I search about home by pets "<pets>" specification
    Then A list of homes that matches specifications "<result>" should be returned and printed on the console
    And An Email with a list of search results will be sent to "maysam.m.mousa@gmail.com" customer email

    Examples:
      | pets | result |
      | Yes  | None   |
      | No   | 01,02  |

  Scenario Outline: Search about home by specific Amenities
    When I search about home with "<amenities>" specification
    Then A list of homes that matches specifications "<result>" should be returned and printed on the console
    And An Email with a list of search results will be sent to "maysam.m.mousa@gmail.com" customer email

    Examples:
      | amenities       | result |
      | AirConditioning | None   |
      | Balcony         | None   |
      | Elevator        | 01,02  |
      | FirePlace       | 01     |
      | GarageParking   | 01     |
      | Swimming Pool   | None   |


  Scenario Outline: Search about home with less than a specific price
    When I search about home with price less than <price_less_than>
    Then A list of homes that matches specifications "<result>" should be returned and printed on the console
    And An Email with a list of search results will be sent to "maysam.m.mousa@gmail.com" customer email

    Examples:
      | price_less_than | result |
      | 600             | 01,02  |
      | 400             | 02     |


  Scenario Outline:Search about home with between specific price
    When I search about home with price less than <price_less_than> and more than <price_more_than>
    Then A list of homes that matches specifications "<result>" should be returned and printed on the console
    And An Email with a list of search results will be sent to "maysam.m.mousa@gmail.com" customer email

    Examples:
      | price_less_than | price_more_than | result |
      | 400             | 200             | 02     |
      | 600             | 500             | 01     |

  Scenario Outline: Search about home with less than a specific area
    When I search about home with area less than <area_less_than>
    Then A list of homes that matches specifications "<result>" should be returned and printed on the console
    And An Email with a list of search results will be sent to "maysam.m.mousa@gmail.com" customer email

    Examples:
      | area_less_than | result |
      | 200            | 01,02  |
      | 140            | 02     |

  Scenario Outline: Search about home with Area in between two specifics sizes
    When I search about home with area less than <area_less_than> and more than <area_more_than>
    Then A list of homes that matches specifications "<result>" should be returned and printed on the console
    And An Email with a list of search results will be sent to "maysam.m.mousa@gmail.com" customer email

    Examples:
      | area_less_than | area_more_than | result |
      | 140            | 100            | 02     |
      | 160            | 100            | 01,02  |

  Scenario Outline: Search about home by number of bedrooms
    When I search about home with specific number of bedrooms <bedrooms>
    Then A list of homes that matches specifications "<result>" should be returned and printed on the console
    And An Email with a list of search results will be sent to "maysam.m.mousa@gmail.com" customer email

    Examples:
      | bedrooms | result |
      | 4        | 02     |
      | 3        | 01     |


  Scenario Outline: Search about home by number of bathrooms
    When I search about home with <bathrooms> bathrooms
    Then A list of homes that matches specifications "<result>" should be returned and printed on the console
    And An Email with a list of search results will be sent to "maysam.m.mousa@gmail.com" customer email

    Examples:
      | bathrooms | result |
      | 2         | 01,02  |
      | 0         | None   |
#
  Scenario Outline: Search about home by specific Lease Length (short term_6 months/long term_year)
    When I search about home with <lease_length> specific lease length
    Then A list of homes that matches specifications "<result>" should be returned and printed on the console
    And An Email with a list of search results will be sent to "maysam.m.mousa@gmail.com" customer email

    Examples:
      | lease_length | result |
      | 6            | 01     |
      | 12           | 02     |


  Scenario Outline: Combined Scenario #1
    When I search about pets "<pets>" and price less than <price>
    Then A list of homes that matches specifications "<result>" should be returned and printed on the console
    And An Email with a list of search results will be sent to "maysam.m.mousa@gmail.com" customer email

    Examples:
      | pets | price | result |
      | No   | 200   | None   |
      | No   | 400   | 02     |
      | Yes  | 2000  | None   |

  Scenario Outline: Combined Scenario #2
    When I search about material "<material>" and price between <price_more_than> and <price_less_than>
    Then A list of homes that matches specifications "<result>" should be returned and printed on the console
    And An Email with a list of search results will be sent to "maysam.m.mousa@gmail.com" customer email

    Examples:
      | material | price_less_than | price_more_than | result |
      | Wood     | 500             | 100             | None   |
      | Brick    | 300             | 150             | 02     |

  Scenario Outline: Combined Scenario #3
    When I search about type "<pets>" and area between <area_more_than> and <area_less_than> and <bathrooms>
    Then A list of homes that matches specifications "<result>" should be returned and printed on the console
    And An Email with a list of search results will be sent to "maysam.m.mousa@gmail.com" customer email

    Examples:
      | pets | area_less_than | area_more_than | bathrooms | result |
      | No   | 200            | 100            | 2         | 01,02  |
      | Yes  | 300            | 250            | 4         | None   |

