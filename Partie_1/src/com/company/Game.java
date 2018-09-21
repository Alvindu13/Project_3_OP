package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Game {
    int nB;
    int essai = 5;
    String[] colours = {"R - Rouge", "J - Jaune", "V - Vert", "B - Bleu", "N - Noir", "G - Gris"};
    Scanner sc = new Scanner(System.in);

    /**
     * Affiche texte choix de la longueur du chiffre à trouver
     */
    public void numberRun() {

        gameChoise();
        // Trouver une façon de ne pas prendre compte des caractères autres que les nombres entier
    }

    /**
     * Permet de connaître le nb de chiffre de la combinaison
     *
     * @param nB nombre de chiffre de la combinaison
     */
    public void availableCommand(int nB) {
        if (nB >= 1 && nB <= 5) {
            System.out.println("Vous avez choisi une combinaison à " + nB + " valeurs");
        } else {
            System.out.println("Je n'ai pas compris votre réponse. Merci de mettre un chiffre valide\n");
            numberRun();
        }
    }

    /**
     * Calcul un nombre aléatoire de nB chiffre(s) et le return
     *
     * @param nB représente la taille de la combi à générer
     * @return le nombre aléatoire généré de nB chiffre(s)
     */
    public int aleatoireNumberAndSelectedNumber(int nB) {
        int bMin = (int) Math.pow(10, nB - 1);
        int bMax = (int) Math.pow(10, nB);
        int nombre = (int) (Math.random() * (bMax - bMin)) + bMin;
        return nombre;
        //this.displayPropose(nombre);
    }

    /**
     * Proposez les propositions pour chercher la combinaison
     *
     * @param n combinaison à trouver
     */

    public void displayPropose(int n) {
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

    /**
     * Retry game
     */

    public void retry() {

        System.out.println();
        System.out.println("Voulez-vous rejouer ? Si oui, veuillez entrer OK. Si non, appuyez sur n'importe quelle touche puis sur entrée");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        while (str.contains("OK")) {
            this.numberRun();
        }
        System.out.println("Je vous remercie d'avoir joué. À bientôt ! ");
    }

    /**
     * Select game and display it
     */
    public void gameChoise() {
        System.out.println("Veuillez choisir le jeu que vous voulez lancer : ");
        String[] gameCh = {"Recherche d'une combinaison de chiffre avec indicateurs +/-", "Recherche d'une combinaison de couleurs avec indicateurs de placement - Mastermind"};
        for (int i = 0; i < 2; i++) {
            System.out.println(i + 1 + " - " + gameCh[i]);
        }
        int n = sc.nextInt();
        switch (n) {
            case 1:
                System.out.println("Veuillez proposer un nombre entre 1 et 5 pour déterminer le nombre de chiffre de la combinaison à trouver : ");
                nB = sc.nextInt();
                this.availableCommand(nB);
                int nA = aleatoireNumberAndSelectedNumber(nB);
                displayPropose(nA);
                retry();
                break;
            case 2:
                System.out.println("Veuillez proposer un nombre entre 1 et 5 pour déterminer le nombre de case de la combinaison de couleurs à trouver : ");
                nB = sc.nextInt();
                availableCommand(nB);
                //System.out.println("Voulez-vous jouer avec des couleurs ou des chiffres ? ");
                //System.out.println("1 - Combinaison de couleurs");
                //System.out.println("2 - Combinaison de chiffres");
                //int nChoise = sc.nextInt();
                //switch (nChoise) {
                //case 1:
                availableColours();
                System.out.println();
                System.out.println("Rappel : ");
                System.out.println("Les couleurs disponibles sont : R - J - V - B - N - G");
                randomColour();
                //break;
                //case 2:
                //break;
                //default:


        }

    }


    public void gameMode() {
        System.out.println("");
    }

    public void availableColours() {
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

    public void randomColour() {

        int s = 0;
        int OKLM = 5;
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
        for (int u = 0; u < nB; u++) {
            rrandomColours[u] = randomColours[u];
        }
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
                randomColour();
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




        /*public void colourGame() {


        }

        //public void placementGame() {

        }


    }*/

            counter = 0;
            s = 0;
            essai--;
            //System.out.println(OKLM);

            //System.out.println(Arrays.toString(stock));
            //System.out.println(Arrays.toString(rrandomColours));

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
        for (int rep = 0; rep < nB; rep++) {
            System.out.print(rrandomColours[rep]);
        }
        }
    }
}



