package com.company;

import java.util.Scanner;

public class Game2Mastermind {
    int essai = 5;
    /**
     * Create a random array char with colours
     * @param nB size of array
     */
    public void challengeMode(int nB) {
        int s = 0;
        int indice = 0;
        int counter = 0;
        char[] colours1 = {'R', 'J', 'V', 'B', 'N', 'G'};
        char[] randomColours = new char[nB];
        char[] rrandomColours = new char[nB];
        char[] responseS = new char[nB];
        char[] stock = new char[nB];
        System.out.println("La combinaison secrète est : ");
        for (int k = 0; k < nB; k++) {
            int bMin = 0;
            int bMax = 5;
            int nomb = (int) (Math.random() * (bMax - bMin)) + bMin;
            randomColours[k] = colours1[nomb];
            System.out.print(randomColours[k]);
        }
        for (int u = 0; u < nB; u++)
            rrandomColours[u] = randomColours[u];
        for (int om = 0; om < 5; om++) {
            char[] testA = {'0', '1', '2', '3', '4'};
            char[] testB = {'5', '6', '7', '8', '9'};
            System.out.println();
            System.out.println("Il vous reste encore " + essai + " tentatives");
            Scanner nk = new Scanner(System.in);
            String response = nk.nextLine();
            for (int jk = 0; jk < nB; jk++) {
                responseS[jk] = response.charAt(jk);
                randomColours[jk] = rrandomColours[jk];
                stock[jk] = responseS[jk];
            }
            while (response.length() != nB) {
                System.out.println("Merci de faire une proposition valide : ");
                challengeMode(nB);
            }
            for (int i = 0; i < nB; i++) {
                for (int o = 0; o < nB; o++) {
                    if (randomColours[o] == responseS[i] && o == i) {
                        counter++;
                        s++;
                        responseS[i] = testA[i];
                        randomColours[o] = testB[o];
                    }
                }
            }
            for (int q = 0; q < nB; q++) {
                for (int r = 0; r < nB; r++) {
                    if (randomColours[r] == responseS[q]) {
                        responseS[q] = testA[q];
                        randomColours[r] = testB[r];
                        s++;
                    }
                }
            }
            if (counter == 1) {
                System.out.print(counter + " bien placé");
            } else {
                System.out.print(counter + " bien placés");
            }
            System.out.print(", " + s + "  présent(s)");

            counter = 0;
            s = 0;
            essai--;
            for (indice = 0; indice < stock.length && stock[indice] == rrandomColours[indice]; indice++);

            if (indice == nB){
                System.out.println();
                System.out.println("Bravo vous avez trouver la bonne combinaison. C'était bien : ");
                for (int rep = 0; rep < nB; rep++) {
                    System.out.print(rrandomColours[rep]);
                }
                break;
            }
        }
        if(indice != nB){
            System.out.print("Malheureusement, vous n'avez pas trouvé la réponse. La réponse était  : ");
            for (int rep = 0; rep < nB; rep++)
                System.out.print(rrandomColours[rep]);
        }
    }

    /**
     * Display available colours
     */
    public void availableColours() {
        String[] colours = {"R - Rouge", "J - Jaune", "V - Vert", "B - Bleu", "N - Noir", "G - Gris"};
        System.out.println("Pour prendre connaissance des couleurs disponibles avant de jouer, merci d'entrer V dans le terminal : ");
        Scanner sc = new Scanner(System.in);
        String response = sc.nextLine();
        if ("V".contains(Character.toString(response.charAt(0)))) {
            System.out.println("Voici les couleurs disponibles : ");
            for (int i = 1; i <= 6; i++)
                System.out.println(colours[i - 1]);
        } else {
            System.out.println("Je ne comprends pas votre réponse, merci de rentrer une valeur valide");
            availableColours();
        }
    }

    public static void defenseMode(){

    }
}

