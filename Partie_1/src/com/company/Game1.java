package com.company;

import java.util.Scanner;

public class Game1 {
    /**
     * Calcul un nombre aléatoire de nB chiffre(s) et le return
     * @param nB représente la taille de la combi à générer
     * @return le nombre aléatoire généré de nB chiffre(s)
     */
    public static void randomNumberAndSelectedNumber(int nB) {
        int bMin = (int) Math.pow(10, nB - 1);
        int bMax = (int) Math.pow(10, nB);
        int randomNumber = (int) (Math.random() * (bMax - bMin)) + bMin;
        Game1.displayPropose(randomNumber);
    }

    /**
     * Proposez les propositions pour chercher la combinaison
     * @param n combinaison à trouver
     */
    public static void displayPropose(int n) {
        int essai = 5;
        int m;
        int i;
        System.out.println("Vous avez le droit à 5 tentatives");
        System.out.print("Merci faire votre proposition : ");
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println();
            System.out.println("Il vous reste encore " + essai + " tentatives");
            m = sc.nextInt();
            String F = String.valueOf(n);
            String G = String.valueOf(m);
            //System.out.println("Combinaison secrète : " + n);
            System.out.print("Votre proposition : " + m + " -> réponse : ");
            for (i = 0; i < F.length(); i++) {
                if (G.charAt(i) == F.charAt(i)) {
                    System.out.print("=");
                } else if (G.charAt(i) < F.charAt(i)) {
                    System.out.print("+");
                } else if (G.charAt(i) > F.charAt(i)) {
                    System.out.print("-");
                }
            }
            essai--;
        } while (m != n && essai != 0);
        if (m == n) {
            System.out.println();
            System.out.println("Bravo ! La combinaison secrète était bien " + n);
        } else {
            System.out.println();
            System.out.println("Malheureusement vous n'avez pas trouvé la bonne combinaison qui était :  " + n);
        }
    }
}

