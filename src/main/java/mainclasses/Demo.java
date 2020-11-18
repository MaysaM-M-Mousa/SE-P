package mainclasses;

import searchfeature.SearchByArea;
import searchfeature.SearchInterface;
import searchfeature.SearchLessThanPrice;
import sendmail.EmailService;

import java.util.ArrayList;

public class Demo {

//      | Property    | value     |
//            | ID          | 02        |
//            | Type        | Apartment |
//            | Material    | Brick     |
//            | Placement   | City      |
//            | Pets        | No        |
//            | Amenities   | Elevator  |
//            | Price       | 230       |
//            | Area        | 120       |
//            | Bedrooms    | 4         |
//            | Bathrooms   | 2         |
//            | Leaselength | 12        |


    public static void main(String[] args) {

        Home home1 = new Home("1", "House", "Wood", "Village",
                "GarageParking,FirePlace,Elevator".split(","), 510,
                150, 3, 2, 6, false);

        Home home2 = new Home("2", "Apartment", "Brick", "City",
                "Elevator".split(","), 230,
                120, 4, 2, 12, false);


        ArrayList<Home> list = new ArrayList<>();
        list.add(home1);
        list.add(home2);

        SearchInterface searchObj = new SearchLessThanPrice(300);
        ArrayList<Home> resultHomes = (ArrayList<Home>) searchObj.search(list);


        EmailService emailService = new EmailService();
        emailService.sendMail("maysam.m.mousa@gmail.com", resultHomes);


    }

}
