import java.awt.CardLayout;
import javax.swing.JPanel;
public class Screen extends JPanel
{
    private CardLayout cardLayout;
    private JPanel screen;
    private InitialPage initialPage;

    public Screen()
    {
        screen = new JPanel();
        screen.setLayout(cardLayout = new CardLayout());
        initialPage = new InitialPage();
        screen.add(initialPage);
    }
}