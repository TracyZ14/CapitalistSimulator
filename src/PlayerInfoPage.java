import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
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
        this.add(center, BorderLayout.CENTER);
    }
}