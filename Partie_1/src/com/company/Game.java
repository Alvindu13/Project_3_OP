package com.company;

import java.util.Scanner;

public class Game {
    int nB;
    String[] colours = {"R - Rouge", "J - Jaune", "V - Vert", "B - Bleu", "N - Noir", "G - Gris"};
    Scanner sc = new Scanner(System.in);

    /**
     * Affiche texte choix de la longueur du chiffre à trouver
     */
    public void numberRun() {

        gameChoise();
        // Trouver une façon de ne pas prendre compte des caractères autres que les nombres entier
    }

    /**
     * Permet de connaître le nb de chiffre de la combinaison
     *
     * @param nB nombre de chiffre de la combinaison
     */
    public void availableCommand(int nB) {
        if (nB >= 1 && nB <= 5) {
            System.out.println("Vous avez choisi une combinaison à " + nB + " valeurs");
        } else {
            System.out.println("Je n'ai pas compris votre réponse. Merci de mettre un chiffre valide\n");
            numberRun();
        }
    }

    /**
     * Calcul un nombre aléatoire de nB chiffre(s) et le return
     *
     * @param nB représente la taille de la combi à générer
     * @return le nombre aléatoire généré de nB chiffre(s)
     */
    public int aleatoireNumberAndSelectedNumber(int nB) {
        int bMin = (int) Math.pow(10, nB - 1);
        int bMax = (int) Math.pow(10, nB);
        int nombre = (int) (Math.random() * (bMax - bMin)) + bMin;
        return nombre;
        //this.displayPropose(nombre);
    }

    /**
     * Proposez les propositions pour chercher la combinaison
     *
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
        if (m == n) {
            System.out.println();
            System.out.println("Bravo ! La combinaison secrète était bien " + n);
        } else {
            System.out.println();
            System.out.println("Malheureusement vous n'avez pas trouvé la bonne combinaison qui était :  " + n);
        }
    }

    /**
     * Retry game
     */

    public void retry() {

        System.out.println("Voulez-vous rejouer ? Si oui, veuillez entrer OK. Si non, appuyez sur n'importe quelle touche puis sur entrée");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        while (str.contains("OK")) {
            numberRun();
        }
        System.out.println("Je vous remercie d'avoir joué. À bientôt ! ");
    }

    /**
     * Select game and display it
     */
    public void gameChoise() {
        System.out.println("Veuillez choisir le jeu que vous voulez lancer : ");
        String[] gameCh = {"Recherche d'une combinaison de chiffre avec indicateurs +/-", "Recherche d'une combinaison de chiffre ou de couleurs avec indicateurs de placement"};
        for (int i = 0; i < 2; i++) {
            System.out.println(i + 1 + " - " + gameCh[i]);
        }
        int n = sc.nextInt();
        switch (n) {
            case 1:
                System.out.println("Veuillez proposer un nombre entre 1 et 5 pour déterminer le nombre de chiffre de la combinaison à trouver : ");
                nB = sc.nextInt();
                this.availableCommand(nB);
                int nA = aleatoireNumberAndSelectedNumber(nB);
                displayPropose(nA);
                retry();
                break;
            case 2:
                System.out.println("Veuillez proposer un nombre entre 1 et 5 pour déterminer le nombre de case de la combinaison de chiffre ou de couleur à trouver : ");
                nB = sc.nextInt();
                availableCommand(nB);
                System.out.println("Voulez-vous jouer avec des couleurs ou des chiffres ? ");
                System.out.println("1 - Combinaison de couleurs");
                System.out.println("2 - Combinaison de chiffres");
                int nChoise = sc.nextInt();
                switch (nChoise) {
                    case 1:
                        availableColours();
                        System.out.println();
                        System.out.println("Rappel : ");
                        System.out.println("Les couleurs disponibles sont : R - J - V - B - N - G");
                        randomColour();
                        break;
                    case 2:
                        break;
                    default:
                }

        }

    }


    public void gameMode() {
        System.out.println("");
    }

    public void availableColours() {
        System.out.println("Pour prendre connaissance des couleurs disponibles avant de jouer, merci d'entrer V dans le terminal : ");
        Scanner sc = new Scanner(System.in);
        String response = sc.nextLine();
        if ("V".contains(Character.toString(response.charAt(0)))) {
            System.out.println("Voici les couleurs disponibles : ");
            for (int i = 1; i <= 6; i++)
                System.out.println(colours[i - 1]);
        } else {
            System.out.println("Je ne comprends pas votre réponse, merci de rentrer une valeur valide");
            availableColours();
        }
    }

