import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.beans.ExceptionListener;
import java.io.File;
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
    private JLabel picLabel;
    private JLabel salmeBog;
    private JLabel executionCompleteLabel;
    private int salmeNr;
    private int psalmnumba;

    public gui() {
        salmeNrField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Exception handler for NumberFormatError
                try {
                    salmeNrLabelForDisplay.setText("");     //Clears both labels
                    salmeValgLabel.setText("");
                    salmeNr = Integer.parseInt(salmeNrField.getText());     //Gets input text, parses input and displays salme number and title
                    salmeNrLabelForDisplay.setText("69");
                    System.out.println(salmeNrField.getText());
                    int psalmnumba = Integer.parseInt(salmeNrField.getText());
                    salmeNrField.setText("");
                    }
                catch(NumberFormatException | IOException ex) {
                    salmeNrLabelForDisplay.setText("Invalid Input, please enter a number");
                    salmeValgLabel.setText(psalm.downloadPsalms(psalmnumba, "title"));
                    System.out.println("Invalid Input, Please enter a number");
                    salmeNrField.setText("");
                }
                }
<<<<<<< Updated upstream

                //TODO: Add Database connection
=======
>>>>>>> Stashed changes
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
        salmeBog = new JLabel(new ImageIcon("rsz_2rsz_salmeBog.png"));
    }
}
