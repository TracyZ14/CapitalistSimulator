import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
public class PlayerInfoPage extends JPanel
{
    private Player player;

    public PlayerInfoPage(String name, int money)
    {
        this.player = new Player(name, money);
    }
}