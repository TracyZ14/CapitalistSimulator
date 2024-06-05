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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class PlayerInfoPage extends JPanel implements ActionListener
{
    private Player player;

    public PlayerInfoPage(Player player)
    {
        this.player = player;
        this.setLayout(new BorderLayout(0, 50));
        this.setBorder(BorderFactory.createEmptyBorder(75, 200, 75, 200));
        JLabel playerInfo = new JLabel("PLAYER INFO", SwingConstants.CENTER);
        playerInfo.setFont(new Font("Courier New", Font.BOLD, 75));
        this.add(playerInfo, BorderLayout.NORTH);
        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        Font centerFont = new Font("Courier New", Font.PLAIN, 25);
        JLabel playerUsername = new JLabel("USERNAME   : " + player.getUsername(), SwingConstants.LEFT);
        playerUsername.setFont(centerFont);
        center.add(playerUsername);
        JLabel playerMoney = new JLabel("WEALTH     : $" + player.getMoney(), SwingConstants.LEFT);
        playerMoney.setFont(centerFont);
        center.add(playerMoney);
        JLabel businessesLabel = new JLabel("BUSINESSES :", SwingConstants.LEFT);
        businessesLabel.setFont(centerFont);
        center.add(businessesLabel);
        ArrayList<Business> businesses = player.getBusinesses();
        JPanel businessInfo = new JPanel();
        businessInfo.setFont(new Font("Courier New", Font.PLAIN, 20));
        JButton logOut = new JButton("LOG OUT");
        logOut.addActionListener(this);
        center.add(logOut);
        this.add(center, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        if(command.equals("LOG OUT"))
        {
            System.exit(0);
        }
    }
}