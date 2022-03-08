package Sockets.Model;

import Sockets.View.ConnectionUI;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Connection {
    private final DataInputStream inputStreamReader;
    private final DataOutputStream outputStreamWriter;

    private final ConnectionUI connectionUI;

    public Connection(Socket socket, ConnectionUI connectionUI) {
        this.connectionUI = connectionUI;

        try {
            inputStreamReader = new DataInputStream(socket.getInputStream());
            outputStreamWriter = new DataOutputStream(socket.getOutputStream());

        } catch (IOException e) {
            throw new RuntimeException(e);

        }

        readMessage();
    }

    public synchronized void sendMessage(String msg) {
        new Thread(() -> {
            try {
                outputStreamWriter.writeUTF(msg);

            } catch (IOException e) {
                throw new RuntimeException(e);

            }
        }).start();
    }

    public void readMessage() {
        new Thread(() -> {
            while (true) {
                try {
                    connectionUI.getTextArea().append("\n" + inputStreamReader.readUTF());

                } catch (IOException ignored) {
                }
            }
        }).start();
    }

}
