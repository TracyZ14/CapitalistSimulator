import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
public class Screen extends JPanel
{
    private Player player;

    public Screen(Player player)
    {
        this.setLayout(new BorderLayout());
        JTabbedPane gameScreen = new JTabbedPane();
        gameScreen.add("PLAYER INFO", new PlayerInfoPage(player));
        gameScreen.add("BUSINESSES", new BusinessesPage(player));
        gameScreen.add("BAKERY", new BusinessInfo(player, new Bakery()));
        this.add(gameScreen, BorderLayout.CENTER);
    }
}