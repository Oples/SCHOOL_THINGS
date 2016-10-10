/*
 * Classe per creare la classifica
 */
package random_game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Coded by Basso Nicola
 * Classe 3 ^ AI
 * @author Lynx
 */

public class Classifica {
    
    static String CompFile ="Classifica.txt";
    
    public static void file_gen() throws FileNotFoundException, IOException{
       //Inizializzazione variabili per il file
        String path = "/.";
        CompFile += path;
        PrintWriter pw;
        pw = new PrintWriter(CompFile);
        pw.print("_-_-_-_-_-_-_-_-_-_-CLASSIFICA DEL GIOCO_-_-_-_-_-_-_-_-_-_-");
        pw.close();
    }
    
    public static void file_write(String name, int difficulty, int tentativi) throws IOException{
        File file = new File(CompFile);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String text = br.readLine();
        FileWriter fw = new FileWriter(CompFile, true);
        PrintWriter pw;
        pw = new PrintWriter(fw, true);
        pw.println("\nNome: " +name+ " - Difficoltà: " +difficulty+ " - Numero Tentativi: " +tentativi);
        pw.close();
    }
}
