package Sockets.View;

import Sockets.Utils.ConstraintsUtils;
import Sockets.Utils.UICreationUtils;

import javax.swing.*;
import java.awt.*;

public class ClientUI extends JPanel {

    public ClientUI(UIPanel uiPanel) {
        super(new GridBagLayout());

        ConstraintsUtils constraints = new ConstraintsUtils();
        UICreationUtils creationUtils = new UICreationUtils(this, constraints);

        constraints.resetConstraints().changeInsets(10, 10, 10, 10);
        creationUtils.createLabel("IP:");

        constraints.changePosition(1, 0);
        JTextField ipTextField = creationUtils.createTextField("");
        ipTextField.setColumns(5);

        constraints.changePosition(0, 1);
        creationUtils.createLabel("Port:");

        constraints.changePosition(1, 1);
        JTextField portTextField = creationUtils.createTextField("");
        portTextField.setColumns(15);

        constraints.changePosition(0, 2).changeDimensions(2, 1);
        creationUtils.createButton("Connect!", e -> uiPanel.getMain().getController().connectToServer(ipTextField.getText(), Integer.parseInt(portTextField.getText())));

    }



}
