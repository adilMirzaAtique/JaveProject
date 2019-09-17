
package gui;

import commands.AddDoctorCommand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The panel to obtain data for the creation of a doctor, and to cause the doctor to be created.
 */
public class DoctorAddPanel extends JPanel{

    /**
     * A text field to be used to display an error if one should occur.
     */
    JTextArea error = null;

    /**
     * A panel for the entry of the name of a new doctor.
     */
    ValueEntryPanel namePanel;

    /**
     * Create the panel to obtain data for the creation of a doctor, and to
     * cause the doctor to be created.
     */
    public DoctorAddPanel() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(Box.createVerticalGlue());

        JLabel prompt = new JLabel("Enter Doctor Information");
        prompt.setMaximumSize(prompt.getPreferredSize());
        add(prompt);
        prompt.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createVerticalGlue());

        // add a panel with the field for the entry of the doctor's name
        namePanel = new ValueEntryPanel("name");
        namePanel.setMaximumSize(namePanel.getPreferredSize());
        add(namePanel);
        namePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createVerticalGlue());

        // add a button to submit the information and create the doctor
        JButton submitButton = new JButton("Submit");
        submitButton.setMaximumSize(submitButton.getPreferredSize());
        add(submitButton);
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        submitButton.addActionListener(new SubmitListener());
        add(Box.createVerticalGlue());
    }

    /**
     * The class listening for the press of the submit button. It accesses the name
     * entered and used it to add a new doctor to the system.
     */
    private class SubmitListener implements ActionListener {

        /**
         * When the submit button is pressed, access the name entered and use it to
         * add a new doctor to the system.
         * @param event Event which happens when the button is clicked
         */
        public void actionPerformed(ActionEvent event)
        {
            if (error != null)
            {
                // remove error from the previous submission
                remove(error);
                error = null;
            }
            String name = namePanel.getValueAsString();
            AddDoctorCommand addDoctor =  new AddDoctorCommand();
            boolean loop = true;
            while (loop)
            {
                String isSurgeon = JOptionPane.showInputDialog("Is the new doctor a surgeon(y/n)");
                if (isSurgeon.equals("y"))
                {
                    addDoctor.addDoctor(name, true);
                    loop = false;
                }
                else if (isSurgeon.equals("n"))
                {
                    addDoctor.addDoctor(name, false);
                    loop = false;
                }
            }

            if (addDoctor.wasSuccessful())
            {
                getTopLevelAncestor().setVisible(false);
            }
            else
            {
                error = new JTextArea(SplitString.at(addDoctor.getErrorMessage(), 40));
                error.setMaximumSize(error.getPreferredSize());
                add(error);
                error.setAlignmentX(Component.CENTER_ALIGNMENT);
                add(Box.createVerticalGlue());
                revalidate(); // redraw the window as it has changed
            }
        }
    }

    public static final long serialVersionID = 1;
}
