package Sockets.Model;

import Sockets.Controller.Controller;
import Sockets.View.ConnectionUI;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerConnector {
    private ServerSocket serverSocket;
    private Socket socket;

    public ServerConnector(int port, Controller controller) {
        Thread thread = new Thread(() -> {
            try {
                serverSocket = new ServerSocket(port);
                while (true) {
                    socket = serverSocket.accept();

                    ConnectionUI connectionUI = controller.getMain().getUiPanel().createNewConnectionTab("Host", String.valueOf(socket.getPort()));
                    Connection connection = new Connection(socket, connectionUI);

                    controller.getConnectionHashMap().put(connectionUI, connection);

                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        thread.start();
    }

}
