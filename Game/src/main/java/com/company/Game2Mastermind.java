package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Game2Mastermind {
    int essai = 5;

    /**
     * Create a random array char with colours
     *
     * @param nbCases size of array
     */
    public void challengeModeMastermind(int nbCases, char[] format) {
        int s = 0;
        int indice = 0;
        int counter = 0;
        char[] randomColours = new char[nbCases];
        char[] stockRandomColours = new char[nbCases];
        char[] responseToChar = new char[nbCases];
        char[] stockResponseToChar = new char[nbCases];
        for (int indexColour = 0; indexColour < nbCases; indexColour++) {
            int bMin = 0;
            int bMax = 10;
            int numRandom = (int) (Math.random() * (bMax - bMin)) + bMin;
            randomColours[indexColour] = format[numRandom];
            System.out.print(randomColours[indexColour]);
        }
        for (int index = 0; index < nbCases; index++)
            stockRandomColours[index] = randomColours[index];
        for (int in = 0; in < 5; in++) {
            char[] testA = {'0', '1', '2', '3'};
            char[] testB = {'5', '6', '7', '8'};
            System.out.println();
            System.out.println("Il vous reste encore " + essai + " tentatives");
            Scanner nk = new Scanner(System.in);
            String responseString = nk.nextLine();
            for (int indexRep = 0; indexRep < nbCases; indexRep++) {
                responseToChar[indexRep] = responseString.charAt(indexRep);
                randomColours[indexRep] = stockRandomColours[indexRep];
                stockResponseToChar[indexRep] = responseToChar[indexRep];
            }
            while (responseString.length() != nbCases) {
                System.out.println("Merci de faire une proposition valide : ");
                challengeModeMastermind(nbCases, format);
            }

            for (int i = 0; i < nbCases; i++) { //Je pense qu'un des for est useless, à voir
                //for (int o = 0; o < nbCases; o++) {
                if (randomColours[i] == responseToChar[i] && i == i) {
                    counter++;
                    s++;
                    responseToChar[i] = testA[i];
                    randomColours[i] = testB[i];
                }
                //}
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
            essai--;
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


    public void defenseModeMastermind(int nbCases, char[] format) {

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
        System.out.print("La combinaison secrète est : ");
        System.out.println(yourResponse);
        System.out.println();
        responseRandomPC = randomColours(nbCases, format);
        for (int index = 0; index < nbCases; index++)
            yourColours[index] = yourResponse.charAt(index);
        System.out.println(Arrays.toString(yourColours));


        for (int in = 0; in < 5; in++) {
            System.out.println();
            System.out.println("Il vous reste encore " + essai + " tentatives");
            char[] Sup1 = {'0', '1', '2', '3'};
            char[] Sup2 = {'5', '6', '7', '8'};
            for (int index = 0; index < nbCases; index++) { // stock la combinaison secrète
                stockRandomColours[index] = yourColours[index];
                stockResponseRandom[index] = responseRandomPC[index];
            }
            System.out.println("La combinaison secrète est : " + Arrays.toString(yourColours));
            for (int i = 0; i < 4; i++) {
                //for (int j = 0; j < nbCases; j++) {
                if (responseRandomPC[i] == yourColours[i]) {
                    stockGoodResponse[i] = yourColours[i]; // stock les doublons
                    responseRandomPC[i] = Sup1[i];
                    yourColours[i] = Sup2[i];
                    if (i == 0){
                        j0 = true;
                    }
                    if (i == 1){
                        j1 = true;
                    }
                    if (i == 2){
                        j2 = true;
                    }
                    if (i == 3){
                        j3 = true;
                    }
                    /**switch (i) {
                        case 0:
                            j0 = true;
                            i0 = 0;
                            break;
                        case 1:
                            j1 = true;
                            i1 = 1;
                            break;
                        case 2:
                            j2 = true;
                            i2 = 2;
                            break;
                        case 3:
                            j3 = true;
                            i3 = 3;
                            break;
                    */

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
            //for (int index = 1; index <= nbCases; index++)
            //    System.out.println(stockGoodResponse[index - 1]);

            for (int q = 0; q < nbCases; q++) {
                for (int r = 0; r < nbCases; r++) {
                    if (yourColours[r] == responseRandomPC[q]) {
                        responseRandomPC[q] = Sup1[q];
                        yourColours[r] = Sup2[r];
                        PMP++;
                    }
                }
            }
            //System.out.print("i et j : " + i0 + ", " + i1 + ", " + i2 + ", " + i3 + ", " + j0 + ", " + j1 + ", " + j2 + ", " + j3);
            //if (PNP > 0) {
                if (essai == 5) {
                    responseRandomPC = stockResponseRandom;
                    System.out.println();
                    System.out.print("réponse du PC " + counter + " : ");
                    System.out.println(Arrays.toString(responseRandomPC));
                    responseRandomPC = randomColours(nbCases, format);
                    if (i0 == 0)
                        responseRandomPC[i0] = stockGoodResponse[i0];
                    if (i1 == 1)
                        responseRandomPC[i1] = stockGoodResponse[i1];
                    if (i2 == 2)
                        responseRandomPC[i2] = stockGoodResponse[i2];
                    if (i3 == 3)
                        responseRandomPC[i3] = stockGoodResponse[i3];
                }


                if (essai >= 1 && essai < 5) {
                    responseRandomPC = stockResponseRandom;
                    System.out.println();
                    System.out.print("réponse du PC " + counter + " : ");
                    System.out.println(Arrays.toString(responseRandomPC));
                    responseRandomPC = randomColours(nbCases, format);
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
            essai--;
            counter++;
            PMP = 0;

        }



            //nextresponse = stockGoodResponse[index - ceux qui sont bons}
            System.out.println("présent " + present);
            System.out.println("Bien placé" + goodPlace);
            int find = 0;
            for (int index = 1; index <= nbCases; index++) {
                if (stockGoodResponse[index - 1] != '0')
                    find++;
            }

        System.out.println("Vous avez trouvé " + find + " élément(s) de la combinaison");


            for (int index = 1; index <= nbCases; index++)
                System.out.println(stockGoodResponse[index - 1]);
            //System.out.println(Arrays.toString(stockGoodResponse));



    }

    public char[] randomColours(int nbCases, char[] format) {

        char[] responseRandomPC = new char[nbCases];
        Game test = new Game();
        for (int indexColour = 0; indexColour < nbCases; indexColour++) { //génère une série de 4 couleurs aléatoire pour la réponse de l'ordi
            int bMin = 0;
            int bMax = test.getNbAvailableColours();
            int numRandom = (int) (Math.random() * (bMax - bMin)) + bMin;
            responseRandomPC[indexColour] = format[numRandom];
        }
        return responseRandomPC;

    }
}
