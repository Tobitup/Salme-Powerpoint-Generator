import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.ExceptionListener;
import java.io.IOException;

public class gui {
    private static int WINDOWWIDTH = 750;
    private static int WINDOWHEIGHT = 200;
    private JPanel main;
    private JPanel Preview;
    private JTextField salmeNrField;
    private JLabel salmeNrLabel;
    private JLabel salmeValgLabel;
    private JLabel salmeNrLabelForDisplay;
    private JButton compileButton;
    private int salmeNr;
    private int psalmnumba;


    public static void initializeGUI() {
        //Initializes GUI by creating the JFrame and Panel
        JFrame Window = new JFrame();
        Window.setSize(WINDOWWIDTH, WINDOWHEIGHT);
        Window.setContentPane(new gui().main);
        Window.setVisible(true);
    }


    public gui() {
        compileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Exception handler for NumberFormatError
                try {
                    //Clears both existing labels
                    salmeNrLabelForDisplay.setText("");
                    salmeValgLabel.setText("");

                    //Gets input text, parses input ito int
                    salmeNr = Integer.parseInt(salmeNrField.getText());
                    String[] info = psalm.downloadPsalms(salmeNr);

                    //Displays salme number and title
                    salmeNrLabelForDisplay.setText(salmeNrField.getText());
                    salmeValgLabel.setText(info[0]);
                    System.out.println(salmeNrField.getText());
                    salmeNrField.setText("");

                    //Creates PowerPoint Slide from Database data
                    powerpoint slide1 = new powerpoint();
                    slide1.generateSlide(salmeNr);
                    }

                //Catches error if user inputs string instead of int
                catch(NumberFormatException | IOException ex) {
                    salmeNrLabelForDisplay.setText("Invalid Input, please enter a number");
                    System.out.println("Invalid Input, Please enter a number");
                    salmeNrField.setText("");
                }
                }
            }
        );
    }
}