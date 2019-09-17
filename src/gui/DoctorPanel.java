package gui;

import commands.AssignDoctorCommand;
import commands.DropAssocCommand;
import entities.Doctor;
import entities.Patient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DoctorPanel extends JPanel {

    public DoctorPanel(Doctor doctor)
    {
        build(doctor);
    }

    private void build(Doctor doctor)
    {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(new JLabel("Name: " + doctor.getName()));

        add(new JLabel("Patients"));
        for (Patient patient: doctor.patients.toArray(new Patient[0]))
        {
            JPanel d = listPatientPanel(patient, doctor);
            add(d);
            d.setAlignmentX(Component.LEFT_ALIGNMENT);
        }

        JPanel emptyPanel = new JPanel();
        add(emptyPanel);
        emptyPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel addPatientPanel = addPatientPanel(doctor);
        add(addPatientPanel);
        addPatientPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        addPatientPanel.setMaximumSize(addPatientPanel.getPreferredSize());

        add(new JLabel("  "));
        final JButton exitButton = new JButton("Exit");
        add(exitButton);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitButton.getTopLevelAncestor().setVisible(false);
            }
        });
    }

    private JPanel listPatientPanel(final Patient patient, final Doctor doctor)
    {
        JPanel patientPanel = new JPanel();
        patientPanel.add(new JLabel("  "));
        patientPanel.add(new JLabel(patient.getName()));
        JButton removeButton = new JButton("remove");
        patientPanel.add(removeButton);
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DropAssocCommand dropAssoc = new DropAssocCommand();
                dropAssoc.dropAssociation(doctor.getName(), patient.getHealthNumber());
                if (dropAssoc.wasSuccessful())
                {
                    removeAll();
                    build(doctor);
                    revalidate();
                }
                else
                {
                    JOptionPane.showMessageDialog(DoctorPanel.this, dropAssoc.getErrorMessage());
                }
            }
        });
        return patientPanel;
    }

    private JPanel addPatientPanel(final Doctor doctor)
    {
        JPanel addPatientPanel = new JPanel();
        addPatientPanel.add(new JLabel("Add patient"));
        final JTextField textField = new JTextField(10);
        addPatientPanel.add(textField);
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String patientNameString = textField.getText();
                AssignDoctorCommand addAssoc = null;
                try {
                    int patientNameInt = Integer.parseInt(patientNameString);
                    addAssoc = new AssignDoctorCommand();
                    addAssoc.assignDoctor(doctor.getName(), patientNameInt);
                }
                catch (NumberFormatException exception)
                {
                    revalidate();
                    return;
                }
                if (addAssoc.wasSuccessful())
                {
                    removeAll();
                    build(doctor);
                    revalidate();
                }
                else
                {
                    JOptionPane.showMessageDialog(DoctorPanel.this, addAssoc.getErrorMessage());
                }
            }
        });
        return addPatientPanel;
    }

    public static final long serialVersionUID = 1;
}
