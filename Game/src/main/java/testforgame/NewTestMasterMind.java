package testforgame;

import java.util.*;

import static java.util.Collections.shuffle;

public class NewTestMasterMind {


    private static final Object List = Arrays.asList('R', 'J', 'B');
    Scanner sc = new Scanner(System.in);
    java.util.List<Character> colours = new ArrayList<Character>();
    List<Character> Colourss = Arrays.asList('R', 'J', 'B', 'I', 'M', 'V', 'G', 'N', 'O', 'P');
    List<Character> myResponse = new ArrayList<Character>();
    String myResp;
    static char t;

    public static void main(String[] args) {
        List<Character> nums3 = new ArrayList();
        List<Character> nums4 = new ArrayList();
        nums3.add('R');
        nums3.add('J');

        nums3.remove(0);
        NewTestMasterMind test = new NewTestMasterMind();
        System.out.println("Colours" + nums3);

        List<Character> nums = new ArrayList();
        nums.add('R');
        nums.add('T');
        nums.add('R');
        nums.add('R');

        List<Character> nums2 = new ArrayList();
        nums2.add('N');
        nums2.add('R');
        nums2.add('R');
        nums2.add('R');

        nums3 = nums;
        nums4 = nums2;
        // create an empty array list
        System.out.println("test : " + nums);
        System.out.println("test : " + nums2);

        int remove = 0;
        int goodplace = 0;
        int remove2 = 0;
        int PMP = 0;
        int i = 0;
        int o = 0;
        int[] StockIndice = new int[4];
        int stockInd1 = 0;
        int stockInd2 = 0;
        int z = 0;
        int b = 0;
        int p = 0;
        int m = 0;
            for(int j =0; j < 4; j++) {
                if(nums.isEmpty() && nums2.isEmpty())
                    break;
                System.out.println(j);
                int k;
                int h = 0;
                k = j - remove;
                if(nums2.get(k) == nums.get(k)){
                    nums.remove(k);
                    nums2.remove(k);
                    remove++;
                    goodplace++;

                }

                for (int l = 0; l < nums.size(); l++){
                    if(nums.get(l) != nums2.get(l))
                        h++;
                }
                p = h;
                if(h == nums.size())
                    break;
                System.out.println("test dans boucle remove : " + remove);

                System.out.println("test dans boucle h : " + h);
                System.out.println("test dans boucle num : " + nums.size());



                System.out.println("test dans boucle o : " + nums);
                System.out.println("test dans boucle o : " + nums2);


            }
            System.out.println("test dans boucle o : " + nums);
            System.out.println("test dans boucle o : " + nums2);
            System.out.println("p" + p);

            while( i < 2) {
                for (o = 0; o < p; o++) {
                    z = 0;
                    System.out.println("i " + i + "o : " + o);
                    //System.out.println("z " + z);
                    if(i == nums.size()){
                        break;
                    }


                    if (!nums2.contains(nums.get(i))) {
                        z++;
                    }

                    System.out.println("numsize " + nums.size());
                    if (z == nums.size()) {
                        break;
                    }




                    System.out.println("valeur de i : " + i);


                    if (nums.isEmpty() && nums2.isEmpty())
                        break;
                    if (o - remove2 < 0) {
                        b = 0;
                    } else
                        b = o - remove2;


                    System.out.println("new i :  " + i);


                    System.out.println(i);
                    System.out.println("b : " + b);
                    if (nums2.get(i) == nums.get(b)) {
                        stockInd2 = o - remove2;
                        if (i - remove2 < 0)
                            stockInd1 = 0;
                        if (o - remove2 < 0)
                            stockInd2 = 0;
                        nums2.remove(i);
                        nums.remove(stockInd2);
                        remove2++;
                        PMP++;

                    }
                    System.out.println("remove2 : " + remove2);


                    System.out.println("i : " + i);
                    System.out.println("o : " + o);
                    System.out.println("stockInd1 : " + stockInd1);
                    System.out.println("stockInd2: " + stockInd2);
                    System.out.println("test dans boucle op : " + nums);
                    System.out.println("test dans boucle o : " + nums2);


                }
                i++;

        }


            System.out.println("test : " + nums);
            System.out.println("test : " + nums2);
            System.out.println("PMP: " + PMP);
        System.out.println("Bien placé: " + goodplace);




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

