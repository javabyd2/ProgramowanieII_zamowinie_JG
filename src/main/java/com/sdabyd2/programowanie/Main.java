package com.sdabyd2.programowanie;

import com.sdabyd2.programowanie.model.Pozycja;
import com.sdabyd2.programowanie.model.Zamowienie;

public class Main {

    public static void main(String[] args) {
        // write your code here

        String destination = "Order.json";

        Pozycja pozycja1 = new Pozycja("Chleb", 1, 3.5);
        System.out.println(pozycja1);
        Pozycja pozycja2 = new Pozycja("Mąka", 3, 2.49);
        System.out.println(pozycja2);
        Pozycja pozycja3 = new Pozycja("mleko", 2, 2.25);
        System.out.println(pozycja3);
        Pozycja pozycja4 = new Pozycja("Makaron", 7, 3.5);
        System.out.println(pozycja4);
        Pozycja pozycja5 = new Pozycja("jogurt", 1, 4.5);
        System.out.println(pozycja5);
        Pozycja pozycja6 = new Pozycja("jogurt", 8, 4.5);


        Zamowienie zamowienie = new Zamowienie(20);

        zamowienie.dodajPozycje(pozycja1);
        zamowienie.dodajPozycje(pozycja2);
        zamowienie.dodajPozycje(pozycja3);
        zamowienie.dodajPozycje(pozycja4);
        zamowienie.dodajPozycje(pozycja5);

        zamowienie.usunPozycje(1);
        zamowienie.edytujPozycje(1, 7, 1, "pomidory");

        System.out.println(zamowienie);

//        zamowienie.zapiszZamowienie(zamowienie, destination);
//        zamowienie.wczytajZamowienie(destination);
        //pozycja1.zapiszZamowienie(zamowienie,destination);
    }
}
