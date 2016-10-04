/* 3)
 * Scrivi un programma che esegua il calcolo del FATTORIALE
 * di un numero positivo inserito (fare il controllo affinchè il numero inserito non sia negativo).
 * Il fattoriale di un numero è la moltiplicazione di tutti i suoi predecessori.
 * Esempi:
 * 3! = 3*2*1 = 6
 * 5! = 5*4*3*2*1 = 120
 */
package fattoriale;

/**
 * Coded by Basso Nicola
 * Classe 3 ^ AI
 * @author Lynx
 */
public class Fattoriale {
    
    public static void main(String[] args) {
        int n = Inserimento_n_qualsiasi.input();
        long fat = fattoriale(n);
        System.out.println("Il fattoriale di " + n + " è uguale a " + fat);
    }
    
    private static long fattoriale(int n){
        if(n == 1)
            return 1;
        else
            return n * fattoriale(n-1);
    }
}
