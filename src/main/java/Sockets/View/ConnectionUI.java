package Sockets.View;

import Sockets.Utils.ConstraintsUtils;
import Sockets.Utils.UICreationUtils;

import javax.swing.*;
import java.awt.*;

public class ConnectionUI extends JPanel {
    private final JTextArea textArea;

    public ConnectionUI(UIPanel uiPanel) {
        super(new GridBagLayout());

        ConstraintsUtils constraints = new ConstraintsUtils();
        UICreationUtils creationUtils = new UICreationUtils(this, constraints);

        textArea = new JTextArea();
        textArea.setPreferredSize(new Dimension(300, 300));
        textArea.setEditable(false);

        constraints.resetConstraints().changePosition(0, 0).changeDimensions(2, 1);
        creationUtils.createScrollPane(textArea);

        constraints.changePosition(0, 1).changeDimensions(1, 1);
        JTextField textField = creationUtils.createTextField("");

        constraints.changePosition(1, 1);
        creationUtils.createButton("Send", e -> {
            uiPanel.getMain().getController().sendMessage(textField.getText(), this);
            this.textArea.append("\n" + textField.getText());
        });


    }

    public JTextArea getTextArea() {
        return textArea;
    }



}
