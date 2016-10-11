/*
 * Indovina il numero 1
 * Versione di base del famoso gioco.
 */
package random_game;

import java.util.Random;

/**
 * Coded by Basso Nicola
 * Classe 3 ^ AI
 * @author Lynx
 */

public class RANDOM_game {

    public static void main(String[] args) throws InterruptedException{
        /******************************************************************
        *          Inizio programma con input della difficoltà e altro
        ******************************************************************/
        Inserimento Ins = new Inserimento();
        try {
            //creazione file di classifica
            Classifica.file_gen();
        } catch (Exception e) {
            System.out.println("\n-----ERRORE NELLA GENERAZIONE DELLA CLASSIFICA!-----");
        }
        System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
        System.out.println("_-_-_-_-_-_-_-_GIOCO INDOVINA IL NUMERO_-_-_-_-_-_-_-_");
        System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-\n");
        
       //richiesta difficoltà
        System.out.println("Che difficoltà scegli?");
        System.out.println("1 --> FACILE");
        System.out.println("2 --> MEDIO");
        System.out.println("3 --> DIFFICILE");
        System.out.println("4 --> ARMAGEDDON"); //with a special gift :)
        int chose;
        do{
            chose = Ins.input();
            if((chose < 0) && (chose > 5))
                System.out.println("Hai inserito una difficoltà non valida");
        }while((chose < 0) && (chose > 5));
        
       //passaggio della variabile chose alla scelta della difficoltà danto il limite al random
        int numero = rand(difficulty(chose));
        
       //numero E' LA VARIABILE CON IL NUMERO RANDOM DA INDOVINARE
       /******************************************************************
        *                        inizio gioco                           
        ******************************************************************/
        int guest, cont = 0;
       //ciclo do-while che è il gioco in sè
        do{
            System.out.println("Inserisci un numero:");
            guest = Ins.input();
            cont++;
           //controlli sul numero e stampe
            if(guest > numero)
                System.out.println("Il numero che stai cercando è - PIU' PICCOLO -");
            else if(guest < numero)
                System.out.println("Il numero che stai cercando è + PIU' GRANDE +");
            else{
                System.out.println("\n_-_-_-_-_-_-_-_-_-_-YOU WIN!!!_-_-_-_-_-_-_-_-_-_-\n\n");
                if(chose == 4)
                    ARMAGEDDON(numero);
            }
        }while(guest != numero);
       //aggiunta player classifica
        System.out.println("Inserisci il tuo nome: (max 8 lettere)");
        String name = Ins.input_name();
        int difficulty = chose;
        int tentativi = cont;
        try {
            Classifica.file_write(name, difficulty, tentativi);
        } catch (Exception e) {
            //stampa dell'errore
            System.out.println("Errore : " + e);
        }
    }//end main
    
    //funzione per generare un numero random INTERO con un limite
    static int rand(int limit){
        Random rand = new Random();
        int r = rand.nextInt(limit)+1;
        return r;
    }
    
    //funzione per scelta del limite
    static int difficulty(int n){
        int max = 0;
        switch (n){
                case 1: max = 10;
                    break;
                case 2: max = 100;
                    break;
                case 3: max = 1000;
                    break;
                case 4: max = 1000000000; System.out.println("Preparing apocalipse...");
                    break;
        }
        return max;
    }
    
