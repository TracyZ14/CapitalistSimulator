import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.util.ArrayList;
public class PlayerInfoPage extends JPanel
{
    private Player player;

    public PlayerInfoPage(Player player)
    {
        this.player = player;
        this.setLayout(new BorderLayout(0, 50));
        this.setBorder(BorderFactory.createEmptyBorder(100, 200, 100, 200));
        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        JLabel playerUsername = new JLabel(player.getUsername(), SwingConstants.LEFT);
        playerUsername.setFont(new Font("Courier New", Font.BOLD, 30));
        center.add(playerUsername);
        JLabel playerMoney = new JLabel(("$" + player.getMoney()), SwingConstants.LEFT);
        playerMoney.setFont(new Font("Courier New", Font.BOLD, 25));
        center.add(playerMoney);
        JLabel businessesLabel = new JLabel("BUSINESSES", SwingConstants.LEFT);
        businessesLabel.setFont(new Font("Courier New", Font.BOLD, 30));
        center.add(businessesLabel);
        center.setFont(new Font("Courier New", Font.PLAIN, 20));
        ArrayList<Business> businesses = player.getBusinesses();
        JPanel businessInfo = new JPanel();
        businessInfo.setLayout(new GridLayout((businesses.size() + 1), 4));
        businessInfo.setLayout(new GridLayout((businesses.size() + 1), 4, 10, 20));
        businessInfo.add(new JLabel("NAME OF BUSINESS", SwingConstants.LEFT));
        businessInfo.add(new JLabel("NUMBER OF EMPLOYEES", SwingConstants.LEFT));
        businessInfo.add(new JLabel("WAGE OF EMPLOYEES", SwingConstants.LEFT));
        businessInfo.add(new JLabel("IS HIRING", SwingConstants.LEFT));
        for(Business business : businesses)
        {
            JLabel businessName = new JLabel(business.getName(), SwingConstants.LEFT);
            businessInfo.add(businessName);
            JLabel numberOfEmployees = new JLabel(("" + business.getEmployees()), SwingConstants.LEFT);
            businessInfo.add(numberOfEmployees);
            JLabel employeeWage = new JLabel(("$" + business.getEmployeeWage()), SwingConstants.LEFT);
            businessInfo.add(employeeWage);
            JLabel hiringStatus = new JLabel(("" + business.getIsHiring()), SwingConstants.LEFT);
            businessInfo.add(hiringStatus);
        }
        JScrollPane businessesInfo = new JScrollPane(businessInfo);
        businessesInfo.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        center.add(businessesInfo);
        this.add(center, BorderLayout.CENTER);
    }
}