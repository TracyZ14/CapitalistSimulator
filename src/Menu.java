import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
public class Menu extends JMenu
{
    private JMenuBar menuBar;

    public Menu()
    {
        menuBar = new JMenuBar();
        JMenu menu = new JMenu("MENU");
        JMenuItem playerInfoPage = new JMenuItem("PLAYER INFO");
        menu.add(playerInfoPage);
        JMenuItem defaultPage = new JMenuItem("LOG OUT");
        menu.add(defaultPage);
        menuBar.add(menu);
        JMenu business = new JMenu("BUSINESS");
        JMenuItem bakery = new JMenuItem("BAKERY");
        business.add(bakery);
        menuBar.add(business);
    }

    public JMenuBar getMenuBar()
    {
        return menuBar;
    }
}