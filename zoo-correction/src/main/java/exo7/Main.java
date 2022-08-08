package exo7;

import exo7.classes.Apartment;
import exo7.classes.House;
import exo7.classes.Person;
import exo7.interfaces.IHouse;

public class Main {
    public static void main(String[] args) {
        Person pierre = new Person("Pierre");
        IHouse house = new House(100, "beige");
        pierre.setHouse(house);
        System.out.println(pierre.Display());

        Person marie = new Person("Marie");
        House apartment = new Apartment("blanche");
        marie.setHouse(apartment);
        System.out.println(marie.Display());
    }
}
