package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class MastermindGame implements GameMode{
    private int nbCases;
    private int nbTry;
    private int nbAvailableColours;
    private Scanner sc;
    private char[] formatColoursGame;


    public MastermindGame( int nbCases, int nbTry, int nbAvailableColours) {
        this.nbCases = nbCases;
        this.nbTry = nbTry;
        this.nbAvailableColours = nbAvailableColours;
        sc = new Scanner(System.in);
        formatColoursGame = new char[nbAvailableColours];
        displayAvailableColours();
    }

    private void displayAvailableColours(){
        
        String[] coloursAvailable = {"Rouge", "Jaune", "Bleu", "Indigo", "Marron", "Vert", "Gris", "Noir", "Orange", "Pourpre"};
        String[] stockColoursAvailable = new String[nbAvailableColours];

        System.out.println(String.format("La taille des combinaisons est de  " + nbCases + " et vous avez le droit à " + nbTry + " nbTrys%n"));
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
                formatColoursGame[index - 1] = stockColoursAvailable[index - 1].charAt(0);
                if (index < formatColoursGame.length)
                    System.out.print(formatColoursGame[index - 1] + ", ");
                else
                    System.out.println(formatColoursGame[index - 1] + ".");
            }
            System.out.println();
            System.out.println("Exemple d'une proposition valide : RJBJ équivaut à Rouge, Jaune, Bleu, Jaune \n");
    }
    
    /**
     * Create a random array char with colours
     *
     */



    public char[] randomColours(int nbCases, char[] format) {

        char[] responseRandomPC = new char[nbCases];
        GameSelector test = new GameSelector();
        for (int indexColour = 0; indexColour < nbCases; indexColour++) { //génère une série de 4 couleurs aléatoire pour la réponse de l'ordi
            int bMin = 0;
            int bMax = test.getNbAvailableColours();
            int numRandom = (int) (Math.random() * (bMax - bMin)) + bMin;
            responseRandomPC[indexColour] = format[numRandom];
        }
        return responseRandomPC;

    }

    @Override
    public void challengeMode() {
        int s = 0;
        int indice = 0;
        int counter = 0;
        char[] randomColours = new char[nbCases];
        char[] stockRandomColours = new char[nbCases];
        char[] responseToChar = new char[nbCases];
        char[] stockResponseToChar = new char[nbCases];
        for (int indexColour = 0; indexColour < nbCases; indexColour++) {
            int bMin = 0;
            int bMax = nbAvailableColours;
            int numRandom = (int) (Math.random() * (bMax - bMin)) + bMin;
            randomColours[indexColour] = formatColoursGame[numRandom];
            System.out.print(randomColours[indexColour]);
        }
        for (int index = 0; index < nbCases; index++)
            stockRandomColours[index] = randomColours[index];
        for (int in = 0; in < 5; in++) {
            char[] testA = {'0', '1', '2', '3'};
            char[] testB = {'5', '6', '7', '8'};
            System.out.println();
            System.out.println("Il vous reste encore " + nbTry + " tentatives");
            Scanner nk = new Scanner(System.in);
            String responseString = nk.nextLine();
            for (int indexRep = 0; indexRep < nbCases; indexRep++) {
                responseToChar[indexRep] = responseString.charAt(indexRep);
                randomColours[indexRep] = stockRandomColours[indexRep];
                stockResponseToChar[indexRep] = responseToChar[indexRep];
            }
            while (responseString.length() != nbCases) {
                System.out.println("Merci de faire une proposition valide : ");
                challengeMode();
            }
            for (int i = 0; i < nbCases; i++) { //Je pense qu'un des for est useless, à voir
                if (randomColours[i] == responseToChar[i] && i == i) {
                    counter++;
                    s++;
                    responseToChar[i] = testA[i];
                    randomColours[i] = testB[i];
                }
            }
            for (int q = 0; q < nbCases; q++) {
                for (int r = 0; r < nbCases; r++) {
                    if (randomColours[r] == responseToChar[q]) {
                        responseToChar[q] = testA[q];
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
            nbTry--;
            for (indice = 0; indice < stockResponseToChar.length && stockResponseToChar[indice] == stockRandomColours[indice]; indice++)
                ;

            if (indice == nbCases) {
                System.out.println();
                System.out.print("Bravo vous avez trouver la bonne combinaison. C'était bien : ");
                for (int rep = 0; rep < nbCases; rep++) {
                    System.out.print(stockRandomColours[rep]);
                }
                break;
            }
        }
        if (indice != nbCases) {
            System.out.println();
            System.out.print("Malheureusement, vous n'avez pas trouvé la réponse. La réponse était  : ");
            for (int rep = 0; rep < nbCases; rep++)
                System.out.print(stockRandomColours[rep]);
        }
    }


    @Override
    public void defenseMode() {

        int goodPlace = 0;
        int counter = 1;
        int PMP = 0;
        int i0 = 1;
        int i1 = 0;
        int i2 = 0;
        int i3 = 0;
        boolean j0 = false;
        boolean j1 = false;
        boolean j2 = false;
        boolean j3 = false;
        Scanner sc = new Scanner(System.in);
        int present = 0;
        char[] stockGoodResponse = new char[nbCases];
        for (int index = 0; index < nbCases; index++)
            stockGoodResponse[index] = '0';
        char[] yourColours = new char[nbCases];
        char[] stockRandomColours = new char[nbCases];
        char[] stockResponseRandom = new char[nbCases];
        char[] responseRandomPC = new char[nbCases];
        System.out.println("Veuillez rentrer la combinaison que l'ordinateur doit trouver ; ");
        String yourResponse = sc.nextLine();
        String stringResponseRandomPC = new String();
        System.out.print("La combinaison secrète est : ");
        System.out.println(yourResponse);
        System.out.println();
        responseRandomPC = randomColours(nbCases, formatColoursGame );
        for (int index = 0; index < nbCases; index++) {
            yourColours[index] = yourResponse.charAt(index);
            stringResponseRandomPC += responseRandomPC[index];
        }
        System.out.println(Arrays.toString(yourColours));
        System.out.println(stringResponseRandomPC.contains(yourResponse));
        System.out.println("Il vous reste encore " + nbTry + " tentatives");
        while(nbTry >= 1 || (stringResponseRandomPC.contains(yourResponse) == false && nbTry > 0)){
            System.out.println();
            System.out.println("Il vous reste encore " + nbTry + " tentatives");

            char[] Sup1 = {'0', '1', '2', '3'};
            char[] Sup2 = {'5', '6', '7', '8'};
            for (int index = 0; index < nbCases; index++) { // stock la combinaison secrète
                stockRandomColours[index] = yourColours[index];
                stockResponseRandom[index] = responseRandomPC[index];
            }
            System.out.println("La combinaison secrète est : " + Arrays.toString(yourColours));
            for (int i = 0; i < 4; i++) {
                if (responseRandomPC[i] == yourColours[i]) {
                    stockGoodResponse[i] = yourColours[i]; // stock les doublons
                    responseRandomPC[i] = Sup1[i];
                    yourColours[i] = Sup2[i];
                    if (i == 0)
                        j0 = true;
                    if (i == 1)
                        j1 = true;
                    if (i == 2)
                        j2 = true;
                    if (i == 3)
                        j3 = true;
                }
                if(j0 == true)
                    i0 = 0;
                if(j1 == true)
                    i1 = 1;
                if(j2 == true)
                    i2 = 2;
                if(j3 == true)
                    i3 = 3;
            }
            for (int q = 0; q < nbCases; q++) {
                for (int r = 0; r < nbCases; r++) {
                    if (yourColours[r] == responseRandomPC[q]) {
                        responseRandomPC[q] = Sup1[q];
                        yourColours[r] = Sup2[r];
                        PMP++;
                    }
                }
            }
            if (nbTry == 5) {
                responseRandomPC = stockResponseRandom;
                System.out.println();
                System.out.print("réponse du PC " + counter + " : ");
                System.out.println(Arrays.toString(responseRandomPC));
                responseRandomPC = randomColours(nbCases, formatColoursGame );
                if (i0 == 0)
                    responseRandomPC[i0] = stockGoodResponse[i0];
                if (i1 == 1)
                    responseRandomPC[i1] = stockGoodResponse[i1];
                if (i2 == 2)
                    responseRandomPC[i2] = stockGoodResponse[i2];
                if (i3 == 3)
                    responseRandomPC[i3] = stockGoodResponse[i3];
            }
            if (nbTry >= 1 && nbTry < 5) {
                responseRandomPC = stockResponseRandom;
                System.out.println();
                System.out.print("réponse du PC " + counter + " : ");
                System.out.println(Arrays.toString(responseRandomPC));
                responseRandomPC = randomColours(nbCases, formatColoursGame );
                if (i0 == 0)
                    responseRandomPC[i0] = stockGoodResponse[i0];
                if (i1 == 1)
                    responseRandomPC[i1] = stockGoodResponse[i1];
                if (i2 == 2)
                    responseRandomPC[i2] = stockGoodResponse[i2];
                if (i3 == 3)
                    responseRandomPC[i3] = stockGoodResponse[i3];
            }
            for (int index = 0; index < nbCases; index++)
                yourColours[index] = stockRandomColours[index];
            System.out.println("PMP = " + PMP);
            nbTry--;
            counter++;
            PMP = 0;

            for (int index = 0; index < nbCases; index++) {
                stringResponseRandomPC += responseRandomPC[index];
            }
            if(stringResponseRandomPC.contains(yourResponse) == true)
                break;
        }
        if(stringResponseRandomPC.contains(yourResponse) == true)
            System.out.println("Bravo ! Vous avez trouvé la bonne combinaison");
        System.out.println("présent " + present);
        System.out.println("Bien placé" + goodPlace);
        int find = 0;
        for (int index = 1; index <= nbCases; index++) {
            if (stockGoodResponse[index - 1] != '0')
                find++;
        }
        System.out.println("Vous avez trouvé " + find + " élément(s) de la combinaison qui est : ");
        for (int index = 1; index <= nbCases; index++)
            System.out.print(stockGoodResponse[index - 1]);
    }


    @Override
    public void dualMode() {

    }
}
