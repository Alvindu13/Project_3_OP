package com.company.test;

import java.util.Scanner;

public class TestDualMode {

    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        TestDualMode test = new TestDualMode();
        test.run();
    }

    public void run(){

        int nombre = 0;
        boolean checkAnswer = false;
        String randomNumberAtFind;
        String myAnswer;
        String ordiAnswer;
        randomNumberAtFind = String.valueOf(randomNumberAndSelectedNumber(4));
        System.out.println(randomNumberAtFind);

        do {
            if (nombre % 2 == 0) {
                System.out.print("C'est à votre tour : ");
                myAnswer = sc.nextLine();
                System.out.print("Votre réponse : " + myAnswer + " -> réponse : ");
                checkAndDisplayPlacement(myAnswer, randomNumberAtFind);
                if (myAnswer.contains(randomNumberAtFind))
                    checkAnswer = true;
            } else {
                System.out.println("C'est au tour de l'ordinateur ! ");
                ordiAnswer = String.valueOf(randomNumberAndSelectedNumber(4));
                System.out.print("L'ordinateur propose : " + ordiAnswer + " -> réponse : ");
                checkAndDisplayPlacement(ordiAnswer, randomNumberAtFind);
                if (ordiAnswer.contains(randomNumberAtFind))
                    checkAnswer = true;
            }
            nombre++;
            System.out.println("\n");
        }while(!checkAnswer);
    }

    public int randomNumberAndSelectedNumber(int nbCases) { //revoir cette méthode
        int bMin = (int) Math.pow(10, 4 - 1);
        int bMax = (int) Math.pow(10, 4);
        int randomNumber = (int) (Math.random() * (bMax - bMin)) + bMin;
        return randomNumber;
    }

    public void checkAndDisplayPlacement(String answer, String combinaison) {
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
