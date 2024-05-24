import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
public class BusinessInfo extends JPanel implements ActionListener
{
    private Player player;
    private Business business;
    private ArrayList<Business> sameBusinessType;
    private JPanel center;
    private BusinessInfoChart sameBusinessInfo;

    public BusinessInfo(Player player, Business business)
    {
        this.player = player;
        this.business = business;
        this.setLayout(new BorderLayout(0, 50));
        JLabel businessType = new JLabel(business.getBusinessType(), SwingConstants.CENTER);
        businessType.setFont(new Font("Courier New", Font.BOLD, 75));
        this.add(businessType, BorderLayout.NORTH);
        this.center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        JButton addBusiness = new JButton("BUY NEW " + business.getBusinessType());
        addBusiness.addActionListener(this);
        center.add(addBusiness);
        JButton sellBusiness = new JButton("SELL " + business.getBusinessType());
        sellBusiness.addActionListener(this);
        center.add(sellBusiness);
        ArrayList<Business> businesses = player.getBusinesses();
        this.sameBusinessType = new ArrayList<Business>();
        for(Business b : businesses)
        {
            if(b.getBusinessType().equals(business.getBusinessType()))
            {
                sameBusinessType.add(b);
            }
        }
        this.sameBusinessInfo = new BusinessInfoChart(sameBusinessType);
        JScrollPane sameBusinessesInfo = new JScrollPane(sameBusinessInfo);
        center.add(sameBusinessesInfo);
        this.add(center, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        if(command.equals("BUY NEW " + business.getBusinessType()))
        {

        }
        if(command.equals("SELL " + business.getBusinessType()))
        {
            String[] businesses = new String[sameBusinessType.size()];
            for(int i = 0; i < sameBusinessType.size(); i++)
            {
                businesses[i] = sameBusinessType.get(i).getName();
            }
            String businessSold = (String) JOptionPane.showInputDialog(null, "Business to sell:", "SELL BUSINESSES", JOptionPane.QUESTION_MESSAGE, null, businesses, "BUSINESS");
            for(int i = 0; i < businesses.length; i++)
            {
                if(businessSold.equals(businesses[i]))
                {
                    int sellBusiness = JOptionPane.showConfirmDialog(null, ("Are you sure you want to sell " + businessSold + "?"), "SELL BUSINESS", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if(sellBusiness == JOptionPane.YES_OPTION)
                    {
                        for(int j = 0; j < 9; j++)
                        {
                            sameBusinessInfo.remove((i + 1) * 9);
                        }
                        JOptionPane.showMessageDialog(null, ("You have successfully sold " + businessSold + " for $" + sameBusinessType.get(i).calculateWorth() + "!"), "SELL BUSINESS", JOptionPane.INFORMATION_MESSAGE);
                        player.removeBusiness(sameBusinessType.remove(i));
                    }
                }
            }
        }
        sameBusinessInfo = new BusinessInfoChart(sameBusinessType);
        sameBusinessInfo.revalidate();
        sameBusinessInfo.repaint();
        this.revalidate();
        this.repaint();
    }
}