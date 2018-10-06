package com.company.test;

import java.util.ArrayList;
import java.util.Iterator;

import static java.util.Collections.shuffle;

public class TestList {
        public static void main(String[] args) {
            ArrayList<String> maListe = new ArrayList<String>();
            maListe.add("Permier Element" );
            maListe.add("Second Element" );
            maListe.add("Troisieme Element" );
            maListe.add("Quatrieme Element" );
            maListe.add("Cinquieme Element" );
            for(int i = 0 ; i < maListe.size(); i++){
                String maValeur = maListe.get(i);
                System.out.println(maValeur);
            }

            shuffle(maListe);
            System.out.println();
            /*maListe.add(2,"Entre 2 et 3" );
            maListe.add(4,"Entre 3 et 4" );*/

            Iterator<String> it = maListe.iterator();
            while(it.hasNext()){
                System.out.println(it.next());
            }
        }
    }

