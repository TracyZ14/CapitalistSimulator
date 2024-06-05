import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.util.ArrayList;
public class BusinessesPage extends JPanel
{
    private Player player;

    public BusinessesPage(Player player)
    {
        this.player = player;
        this.setLayout(new BorderLayout(0, 50));
        this.setBorder(BorderFactory.createEmptyBorder(75, 200, 75, 200));
        JLabel businessesLabel = new JLabel("BUSINESSES", SwingConstants.CENTER);
        businessesLabel.setFont(new Font("Courier New", Font.BOLD, 75));
        this.add(businessesLabel, BorderLayout.NORTH);
        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        ArrayList<Business> businesses = player.getBusinesses();
        JPanel businessInfo = new JPanel();
        businessInfo.setLayout(new GridLayout((businesses.size() + 1), 5, 10, 20));
        Font businessInfoFont = new Font("Courier New", Font.BOLD, 20);
        JLabel businessNameColumn = new JLabel("BUSINESS NAME", SwingConstants.LEFT);
        businessNameColumn.setFont(businessInfoFont);
        businessInfo.add(businessNameColumn);
        JLabel dailyExpensesColumn = new JLabel("DAILY EXPENSES", SwingConstants.LEFT);
        dailyExpensesColumn.setFont(businessInfoFont);
        businessInfo.add(dailyExpensesColumn);
        JLabel dailyRevenueColumn = new JLabel("DAILY REVENUE", SwingConstants.LEFT);
        dailyRevenueColumn.setFont(businessInfoFont);
        businessInfo.add(dailyRevenueColumn);
        JLabel dailyNetIncome = new JLabel("DAILY NET INCOME", SwingConstants.LEFT);
        dailyNetIncome.setFont(businessInfoFont);
        businessInfo.add(dailyNetIncome);
        JLabel detailedInfo = new JLabel("DETAILED INFO", SwingConstants.LEFT);
        detailedInfo.setFont(businessInfoFont);
        businessInfo.add(detailedInfo);
        businessInfo.setFont(new Font("Courier New", Font.PLAIN, 20));
        for(Business business : businesses)
        {
            businessInfo.add(new JLabel(business.getName(), SwingConstants.LEFT));
            businessInfo.add(new JLabel(("$" + business.calculateDailyExpenses()), SwingConstants.LEFT));
            businessInfo.add(new JLabel(("$" + business.calculateDailyRevenue()), SwingConstants.LEFT));
            businessInfo.add(new JLabel(("$" + business.calculateDailyNetIncome()), SwingConstants.LEFT));
            JButton findDetailedInfo = new JButton();
            if(business instanceof Bakery)
            {
                findDetailedInfo.setText("BAKERY");
            }
            businessInfo.add(findDetailedInfo);
        }
        JScrollPane businessesInfo = new JScrollPane(businessInfo);
        center.add(businessesInfo);
        this.add(center, BorderLayout.CENTER);
    }
}