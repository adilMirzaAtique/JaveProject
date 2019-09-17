package gui;

import containers.DoctorSetAccess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PracDocOps extends JPanel {

    public PracDocOps()
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
                DoctorAddFrame doctorAddFrame = new DoctorAddFrame();
                doctorAddFrame.setSize(300, 300);
                doctorAddFrame.setVisible(true);
                doctorAddFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            }
        });
        add(Box.createVerticalGlue());

        DoctorAccessPanel doctorAccessPanel = new DoctorAccessPanel();
        add(doctorAccessPanel);
        add(Box.createVerticalGlue());

        JButton listAllButton = new JButton("List all");
        listAllButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        listAllButton.setMaximumSize(listAllButton.getPreferredSize());
        add(listAllButton);
        listAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, DoctorSetAccess.dictionary().values());
            }
        });
        add(Box.createVerticalGlue());

        JButton exitButton = new JButton("Exit");
        exitButton.setMaximumSize(exitButton.getPreferredSize());
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(exitButton);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitButton.getTopLevelAncestor().setVisible(false);
            }
        });
        add(Box.createVerticalGlue());
    }
}
