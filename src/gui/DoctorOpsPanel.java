package gui;

import containers.DoctorSetAccess;
import entities.Patient;

import javax.print.Doc;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DoctorOpsPanel extends JPanel {

    public DoctorOpsPanel()
    {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(Box.createVerticalGlue());

        JButton addButton = new JButton("Add Doctor");
        addButton.setMaximumSize(addButton.getPreferredSize());
        add(addButton);
        addButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DoctorAddFrame frame = new DoctorAddFrame();
                frame.setLocation(300,300);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.setVisible(true);
            }
        });
        add(Box.createVerticalGlue());

        DoctorAccessPanel accessPanel = new DoctorAccessPanel();
        add(accessPanel);

        JButton listAllButton = new JButton("List all");
        listAllButton.setMaximumSize(listAllButton.getPreferredSize());
        add(listAllButton);
        listAllButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        listAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, DoctorSetAccess.dictionary().values());
            }
        });
        add(Box.createVerticalGlue());

        final JButton exitButton = new JButton("Exit");
        exitButton.setMaximumSize(exitButton.getPreferredSize());
        add(exitButton);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitButton.getTopLevelAncestor().setVisible(false);
            }
        });
        add(Box.createVerticalGlue());
    }

    public static final long serialVersionUID = 1;
}
