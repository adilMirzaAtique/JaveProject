
package gui;

import startup.HospitalSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.System.exit;

/**
 * This class represents the main menu frame for the hospital system
 * and the panel for the frame is represented as the inner class
 */

public class MainMenuFrame extends JFrame {

    /**
     * Button to terminate the system
     */
    private JButton terminateButton;

    public MainMenuFrame()
    {
        add(new MainManuPanel());
        terminateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exit(0);
            }
        });
    }

    /**
     * Panel for the MainMenuFrame class
     */
    public class MainManuPanel extends JPanel {

        public MainManuPanel() {
            setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
            JButton patientOps = new JButton("Patient Operations");
            patientOps.setMaximumSize(patientOps.getPreferredSize());
            patientOps.setAlignmentX(Box.CENTER_ALIGNMENT);
            patientOps.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    PatientOpsFrame frame = new PatientOpsFrame();
                    frame.setVisible(true);
                }
            });
            add(patientOps);
            add(Box.createVerticalGlue());

            JButton doctorOps = new JButton("Doctor Operations");
            doctorOps.setMaximumSize(doctorOps.getPreferredSize());
            doctorOps.setAlignmentX(Box.CENTER_ALIGNMENT);
            doctorOps.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    DoctorOpsFrame frame = new DoctorOpsFrame();
                    frame.setVisible(true);
                }
            });
            add(doctorOps);
            add(Box.createVerticalGlue());

            JButton displayButton = new JButton("Display State");
            displayButton.setMaximumSize(displayButton.getPreferredSize());
            displayButton.setAlignmentX(Box.CENTER_ALIGNMENT);
            displayButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    DisplayFrame frame = new DisplayFrame();
                    frame.setVisible(true);
                }
            });
            add(displayButton);
            add(Box.createVerticalGlue());

            terminateButton = new JButton("Terminate");
            terminateButton.setMaximumSize(terminateButton.getPreferredSize());
            terminateButton.setAlignmentX(Box.CENTER_ALIGNMENT);
            add(terminateButton);
        }
    }

    public static void main(String[] args)
    {
        HospitalSystem hospitalSystem = new HospitalSystem();
        hospitalSystem.initialize();
        MainMenuFrame frame = new MainMenuFrame();
        frame.setSize(300,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
