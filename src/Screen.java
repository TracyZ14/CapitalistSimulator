import java.awt.CardLayout;
import javax.swing.JPanel;
public class Screen extends JPanel
{
    private InitialPage initialPage;

    public Screen()
    {
        this.setLayout(new CardLayout());
        this.initialPage = new InitialPage();
        this.add(initialPage);
    }
}