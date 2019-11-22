import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gui {
    private static int WINDOWWIDTH = 1080;
    private static int WINDOWHEIGHT = 720;
    private JPanel main;
    private JPanel Preview;
    private JTextField salmeNrField;
    private JLabel salmeNrLabel;

    public gui() {
        salmeNrField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer.parseInt(salmeNrField.getText());
                System.out.println(salmeNrField.getText());

                //TODO: Add Database connection
            }
        });
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
