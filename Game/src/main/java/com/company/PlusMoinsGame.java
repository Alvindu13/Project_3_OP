package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.Collections.shuffle;

public class PlusMoinsGame implements GameMode {

    private int nbCases;
    private int nbTry;
    private int nbAvailableColours;
    private Scanner sc;


    public PlusMoinsGame(int nbCases, int nbTry, int nbAvailableColours) {
        this.nbCases = nbCases;
        this.nbTry = nbTry;
        this.nbAvailableColours = nbAvailableColours;
        sc = new Scanner(System.in);
    }

    /**
     * Calcul un nombre aléatoire de nB chiffre(s) et le return
     * @param nbCases représente la taille de la combi à générer
     * @return le nombre aléatoire généré de nB chiffre(s)
     */
    public int randomNumberAndSelectedNumber(int nbCases) { //revoir cette méthode
        int bMin = (int) Math.pow(10, nbCases-1);
        int bMax = (int) Math.pow(10, nbCases);
        int randomNumber = (int) (Math.random() * (bMax - bMin)) + bMin;
        return randomNumber;
    }

    /**
     * Proposez les propositions pour chercher la combinaison
     */

    @Override
    public void challengeMode() {
        int essai = 5;
        int userProposal;
        int randomNumber;
        int i;
        System.out.print("Merci faire votre proposition : ");
        randomNumber = randomNumberAndSelectedNumber(nbCases);
        System.out.println("random" + randomNumber);
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println();
            System.out.println("Il vous reste encore " + essai + " tentatives");
            userProposal = sc.nextInt();
            String toStringRandomNumber = String.valueOf(randomNumber);
            String toStringProposal = String.valueOf(userProposal);
            System.out.print("Votre proposition : " + userProposal + " -> réponse : ");
            for (i = 0; i < toStringRandomNumber.length(); i++) {
                if (toStringProposal.charAt(i) == toStringRandomNumber.charAt(i)) {
                    System.out.print("=");
                } else if (toStringProposal.charAt(i) < toStringRandomNumber.charAt(i)) {
                    System.out.print("+");
                } else if (toStringProposal.charAt(i) > toStringRandomNumber.charAt(i)) {
                    System.out.print("-");
                }
            }
            essai--;
        } while (userProposal != randomNumber && essai != 0);
        if (userProposal == randomNumber) {
            System.out.println();
            System.out.println("Bravo ! La combinaison secrète était bien " + randomNumber);
        } else {
            System.out.println();
            System.out.println("Malheureusement vous n'avez pas trouvé la bonne combinaison qui était :  " + randomNumber);
        }
    }


    @Override
    public void defenseMode() {
        String yourResponse;
        String ordiResponse;
        String verificationResponse;
        char[] ToCharOrdiResponseGood = new char[4];
        int intYourResponse;
        int intOrdiResponse;
        int tentative = 1;
        System.out.print("Merci de choisir le nombre à 4 chiffres que l'ordinateur doit trouver : ");
        yourResponse = sc.nextLine();
        System.out.println("L'ordinateur doit retrouver la réponse suivante : " + yourResponse);
        ordiResponse = String.valueOf(randomNumberAndSelectedNumber(nbCases));
        do {
            System.out.print("Proposition " + tentative + " : " + ordiResponse + " vérification des placemens : ");
            for(int counter = 1; counter <= 4; counter++) {
                intYourResponse = Character.digit(yourResponse.charAt(counter - 1), 10);
                intOrdiResponse = Character.digit(ordiResponse.charAt(counter - 1), 10);
                if (intYourResponse == intOrdiResponse) {
                    verificationResponse = "=";
                    System.out.print(verificationResponse);
                } else if (intOrdiResponse < intYourResponse) {
                    verificationResponse = "+";
                    System.out.print(verificationResponse);
                } else if (intOrdiResponse > intYourResponse) {
                    verificationResponse = "-";
                    System.out.print(verificationResponse);
                }
            }
            System.out.println();
            ordiResponse = String.valueOf(randomNumberAndSelectedNumber(nbCases));
            ordiResponse.getChars(0, 4, ToCharOrdiResponseGood, 0);
            tentative++;
        }while(ordiResponse != yourResponse && tentative < 6);
    }

    @Override
    public void dualMode() {
        int nombre = 1;
        //List<Character> myRespList = new ArrayList<Character>();
        //shuffle(myRespList);

        String randomNumberAtFind;
        String myAnswer;
        String ordiAnswer;
        randomNumberAtFind = String.valueOf(randomNumberAndSelectedNumber(nbCases));

        do {
            if (nombre % 2 == 0) {

            } else {
            }
            nombre++;

        }while(randomNumberAtFind == "0");
    }
}

