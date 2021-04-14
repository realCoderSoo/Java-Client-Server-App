
/** *********************************************************************************************
 * File name: CLient.java
 * Author: Soojin Han, 040698591
 * Course: CST8221 - JAP, Lab Section: 302
 * Assignment: 2 part 2
 * Professor: Daniel Cormier
 * Due Date: 2020 August 7
 * Purpose: The purpose of the class is to run ClientView GUI
 *********************************************************************************************** */
import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Dimension;

/**
 * Main class for ClientGUI application
 *
 * @author Soojin Han
 * @version 1.0
 * @since 1.8.0_251
 */
public class Client {

    /**
     * this main method creates a ClientView window
     *
     * @param args arguments to be passed on to the application
     */
    public static void main(String[] args) {
System.out.println(System.getProperty("java.class.path"));
        // instantiating ClientView class
        ClientView clientView = new ClientView();

        EventQueue.invokeLater(new Runnable() {

            public void run() {

                JFrame frame = new JFrame();
                frame.setTitle("Soojin's Client");
                frame.setResizable(true);
                frame.setMinimumSize(new Dimension(600, 550));//setting dimention for the frame
                frame.add(clientView);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);//setting the frame visible
            }

        });
    }
}
