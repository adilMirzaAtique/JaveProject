

package gui;

import javax.swing.*;
import java.awt.*;

/**
 * This frame displays state of the system a listing of all the beds in the ward.
 */
public class DisplayFrame extends JFrame{

    /** The standard width for the frame. */
    private static final int DEFAULT_WIDTH = 400;

    /** The standard height for the frame. */
    private static final int DEFAULT_HEIGHT = 400;

    /**
     * Create the frame to display system state
     */
    public DisplayFrame() {
        setTitle("System State");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        BedsPanel panel = new BedsPanel();
        add(panel);
    }
    public static final long serialVersionUID = 1;
}