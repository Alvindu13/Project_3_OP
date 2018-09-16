package com.company;

import java.util.Scanner;

public class Game {

    /**
     * Affiche texte choix de la longueur du chiffre à trouver
     */
    public void numberRun() {
        System.out.println("Veuillez proposer un nombre entre 1 et 10 pour déterminer le nombre de chiffre de la combinaison à trouver : ");
        Scanner sc = new Scanner(System.in);
        int nb = sc.nextInt();
        this.displayCombinaison(nb);
        this.aleatoireNumber(nb);
        // Trouver une façon de ne pas prendre compte des caractères autres que les nombres entier
    }

    /**
     *
     * @param nb
     * @return
     */
    /*public boolean availableCommand(int nb){
        bollean
        if (nb >= 1 && nb <=10) {
            System.out.println("Vous avez choisi un nombre à " + nC + " chiffres");
        } else {
            System.out.println("Je n'ai pas compris votre réponse. Merci de mettre un chiffre valide\n");
            numberRun();
        }

    }*/

    /**
     * Choix du chiffre pour la longueur de la combi
     * @param nC
     */

    public void displayCombinaison(int nC) {
        if (nC >= 1 && nC <=10) {
            System.out.println("Vous avez choisi un nombre à " + nC + " chiffres");
        } else {
            System.out.println("Je n'ai pas compris votre réponse. Merci de mettre un chiffre valide\n");
            numberRun();
        }
    }

    /**
     * Génère un nombre aléatoire de nB chiffre(s)
     * @param nB
     */

    public void aleatoireNumber(int nB) {
        int bMin=(int)Math.pow(10,nB-1);
        int bMax=(int)Math.pow(10,nB);
        int nombre = (int)(Math.random() * (bMax - bMin)) + bMin ;
        //System.out.println("Le nombre est : " + nombre);
        this.displayPropose(nombre);

        }

    public void displayPropose(int nB) {
        int m;
        int i;
        String str = "";
        System.out.print("Merci faire votre proposition : ");
        do{
            Scanner sc = new Scanner (System.in);
            System.out.println();
            m = sc.nextInt();
            String F = str+nB;
            String G = str+m;
            //Integer.toString(m);
            //System.out.println("Combinaison secrète : " + nB);
            System.out.print("Votre proposition : " + m + " -> réponse : " );
            for(i = 0; i < F.length(); i++){
                if (G.charAt(i) == F.charAt(i)){
                    System.out.print("=");
                } else if (G.charAt(i) < F.charAt(i)){
                    System.out.print("+");
                } else if (G.charAt(i) > F.charAt(i)){
                    System.out.print("-");
                }

            }

            //if
        } while (m != nB);
        System.out.println();
        System.out.println("Bravo ! La combinaison secrète était bien " + nB);
    }

}


