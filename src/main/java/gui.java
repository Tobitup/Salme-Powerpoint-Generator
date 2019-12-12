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
                    salmeNr = Integer.parseInt(salmeNrField.getText());
                    String[] info = psalm.downloadPsalms(salmeNr);
                    salmeNrLabelForDisplay.setText("");     //Clears both labels
                    salmeValgLabel.setText("");

                    //Gets input text, parses input and displays salme number and title
                    salmeNrLabelForDisplay.setText(salmeNrField.getText());
                    salmeValgLabel.setText(info[0]);
                    System.out.println(salmeNrField.getText());
                    salmeNrField.setText("");
                    powerpoint slide1 = new powerpoint();
                    slide1.generateSlide(salmeNr);
                    }
                catch(NumberFormatException | IOException ex) {
                    salmeNrLabelForDisplay.setText("Invalid Input, please enter a number");
                    System.out.println("Invalid Input, Please enter a number");
                    salmeNrField.setText("");
                }
            }
        });
    }
}
