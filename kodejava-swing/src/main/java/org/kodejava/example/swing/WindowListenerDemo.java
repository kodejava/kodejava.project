package org.kodejava.example.swing;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowListenerDemo extends JFrame {
    public WindowListenerDemo() {
        initializeComponent();
    }

    private void initializeComponent() {
        setSize(300, 300);
        setTitle("Window Listener");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.addWindowListener(new WindowAdapter() {
            // Invoked when a window has been opened.
            public void windowOpened(WindowEvent e) {
                System.out.println("Window Opened Event");
            }

            // Invoked when a window is in the process of being closed.
            // The close operation can be overridden at this point.
            public void windowClosing(WindowEvent e) {
                System.out.println("Window Closing Event");
            }

            // Invoked when a window has been closed.
            public void windowClosed(WindowEvent e) {
                System.out.println("Window Close Event");
            }

            // Invoked when a window is iconified.
            public void windowIconified(WindowEvent e) {
                System.out.println("Window Iconified Event");
            }

            // Invoked when a window is de-iconified.
            public void windowDeiconified(WindowEvent e) {
                System.out.println("Window Deiconified Event");
            }

            // Invoked when a window is activated.
            public void windowActivated(WindowEvent e) {
                System.out.println("Window Activated Event");
            }

            // Invoked when a window is de-activated.
            public void windowDeactivated(WindowEvent e) {
                System.out.println("Window Deactivated Event");
            }

            // Invoked when a window state is changed.
            public void windowStateChanged(WindowEvent e) {
                System.out.println("Window State Changed Event");
            }

            // Invoked when the Window is set to be the focused Window, which means
            // that the Window, or one of its sub components, will receive keyboard
            // events.
            public void windowGainedFocus(WindowEvent e) {
                System.out.println("Window Gained Focus Event");
            }

            // Invoked when the Window is no longer the focused Window, which means
            // that keyboard events will no longer be delivered to the Window or any of
            // its sub components.
            public void windowLostFocus(WindowEvent e) {
                System.out.println("Window Lost Focus Event");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new WindowListenerDemo().setVisible(true);
            }
        });
    }
}
