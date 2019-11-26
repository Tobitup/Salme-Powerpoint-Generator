import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.ExceptionListener;

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
                    salmeValgLabel.setText("Shit Broken Yo");
                    System.out.println(salmeNrField.getText());
                    salmeNrField.setText("");
                    }
                catch(NumberFormatException ex) {
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
