import java.util.Scanner;

public class main
{
    static Scanner key = new Scanner(System.in);
    
    Karten[] spielkarten = new Karten[52];
    Karten[] spieler1 = new Karten[3];
    Karten[] spieler2 = new Karten[3];
    Karten[] spieler3 = new Karten[3];
    
    Karten[] mitte = new Karten[3];
    
    int textEingabe = 0;

    public void main()
    {
        System.out.println((char)12);
        
        //Siehe unten
        initKarten();
        
        /* Die Spieler-Karten und Mitte-Karten müssen nicht initialisiert werden.
         * Die entsprechenden Arrays können Objekte vom Typ Karten aufnehmen. Es
         * müssen jedoch keine Dummy-Karten erstellt werden.
         * Wenn ihr das spielt, dann haltet ihr ja auch keine leeren Kartne in der
         * Hand, wenn der Kartenstapel noch gemischt wird.
         */

        //------------------------------------------------------------------------
        //alle Spieler + W/L
        PlayerStats[] PlayerStats = new PlayerStats[3];
        //                               PlayerName, Wins, Lose
        PlayerStats[0] = new PlayerStats("Player 1",  0  ,  0  );
        PlayerStats[1] = new PlayerStats("Player 2",  0  ,  0  );
        PlayerStats[2] = new PlayerStats("Player 3",  0  ,  0  );

        //------------------------------------------------------------------------
        //Willkommens Ansprache
        System.out.println("                 Willkommen                ");
        System.out.println("Spiel Starten[1] -  oder - Spiel Beenden[2]");
        
        while(textEingabe == 0 )  
        {
            textEingabe = key.nextInt();
            //Start
            if(textEingabe == 1)
            {
                System.out.println("Okey, Los gehts !");
                break;
            }
            //Beenden
            else if(textEingabe == 2)
            {
                System.out.println("Okey, Tschüss"); break;
            }
            //Falsche eingabe
            else
            {
                System.out.println("Diese auswahl gab es nicht !"); 
                break;
            }
        }
        //------------------------------------------------------------------------
        //Mischen + austeilen
        textEingabe = 0;
        Karten tempKarte;
        
        int zufall;
        
        while(textEingabe != 1 || textEingabe != 2) 
        {
            System.out.println("mischen[1] - oder - austeilen[2]");
            textEingabe = key.nextInt();
            //Mischen
            if(textEingabe == 1)
            {
                for(int j = 0; j < 52; j++)
                {
                    zufall = (int)(Math.random()*52);
                    tempKarte = spielkarten[j];
                    spielkarten[j] = spielkarten[zufall];
                    spielkarten[zufall] = tempKarte;
                    break;
                }
                textEingabe = 0;
            }
            /* Da es nur 9 Karten zu verteilen gibt, gebe ich diese direkt an.
             * Denkbar wäre sicherlich auch eine Schleife, aber das ist mir heute
             * Abend zu kompliziert ^^
             */
            else if(textEingabe == 2)
            {
                spieler1[0] = spielkarten[0]; 
                spielkarten[0] = null;
                spieler1[1] = spielkarten[1];
                spielkarten[1] = null;
                spieler1[2] = spielkarten[2];
                spielkarten[2] = null;
                
                spieler2[0] = spielkarten[3]; 
                spielkarten[3] = null;
                spieler2[1] = spielkarten[4];
                spielkarten[4] = null;
                spieler2[2] = spielkarten[5];
                spielkarten[5] = null;
                
                spieler3[0] = spielkarten[6]; 
                spielkarten[6] = null;
                spieler3[1] = spielkarten[7];
                spielkarten[7] = null;
                spieler3[2] = spielkarten[8];
                spielkarten[8] = null;
                
                mitte[0] = spielkarten[9]; 
                spielkarten[9] = null;
                mitte[1] = spielkarten[10];
                spielkarten[10] = null;
                mitte[2] = spielkarten[11];
                spielkarten[11] = null;
                
                break;
            }
            //Falsche eingabe
            else
            {
                System.out.println("Diese Auswahl gibt es nicht!");
            }
        }
        
        //------------------------------------------------------------------------
        //Stapelauswahl
        zufall = (int)(Math.random() * PlayerStats.length);
        textEingabe = 0;
        
        System.out.println("Der" + PlayerStats[zufall].GibName() + " darf zwischen zwei verschiedenen Stapeln auswählen");
        System.out.println("Linker Stapel[1] - oder - Rechter Stapel[2]");
        
        while(textEingabe != 1 || textEingabe != 2)
        {
            //Linker Stapel
            if(textEingabe == 1)
            {
                System.out.println("Deine Karten sind : ");
                System.out.println("Sicher[1] - oder - Risiko[2]");
                if(textEingabe == 1)
                {
                    System.out.println("Auf gehts !");
                }
                else if(textEingabe == 2)
                {

                }
            }
            //Rechter Stapel
            else if(textEingabe == 2)
            {

            }
            //Falsche eingabe
            else
            {
                System.out.println("Diese auswahl gab es nicht !"); 
            }
        }
    }
    
    private void printInfo(String pUeberschrift, String pText)
    {
        /* Ihr könntet Euch hier eine Methode erstellen, die Euer Menü
         * "schön" darstellt. Anstatt dann oben System.out.println() zu
         * schreiben, wird hier diese Methode aufgerufen und ihr die
         * Parameter übergeben.
         * Außerdem kann diese Methode dann immer die Ausgabe löschen,
         * bevor etwas neues ausgegeben wird.
         */
    }

    private void initKarten()
    {
        String[] farben = {"Herz", "Karo", "Pik", "Kreuz"};

        for(int j = 0; j < 4; j++)
        {
            for(int i = 0; i < 13; i++)
            {
                if(i == 9) spielkarten[j*13 + i] = new Karten(farben[j] + " Bube", 10);
                else if(i == 10) spielkarten[j*13 + i] = new Karten(farben[j] + " Dame", 10);
                else if(i == 11) spielkarten[j*13 + i] = new Karten(farben[j] + " König", 10);
                else if(i == 12) spielkarten[j*13 + i] = new Karten(farben[j] + " Ass", 11);
                else spielkarten[j*13 + i] = new Karten(farben[j] + " " + (i + 2), i + 2);
            }
        }
    }
}    
