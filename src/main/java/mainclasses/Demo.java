package mainclasses;

import searchfeature.SearchInterface;
import searchfeature.SearchLessThanPrice;
import sendmail.EmailService;

import java.util.ArrayList;

public class Demo {


    public static void main(String[] args) {


        Home home1=new Home();
        home1.setID("1");
        home1.setType("House");
        home1.setMaterial("Wood");
        home1.setPlacement("Village");
        home1.setAmenities("GarageParking,FirePlace,Elevator".split(","));
        home1.setPrice(510);
        home1.setArea(150);
        home1.setBedrooms(3);
        home1.setBathrooms(2);
        home1.setLeaseLength(6);
        home1.setPets(false);

        Home home2=new Home();
        home2.setID("2");
        home2.setType("Apartment");
        home2.setMaterial("Brick");
        home2.setPlacement("City");
        home2.setAmenities("Elevator".split(","));
        home2.setPrice(230);
        home2.setArea(120);
        home2.setBedrooms(4);
        home2.setBathrooms(2);
        home2.setLeaseLength(12);
        home2.setPets(false);
        ArrayList<Home> list = new ArrayList<>();


        list.add(home1);
        list.add(home2);

        SearchInterface searchObj = new SearchLessThanPrice(300);
        ArrayList<Home> resultHomes = (ArrayList<Home>) searchObj.search(list);


        EmailService emailService = new EmailService();
        emailService.sendMail("maysam.m.mousa@gmail.com", resultHomes);


    }



}
