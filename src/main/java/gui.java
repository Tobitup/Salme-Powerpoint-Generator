import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.ExceptionListener;
import java.io.IOException;

public class gui {
    private static int WINDOWWIDTH = 1080;
    private static int WINDOWHEIGHT = 720;
    private JPanel main;
    private JPanel Preview;
    private JTextField salmeNrField;
    private JLabel salmeNrLabel;
    private JLabel salmeValgLabel;
    private JLabel salmeNrLabelForDisplay;
    private JButton compileButton;
    private int salmeNr;

    public gui() {
        salmeNrField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Exception handler for NumberFormatError
                try {
                    salmeNr = Integer.parseInt(salmeNrField.getText());     //Gets input text, parses input and displays salme number and title
                    salmeNrLabelForDisplay.setText("69");
                    System.out.println(salmeNrField.getText());
                    int psalmnumba = Integer.parseInt(salmeNrField.getText());
                    salmeNrField.setText("");
                    salmeValgLabel.setText(psalm.downloadPsalms(psalmnumba, "title"));
                }
                catch(NumberFormatException | IOException ex) {
                    System.out.println("Invalid Input, Please enter a number");
                    salmeNrField.setText("");
                }
                }

                //TODO: Add Database connection
            }
        );
    }

    public static void initializeGUI() {
        JFrame Window = new JFrame();
        Window.setSize(WINDOWWIDTH, WINDOWHEIGHT);
        Window.setContentPane(new gui().main);
        Window.setVisible(true);



    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
