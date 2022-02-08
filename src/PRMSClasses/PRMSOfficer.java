package PRMSClasses;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

public final class PRMSOfficer extends JFrame {
    
    public PRMSOfficer(){
        MainGUIWindow();
        
    }

    public void MainGUIWindow() {

        // CENTER POPUP MAIN WINDOW.
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dimension.width / 2 - this.getWidth() / 2, dimension.height / 2 - this.getHeight() / 2);
        
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
        setTitle("BTS Program");
        setLayout(null);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // <editor-fold defaultstate="collapsed" desc="<<< JPanel Declarations.">              
        // <editor-fold defaultstate="collapsed" desc="<<< Navigation Bar Components.">
        
        // Navigation Bar (JPanel) Declarations.
        final int navigationPanelHeight = 574;
        final int navigationPanelWidth = 202;
        final int navigationPanelLocationX = 0;
        final int navigationPanelLocationY = 126;

        JPanel navigationBar = new JPanel();

        // Navigation Bar (JPanel) Decorations.
        navigationBar.setBounds(navigationPanelLocationX, navigationPanelLocationY, navigationPanelWidth, navigationPanelHeight);
        add(navigationBar, new AbsoluteConstraints(navigationPanelLocationX, navigationPanelLocationY, navigationPanelWidth, navigationPanelHeight));
        navigationBar.setBackground(new java.awt.Color(0, 0, 32));
        navigationBar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 200, 0), 2, false));
        navigationBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        // Navigation Bar Label (JPanel) Declaration.
        final int navigationTabHeight = 50;
        final int navigationTabWidth = 190;
        final int navigationTabLocationX = 6;
        final int navigationTabLocationY = 6;

        JPanel navigationBarLabel = new JPanel();

        // Navigation Bar Label (JPanel) Decorations.
        navigationBarLabel.setBounds(navigationTabLocationX, navigationTabLocationY, navigationTabWidth, navigationTabHeight);
        navigationBar.add(navigationBarLabel, new AbsoluteConstraints(navigationTabLocationX, navigationTabLocationY, navigationTabWidth, navigationTabHeight));
        navigationBarLabel.setBackground(new java.awt.Color(255, 208, 0));
        navigationBarLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        navigationBarLabel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        // nBLText (JLabel) Declarations.
        JLabel nBLText = new JLabel();
        nBLText.setBounds(navigationTabLocationX, navigationTabLocationY, navigationTabWidth, navigationTabHeight);
        navigationBarLabel.add(nBLText, new AbsoluteConstraints(0, 0, navigationTabWidth, navigationTabHeight));
        nBLText.setForeground(new java.awt.Color(0, 0, 0));
        nBLText.setFont(new java.awt.Font("Verdana", 1, 14));
        nBLText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nBLText.setText("Navigation Bar");

        // Home Tab (JPanel) Declarations.
        final int dBHTAbX = 6;
        final int dBHTabY = 60;

        JPanel dBHTab = new JPanel();

        // Home Tab (JPanel) Decorations.
        dBHTab.setBounds(dBHTAbX, dBHTabY, navigationTabWidth, navigationTabHeight);
        navigationBar.add(dBHTab, new AbsoluteConstraints(dBHTAbX, dBHTabY, navigationTabWidth, navigationTabHeight));
        dBHTab.setBackground(new java.awt.Color(21, 21, 21));
        dBHTab.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        dBHTab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        // Home Tab Text(JLabel) Declarations and Decorations.
        JLabel homeTabText = new JLabel();
        homeTabText.setBounds(navigationTabLocationX, navigationTabLocationY, navigationTabWidth, navigationTabHeight);
        dBHTab.add(homeTabText, new AbsoluteConstraints(0, 0, navigationTabWidth, navigationTabHeight));
        homeTabText.setForeground(new java.awt.Color(255, 255, 255));
        homeTabText.setFont(new java.awt.Font("Cambria", 1, 14));
        homeTabText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        homeTabText.setText("Home");

        // Main Tab (JPanel) Declarations.
        final int dBMTabX = 6;
        final int dBMTabY = 114;

        JPanel dBMTab = new JPanel();

        // Main Tab (JPanel) Decorations.
        dBMTab.setBounds(dBMTabX, dBMTabY, navigationTabWidth, navigationTabHeight);
        navigationBar.add(dBMTab, new AbsoluteConstraints(dBMTabX, dBMTabY, navigationTabWidth, navigationTabHeight));
        dBMTab.setBackground(new java.awt.Color(21, 21, 21));
        dBMTab.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        dBMTab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        // Main Tab Text (JLabel) Declarations and Decorations.
        JLabel mainTabText = new JLabel();
        mainTabText.setBounds(navigationTabLocationX, navigationTabLocationY, navigationTabWidth, navigationTabHeight);
        dBMTab.add(mainTabText, new AbsoluteConstraints(0, 0, navigationTabWidth, navigationTabHeight));
        mainTabText.setForeground(new java.awt.Color(255, 255, 255));
        mainTabText.setFont(new java.awt.Font("Cambria", 1, 14));
        mainTabText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainTabText.setText("Database");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="<<< Title Bar Components.">                     
        
        // Title Bar (JPanel) Declaration
        final int titlePanelHeight = 128;
        final int titlePanelWidth = 1000;
        final int titlePanelLocationX = 0;
        final int titlePanelLocationY = 0;

        JPanel titleBar = new JPanel();

        // Title Bar (JPanel) Decorations.
        titleBar.setBounds(titlePanelLocationX, titlePanelLocationY, titlePanelWidth, titlePanelHeight);
        add(titleBar, new AbsoluteConstraints(titlePanelLocationX, titlePanelLocationY, titlePanelWidth, titlePanelHeight));
        titleBar.setBackground(new java.awt.Color(0, 0, 32));
        titleBar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 200, 0), 2, false));
        titleBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        // Title Bar Logo (JLabel) Declarations.
        final int logoHeight = 158;
        final int logoWidth = 158;
        final int logoLocationX = 5;
        final int logoLocationY = 5;

        JLabel logo = new JLabel();

        // Title Bar Logo (JLabel) Decorations.
        logo.setBounds(logoLocationX, logoLocationY, logoWidth, logoHeight);
        titleBar.add(logo, new AbsoluteConstraints(logoLocationX, logoLocationY, logoWidth, logoHeight));
        logo.setForeground(new java.awt.Color(0, 0, 0));
        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ImageIcon logoGetter = new ImageIcon("src\\res\\Brion-Tactical-Systems.png");
        Image getLogo = logoGetter.getImage();
        Image scaleLogo = getLogo.getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon displayLogo = new ImageIcon(scaleLogo);
        logo.setIcon(displayLogo);

        // Title Bar Text (JLabel) Declarations.
        Font IronShark;

        final int companyNameHeight = 20;
        final int companyNameWidth = 600;
        final int companyNameLocationX = 150;
        final int companyNameLocationY = 50;

        JLabel companyName = new JLabel();

        final int cNameShadowLocationY = 54;

        JLabel cNameShadow = new JLabel();

        companyName.setBounds(companyNameLocationX, companyNameLocationY, companyNameWidth, companyNameHeight);
        titleBar.add(companyName, new AbsoluteConstraints(companyNameLocationX, companyNameLocationY, companyNameWidth, companyNameHeight));
        companyName.setForeground(new java.awt.Color(255, 208, 0));
        companyName.setFont(new java.awt.Font("Iron Shark", 0, 20));

        cNameShadow.setBounds(companyNameLocationX, cNameShadowLocationY, companyNameWidth, companyNameHeight);
        titleBar.add(cNameShadow, new AbsoluteConstraints(companyNameLocationX, cNameShadowLocationY, companyNameWidth, companyNameHeight));
        cNameShadow.setForeground(new java.awt.Color(0, 0, 0));
        cNameShadow.setFont(new java.awt.Font("Iron Shark", 0, 20));

        try {

            IronShark = Font.createFont(Font.TRUETYPE_FONT, new File("src\\res\\Iron-Shark.ttf")).deriveFont(20f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src\\res\\Iron-Shark.ttf")));

        } catch (IOException | FontFormatException e) {

        }

        companyName.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        companyName.setText("Brion Tactical Systems");
        companyName.setVisible(true);

        cNameShadow.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        cNameShadow.setText("Brion Tactical Systems");
        cNameShadow.setVisible(true);
        
        // Program Name (JLabel) Declarations.
        
        final int programNameHeight = 25;
        final int programNameWidth = 600;
        final int programNameLocationX = 150;
        final int programNameLocationY = 70;
        
        JLabel programName = new JLabel();
        
        programName.setBounds(programNameLocationX, programNameLocationY, programNameWidth, programNameHeight);
        titleBar.add(programName, new AbsoluteConstraints(programNameLocationX, programNameLocationY, programNameWidth, programNameHeight));
        programName.setForeground(new java.awt.Color(255, 255, 255));
        programName.setFont(new java.awt.Font("Impact", 0, 25));
        programName.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        programName.setText("POLICE RECORD MANAGEMENT SYSTEM");
        programName.setVisible(true);
        
        // </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc="<<< Dashbar Components.">   
        
        // Dashbar Home (JPanel) Declarations.
        final int dashBarHeight = 574;
        final int dashBarWidth = 801;
        final int dashBarLocationX = 199;
        final int dashBarLocationY = 126;

        JPanel dashBarHome = new JPanel();

        // Dashbar Home (JPanel) Decorations.
        dashBarHome.setBounds(dashBarLocationX, dashBarLocationY, dashBarWidth, dashBarHeight);
        add(dashBarHome, new AbsoluteConstraints(dashBarLocationX, dashBarLocationY, dashBarWidth, dashBarHeight));
        dashBarHome.setBackground(new java.awt.Color(0, 0, 32));
        dashBarHome.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 200, 0), 2, false));
        dashBarHome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        // dBHBackground (JLabel) Declaration.
        final int dBHBackgroundHeight = 568;
        final int dBHBackgroundWidth = 795;
        final int dBHBackgroundLocationX = 3;
        final int dBHBackgroundLocationY = 3;

        JLabel dBHBackground = new JLabel();

        // Dashbar Home Components.
        final int homeTextHeight = 30;
        final int homeTextWidth = 200;
        final int homeTextX = 660;
        final int homeTextY = 548;

        JLabel homeText = new JLabel();

        homeText.setBounds(homeTextX, homeTextY, homeTextWidth, homeTextHeight);
        dashBarHome.add(homeText, new AbsoluteConstraints(homeTextX, homeTextY, homeTextWidth, homeTextHeight));
        homeText.setForeground(new java.awt.Color(255, 255, 255));
        homeText.setFont(new java.awt.Font("Impact", 0, 14));
        homeText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        homeText.setText("HOME");
        homeText.setVisible(true);

        // DashBar Home Background (JLabel) Decorations.
        dBHBackground.setBounds(dBHBackgroundLocationX, dBHBackgroundLocationY, dBHBackgroundWidth, dBHBackgroundHeight);
        dashBarHome.add(dBHBackground, new AbsoluteConstraints(dBHBackgroundLocationX, dBHBackgroundLocationY, dBHBackgroundWidth, dBHBackgroundHeight));
        dBHBackground.setForeground(new java.awt.Color(0, 0, 0));
        dBHBackground.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dBHBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ImageIcon icon = new ImageIcon("src\\res\\carbonbackgound.jpg");
        Image homeBackground = icon.getImage();
        Image imgScale = homeBackground.getScaledInstance(dBHBackground.getWidth(), dBHBackground.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        dBHBackground.setIcon(scaledIcon);

        // Dashbar Database (JPanel) Declarations.
        final int dashbarDatabaseHeight = 574;
        final int dashbarDatabaseWidth = 801;
        final int dashbarDatabaseLocationX = 199;
        final int dashbarDatabaseLocationY = 126;

        JPanel dashbarDatabase = new JPanel();

        // Dashbar Database Components.
        final int mainTextHeight = 30;
        final int mainTextWidth = 200;
        final int mainTextX = 660;
        final int mainTextY = 548;

        JLabel mainText = new JLabel();

        mainText.setBounds(mainTextX, mainTextY, mainTextWidth, mainTextHeight);
        dashbarDatabase.add(mainText, new AbsoluteConstraints(mainTextX, mainTextY, mainTextWidth, mainTextHeight));
        mainText.setForeground(new java.awt.Color(255, 255, 255));
        mainText.setFont(new java.awt.Font("Impact", 0, 14));
        mainText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainText.setText("DATABASE");
        mainText.setVisible(true);

        // Dashbar Database (JPanel) Decorations.
        dashbarDatabase.setBounds(dashbarDatabaseLocationX, dashbarDatabaseLocationY, dashbarDatabaseWidth, dashbarDatabaseHeight);
        add(dashbarDatabase, new AbsoluteConstraints(dashbarDatabaseLocationX, dashbarDatabaseLocationY, dashbarDatabaseWidth, dashbarDatabaseHeight));
        dashbarDatabase.setBackground(new java.awt.Color(0, 0, 32));
        dashbarDatabase.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 200, 0), 2, false));
        dashbarDatabase.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        // dBMBackground (JLabel) Declaration.
        final int dBDBackgroundHeight = 568;
        final int dBDBackgroundWidth = 795;
        final int dBDBackgroundLocationX = 3;
        final int dBDBackgroundLocationY = 3;

        JLabel dBDBackground = new JLabel();

        // dBHBackground (JLabel) Decorations.
        dBDBackground.setBounds(dBHBackgroundLocationX, dBHBackgroundLocationY, dBHBackgroundWidth, dBHBackgroundHeight);
        dashbarDatabase.add(dBDBackground, new AbsoluteConstraints(dBDBackgroundLocationX, dBDBackgroundLocationY, dBDBackgroundWidth, dBDBackgroundHeight));
        dBDBackground.setForeground(new java.awt.Color(0, 0, 0));
        dBDBackground.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dBDBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ImageIcon icon2 = new ImageIcon("src\\res\\carbonbackgound.jpg");
        Image mainBackground = icon2.getImage();
        Image imgScale2 = mainBackground.getScaledInstance(dBHBackground.getWidth(), dBHBackground.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon2 = new ImageIcon(imgScale2);
        dBDBackground.setIcon(scaledIcon2);
        // </editor-fold>

        // </editor-fold>
        // </editor-fold>  
        setVisible(true);
        navigationBar.setVisible(true);
        navigationBarLabel.setVisible(true);
        nBLText.setVisible(true);
        titleBar.setVisible(true);
        dashBarHome.setVisible(true);
        dashbarDatabase.setVisible(false);

        dBHTab.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

                dBHTab.setBackground(new java.awt.Color(255, 255, 255));
                homeTabText.setForeground(new java.awt.Color(0, 0, 0));

                dashBarHome.setVisible(true);
                dashbarDatabase.setVisible(false);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                dBHTab.setBackground(new java.awt.Color(255, 208, 0));
                homeTabText.setForeground(new java.awt.Color(0, 0, 0));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                dBHTab.setBackground(new java.awt.Color(255, 208, 0));
                homeTabText.setForeground(new java.awt.Color(0, 0, 0));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                dBHTab.setBackground(new java.awt.Color(21, 21, 21));
                homeTabText.setForeground(new java.awt.Color(255, 255, 255));
            }
        });

        dBMTab.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

                dBMTab.setBackground(new java.awt.Color(255, 255, 255));
                mainTabText.setForeground(new java.awt.Color(0, 0, 0));

                dashBarHome.setVisible(false);
                dashbarDatabase.setVisible(true);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                dBMTab.setBackground(new java.awt.Color(255, 208, 0));
                mainTabText.setForeground(new java.awt.Color(0, 0, 0));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                dBMTab.setBackground(new java.awt.Color(255, 208, 0));
                mainTabText.setForeground(new java.awt.Color(0, 0, 0));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                dBMTab.setBackground(new java.awt.Color(21, 21, 21));
                mainTabText.setForeground(new java.awt.Color(255, 255, 255));
            }
        });
        
        pack();
        setLocationRelativeTo(null);
    }
}
