package Sockets.Model;

import Sockets.Controller.Controller;
import Sockets.View.ConnectionUI;

import java.net.Socket;

public class ClientConnector {

    public ClientConnector(String ip, int port, Controller controller) {
        this.connect(ip, port, controller);
    }

    public void connect(String ip, int port, Controller controller) {
        try {
            Socket socket = new Socket(ip, port);

            ConnectionUI connectionUI = controller.getMain().getUiPanel().createNewConnectionTab("User", String.valueOf(socket.getLocalPort()));
            Connection connection = new Connection(socket, connectionUI);

            controller.getConnectionHashMap().put(connectionUI, connection);


        } catch (Exception e) {
            System.out.println("Error");
        }
    }

}
