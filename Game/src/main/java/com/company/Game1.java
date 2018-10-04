package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game1 {
    static Game game_3 = new Game();

    /**
     * Calcul un nombre aléatoire de nB chiffre(s) et le return
     * @param nbCases représente la taille de la combi à générer
     * @return le nombre aléatoire généré de nB chiffre(s)
     */
    public static int randomNumberAndSelectedNumber(int nbCases) { //revoir cette méthode
        int bMin = (int) Math.pow(10, nbCases-1);
        int bMax = (int) Math.pow(10, nbCases);
        int randomNumber = (int) (Math.random() * (bMax - bMin)) + bMin;
        return randomNumber;
    }

    /**
     * Proposez les propositions pour chercher la combinaison
     */
    public static void challengeModeGame1() {
        int essai = 5;
        int userProposal;
        int randomNumber;
        int i;
        System.out.print("Merci faire votre proposition : ");
        randomNumber = randomNumberAndSelectedNumber(game_3.getNbCases());
        System.out.println("random" + randomNumber);
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println();
            System.out.println("Il vous reste encore " + essai + " tentatives");
            userProposal = sc.nextInt();
            String toStringRandomNumber = String.valueOf(randomNumber);
            String toStringProposal = String.valueOf(userProposal);
            //System.out.println("Combinaison secrète : " + n);
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

    public static void defenseModeGame1() {
        String yourResponse;
        ArrayList<Character> sampleCatchEqual = new ArrayList<Character>();
        ArrayList<Character> test = new ArrayList<Character>();
        String ordiResponse;
        String verificationResponse;
        String stockOrdiResponse;
        String nextAnswer = "test";
        char[] stockGoodAnswer = new char[4];
        char[] ToCharOrdiResponseGood = new char[4];
        char[] stockToCharOrdiResponseGood = new char[4];
        int[] arrayOrdiResponse = new int[4];
        int intYourResponse;
        int intOrdiResponse;
        int tentative = 1;
        System.out.print("Merci de choisir le nombre à 4 chiffres que l'ordinateur doit trouver : ");
        yourResponse = game_3.sc.nextLine();
        System.out.println("L'ordinateur doit retrouver la réponse suivante : " + yourResponse);
        ordiResponse = String.valueOf(randomNumberAndSelectedNumber(game_3.getNbCases()));



        do {
            //System.out.print("Proposition " + tentative + " : " + ordiResponse + " vérification des placemens : ");
           // System.out.print("ToChar : ");
            //System.out.println(ToCharOrdiResponseGood);
            //System.out.println("ma response = " + yourResponse);
            System.out.print("Proposition " + tentative + " : " + ordiResponse + " vérification des placemens : ");
            //for (int index = 1; index <= ordiResponse.length(); index++) {
                for(int counter = 1; counter <= 4; counter++) {
                    intYourResponse = Character.digit(yourResponse.charAt(counter - 1), 10);
                    intOrdiResponse = Character.digit(ordiResponse.charAt(counter - 1), 10);

                    if (intYourResponse == intOrdiResponse) {
                        verificationResponse = "=";
                        //stockGoodAnswer[counter - 1] = ToCharOrdiResponseGood[counter - 1];
                        System.out.print(verificationResponse);
                    } else if (intOrdiResponse < intYourResponse) {
                        verificationResponse = "+";
                        System.out.print(verificationResponse);
                    } else if (intOrdiResponse > intYourResponse) {
                        verificationResponse = "-";
                        System.out.print(verificationResponse);
                    }
                    //ordiResponse.getChars(0, 4, stockToCharOrdiResponseGood, 0);
                }
                    System.out.println();
                    ordiResponse = String.valueOf(randomNumberAndSelectedNumber(game_3.getNbCases()));
                    ordiResponse.getChars(0, 4, ToCharOrdiResponseGood, 0);
                //if(ordiResponse.charAt(index-1) == yourResponse.charAt(index-1)){
                    //ToCharOrdiResponseGood[index-1] = yourResponse.charAt(index-1);
                //}


            /*System.out.println();
            for(int i = 1; i <= sampleCatchEqual.size(); i++){
                char catche = sampleCatchEqual.get(i-1);
                System.out.print ("tst: " + catche);
            }*/

            tentative++;
        }while(ordiResponse != yourResponse && tentative < 6);






        //do {




            /*System.out.println();
            System.out.println("Il vous reste encore " + essai + " tentatives");
            userProposal = sc.nextInt();
            String toStringRandomNumber = String.valueOf(randomNumber);
            String toStringProposal = String.valueOf(userProposal);
            //System.out.println("Combinaison secrète : " + n);
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







    }*/

    }
}

