package com.sdabyd2.programowanie.model;

import com.sdabyd2.programowanie.model.Pozycja;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Zamowienie implements Serializable {

    int ileDodanych;
    int maksRozmiar;
    List<Pozycja> pozycje = new ArrayList<>();
  //  ObjectMapper mapper = new ObjectMapper();
    double calkowitaWartoscZamowienia;
    int ilośćMaksymalna;


    public List<Pozycja> getPozycje() {
        return pozycje;
    }



    public void setPozycje(List<Pozycja> pozycje) {
       this.pozycje = pozycje;
    }

    public Zamowienie() {
        this.maksRozmiar = 20;

    }

    public Zamowienie(int ileDodanych) {
        this.ileDodanych = ileDodanych;
    }

    public void dodajPozycje(Pozycja p) {

        pozycje.add(p);

        for (int i = 0; i < pozycje.size(); i++) {
            ilośćMaksymalna += pozycje.get(i).getIleSztuk();
            for (int j = 0; j < pozycje.size(); j++) {
                if (pozycje.get(i).getNazwaTowaru().equals(pozycje.get(j).getNazwaTowaru()) && i != j) {
                    pozycje.get(i).setIleSztuk(pozycje.get(i).getIleSztuk() + pozycje.get(j).getIleSztuk());
                    pozycje.remove(j);
                }
            }
        }
    }

    public double obliczWartoscCala() {

        for (int i = 0; i < pozycje.size(); i++) {
            calkowitaWartoscZamowienia += pozycje.get(i).obliczWartosc() - pozycje.get(i).obliczWartoscZRabatem();
            if (pozycje.get(i).getRabat() > 0)
                System.out.println("kwota rabatu za: " + pozycje.get(i).getNazwaTowaru() + ": " + (String.format("%.2f", pozycje.get(i).getRabat())) + " zł");

        }
        return calkowitaWartoscZamowienia;
    }

    @Override
    public String toString() {

        System.out.println("\nZamowienie: ");
        for (int i = 0; i < pozycje.size(); i++) {
            System.out.println(pozycje.get(i));

        }
        return "\nwartość całkowita po uwzglednieniu rabatu : " + obliczWartoscCala() + " zł";
    }

    public void usunPozycje(int indeks) {
        pozycje.remove(indeks);
    }

   public void edytujPozycje(int indeks, double cena, int sztuk, String nazwa) {
        pozycje.get(indeks).cena = cena;
        pozycje.get(indeks).ileSztuk = sztuk;
        pozycje.get(indeks).nazwaTowaru = nazwa;
    }}




