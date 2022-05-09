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
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.JTextField;

import static PRMSClasses.PRMSLogin.minimize;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;

public class PRMSMainWindow extends JFrame {

    JPanel navigationBar, navigationBarLabel, dBHTab, homeTabIndicator, dBDTab, databaseTabIndicator, profileTab, profileTabIndicator, aboutTab, aboutTabIndicator,
            titleBar,
            dashBarHome, dashbarDatabase, dashbarProfile, dashbarAbout;

    public static JLabel ProfilePicture;
    JLabel nBLText, homeTabText, databaseTabText, profileTabText, aboutTabText,
            logo, companyName, cNameShadow, programName,
            dBHBackground, homeText, databaseText, dBDBackground, officerProfileText, dOPBackground, aboutDashBarText, aboutBackground,
            Welcome,
            PersonIDLabel, AgeLabel, GenderLabel, HomeAddressLabel, ProvinceOfOriginLabel, DateOfArrestLabel, DateOfReleaseLabel, ReasonOfApprehensionLabel, MugShot,
            RecordsLabel, SearchLabel,
            ProfileAgeLabel, ProfileHomeAddressLabel, ProfileContactLabel, ProfileStationLabel, ProfileRankLabel, ProfileUsernameLabel,
            AboutCompanyLogo, AboutCompanyName, AboutProgramName, AboutDevelopmentTeamLabel,
            FirstYearDevelopers, CC3SubProf, FirstYearLeadD, FirstYearCOD, FirstYearAD,
            SecondYearDevelopers, ComProg3Prof, SecondYearLeadD, SecondYearCOD, FirstYearDevTimeline, SecondYearDevTimeline;

    JTable PoliceRecords;
    JScrollPane PoliceRecordsScrollBar;
    JTextField IDField, NameField, AgeField, GenderField, HomeAddressField, ProvinceOfOriginField, DateOfArrestField, DateOfReleaseField, ReasonOfApprehensionField, SearchBar;
    public static JTextField ProfileNameField, ProfileAgeField, ProfileHomeAddressField, ProfileContactField, ProfileStationField, ProfileRankField, ProfileUsernameField;

    JButton RefreshList, PrintRecord, ClearRecordFields, ResetListFields, AddRecord, DeleteRecord,
            LogOut;
    
    Font IronShark, Quicksand, Gepestev;

    // FRAME DRAGGER
    int xMouse;
    int yMouse;

    public PRMSMainWindow() {

        SetComponentLookAndFeel();

        PoliceMobileComponents();

        GetDataFromDatabase();

    }

    private void PoliceMobileComponents() {

        // <editor-fold defaultstate="collapsed" desc="<<< JFrame Container.">
        // JFrame Declaration
        final int FrameSizeX = 1000;
        final int FrameSizeY = 700;

        //JFrame Size.
        setSize(FrameSizeX, FrameSizeY);
        setMinimumSize(new Dimension(FrameSizeX, FrameSizeY));
        setPreferredSize(new Dimension(FrameSizeX, FrameSizeY));

        //JFrame Decoration.
        setUndecorated(true);
        setOpacity(1.0f);
        setTitle("PRMS : Police Database");
        setLayout(null);
        setResizable(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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

        Welcome = new JLabel();

        dashbarDatabase = new JPanel();

        PersonIDLabel = new JLabel();
        AgeLabel = new JLabel();
        GenderLabel = new JLabel();
        HomeAddressLabel = new JLabel();
        ProvinceOfOriginLabel = new JLabel();
        DateOfArrestLabel = new JLabel();
        DateOfReleaseLabel = new JLabel();
        ReasonOfApprehensionLabel = new JLabel();
        MugShot = new JLabel();
        RecordsLabel = new JLabel();
        SearchLabel = new JLabel();

        IDField = new JTextField();
        NameField = new JTextField();
        AgeField = new JTextField();
        GenderField = new JTextField();
        HomeAddressField = new JTextField();
        ProvinceOfOriginField = new JTextField();
        DateOfArrestField = new JTextField();
        DateOfReleaseField = new JTextField();
        ReasonOfApprehensionField = new JTextField();

        PoliceRecords = new JTable() {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };

        PoliceRecordsScrollBar = new JScrollPane();
        SearchBar = new JTextField();

        RefreshList = new JButton();
        PrintRecord = new JButton();
        ResetListFields = new JButton();
        DeleteRecord = new JButton();
        AddRecord = new JButton();

        dashbarProfile = new JPanel();

        ProfilePicture = new JLabel();
        ProfileAgeLabel = new JLabel();
        ProfileHomeAddressLabel = new JLabel();
        ProfileStationLabel = new JLabel();
        ProfileRankLabel = new JLabel();
        ProfileUsernameLabel = new JLabel();
        ProfileContactLabel = new JLabel();

        ProfileNameField = new JTextField();
        ProfileAgeField = new JTextField();
        ProfileHomeAddressField = new JTextField();
        ProfileStationField = new JTextField();
        ProfileRankField = new JTextField();
        ProfileUsernameField = new JTextField();
        ProfileContactField = new JTextField();

        LogOut = new JButton();

        dashbarAbout = new JPanel();

        AboutCompanyLogo = new JLabel();
        AboutCompanyName = new JLabel();
        AboutProgramName = new JLabel();
        AboutDevelopmentTeamLabel = new JLabel();
        FirstYearDevelopers = new JLabel();
        CC3SubProf = new JLabel();
        FirstYearLeadD = new JLabel();
        FirstYearCOD = new JLabel();
        FirstYearAD = new JLabel();
        SecondYearDevelopers = new JLabel();
        ComProg3Prof = new JLabel();
        SecondYearLeadD = new JLabel();
        SecondYearCOD = new JLabel();
        FirstYearDevTimeline = new JLabel();
        SecondYearDevTimeline = new JLabel();

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
        navigationBar.setBackground(new Color(10, 10, 10));
        navigationBar.setBorder(new javax.swing.border.LineBorder(new Color(255, 200, 0), 2, false));
        navigationBar.setLayout(null);

        // Navigation Bar Label (JPanel) Decorations.
        final int navigationTabHeight = 50;
        final int navigationTabWidth = 190;
        final int navigationTabLocationX = 6;
        final int navigationTabLocationY = 6;

        navigationBarLabel.setBounds(navigationTabLocationX, navigationTabLocationY, navigationTabWidth, navigationTabHeight);
        navigationBar.add(navigationBarLabel);
        navigationBarLabel.setBackground(new Color(0, 29, 61));
        navigationBarLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.SoftBevelBorder.RAISED));
        navigationBarLabel.setLayout(null);

        // nBLText (JLabel) Decorations.
        nBLText.setBounds(0, 0, navigationTabWidth, navigationTabHeight);
        navigationBarLabel.add(nBLText);
        nBLText.setForeground(new Color(255, 255, 255));
        nBLText.setFont(new Font("Quicksand", Font.BOLD, 14));
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
        dBHTab.setBackground(new Color(21, 21, 21));
        dBHTab.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        dBHTab.setLayout(null);

        // Home Tab Text(JLabel) Decorations.
        homeTabText.setBounds(0, 0, navigationTabWidth, navigationTabHeight);
        dBHTab.add(homeTabText);
        homeTabText.setForeground(new Color(255, 255, 255));
        homeTabText.setFont(new Font("Quicksand", Font.BOLD, 14));
        homeTabText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        homeTabText.setText("Home");

        // Home Tab Indicator (JPanel) Decorations.
        final int homeTabIndicatorHeight = 46;
        final int homeTabIndicatorWidth = 10;
        final int homeTabIndicatorLocationX = 2;
        final int homeTabIndicatorLocationY = 2;

        homeTabIndicator.setBounds(homeTabIndicatorLocationX, homeTabIndicatorLocationY, homeTabIndicatorWidth, homeTabIndicatorHeight);
        dBHTab.add(homeTabIndicator);
        homeTabIndicator.setBackground(new Color(255, 208, 0));
        homeTabIndicator.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        homeTabIndicator.setVisible(true);

        // Database Tab (JPanel) Decorations.
        final int dBDTabX = 3;
        final int dBDTabY = 114;

        dBDTab.setBounds(dBDTabX, dBDTabY, dBHTabWidth, dBHTabHeight);
        navigationBar.add(dBDTab);
        dBDTab.setBackground(new Color(21, 21, 21));
        dBDTab.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        dBDTab.setLayout(null);

        // Database Tab Text (JLabel) Decorations.      
        databaseTabText.setBounds(0, 0, navigationTabWidth, navigationTabHeight);
        dBDTab.add(databaseTabText);
        databaseTabText.setForeground(new Color(255, 255, 255));
        databaseTabText.setFont(new Font("Quicksand", Font.BOLD, 14));
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
        databaseTabIndicator.setBackground(new Color(255, 208, 0));
        databaseTabIndicator.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        databaseTabIndicator.setVisible(false);

        // Officer Profile Tab (JPanel) Decorations.
        final int profileTabX = 3;
        final int profileTabY = 168;

        profileTab.setBounds(profileTabX, profileTabY, dBHTabWidth, dBHTabHeight);
        navigationBar.add(profileTab);
        profileTab.setBackground(new Color(21, 21, 21));
        profileTab.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        profileTab.setLayout(null);

        // Officer Profile Tab Text (JLabel) Decorations.
        profileTabText.setBounds(0, 0, navigationTabWidth, navigationTabHeight);
        profileTab.add(profileTabText);
        profileTabText.setForeground(new Color(255, 255, 255));
        profileTabText.setFont(new Font("Quicksand", Font.BOLD, 14));
        profileTabText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        profileTabText.setText("Officer Profile");

        // Officer Profile Tab Indicator (JPanel) Decorations.
        final int profileTabIndicatorHeight = 46;
        final int profileTabIndicatorWidth = 10;
        final int profileTabIndicatorLocationX = 2;
        final int profileTabIndicatorLocationY = 2;

        profileTabIndicator.setBounds(profileTabIndicatorLocationX, profileTabIndicatorLocationY, profileTabIndicatorWidth, profileTabIndicatorHeight);
        profileTab.add(profileTabIndicator);
        profileTabIndicator.setBackground(new Color(255, 208, 0));
        profileTabIndicator.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        profileTabIndicator.setVisible(false);

        // About Software Tab (JPanel) Decorations.
        final int aboutTabLocationX = 3;
        final int aboutTabLocationY = 222;

        aboutTab.setBounds(aboutTabLocationX, aboutTabLocationY, dBHTabWidth, dBHTabHeight);
        navigationBar.add(aboutTab);
        aboutTab.setBackground(new Color(21, 21, 21));
        aboutTab.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        aboutTab.setLayout(null);

        // About Software Tab (JText) Decorations.
        aboutTabText.setBounds(0, 0, navigationTabWidth, navigationTabHeight);
        aboutTab.add(aboutTabText);
        aboutTabText.setForeground(new Color(255, 255, 255));
        aboutTabText.setFont(new Font("Quicksand", Font.BOLD, 14));
        aboutTabText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        aboutTabText.setText("About");

        // About Software Tab Indicator (JPanel) Decorations.
        final int aboutTabIndicatorLocationX = 2;
        final int aboutTabIndicatorLocationY = 2;
        final int aboutTabIndicatorWidth = 10;
        final int aboutTabIndicatorHeigth = 46;

