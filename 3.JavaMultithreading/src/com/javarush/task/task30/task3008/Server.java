package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Justinas on 2017-10-16.
 */
public class Server {
    public static void main(String[] args) throws IOException {
        int port = ConsoleHelper.readInt();
        ServerSocket socket = new ServerSocket(port);
        ConsoleHelper.writeMessage("Listening on port" + socket.getLocalPort());
        try {
            while (true) {
                Socket accept = socket.accept();
                new Handler(accept).start();
            }
        } catch (Exception e) {
            ConsoleHelper.writeMessage(e.getMessage());
        } finally {
            socket.close();
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }
    }

}
