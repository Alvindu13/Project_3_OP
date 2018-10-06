package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Scanner;


public class GameSelector {
    private MastermindGame mastermindGame;
    private PlusMoinsGame plusMoinsGame;
    private int nbCases;
    private int nbTry;
    private int nbAvailableColours;
    private Scanner sc = new Scanner(System.in);


    /**
     * Affiche texte choix de la longueur du chiffre à trouver
     */
    public void numberRun() {

        Properties prop = new Properties();
        try {
            prop.load(new FileReader("src/main/resources/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        nbCases = Integer.parseInt(prop.getProperty("nombre.cases"));
        nbTry = Integer.parseInt(prop.getProperty("nombre.essai"));
        nbAvailableColours = Integer.parseInt(prop.getProperty("mastermind.nombre.couleurs"));
        int modeGame = gameMode();
        gameChoise(modeGame);
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
    public void gameChoise(int gameMode) {
        int numberGame = 0;
        boolean numberChoiseIsGood;
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
            this.readParameters();
            plusMoinsGame = new PlusMoinsGame(nbCases, nbTry, nbAvailableColours);
            if(numberGame == 1 && gameMode ==1)
                plusMoinsGame.challengeMode();
            else if(numberGame == 1 && gameMode == 2)
                plusMoinsGame.defenseMode();
            else if(numberGame == 1 && gameMode == 3)
                plusMoinsGame.dualMode();
            if(numberGame == 2 && gameMode == 1) {
                mastermindGame = new MastermindGame(nbCases, nbTry, nbAvailableColours);
                mastermindGame.challengeMode();
            }
            else if(numberGame == 2 && gameMode == 2)
                mastermindGame.defenseMode();
            }
        this.retry();
    }

    public int gameMode() {

        int choise;
        String[] arrayMode = {"1 - Mode Challenger : vous devez trouver la combinaison secrète de l'ordinateur", "2 - Mode Défenseur : où c'est à l'ordinateur de trouver votre combinaison secrète ", "3 - Mode duel : où l'ordinateur et vous jouez tour à tour, le premier à trouver la combinaison secrète de l'autre a gagné"};
        System.out.println("Veuillez choisir le mode de jeu :");
        for (int index = 0; index < arrayMode.length; index++)
            System.out.println(arrayMode[index]);
        choise = sc.nextInt();

        return choise;
        }


    public void readParameters() {
        try {
            Properties prop = new Properties();
            prop.load(new FileReader("src/main/resources/config.properties"));
            this.nbCases = Integer.parseInt(prop.getProperty("nombre.cases"));
            this.nbTry = Integer.parseInt(prop.getProperty("nombre.essai"));
            this.nbAvailableColours = Integer.parseInt(prop.getProperty("mastermind.nombre.couleurs"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public int getNbAvailableColours(){
        Properties prop = new Properties();
        try {
            prop.load(new FileReader("src/main/resources/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.nbAvailableColours = Integer.parseInt(prop.getProperty("mastermind.nombre.couleurs"));
        return nbAvailableColours;
    }


}








