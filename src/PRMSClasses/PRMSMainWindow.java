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
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JCheckBox;

import static PRMSClasses.PRMSLogin.IronShark;
import static PRMSClasses.PRMSLogin.Quicksand; 
import static PRMSClasses.PRMSLogin.Gepestev;
import static PRMSClasses.PRMSLogin.minimize;

public final class PRMSMainWindow extends JFrame {
    
    JPanel navigationBar, navigationBarLabel, dBHTab, homeTabIndicator, dBDTab, databaseTabIndicator, profileTab, profileTabIndicator, aboutTab, aboutTabIndicator,
           titleBar,
           dashBarHome, dashbarDatabase, dashbarProfile, dashbarAbout;
    
    
    JLabel nBLText, homeTabText, databaseTabText, profileTabText, aboutTabText,
            logo, companyName, cNameShadow, programName, 
            dBHBackground, homeText, databaseText, dBDBackground, officerProfileText, dOPBackground, aboutDashBarText, aboutBackground,
            unitStatusText, UserLogsText;
    
    JRadioButton AvailabilityA, AvailabilityE;
    
    JCheckBox SirenToggle, EMSLights;
    
    ButtonGroup UnitStatus;
    
    JTextArea userLogsInput;
    
    JScrollPane userLogsScroller;
            

    // FRAME DRAGGER
    int xMouse;
    int yMouse;
    
      
    public PRMSMainWindow() {
        
        SetComponentLookAndFeel();
        
        PoliceMobileComponents();

    }

