package com.company.test;

import com.company.GameSelector;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.Collections.shuffle;

public class TestDualMode {

    Scanner sc = new Scanner(System.in);
    List<Character> colours = new ArrayList<Character>();
    List<Character> Colourss = Arrays.asList('R', 'J', 'B', 'I', 'M', 'V', 'G', 'N', 'O', 'P');
    List<Character> myResponse = new ArrayList<Character>();
    String myResp;

    public static void main(String[] args) {
        TestDualMode test = new TestDualMode();
        test.colours = test.randomColours();
        System.out.print("valeur de randomColours : " );
        for(char s : test.colours){
            System.out.print(s);
        }
        System.out.println();
        test.myResponse = test.myResponseList();
        System.out.print("valeur de myRep : " );
        for(char s : test.myResponse){
            System.out.print(s);
        }
        System.out.println();
        test.compareListAndRemove(test.myResponse, test.colours);
        //test.randomListAfterGenerated();
    }

    public void dualModeMasterMind() {
        List<Character> colours = new ArrayList<Character>();
        int random;
        String randomColours;

    }

    public List randomColours() {
        for (int indexColour = 0; indexColour < 4; indexColour++) { //génère une série de 4 couleurs aléatoire pour la réponse de l'ordi
            int bMin = 0;
            int bMax = 6;
            int numRandom = (int) (Math.random() * (bMax - bMin)) + bMin;
            colours.add(Colourss.get(numRandom));
            System.out.println(indexColour);
        }
        return colours;
    }

    public void randomListAfterGenerated(){
        shuffle(colours);
        for(char s : colours){
            System.out.print(s);
        }
    }

    public List myResponseList(){
        System.out.println("Entrez votre réponse : ");
        myResp = sc.nextLine();
        myResponse = Arrays.asList(myResp.charAt(0), myResp.charAt(1), myResp.charAt(2), myResp.charAt(3));
        return myResponse;
    }

    public void compareListAndRemove(List<Character> myResponseZ, List<Character> coloursZ) {
        int present = 0;
        int findGoodAnswer = 0;
        int[] stockIndice = new int[]{0 , 1, 2, 3};
        int remove = 0;
        List<Character> transfert1 = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7');
        List<Character> transfert2 = Arrays.asList('8', '9', 'A', 'B', 'C', 'D', 'E', 'F');
        List<Character> nums3MyResp = new ArrayList();

        for(int index = 0; index < 4; index++){
            nums3MyResp.add(myResponse.get(index));
        }

        System.out.print("test + " + nums3MyResp);

        for(int index = 0; index < 4; index++){
            System.out.println(nums3MyResp);
            nums3MyResp.remove(stockIndice[index-remove]);
            remove++;
        }

        System.out.print("test + " + nums3MyResp);


        System.out.println();
        for (int i = 0; i < 4; i++) {
            if (coloursZ.contains(myResponseZ.get(i))) {

                if (myResponseZ.get(i) == coloursZ.get(i)) {
                    myResponseZ.set(i, transfert1.get(i));
                    coloursZ.set(i, transfert2.get(i));
                    findGoodAnswer++;
                    present++;
                }
            } else
                System.out.println("La couleur " + myResponseZ.get(i) + " ne se trouve pas dans la combinaison");

        }
        for (int i = 0; i < 4; i++) {
            for (int o = 0; o < 4; o++) {
                boolean find = false;
                if (myResponseZ.get(i) == coloursZ.get(o) && i != o) {
                    myResponseZ.set(i, transfert1.get(i));
                    coloursZ.set(o, transfert2.get(o));
                    present++;

                    find = true;
                } else
                    find = false;
                if (find == true)
                    break;

            }
        }
            System.out.println("Bien placé : " + findGoodAnswer);
            System.out.println("Présent(s) : " + (present-findGoodAnswer));
    }



    public void removeList(){

    }
}
