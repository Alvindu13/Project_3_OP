package com.company;

import java.util.Scanner;

public class Game1 {
    /**
     * Calcul un nombre aléatoire de nB chiffre(s) et le return
     * @param nbCases représente la taille de la combi à générer
     * @return le nombre aléatoire généré de nB chiffre(s)
     */
    public static void randomNumberAndSelectedNumber(int nbCases) {
        int bMin = (int) Math.pow(10, nbCases-1);
        int bMax = (int) Math.pow(10, nbCases);
        int randomNumber = (int) (Math.random() * (bMax - bMin)) + bMin;
        Game1.displayPropose(randomNumber);
    }

    /**
     * Proposez les propositions pour chercher la combinaison
     * @param randomNumber combinaison à trouver
     */
    public static void displayPropose(int randomNumber) {
        int essai = 5;
        int userProposal;
        int i;
        System.out.print("Merci faire votre proposition : ");
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println();
            System.out.println("Il vous reste encore " + essai + " tentatives");
            userProposal = sc.nextInt();
            String F = String.valueOf(randomNumber);
            String G = String.valueOf(userProposal);
            //System.out.println("Combinaison secrète : " + n);
            System.out.print("Votre proposition : " + userProposal + " -> réponse : ");
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
        } while (userProposal != randomNumber && essai != 0);
        if (userProposal == randomNumber) {
            System.out.println();
            System.out.println("Bravo ! La combinaison secrète était bien " + randomNumber);
        } else {
            System.out.println();
            System.out.println("Malheureusement vous n'avez pas trouvé la bonne combinaison qui était :  " + randomNumber);
        }
    }
}