    private void PoliceMobileComponents() {

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
        setTitle("BTS : Police Database");
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
        
        unitStatusText = new JLabel();
        AvailabilityA = new JRadioButton();
        AvailabilityE = new JRadioButton();
        UnitStatus = new ButtonGroup();
        SirenToggle = new JCheckBox();
        EMSLights = new JCheckBox();     
        UserLogsText = new JLabel();
        userLogsInput = new JTextArea();
        userLogsScroller = new JScrollPane();
        
        minimize = new JButton();
        
        // </editor-fold>

        // CUSTOM FONTS 
        try {
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                
                // FOR COMPANY NAME
                IronShark = Font.createFont(Font.TRUETYPE_FONT, new File("src\\PRMS Files\\fonts\\Iron-Shark.ttf")).deriveFont(18f);
                ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src\\PRMS Files\\fonts\\Iron-Shark.ttf")));
                
                // FOR THE ENTIRE SYSTEM
                Quicksand = Font.createFont(Font.TRUETYPE_FONT, new File("src\\PRMS Files\\fonts\\Quicksand-Regular.ttf")).deriveFont(18f);
                ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src\\PRMS Files\\fonts\\Quicksand-Regular.ttf")));
                
                // FOR THE SYSTEM NAME
                Gepestev = Font.createFont(Font.TRUETYPE_FONT, new File("src\\PRMS Files\\fonts\\Gepestev.ttf")).deriveFont(18f);
                ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src\\PRMS Files\\fonts\\Gepestev.ttf")));

        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
        
        
        // <editor-fold defaultstate="collapsed" desc="<<< Navigation Bar Components.">

        // Navigation Bar (JPanel) Decorations.
        
            final int navigationPanelHeight = 574;
            final int navigationPanelWidth = 202;
            final int navigationPanelLocationX = 0;
            final int navigationPanelLocationY = 126;

            navigationBar.setBounds(navigationPanelLocationX, navigationPanelLocationY, navigationPanelWidth, navigationPanelHeight);
            add(navigationBar);
            navigationBar.setBackground(new java.awt.Color(10, 10, 10));
            navigationBar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 200, 0), 2, false));
            navigationBar.setLayout(null);

            // Navigation Bar Label (JPanel) Decorations.
                final int navigationTabHeight = 50;
                final int navigationTabWidth = 190;
                final int navigationTabLocationX = 6;
                final int navigationTabLocationY = 6;

                navigationBarLabel.setBounds(navigationTabLocationX, navigationTabLocationY, navigationTabWidth, navigationTabHeight);
                navigationBar.add(navigationBarLabel);
                navigationBarLabel.setBackground(new java.awt.Color(0, 29, 61));
                navigationBarLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.SoftBevelBorder.RAISED));
                navigationBarLabel.setLayout(null);

                // nBLText (JLabel) Decorations.
                    nBLText.setBounds(0, 0, navigationTabWidth, navigationTabHeight);
                    navigationBarLabel.add(nBLText);
                    nBLText.setForeground(new java.awt.Color(255, 255, 255));
                    nBLText.setFont(new java.awt.Font("Quicksand", Font.BOLD, 14));
                    nBLText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    nBLText.setIconTextGap(15);
                    nBLText.setText("Navigation Bar");
                    
                    ImageIcon navIcon = new ImageIcon("src\\PRMS Files\\icons\\Navigation_Bar.png");
                    Image getNavIcon = navIcon.getImage();
                    Image scaleNavIcon = getNavIcon.getScaledInstance(32, 32, Image.SCALE_SMOOTH);
                    ImageIcon displayNavIcon = new ImageIcon(scaleNavIcon);
                    nBLText.setIcon(displayNavIcon);

                // Home Tab (JPanel) Decorations.
                    final int dBHTAbX = 3;
                    final int dBHTabY = 60;
                    final int dBHTabWidth = 196;
                    final int dBHTabHeight = 50;

                    dBHTab.setBounds(dBHTAbX, dBHTabY, dBHTabWidth, dBHTabHeight);
                    navigationBar.add(dBHTab);
                    dBHTab.setBackground(new java.awt.Color(21, 21, 21));
                    dBHTab.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
                    dBHTab.setLayout(null);

                    // Home Tab Text(JLabel) Decorations.
                        homeTabText.setBounds(0, 0, navigationTabWidth, navigationTabHeight);
                        dBHTab.add(homeTabText);
                        homeTabText.setForeground(new java.awt.Color(255, 255, 255));
                        homeTabText.setFont(new java.awt.Font("Quicksand", Font.BOLD, 14));
                        homeTabText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        homeTabText.setText("Home");

                        // Home Tab Indicator (JPanel) Decorations.
                            final int homeTabIndicatorHeight = 46;
                            final int homeTabIndicatorWidth = 10;
                            final int homeTabIndicatorLocationX = 2;
                            final int homeTabIndicatorLocationY = 2;

                            homeTabIndicator.setBounds(homeTabIndicatorLocationX, homeTabIndicatorLocationY, homeTabIndicatorWidth, homeTabIndicatorHeight);
                            dBHTab.add(homeTabIndicator);
                            homeTabIndicator.setBackground(new java.awt.Color(255, 208, 0));
                            homeTabIndicator.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
                            homeTabIndicator.setVisible(true);

                // Database Tab (JPanel) Decorations.
                    final int dBDTabX = 3;
                    final int dBDTabY = 114;

                    dBDTab.setBounds(dBDTabX, dBDTabY, dBHTabWidth, dBHTabHeight);
                    navigationBar.add(dBDTab);
                    dBDTab.setBackground(new java.awt.Color(21, 21, 21));
                    dBDTab.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
                    dBDTab.setLayout(null);

                    // Database Tab Text (JLabel) Decorations.      
                    databaseTabText.setBounds(0, 0, navigationTabWidth, navigationTabHeight);
                    dBDTab.add(databaseTabText);
                    databaseTabText.setForeground(new java.awt.Color(255, 255, 255));
                    databaseTabText.setFont(new java.awt.Font("Quicksand", Font.BOLD, 14));
                    databaseTabText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    databaseTabText.setText("Database");

                    // Database Tab Indicator (JPanel) Declarations.
                        final int databaseTabIndicatorHeight = 46;
                        final int databaseTabIndicatorWidth = 10;
                        final int databaseTabIndicatorLocationX = 2;
                        final int databaseTabIndicatorLocationY = 2;

                        // Database Tab Indicator (JPanel) Decorations.
                            databaseTabIndicator.setBounds(databaseTabIndicatorLocationX, databaseTabIndicatorLocationY, databaseTabIndicatorWidth, databaseTabIndicatorHeight);
                            dBDTab.add(databaseTabIndicator);
                            databaseTabIndicator.setBackground(new java.awt.Color(255, 208, 0));
                            databaseTabIndicator.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
                            databaseTabIndicator.setVisible(false);

                // Officer Profile Tab (JPanel) Decorations.
                    final int profileTabX = 3;
                    final int profileTabY = 168;

                    profileTab.setBounds(profileTabX, profileTabY, dBHTabWidth, dBHTabHeight);
                    navigationBar.add(profileTab);
                    profileTab.setBackground(new java.awt.Color(21, 21, 21));
                    profileTab.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
                    profileTab.setLayout(null);

                    // Officer Profile Tab Text (JLabel) Decorations.
                        profileTabText.setBounds(0, 0, navigationTabWidth, navigationTabHeight);
                        profileTab.add(profileTabText);
                        profileTabText.setForeground(new java.awt.Color(255, 255, 255));
                        profileTabText.setFont(new java.awt.Font("Quicksand", Font.BOLD, 14));
                        profileTabText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        profileTabText.setText("Officer Profile");

                        // Officer Profile Tab Indicator (JPanel) Decorations.
                            final int profileTabIndicatorHeight = 46;
                            final int profileTabIndicatorWidth = 10;
                            final int profileTabIndicatorLocationX = 2;
                            final int profileTabIndicatorLocationY = 2;

                            profileTabIndicator.setBounds(profileTabIndicatorLocationX, profileTabIndicatorLocationY, profileTabIndicatorWidth, profileTabIndicatorHeight);
                            profileTab.add(profileTabIndicator);
                            profileTabIndicator.setBackground(new java.awt.Color(255, 208, 0));
                            profileTabIndicator.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
                            profileTabIndicator.setVisible(false);

                // About Software Tab (JPanel) Decorations.

                    final int aboutTabLocationX = 3;
                    final int aboutTabLocationY = 222;

                    aboutTab.setBounds(aboutTabLocationX, aboutTabLocationY, dBHTabWidth, dBHTabHeight);
                    navigationBar.add(aboutTab);
                    aboutTab.setBackground(new java.awt.Color(21, 21, 21));
                    aboutTab.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
                    aboutTab.setLayout(null);

                    // About Software Tab (JText) Decorations.

                        aboutTabText.setBounds(0, 0, navigationTabWidth, navigationTabHeight);
                        aboutTab.add(aboutTabText);
                        aboutTabText.setForeground(new java.awt.Color(255, 255, 255));
                        aboutTabText.setFont(new java.awt.Font("Quicksand", Font.BOLD, 14));
                        aboutTabText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        aboutTabText.setText("About");

                        // About Software Tab Indicator (JPanel) Decorations.

                            final int aboutTabIndicatorLocationX = 2;
                            final int aboutTabIndicatorLocationY = 2;
                            final int aboutTabIndicatorWidth     = 10;
                            final int aboutTabIndicatorHeigth    = 46;

                            aboutTabIndicator.setBounds(aboutTabIndicatorLocationX, aboutTabIndicatorLocationY, aboutTabIndicatorWidth, aboutTabIndicatorHeigth);
                            aboutTab.add(aboutTabIndicator);
                            aboutTabIndicator.setBackground(new java.awt.Color(255, 208, 0));
                            aboutTabIndicator.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
                            aboutTabIndicator.setVisible(false);
                            
           /*
            // User logs.
            
                // User Logs Text Label (JLabel) Decorations.
                
                final int userLogsTextLocationX = 10;
                final int userLogsTextLocationY = 395;
                final int userLogsTextWidth     = 80;
                final int userLogsTextHeight    = 35;
                
                // nBLText (JLabel) Decorations.
                    UserLogsText.setBounds(userLogsTextLocationX, userLogsTextLocationY, userLogsTextWidth, userLogsTextHeight);
                    navigationBar.add(UserLogsText);
                    UserLogsText.setForeground(new java.awt.Color(255, 255, 255));
                    UserLogsText.setFont(new java.awt.Font("Quicksand", Font.BOLD, 14));
                    UserLogsText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    UserLogsText.setIconTextGap(0);
                    UserLogsText.setText("User Logs : ");
            
                // User Logs Input (JTextArea) Decorations.
            
                    final int logInputLocationX = 3;
                    final int logInputLocationY = 420;
                    final int logInputWidth     = 196;
                    final int logInputHeight    = 150;

                    userLogsInput.setBounds(logInputLocationX, logInputLocationY, logInputWidth, logInputHeight);
                    navigationBar.add(userLogsInput);
                    userLogsInput.setForeground(new java.awt.Color(0,0,0));
                    userLogsInput.setCaretColor(new java.awt.Color(0,0,0));
                    userLogsInput.setBackground(new java.awt.Color(237, 242, 244));
                    userLogsInput.setLineWrap(true);
                    userLogsInput.setWrapStyleWord(true);
                    userLogsInput.setFont(new java.awt.Font("Tahoma", 0, 14));
                    userLogsInput.setLayout(null);
                    userLogsInput.setVisible(true);
                    

                        // User Logs Scroll Pane.
                        
                            userLogsScroller.setBounds(logInputLocationX, logInputLocationY, logInputWidth, logInputHeight);
                            navigationBar.add(userLogsScroller);
                            userLogsScroller.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
                            userLogsScroller.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                            userLogsScroller.setViewportBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0,0,0)));
                            userLogsScroller.setAutoscrolls(true);      
                            userLogsScroller.getViewport().add(userLogsInput);
                            */
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="<<< Title Bar Components.">
        // Title Bar (JPanel) Decorations.
            final int titlePanelHeight = 128;
            final int titlePanelWidth = 1000;
            final int titlePanelLocationX = 0;
            final int titlePanelLocationY = 0;

            titleBar.setBounds(titlePanelLocationX, titlePanelLocationY, titlePanelWidth, titlePanelHeight);
            add(titleBar);
            titleBar.setBackground(new java.awt.Color(0, 29, 61));
            titleBar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 200, 0), 2, false));
            titleBar.setLayout(null);

            // Title Bar Frame dragging Declaration.
            titleBar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
                public void mouseDragged(java.awt.event.MouseEvent evt) {
                    // JFRAME DRAGGER
                    int x = evt.getXOnScreen();
                    int y = evt.getYOnScreen();

                    setLocation(x - xMouse, y - yMouse);
                }
            });

            titleBar.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mousePressed(java.awt.event.MouseEvent evt) {
                    // JFRAME DRAGGER PART 2
                    xMouse = evt.getX();
                    yMouse = evt.getY();
                }
            });

            // Title Bar Logo (JLabel) Decorations.
                final int logoHeight = 158;
                final int logoWidth = 158;
                final int logoLocationX = 5;
                final int logoLocationY = 5;

                logo.setBounds(logoLocationX, logoLocationY, logoWidth, logoHeight);
                titleBar.add(logo);
                logo.setForeground(new java.awt.Color(0, 0, 0));
                logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                logo.setLayout(null);

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
                titleBar.add(companyName);
                companyName.setForeground(new java.awt.Color(255, 208, 0));
                companyName.setFont(new java.awt.Font("Iron Shark", Font.PLAIN, 20));

                cNameShadow.setBounds(companyNameLocationX, cNameShadowLocationY, companyNameWidth, companyNameHeight);
                titleBar.add(cNameShadow);
                cNameShadow.setForeground(new java.awt.Color(0, 0, 0));
                cNameShadow.setFont(new java.awt.Font("Iron Shark", Font.PLAIN, 20));

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
                titleBar.add(programName);
                programName.setForeground(new java.awt.Color(255, 255, 255));
                programName.setFont(new java.awt.Font("Gepestev", Font.BOLD, 25));
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
                add(dashBarHome);
                dashBarHome.setBackground(new java.awt.Color(0, 0, 32));
                dashBarHome.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 200, 0), 2, false));
                dashBarHome.setLayout(null);

            // Home Dashbar Name (JLabel) Decorations.
                final int homeTextHeight = 30;
                final int homeTextWidth = 200;
                final int homeTextX = 660;
                final int homeTextY = 548;

                homeText.setBounds(homeTextX, homeTextY, homeTextWidth, homeTextHeight);
                dashBarHome.add(homeText);
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
                dashBarHome.add(dBHBackground);
                dBHBackground.setForeground(new java.awt.Color(0, 0, 0));
                dBHBackground.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                dBHBackground.setLayout(null);

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
                dashbarDatabase.add(databaseText);
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
                add(dashbarDatabase);
                dashbarDatabase.setBackground(new java.awt.Color(0, 0, 32));
                dashbarDatabase.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 200, 0), 2, false));
                dashbarDatabase.setLayout(null);

            // dBDBackground (JLabel) Decorations.
                final int dBDBackgroundHeight = 568;
                final int dBDBackgroundWidth = 795;
                final int dBDBackgroundLocationX = 3;
                final int dBDBackgroundLocationY = 3;

                dBDBackground.setBounds(dBDBackgroundLocationX, dBDBackgroundLocationY, dBDBackgroundWidth, dBDBackgroundHeight);
                dashbarDatabase.add(dBDBackground);
                dBDBackground.setForeground(new java.awt.Color(0, 0, 0));
                dBDBackground.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                dBDBackground.setLayout(null);

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
                dashbarProfile.add(officerProfileText);
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
                add(dashbarProfile);
                dashbarProfile.setBackground(new java.awt.Color(0, 0, 50));
                dashbarProfile.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 200, 0), 2, false));
                dashbarProfile.setLayout(null);
                dashbarProfile.setVisible(false);

            // dOPBackground (JLAbel) Decorations.
                final int dOPBackgroundHeight = 568;
                final int dOPBackgroundWidth = 795;
                final int dOPBackgroundLocationX = 3;
                final int dOPBackgroundLocationY = 3;

                dOPBackground.setBounds(dOPBackgroundLocationX, dOPBackgroundLocationY, dOPBackgroundWidth, dOPBackgroundHeight);
                dashbarProfile.add(dOPBackground);
                dOPBackground.setForeground(new java.awt.Color(0, 0, 0));
                dOPBackground.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                dOPBackground.setLayout(null);

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
                dashbarAbout.add(aboutDashBarText);
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
                add(dashbarAbout);
                dashbarAbout.setBackground(new java.awt.Color(0, 0, 50));
                dashbarAbout.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 200, 0), 2, false));
                dashbarAbout.setLayout(null);
                dashbarAbout.setVisible(false);

            // DashBar AboutBackground (JLAbel) Decorations.
                final int aboutBackgroundHeight = 568;
                final int aboutBackgroundWidth = 795;
                final int aboutBackgroundLocationX = 3;
                final int aboutBackgroundLocationY = 3;

                aboutBackground.setBounds(aboutBackgroundLocationX, aboutBackgroundLocationY, aboutBackgroundWidth, aboutBackgroundHeight);
                dashbarAbout.add(aboutBackground);
                aboutBackground.setForeground(new java.awt.Color(0, 0, 0));
                aboutBackground.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                aboutBackground.setLayout(null);

                ImageIcon icon4 = new ImageIcon("src\\PRMS Files\\backgrounds\\carbonbackground.jpg");
                Image getAboutBackground = icon4.getImage();
                Image imgScale4 = getAboutBackground.getScaledInstance(aboutBackground.getWidth(), aboutBackground.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon scaledIcon4 = new ImageIcon(imgScale4);
                aboutBackground.setIcon(scaledIcon4);


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
        
        // Minimize Button.
        final int minimizeButtonLocationX = 966;
        final int minimizeButtonLocationY = 10;
        final int minimizeButtonWidth     = 24;
        final int minimizeButtonHeight    = 24;
        
        titleBar.add(minimize);
        minimize.setBounds(minimizeButtonLocationX, minimizeButtonLocationY, minimizeButtonWidth, minimizeButtonHeight);
        minimize.setForeground(new java.awt.Color(0,0,0));
        minimize.setBackground(new java.awt.Color(248, 249, 250));
        minimize.setFont(new java.awt.Font("Quicksand", Font.PLAIN, 16));
        minimize.setBorder(null);
        minimize.setFocusPainted(false);
        minimize.setHorizontalAlignment(SwingConstants.CENTER);
        minimize.setOpaque(false);
        minimize.setVisible(true);
        minimize.setContentAreaFilled(false);
        minimize.setBorderPainted(false);
        minimize.setIconTextGap(0);
        
        ImageIcon minimizeIcon = new ImageIcon("src\\PRMS Files\\icons\\DehoveredMinimize.png");
        Image importMinimizeIcon = minimizeIcon.getImage();
        ImageIcon GetMinimizeIcon = new ImageIcon(importMinimizeIcon);
        minimize.setIcon(GetMinimizeIcon);
        
        ImageIcon minimizeSelectedIcon = new ImageIcon("src\\PRMS Files\\icons\\HoveredMinimize.png");
        Image importMinimizeSelectedIcon = minimizeSelectedIcon.getImage();
        ImageIcon GetMinimizeSelectedIcon = new ImageIcon(importMinimizeSelectedIcon);
        minimize.setSelectedIcon(GetMinimizeSelectedIcon);
        
        ImageIcon minimizeRolloverIcon = new ImageIcon("src\\PRMS Files\\icons\\Clicked Minimize.png");
        Image importMinimizeRolloverIcon = minimizeRolloverIcon.getImage();
        ImageIcon GetMinimizeRolloverIcon = new ImageIcon(importMinimizeRolloverIcon);
        minimize.setRolloverIcon(GetMinimizeRolloverIcon);
        
        // Minimize Function 
        minimize.addActionListener((java.awt.event.ActionEvent evt) -> {
            setState(PRMSLogin.ICONIFIED);
            });

        pack();
        setLocationRelativeTo(null);
    }
    
    // CLASS FUNCTIONS //
    
    private void SetComponentLookAndFeel(){
       
       try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
           e.printStackTrace();
        }/*/ /*/
       
        
    }
    
    public static void main(String[] args) {

        PRMSMainWindow Open = new PRMSMainWindow();
        Open.setVisible(true);
    }
}