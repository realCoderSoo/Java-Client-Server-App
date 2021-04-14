
/** *********************************************************************************************
 * File name: ClientView.java
 * Author: Soojin Han, 040698591
 * Course: CST8221 - JAP, Lab Section: 302
 * Assignment: 2 part 2
 * Professor: Daniel Cormier
 * Due Date: 2020 August 7
 * Purpose: The purpose of the class is to connect with ServerSocketRunnable class
 *********************************************************************************************** */

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Main class for Server Connection
 *
 * @author Soojin Han
 * @version 1.0
 * @since 1.8.0_251
 */
public class Server {

    /**
     * main method to run server
     *
     * @param args string arguments
     */
    public static void main(String args[]) {
        int portNum = 0;//port number
        ServerSocket serverSocket = null;//server socket that waits for requests to come in over the network
        Socket socket = null;//socket

        if (args.length == 0) {
            portNum = 65535;
        } else {
            try {
                portNum = Integer.parseInt(args[0]);//getting the first argument for port number
            } catch (NumberFormatException e) {
                System.out.println("Using default port: 65535");
                portNum = 65535;
            }
        }
        
        if (portNum == 65535) {
            System.out.println("Using port: 65535");
        } else {
            System.out.println("Using port: " + portNum);
        }

        try {
            serverSocket = new ServerSocket(portNum);//Creates a server socket, bound to the specified port.
        } catch (IOException e) {
            System.out.println("Unable to initialize server socket");
        }

        while (true) {

            try {
                socket = serverSocket.accept();//Listens for a connection to be made to this socket and accepts it.
                System.out.println("Connected to Socket[addr=" + socket.getInetAddress() + ",port=" + socket.getPort() + ",localport=" + socket.getLocalPort() + "]");
                ServerSocketRunnable serverRun = new ServerSocketRunnable(socket);
                Thread th = new Thread(serverRun);//Allocates a serverRun object.
                th.run();
            } catch (IOException e) {
                System.out.println("Unable to create server socket " + portNum);
            }

            System.out.println("Server socket: Closing Client connection...");
        }
    }
}
