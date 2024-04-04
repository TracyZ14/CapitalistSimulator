import java.util.ArrayList;
public class Player
{
    private String userName;
    private int money;
    private int daysPassed;
    private ArrayList<Business> businesses;

    public Player(String userName, int money)
    {
        this.userName = userName;
        this.money = money;
        this.daysPassed = 0;
        this.businesses = new ArrayList<Business>();
    }

    public String getUserName()
    {
        return userName;
    }

    public int getMoney()
    {
        return money;
    }

    public void setMoney(int newMoney)
    {
        money = newMoney;
    }

    public int getDaysPassed()
    {
        return daysPassed;
    }

    public void increaseDaysPassed()
    {
        daysPassed++;
    }

    public ArrayList<Business> getBusinesses()
    {
        return businesses;
    }

    public void setBusinesses(ArrayList<Business> newBusinesses)
    {
        businesses = newBusinesses;
    }
}