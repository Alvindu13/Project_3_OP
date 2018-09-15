package com.company;

import java.util.Scanner;

public class Game {

    /**
     * Affiche texte choix de la longueur du chiffre à trouver
     */
    public void numberRun() {
        System.out.println("Veuillez proposer un nombre entre 1 et 10 pour déterminer le nombre de chiffre de la combinaison à trouver : ");
        Scanner sc = new Scanner(System.in);
        int nb = sc.nextInt();
        this.displayCombinaison(nb);
        this.aleatoireNumber(nb);
    }

    /**
     * Choix du chiffre pour la longueur de la combi
     * @param nC
     */

    public void displayCombinaison(int nC) {
        if (nC >= 1) {
            System.out.println("Vous avez choisi un nombre à " + nC + " chiffres");
        } else {
            System.out.println("Merci de mettre un chiffre valide\n");
            numberRun();
        }
    }

    /**
     * Génère un nombre aléatoire de nB chiffre(s)
     * @param nB
     */

    public void aleatoireNumber(int nB) {
        int bMin=(int)Math.pow(10,nB-1);
        int bMax=(int)Math.pow(10,nB);
        int nombre = (int)(Math.random() * (bMax - bMin)) + bMin ;
        System.out.println("Le nombre est : " + nombre);
        }

}


