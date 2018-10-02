package com.company;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Scanner;

public class Game {
    Game2Mastermind Game2Mastermind = new Game2Mastermind();
    int nbCases;
    int nbTry;
    int nbAvailableColours;
    char[] formatColoursGame = new char[10];
    Scanner sc = new Scanner(System.in);

    /**
     * Affiche texte choix de la longueur du chiffre à trouver
     */
    public void numberRun() {
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
        boolean whatGame;
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
            switch (numberGame) {
                case 1:
                    whatGame = false;
                    this.readParameters(whatGame);
                    Game1.randomNumberAndSelectedNumber(nbCases);
                    this.retry();
                    break;
                case 2:
                    whatGame = true;
                    this.readParameters(whatGame);
                    if (gameMode == 1)
                        Game2Mastermind.challengeModeMastermind(nbCases, formatColoursGame);
                    else if(gameMode == 2)
                        Game2Mastermind.defenseModeMastermind(nbCases, formatColoursGame);
            }
        }
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


    public void readParameters(boolean choiseMastermind) {
        try {
            Properties prop = new Properties();
            prop.load(new FileReader("src/main/resources/config.properties"));
            this.nbCases = Integer.parseInt(prop.getProperty("nombre.cases"));
            this.nbTry = Integer.parseInt(prop.getProperty("nombre.essai"));
            this.nbAvailableColours = Integer.parseInt(prop.getProperty("mastermind.nombre.couleurs"));
            //System.out.println("properties = " + nbCases + nbTry + nbAvailableColours);
            //FileReader in = new FileReader("src/main/resources/config.properties");

            String[] coloursAvailable = {"Rouge", "Jaune", "Bleu", "Indigo", "Marron", "Vert", "Gris", "Noir", "Orange", "Pourpre"};
            String[] stockColoursAvailable = new String[nbAvailableColours];


            /*for (CSVRecord record : records) {
                int nParseCases = Integer.valueOf(record.get("nombreCases"));
                if (nParseCases > 0)
                    nbCases = nParseCases;
                int nParsebTry = Integer.valueOf(record.get("essai"));
                if (nParsebTry > 0)
                    nbTry = nParsebTry;
                int nColours = Integer.valueOf(record.get("couleurs"));
                stockColoursAvailable[nColours] = couloursAvailable[nColours];
            }*/
            System.out.println(String.format("La taille des combinaisons est de  " + nbCases + " et vous avez le droit à " + nbTry + " essais%n"));
            if (choiseMastermind == true) {
                System.out.println("Les couleurs disponibles sont : ");
                for (int index = 1; index <= stockColoursAvailable.length; index++) {
                    stockColoursAvailable[index-1] = coloursAvailable[index-1] ;
                    if (index < stockColoursAvailable.length)
                        System.out.print(stockColoursAvailable[index - 1] + ", ");
                    else
                        System.out.println(stockColoursAvailable[index - 1] + ".");
                }
                System.out.println();
                System.out.println("Pour le jeu, il faudra utiliser le format suivant pour proposer une combinaison : ");
                for (int index = 1; index <= stockColoursAvailable.length; index++) {
                    formatColoursGame[index - 1] = coloursAvailable[index - 1].charAt(0);
                    if (index < formatColoursGame.length)
                        System.out.print(formatColoursGame[index - 1] + ", ");
                    else
                        System.out.println(formatColoursGame[index - 1] + ".");
                }
                System.out.println();
                System.out.println("Exemple d'une proposition valide : RJBJ équivaut à Rouge, Jaune, Bleu, Jaune \n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}








