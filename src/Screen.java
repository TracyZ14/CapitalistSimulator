import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
public class Screen extends JPanel implements ChangeListener
{
    private Player player;
    private JTabbedPane gameScreen;

    public Screen(Player player)
    {
        this.player = player;
        this.setLayout(new BorderLayout());
        this.gameScreen = new JTabbedPane();
        gameScreen.addTab("PLAYER INFO",new PlayerInfoPage(player));
        gameScreen.addTab("BUSINESSES", new BusinessesPage(player));
        gameScreen.addTab("BAKERY", new BusinessInfo(player, new Bakery()));
        gameScreen.addTab("BOOKSTORE", new BusinessInfo(player, new Bookstore()));
        gameScreen.addChangeListener(this);
        this.add(gameScreen, BorderLayout.CENTER);
    }

    public void stateChanged(ChangeEvent e)
    {
        int tabNumber = gameScreen.getSelectedIndex();
        if(tabNumber == 0)
        {
            gameScreen.setComponentAt(tabNumber, new PlayerInfoPage(player));
        }
        if(tabNumber == 1)
        {
            gameScreen.setComponentAt(tabNumber, new BusinessesPage(player));
        }
        if(tabNumber == 2)
        {
            gameScreen.setComponentAt(tabNumber, new BusinessInfo(player, new Bakery()));
        }
        if(tabNumber == 3)
        {
            gameScreen.setComponentAt(tabNumber, new BusinessInfo(player, new Bookstore()));
        }
        this.revalidate();
        this.repaint();
    }
}