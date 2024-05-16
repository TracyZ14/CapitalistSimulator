import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.util.ArrayList;
public class BusinessInfo extends JPanel
{
    private Player player;
    private Business business;

    public BusinessInfo(Player player, Business business)
    {
        this.player = player;
        this.business = business;
        this.setLayout(new BorderLayout(0, 50));
        JLabel businessType = new JLabel(business.getBusinessType(), SwingConstants.CENTER);
        businessType.setFont(new Font("Courier New", Font.BOLD, 75));
        this.add(businessType, BorderLayout.NORTH);
        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        JButton addBusiness = new JButton("BUY NEW " + business.getBusinessType());
        center.add(addBusiness);
        ArrayList<Business> businesses = player.getBusinesses();
        ArrayList<Business> sameBusinessType = new ArrayList<Business>();
        for(Business b : businesses)
        {
            if(b.getBusinessType().equals(business.getBusinessType()))
            {
                sameBusinessType.add(b);
            }
        }
        JPanel sameBusinessInfo = new JPanel();
        sameBusinessInfo.setLayout(new GridLayout((sameBusinessType.size() + 1), 9));
        sameBusinessInfo.add(new JLabel("NAME", SwingConstants.LEFT));
        sameBusinessInfo.add(new JLabel("DAILY EXPENSES", SwingConstants.LEFT));
        sameBusinessInfo.add(new JLabel("DAILY REVENUE", SwingConstants.LEFT));
        sameBusinessInfo.add(new JLabel("DAILY NET INCOME", SwingConstants.LEFT));
        sameBusinessInfo.add(new JLabel("NUMBER OF EMPLOYEES", SwingConstants.LEFT));
        sameBusinessInfo.add(new JLabel("IS HIRING", SwingConstants.LEFT));
        sameBusinessInfo.add(new JLabel("OWN BUILDING", SwingConstants.LEFT));
        sameBusinessInfo.add(new JLabel("DAILY RENT", SwingConstants.LEFT));
        sameBusinessInfo.add(new JLabel());
        for(Business b : sameBusinessType)
        {
            JButton deleteBusiness = new JButton("DELETE");
            sameBusinessInfo.add(deleteBusiness);
        }
        JScrollPane sameBusinessesInfo = new JScrollPane(sameBusinessInfo);
        center.add(sameBusinessesInfo);
        this.add(center, BorderLayout.CENTER);
    }
}