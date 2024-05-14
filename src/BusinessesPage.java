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
        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        JLabel businessesLabel = new JLabel("BUSINESSES", SwingConstants.LEFT);
        businessesLabel.setFont(new Font("Courier New", Font.BOLD, 30));
        center.add(businessesLabel);
        ArrayList<Business> businesses = player.getBusinesses();
        JPanel businessInfo = new JPanel();
        businessInfo.setFont(new Font("Courier New", Font.BOLD, 25));
        businessInfo.setLayout(new GridLayout((businesses.size() + 1), 5, 10, 20));
        businessInfo.add(new JLabel("BUSINESS NAME", SwingConstants.LEFT));
        businessInfo.add(new JLabel("DAILY EXPENSES", SwingConstants.LEFT));
        businessInfo.add(new JLabel("DAILY REVENUE", SwingConstants.LEFT));
        businessInfo.add(new JLabel("DAILY NET INCOME", SwingConstants.LEFT));
        businessInfo.add(new JLabel("DETAILED INFO", SwingConstants.LEFT));
        businessInfo.setFont(new Font("Courier New", Font.PLAIN, 20));
        for(Business business : businesses)
        {
            businessInfo.add(new JLabel(business.getName(), SwingConstants.LEFT));
            businessInfo.add(new JLabel(("$" + business.calculateDailyExpenses()), SwingConstants.LEFT));
            businessInfo.add(new JLabel(("$" + business.calculateDailyRevenue()), SwingConstants.LEFT));
            businessInfo.add(new JLabel(("$" + business.calculateDailyNetIncome()), SwingConstants.LEFT));
            JButton detailedInfo = new JButton();
            if(business instanceof Bakery)
            {
                detailedInfo.setText("BAKERY");
            }
            businessInfo.add(detailedInfo);
        }
        JScrollPane businessesInfo = new JScrollPane(businessInfo);
        center.add(businessesInfo);
        this.add(center, BorderLayout.CENTER);
    }
}