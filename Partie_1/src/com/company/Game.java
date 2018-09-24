package com.company;

import java.util.InputMismatchException;
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
        int numberGame = 0;
        boolean numberChoiseIsGood;
        boolean numberLength;
        System.out.println("Veuillez choisir le jeu que vous voulez lancer : ");
        String[] gameCh = {"Recherche d'une combinaison de chiffre avec indicateurs +/-", "Recherche d'une combinaison de couleurs avec indicateurs de placement - Mastermind"};
        for (int i = 0; i < 2; i++)
            System.out.println(i + 1 + " - " + gameCh[i]);
        do {
            try {
                numberGame = sc.nextInt();
                if (numberGame >= 1 && numberGame <= 2) {
                    numberChoiseIsGood = true;
                } else {
                    numberChoiseIsGood = false;
                    System.out.println("Vous devez saisir un nombre valide");
                }
            } catch (InputMismatchException e) {
                sc.next();
                System.out.println("Vous devez saisir un nombre, correspondant au jeu choisi");
                numberChoiseIsGood = false;
            }
        } while (!numberChoiseIsGood);
        if (numberChoiseIsGood) {
            do {
                System.out.println("Veuillez proposer un nombre entre 1 et 5 pour déterminer le nombre de chiffre ou de couleurs de la combinaison à trouver : ");
                try {
                    nB = sc.nextInt();
                    if (nB >= 1 && nB <= 5)
                        numberLength = true;
                    else{
                        numberLength = false;
                        System.out.println("Vous devez saisir un nombre valide");
                    }
                } catch (InputMismatchException e) {
                    sc.next();
                    System.out.println("Vous devez saisir un nombre valide");
                    numberLength = false;
                }
            } while (!numberLength);
            switch (numberGame) {
                case 1:
                    this.availableCommand(nB);
                    int nA = aleatoireNumberAndSelectedNumber(nB);
                    this.displayPropose(nA);
                    this.retry();
                    break;
                case 2:
                    this.availableCommand(nB);
                    this.availableColours();
                    System.out.println();
                    System.out.println("Rappel : ");
                    System.out.println("Les couleurs disponibles sont : R - J - V - B - N - G");
                    Game2Mastermind.randomColourGame(nB);
            }
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
}





        /*public void colourGame() {


        }

        //public void placementGame() {

        }


    }*/





