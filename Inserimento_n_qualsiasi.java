/*
 * Input Base
 */
package fattoriale;

import java.util.Scanner;

/**
 * Coded by Basso Nicola
 * Classe 3 ^ AI
 * @author Lynx
 */
class Inserimento_n_qualsiasi {
    static Scanner input = new Scanner(System.in);
    
    public static int input(){
        int n = 0;
        System.out.println("Inserisci un valore positivo:");
        try{
            do{
                n = input.nextInt();
                if(n < 0){
                    System.out.println("Hai inserito un numero negativo!");
                    System.out.println("Re-inserisci il numero:");
                }
            } while(n < 0);
        } catch(Exception e){
            System.out.println("-----Input errato!-----");
        }
        return n;
    }
}
