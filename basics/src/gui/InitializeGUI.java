package gui;

import javax.swing.SwingUtilities;

public class InitializeGUI {
    public static void initFrame(){
        
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                MainFrame frame = new MainFrame();
                frame.setVisible(true);
            }
        });
        
        
        
        
        
    }
}
