import java.awt.CardLayout;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Screen extends JPanel
{
    private Game game;
    private CardLayout cardLayout;
    private JMenuBar menuBar;
    private InitialPage initialPage;
    private PlayerInfoPage playerInfoPage;
    private BusinessesPage businessesPage;
    private BusinessInfo bakeryInfoPage;

    public Screen(Game game)
    {
        this.game = game;
        this.cardLayout = new CardLayout();
        this.setLayout(cardLayout);
        this.menuBar = new JMenuBar();
        this.initialPage = new InitialPage();
        this.add(initialPage, ("Initial Page"));
        /*
        this.setLayout(new CardLayout());
        this.initialPage = new InitialPage();
        this.add(initialPage);
        Player player = new Player("Player");
        this.playerInfoPage = new PlayerInfoPage(player);
        this.add(playerInfoPage);
        this.businessesPage = new BusinessesPage(player);
        this.add(businessesPage);
        this.bakeryInfoPage = new BusinessInfo(player, new Bakery());
        this.add(bakeryInfoPage);
         */
    }

    public void showCard(String key)
    {
        cardLayout.show(this, key);
    }
}