
/**
 * Beschreiben Sie hier die Klasse Test.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Test
{
    Karten[] spielkarten = new Karten[52];
    public void initKarten()
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
