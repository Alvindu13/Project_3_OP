package testforgame;

import com.company.test.TestDualMode;

import java.lang.reflect.Array;
import java.util.*;

import static java.util.Collections.shuffle;

public class MasterMind {

    private static final Object List = Arrays.asList('R', 'J', 'B');
    Scanner sc = new Scanner(System.in);
    List<Character> colours = new ArrayList<Character>();
    List<Character> Colourss = Arrays.asList('R', 'J', 'B', 'I', 'M', 'V', 'G', 'N', 'O', 'P');
    List<Character> myResponse = new ArrayList<Character>();
    String myResp;
    static char t;

    public static void main(String[] args) {
        List<Character> nums3 = new ArrayList();
        nums3.add('R');
        nums3.add('J');

        nums3.remove(0);
        MasterMind test = new MasterMind();
        System.out.println("Colours" + nums3);

        List<Character> nums = new ArrayList();
        nums.add('J');
        nums.add('R');
        nums.add('V');
        nums.add('V');

        List<Character> nums2 = new ArrayList();
        nums2.add('J');
        nums2.add('J');
        nums2.add('R');
        nums2.add('B');
        // create an empty array list
        System.out.println("test : " + nums);
        System.out.println(nums.get(1));
        System.out.println(nums2.get(1));

        Iterator<Character> it = nums.iterator();
         while (it.hasNext()) {
            Character integer = it.next();
            if (nums.get(0) == nums2.get(0)) {
                it.remove();
                //it2.remove();
            }
        }
        Iterator<Character> it2 = nums.iterator();
        System.out.println("test : " + nums);
        System.out.println("test : " + nums2);


        while (it2.hasNext()) {
            Character integer2 = it2.next();
            if (nums.get(0) == nums2.get(2)) {
                it2.remove();
            }
        }
        System.out.println("test : " + nums);
        System.out.println("test : " + nums2);


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

    public void randomListAfterGenerated() {
        shuffle(colours);
        for (char s : colours) {
            System.out.print(s);
        }
    }

    public List myResponseList() {
        System.out.println("Entrez votre réponse : ");
        myResp = sc.nextLine();
        myResponse = Arrays.asList(myResp.charAt(0), myResp.charAt(1), myResp.charAt(2), myResp.charAt(3));
        return myResponse;
    }

    public void compareListAndRemove(List<Character> myResponseZ, List<Character> coloursZ) {
        int present = 0;
        int findGoodAnswer = 0;
        List<Character> transfert1 = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7');
        List<Character> transfert2 = Arrays.asList('8', '9', 'A', 'B', 'C', 'D', 'E', 'F');
        int stockIndice = 0;
        int[] StockIndice = new int[4];
        List<Character> StockMyresponse = myResponse;

        for (int i = 0; i < myResponseZ.size(); i++) {
            if (coloursZ.contains(myResponseZ.get(i))) {

                if (myResponseZ.get(i) == coloursZ.get(i)) {
                    findGoodAnswer++;
                    present++;
                    StockIndice[i] = i;
                    stockIndice++;
                }
            } else
                System.out.println("La couleur " + StockMyresponse.get(i) + " ne se trouve pas dans la combinaison");
            if(i == myResponseZ.size())
                break;
        }
            myResponseZ.remove(0);


        for( Character a : myResponseZ)
            System.out.println(a);

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
        System.out.println("Présent(s) : " + (present - findGoodAnswer));
    }
}