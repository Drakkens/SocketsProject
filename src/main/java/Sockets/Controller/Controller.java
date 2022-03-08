package Sockets.Controller;

import Sockets.Main;
import Sockets.Model.ClientConnector;
import Sockets.Model.Connection;
import Sockets.Model.ServerConnector;
import Sockets.View.ConnectionUI;

import javax.swing.*;
import java.util.HashMap;

public class Controller {
    private final HashMap<JPanel, Connection> connectionHashMap = new HashMap<>();
    private final Main main;

    public Controller(Main main) {

        this.main = main;
    }

    public void sendMessage(String message, ConnectionUI connectionUI) {
        Connection connection = connectionHashMap.get(connectionUI);
        connection.sendMessage(message);

    }


    public void startServer(int port) {
        new ServerConnector(port, this);

    }

    public void connectToServer(String ip, int port) {
        new ClientConnector(ip, port, this);

    }

    public HashMap<JPanel, Connection> getConnectionHashMap() {
        return connectionHashMap;
    }

    public Main getMain() {
        return this.main;
    }
}
