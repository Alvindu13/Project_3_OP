package com.company;

import java.util.Scanner;

public class Game {

    /**
     * Affiche texte choix de la longueur du chiffre à trouver
     */
    public void numberRun() {
        System.out.println("Veuillez proposer un nombre entre 1 et 5 pour déterminer le nombre de chiffre de la combinaison à trouver : ");
        Scanner sc = new Scanner(System.in);
        int nb = sc.nextInt();
        this.availableCommand(nb);
        int n = aleatoireNumberAndSelectedNumber(nb);
        displayPropose(n);
        retry();
        // Trouver une façon de ne pas prendre compte des caractères autres que les nombres entier
    }

    /**
     *
     * @param nb
     * @return
     */
    public void availableCommand(int nb){
        switch (nb) {
            case 1:
                System.out.println("Vous avez choisi un nombre à " + nb + " chiffres");
                break;
            case 2:
                System.out.println("Vous avez choisi un nombre à " + nb + " chiffres");
                break;
            case 3:
                System.out.println("Vous avez choisi un nombre à " + nb + " chiffres");
                break;
            case 4:
                System.out.println("Vous avez choisi un nombre à " + nb + " chiffres");
                break;
            case 5:
                System.out.println("Vous avez choisi un nombre à " + nb + " chiffres");
                break;
            default:
                System.out.println("Je n'ai pas compris votre réponse. Merci de mettre un chiffre valide\n");
                numberRun();
                break;
        }

    }

    /**
     * Génère un nombre aléatoire de nB chiffre(s)
     * @param nB
     */

    public int aleatoireNumberAndSelectedNumber(int nB) {
        int bMin=(int)Math.pow(10,nB-1);
        int bMax=(int)Math.pow(10,nB);
        int nombre = (int)(Math.random() * (bMax - bMin)) + bMin ;
        return nombre;
        //this.displayPropose(nombre);
    }

    /**
     *
     * @param nB
     */

    public void displayPropose(int nB) {
        int m;
        int i;
        int essai = 5;
        System.out.println("Vous avez le droit à 5 tentatives");
        System.out.print("Merci faire votre proposition : ");
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println();
            System.out.println("Il vous reste encore " + essai + " tentatives");
            m = sc.nextInt();
            String F = String.valueOf(nB);
            String G = String.valueOf(m);
            //System.out.println("Combinaison secrète : " + nB);
            System.out.print("Votre proposition : " + m + " -> réponse : ");
            for (i = 0; i < F.length(); i++) {
                if (G.charAt(i) == F.charAt(i)) {
                    System.out.print("=");
                } else if (G.charAt(i) < F.charAt(i)) {
                    System.out.print("+");
                } else if (G.charAt(i) > F.charAt(i)) {
                    System.out.print("-");
                }
            }
            essai--;
        } while (m != nB && essai != 0);
        if (m == nB){
            System.out.println();
            System.out.println("Bravo ! La combinaison secrète était bien " + nB);
        } else {
            System.out.println();
            System.out.println("Malheureusement vous n'avez pas trouvé la bonne combinaison qui était :  "  + nB);
        }
    }

    /**
     * 
     */

    public void retry(){

        System.out.println("Voulez-vous rejouer ? Si oui, veuillez entrer OK");
        Scanner sc = new Scanner (System.in);
        String str = sc.nextLine();
        while (str.contains("OK")){
            numberRun();
        }
            System.out.println("Je vous remercie d'avoir joué. À bientôt ! ");
    }
}



