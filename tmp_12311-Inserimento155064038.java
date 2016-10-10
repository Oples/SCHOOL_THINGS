/*
 * Classe per input di numeri
 */
package random_game;

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
                if(n < 0)
                    System.out.println("Hai inserito un numero NEGATIVO!");
            }while(n < 0);
        } catch(Exception e){
            //stampa dell'errore e ricorsione alla funzione stessa
            System.out.println("-----Input errato!-----");
            System.out.println("Errore : " + e);
            input();
        }
        return n;   //input finale valido
    }// end input
    
   //inizio funzione input del nome
    public static String input_name(){
        int l = 0;
        String str = null;
       //blocco try/catch per evitare errori
        try{
            //ciclo do-while per far inserire solo numeri positivi
            do{
                str = input.next();
                str = str.trim();
                l = str.length();
                //controlli sul nome
                if(str == "USER"){
                    System.out.println("Verrà usato l'username di sistema");
                    str = System.getProperty("user.name");
                }
                else if(l > 8)
                    System.out.println("Hai inserito un nome troppo GRANDE!");
            }while(l > 8 || str.isEmpty());
        } catch(Exception e){
            //stampa dell'errore e ricorsione alla funzione stessa
            System.out.println("-----Input errato!-----");
            System.out.println("Errore : " + e);
            input_name();
        }
        return str;   //input finale valido
    }// end input_name
    
}// end class
