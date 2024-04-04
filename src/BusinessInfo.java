public class BusinessInfo
{
    public static int findBakeryStartUpCost()
    {
        return((int) (51500 + (Math.random() * 90000)));
    }

    public static int findBakeryCost()
    {
        return((int) (267000 + (Math.random() * 483000)));
    }

    public static int findBakeryRent()
    {
        return((int) (30 + (Math.random() * 170)));
    }
}