    //funzione...argameddooooon
    static void ARMAGEDDON(int numero){
        if(numero > 10000)
            System.out.println("---BOOOOOOOM BIG NUMBER EXPLOSION!---\n\n"+
"@@@MM@@@@EB@@80@@OE@@U0@Zu@PY@juMiESv@r5Pr@r18r8YLM:J@75@7U@GYB@MUZ@@@ON@@@GZB@@\n" +
"@M@@0kM@@E1PMMkvXGuv007UNrLP:Y2:k7iUi2irriUiLriki7u@SiiFiiquiUZkvJ8MkL1OMN55O@@X\n" +
"GS@@@@@GM@@@q8@BXZ@81ZMLY8755:FiZ@:Fi7i;LiviFrJY;JB@LiZj7B2rOB2uOBOPXM@Mkq@@@BZF\n" +
"@@@MB@@@8PO@@NSO@NUOOYv02uY,M@Y7,@N:YZ@@@Mkiri7i;:@B:i::E7;MG7LMM51EM8kX@@@NqO@@\n" +
"@@@@@MGM@@GSE@OXPOOUUP@@@@@M@@@@iq@u@BBOL@@@::i:::@.:@@@:iZui5MFvu8Ekq8@OkSG@@@S\n" +
"@NM@@@@BqN@@EXZMEuFOu:@@@@@BB@@@BM@@5kSX.FZBMMBME@0,i@@B:LiiqqrL0SLuGO0PkM@@GPN0\n" +
"@@@@G8O@@8XPGM01FO1Lu7O@XvLNBMN0OMB@X77L 7MEM@@@@@@@BMi;M1YJiiUurLqPJJ0OMGXk0@@M\n" +
"8X@@@@OPqOOMNkXGSJuu7MBL7FMi:iO8MX:.   , .rG@B@@@@@@@BPMMB@Mi;;r1FJLP8q12PMBMO02\n" +
"@@@8PZ@@@OXq0Ekv7YJr@BvYM@7   J@i,.,:iir  ,,r0ri:iiiMFiirU5@F:iiirkFjL18Z8NXXO@M\n" +
"OP@@@@0N0EZGNrv@@8r8M72MB@@i,r@ri;777rr7  7:ii:ii;77, iir5B@@@BJiiiYFk2jj08BBOGu\n" +
"@EOZq0OMOGGFX@@@M@@@@PONJvP@ML7r7r:,,,:i  i::..  ..  77v7::iBEZ@@L;vvJ1P0FXSqZMG\n" +
"@E@@@MO0PZGU@@@@@:;@@@@@ui   :LL:.        ::.,::    ,;7O;   1@ZLM@LiuuuJukZEO88U\n" +
"@EBZG0OZMGEku@@@@EMBGMOi. .i:    ..        ,..    :,  :YJri7@M@@vB@iiu552u2XSNON\n" +
"@Z@@MMMGZq15jL2NZM8ZBS:  ,v777:                  ,,:, ,7YjPNSi:UEu@jirYJ1F0GO882\n" +
"ONOGq0EEGNPu2B@MNXFFqi  ,vrrrri:.               ...:::.::    ,:uZ2@5:LYjuuJFE0OE\n" +
"M0@@MOZZGE5YM@OqXN2uv,  77r:..:::,                       .:rrr@@@@@@@1Yu1SXqXNNu\n" +
"M0M80ZEZ00Pu@@GqP5jrv: :Uj:    ,.                     :rvLYLvrU@@@@@:ivYu15SEEM0\n" +
"MqMMMOG800PJE@GqP5iii:  .                          .::iiirrri::B@@@@.iLYu1U2E00u\n" +
"M0@MMZGZ0X5UYOBZUL::,,. .....                       ..,ii;7riiiYLYZ@@iruu1F0EEM0\n" +
"MqMM00Gq001v7iLM@@@@@@Br7L7777i,:.                     ,:i;7ririu1q@@iruLjUu50Eu\n" +
"@G@@@MO8NqS@@@@@@@@@@EZrii;;rLi                        ..,::7r7u1EO@5ivU11UNZOO0\n" +
"OPGN0EEZNqO@@@@@@G@M0Pq@i,:;:     .               ..  :,.:i :iXEG@@ZivYU525FX0Eu\n" +
"@O@@MOOGqGqvvLEPi,O@OGZM0@@   :i.  .        :7.  .   :,.:i: i:G@Ou7irLYjju1PN8OE\n" +
"OXOOG8OZ8NNXFuJLYir@@Bq.P@@Liriii,     ...  ..:r  :ii:::ii q@@@@r:;rLLu22Eq08GGJ\n" +
"@B@@BG80PN0EFuUUuLiiMMjjEZ8@r:iiiii7  i:iL:    iL, Lvv77i  .Z@@@i;7rL211U25kN8M8\n" +
"OkOOZO@MOZN0PS512u7iLZJ:@@@@,:iiiirr iJLJLj  :ivvui :, ,.:1Z@GEO:;rLuuju1qO88GZu\n" +
"@B@@@BG00M80Eq1U1uJUO2i::@@k:::::iv  : .:i7.,jri:..,.   .@@@@@@O:vLJjjFEq0qPPGB8\n" +
"@0M8EB@MO0Pq0Zq1U1UF@XU7:,.@@@PjLFv ,.   ,,      .:LM:.,u@MMG@@@@ivukS525EOMBOZ1\n" +
"@G@@@BqP8MBGqqEZkuUu5BMMO5@@B@@@B@,..:, .r@v:7@8rMB@@@@@@MOq@k,:LJF5uLSMONXk0O@M\n" +
"@@@GG@@@M0NZMM01PGuLUuvk,@@kJk8M@1,@:u::5@@@@@@@@@BMMMMMM8q@@@ii22vYE8PkSqB@O00S\n" +
"G0@@@@8PZ@@O0EMG05q0jj1:@@;@@M0NZi8@@@@@@@@MBO@@@OMMMB@@M@@@@@GJv2ZkU1EMMZkqM@@8\n" +
"@@@@ZM@@@OPqMMEXGOXu80r@@.@@@7GBBB@O@@@Y,:L@@O@@@@@@@MqN:M@@@0:uOkY5O8NXEM@@GqZM\n" +
"@k@@@@@GEB@@0XZ@ZF8MPF8FJFu@Y:J:ji7,@E88iiiMF:rivvrY:J:iU:iY,7OkvZMOqNMBONNO@@@P\n" +
"@@@@@MM@@@ONM@BPZ@OkOMF2OjUFiOLvSi5:@2@@;r7iir;JiFiuY;GvuBvu@5jOMPXO@8XE@@@GZB@@\n" +
"@PZP8@@@EPG@Ok5Z8SJEEL28vuqiuUiX;Lrr@;0:777vr5i1rrui5rrXi7XY7Z5LUGZLUG8q1S8@BGNF");
        else
            System.out.println("OOPS, LOW NUMBER WITH ARMAGEDDON DIFFICULTY, you're lucky ;)");
    }
}
