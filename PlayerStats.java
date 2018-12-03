
public class PlayerStats
{
    String name;
    int wins;
    int lose;

    public PlayerStats(String pName, int pWins, int pLose)
    {
        name = pName;
        wins = pWins;
        lose = pLose;
    }
    
    public String GibName()
    {
        return name;
    }

    public int GibWins()
    {
        return wins;
    }

    public int GibLose()
    {
        return lose;
    }
}
