package com.company;

import java.util.Scanner;

public class Game2Mastermind {

    public static void randomColourGame(int nB) {
        int essai = 5;
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
                randomColourGame(nB);
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
}

