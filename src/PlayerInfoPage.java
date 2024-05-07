import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.util.ArrayList;
import java.lang.Class;
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
        JLabel businessesLabel = new JLabel("BUSINESSES", SwingConstants.LEFT);
        businessesLabel.setFont(new Font("Courier New", Font.BOLD, 30));
        center.add(businessesLabel);
        center.setFont(new Font("Courier New", Font.PLAIN, 20));
        ArrayList<Business> businesses = player.getBusinesses();
        for(Business business : businesses)
        {
            JPanel businessInfo = new JPanel();
            businessInfo.setLayout(new BoxLayout(businessInfo, BoxLayout.Y_AXIS));
            JLabel businessName = new JLabel("NAME OF BUSINESS: " + business.getName(), SwingConstants.LEFT);
            businessInfo.add(businessName);
            JLabel numberOfEmployees = new JLabel("NUMBER OF EMPLOYEES: " + business.getEmployees(), SwingConstants.LEFT);
            businessInfo.add(numberOfEmployees);
            JLabel employeeWage = new JLabel("WAGE OF EMPLOYEES: $" + business.getEmployeeWage());
            businessInfo.add(employeeWage);
            JLabel hiringStatus = new JLabel("IS HIRING: " + business.getIsHiring());
            businessInfo.add(hiringStatus);
            this.add(businessInfo);
        }
        this.add(center, BorderLayout.CENTER);
    }
}