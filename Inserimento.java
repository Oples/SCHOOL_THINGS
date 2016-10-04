/*
 * Classe per input di numeri
 */
package seven_777;

import static java.lang.Integer.parseInt;
import java.util.Scanner;

/**
 * Coded by Basso Nicola
 * Classe 3 ^ AI
 * @author Lynx
 */
public class Inserimento {
    static Scanner input = new Scanner(System.in); //oggetto per lo scan
   //inizio funzione dell'input
    public static int input(){
        int n = 0;
       //blocco try/catch per evitare errori
        try{
            //ciclo do-while per far inserire solo numeri positivi
            do{
                String str= input.next();
                n = parseInt(str);
                if(str.isEmpty()){   //se non ha inserito niente
                    System.out.println("Non hai inserito nulla !!!");
                    n = 0;
                }
                if(n < 0){ //e se è negativo
                    System.out.println("Hai inserito un numero negativo!");
                    System.out.print("Re-inserisci il numero:   ");
                }
            } while(n < 0);
        } catch(Exception e){
            //stampa dell'errore e ricorsione alla funzione stessa
            System.out.println("-----Input errato!-----");
            System.out.println("Errore : " + e);
            input();
        }
        return n;   //input finale valido
    }// end Inserimento
}// end class
