package com.company;

import java.util.Scanner;

public class Game {

    public void numberRun() {
        System.out.println("Veuillez proposer nombre de chiffres pour la combinaison à rechercher (max 5) : ");
        Scanner sc = new Scanner(System.in);
        int nb = sc.nextInt();
        this.displayCombinaison(nb);
    }


    public void displayCombinaison(int nC) {
        if (nC >= 1) {
            System.out.println("Vous avez choisi un nombre à " + nC + " chiffres");
        } else {
            System.out.println("Merci de mettre un chiffre valide\n");
            numberRun();
        }

    }
    
}