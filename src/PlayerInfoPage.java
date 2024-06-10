import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class PlayerInfoPage extends JPanel implements ActionListener
{
    private Player player;
    private JPanel center;

    public PlayerInfoPage(Player player)
    {
        this.player = player;

        this.setLayout(new BorderLayout(0, 50));
        this.setBorder(BorderFactory.createEmptyBorder(75, 200, 75, 200));

        JLabel playerInfo = new JLabel("PLAYER INFO", SwingConstants.CENTER);
        playerInfo.setFont(new Font("Courier New", Font.BOLD, 75));
        this.add(playerInfo, BorderLayout.NORTH);

        this.center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));

        Font centerFont = new Font("Courier New", Font.PLAIN, 20);

        try
        {
            BufferedImage playerImage = ImageIO.read(new File("images/Player.png"));
            center.add(new JLabel(new ImageIcon(playerImage)));
        }
        catch(IOException ex)
        {
            JLabel missingPlayerImage = new JLabel("(No player image found.)", SwingConstants.LEFT);
            missingPlayerImage.setFont(centerFont);
            center.add(missingPlayerImage);
        }

        center.add(Box.createVerticalStrut(25));

        JLabel playerUsername = new JLabel("USERNAME   : " + player.getUsername(), SwingConstants.LEFT);
        playerUsername.setFont(centerFont);
        center.add(playerUsername);

        center.add(Box.createVerticalStrut(25));

        JLabel playerMoney = new JLabel("WEALTH     : $" + player.getMoney(), SwingConstants.LEFT);
        if(player.getMoney() < 0)
        {
            playerMoney = new JLabel("WEALTH     : -$" + Math.abs(player.getMoney()), SwingConstants.LEFT);
        }
        playerMoney.setFont(centerFont);
        center.add(playerMoney);

        center.add(Box.createVerticalStrut(25));

        JLabel daysPassed = new JLabel("DAYS PASSED : " + player.getDaysPassed(), SwingConstants.LEFT);
        daysPassed.setFont(centerFont);
        center.add(daysPassed);

        center.add(Box.createVerticalStrut(25));

        JLabel businessesLabel = new JLabel("BUSINESSES :", SwingConstants.LEFT);
        businessesLabel.setFont(centerFont);
        center.add(businessesLabel);

        int numberOfBakeries = 0;
        int numberOfBookstores = 0;
        ArrayList<Business> businesses = player.getBusinesses();
        for(Business b : businesses)
        {
            if(b instanceof Bakery)
            {
                numberOfBakeries++;
            }
            if(b instanceof Bookstore)
            {
                numberOfBookstores++;
            }
        }

        Font businessInfoFont = new Font("Courier New", Font.PLAIN, 15);

        JLabel bakeriesInfo = new JLabel("Number of bakeries : " + numberOfBakeries, SwingConstants.LEFT);
        bakeriesInfo.setFont(businessInfoFont);
        center.add(bakeriesInfo);

        JLabel bookstoresInfo = new JLabel("Number of bookstores : " + numberOfBookstores, SwingConstants.LEFT);
        bookstoresInfo.setFont(businessInfoFont);
        center.add(bookstoresInfo);

        center.add(Box.createVerticalStrut(25));

        JButton nextDay = new JButton("NEXT DAY");
        nextDay.setFont(centerFont);
        nextDay.addActionListener(this);
        center.add(nextDay);

        center.add(Box.createVerticalStrut(25));

        JButton logOut = new JButton("LOG OUT");
        logOut.setFont(centerFont);
        logOut.addActionListener(this);
        center.add(logOut);

        this.add(new JScrollPane(center, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        if(command.equals("NEXT DAY"))
        {
            player.increaseDaysPassed();
            center.remove(6);
            JLabel daysPassed = new JLabel("DAYS PASSED : " + player.getDaysPassed());
            daysPassed.setFont(new Font("Courier New", Font.PLAIN, 25));
            center.add(daysPassed, 6);
        }
        if(command.equals("LOG OUT"))
        {
            System.exit(0);
        }
        this.revalidate();
        this.repaint();
    }
}