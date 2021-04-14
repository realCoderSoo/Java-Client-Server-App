
/** *********************************************************************************************
 * File name: ClientView.java
 * Author: Soojin Han, 040698591
 * Course: CST8221 - JAP, Lab Section: 302
 * Assignment: 2 part 2
 * Professor: Daniel Cormier
 * Due Date: 2020 August 7
 * Purpose: The purpose of the class is to connect with server socket and receive messages
 * and display on the window
 *********************************************************************************************** */

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * This class is responsible for running server socket interaction
 *
 * @author Soojin Han
 * @version 1.0
 * @since 1.8.0_251
 */
public class ServerSocketRunnable implements Runnable {

    /**
     * client sockets
     */
    private Socket socket = null;
    /**
     * initializing month array to display at runtime
     */
    String mths[] = {"January", "February", "March", "April", "May", "June", "July", "August",
        "September", "October", "November", "December"};

    /**
     * setting a value for socket
     *
     * @param sk
     */
    public ServerSocketRunnable(Socket sk) {
        this.socket = sk;
    }

    /**
     * thread runner method
     */
    public void run() {
        InputStream inStream = null;//input stream
        OutputStream outStream = null;//output stream
        String userInput = null;//user input message
        Scanner inputStreamMsg = null;
        PrintWriter out = null;

        try {//getting input and output stream and throw an error if fails
            inStream = this.socket.getInputStream();
            outStream = this.socket.getOutputStream();
            inputStreamMsg = new Scanner(inStream);
            out = new PrintWriter(outStream, true);
        } catch (IOException e) {
            System.out.println("unable to get input or output stream");
        }

        try {
            //assessing lines obtained from the input stream
            while (inputStreamMsg.hasNextLine()) {
                String line = inputStreamMsg.nextLine();

                if (!line.startsWith("-")) {
                    out.append("wrong input format");
                } else {
                    //line starts with "-"
                    String[] lines = line.substring(1).split("-");
                    String input = lines[0];

                    if (input.equals("end")) {//end request
                        out.println("SERVER>Connection closed.");
                        break;
                    } else if (input.equals("time")) {//time request
                        LocalDateTime time = LocalDateTime.now();
                        String day = null;

                        if (time.getHour() >= 12) {
                            day = "PM";
                        } else {
                            day = "AM";
                        }

                        out.println("SERVER>TIME:" + time.getHour() + ":" + time.getMinute() + ":" + time.getSecond() + day);
                    } else if (input.equals("date")) {//date request
                        LocalDateTime date = LocalDateTime.now();
                        out.println("SERVER>DATE: " + date.getDayOfMonth() + " " + mths[date.getMonthValue() - 1] + " "
                                + date.getYear());
                    } else if (input.equals("help")) {//help request
                        out.println("SERVER>Available Services:\nend\necho\ntime\ndate\nhelp\ncld\n");
                    } else if (input.equals("cld")) {//clear display request
                        out.println("SERVER>CLD:");
                    } else if (input.equals("echo")) {//echo request

                        if (lines.length > 1) {
                            out.println("SERVER>ECHO: " + lines[1]);
                        } else {
                            out.println("SERVER>ECHO: ");
                        }

                    } else {
                        out.println("SERVER>ERROR: Unrecognized command.");
                    }

                    Thread.sleep(100);//threa sleep for 100 milliseconds
                }

            }
        } catch (NullPointerException e) {
            System.out.println("socket is invalid");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {//releasing resources

            if (socket != null) {
                socket.close();
            }

            if (inputStreamMsg != null) {
                inputStreamMsg.close();
            }

            if (out != null) {
                out.flush();
                out.close();
            }

        } catch (IOException e) {//unable to release resource
            System.out.println("failed to close connection");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("failed to close connection");
            e.printStackTrace();
        }
    }
}
