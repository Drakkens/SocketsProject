package Sockets.View;

import Sockets.Utils.ConstraintsUtils;
import Sockets.Utils.UICreationUtils;

import javax.swing.*;
import java.awt.*;

public class ServerUI extends JPanel {

    public ServerUI(UIPanel uiPanel) {
        super(new GridBagLayout());
        this.setSize(new Dimension((int) (getToolkit().getScreenSize().getWidth() / 2), (int) getToolkit().getScreenSize().getHeight()));
        this.setBackground(Color.GRAY);

        ConstraintsUtils constraints = new ConstraintsUtils();
        UICreationUtils creationUtils = new UICreationUtils(this, constraints);


        constraints.resetConstraints().changeInsets(10, 10, 10, 10);
        creationUtils.createLabel("Port");

        constraints.changePosition(1, 0);
        JTextField portTextField = creationUtils.createTextField("");
        portTextField.setColumns(5);

        constraints.changePosition(2, 0);
        creationUtils.createButton("Start Server", e -> {
            uiPanel.getMain().getController().startServer(Integer.parseInt(portTextField.getText()));
            portTextField.setEditable(false);
        });


        this.setVisible(true);
    }

}
