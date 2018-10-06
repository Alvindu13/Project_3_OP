package com.company;

import java.util.Scanner;

public class PlusMoinsGame implements GameMode {


    private int nbCases;
    private int nbTry;
    private Scanner sc;
    private boolean checkAnswer;

    /**
     * @param nbCases représente la taille de la combi à générer
     * @param nbTry nombre de tentative possible
     */
    public PlusMoinsGame(int nbCases, int nbTry) {
        this.nbCases = nbCases;
        this.nbTry = nbTry;
        this.checkAnswer = false;
        sc = new Scanner(System.in);
    }

    /**
     * Calcul un nombre aléatoire de nB chiffre(s) et le return
     *
     * @param nbCases représente la taille de la combi à générer
     * @return le nombre aléatoire généré de nB chiffre(s)
     */
    public int randomNumberAndSelectedNumber(int nbCases) { //revoir cette méthode
        int bMin = (int) Math.pow(10, nbCases - 1);
        int bMax = (int) Math.pow(10, nbCases);
        int randomNumber = (int) (Math.random() * (bMax - bMin)) + bMin;
        return randomNumber;
    }

    /**
     * Mode Challenge, c'est au joueur de proposer des propositions pour trouver la combinaison.
     */

    @Override
    public void challengeMode() {
        String myAnswer;
        String randomNumber;
        System.out.print("Merci faire votre proposition : ");
        randomNumber = String.valueOf(randomNumberAndSelectedNumber(nbCases));
        do {
            System.out.println();
            System.out.println("Il vous reste encore " + nbTry + " tentatives");
            myAnswer = sc.nextLine();
            System.out.print("Votre proposition : " + myAnswer + " -> réponse : ");
            compareAndDisplayPlacement(myAnswer, randomNumber);
            if (myAnswer.contains(randomNumber)) {
                checkAnswer = true;
                System.out.print("\n" + "Bravo ! Vous avez trouvé la bonne combinaison : " + myAnswer);
            }
            nbTry--;
        } while (!checkAnswer && nbTry != 0);
        if(!checkAnswer){
            System.out.println();
            System.out.println("Malheureusement vous n'avez pas trouvé la bonne combinaison qui était :  " + randomNumber);
        }
    }

    /**
     * Mode Defense, c'est à l'ordinateur de proposer des propositions pour trouver la combinaison que vous avez proposé.
     */

    @Override
    public void defenseMode() {
        String yourResponseThatOrdiFind;
        String ordiAnswer;
        int tentative = 1;
        System.out.print("Merci de choisir le nombre à 4 chiffres que l'ordinateur doit trouver : ");
        yourResponseThatOrdiFind = sc.nextLine();
        System.out.println("L'ordinateur doit retrouver la réponse suivante : " + yourResponseThatOrdiFind);
        do {
            ordiAnswer = String.valueOf(randomNumberAndSelectedNumber(nbCases));
            System.out.print("Proposition " + tentative + " : " + ordiAnswer + " vérification des placements : ");
            compareAndDisplayPlacement(ordiAnswer, yourResponseThatOrdiFind);
            System.out.println();
            if (ordiAnswer.contains(yourResponseThatOrdiFind)) {
                checkAnswer = true;
                System.out.print("\n" + "L'ordi a trouvé la bonne combinaison : " + ordiAnswer);
            }
            tentative++;
        } while (!checkAnswer && tentative < 6);
        if(!checkAnswer)
            System.out.print("\n" + "L'ordi n'a pas trouvé la bonne combinaison, qui est : " + yourResponseThatOrdiFind);
    }

    /**
     * Mode Dual, on alterne entre joueur et l'ordinateur pour trouver une combinaison secrète.
     */
    @Override
    public void dualMode() {
        int nombre = 0;
        String randomNumberAtFind;
        String myAnswer;
        String ordiAnswer;
        randomNumberAtFind = String.valueOf(randomNumberAndSelectedNumber(nbCases));
        do {
            if (nombre % 2 == 0) {
                System.out.print("C'est à votre tour : ");
                myAnswer = sc.nextLine();
                System.out.print("Votre réponse : " + myAnswer + " -> réponse : ");
                compareAndDisplayPlacement(myAnswer, randomNumberAtFind);
                if (myAnswer.contains(randomNumberAtFind)) {
                    checkAnswer = true;
                    System.out.print("\n" + "Bravo vous avez trouvé la bonne combinaison : " + myAnswer);
                }
            } else {
                System.out.println("C'est au tour de l'ordinateur ! ");
                ordiAnswer = String.valueOf(randomNumberAndSelectedNumber(nbCases));
                System.out.print("L'ordinateur propose : " + ordiAnswer + " -> réponse : ");
                compareAndDisplayPlacement(ordiAnswer, randomNumberAtFind);
                if (ordiAnswer.contains(randomNumberAtFind)) {
                    checkAnswer = true;
                    System.out.print("\n" + "C'est l'ordi qui a trouvé la bonne combinaison : " + ordiAnswer);
                }
            }
            nombre++;
            System.out.println("\n");
        } while (!checkAnswer);
    }

    /**
     * Compare la réponse à la combinaison et affiche des indications de placements +/-.
     * @param answer votre réponse ou celle de l'ordinateur selon le jeu.
     * @param combinaison la combinaison secrète
     */

    public void compareAndDisplayPlacement(String answer, String combinaison) {
        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) == combinaison.charAt(i)) {
                System.out.print("=");
            } else if (answer.charAt(i) < combinaison.charAt(i)) {
                System.out.print("+");
            } else if (answer.charAt(i) > combinaison.charAt(i)) {
                System.out.print("-");
            }
        }
    }


}

