package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MastermindGame implements GameMode{
    private int nbCases;
    private int nbTry;
    private int nbAvailableColours;
    private Scanner sc;
    private char[] formatColoursGameS;
    private List<Character> formatColoursGame;




    public MastermindGame( int nbCases, int nbTry, int nbAvailableColours) {
        this.nbCases = nbCases;
        this.nbTry = nbTry;
        this.nbAvailableColours = nbAvailableColours;
        sc = new Scanner(System.in);
        formatColoursGameS = new char[]{'R', 'J', 'B', 'I', 'M', 'V', 'G', 'N', 'O', 'P'};
        this.formatColoursGame = Arrays.asList('R', 'J', 'B', 'I', 'M', 'V', 'G', 'N', 'O', 'P');
        displayAvailableColours();
    }

    private void displayAvailableColours(){

        List<String> coloursAvailable = Arrays.asList("Rouge", "Jaune", "Bleu", "Indigo", "Marron", "Vert", "Gris", "Noir", "Orange", "Pourpre");
        List<String> stockColoursAvailable = new ArrayList();
        System.out.println(String.format("La taille des combinaisons est de  " + nbCases + " et vous avez le droit à " + nbTry + " tentatives"));
        System.out.println("Les couleurs disponibles sont : ");
        stockColoursAvailable = coloursAvailable;
            for (int index = 1; index <= nbAvailableColours; index++) {
                if (index < nbAvailableColours)
                    System.out.print(stockColoursAvailable.get(index - 1) + ", ");
                else
                    System.out.println(stockColoursAvailable.get(index - 1) + ".");
            }
            System.out.println();
            System.out.println("Pour le jeu, il faudra utiliser le format suivant pour proposer une combinaison : ");
            for (int index = 1; index <= nbAvailableColours; index++) {
                if (index < nbAvailableColours)
                    System.out.print(formatColoursGame.get(index - 1) + ", ");
                else
                    System.out.println(formatColoursGame.get(index - 1) + ".");
            }
            System.out.println();
            System.out.println("Exemple d'une proposition valide : RJBJ équivaut à Rouge, Jaune, Bleu, Jaune \n");
    }

    /**
     * Create a random array char with colours
     *
     */




    public char[] randomColours(int nbCases, char[] format ) {

        char [] randomClours = new char[nbCases];
        for (int indexColour = 0; indexColour < nbCases; indexColour++) { //génère une série de 4 couleurs aléatoire pour la réponse de l'ordi
            int bMin = 0;
            int bMax = nbAvailableColours;
            int numRandom = (int) (Math.random() * (bMax - bMin)) + bMin;
            randomClours[indexColour] = formatColoursGameS[numRandom];
        }
        return randomClours;

    }


    public void displayCombinaison(char[] combinaison, int nbCases) {
        for (int i = 0; i < nbCases; i++)
            System.out.print(combinaison[i]);
        System.out.println(" ");
    }

    public boolean compare(String myAnswer, char[] combinaisonSecrete, int counter, int user ) {

        int[] reponse = new int[2];
        boolean [] checkDoublon = new boolean[nbCases];
        int PMP = 0; // Présent(s) Mal Placé(s)
        int findGoodPlace = 0;
        char[] answer = new char[nbCases];
        boolean find = true;

        for (int index = 0; index < nbCases; index++) {
                answer[index] = myAnswer.charAt(index);
            }
            // cette première boucle sert à trouver
            // les éléments bien devinés et correctement placés.
            // Le tableau marque permet de marquer de tels
            // éléments pour qu'ils ne soient pas considérés
            // plusieurs fois.
            for (int index = 0; index < nbCases; index++) {
                if (combinaisonSecrete[index] == answer[index]) {
                    findGoodPlace++;
                    checkDoublon[index] = true;
                } else {
                    find = false;
                    checkDoublon[index] = false;
                }
            }
            // la deuxième boucle suivante sert à identifier les
            // éléments bien devinés mais mal placés.
            for (int index = 0; index < nbCases; index++) {
                if (combinaisonSecrete[index] != answer[index]) {
                    int j = 0;
                    boolean trouveMalPlace = false;
                    while ((j < nbCases) && !trouveMalPlace) {
                        if (!checkDoublon[j] && (combinaisonSecrete[index] == answer[j])) {
                            PMP++;
                            checkDoublon[j] = true;
                            trouveMalPlace = true;
                        }
                        j++;
                    }
                }
            }

            reponse[0] = findGoodPlace;
            reponse[1] = PMP;
            switch (user){
                case 0 : //humain
                    System.out.print("Votre proposition pour le tour " + counter +   " : " + myAnswer + " => ");
                    break;
                case 1 : //machine
                    System.out.print("L'ordinateur propose pour le tour " + counter +   " : " + myAnswer + " => ");
                    break;

            }
            System.out.print(findGoodPlace + " bien placé(s), ");
            System.out.println(PMP + " présent(s). \n");
            nbTry--;


        return find;
    }

    @Override
    public void challengeMode() {
        boolean trouve = false;
        int counter = 1;
        String myAnswer = "";
        char[] combinaisonSecrete = new char[nbCases];
        combinaisonSecrete = randomColours(nbCases, formatColoursGameS);

        while(nbTry > 0 && !trouve) {
            System.out.print("Merci de proposer une combinaison de couleurs : ");
            myAnswer = sc.nextLine();
            trouve = compare(myAnswer, combinaisonSecrete, counter, 0);
            counter++;
        }

        if(trouve == true)
            System.out.println("Bravo ! Vous avez trouvé la bonne combinaison  : " + myAnswer);
        else {
            System.out.print("Dommage, vous n'avez pas trouvé la combinaison : ");
            displayCombinaison(combinaisonSecrete, nbCases);
        }
    }

    @Override
    public void defenseMode() {

        boolean trouve = false;
        int counter = 1;
        String ordiAnswers = "";
        char[] ordiAnswer = new char[nbCases];

        String combinaisonSecretes = "";
        char[] combinaisonSecrete = new char[nbCases];

        System.out.println("Merci de proposer une combinaison que l'ordinateur va devoir trouver : ");
        combinaisonSecretes = sc.nextLine();
        for (int index = 0; index < nbCases; index++) {
            combinaisonSecrete[index] = combinaisonSecretes.charAt(index);
        }
        while(nbTry > 0 && !trouve) {
            ordiAnswers = "";
            ordiAnswer = randomColours(nbCases, formatColoursGameS);
            for (int index = 0; index < nbCases; index++)
                ordiAnswers += ordiAnswer[index];
            trouve = compare(ordiAnswers, combinaisonSecrete, counter, 1);
            counter++;
        }

        if(trouve == true)
            System.out.println("Bravo ! Vous avez trouvé la bonne combinaison  : " + combinaisonSecretes);
        else {
            System.out.print("Dommage, vous n'avez pas trouvé la combinaison : " + combinaisonSecretes);
        }
    }

    @Override
    public void dualMode() {
        int nombre = 0;
        int counter1 = 1;
        int counter2 = 1;
        String myAnswer;
        String ordiAnswers;
        boolean find = false;
        char[] combinaisonSecrete = new char[nbCases];
        char[] ordiAnswer = new char[nbCases];
        combinaisonSecrete = randomColours(nbCases, formatColoursGameS);

        while(!find){
            if (nombre % 2 == 0) {
                System.out.print("C'est à votre tour : ");
                myAnswer = sc.nextLine();
                find = compare(myAnswer, combinaisonSecrete, counter1, 0);
                if (find)
                    System.out.print("\n" + "Bravo vous avez trouvé la bonne combinaison : " + myAnswer);
                counter1++;
            } else {
                System.out.println("C'est au tour de l'ordinateur ! ");
                ordiAnswers = "";
                ordiAnswer = randomColours(nbCases, formatColoursGameS);
                for (int index = 0; index < nbCases; index++)
                    ordiAnswers += ordiAnswer[index];
                find = compare(ordiAnswers, combinaisonSecrete, counter2, 1);
                if (find)
                    System.out.print("\n" + "C'est l'ordi qui a trouvé la bonne combinaison : " + ordiAnswer);
                counter2++;

            }
            nombre++;
        }
    }
}

