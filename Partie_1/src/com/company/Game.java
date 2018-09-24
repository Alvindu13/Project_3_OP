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

        gameMode();
        gameChoise();
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
                    Game1.randomNumberAndSelectedNumber(nB);
                    this.retry();
                    break;
                case 2:
                    this.availableCommand(nB);
                    Game2Mastermind.availableColours();
                    System.out.println();
                    System.out.println("Rappel : ");
                    System.out.println("Les couleurs disponibles sont : R - J - V - B - N - G");
                    Game2Mastermind.randomColourGame(nB);
            }
        }
    }

    public void gameMode() {
        int choise;
        String[] arrayMode = {"1 - Mode Challenger : vous devez trouver la combinaison secrète de l'ordinateur", "2 - Mode Défenseur : où c'est à l'ordinateur de trouver votre combinaison secrète ", "3 - Mode duel : où l'ordinateur et vous jouez tour à tour, le premier à trouver la combinaison secrète de l'autre a gagné"};
        System.out.println("Veuillez choisir le mode de jeu : ");
        for(int index = 0; index < arrayMode.length; index++)
            System.out.println(arrayMode[index]);
        choise = sc.nextInt();
    }

}





        /*public void colourGame() {


        }

        //public void placementGame() {

        }


    }*/





