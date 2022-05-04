
package PRMSClasses;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class PRMSModifyAccount extends JFrame {
    
    public PRMSModifyAccount(){
        
        ModifyAccountComponents();
        
    }
    
    private void ModifyAccountComponents() {
        
        // <editor-fold defaultstate="collapsed" desc="<<< JFrame Container.">
        // JFrame Declaration
        final int FrameSizeX = 1000;
        final int FrameSizeY = 700;

        //JFrame Size.
        setSize(FrameSizeX, FrameSizeY);
        setMinimumSize(new java.awt.Dimension(FrameSizeX, FrameSizeY));
        setPreferredSize(new java.awt.Dimension(FrameSizeX, FrameSizeY));

        //JFrame Decoration.
        setUndecorated(true);
        setOpacity(1.0f);
        setTitle("BTS : Modify Police Account");
        setLayout(null);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // CENTER POPUP MAIN WINDOW.
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dimension.width / 2 - this.getWidth() / 2, dimension.height / 2 - this.getHeight() / 2);

        // </editor-fold>
        
        pack();
        setLocationRelativeTo(null);
    }
    
    public static void main(String args[]){
        
        PRMSModifyAccount Open = new PRMSModifyAccount();
        Open.setVisible(true);
        
    }
}