        aboutTabIndicator.setBounds(aboutTabIndicatorLocationX, aboutTabIndicatorLocationY, aboutTabIndicatorWidth, aboutTabIndicatorHeigth);
        aboutTab.add(aboutTabIndicator);
        aboutTabIndicator.setBackground(new Color(255, 208, 0));
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
        add(titleBar);
        titleBar.setBackground(new Color(0, 29, 61));
        titleBar.setBorder(new javax.swing.border.LineBorder(new Color(255, 200, 0), 2, false));
        titleBar.setLayout(null);

        // Title Bar Frame dragging Declaration.
        titleBar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            @Override
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                // JFRAME DRAGGER
                int x = evt.getXOnScreen();
                int y = evt.getYOnScreen();

                setLocation(x - xMouse, y - yMouse);
            }
        });

        titleBar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
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
        logo.setForeground(new Color(0, 0, 0));
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
        companyName.setForeground(new Color(255, 208, 0));
        companyName.setFont(new Font("Iron Shark", Font.PLAIN, 20));

        cNameShadow.setBounds(companyNameLocationX, cNameShadowLocationY, companyNameWidth, companyNameHeight);
        titleBar.add(cNameShadow);
        cNameShadow.setForeground(new Color(0, 0, 0));
        cNameShadow.setFont(new Font("Iron Shark", Font.PLAIN, 20));

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
        programName.setForeground(new Color(255, 255, 255));
        programName.setFont(new Font("Gepestev", Font.BOLD, 25));
        programName.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        programName.setText("POLICE RECORD MANAGEMENT SYSTEM");
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
        dashBarHome.setBackground(new Color(0, 0, 32));
        dashBarHome.setBorder(new javax.swing.border.LineBorder(new Color(255, 200, 0), 2, false));
        dashBarHome.setLayout(null);

        // Dasbar Home Welcome Label (JLabel) Decorations. 
        final int WelcomeLabelLocationX = 210;
        final int WelcomeLabelLocationY = 100;
        final int WelcomeLabelWidth = 500;
        final int WelcomeLabelHeight = 80;

        dashBarHome.add(Welcome);
        Welcome.setBounds(WelcomeLabelLocationX, WelcomeLabelLocationY, WelcomeLabelWidth, WelcomeLabelHeight);
        Welcome.setForeground(new Color(255, 255, 255));
        Welcome.setHorizontalAlignment(SwingConstants.LEADING);
        Welcome.setFont(new Font("Tahoma", Font.BOLD, 80));
        Welcome.setText("WELCOME");
        Welcome.setVisible(true);

        //Dashbar Home Welcome Label Shadow (JLabel) Declaration and Decorations.
        JLabel WelcomeShadow = new JLabel();

        final int ShadowLabelLocationX = 210;
        final int ShadowLabelLocationY = 105;
        final int ShadowLabelWidth = 500;
        final int ShadowLabelHeight = 80;

        dashBarHome.add(WelcomeShadow);
        WelcomeShadow.setBounds(ShadowLabelLocationX, ShadowLabelLocationY, ShadowLabelWidth, ShadowLabelHeight);
        WelcomeShadow.setForeground(new Color(0, 0, 50));
        WelcomeShadow.setFont(new Font("Tahoma", Font.BOLD, 80));
        WelcomeShadow.setText("WELCOME");
        WelcomeShadow.setVisible(true);

        // Home Dashbar Name (JLabel) Decorations.
        final int homeTextHeight = 30;
        final int homeTextWidth = 200;
        final int homeTextX = 660;
        final int homeTextY = 548;

        homeText.setBounds(homeTextX, homeTextY, homeTextWidth, homeTextHeight);
        dashBarHome.add(homeText);
        homeText.setForeground(new Color(255, 255, 255));
        homeText.setFont(new Font("Impact", Font.PLAIN, 14));
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
        dBHBackground.setForeground(new Color(0, 0, 0));
        dBHBackground.setHorizontalAlignment(SwingConstants.CENTER);
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
        databaseText.setForeground(new Color(255, 255, 255));
        databaseText.setFont(new Font("Impact", Font.PLAIN, 14));
        databaseText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        databaseText.setText("DATABASE");
        databaseText.setVisible(true);

        // Database Dashbar Components.
        // Person's Name (JTextField) Decorations.
        final int NameFieldLocationX = 50;
        final int NameFieldLocationY = 30;
        final int NameFieldWidth = 700;
        final int NameFieldHeight = 35;

        dashbarDatabase.add(NameField);
        NameField.setBounds(NameFieldLocationX, NameFieldLocationY, NameFieldWidth, NameFieldHeight);
        NameField.setBackground(new Color(0, 0, 0, 0));
        NameField.setForeground(new Color(255, 255, 255));
        NameField.setHorizontalAlignment(SwingConstants.CENTER);
        NameField.setEditable(false);
        NameField.setText("- REPORT SHEET -");
        NameField.setOpaque(false);
        NameField.setCaretColor(new Color(237, 242, 244));
        NameField.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(237, 242, 244)));
        NameField.setFont(new Font("Quicksand", Font.BOLD, 26));
        NameField.setVisible(true);

        // Person's Age  (JLabel) Decorations.
        final int AgeLabelLocationX = 300;
        final int AgeLabelLocationY = 80;
        final int AgeLabelWidth = 130;
        final int AgeLabelHeight = 35;

        dashbarDatabase.add(AgeLabel);
        AgeLabel.setBounds(AgeLabelLocationX, AgeLabelLocationY, AgeLabelWidth, AgeLabelHeight);
        AgeLabel.setForeground(new Color(255, 255, 255));
        AgeLabel.setFont(new Font("Quicksand", Font.PLAIN, 16));
        AgeLabel.setText("Age :");
        AgeLabel.setVisible(true);

        // Person's Age Field (JTextField) Decorations.
        final int AgeFieldLocationX = 340;
        final int AgeFieldLocationY = 80;
        final int AgeFieldWidth = 27;
        final int AgeFieldHeight = 35;

        dashbarDatabase.add(AgeField);
        AgeField.setBounds(AgeFieldLocationX, AgeFieldLocationY, AgeFieldWidth, AgeFieldHeight);
        AgeField.setBackground(new Color(0, 0, 0, 0));
        AgeField.setForeground(new Color(255, 255, 255));
        AgeField.setEditable(false);
        AgeField.setOpaque(false);
        AgeField.setCaretColor(new Color(237, 242, 244));
        AgeField.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(237, 242, 244)));
        AgeField.setFont(new Font("Quicksand", Font.PLAIN, 16));
        AgeField.setVisible(true);

        // Person's Gender (JLabel) Decorations.
        final int GenderLabelLocationX = 50;
        final int GenderLabelLocationY = 80;
        final int GenderLabelWidth = 130;
        final int GenderLabelHeight = 35;

        dashbarDatabase.add(GenderLabel);
        GenderLabel.setBounds(GenderLabelLocationX, GenderLabelLocationY, GenderLabelWidth, GenderLabelHeight);
        GenderLabel.setForeground(new Color(255, 255, 255));
        GenderLabel.setFont(new Font("Quicksand", Font.PLAIN, 16));
        GenderLabel.setText("Gender :");
        GenderLabel.setVisible(true);

        // Person's Gender Field (JTextField) Decorations.
        final int GenderFieldLocationX = 115;
        final int GenderFieldLocationY = 80;
        final int GenderFieldWidth = 150;
        final int GenderFieldHeight = 35;

        dashbarDatabase.add(GenderField);
        GenderField.setBounds(GenderFieldLocationX, GenderFieldLocationY, GenderFieldWidth, GenderFieldHeight);
        GenderField.setBackground(new Color(0, 0, 0, 0));
        GenderField.setForeground(new Color(255, 255, 255));
        GenderField.setEditable(false);
        GenderField.setOpaque(false);
        GenderField.setCaretColor(new Color(237, 242, 244));
        GenderField.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(237, 242, 244)));
        GenderField.setFont(new Font("Quicksand", Font.PLAIN, 16));
        GenderField.setVisible(true);

        // Person's Home Address (JLabel) Decorations.
        final int HomeAddressLabelLocationX = 50;
        final int HomeAddressLabelLocationY = 110;
        final int HomeAddressLabelWidth = 130;
        final int HomeAddressLabelHeight = 35;

        dashbarDatabase.add(HomeAddressLabel);
        HomeAddressLabel.setBounds(HomeAddressLabelLocationX, HomeAddressLabelLocationY, HomeAddressLabelWidth, HomeAddressLabelHeight);
        HomeAddressLabel.setForeground(new Color(255, 255, 255));
        HomeAddressLabel.setFont(new Font("Quicksand", Font.PLAIN, 16));
        HomeAddressLabel.setText("Home Address :");
        HomeAddressLabel.setVisible(true);

        // Person's Home Address Field (JTextField) Decorations.
        final int HomeAddressFieldLocationX = 175;
        final int HomeAddressFieldLocationY = 110;
        final int HomeAddressFieldWidth = 365;
        final int HomeAddressFieldHeight = 35;

        dashbarDatabase.add(HomeAddressField);
        HomeAddressField.setBounds(HomeAddressFieldLocationX, HomeAddressFieldLocationY, HomeAddressFieldWidth, HomeAddressFieldHeight);
        HomeAddressField.setBackground(new Color(0, 0, 0, 0));
        HomeAddressField.setForeground(new Color(255, 255, 255));
        HomeAddressField.setEditable(false);
        HomeAddressField.setOpaque(false);
        HomeAddressField.setCaretColor(new Color(237, 242, 244));
        HomeAddressField.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(237, 242, 244)));
        HomeAddressField.setFont(new Font("Quicksand", Font.PLAIN, 16));
        HomeAddressField.setVisible(true);

        // Person's Province of Origin (JLabel) Decorations.
        final int OriginLabelLocationX = 50;
        final int OriginLabelLocationY = 140;
        final int OriginLabelWidth = 200;
        final int OriginLabelHeight = 35;

        dashbarDatabase.add(ProvinceOfOriginLabel);
        ProvinceOfOriginLabel.setBounds(OriginLabelLocationX, OriginLabelLocationY, OriginLabelWidth, OriginLabelHeight);
        ProvinceOfOriginLabel.setForeground(new Color(255, 255, 255));
        ProvinceOfOriginLabel.setFont(new Font("Quicksand", Font.PLAIN, 16));
        ProvinceOfOriginLabel.setText("Province of Origin :");
        ProvinceOfOriginLabel.setVisible(true);

        // Person's Province of Origin Field (JTextField) Decorations.
        final int OriginFieldLocationX = 190;
        final int OriginFieldLocationY = 140;
        final int OriginFieldWidth = 350;
        final int OriginFieldHeight = 35;

        dashbarDatabase.add(ProvinceOfOriginField);
        ProvinceOfOriginField.setBounds(OriginFieldLocationX, OriginFieldLocationY, OriginFieldWidth, OriginFieldHeight);
        ProvinceOfOriginField.setBackground(new Color(0, 0, 0, 0));
        ProvinceOfOriginField.setForeground(new Color(255, 255, 255));
        ProvinceOfOriginField.setEditable(false);
        ProvinceOfOriginField.setOpaque(false);
        ProvinceOfOriginField.setCaretColor(new Color(237, 242, 244));
        ProvinceOfOriginField.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(237, 242, 244)));
        ProvinceOfOriginField.setFont(new Font("Quicksand", Font.PLAIN, 16));
        ProvinceOfOriginField.setVisible(true);

        // Person's Date of Arrest (JLabel) Decorations.
        final int DOALabelLocationX = 50;
        final int DOALabelLocationY = 170;
        final int DOALabelWidth = 130;
        final int DOALabelHeight = 35;

        dashbarDatabase.add(DateOfArrestLabel);
        DateOfArrestLabel.setBounds(DOALabelLocationX, DOALabelLocationY, DOALabelWidth, DOALabelHeight);
        DateOfArrestLabel.setForeground(new Color(255, 255, 255));
        DateOfArrestLabel.setFont(new Font("Quicksand", Font.PLAIN, 16));
        DateOfArrestLabel.setText("Date Arrested :");
        DateOfArrestLabel.setVisible(true);

        // Person's Date of Arrest Field (JTextField) Decorations.
        final int DOAFieldLocationX = 165;
        final int DOAFieldLocationY = 170;
        final int DOAFieldWidth = 125;
        final int DOAFieldHeight = 35;

        dashbarDatabase.add(DateOfArrestField);
        DateOfArrestField.setBounds(DOAFieldLocationX, DOAFieldLocationY, DOAFieldWidth, DOAFieldHeight);
        DateOfArrestField.setBackground(new Color(0, 0, 0, 0));
        DateOfArrestField.setForeground(new Color(255, 255, 255));
        DateOfArrestField.setEditable(false);
        DateOfArrestField.setOpaque(false);
        DateOfArrestField.setCaretColor(new Color(237, 242, 244));
        DateOfArrestField.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(237, 242, 244)));
        DateOfArrestField.setFont(new Font("Quicksand", Font.PLAIN, 16));
        DateOfArrestField.setVisible(true);

        // Person's Date of Release (JLabel) Decorations.
        final int DORLabelLocationX = 300;
        final int DORLabelLocationY = 170;
        final int DORLabelWidth = 130;
        final int DORLabelHeight = 35;

        dashbarDatabase.add(DateOfReleaseLabel);
        DateOfReleaseLabel.setBounds(DORLabelLocationX, DORLabelLocationY, DORLabelWidth, DORLabelHeight);
        DateOfReleaseLabel.setForeground(new Color(255, 255, 255));
        DateOfReleaseLabel.setFont(new Font("Quicksand", Font.PLAIN, 16));
        DateOfReleaseLabel.setText("Release Date :");
        DateOfReleaseLabel.setVisible(true);

        // Person's Date of Release Field (JTextField) Decorations.
        final int DORFieldLocationX = 415;
        final int DORFieldLocationY = 170;
        final int DORFieldWidth = 125;
        final int DORFieldHeight = 35;

        dashbarDatabase.add(DateOfReleaseField);
        DateOfReleaseField.setBounds(DORFieldLocationX, DORFieldLocationY, DORFieldWidth, DORFieldHeight);
        DateOfReleaseField.setBackground(new Color(0, 0, 0, 0));
        DateOfReleaseField.setForeground(new Color(255, 255, 255));
        DateOfReleaseField.setEditable(false);
        DateOfReleaseField.setOpaque(false);
        DateOfReleaseField.setCaretColor(new Color(237, 242, 244));
        DateOfReleaseField.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(237, 242, 244)));
        DateOfReleaseField.setFont(new Font("Quicksand", Font.PLAIN, 16));
        DateOfReleaseField.setVisible(true);

        // Person's Reason of Apprehension (JLabel) Decorations.
        final int ReasonLabelLocationX = 50;
        final int ReasonLabelLocationY = 200;
        final int ReasonLabelWidth = 200;
        final int ReasonLabelHeight = 35;

        dashbarDatabase.add(ReasonOfApprehensionLabel);
        ReasonOfApprehensionLabel.setBounds(ReasonLabelLocationX, ReasonLabelLocationY, ReasonLabelWidth, ReasonLabelHeight);
        ReasonOfApprehensionLabel.setForeground(new Color(255, 255, 255));
        ReasonOfApprehensionLabel.setFont(new Font("Quicksand", Font.PLAIN, 16));
        ReasonOfApprehensionLabel.setText("Reason of Apprehension :");
        ReasonOfApprehensionLabel.setVisible(true);

        // Person's Reason of Apprehension Field (JTextField) Decorations.
        final int ROAFieldLocationX = 250;
        final int ROAFieldLocationY = 200;
        final int ROAFieldWidth = 290;
        final int ROAFieldHeight = 35;

        dashbarDatabase.add(ReasonOfApprehensionField);
        ReasonOfApprehensionField.setBounds(ROAFieldLocationX, ROAFieldLocationY, ROAFieldWidth, ROAFieldHeight);
        ReasonOfApprehensionField.setBackground(new Color(0, 0, 0, 0));
        ReasonOfApprehensionField.setForeground(new Color(255, 255, 255));
        ReasonOfApprehensionField.setEditable(false);
        ReasonOfApprehensionField.setOpaque(false);
        ReasonOfApprehensionField.setCaretColor(new Color(237, 242, 244));
        ReasonOfApprehensionField.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(237, 242, 244)));
        ReasonOfApprehensionField.setFont(new Font("Quicksand", Font.PLAIN, 16));
        ReasonOfApprehensionField.setVisible(true);

        // Person's Mug shot (JLabel) Decorations.
        final int MugshotLocationX = 575;
        final int MugshotLocationY = 85;
        final int MugshotWidth = 180;
        final int MugshotHeight = 180;

        dashbarDatabase.add(MugShot);
        MugShot.setBounds(MugshotLocationX, MugshotLocationY, MugshotWidth, MugshotHeight);
        MugShot.setBackground(new Color(237, 242, 244));
        MugShot.setOpaque(true);
        MugShot.setHorizontalAlignment(SwingConstants.CENTER);
        MugShot.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(255, 208, 0)));
        MugShot.setLayout(null);
        MugShot.setVisible(true);

        ImageIcon findMugshot = new ImageIcon("src\\PRMS Files\\icons\\Mugshot180x.png");
        Image importMugshot = findMugshot.getImage();
        Image scaleMugshot = importMugshot.getScaledInstance(MugShot.getWidth(), MugShot.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledMugshot = new ImageIcon(scaleMugshot);
        MugShot.setIcon(scaledMugshot);

        // Records Label (JLabel) Decorations.
        final int RecordsLabelLocationX = 370;
        final int RecordsLabelLocationY = 260;
        final int RecordsLabelWidth = 130;
        final int RecordsLabelHeight = 35;

        dashbarDatabase.add(RecordsLabel);
        RecordsLabel.setBounds(RecordsLabelLocationX, RecordsLabelLocationY, RecordsLabelWidth, RecordsLabelHeight);
        RecordsLabel.setForeground(new Color(255, 255, 255));
        RecordsLabel.setFont(new Font("Quicksand", Font.PLAIN, 16));
        RecordsLabel.setText("RECORDS");
        RecordsLabel.setVisible(true);

        // List of Records (JTable) Decorations.
        final int RecordsListLocationX = 0;
        final int RecordsListLocationY = 290;
        final int RecordsListWidth = 800;
        final int RecordsListHeight = 220;

        dashbarDatabase.add(PoliceRecords);
        PoliceRecords.setBounds(RecordsListLocationX, RecordsListLocationY, RecordsListWidth, RecordsListHeight);
        PoliceRecords.setForeground(new Color(0, 0, 0));
        PoliceRecords.setBackground(new Color(237, 242, 244));
        PoliceRecords.setFont(new Font("Tahoma", 0, 14));
        PoliceRecords.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        PoliceRecords.enableInputMethods(false);
        PoliceRecords.setLayout(null);
        PoliceRecords.setVisible(true);

        PoliceRecords.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PoliceRecordsFunction(evt);
            }
        });

        // List of Records (JScrollpane) Decorations.
        dashbarDatabase.add(PoliceRecordsScrollBar);
        PoliceRecordsScrollBar.setBounds(RecordsListLocationX, RecordsListLocationY, RecordsListWidth, RecordsListHeight);
        PoliceRecordsScrollBar.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        PoliceRecordsScrollBar.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        PoliceRecordsScrollBar.setViewportBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
        PoliceRecordsScrollBar.setAutoscrolls(true);
        PoliceRecordsScrollBar.setEnabled(true);
        PoliceRecordsScrollBar.setWheelScrollingEnabled(true);
        PoliceRecordsScrollBar.setFocusable(true);
        PoliceRecordsScrollBar.getViewport().add(PoliceRecords);

        // Search Records (JLabel) Decorations.
        final int SearchLabelLocationX = 50;
        final int SearchLabelLocationY = 515;
        final int SearchLabelWidth = 130;
        final int SearchLabelHeight = 35;

        dashbarDatabase.add(SearchLabel);
        SearchLabel.setBounds(SearchLabelLocationX, SearchLabelLocationY, SearchLabelWidth, SearchLabelHeight);
        SearchLabel.setForeground(new Color(255, 255, 255));
        SearchLabel.setFont(new Font("Quicksand", Font.PLAIN, 16));
        SearchLabel.setText("Search :");
        SearchLabel.setVisible(true);

        // Search Bar (JTextField) Decorations.
        final int SearchBarLocationX = 120;
        final int SearchBarLocationY = 515;
        final int SearchBarWidth = 225;
        final int SearchBarHeight = 35;

        dashbarDatabase.add(SearchBar);
        SearchBar.setBounds(SearchBarLocationX, SearchBarLocationY, SearchBarWidth, SearchBarHeight);
        SearchBar.setBackground(new Color(0, 0, 0, 0));
        SearchBar.setForeground(new Color(237, 242, 244));
        SearchBar.setOpaque(false);
        SearchBar.setCaretColor(new Color(237, 242, 244));
        SearchBar.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(237, 242, 244)));
        SearchBar.setFont(new Font("Quicksand", Font.PLAIN, 14));
        SearchBar.setVisible(true);

        SearchBar.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchBarKeyPressed(evt);
            }
        });

        // Refresh Button (JButton) Decorations.
        final int RefreshButtonLocationX = 360;
        final int RefreshButtonLocationY = 515;
        final int RefreshButtonWidth = 90;
        final int RefreshButtonHeight = 35;

        dashbarDatabase.add(RefreshList);
        RefreshList.setBounds(RefreshButtonLocationX, RefreshButtonLocationY, RefreshButtonWidth, RefreshButtonHeight);
        RefreshList.setBackground(new Color(248, 249, 250));
        RefreshList.setFont(new Font("Quicksand", Font.PLAIN, 16));
        RefreshList.setFocusPainted(false);
        RefreshList.setHorizontalAlignment(SwingConstants.CENTER);
        RefreshList.setOpaque(false);
        RefreshList.setForeground(new Color(0, 0, 0));
        RefreshList.setText("Refresh");
        RefreshList.setVisible(true);

        RefreshList.setContentAreaFilled(true);
        RefreshList.setBorderPainted(false);
        RefreshList.setIconTextGap(-2);

        RefreshList.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                RefreshList.setBackground(new Color(0, 0, 0));
                RefreshList.setForeground(new Color(255, 255, 255));

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                RefreshList.setBackground(new Color(248, 249, 250));
                RefreshList.setForeground(new Color(0, 0, 0));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                RefreshList.setBackground(new Color(150, 150, 150));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                RefreshList.setBackground(new Color(248, 249, 250));
                RefreshList.setForeground(new Color(0, 0, 0));
            }

        });

        RefreshList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                RefreshListFunction(evt);
            }
        });

        // Add Record (JButton) Decorations
        final int AddRecordLocationX = 450;
        final int AddRecordLocationY = 515;
        final int AddRecordWidth = 110;
        final int AddRecordHeight = 35;

        dashbarDatabase.add(AddRecord);
        AddRecord.setBounds(AddRecordLocationX, AddRecordLocationY, AddRecordWidth, AddRecordHeight);
        AddRecord.setBackground(new Color(248, 249, 250));
        AddRecord.setFont(new Font("Quicksand", Font.PLAIN, 14));
        AddRecord.setFocusPainted(false);
        AddRecord.setHorizontalAlignment(SwingConstants.CENTER);
        AddRecord.setOpaque(false);
        AddRecord.setForeground(new Color(0, 0, 0));
        AddRecord.setText("Add Record");
        AddRecord.setVisible(true);

        AddRecord.setContentAreaFilled(true);
        AddRecord.setBorderPainted(false);
        AddRecord.setIconTextGap(-2);

        AddRecord.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                AddRecord.setBackground(new Color(0, 0, 0));
                AddRecord.setForeground(new Color(255, 255, 255));

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                AddRecord.setBackground(new Color(248, 249, 250));
                AddRecord.setForeground(new Color(0, 0, 0));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                AddRecord.setBackground(new Color(150, 150, 150));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                AddRecord.setBackground(new Color(248, 249, 250));
                AddRecord.setForeground(new Color(0, 0, 0));
            }

        });

        AddRecord.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AddRecordButtonFunction(evt);
            }
        });

        //Delete Record Button (JButton) Decorations.
        final int DeleteRecordButtonLocationX = 670;
        final int DeleteRecordButtonLocationY = 515;
        final int DeleteRecordButtonWidth = 120;
        final int DeleteRecordButtonHeight = 35;

        dashbarDatabase.add(DeleteRecord);
        DeleteRecord.setBounds(DeleteRecordButtonLocationX, DeleteRecordButtonLocationY, DeleteRecordButtonWidth, DeleteRecordButtonHeight);
        DeleteRecord.setBackground(new Color(248, 249, 250));
        DeleteRecord.setFont(new Font("Quicksand", Font.PLAIN, 14));
        DeleteRecord.setFocusPainted(false);
        DeleteRecord.setHorizontalAlignment(SwingConstants.CENTER);
        DeleteRecord.setOpaque(false);
        DeleteRecord.setForeground(new Color(0, 0, 0));
        DeleteRecord.setText("Delete Record");
        DeleteRecord.setVisible(true);

        DeleteRecord.setContentAreaFilled(true);
        DeleteRecord.setBorderPainted(false);
        DeleteRecord.setIconTextGap(-2);

        DeleteRecord.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                DeleteRecord.setBackground(new Color(0, 0, 0));
                DeleteRecord.setForeground(new Color(255, 255, 255));

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                DeleteRecord.setBackground(new Color(248, 249, 250));
                DeleteRecord.setForeground(new Color(0, 0, 0));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                DeleteRecord.setBackground(new Color(150, 150, 150));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                DeleteRecord.setBackground(new Color(248, 249, 250));
                DeleteRecord.setForeground(new Color(0, 0, 0));
            }

        });

        DeleteRecord.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                DeleteButtonFunction(evt);
            }
        });

        // Print Record Button (JButton) Decorations.
        final int PrintRecordButtonLocationX = 560;
        final int PrintRecordButtonLocationY = 515;
        final int PrintRecordButtonWidth = 110;
        final int PrintRecordButtonHeight = 35;

        dashbarDatabase.add(PrintRecord);
        PrintRecord.setBounds(PrintRecordButtonLocationX, PrintRecordButtonLocationY, PrintRecordButtonWidth, PrintRecordButtonHeight);
        PrintRecord.setBackground(new Color(248, 249, 250));
        PrintRecord.setFont(new Font("Quicksand", Font.PLAIN, 14));
        PrintRecord.setFocusPainted(false);
        PrintRecord.setHorizontalAlignment(SwingConstants.CENTER);
        PrintRecord.setOpaque(false);
        PrintRecord.setForeground(new Color(0, 0, 0));
        PrintRecord.setText("Print Record");
        PrintRecord.setVisible(true);

        PrintRecord.setContentAreaFilled(true);
        PrintRecord.setBorderPainted(false);
        PrintRecord.setIconTextGap(-2);

        PrintRecord.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                PrintRecord.setBackground(new Color(0, 0, 0));
                PrintRecord.setForeground(new Color(255, 255, 255));

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                PrintRecord.setBackground(new Color(248, 249, 250));
                PrintRecord.setForeground(new Color(0, 0, 0));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                PrintRecord.setBackground(new Color(150, 150, 150));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                PrintRecord.setBackground(new Color(248, 249, 250));
                PrintRecord.setForeground(new Color(0, 0, 0));
            }

        });
        
        PrintRecord.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                PrintButtonFunction(evt);
            }
        });

        // Reset Fields (JButton) Decorations
        final int ResetListFieldsLocationX = 50;
        final int ResetListFieldsLocationY = 230;
        final int ResetListFieldsButtonWidth = 120;
        final int ResetListFieldsHeight = 35;

        dashbarDatabase.add(ResetListFields);
        ResetListFields.setBounds(ResetListFieldsLocationX, ResetListFieldsLocationY, ResetListFieldsButtonWidth, ResetListFieldsHeight);
        ResetListFields.setBackground(new Color(248, 249, 250));
        ResetListFields.setFont(new Font("Quicksand", Font.PLAIN, 14));
        ResetListFields.setFocusPainted(false);
        ResetListFields.setHorizontalAlignment(SwingConstants.CENTER);
        ResetListFields.setOpaque(false);
        ResetListFields.setForeground(new Color(0, 0, 0));
        ResetListFields.setText("CLEAR");
        ResetListFields.setVisible(true);

        ResetListFields.setContentAreaFilled(true);
        ResetListFields.setBorderPainted(false);
        ResetListFields.setIconTextGap(-2);

        ResetListFields.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                ResetListFields.setBackground(new Color(0, 0, 0));
                ResetListFields.setForeground(new Color(255, 255, 255));

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                ResetListFields.setBackground(new Color(248, 249, 250));
                ResetListFields.setForeground(new Color(0, 0, 0));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                ResetListFields.setBackground(new Color(150, 150, 150));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                ResetListFields.setBackground(new Color(248, 249, 250));
                ResetListFields.setForeground(new Color(0, 0, 0));
            }

        });

        ResetListFields.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ResetButtonFunction(evt);
            }
        });

        // Dashbar Database (JPanel) Decorations.
        final int dashbarDatabaseHeight = 574;
        final int dashbarDatabaseWidth = 801;
        final int dashbarDatabaseLocationX = 199;
        final int dashbarDatabaseLocationY = 126;

        dashbarDatabase.setBounds(dashbarDatabaseLocationX, dashbarDatabaseLocationY, dashbarDatabaseWidth, dashbarDatabaseHeight);
        add(dashbarDatabase);
        dashbarDatabase.setBackground(new Color(0, 0, 32));
        dashbarDatabase.setBorder(new javax.swing.border.LineBorder(new Color(255, 200, 0), 2, false));
        dashbarDatabase.setLayout(null);

        // dBDBackground (JLabel) Decorations.
        final int dBDBackgroundHeight = 568;
        final int dBDBackgroundWidth = 795;
        final int dBDBackgroundLocationX = 3;
        final int dBDBackgroundLocationY = 3;

        dBDBackground.setBounds(dBDBackgroundLocationX, dBDBackgroundLocationY, dBDBackgroundWidth, dBDBackgroundHeight);
        dashbarDatabase.add(dBDBackground);
        dBDBackground.setForeground(new Color(0, 0, 0));
        dBDBackground.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dBDBackground.setLayout(null);

        ImageIcon icon2 = new ImageIcon("src\\PRMS Files\\backgrounds\\carbonbackground.jpg");
        Image databaseBackground = icon2.getImage();
        Image imgScale2 = databaseBackground.getScaledInstance(dBHBackground.getWidth(), dBHBackground.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon2 = new ImageIcon(imgScale2);
        dBDBackground.setIcon(scaledIcon2);

        // Dashbar Officer Profile Components.
        // Officer Profile Picture (JLabel) Decorations.
        final int ProfilePictureLocationX = 70;
        final int ProfilePictureLocationY = 80;
        final int ProfilePictureWidth = 180;
        final int ProfilePictureHeight = 180;

        dashbarProfile.add(ProfilePicture);
        ProfilePicture.setBounds(ProfilePictureLocationX, ProfilePictureLocationY, ProfilePictureWidth, ProfilePictureHeight);
        ProfilePicture.setBackground(new Color(237, 242, 244));
        ProfilePicture.setOpaque(true);
        ProfilePicture.setHorizontalAlignment(SwingConstants.CENTER);
        ProfilePicture.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(237, 242, 244)));
        ProfilePicture.setLayout(null);
        ProfilePicture.setVisible(true);

        ImageIcon findProfilePicture = new ImageIcon("src\\PRMS Files\\icons\\Mugshot180x.png");
        Image importProfilePicture = findProfilePicture.getImage();
        Image scaleProfilePicture = importProfilePicture.getScaledInstance(ProfilePicture.getWidth(), ProfilePicture.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledProfilePicture = new ImageIcon(scaleProfilePicture);
        ProfilePicture.setIcon(scaledProfilePicture);

        // Profile Name Field (JTextField) Decorations.
        final int ProfileNameFieldLocationX = 300;
        final int ProfileNameFieldLocationY = 60;
        final int ProfileNameFieldWidth = 450;
        final int ProfileNameFieldHeight = 35;

        dashbarProfile.add(ProfileNameField);
        ProfileNameField.setBounds(ProfileNameFieldLocationX, ProfileNameFieldLocationY, ProfileNameFieldWidth, ProfileNameFieldHeight);
        ProfileNameField.setBackground(new Color(0, 0, 0, 0));
        ProfileNameField.setForeground(new Color(255, 255, 255));
        ProfileNameField.setHorizontalAlignment(SwingConstants.LEADING);
        ProfileNameField.setEditable(false);
        ProfileNameField.setText("OFFICER PROFILE");
        ProfileNameField.setOpaque(false);
        ProfileNameField.setCaretColor(new Color(237, 242, 244));
        ProfileNameField.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(237, 242, 244)));
        ProfileNameField.setFont(new Font("Quicksand", Font.BOLD, 30));
        ProfileNameField.setVisible(true);

        // Profile Age  (JLabel) Decorations.
        final int ProfileAgeLabelLocationX = 300;
        final int ProfileAgeLabelLocationY = 110;
        final int ProfileAgeLabelWidth = 130;
        final int ProfileAgeLabelHeight = 35;

        dashbarProfile.add(ProfileAgeLabel);
        ProfileAgeLabel.setBounds(ProfileAgeLabelLocationX, ProfileAgeLabelLocationY, ProfileAgeLabelWidth, ProfileAgeLabelHeight);
        ProfileAgeLabel.setForeground(new Color(255, 255, 255));
        ProfileAgeLabel.setFont(new Font("Quicksand", Font.PLAIN, 16));
        ProfileAgeLabel.setText("Age : ");
        ProfileAgeLabel.setVisible(true);

        // Profile Age Field (JTextField) Decorations.
        final int ProfileAgeFieldLocationX = 340;
        final int ProfileAgeFieldLocationY = 110;
        final int ProfileAgeFieldWidth = 27;
        final int ProfileAgeFieldHeight = 35;

        dashbarProfile.add(ProfileAgeField);
        ProfileAgeField.setBounds(ProfileAgeFieldLocationX, ProfileAgeFieldLocationY, ProfileAgeFieldWidth, ProfileAgeFieldHeight);
        ProfileAgeField.setBackground(new Color(0, 0, 0, 0));
        ProfileAgeField.setForeground(new Color(255, 255, 255));
        ProfileAgeField.setEditable(false);
        ProfileAgeField.setOpaque(false);
        ProfileAgeField.setCaretColor(new Color(237, 242, 244));
        ProfileAgeField.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(237, 242, 244)));
        ProfileAgeField.setFont(new Font("Quicksand", Font.PLAIN, 16));
        ProfileAgeField.setVisible(true);

        // Profile Home Address Label (JLabel) Decorations.
        final int ProfileHomeAddressLabelLocationX = 300;
        final int ProfileHomeAddressLabelLocationY = 140;
        final int ProfileHomeAddressLabelWidth = 130;
        final int ProfileHomeAddressLabelHeight = 35;

        dashbarProfile.add(ProfileHomeAddressLabel);
        ProfileHomeAddressLabel.setBounds(ProfileHomeAddressLabelLocationX, ProfileHomeAddressLabelLocationY, ProfileHomeAddressLabelWidth, ProfileHomeAddressLabelHeight);
        ProfileHomeAddressLabel.setForeground(new Color(255, 255, 255));
        ProfileHomeAddressLabel.setFont(new Font("Quicksand", Font.PLAIN, 16));
        ProfileHomeAddressLabel.setText("Home Address  :");
        ProfileHomeAddressLabel.setVisible(true);

        // Profile Home Address Field (JTextField) Decorations.
        final int ProfileHomeAddressFieldLocationX = 430;
        final int ProfileHomeAddressFieldLocationY = 140;
        final int ProfileHomeAddressFieldWidth = 310;
        final int ProfileHomeAddressFieldHeight = 35;

        dashbarProfile.add(ProfileHomeAddressField);
        ProfileHomeAddressField.setBounds(ProfileHomeAddressFieldLocationX, ProfileHomeAddressFieldLocationY, ProfileHomeAddressFieldWidth, ProfileHomeAddressFieldHeight);
        ProfileHomeAddressField.setBackground(new Color(0, 0, 0, 0));
        ProfileHomeAddressField.setForeground(new Color(255, 255, 255));
        ProfileHomeAddressField.setEditable(false);
        ProfileHomeAddressField.setOpaque(false);
        ProfileHomeAddressField.setCaretColor(new Color(237, 242, 244));
        ProfileHomeAddressField.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(237, 242, 244)));
        ProfileHomeAddressField.setFont(new Font("Quicksand", Font.PLAIN, 16));
        ProfileHomeAddressField.setVisible(true);

        // Profile Station Assigned Label (JLabel) Decorations.
        final int ProfileStationAssignedLabelLocationX = 300;
        final int ProfileStationAssignedLabelLocationY = 170;
        final int ProfileStationAssignedLabelWidth = 130;
        final int ProfileStationAssignedLabelHeight = 35;

        dashbarProfile.add(ProfileStationLabel);
        ProfileStationLabel.setBounds(ProfileStationAssignedLabelLocationX, ProfileStationAssignedLabelLocationY, ProfileStationAssignedLabelWidth, ProfileStationAssignedLabelHeight);
        ProfileStationLabel.setForeground(new Color(255, 255, 255));
        ProfileStationLabel.setFont(new Font("Quicksand", Font.PLAIN, 16));
        ProfileStationLabel.setText("Station Assigned :");
        ProfileStationLabel.setVisible(true);

        // Profile Station Assigned Field (JTextField) Decorations.
        final int ProfileStationFieldLocationX = 435;
        final int ProfileStationFieldLocationY = 170;
        final int ProfileStationFieldWidth = 310;
        final int ProfileStationFieldHeight = 35;

        dashbarProfile.add(ProfileStationField);
        ProfileStationField.setBounds(ProfileStationFieldLocationX, ProfileStationFieldLocationY, ProfileStationFieldWidth, ProfileStationFieldHeight);
        ProfileStationField.setBackground(new Color(0, 0, 0, 0));
        ProfileStationField.setForeground(new Color(255, 255, 255));
        ProfileStationField.setEditable(false);
        ProfileStationField.setOpaque(false);
        ProfileStationField.setCaretColor(new Color(237, 242, 244));
        ProfileStationField.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(237, 242, 244)));
        ProfileStationField.setFont(new Font("Quicksand", Font.PLAIN, 16));
        ProfileStationField.setVisible(true);

        // Profile Rank Label (JLabel) Decorations.
        final int ProfileRankLabelLocationX = 300;
        final int ProfileRankLabelLocationY = 200;
        final int ProfileRankLabelWidth = 130;
        final int ProfileRankLabelHeight = 35;

        dashbarProfile.add(ProfileRankLabel);
        ProfileRankLabel.setBounds(ProfileRankLabelLocationX, ProfileRankLabelLocationY, ProfileRankLabelWidth, ProfileRankLabelHeight);
        ProfileRankLabel.setForeground(new Color(255, 255, 255));
        ProfileRankLabel.setFont(new Font("Quicksand", Font.PLAIN, 16));
        ProfileRankLabel.setText("Officer Rank :");
        ProfileRankLabel.setVisible(true);

        // Profile Rank Field (JTextField) Decorations.
        final int ProfileRankFieldLocationX = 410;
        final int ProfileRankFieldLocationY = 200;
        final int ProfileRankFieldWidth = 310;
        final int ProfileRankFieldHeight = 35;

        dashbarProfile.add(ProfileRankField);
        ProfileRankField.setBounds(ProfileRankFieldLocationX, ProfileRankFieldLocationY, ProfileRankFieldWidth, ProfileRankFieldHeight);
        ProfileRankField.setBackground(new Color(0, 0, 0, 0));
        ProfileRankField.setForeground(new Color(255, 255, 255));
        ProfileRankField.setEditable(false);
        ProfileRankField.setOpaque(false);
        ProfileRankField.setCaretColor(new Color(237, 242, 244));
        ProfileRankField.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(237, 242, 244)));
        ProfileRankField.setFont(new Font("Quicksand", Font.PLAIN, 16));
        ProfileRankField.setVisible(true);

        // Profile Username Label (JLabel) Decorations.
        final int ProfileUsernameLabelLocationX = 300;
        final int ProfileUsernameLabelLocationY = 230;
        final int ProfileUsernameLabelWidth = 130;
        final int ProfileUsernameLabelHeight = 35;

        dashbarProfile.add(ProfileUsernameLabel);
        ProfileUsernameLabel.setBounds(ProfileUsernameLabelLocationX, ProfileUsernameLabelLocationY, ProfileUsernameLabelWidth, ProfileUsernameLabelHeight);
        ProfileUsernameLabel.setForeground(new Color(255, 255, 255));
        ProfileUsernameLabel.setFont(new Font("Quicksand", Font.PLAIN, 16));
        ProfileUsernameLabel.setText("Username :");
        ProfileUsernameLabel.setVisible(true);

        // Profile Username Field (JTextField) Decorations.
        final int ProfileUsernameFieldLocationX = 390;
        final int ProfileUsernameFieldLocationY = 230;
        final int ProfileUsernameFieldWidth = 310;
        final int ProfileUsernameFieldHeight = 35;

        dashbarProfile.add(ProfileUsernameField);
        ProfileUsernameField.setBounds(ProfileUsernameFieldLocationX, ProfileUsernameFieldLocationY, ProfileUsernameFieldWidth, ProfileUsernameFieldHeight);
        ProfileUsernameField.setBackground(new Color(0, 0, 0, 0));
        ProfileUsernameField.setForeground(new Color(255, 255, 255));
        ProfileUsernameField.setEditable(false);
        ProfileUsernameField.setOpaque(false);
        ProfileUsernameField.setCaretColor(new Color(237, 242, 244));
        ProfileUsernameField.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(237, 242, 244)));
        ProfileUsernameField.setFont(new Font("Quicksand", Font.PLAIN, 16));
        ProfileUsernameField.setVisible(true);

        // Profile Username Label (JLabel) Decorations.
        final int ProfileContactLabelLocationX = 300;
        final int ProfileContactLabelLocationY = 260;
        final int ProfileContactWidth = 130;
        final int ProfileContactHeight = 35;

        dashbarProfile.add(ProfileContactLabel);
        ProfileContactLabel.setBounds(ProfileContactLabelLocationX, ProfileContactLabelLocationY, ProfileContactWidth, ProfileContactHeight);
        ProfileContactLabel.setForeground(new Color(255, 255, 255));
        ProfileContactLabel.setFont(new Font("Quicksand", Font.PLAIN, 16));
        ProfileContactLabel.setText("Contact Number :");
        ProfileContactLabel.setVisible(true);

        // Profile Username Field (JTextField) Decorations.
        final int ProfileContactFieldLocationX = 440;
        final int ProfileContactFieldLocationY = 260;
        final int ProfileContactFieldWidth = 310;
        final int ProfileContactFieldHeight = 35;

        dashbarProfile.add(ProfileContactField);
        ProfileContactField.setBounds(ProfileContactFieldLocationX, ProfileContactFieldLocationY, ProfileContactFieldWidth, ProfileContactFieldHeight);
        ProfileContactField.setBackground(new Color(0, 0, 0, 0));
        ProfileContactField.setForeground(new Color(255, 255, 255));
        ProfileContactField.setEditable(false);
        ProfileContactField.setOpaque(false);
        ProfileContactField.setCaretColor(new Color(237, 242, 244));
        ProfileContactField.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(237, 242, 244)));
        ProfileContactField.setFont(new Font("Quicksand", Font.PLAIN, 16));
        ProfileContactField.setVisible(true);

        // Log-out Button (JButton) Decorations.
        final int LogOutButtonLocationX = 630;
        final int LogOutButtonLocationY = 515;
        final int LogOutButtonWidth = 120;
        final int LogOutButtonHeight = 35;

        dashbarProfile.add(LogOut);
        LogOut.setBounds(LogOutButtonLocationX, LogOutButtonLocationY, LogOutButtonWidth, LogOutButtonHeight);
        LogOut.setBackground(new Color(248, 249, 250));
        LogOut.setFont(new Font("Quicksand", Font.PLAIN, 14));
        LogOut.setFocusPainted(false);
        LogOut.setHorizontalAlignment(SwingConstants.CENTER);
        LogOut.setOpaque(false);
        LogOut.setForeground(new Color(0, 0, 0));
        LogOut.setText("Log-Out");
        LogOut.setVisible(true);

        LogOut.setContentAreaFilled(true);
        LogOut.setBorderPainted(false);
        LogOut.setIconTextGap(-2);

        LogOut.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                LogOut.setBackground(new Color(0, 0, 0));
                LogOut.setForeground(new Color(255, 255, 255));

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                LogOut.setBackground(new Color(248, 249, 250));
                LogOut.setForeground(new Color(0, 0, 0));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                LogOut.setBackground(new Color(150, 150, 150));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                LogOut.setBackground(new Color(248, 249, 250));
                LogOut.setForeground(new Color(0, 0, 0));
            }

        });

        LogOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                LogOutFunction(evt);
            }
        });

        // Officer Profile Dashbar Name (JLabel) Decorations.
        final int officerProfileTextHeight = 30;
        final int officerProfileTextWidth = 200;
        final int officerProfileTextX = 645;
        final int officerProfileTextY = 548;

        officerProfileText.setBounds(officerProfileTextX, officerProfileTextY, officerProfileTextWidth, officerProfileTextHeight);
        dashbarProfile.add(officerProfileText);
        officerProfileText.setForeground(new Color(255, 255, 255));
        officerProfileText.setFont(new Font("Impact", Font.PLAIN, 14));
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
        dashbarProfile.setBackground(new Color(0, 0, 50));
        dashbarProfile.setBorder(new javax.swing.border.LineBorder(new Color(255, 200, 0), 2, false));
        dashbarProfile.setLayout(null);
        dashbarProfile.setVisible(false);

        // dOPBackground (JLAbel) Decorations.
        final int dOPBackgroundHeight = 568;
        final int dOPBackgroundWidth = 795;
        final int dOPBackgroundLocationX = 3;
        final int dOPBackgroundLocationY = 3;

        dOPBackground.setBounds(dOPBackgroundLocationX, dOPBackgroundLocationY, dOPBackgroundWidth, dOPBackgroundHeight);
        dashbarProfile.add(dOPBackground);
        dOPBackground.setForeground(new Color(0, 0, 0));
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
        aboutDashBarText.setForeground(new Color(255, 255, 255));
        aboutDashBarText.setFont(new Font("Impact", Font.PLAIN, 14));
        aboutDashBarText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        aboutDashBarText.setText("ABOUT");
        aboutDashBarText.setVisible(true);

        // Company Logo (JLabel) Decorations.
        final int CompanyLogoLocationX = 0;
        final int CompanyLogoLocationY = 0;
        final int CompanyLogoWidth = 400;
        final int CompanyLogoHeight = 400;

        dashbarAbout.add(AboutCompanyLogo);
        AboutCompanyLogo.setBounds(CompanyLogoLocationX, CompanyLogoLocationY, CompanyLogoWidth, CompanyLogoHeight);
        AboutCompanyLogo.setOpaque(false);
        AboutCompanyLogo.setHorizontalAlignment(SwingConstants.CENTER);
        AboutCompanyLogo.setLayout(null);
        AboutCompanyLogo.setVisible(true);

        ImageIcon findCompanyLogo = new ImageIcon("src\\PRMS Files\\logo\\BTSLogo1.png");
        Image importCompanyLogo = findCompanyLogo.getImage();
        Image scaleCompanyLogo = importCompanyLogo.getScaledInstance(AboutCompanyLogo.getWidth(), AboutCompanyLogo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledCompanyLogo = new ImageIcon(scaleCompanyLogo);
        AboutCompanyLogo.setIcon(scaledCompanyLogo);

        // Company Name Label (JLabel) Declarations.        
        final int AboutCompanyLabelHeight = 18;
        final int AboutCompanyLabelWidth = 440;
        final int AboutCompanyLabelLocationX = 340;
        final int AboutCompanyLabelLocationY = 160;
        final int AboutCompanyShadowLocationY = 165;

        dashbarAbout.add(AboutCompanyName);
        AboutCompanyName.setBounds(AboutCompanyLabelLocationX, AboutCompanyLabelLocationY, AboutCompanyLabelWidth, AboutCompanyLabelHeight);
        AboutCompanyName.setForeground(new Color(255, 208, 0));
        AboutCompanyName.setFont(new Font("Iron Shark", Font.PLAIN, 18));

        JLabel ACLShadow = new JLabel();

        dashbarAbout.add(ACLShadow);
        ACLShadow.setBounds(AboutCompanyLabelLocationX, AboutCompanyShadowLocationY, AboutCompanyLabelWidth, AboutCompanyLabelHeight);
        ACLShadow.setForeground(new Color(0, 0, 0));
        ACLShadow.setFont(new Font("Iron Shark", Font.PLAIN, 18));

        AboutCompanyName.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        AboutCompanyName.setText("Brion Tactical Systems");
        AboutCompanyName.setVisible(true);

        ACLShadow.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        ACLShadow.setText("Brion Tactical Systems");
        ACLShadow.setVisible(true);

        // Program Name Label (JLabel) Declarations.
        final int AboutProgramLabelHeight = 20;
        final int AboutProgramLabelWidth = 300;
        final int AboutProgramLabelLocationX = 340;
        final int AboutProgramLabelLocationY = 185;
        final int AboutProgramShadowLocationY = 190;

        dashbarAbout.add(AboutProgramName);
        AboutProgramName.setBounds(AboutProgramLabelLocationX, AboutProgramLabelLocationY, AboutProgramLabelWidth, AboutProgramLabelHeight);
        AboutProgramName.setForeground(new Color(255, 255, 255));
        AboutProgramName.setFont(new Font("Impact", Font.PLAIN, 20));

        JLabel APLShadow = new JLabel();

        dashbarAbout.add(APLShadow);
        APLShadow.setBounds(AboutProgramLabelLocationX, AboutProgramShadowLocationY, AboutProgramLabelWidth, AboutProgramLabelHeight);
        APLShadow.setForeground(new Color(0, 0, 0));
        APLShadow.setFont(new Font("Impact", Font.PLAIN, 20));

        AboutProgramName.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        AboutProgramName.setText("POLICE RECORD MANAGEMENT SYSTEM");
        AboutProgramName.setVisible(true);

        APLShadow.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        APLShadow.setText("POLICE RECORD MANAGEMENT SYSTEM");
        APLShadow.setVisible(true);

        // Development Team Label (JLabel) Decorations.
        final int DevelopmentTeamLabelHeight = 20;
        final int DevelopmentTeamLabelWidth = 300;
        final int DevelopmentTeamLabelLocationX = 275;
        final int DevelopmentTeamLabelLocationY = 300;
        final int DevelopmentTeamShadowLocationY = 305;

        dashbarAbout.add(AboutDevelopmentTeamLabel);
        AboutDevelopmentTeamLabel.setBounds(DevelopmentTeamLabelLocationX, DevelopmentTeamLabelLocationY, DevelopmentTeamLabelWidth, DevelopmentTeamLabelHeight);
        AboutDevelopmentTeamLabel.setForeground(new Color(255, 255, 255));
        AboutDevelopmentTeamLabel.setFont(new Font("Impact", Font.PLAIN, 20));

        JLabel ADTLShadow = new JLabel();

        dashbarAbout.add(ADTLShadow);
        ADTLShadow.setBounds(DevelopmentTeamLabelLocationX, DevelopmentTeamShadowLocationY, DevelopmentTeamLabelWidth, DevelopmentTeamLabelHeight);
        ADTLShadow.setForeground(new Color(0, 0, 0));
        ADTLShadow.setFont(new Font("Impact", Font.PLAIN, 20));

        AboutDevelopmentTeamLabel.setHorizontalAlignment(SwingConstants.LEADING);
        AboutDevelopmentTeamLabel.setText("DEVELOPMENT TEAM INFORMATION");
        AboutDevelopmentTeamLabel.setVisible(true);

        ADTLShadow.setHorizontalAlignment(SwingConstants.LEADING);
        ADTLShadow.setText("DEVELOPMENT TEAM INFORMATION");
        ADTLShadow.setVisible(true);

        // First Year Second Semester Developers.
        final int FirstYearLabelHeight = 18;
        final int FirstYearLabelWidth = 300;
        final int FirstYearLabelLocationX = 50;
        final int FirstYearLabelLocationY = 340;
        final int FirstYearLabelShadowLocationY = 345;

        dashbarAbout.add(FirstYearDevelopers);
        FirstYearDevelopers.setBounds(FirstYearLabelLocationX, FirstYearLabelLocationY, FirstYearLabelWidth, FirstYearLabelHeight);
        FirstYearDevelopers.setForeground(new Color(255, 255, 255));
        FirstYearDevelopers.setFont(new Font("Impact", Font.PLAIN, 18));

        JLabel FirstYearShadow = new JLabel();

        dashbarAbout.add(FirstYearShadow);
        FirstYearShadow.setBounds(FirstYearLabelLocationX, FirstYearLabelShadowLocationY, FirstYearLabelWidth, FirstYearLabelHeight);
        FirstYearShadow.setForeground(new Color(0, 0, 0));
        FirstYearShadow.setFont(new Font("Impact", Font.PLAIN, 18));

        FirstYearDevelopers.setHorizontalAlignment(SwingConstants.LEADING);
        FirstYearDevelopers.setText("BSIT WMA 1F, 1st Year, 2nd Semester");
        FirstYearDevelopers.setVisible(true);

        FirstYearShadow.setHorizontalAlignment(SwingConstants.LEADING);
        FirstYearShadow.setText("BSIT WMA 1F, 1st Year, 2nd Semester");
        FirstYearShadow.setVisible(true);

        // Lead Developer 1st Year (JLabel) Decorations.
        final int FirstYearLeadDevLocationX = 50;
        final int FirstYearLeadDevLocationY = 370;
        final int FirstYearLeadDevWidth = 290;
        final int FirstYearLeadDevHeight = 35;

        dashbarAbout.add(FirstYearLeadD);
        FirstYearLeadD.setBounds(FirstYearLeadDevLocationX, FirstYearLeadDevLocationY, FirstYearLeadDevWidth, FirstYearLeadDevHeight);
        FirstYearLeadD.setBackground(new Color(0, 0, 0, 0));
        FirstYearLeadD.setForeground(new Color(255, 255, 255));
        FirstYearLeadD.setText("JHON BRIX BRION (Lead Developer)");
        FirstYearLeadD.setOpaque(false);
        FirstYearLeadD.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(237, 242, 244)));
        FirstYearLeadD.setFont(new Font("Quicksand", Font.PLAIN, 16));
        FirstYearLeadD.setVisible(true);

        // Co - Developer 1st Year (JLabel) Decorations.
        final int FirstYearCoDevLocationX = 50;
        final int FirstYearCoDevLocationY = 390;
        final int FirstYearCoDevWidth = 320;
        final int FirstYearCoDevHeight = 35;

        dashbarAbout.add(FirstYearCOD);
        FirstYearCOD.setBounds(FirstYearCoDevLocationX, FirstYearCoDevLocationY, FirstYearCoDevWidth, FirstYearCoDevHeight);
        FirstYearCOD.setBackground(new Color(0, 0, 0, 0));
        FirstYearCOD.setForeground(new Color(255, 255, 255));
        FirstYearCOD.setText("PAULA ANDREA NAVARRO (Co-Developer)");
        FirstYearCOD.setOpaque(false);
        FirstYearCOD.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(237, 242, 244)));
        FirstYearCOD.setFont(new Font("Quicksand", Font.PLAIN, 16));
        FirstYearCOD.setVisible(true);

        // Assistand Developer 1st Year (JLabel) Decorations.
        final int FirstYearAssistDevLocationX = 50;
        final int FirstYearAssistDevLocationY = 410;
        final int FirstYearAssistDevWidth = 320;
        final int FirstYearAssistDevHeight = 35;

        dashbarAbout.add(FirstYearAD);
        FirstYearAD.setBounds(FirstYearAssistDevLocationX, FirstYearAssistDevLocationY, FirstYearAssistDevWidth, FirstYearAssistDevHeight);
        FirstYearAD.setBackground(new Color(0, 0, 0, 0));
        FirstYearAD.setForeground(new Color(255, 255, 255));
        FirstYearAD.setText("ELISON SERRANO (Assistant Developer)");
        FirstYearAD.setOpaque(false);
        FirstYearAD.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(237, 242, 244)));
        FirstYearAD.setFont(new Font("Quicksand", Font.PLAIN, 16));
        FirstYearAD.setVisible(true);

        // CC3 Subject Professor (JLabel) Decorations.
        final int CC3ProfNameLocationX = 50;
        final int CC3ProfNameLocationY = 430;
        final int CC3ProfNameWidth = 320;
        final int CC3ProfNameHeight = 35;

        dashbarAbout.add(CC3SubProf);
        CC3SubProf.setBounds(CC3ProfNameLocationX, CC3ProfNameLocationY, CC3ProfNameWidth, CC3ProfNameHeight);
        CC3SubProf.setBackground(new Color(0, 0, 0, 0));
        CC3SubProf.setForeground(new Color(255, 255, 255));
        CC3SubProf.setText("PROF.RENGEL CORPUZ (CC3 Professor)");
        CC3SubProf.setOpaque(false);
        CC3SubProf.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(237, 242, 244)));
        CC3SubProf.setFont(new Font("Quicksand", Font.PLAIN, 16));
        CC3SubProf.setVisible(true);

        // 1st Year Development Timeline(JLabel) Decorations.
        final int FirstYearTimelineLocationX = 50;
        final int FirstYearTimelineLocationY = 460;
        final int FirstYearTimelineWidth = 335;
        final int FirstYearTimelineHeight = 35;

        dashbarAbout.add(FirstYearDevTimeline);
        FirstYearDevTimeline.setBounds(FirstYearTimelineLocationX, FirstYearTimelineLocationY, FirstYearTimelineWidth, FirstYearTimelineHeight);
        FirstYearDevTimeline.setBackground(new Color(0, 0, 0, 0));
        FirstYearDevTimeline.setForeground(new Color(255, 255, 255));
        FirstYearDevTimeline.setText("Started : April 8 2021 - Deadline : May 25 2021");
        FirstYearDevTimeline.setOpaque(false);
        FirstYearDevTimeline.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(237, 242, 244)));
        FirstYearDevTimeline.setFont(new Font("Quicksand", Font.PLAIN, 16));
        FirstYearDevTimeline.setVisible(true);

        // Second Year Second Semester Developers.
        final int SecondYearLabelHeight = 18;
        final int SecondYearLabelWidth = 300;
        final int SecondYearLabelLocationX = 410;
        final int SecondYearLabelLocationY = 340;
        final int SecondYearLabelShadowLocationY = 345;

        dashbarAbout.add(SecondYearDevelopers);
        SecondYearDevelopers.setBounds(SecondYearLabelLocationX, SecondYearLabelLocationY, SecondYearLabelWidth, SecondYearLabelHeight);
        SecondYearDevelopers.setForeground(new Color(255, 255, 255));
        SecondYearDevelopers.setFont(new Font("Impact", Font.PLAIN, 18));

        JLabel SecondYearShadow = new JLabel();

        dashbarAbout.add(SecondYearShadow);
        SecondYearShadow.setBounds(SecondYearLabelLocationX, SecondYearLabelShadowLocationY, SecondYearLabelWidth, SecondYearLabelHeight);
        SecondYearShadow.setForeground(new Color(0, 0, 0));
        SecondYearShadow.setFont(new Font("Impact", Font.PLAIN, 18));

        SecondYearDevelopers.setHorizontalAlignment(SwingConstants.LEADING);
        SecondYearDevelopers.setText("BSCS 2B, 2st Year, 2nd Semester");
        SecondYearDevelopers.setVisible(true);

        SecondYearShadow.setHorizontalAlignment(SwingConstants.LEADING);
        SecondYearShadow.setText("BSCS 2B, 2st Year, 2nd Semester");
        SecondYearShadow.setVisible(true);

        // Lead Developer 2nd Year (JLabel) Decorations.
        final int SecondYearLeadDevLocationX = 410;
        final int SecondYearLeadDevLocationY = 370;
        final int SecondYearLeadDevWidth = 320;
        final int SecondYearLeadDevHeight = 35;

        dashbarAbout.add(SecondYearLeadD);
        SecondYearLeadD.setBounds(SecondYearLeadDevLocationX, SecondYearLeadDevLocationY, SecondYearLeadDevWidth, SecondYearLeadDevHeight);
        SecondYearLeadD.setBackground(new Color(0, 0, 0, 0));
        SecondYearLeadD.setForeground(new Color(255, 255, 255));
        SecondYearLeadD.setText("JHON BRIX BRION (Lead Developer)");
        SecondYearLeadD.setOpaque(false);
        SecondYearLeadD.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(237, 242, 244)));
        SecondYearLeadD.setFont(new Font("Quicksand", Font.PLAIN, 16));
        SecondYearLeadD.setFont(new Font("Quicksand", Font.PLAIN, 16));
        SecondYearLeadD.setVisible(true);

        // Co - Developer (JLabel) Decorations.
        final int SecondYearCODevLocationX = 410;
        final int SecondYearCODevLocationY = 390;
        final int SecondYearCODevWidth = 320;
        final int SecondYearCODevHeight = 35;

        dashbarAbout.add(SecondYearCOD);
        SecondYearCOD.setBounds(SecondYearCODevLocationX, SecondYearCODevLocationY, SecondYearCODevWidth, SecondYearCODevHeight);
        SecondYearCOD.setBackground(new Color(0, 0, 0, 0));
        SecondYearCOD.setForeground(new Color(255, 255, 255));
        SecondYearCOD.setText("SHANE MARIE MON (Co-Developer)");
        SecondYearCOD.setOpaque(false);
        SecondYearCOD.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(237, 242, 244)));
        SecondYearCOD.setFont(new Font("Quicksand", Font.PLAIN, 16));
        SecondYearCOD.setFont(new Font("Quicksand", Font.PLAIN, 16));
        SecondYearCOD.setVisible(true);

        // ComProg 3 Subject Professor (JLabel) Decorations.
        final int ComProg3ProfNameLocationX = 410;
        final int ComProg3ProfNameLocationY = 430;
        final int ComProg3ProfNameWidth = 350;
        final int ComProg3NameHeight = 35;

        dashbarAbout.add(ComProg3Prof);
        ComProg3Prof.setBounds(ComProg3ProfNameLocationX, ComProg3ProfNameLocationY, ComProg3ProfNameWidth, ComProg3NameHeight);
        ComProg3Prof.setBackground(new Color(0, 0, 0, 0));
        ComProg3Prof.setForeground(new Color(255, 255, 255));
        ComProg3Prof.setText("PROF.KWINNO PINEDA (ComProg 3 Professor)");
        ComProg3Prof.setOpaque(false);
        ComProg3Prof.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(237, 242, 244)));
        ComProg3Prof.setFont(new Font("Quicksand", Font.PLAIN, 16));
        ComProg3Prof.setVisible(true);

        // 2nd Year Development Timeline (JLabel) Decorations.
        final int SecondYearTimelineLocationX = 410;
        final int SecondYearTimelineLocationY = 460;
        final int SecondYearTimelineWidth = 355;
        final int SecondYearTimelineHeight = 35;

        dashbarAbout.add(SecondYearDevTimeline);
        SecondYearDevTimeline.setBounds(SecondYearTimelineLocationX, SecondYearTimelineLocationY, SecondYearTimelineWidth, SecondYearTimelineHeight);
        SecondYearDevTimeline.setBackground(new Color(0, 0, 0, 0));
        SecondYearDevTimeline.setForeground(new Color(255, 255, 255));
        SecondYearDevTimeline.setText("Started : March 14 2022 - Deadline : May 23 2022");
        SecondYearDevTimeline.setOpaque(false);
        SecondYearDevTimeline.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(237, 242, 244)));
        SecondYearDevTimeline.setFont(new Font("Quicksand", Font.PLAIN, 16));
        SecondYearDevTimeline.setVisible(true);

        // Dashbar About Software (JPanel) Decorations.
        final int dashbarAboutLocationX = 199;
        final int dashbarAboutLocationY = 126;
        final int dashbarAboutWidth = 801;
        final int dashbarAboutHeight = 574;

        dashbarAbout.setBounds(dashbarAboutLocationX, dashbarAboutLocationY, dashbarAboutWidth, dashbarAboutHeight);
        add(dashbarAbout);
        dashbarAbout.setBackground(new Color(0, 0, 50));
        dashbarAbout.setBorder(new javax.swing.border.LineBorder(new Color(255, 200, 0), 2, false));
        dashbarAbout.setLayout(null);
        dashbarAbout.setVisible(false);

        // DashBar AboutBackground (JLAbel) Decorations.
        final int aboutBackgroundHeight = 568;
        final int aboutBackgroundWidth = 795;
        final int aboutBackgroundLocationX = 3;
        final int aboutBackgroundLocationY = 3;

        aboutBackground.setBounds(aboutBackgroundLocationX, aboutBackgroundLocationY, aboutBackgroundWidth, aboutBackgroundHeight);
        dashbarAbout.add(aboutBackground);
        aboutBackground.setForeground(new Color(0, 0, 0));
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
                dBHTab.setBackground(new Color(255, 255, 255));
                homeTabText.setForeground(new Color(0, 0, 0));

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
                dBHTab.setBackground(new Color(21, 21, 21));
                homeTabText.setForeground(new Color(255, 255, 255));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                dBHTab.setBackground(new Color(100, 100, 100));
                homeTabText.setForeground(new Color(0, 0, 0));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                dBHTab.setBackground(new Color(21, 21, 21));
                homeTabText.setForeground(new Color(255, 255, 255));
            }
        });

        dBDTab.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {

                dBDTab.setBackground(new Color(255, 255, 255));
                databaseTabText.setForeground(new Color(0, 0, 0));

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
                dBDTab.setBackground(new Color(21, 21, 21));
                databaseTabText.setForeground(new Color(255, 255, 255));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                dBDTab.setBackground(new Color(100, 100, 100));
                databaseTabText.setForeground(new Color(0, 0, 0));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                dBDTab.setBackground(new Color(21, 21, 21));
                databaseTabText.setForeground(new Color(255, 255, 255));
            }
        });

        profileTab.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

                profileTab.setBackground(new Color(255, 255, 255));
                profileTabText.setForeground(new Color(0, 0, 0));

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
                profileTab.setBackground(new Color(21, 21, 21));
                profileTabText.setForeground(new Color(255, 255, 255));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                profileTab.setBackground(new Color(100, 100, 100));
                profileTabText.setForeground(new Color(0, 0, 0));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                profileTab.setBackground(new Color(21, 21, 21));
                profileTabText.setForeground(new Color(255, 255, 255));
            }
        });

        aboutTab.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                aboutTab.setBackground(new Color(255, 255, 255));
                aboutTabText.setForeground(new Color(0, 0, 0));

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
                aboutTab.setBackground(new Color(21, 21, 21));
                aboutTabText.setForeground(new Color(255, 255, 255));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                aboutTab.setBackground(new Color(100, 100, 100));
                aboutTabText.setForeground(new Color(0, 0, 0));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                aboutTab.setBackground(new Color(21, 21, 21));
                aboutTabText.setForeground(new Color(255, 255, 255));
            }
        });

        // Minimize Button.
        final int minimizeButtonLocationX = 966;
        final int minimizeButtonLocationY = 10;
        final int minimizeButtonWidth = 24;
        final int minimizeButtonHeight = 24;

        titleBar.add(minimize);
        minimize.setBounds(minimizeButtonLocationX, minimizeButtonLocationY, minimizeButtonWidth, minimizeButtonHeight);
        minimize.setForeground(new Color(0, 0, 0));
        minimize.setBackground(new Color(248, 249, 250));
        minimize.setFont(new Font("Quicksand", Font.PLAIN, 16));
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

    // PRMSMainWindow CLASS FUNCTIONS //
    private void SetComponentLookAndFeel() {

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

    private void LogOutFunction(ActionEvent evt) {

        // CUSTOM EXIT BUTTON PROMP
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        int Question_YES = JOptionPane.showConfirmDialog(null, "Are you sure you want to Log-Out?", "BTS : PRMS - Log-Out Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (Question_YES == JOptionPane.YES_OPTION) {

            dispose();
            try {
                for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                e.printStackTrace();
            }
            PRMSLogin LogOut = new PRMSLogin();
            LogOut.setTitle("Brion Tactical Systems : PRMS DATABASE");
            LogOut.setLocationRelativeTo(null);
            LogOut.setVisible(true);

        } else if (Question_YES == JOptionPane.NO_OPTION) {

            String message = " User Log-Out Aborted";
            String title1 = "BTS : PRMS - Confirmation";

            JOptionPane.showMessageDialog(null, message, title1, JOptionPane.INFORMATION_MESSAGE);

        }
    }

    private void GetDataFromDatabase() {
        Connection dbconn = DBConnection.connectDB();
        String sqlQuery = "SELECT * FROM prmscriminalrecords";
        if (dbconn != null) {
            try {
                Statement st = (Statement) dbconn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = st.executeQuery(sqlQuery);
                PoliceRecords.setModel(DbUtils.resultSetToTableModel(rs));
                PoliceRecords.getColumnModel().getColumn(0).setPreferredWidth(50);
                PoliceRecords.getColumnModel().getColumn(1).setPreferredWidth(150);
                PoliceRecords.getColumnModel().getColumn(2).setPreferredWidth(150);
                PoliceRecords.getColumnModel().getColumn(3).setPreferredWidth(150);
                PoliceRecords.getColumnModel().getColumn(4).setPreferredWidth(400);
                PoliceRecords.getColumnModel().getColumn(5).setPreferredWidth(150);
                PoliceRecords.getColumnModel().getColumn(6).setPreferredWidth(150);
                PoliceRecords.getColumnModel().getColumn(7).setPreferredWidth(150);
                PoliceRecords.getColumnModel().getColumn(8).setPreferredWidth(150);
                PoliceRecords.getColumnModel().getColumn(9).setPreferredWidth(150);
                PoliceRecords.getColumnModel().getColumn(10).setPreferredWidth(150);
                TableColumn tcol = PoliceRecords.getColumnModel().getColumn(11);
                PoliceRecords.removeColumn(tcol);

                String header[] = {"ID", "LAST NAME", "FIRST NAME", "MIDDLE NAME", "ADDRESS", "DATE OF ARREST", "DATE OF RELEASE", "AGE", "GENDER", "STATUS", "ORIGIN", ""};

                for (int i = 0; i < PoliceRecords.getColumnCount(); i++) {
                    TableColumn column1 = PoliceRecords.getTableHeader().getColumnModel().getColumn(i);

                    column1.setHeaderValue(header[i]);
                }
            } catch (SQLException ex) {
                Logger.getLogger(PRMSMainWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("Police Database connection Unavailable! Check your JDBC Connector");
            JOptionPane.showMessageDialog(this, "Police database connection unavailable!\r\n"
                    + "Please Check your JDBC Connector!", "POLICE DATABASE", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void PoliceRecordsFunction(MouseEvent evt) {
        PoliceRecords.setCellSelectionEnabled(false);
        PoliceRecords.setRowSelectionAllowed(true);

        int number = PoliceRecords.getSelectedRow();
        IDField.setText(PoliceRecords.getValueAt(number, 0).toString());
        String conCat = PoliceRecords.getValueAt(number, 1).toString() + ", " + PoliceRecords.getValueAt(number, 2).toString()
                + " " + PoliceRecords.getValueAt(number, 3).toString();
        String upperCase = conCat.toUpperCase();
        NameField.setText(upperCase);
        HomeAddressField.setText(PoliceRecords.getValueAt(number, 4).toString());
        DateOfArrestField.setText(PoliceRecords.getValueAt(number, 5).toString());
        DateOfReleaseField.setText(PoliceRecords.getValueAt(number, 6).toString());
        AgeField.setText(PoliceRecords.getValueAt(number, 7).toString());
        GenderField.setText(PoliceRecords.getValueAt(number, 8).toString());
        ReasonOfApprehensionField.setText(PoliceRecords.getValueAt(number, 9).toString());
        ProvinceOfOriginField.setText(PoliceRecords.getValueAt(number, 10).toString());

        Connection conn = DBConnection.connectDB();
        if (conn != null) {
            try {
                String username = IDField.getText();
                PreparedStatement ps = (PreparedStatement) conn.prepareStatement("SELECT crimPicture FROM prmscriminalrecords WHERE id = ?");
                ps.setString(1, username);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    byte[] imageBytes = rs.getBytes("crimPicture");
                    ImageIcon imageIcon = new ImageIcon(imageBytes);
                    Image imagePicture = imageIcon.getImage();
                    Image resizeImage = imagePicture.getScaledInstance(180, 180, Image.SCALE_SMOOTH);
                    ImageIcon myPicture = new ImageIcon(resizeImage);
                    MugShot.setIcon(myPicture);

                }
            } catch (SQLException ex) {
                Logger.getLogger(PRMSMainWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("Police Database connection Unavailable! Check your JDBC Connector");
            JOptionPane.showMessageDialog(this, "Police database connection unavailable!\r\n"
                    + "Please Check your JDBC Connector!", "POLICE DATABASE", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void SearchBarKeyPressed(KeyEvent evt) {

        DefaultTableModel table = (DefaultTableModel) PoliceRecords.getModel();
        String search = SearchBar.getText();
        @SuppressWarnings("Convert2Diamond")
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        PoliceRecords.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));

    }

    private void RefreshListFunction(ActionEvent evt) {

        // GET DATA TO DATABASE
        Connection dbconn = DBConnection.connectDB();
        String sqlQuery = "SELECT * FROM prmscriminalrecords";
        if (dbconn != null) {
            try {
                Statement st = (Statement) dbconn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = st.executeQuery(sqlQuery);
                PoliceRecords.setModel(DbUtils.resultSetToTableModel(rs));
                PoliceRecords.getColumnModel().getColumn(0).setPreferredWidth(50);
                PoliceRecords.getColumnModel().getColumn(1).setPreferredWidth(150);
                PoliceRecords.getColumnModel().getColumn(2).setPreferredWidth(150);
                PoliceRecords.getColumnModel().getColumn(3).setPreferredWidth(150);
                PoliceRecords.getColumnModel().getColumn(4).setPreferredWidth(400);
                PoliceRecords.getColumnModel().getColumn(5).setPreferredWidth(150);
                PoliceRecords.getColumnModel().getColumn(6).setPreferredWidth(150);
                PoliceRecords.getColumnModel().getColumn(7).setPreferredWidth(150);
                PoliceRecords.getColumnModel().getColumn(8).setPreferredWidth(150);
                PoliceRecords.getColumnModel().getColumn(9).setPreferredWidth(150);
                PoliceRecords.getColumnModel().getColumn(10).setPreferredWidth(150);
                TableColumn tcol = PoliceRecords.getColumnModel().getColumn(11);
                PoliceRecords.removeColumn(tcol);

                String header[] = {"ID", "LAST NAME", "FIRST NAME", "MIDDLE NAME", "ADDRESS", "DATE OF ARREST", "DATE OF RELEASE", "AGE", "GENDER", "STATUS", "ORIGIN", ""};

                for (int i = 0; i < PoliceRecords.getColumnCount(); i++) {
                    TableColumn column1 = PoliceRecords.getTableHeader().getColumnModel().getColumn(i);

                    column1.setHeaderValue(header[i]);
                }
            } catch (SQLException ex) {
                Logger.getLogger(PRMSMainWindow.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            System.out.println("Police Database connection Unavailable! Check your JDBC Connector");
            JOptionPane.showMessageDialog(this, "Police database connection unavailable!\r\n"
                    + "Please Check your JDBC Connector!", "POLICE DATABASE", JOptionPane.INFORMATION_MESSAGE);
        }

    }
    
    private void PrintButtonFunction(ActionEvent evt){
        PRMSPrint Launch = new PRMSPrint();
        Launch.setVisible(true);
    }

    private void DeleteButtonFunction(ActionEvent evt) {

        PRMSAddRecord GetData = new PRMSAddRecord();
        Connection conn = DBConnection.connectDB();
        if (conn != null) {
            try {
                PreparedStatement ps = (PreparedStatement) conn.prepareStatement("DELETE FROM prmscriminalrecords WHERE ID = ?");
                ps.setInt(1, Integer.parseInt(IDField.getText()));
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Success! Record has been deleted");
                IDField.setText("");
                GetData.LastNameField.setText("");
                GetData.FirstNameField.setText("");
                GetData.MiddleNameField.setText("");
                GetData.HomeAddressField.setText("");
                GetData.DateOfArrestChooser.toString();
                GetData.DateOfReleaseChooser.toString();
                GetData.AgeList.getSelectedItem().toString();
                GetData.GenderList.getSelectedItem().toString();
                GetData.ReasonList.getSelectedItem().toString();
                GetData.OriginList.getSelectedItem().toString();
                GetData.AddMugShot.getIcon();

            } catch (SQLException ex) {
                Logger.getLogger(PRMSMainWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("Police Database connection Unavailable! Check your JDBC Connector");
            JOptionPane.showMessageDialog(this, "Police database connection unavailable!\r\n"
                    + "Please Check your JDBC Connector!", "POLICE DATABASE", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private void AddRecordButtonFunction(ActionEvent evt) {

        PRMSAddRecord Launch = new PRMSAddRecord();
        Launch.setVisible(true);

    }

    private void ResetButtonFunction(ActionEvent evt) {

        IDField.setText("");
        NameField.setText("- REPORT SHEET -");
        AgeField.setText("");
        GenderField.setText("");
        HomeAddressField.setText("");
        ProvinceOfOriginField.setText("");
        DateOfArrestField.setText("");
        DateOfReleaseField.setText("");
        ReasonOfApprehensionField.setText("");
        ImageIcon imageIcon = new ImageIcon("src\\PRMS Files\\icons\\Mugshot180x.png");
        Image imagePicture = imageIcon.getImage();

        Image resizeImage = imagePicture.getScaledInstance(180, 180, Image.SCALE_SMOOTH);
        ImageIcon myPicture = new ImageIcon(resizeImage);
        MugShot.setIcon(myPicture);

    }
    
    public static void main(String args[]) {
        PRMSMainWindow Launch = new PRMSMainWindow();
        Launch.setVisible(true);
    }
}
