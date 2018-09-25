package com.company;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    Game2Mastermind Game2Mastermind = new Game2Mastermind();
    int nbCases;
    int nbTry;
    Scanner sc = new Scanner(System.in);

    /**
     * Affiche texte choix de la longueur du chiffre à trouver
     */
    public void numberRun() {

        gameMode();
        gameChoise();
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
                    Game2Mastermind.availableColours();
                    Game2Mastermind.challengeMode(nbCases);
            }
        }
    }

    public void gameMode() {
        int choise;
        String[] arrayMode = {"1 - Mode Challenger : vous devez trouver la combinaison secrète de l'ordinateur", "2 - Mode Défenseur : où c'est à l'ordinateur de trouver votre combinaison secrète ", "3 - Mode duel : où l'ordinateur et vous jouez tour à tour, le premier à trouver la combinaison secrète de l'autre a gagné"};
        System.out.println(String.format("Veuillez choisir le mode de jeu : %n"));
        for(int index = 0; index < arrayMode.length; index++)
            System.out.println(arrayMode[index]);
        choise = sc.nextInt();
    }

    public void readParameters(boolean choiseMastermind){
        String[] stockColoursAvailable = new String[10];
        try {
            Reader in = new FileReader("src/main/ressources/config.properties.csv");
            Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);
            String[] couloursAvailable = {"R-Rouge", "J-Jaune", "B-Bleu", "I-Indigo", "M-Marron", "V-Vert", "G-Gris", "N-Noir", "O-Orange", "P-Pourpre"};
            for (CSVRecord record : records) {
                int nParseCases = Integer.valueOf(record.get("nombreCases"));
                if(nParseCases > 0)
                    nbCases = nParseCases;
                int nParsebTry = Integer.valueOf(record.get("essai"));
                if(nParsebTry > 0)
                    nbTry = nParsebTry;
                int nColours = Integer.valueOf(record.get("couleurs"));
                stockColoursAvailable[nColours] = couloursAvailable[nColours];
                }
            System.out.println(String.format("La taille des combinaisons est de  " + nbCases + " et vous avez le droit à " +nbTry+ " essais%n"));
            if(choiseMastermind == true) {
                System.out.println(String.format("Les couleurs disponibles sont : %n"));
                for (int index = 1; index < stockColoursAvailable.length; index++)
                    System.out.println(stockColoursAvailable[index - 1]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}







