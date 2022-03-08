package Sockets;

import Sockets.Controller.Controller;
import Sockets.Utils.ConstraintsUtils;
import Sockets.View.UIPanel;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    private final Controller controller;
    private final UIPanel uiPanel;


    public Main() {
        super("Connections");
        this.setLayout(new GridBagLayout());
        this.setSize(new Dimension((int) (getToolkit().getScreenSize().getWidth() / 2), (int) getToolkit().getScreenSize().getHeight()));
        this.setUndecorated(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.GRAY);

        ConstraintsUtils constraints = new ConstraintsUtils();
        constraints.resetConstraints().changeWeight(1, 1);

        controller = new Controller(this);
        uiPanel = new UIPanel(this);
        this.add(uiPanel, constraints);

        this.setVisible(true);


    }

    public static void main(String[] args) {
        new Main();

    }

    /*---------------------------------------/
              Getters & Setters
    /---------------------------------------*/


    public Controller getController() {
        return controller;
    }

    public UIPanel getUiPanel() {
        return uiPanel;
    }
}