    public void randomColour() {

        int j = 0;
        int R = 0;
        int J = 0;
        int V = 0;
        int B = 0;
        int N = 0;
        int G = 0;
        int total = 0;
        int s = 0;
        int counter = 0;
        char[] colours1 = {'R', 'J', 'V', 'B', 'N', 'G'};
        char[] randomColours = new char[nB];
        char[] rrandomColours = new char[nB];
        char[] responseS = new char[nB];
        System.out.println("La combinaison secrète est : ");
        System.out.println("Merci de faire une proposition sous le format suivant : R,J,B,R");
        for (int k = 0; k < nB; k++) {
            int bMin = 0;
            int bMax = 5;
            int nomb = (int) (Math.random() * (bMax - bMin)) + bMin;
            randomColours[k] = colours1[nomb];
            System.out.print(randomColours[k]);
        }

        Scanner nk = new Scanner(System.in);
        System.out.println();
        String response = nk.nextLine();

        for (int jk = 0; jk < nB; jk++) {
            responseS[jk] = response.charAt(jk);
        }

        while (response.length() != nB) {
        System.out.println("Merci de faire une proposition valide : ");
        randomColour();
        }
        char[] testA = {'0', '1', '2', '3', '4'};
        char[] testB = {'5', '6', '7', '8', '9'};
        for (int u = 0; u < nB; u++){
            rrandomColours[u] = randomColours[u];
        }


        //System.out.println(Arrays.toString(responseS));
        //System.out.println(Arrays.toString(randomColours));
        for (int i = 0; i < nB; i++) {
            /*if (randomColours[i] == responseS[i]) {
                counter++;
                s++;
            }*/
            for (int o = 0; o < nB; o++) {

                if (randomColours[o] == responseS[i] && o == i) {
                    counter++;
                    s++;
                    responseS[i] = testA[i];
                    randomColours[o] = testB[o];
                }

            }
                /*if (randomColours[o] == responseS[i]) {

                    if (randomColours[i] == 'R' && responseS[o] == 'R') {
                        R++;
                    } else if (randomColours[i] == 'J' && responseS[o] == 'J') {
                        J++;
                    } else if (randomColours[i] == 'V' && responseS[o] == 'V') {
                        V++;
                    } else if (randomColours[i] == 'B' && responseS[o] == 'B') {
                        B++;
                    } else if (randomColours[i] == 'N' && responseS[o] == 'N') {
                        N++;
                    } else if (randomColours[i] == 'G' && responseS[o] == 'G') {
                        G++;
                    }
                    responseS[i] = testA[i];
                    randomColours[o] = testB[o];
                    s++;

                    //randomColours[i] == responseS[i]) ;
                }    // char test = randomColours[i];
                //char test1 = responseS[o];
                //if(test == test1)
                //System.out.println(test + " et " +test1);
                //

            }


            for (int i = 0; i < nB; i++) {
            /*if (randomColours[i] == responseS[i]) {
                counter++;
                s++;
            }*/

        }
            for (int q = 0; q < nB; q++) {
                for (int r = 0; r < nB; r++) {

                    if (randomColours[r] == responseS[q]) {

                        /*if (randomColours[r] == 'R' && responseS[q] == 'R') {
                            R++;
                        } else if (randomColours[r] == 'J' && responseS[q] == 'J') {
                            J++;
                        } else if (randomColours[r] == 'V' && responseS[q] == 'V') {
                            V++;
                        } else if (randomColours[r] == 'B' && responseS[q] == 'B') {
                            B++;
                        } else if (randomColours[r] == 'N' && responseS[q] == 'N') {
                            N++;
                        } else if (randomColours[r] == 'G' && responseS[q] == 'G') {
                            G++;
                        }*/
                        responseS[q] = testA[q];
                        randomColours[r] = testB[r];
                        s++;
                    }
                }
            }
            System.out.print("la réponse était  : ");
            for (int rep = 0; rep < nB; rep++){
                System.out.print(rrandomColours[rep]);
            }

            System.out.println();


                //System.out.println(Arrays.toString(responseS));
                //System.out.println(Arrays.toString(randomColours));




            /*for (int o = 0; o < response.length(); o++) {
                responseSS = String.valueOf(responseS[i]);
                randomColoursSS = String.valueOf(randomColours[o]);
                if(randomColoursSS.contains(responseSS)) {
                randomColours = ArrayUtils.remove(randomColours, o);
                responseS = ArrayUtils.remove(responseS, i);
                System.out.print(randomColours[o] + " -- ");
                System.out.print(responseS[i]);
                j++;
                } else if (o == response.length() - 1 && randomColours[o] != responseS[i]) {
                    //ArrayUtils.remove(testRandom, o);
                    responseS = ArrayUtils.remove(responseS, i);

                }


            }


        }


        System.out.println(Arrays.toString(responseS));
        System.out.println("test random" + Arrays.toString(randomColours));
        //responseS = ArrayUtils.remove(responseS, 2);
        System.out.println(Arrays.toString(responseS));

        for (int i = 0; i < response.length(); i++) {
            if (randomColours[i] == responseS[i])  {
                    //randomColours[i] == responseS[i]) {
                //responseS =  ArrayUtils.remove(responseS, i);
                //randomColours = ArrayUtils.remove(randomColours, i);
                counter++;
            } else {
                int cal = i + 1;
                System.out.println("la lettre " + cal + " n'est pas bien placée");
            }
            for (int o = 0; o < nB; o++) {
                if (randomColours[o] == responseS[i]) {
                    randomColours = ArrayUtils.remove(randomColours, o);
                    responseS = ArrayUtils.remove(responseS, i);
                    System.out.print(randomColours[o] + " -- ");
                    System.out.print(responseS[i]);
                    j++;
                } else if (o == nB - 1 && randomColours[o] != responseS[i]) {
                    //ArrayUtils.remove(testRandom, o);
                    responseS = ArrayUtils.remove(responseS, i);

                }
            }

        }*/



                    if (counter == 1) {
                        System.out.print(counter + " bien placé");
                    } else {
                        System.out.print(counter + " bien placés");
                    }
                    System.out.print(", " + s + "  présent(s)");





        /*public void colourGame() {


        }

        //public void placementGame() {

        }


    }*/




        }
    }



