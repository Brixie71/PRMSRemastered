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
import org.netbeans.lib.awtextra.AbsoluteConstraints;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public final class PMDSDispatch extends JFrame {
    
    
    // <editor-fold defaultstate="collapsed" desc="<<< Component Declarations.">
    JPanel navigationBar, navigationBarLabel, dBHTab, homeTabIndicator, dBDTab, databaseTabIndicator, profileTab, profileTabIndicator, aboutTab, aboutTabIndicator,
           titleBar,
           dashBarHome, dashbarDatabase, dashbarProfile, dashbarAbout;
    
    
    JLabel nBLText, homeTabText, databaseTabText, profileTabText, aboutTabText,
            logo, companyName, cNameShadow, programName, 
            dBHBackground, homeText, databaseText, dBDBackground, officerProfileText, dOPBackground, aboutDashBarText, aboutBackground;
    
    Font IronShark;
    
    // </editor-fold>
    
    // FRAME DRAGGER
    int xMouse;
    int yMouse;

    public PMDSDispatch() {
        MainGUIWindow();

    }

    private void MainGUIWindow() {

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

        // CENTER POPUP MAIN WINDOW.
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dimension.width / 2 - this.getWidth() / 2, dimension.height / 2 - this.getHeight() / 2);

        // </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc="<<< Component Instantiations.">
        navigationBar = new JPanel();
        navigationBarLabel = new JPanel();
        
        dBHTab = new JPanel();
        homeTabIndicator = new JPanel();
        
        dBDTab = new JPanel();
        databaseTabIndicator = new JPanel();
        
        profileTab = new JPanel();
        profileTabIndicator = new JPanel();
        
        aboutTab = new JPanel();
        aboutTabIndicator = new JPanel();
        
        titleBar = new JPanel();
        
        dashBarHome = new JPanel();
        dashbarDatabase = new JPanel();
        dashbarProfile = new JPanel();
        dashbarAbout = new JPanel();

        nBLText = new JLabel();
        homeTabText = new JLabel();
        databaseTabText = new JLabel();
        profileTabText = new JLabel();
        aboutTabText = new JLabel();
        
        logo = new JLabel();
        companyName = new JLabel();
        cNameShadow = new JLabel();
        programName = new JLabel();
        
        homeText = new JLabel();
        dBHBackground = new JLabel();
        databaseText = new JLabel();
        dBDBackground = new JLabel();
        officerProfileText = new JLabel();
        dOPBackground = new JLabel();
        aboutDashBarText = new JLabel();
        aboutBackground = new JLabel();
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="<<< JPanel Declarations.">
        // <editor-fold defaultstate="collapsed" desc="<<< Navigation Bar Components.">

        // Navigation Bar (JPanel) Decorations.
            final int navigationPanelHeight = 574;
            final int navigationPanelWidth = 202;
            final int navigationPanelLocationX = 0;
            final int navigationPanelLocationY = 126;

            navigationBar.setBounds(navigationPanelLocationX, navigationPanelLocationY, navigationPanelWidth, navigationPanelHeight);
            add(navigationBar, new AbsoluteConstraints(navigationPanelLocationX, navigationPanelLocationY, navigationPanelWidth, navigationPanelHeight));
            navigationBar.setBackground(new java.awt.Color(0, 0, 32));
            navigationBar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 200, 0), 2, false));
            navigationBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            // Navigation Bar Label (JPanel) Decorations.
                final int navigationTabHeight = 50;
                final int navigationTabWidth = 190;
                final int navigationTabLocationX = 6;
                final int navigationTabLocationY = 6;

                navigationBarLabel.setBounds(navigationTabLocationX, navigationTabLocationY, navigationTabWidth, navigationTabHeight);
                navigationBar.add(navigationBarLabel, new AbsoluteConstraints(navigationTabLocationX, navigationTabLocationY, navigationTabWidth, navigationTabHeight));
                navigationBarLabel.setBackground(new java.awt.Color(255, 208, 0));
                navigationBarLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
                navigationBarLabel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                // nBLText (JLabel) Decorations.
                    nBLText.setBounds(navigationTabLocationX, navigationTabLocationY, navigationTabWidth, navigationTabHeight);
                    navigationBarLabel.add(nBLText, new AbsoluteConstraints(0, 0, navigationTabWidth, navigationTabHeight));
                    nBLText.setForeground(new java.awt.Color(0, 0, 0));
                    nBLText.setFont(new java.awt.Font("Verdana", Font.BOLD, 14));
                    nBLText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    nBLText.setText("Navigation Bar");

                // Home Tab (JPanel) Decorations.
                    final int dBHTAbX = 6;
                    final int dBHTabY = 60;

                    dBHTab.setBounds(dBHTAbX, dBHTabY, navigationTabWidth, navigationTabHeight);
                    navigationBar.add(dBHTab, new AbsoluteConstraints(dBHTAbX, dBHTabY, navigationTabWidth, navigationTabHeight));
                    dBHTab.setBackground(new java.awt.Color(21, 21, 21));
                    dBHTab.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
                    dBHTab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                    // Home Tab Text(JLabel) Decorations.
                        homeTabText.setBounds(navigationTabLocationX, navigationTabLocationY, navigationTabWidth, navigationTabHeight);
                        dBHTab.add(homeTabText, new AbsoluteConstraints(0, 0, navigationTabWidth, navigationTabHeight));
                        homeTabText.setForeground(new java.awt.Color(255, 255, 255));
                        homeTabText.setFont(new java.awt.Font("Cambria", Font.BOLD, 14));
                        homeTabText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        homeTabText.setText("Home");

                        // Home Tab Indicator (JPanel) Decorations.
                            final int homeTabIndicatorHeight = 46;
                            final int homeTabIndicatorWidth = 10;
                            final int homeTabIndicatorLocationX = 178;
                            final int homeTabIndicatorLocationY = 2;

                            homeTabIndicator.setBounds(homeTabIndicatorLocationX, homeTabIndicatorLocationY, homeTabIndicatorWidth, homeTabIndicatorHeight);
                            dBHTab.add(homeTabIndicator, new AbsoluteConstraints(homeTabIndicatorLocationX, homeTabIndicatorLocationY, homeTabIndicatorWidth, homeTabIndicatorHeight));
                            homeTabIndicator.setBackground(new java.awt.Color(255, 208, 0));
                            homeTabIndicator.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
                            homeTabIndicator.setVisible(true);

                // Database Tab (JPanel) Decorations.
                    final int dBDTabX = 6;
                    final int dBDTabY = 114;

                    dBDTab.setBounds(dBDTabX, dBDTabY, navigationTabWidth, navigationTabHeight);
                    navigationBar.add(dBDTab, new AbsoluteConstraints(dBDTabX, dBDTabY, navigationTabWidth, navigationTabHeight));
                    dBDTab.setBackground(new java.awt.Color(21, 21, 21));
                    dBDTab.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
                    dBDTab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                    // Database Tab Text (JLabel) Decorations.      
                    databaseTabText.setBounds(navigationTabLocationX, navigationTabLocationY, navigationTabWidth, navigationTabHeight);
                    dBDTab.add(databaseTabText, new AbsoluteConstraints(0, 0, navigationTabWidth, navigationTabHeight));
                    databaseTabText.setForeground(new java.awt.Color(255, 255, 255));
                    databaseTabText.setFont(new java.awt.Font("Cambria", Font.BOLD, 14));
                    databaseTabText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    databaseTabText.setText("Database");

                    // Database Tab Indicator (JPanel) Declarations.
                        final int databaseTabIndicatorHeight = 46;
                        final int databaseTabIndicatorWidth = 10;
                        final int databaseTabIndicatorLocationX = 178;
                        final int databaseTabIndicatorLocationY = 2;

                        // Database Tab Indicator (JPanel) Decorations.
                            databaseTabIndicator.setBounds(databaseTabIndicatorLocationX, databaseTabIndicatorLocationY, databaseTabIndicatorWidth, databaseTabIndicatorHeight);
                            dBDTab.add(databaseTabIndicator, new AbsoluteConstraints(databaseTabIndicatorLocationX, databaseTabIndicatorLocationY, databaseTabIndicatorWidth, databaseTabIndicatorHeight));
                            databaseTabIndicator.setBackground(new java.awt.Color(255, 208, 0));
                            databaseTabIndicator.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
                            databaseTabIndicator.setVisible(false);

                // Officer Profile Tab (JPanel) Decorations.
                    final int profileTabX = 6;
                    final int profileTabY = 168;

                    profileTab.setBounds(profileTabX, profileTabY, navigationTabWidth, navigationTabHeight);
                    navigationBar.add(profileTab, new AbsoluteConstraints(profileTabX, profileTabY, navigationTabWidth, navigationTabHeight));
                    profileTab.setBackground(new java.awt.Color(21, 21, 21));
                    profileTab.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
                    profileTab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                    // Officer Profile Tab Text (JLabel) Decorations.
                        profileTabText.setBounds(navigationTabLocationX, navigationTabLocationY, navigationTabWidth, navigationTabHeight);
                        profileTab.add(profileTabText, new AbsoluteConstraints(0, 0, navigationTabWidth, navigationTabHeight));
                        profileTabText.setForeground(new java.awt.Color(255, 255, 255));
                        profileTabText.setFont(new java.awt.Font("Cambria", Font.BOLD, 14));
                        profileTabText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        profileTabText.setText("Officer Profile");

                        // Officer Profile Tab Indicator (JPanel) Decorations.
                            final int profileTabIndicatorHeight = 46;
                            final int profileTabIndicatorWidth = 10;
                            final int profileTabIndicatorLocationX = 178;
                            final int profileTabIndicatorLocationY = 2;

                            profileTabIndicator.setBounds(profileTabIndicatorLocationX, profileTabIndicatorLocationY, profileTabIndicatorWidth, profileTabIndicatorHeight);
                            profileTab.add(profileTabIndicator, new AbsoluteConstraints(profileTabIndicatorLocationX, profileTabIndicatorLocationY, profileTabIndicatorWidth, profileTabIndicatorHeight));
                            profileTabIndicator.setBackground(new java.awt.Color(255, 208, 0));
                            profileTabIndicator.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
                            profileTabIndicator.setVisible(false);

                // About Software Tab (JPanel) Decorations.

                    final int aboutTabLocationX = 6;
                    final int aboutTabLocationY = 222;

                    aboutTab.setBounds(aboutTabLocationX, aboutTabLocationY, navigationTabWidth, navigationTabHeight);
                    navigationBar.add(aboutTab, new AbsoluteConstraints(aboutTabLocationX, aboutTabLocationY, navigationTabWidth, navigationTabHeight));
                    aboutTab.setBackground(new java.awt.Color(21, 21, 21));
                    aboutTab.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
                    aboutTab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                    // About Software Tab (JText) Decorations.

                        aboutTabText.setBounds(navigationTabLocationX, navigationTabLocationY, navigationTabWidth, navigationTabHeight);
                        aboutTab.add(aboutTabText, new AbsoluteConstraints(0, 0, navigationTabWidth, navigationTabHeight));
                        aboutTabText.setForeground(new java.awt.Color(255, 255, 255));
                        aboutTabText.setFont(new java.awt.Font("Cambria", Font.BOLD, 14));
                        aboutTabText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        aboutTabText.setText("About");

                        // About Software Tab Indicator (JPanel) Decorations.

                            final int aboutTabIndicatorLocationX = 178;
                            final int aboutTabIndicatorLocationY = 2;
                            final int aboutTabIndicatorWidth = 10;
                            final int aboutTabIndicatorHeigth = 46;

                            aboutTabIndicator.setBounds(aboutTabIndicatorLocationX, aboutTabIndicatorLocationY, aboutTabIndicatorWidth, aboutTabIndicatorHeigth);
                            aboutTab.add(aboutTabIndicator, new AbsoluteConstraints(aboutTabIndicatorLocationX, aboutTabIndicatorLocationY, aboutTabIndicatorWidth, aboutTabIndicatorHeigth));
                            aboutTabIndicator.setBackground(new java.awt.Color(255, 208, 0));
                            aboutTabIndicator.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
                            aboutTabIndicator.setVisible(false);


        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="<<< Title Bar Components.">
        // Title Bar (JPanel) Decorations.
            final int titlePanelHeight = 128;
            final int titlePanelWidth = 1000;
            final int titlePanelLocationX = 0;
            final int titlePanelLocationY = 0;

            titleBar.setBounds(titlePanelLocationX, titlePanelLocationY, titlePanelWidth, titlePanelHeight);
            add(titleBar, new AbsoluteConstraints(titlePanelLocationX, titlePanelLocationY, titlePanelWidth, titlePanelHeight));
            titleBar.setBackground(new java.awt.Color(0, 0, 32));
            titleBar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 200, 0), 2, false));
            titleBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            // Title Bar Frame dragging Declaration.
            titleBar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
                public void mouseDragged(java.awt.event.MouseEvent evt) {
                    titleBarMouseDragged(evt);
                }
            });

            titleBar.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mousePressed(java.awt.event.MouseEvent evt) {
                    titleBarMousePressed(evt);
                }
            });

            // Title Bar Logo (JLabel) Decorations.
                final int logoHeight = 158;
                final int logoWidth = 158;
                final int logoLocationX = 5;
                final int logoLocationY = 5;

                logo.setBounds(logoLocationX, logoLocationY, logoWidth, logoHeight);
                titleBar.add(logo, new AbsoluteConstraints(logoLocationX, logoLocationY, logoWidth, logoHeight));
                logo.setForeground(new java.awt.Color(0, 0, 0));
                logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                logo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                ImageIcon logoGetter = new ImageIcon("src\\PRMS Files\\logo\\BTSLogo1.png");
                Image getLogo = logoGetter.getImage();
                Image scaleLogo = getLogo.getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon displayLogo = new ImageIcon(scaleLogo);
                logo.setIcon(displayLogo);

            // Title Bar Text (JLabel) Declarations.        

                final int companyNameHeight = 20;
                final int companyNameWidth = 600;
                final int companyNameLocationX = 150;
                final int companyNameLocationY = 50;
                final int cNameShadowLocationY = 54;

                companyName.setBounds(companyNameLocationX, companyNameLocationY, companyNameWidth, companyNameHeight);
                titleBar.add(companyName, new AbsoluteConstraints(companyNameLocationX, companyNameLocationY, companyNameWidth, companyNameHeight));
                companyName.setForeground(new java.awt.Color(255, 208, 0));
                companyName.setFont(new java.awt.Font("Iron Shark", Font.PLAIN, 20));

                cNameShadow.setBounds(companyNameLocationX, cNameShadowLocationY, companyNameWidth, companyNameHeight);
                titleBar.add(cNameShadow, new AbsoluteConstraints(companyNameLocationX, cNameShadowLocationY, companyNameWidth, companyNameHeight));
                cNameShadow.setForeground(new java.awt.Color(0, 0, 0));
                cNameShadow.setFont(new java.awt.Font("Iron Shark", Font.PLAIN, 20));

                try {

                    IronShark = Font.createFont(Font.TRUETYPE_FONT, new File("src\\PRMS Files\\fonts\\Iron-Shark.ttf")).deriveFont(20f);
                    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                    ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src\\PRMS Files\\fonts\\Iron-Shark.ttf")));

                } catch (IOException | FontFormatException e) {
                    e.printStackTrace();
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

                programName.setBounds(programNameLocationX, programNameLocationY, programNameWidth, programNameHeight);
                titleBar.add(programName, new AbsoluteConstraints(programNameLocationX, programNameLocationY, programNameWidth, programNameHeight));
                programName.setForeground(new java.awt.Color(255, 255, 255));
                programName.setFont(new java.awt.Font("Impact", Font.PLAIN, 25));
                programName.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
                programName.setText("POLICE MOBILE AND DISPATCH SYSTEM");
                programName.setVisible(true);

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="<<< Dashbar Components.">
        
        // Dashbar Home Components.
        
            // Dashbar Home (JPanel) Decorations.
                final int dashBarHeight = 574;
                final int dashBarWidth = 801;
                final int dashBarLocationX = 199;
                final int dashBarLocationY = 126;

                dashBarHome.setBounds(dashBarLocationX, dashBarLocationY, dashBarWidth, dashBarHeight);
                add(dashBarHome, new AbsoluteConstraints(dashBarLocationX, dashBarLocationY, dashBarWidth, dashBarHeight));
                dashBarHome.setBackground(new java.awt.Color(0, 0, 32));
                dashBarHome.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 200, 0), 2, false));
                dashBarHome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            // Home Dashbar Name (JLabel) Decorations.
                final int homeTextHeight = 30;
                final int homeTextWidth = 200;
                final int homeTextX = 660;
                final int homeTextY = 548;

                homeText.setBounds(homeTextX, homeTextY, homeTextWidth, homeTextHeight);
                dashBarHome.add(homeText, new AbsoluteConstraints(homeTextX, homeTextY, homeTextWidth, homeTextHeight));
                homeText.setForeground(new java.awt.Color(255, 255, 255));
                homeText.setFont(new java.awt.Font("Impact", Font.PLAIN, 14));
                homeText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                homeText.setText("HOME");
                homeText.setVisible(true);

            // DashBar Home Background (JLabel) Decorations.
                final int dBHBackgroundHeight = 568;
                final int dBHBackgroundWidth = 795;
                final int dBHBackgroundLocationX = 3;
                final int dBHBackgroundLocationY = 3;

                dBHBackground.setBounds(dBHBackgroundLocationX, dBHBackgroundLocationY, dBHBackgroundWidth, dBHBackgroundHeight);
                dashBarHome.add(dBHBackground, new AbsoluteConstraints(dBHBackgroundLocationX, dBHBackgroundLocationY, dBHBackgroundWidth, dBHBackgroundHeight));
                dBHBackground.setForeground(new java.awt.Color(0, 0, 0));
                dBHBackground.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                dBHBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                ImageIcon icon = new ImageIcon("src\\PRMS Files\\backgrounds\\carbonbackground.jpg");
                Image homeBackground = icon.getImage();
                Image imgScale = homeBackground.getScaledInstance(dBHBackground.getWidth(), dBHBackground.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon scaledIcon = new ImageIcon(imgScale);
                dBHBackground.setIcon(scaledIcon);

        // Dashbar Database Components.
        
            // Database Dashbar Name (JLabel) Decorations.
                final int databaseTextHeight = 30;
                final int databaseTextWidth = 200;
                final int databaseTextX = 660;
                final int databaseTextY = 548;

                databaseText.setBounds(databaseTextX, databaseTextY, databaseTextWidth, databaseTextHeight);
                dashbarDatabase.add(databaseText, new AbsoluteConstraints(databaseTextX, databaseTextY, databaseTextWidth, databaseTextHeight));
                databaseText.setForeground(new java.awt.Color(255, 255, 255));
                databaseText.setFont(new java.awt.Font("Impact", Font.PLAIN, 14));
                databaseText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                databaseText.setText("DATABASE");
                databaseText.setVisible(true);

            // Dashbar Database (JPanel) Decorations.
                final int dashbarDatabaseHeight = 574;
                final int dashbarDatabaseWidth = 801;
                final int dashbarDatabaseLocationX = 199;
                final int dashbarDatabaseLocationY = 126;

                dashbarDatabase.setBounds(dashbarDatabaseLocationX, dashbarDatabaseLocationY, dashbarDatabaseWidth, dashbarDatabaseHeight);
                add(dashbarDatabase, new AbsoluteConstraints(dashbarDatabaseLocationX, dashbarDatabaseLocationY, dashbarDatabaseWidth, dashbarDatabaseHeight));
                dashbarDatabase.setBackground(new java.awt.Color(0, 0, 32));
                dashbarDatabase.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 200, 0), 2, false));
                dashbarDatabase.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            // dBDBackground (JLabel) Decorations.
                final int dBDBackgroundHeight = 568;
                final int dBDBackgroundWidth = 795;
                final int dBDBackgroundLocationX = 3;
                final int dBDBackgroundLocationY = 3;

                dBDBackground.setBounds(dBHBackgroundLocationX, dBHBackgroundLocationY, dBHBackgroundWidth, dBHBackgroundHeight);
                dashbarDatabase.add(dBDBackground, new AbsoluteConstraints(dBDBackgroundLocationX, dBDBackgroundLocationY, dBDBackgroundWidth, dBDBackgroundHeight));
                dBDBackground.setForeground(new java.awt.Color(0, 0, 0));
                dBDBackground.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                dBDBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                ImageIcon icon2 = new ImageIcon("src\\PRMS Files\\backgrounds\\carbonbackground.jpg");
                Image databaseBackground = icon2.getImage();
                Image imgScale2 = databaseBackground.getScaledInstance(dBHBackground.getWidth(), dBHBackground.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon scaledIcon2 = new ImageIcon(imgScale2);
                dBDBackground.setIcon(scaledIcon2);

        // Dashbar Officer Profile Components.
        
            // Officer Profile Dashbar Name (JLabel) Decorations.
                final int officerProfileTextHeight = 30;
                final int officerProfileTextWidth = 200;
                final int officerProfileTextX = 645;
                final int officerProfileTextY = 548;

                officerProfileText.setBounds(officerProfileTextX, officerProfileTextY, officerProfileTextWidth, officerProfileTextHeight);
                dashbarProfile.add(officerProfileText, new AbsoluteConstraints(officerProfileTextX, officerProfileTextY, officerProfileTextWidth, officerProfileTextHeight));
                officerProfileText.setForeground(new java.awt.Color(255, 255, 255));
                officerProfileText.setFont(new java.awt.Font("Impact", Font.PLAIN, 14));
                officerProfileText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                officerProfileText.setText("OFFICER PROFILE");
                officerProfileText.setVisible(true);

            // Dashbar Officer Profile (JPanel) Decorations.
                final int dashbarProfileHeight = 574;
                final int dashbarProfileWidth = 801;
                final int dashbarProfileLocationX = 199;
                final int dashbarProfileLocationY = 126;

                dashbarProfile.setBounds(dashbarProfileLocationX, dashbarProfileLocationY, dashbarProfileWidth, dashbarProfileHeight);
                add(dashbarProfile, new AbsoluteConstraints(dashbarProfileLocationX, dashbarProfileLocationY, dashbarProfileWidth, dashbarProfileHeight));
                dashbarProfile.setBackground(new java.awt.Color(0, 0, 32));
                dashbarProfile.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 200, 0), 2, false));
                dashbarProfile.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
                dashbarProfile.setVisible(false);

            // dOPBackground (JLAbel) Decorations.
                final int dOPBackgroundHeight = 568;
                final int dOPBackgroundWidth = 795;
                final int dOPBackgroundLocationX = 3;
                final int dOPBackgroundLocationY = 3;

                dOPBackground.setBounds(dOPBackgroundLocationX, dOPBackgroundLocationY, dOPBackgroundWidth, dOPBackgroundHeight);
                dashbarProfile.add(dOPBackground, new AbsoluteConstraints(dOPBackgroundLocationX, dOPBackgroundLocationY, dOPBackgroundWidth, dOPBackgroundHeight));
                dOPBackground.setForeground(new java.awt.Color(0, 0, 0));
                dOPBackground.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                dOPBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                ImageIcon icon3 = new ImageIcon("src\\PRMS Files\\backgrounds\\carbonbackground.jpg");
                Image profileBackground = icon3.getImage();
                Image imgScale3 = profileBackground.getScaledInstance(dBHBackground.getWidth(), dBHBackground.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon scaledIcon3 = new ImageIcon(imgScale3);
                dOPBackground.setIcon(scaledIcon3);

        // Dashbar About Components.

            // DashBar About Name (JLabel) Decorations.
                final int dashbarAboutTextX = 645;
                final int dashbarAboutTextY = 548;
                final int dashbarAboutTextWidth = 200;
                final int dashbarAboutTextHeight = 30;

                aboutDashBarText.setBounds(dashbarAboutTextX, dashbarAboutTextY, dashbarAboutTextWidth, dashbarAboutTextHeight);
                dashbarAbout.add(aboutDashBarText, new AbsoluteConstraints(dashbarAboutTextX, dashbarAboutTextY, dashbarAboutTextWidth, dashbarAboutTextHeight));
                aboutDashBarText.setForeground(new java.awt.Color(255, 255, 255));
                aboutDashBarText.setFont(new java.awt.Font("Impact", Font.PLAIN, 14));
                aboutDashBarText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                aboutDashBarText.setText("ABOUT");
                aboutDashBarText.setVisible(true);

            // Dashbar About Software (JPanel) Decorations.

                final int dashbarAboutLocationX = 199;
                final int dashbarAboutLocationY = 126;
                final int dashbarAboutWidth = 801;
                final int dashbarAboutHeight = 574;

                dashbarAbout.setBounds(dashbarAboutLocationX, dashbarAboutLocationY, dashbarAboutWidth, dashbarAboutHeight);
                add(dashbarAbout, new AbsoluteConstraints(dashbarAboutLocationX, dashbarAboutLocationY, dashbarAboutWidth, dashbarAboutHeight));
                dashbarAbout.setBackground(new java.awt.Color(0, 0, 32));
                dashbarAbout.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 200, 0), 2, false));
                dashbarAbout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
                dashbarAbout.setVisible(false);

            // DashBar AboutBackground (JLAbel) Decorations.
                final int aboutBackgroundHeight = 568;
                final int aboutBackgroundWidth = 795;
                final int aboutBackgroundLocationX = 3;
                final int aboutBackgroundLocationY = 3;

                aboutBackground.setBounds(aboutBackgroundLocationX, aboutBackgroundLocationY, aboutBackgroundWidth, aboutBackgroundHeight);
                dashbarAbout.add(aboutBackground, new AbsoluteConstraints(aboutBackgroundLocationX, aboutBackgroundLocationY, aboutBackgroundWidth, aboutBackgroundHeight));
                aboutBackground.setForeground(new java.awt.Color(0, 0, 0));
                aboutBackground.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                aboutBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                ImageIcon icon4 = new ImageIcon("src\\PRMS Files\\backgrounds\\carbonbackground.jpg");
                Image getAboutBackground = icon4.getImage();
                Image imgScale4 = getAboutBackground.getScaledInstance(aboutBackground.getWidth(), aboutBackground.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon scaledIcon4 = new ImageIcon(imgScale4);
                aboutBackground.setIcon(scaledIcon4);


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
                //                                       R    G    B
                dBHTab.setBackground(new java.awt.Color(255, 255, 255));
                homeTabText.setForeground(new java.awt.Color(0, 0, 0));

                dashBarHome.setVisible(true);
                dashbarDatabase.setVisible(false);
                dashbarProfile.setVisible(false);
                dashbarAbout.setVisible(false);

                homeTabIndicator.setVisible(true);
                databaseTabIndicator.setVisible(false);
                profileTabIndicator.setVisible(false);
                aboutTabIndicator.setVisible(false);

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                dBHTab.setBackground(new java.awt.Color(21, 21, 21));
                homeTabText.setForeground(new java.awt.Color(255, 255, 255));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                dBHTab.setBackground(new java.awt.Color(100, 100, 100));
                homeTabText.setForeground(new java.awt.Color(0, 0, 0));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                dBHTab.setBackground(new java.awt.Color(21, 21, 21));
                homeTabText.setForeground(new java.awt.Color(255, 255, 255));
            }
        });

        dBDTab.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {

                dBDTab.setBackground(new java.awt.Color(255, 255, 255));
                databaseTabText.setForeground(new java.awt.Color(0, 0, 0));

                dashBarHome.setVisible(false);
                dashbarDatabase.setVisible(true);
                dashbarProfile.setVisible(false);
                dashbarAbout.setVisible(false);

                homeTabIndicator.setVisible(false);
                databaseTabIndicator.setVisible(true);
                profileTabIndicator.setVisible(false);
                aboutTabIndicator.setVisible(false);

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                dBDTab.setBackground(new java.awt.Color(21, 21, 21));
                databaseTabText.setForeground(new java.awt.Color(255, 255, 255));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                dBDTab.setBackground(new java.awt.Color(100, 100, 100));
                databaseTabText.setForeground(new java.awt.Color(0, 0, 0));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                dBDTab.setBackground(new java.awt.Color(21, 21, 21));
                databaseTabText.setForeground(new java.awt.Color(255, 255, 255));
            }
        });

        profileTab.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

                profileTab.setBackground(new java.awt.Color(255, 255, 255));
                profileTabText.setForeground(new java.awt.Color(0, 0, 0));

                dashBarHome.setVisible(false);
                dashbarDatabase.setVisible(false);
                dashbarProfile.setVisible(true);
                dashbarAbout.setVisible(false);

                homeTabIndicator.setVisible(false);
                databaseTabIndicator.setVisible(false);
                profileTabIndicator.setVisible(true);
                aboutTabIndicator.setVisible(false);

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                profileTab.setBackground(new java.awt.Color(21, 21, 21));
                profileTabText.setForeground(new java.awt.Color(255, 255, 255));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                profileTab.setBackground(new java.awt.Color(100, 100, 100));
                profileTabText.setForeground(new java.awt.Color(0, 0, 0));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                profileTab.setBackground(new java.awt.Color(21, 21, 21));
                profileTabText.setForeground(new java.awt.Color(255, 255, 255));
            }
        });

        aboutTab.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                aboutTab.setBackground(new java.awt.Color(255, 255, 255));
                aboutTabText.setForeground(new java.awt.Color(0, 0, 0));

                dashBarHome.setVisible(false);
                dashbarDatabase.setVisible(false);
                dashbarProfile.setVisible(false);
                dashbarAbout.setVisible(true);

                homeTabIndicator.setVisible(false);
                databaseTabIndicator.setVisible(false);
                profileTabIndicator.setVisible(false);
                aboutTabIndicator.setVisible(true);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                aboutTab.setBackground(new java.awt.Color(21, 21, 21));
                aboutTabText.setForeground(new java.awt.Color(255, 255, 255));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                aboutTab.setBackground(new java.awt.Color(100, 100, 100));
                aboutTabText.setForeground(new java.awt.Color(0, 0, 0));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                aboutTab.setBackground(new java.awt.Color(21, 21, 21));
                aboutTabText.setForeground(new java.awt.Color(255, 255, 255));
            }
        });

        pack();
        setLocationRelativeTo(null);
    }

    private void titleBarMouseDragged(java.awt.event.MouseEvent evt) {
        // JFRAME DRAGGER
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xMouse, y - yMouse);
    }

    private void titleBarMousePressed(java.awt.event.MouseEvent evt) {
        // JFRAME DRAGGER PART 2
        xMouse = evt.getX();
        yMouse = evt.getY();
    }

    public static void main(String[] args) {

        try {
            for ( javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels() ) {
                if ( "Windows".equals(info.getName()) ) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PMDSDispatch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }/*/ /*/

        PMDSDispatch Open = new PMDSDispatch();
        Open.setVisible(true);
    }
}
