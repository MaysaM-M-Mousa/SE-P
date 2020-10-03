Feature: Search about suitable home

  Background: The System has a repository of homes with their specifications (type-material-placement-pets-amenities-price-area-bedrooms-bathrooms-leaselength)
    Given  the following home is a data in the system
#      | HOUSE_WOOD_VILLAGE_NO_GARAGEPARKING,FIREPLACE,ELEVATOR | 510_150_3_2_6  |
#      | APARTMENT_BRICK_CITY_NO_ELEVATOR                       | 230_120_4_2_12 |

      | Property    | value                            |
      | ID          | 01                               |
      | Type        | House                            |
      | Material    | Wood                             |
      | Placement   | Village                          |
      | Pets        | No                               |
      | Amenities   | GARAGEPARKING,FIREPLACE,ELEVATOR |
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
      | Amenities   | ELEVATOR  |
      | Price       | 230       |
      | Area        | 120       |
      | Bedrooms    | 4         |
      | Bathrooms   | 2         |
      | Leaselength | 12        |


  Scenario Outline: Search about home by specific type (apartment/house)
    When I search about home by type "<type>" specification
    Then A list of homes that matches specifications "<result>" should be returned and printed on the console
    Examples:
      | type      | result |
      | House     | 01     |
      | Apartment | 02     |

  Scenario Outline: Search home by material
    When I search about home by material "<material>"
    Then A list of homes that matches specifications "<result>" should be returned and printed on the console
    Examples:
      | material | result |
      | Wood     | 01     |
      | Brick    | 02     |

#  TODO: Implement placement scenario
#  Scenario Outline: Search home by placement
#    When I search about home by placement as "<place>"
#    Then A list of homes that matches specifications "<result>" should be returned and printed on the console
#    Examples:
#      | place   | result |
#      | Village | 01     |
#      | City    | 02     |


  Scenario Outline: Search about home by allow pets
    When I search about home by pets "<pets>" specification
    Then A list of homes that matches specifications "<result>" should be returned and printed on the console
    Examples:
      | pets | result |
      | Yes  | None   |
      | No   | 01,02  |

#  TODO: Implement Amenities scenario
#  Scenario Outline: Search about home by specific Amenities
#    When I search about home with "<amenities>" specification
#    Then A list of homes that matches specifications "<result>" should be returned and printed on the console
#    Examples:
#      | amenities       | result |
#      | AirConditioning | 01     |
#      | Balcony         | None   |
#      | Elevator        | 01,02  |
#      | FirePlace       | 01     |
#      | GarageParking   | 01     |
#      | Swimming Pool   | None   |


#  TODO: Implement specific price scenario
#  Scenario Outline: Search about home with less than a specific price
#    When I search about home with price less than "<price_less_than>"
#    Then A list of homes that matches specifications "<result>" should be returned and printed on the console
#    Examples:
#      | price_less_than | result |
#      | 600             | 01,02  |
#      | 400             | 02     |


#  TODO: Implement between specific price scenario
#  Scenario Outline:Search about home with between specific price
#    When I search about home with price less than "<price_less_than>" and more than "<price_more_than>"
#    Then A list of homes that matches specifications "<result>" should be returned and printed on the console
#    Examples:
#      | price_less_than | price_more_than | result |
#      | 400             | 200             | 02     |
#      | 600             | 500             | 01     |

#  TODO: Implement specific area scenario
#  Scenario Outline: Search about home with less than a specific area
#    When I search about home with area less than "<area_less_than>"
#    Then A list of homes that matches specifications "<result>" should be returned and printed on the console
#    Examples:
#      | area_less_than | result |
#      | 200            | 01,02  |
#      | 140            | 02     |

#  TODO: Implement specifics sizes scenario
#  Scenario Outline: Search about home with Area in between two specifics sizes
#    When I search about home with area less than "<area_less_than>" and more than "<area_more_than>"
#    Then A list of homes that matches specifications "<result>" should be returned and printed on the console
#    Examples:
#      | area_less_than | area_more_than | result |
#      | 140            | 100            | 02     |
#      | 160            | 100            | 01,02  |

#  TODO: Implement number of bedrooms scenario
#  Scenario Outline: Search about home by number of bedrooms
#    When I search about home with specific number of bedrooms "<bedrooms>"
#    Then A list of homes that matches specifications "<result>" should be returned and printed on the console
#    Examples:
#      | bedrooms | result |
#      | 4        | 02     |
#      | 3        | 01     |

#  TODO: Implement by number of bedrooms scenario
#  Scenario Outline: Search about home by number of bedrooms
#    When I search about home with specific number of bedrooms "<bedrooms>"
#    Then A list of homes that matches specifications "<result>" should be returned and printed on the console
#    Examples:
#      | bedrooms | result |
#      | 4        | 02     |
#      | 3        | 01     |

#  TODO: Implement number of bathrooms scenario
#  Scenario : Search about home by number of bathrooms
#    When I search about home with 2 bathrooms
#    Then A list of homes that matches specifications "<result>" should be returned and printed on the console

#  TODO: Implement Lease Length scenario
#  Scenario Outline: Search about home by specific Lease Length (short term_6 months/long term_year)
#    When I search about home with "<lease_length>" specification
#    Then A list of homes that matches specifications "<result>" should be returned and printed on the console
#    Examples:
#      | lease_length        | result |
#      | short term_6 months | 01     |
#      | long term_year      | 02     |


