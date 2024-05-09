import java.util.ArrayList;
public class Player
{
    private String username;
    private int money;
    private int daysPassed;
    private ArrayList<Business> businesses;

    public Player(String username)
    {
        this.username = username;
        this.money = (int) (Math.random() * 500000);
        this.daysPassed = 0;
        this.businesses = new ArrayList<Business>();
    }

    public Player(String username, int money)
    {
        this.username = username;
        this.money = money;
        this.daysPassed = 0;
        this.businesses = new ArrayList<Business>();
    }

    public String getUsername()
    {
        return username;
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
        for(Business business : businesses)
        {
            setMoney(money + business.calculateNetProfit());
        }
    }

    public ArrayList<Business> getBusinesses()
    {
        return businesses;
    }

    public void setBusinesses(ArrayList<Business> newBusinesses)
    {
        businesses = newBusinesses;
    }

    public void addBusiness(Business newBusiness)
    {
        businesses.add(newBusiness);
    }

    public void removeBusiness(Business soldBusiness)
    {
        businesses.remove(soldBusiness);
    }
}