/* 5)
 * Scrivi un programma che calcola quante volte la cifra 7 
 * compare nei numeri tra 1 e 100
 */
package seven_777;

/**
 * Coded by Basso Nicola
 * Classe 3 ^ AI
 * @author Lynx
 */
public class Seven_777 {
    
    public static void main(String[] args) {
       //creazione oggetto In per fare l'input corretto
        Inserimento In = new Inserimento();
        
       //inizio input
        System.out.println("Inserisci il valore massimo:");
        int limit = In.input(); 
        System.out.println("Inserisci la cifra da cercare:");
        int n = 0;
       //controllo se il valore inserito è una singola cifra
        do{
            n = In.input();
            if(n >= 10){
                System.out.println("Hai inserito un numero a 2 cifre!");
            }
        }while(n >= 10);
        String str_n = Integer.toString(n); //conversione del numero da trovare in stringa
        
       //inizio ciclo for con controllo
        int sum = 0;
        for(int i = 0; i <= limit; i++){    // da 0 al limite
            String str_i = Integer.toString(i); //conversione del numero in stringa
            if(str_i.contains(str_n))   //controllo se il numero del ciclo contiene il numero da trovare
                sum++;
        }
        
       //stampe finali
        if(sum > 1)
            System.out.println("La cifra " + n + " è comparsa " + sum + " volte da 0 a " + limit);
        else if(sum == 1)
            System.out.println("La cifra " + n + " è comparsa " + sum + " volta da 0 a " + limit);
        else
            System.out.println("La cifra non è mai apparsa");
    }// end main
}// end class
