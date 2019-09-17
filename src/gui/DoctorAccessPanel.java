

package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * The panel for the access of a specific doctor. It has a prompt label, and a text field
 * for the doctor's name. When enter key is pressed, the name entered is used to create a
 * new window with the doctor's data and operations on the doctor.
 */
public class DoctorAccessPanel extends JPanel {

    /**
     * The text field for the entry of the doctor's name.
     */
    JTextField textField;

    /**
     * Create the panel with the prompt label and text field. When data is entered into the text field,
     * a new window is created with the doctor's data and operations on the doctor.
     */
    public DoctorAccessPanel()
    {
        JLabel promptLabel = new JLabel("Access Doctor");
        add(promptLabel);
        textField = new JTextField(10);
        add(textField);
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    String name = textField.getText();
                    if (name != null  && name.length() > 0)
                    {
                        DoctorFrame frame = new DoctorFrame(name);
                        frame.setLocation(300,300);
                        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                        frame.setVisible(true);
                        textField.setText("");
                        textField.revalidate();
                    }
                    else
                    {
                        textField.setText("Empty field: " + textField.getText());
                        textField.revalidate();
                    }
                }
                catch(RuntimeException exception){
                        textField.setText("Invalid name: " + textField.getText());
                        textField.revalidate();
                }
            }
        });
    }

    public static final long serialVersionUID = 1;
}
