package gui;

import startup.HospitalSystem;

import javax.swing.*;
import javax.xml.bind.annotation.XmlType;

public class DoctorOpsFrame extends JFrame {

    public static final int DEFAULT_WIDTH = 350;

    public static final int DEFAULT_HEIGHT = 200;

    public DoctorOpsFrame()
    {
        setTitle("Doctor Operation");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        DoctorOpsPanel panel = new DoctorOpsPanel();
        add(panel);
    }

    public static void main(String[] args)
    {
        HospitalSystem system = new HospitalSystem();
        system.initialize();
        PatientOpsFrame frame = new PatientOpsFrame();
        frame.setLocation(300,300);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setVisible(true);
    }

    public static final long serialVersionUID = 1;

}
