import java.awt.CardLayout;
import javax.swing.JPanel;
public class Screen extends JPanel
{
    private InitialPage initialPage;
    private PlayerInfoPage playerInfoPage;

    public Screen()
    {
        this.setLayout(new CardLayout());
        this.initialPage = new InitialPage();
        this.add(initialPage);
        Player player = new Player("Player");
        this.playerInfoPage = new PlayerInfoPage(player);
        this.add(playerInfoPage);
    }
}