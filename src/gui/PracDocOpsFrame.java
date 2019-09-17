package gui;

import javax.swing.*;
import java.awt.*;

public class PracDocOpsFrame extends JFrame {

    private PracDocOps panel;

    private JButton button;

    public PracDocOpsFrame()
    {
        setSize(500, 500);
        setTitle("Practice Frame");
        panel = new PracDocOps();
        add(panel);
    }

    public static void main(String[] args)
    {
        PracDocOpsFrame frame = new PracDocOpsFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
