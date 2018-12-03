
public class Karten
{
    private String karte;
    private int value;
    
    public Karten(String pKarte, int pValue)
    {
        karte = pKarte;
        value = pValue;
    }
    
    public String gibKarte()
    {
        return karte;
    }
    
    public int gibValue()
    {
        return value;
    }
}
