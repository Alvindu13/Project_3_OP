package com.company;

import java.util.Scanner;

public class Game {
    int nB;
    /**
     * Affiche texte choix de la longueur du chiffre à trouver
     */
    public void numberRun() {
        System.out.println("Veuillez proposer un nombre entre 1 et 5 pour déterminer le nombre de chiffre de la combinaison à trouver : ");
        Scanner sc = new Scanner(System.in);
        nB = sc.nextInt();
        this.availableCommand(nB);
        int n = aleatoireNumberAndSelectedNumber(nB);
        displayPropose(n);
        retry();
        // Trouver une façon de ne pas prendre compte des caractères autres que les nombres entier
    }

    /**
     * Permet de connaître le nb de chiffre de la combinaison
     * @param nB nombre de chiffre de la combinaison
     */
    public void availableCommand(int nB){
        switch (nB) {
            case 1:
                System.out.println("Vous avez choisi un nombre à " + nB + " chiffres");
                break;
            case 2:
                System.out.println("Vous avez choisi un nombre à " + nB + " chiffres");
                break;
            case 3:
                System.out.println("Vous avez choisi un nombre à " + nB + " chiffres");
                break;
            case 4:
                System.out.println("Vous avez choisi un nombre à " + nB + " chiffres");
                break;
            case 5:
                System.out.println("Vous avez choisi un nombre à " + nB + " chiffres");
                break;
            default:
                System.out.println("Je n'ai pas compris votre réponse. Merci de mettre un chiffre valide\n");
                numberRun();
                break;
        }
    }

    /**
     * Calcul un nombre aléatoire de nB chiffre(s) et le return
     * @param nB représente la taille de la combi à générer
     * @return le nombre aléatoire généré de nB chiffre(s)
     */

    public int aleatoireNumberAndSelectedNumber(int nB) {
        int bMin=(int)Math.pow(10,nB-1);
        int bMax=(int)Math.pow(10,nB);
        int nombre = (int)(Math.random() * (bMax - bMin)) + bMin ;
        return nombre;
        //this.displayPropose(nombre);
    }

    /**
     * Proposez les propositions pour chercher la combinaison
     * @param n combinaison à trouver
     */

    public void displayPropose(int n) {
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
            String F = String.valueOf(n);
            String G = String.valueOf(m);
            //System.out.println("Combinaison secrète : " + n);
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
        } while (m != n && essai != 0);
        if (m == n){
            System.out.println();
            System.out.println("Bravo ! La combinaison secrète était bien " + n);
        } else {
            System.out.println();
            System.out.println("Malheureusement vous n'avez pas trouvé la bonne combinaison qui était :  "  + n);
        }
    }

    /**
     * Retry game
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



