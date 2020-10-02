Feature: Search about suitable home

  Background: The System has a repository of homes with their specifications (type-material-placement-pets-amenties-price-area-bedrooms-bathrooms-leaselength)
    Given  these homes are contained in the system
      | HOUSE_WOOD_VILLAGE_NO_GARAGEPARKING,FIREPLACE,ELEVATOR | 510_150_3_2_6  |
      | APARTMENT_BRICK_CITY_NO_ELEVATOR                       | 230_120_4_2_12 |


  Scenario Outline: Search home by placement
    When I search about home by placement as  "<place>"
    Then A list of homes that matches the  type specification "<result>" should be returned and printed on the console
    Examples:
      | place   | result                                                               |
      | village | HOUSE_WOOD_VILLAGE_NO_GARAGEPARKING,FIREPLACE,ELEVATOR 510_150_3_2_6 |
      | city    | APARTMENT_BRICK_CITY_NO_ELEVATOR 230_120_4_2_12                      |

  Scenario Outline: Search home by material
    When I search about home by material <material>
    Then A list of homes that matches the type specification "<result>" should be returned and printed on the console
    Examples:
      | material | result                                                               |
      | brick    | HOUSE_WOOD_VILLAGE_NO_GARAGEPARKING,FIREPLACE,ELEVATOR 510_150_3_2_6 |
      | wood     | APARTMENT_BRICK_CITY_NO_ELEVATOR 230_120_4_2_12                      |

  Scenario Outline: Search about home with less than a specific price
    When I search about home with price less than <price_less_than>
    Then A list of homes that matches the price specification "<result>" should be returned and printed on the console
    Examples:
      | price_less_than | result                                                               |
      | 400             | APARTMENT_BRICK_CITY_NO_ELEVATOR 230_120_4_2_12                      |
      | 600             | HOUSE_WOOD_VILLAGE_NO_GARAGEPARKING,FIREPLACE,ELEVATOR 510_150_3_2_6 |

  Scenario Outline: Search about home with price in between two specifics prices
    When I search about home with price less than <price_less_than> and more than <price_more_than>
    Then A list of homes that matches the price specification as "<result>" should be returned and printed on the console
    Examples:
      | price_less_than | price_more_than | result                                                               |
      | 400             | 200             | APARTMENT_BRICK_CITY_NO_ELEVATOR 230_120_4_2_12                      |
      | 600             | 500             | HOUSE_WOOD_VILLAGE_NO_GARAGEPARKING,FIREPLACE,ELEVATOR 510_150_3_2_6 |

  Scenario Outline: Search about home with less than a specific area
    When I search about home with area less than <area_less_than>
    Then A list of homes that matches the price specification "<result>" should be returned and printed on the console
    Examples:
      | area_less_than | result                                                                                                               |
      | 200            | APARTMENT_BRICK_CITY_NO_ELEVATOR 230_120_4_2_12,HOUSE_WOOD_VILLAGE_NO_GARAGEPARKING,FIREPLACE,ELEVATOR 510_150_3_2_6 |
      | 140            | APARTMENT_BRICK_CITY_NO_ELEVATOR 230_120_4_2_12                                                                      |

  Scenario Outline: Search about home with Area in between two specifics sizes
    When I search about home with area less than <area_less_than> and more than <area_more_than>
    Then A list of homes that matches the price specification as "<result>" should be returned and printed on the console
    Examples:
      | area_less_than | area_more_than | result                                                                                                                |
      | 140            | 100            | APARTMENT_BRICK_CITY_NO_ELEVATOR 230_120_4_2_12                                                                       |
      | 160            | 100            | HOUSE_WOOD_VILLAGE_NO_GARAGEPARKING,FIREPLACE,ELEVATOR 510_150_3_2_6, APARTMENT_BRICK_CITY_NO_ELEVATOR 230_120_4_2_12 |

  Scenario Outline: Search about home by number of bedrooms
    When I search about home with specific number of bedrooms <bedrooms>
    Then A list of homes that matches specific number of bedrooms specification as "<result>" should be returned and printed on the console
    Examples:
      | bedrooms | result                                                               |
      | 4        | APARTMENT_BRICK_CITY_NO_ELEVATOR 230_120_4_2_12                      |
      | 3        | HOUSE_WOOD_VILLAGE_NO_GARAGEPARKING,FIREPLACE,ELEVATOR 510_150_3_2_6 |

  Scenario Outline: Search about home by number of bedrooms
    When I search about home with specific number of bedrooms <bedrooms>
    Then A list of homes that matches specific number of bedrooms specification as "<result>" should be returned and printed on the console
    Examples:
      | bedrooms | result                                                               |
      | 4        | APARTMENT_BRICK_CITY_NO_ELEVATOR 230_120_4_2_12                      |
      | 3        | HOUSE_WOOD_VILLAGE_NO_GARAGEPARKING,FIREPLACE,ELEVATOR 510_150_3_2_6 |

  Scenario : Search about home by number of bathrooms
    When I search about home with 2 bathrooms
    Then A list of homes that matches specific number of bathrooms specification as "APARTMENT_BRICK_CITY_NO_ELEVATOR 230_120_4_2_12,HOUSE_WOOD_VILLAGE_NO_GARAGEPARKING,FIREPLACE,ELEVATOR 510_150_3_2_6" should be returned and printed on the console


  Scenario Outline: Search about home by allow pets
    When I search about home with <pets> specification
    Then A list of homes that matches specifications <result> should be returned and printed on the console
    Examples:
      | pets | result                                                                                                               |
      | yes  |                                                                                                                      |
      | no   | HOUSE_WOOD_VILLAGE_NO_GARAGEPARKING,FIREPLACE,ELEVATOR 510_150_3_2_6,APARTMENT_BRICK_CITY_NO_ELEVATOR 230_120_4_2_12 |

  Scenario Outline: Search about home by specific type (apartment/house)
    When I search about home with <type> specification
    Then A list of homes that matches specifications <result> should be returned and printed on the console
    Examples:
      | type      | result                                                               |
      | house     | HOUSE_WOOD_VILLAGE_NO_GARAGEPARKING,FIREPLACE,ELEVATOR 510_150_3_2_6 |
      | apartment | APARTMENT_BRICK_CITY_NO_ELEVATOR 230_120_4_2_12                      |

  Scenario Outline: Search about home by specific Lease Length (short term_6 months/long term_year)
    When I search about home with <lease_length> specification
    Then A list of homes that matches specifications <result> should be returned and printed on the console
    Examples:
      | lease_length        | result                                                               |
      | short term_6 months | HOUSE_WOOD_VILLAGE_NO_GARAGEPARKING,FIREPLACE,ELEVATOR 510_150_3_2_6 |
      | long term_year      | APARTMENT_BRICK_CITY_NO_ELEVATOR 230_120_4_2_12                      |

  Scenario Outline: Search about home by specific Amenities
    When I search about home with <amenities> specification
    Then A list of homes that matches specifications <result> should be returned and printed on the console
    Examples:
      | amenities       | result                                                                                                               |
      | AirConditioning | HOUSE_WOOD_VILLAGE_NO_GARAGEPARKING,FIREPLACE,ELEVATOR 510_150_3_2_6                                                 |
      | Balcony         |                                                                                                                      |
      | Elevator        | APARTMENT_BRICK_CITY_NO_ELEVATOR 230_120_4_2_12,HOUSE_WOOD_VILLAGE_NO_GARAGEPARKING,FIREPLACE,ELEVATOR 510_150_3_2_6 |
      | FirePlace,      | HOUSE_WOOD_VILLAGE_NO_GARAGEPARKING,FIREPLACE,ELEVATOR 510_150_3_2_6                                                 |
      | GarageParking   | HOUSE_WOOD_VILLAGE_NO_GARAGEPARKING,FIREPLACE,ELEVATOR 510_150_3_2_6                                                 |
      | Swimming Pool   |                                                                                                                      |

