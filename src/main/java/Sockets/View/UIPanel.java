package Sockets.View;

import Sockets.Main;

import javax.swing.*;
import java.awt.*;

public class UIPanel extends JPanel {
    private final Main main;
    private final JTabbedPane tabbedPane;


    public UIPanel(Main main) {
        super(new GridBagLayout());

        this.main = main;

        this.setBackground(Color.LIGHT_GRAY);

        this.tabbedPane = new JTabbedPane(SwingConstants.TOP);
        tabbedPane.setPreferredSize(new Dimension((int) (getToolkit().getScreenSize().getWidth() / 2), (int) getToolkit().getScreenSize().getHeight()));
        tabbedPane.setSize(getPreferredSize());



        tabbedPane.addTab("Server", new ServerUI(this));

        tabbedPane.addTab("Client", new ClientUI(this));

        this.add(tabbedPane);




        this.setVisible(true);

    }

     /*---------------------------------------/
              Getters & Setters
    /---------------------------------------*/

    public Main getMain() {
        return main;
    }

    public ConnectionUI createNewConnectionTab(String side, String port) {
        String title = side + ":" + port;
        ConnectionUI connectionUI = new ConnectionUI(this);
        this.tabbedPane.addTab(title, connectionUI);
        return connectionUI;
    }
}
