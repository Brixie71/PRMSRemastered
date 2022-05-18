// Package, sets the Directory path of the class and its Dependencies.
package PRMSClasses;

// Swing, IO, AWT, SQL, and util imports of the Java Program.
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PRMSAddRecord extends JFrame {
    
    // Component Declarations.

    JPanel AddRecordBackground;

    JLabel AddRecordLabel, AddMugShot, LastNameLabel, FirstNameLabel, MiddleNameLabel, HomeAddressLabel, AgeLabel, GenderLabel, 
            OriginLabel, DOALabel, DORLabel, ReasonListLabel;

    JTextField LastNameField, FirstNameField, MiddleNameField, HomeAddressField;

    JComboBox AgeList, GenderList, OriginList, ReasonList;

    JDateChooser DateOfArrestChooser, DateOfReleaseChooser;

    JButton BrowsePictureButton, ClearFieldsButton, AddRecordButton, BackButton;

    // FRAME DRAGGER
    int xMouse;
    int yMouse;
    
    Font IronShark, Quicksand, Gepestev;

    // Calling Method
    public PRMSAddRecord() {
        
        SetComponentLookAndFeel();

        RegisterComponents();
        
        setIconImage();

    }

    // Component Instantiations and Decorations. The UI (Java Swing) design of the class.
    private void RegisterComponents() {

        // <editor-fold defaultstate="collapsed" desc="<<< Component Instantiations.">
        AddRecordBackground = new JPanel();

        AddRecordLabel = new JLabel();
        AddMugShot = new JLabel();
        LastNameLabel = new JLabel();
        FirstNameLabel = new JLabel();
        MiddleNameLabel = new JLabel();
        HomeAddressLabel = new JLabel();
        AgeLabel = new JLabel();
        GenderLabel = new JLabel();
        OriginLabel = new JLabel();
        DOALabel = new JLabel();
        DORLabel = new JLabel();
        ReasonListLabel = new JLabel();

        LastNameField = new JTextField();
        FirstNameField = new JTextField();
        MiddleNameField = new JTextField();
        HomeAddressField = new JTextField();

        AgeList = new JComboBox();
        GenderList = new JComboBox();
        OriginList = new JComboBox();
        ReasonList = new JComboBox();

        DateOfArrestChooser = new JDateChooser();
        DateOfReleaseChooser = new JDateChooser();

        BrowsePictureButton = new JButton();
        ClearFieldsButton = new JButton();
        AddRecordButton = new JButton();
        BackButton = new JButton();

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="<<< JFrame Container.">
        // JFrame Declaration
        final int FrameSizeX = 900;
        final int FrameSizeY = 530;

        //JFrame Size.
        setSize(FrameSizeX, FrameSizeY);
        setMinimumSize(new Dimension(FrameSizeX, FrameSizeY));
        setPreferredSize(new Dimension(FrameSizeX, FrameSizeY));

        //JFrame Decoration.
        setUndecorated(true);
        setOpacity(1.0f);
        setTitle("PRMS : Add Individual Record");
        setLayout(null);
        setResizable(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // CENTER POPUP MAIN WINDOW.
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dimension.width / 2 - this.getWidth() / 2, dimension.height / 2 - this.getHeight() / 2);

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
        
        // PRMSAddRecord Frame dragging Declaration.
        AddRecordBackground.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent evt) {

                int x = evt.getXOnScreen();
                int y = evt.getYOnScreen();

                setLocation(x - xMouse, y - yMouse);

            }
        });

        AddRecordBackground.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {

                xMouse = evt.getX();
                yMouse = evt.getY();

            }
        });
        
        // Add Record Background (JPanel) Decorations.
        final int AddRecordBackgroundLocationX = 0;
        final int AddRecordBackgroundLocationY = 0;
        final int AddRecordBackgroundWidth = 900;
        final int AddRecordBackgroundHeigth = 530;

        add(AddRecordBackground);
        AddRecordBackground.setBounds(AddRecordBackgroundLocationX, AddRecordBackgroundLocationY, AddRecordBackgroundWidth, AddRecordBackgroundHeigth);
        AddRecordBackground.setBackground(new Color(0, 29, 61));
        AddRecordBackground.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(255, 208, 0)));
        AddRecordBackground.setLayout(null);
        AddRecordBackground.setVisible(true);

        // Add Record Title (JLabel) Decorations.
        final int AddRecordLabelLocationX = 0;
        final int AddRecordLabelLocationY = 50;
        final int AddRecordLabelWidth = 900;
        final int AddRecordLabelHeight = 35;

        AddRecordBackground.add(AddRecordLabel);
        AddRecordLabel.setBounds(AddRecordLabelLocationX, AddRecordLabelLocationY, AddRecordLabelWidth, AddRecordLabelHeight);
        AddRecordLabel.setBackground(new Color(0, 0, 0, 0));
        AddRecordLabel.setForeground(new Color(255, 255, 255));
        AddRecordLabel.setHorizontalAlignment(SwingConstants.CENTER);
        AddRecordLabel.setText("ADD DATABASE RECORD");
        AddRecordLabel.setOpaque(false);
        AddRecordLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(237, 242, 244)));
        AddRecordLabel.setFont(new Font("Quicksand", Font.BOLD, 26));
        AddRecordLabel.setVisible(true);

        // AddMugshot Picture (JLabel) Decorations.
        final int AddMugshotLocationX = 70;
        final int AddMugshotLocationY = 100;
        final int AddMugshotWidth = 180;
        final int AddMugshotHeight = 180;

        AddRecordBackground.add(AddMugShot);
        AddMugShot.setBounds(AddMugshotLocationX, AddMugshotLocationY, AddMugshotWidth, AddMugshotHeight);
        AddMugShot.setBackground(new Color(237, 242, 244));
        AddMugShot.setOpaque(true);
        AddMugShot.setHorizontalAlignment(SwingConstants.CENTER);
        AddMugShot.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(255, 208, 0)));
        AddMugShot.setLayout(null);
        AddMugShot.setVisible(true);

        ImageIcon findMugshot = new ImageIcon("src\\PRMS Files\\icons\\Mugshot180x.png");
        Image importMugshot = findMugshot.getImage();
        Image scaleMugshot = importMugshot.getScaledInstance(AddMugShot.getWidth(), AddMugShot.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledMugshot = new ImageIcon(scaleMugshot);
        AddMugShot.setIcon(scaledMugshot);

        // Last Name Label (JLabel) Decorations.
        final int GenderLabelLocationX = 300;
        final int GenderLabelLocationY = 100;
        final int GenderLabelWidth = 130;
        final int GenderLabelHeight = 35;

        AddRecordBackground.add(LastNameLabel);
        LastNameLabel.setBounds(GenderLabelLocationX, GenderLabelLocationY, GenderLabelWidth, GenderLabelHeight);
        LastNameLabel.setForeground(new Color(255, 255, 255));
        LastNameLabel.setFont(new Font("Quicksand", Font.PLAIN, 16));
        LastNameLabel.setText("Last Name :");
        LastNameLabel.setVisible(true);

        // Last Name Field (JTextField) Decorations.
        final int LastNameFieldLocationX = 400;
        final int LastNameLocationY = 100;
        final int LastNameWidth = 430;
        final int LastNameHeight = 35;

        AddRecordBackground.add(LastNameField);
        LastNameField.setBounds(LastNameFieldLocationX, LastNameLocationY, LastNameWidth, LastNameHeight);
        LastNameField.setBackground(new Color(237, 242, 244, 255));
        LastNameField.setForeground(new Color(0, 0, 0));
        LastNameField.setEditable(true);
        LastNameField.setOpaque(true);
        LastNameField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        LastNameField.setVisible(true);

        // First Name Label (JLabel) Decorations.
        final int FirstNameLabelLocationX = 300;
        final int FirstNameLabelLocationY = 150;
        final int FirstNameLabelWidth = 130;
        final int FirstNameLabelHeight = 35;

        AddRecordBackground.add(FirstNameLabel);
        FirstNameLabel.setBounds(FirstNameLabelLocationX, FirstNameLabelLocationY, FirstNameLabelWidth, FirstNameLabelHeight);
        FirstNameLabel.setForeground(new Color(255, 255, 255));
        FirstNameLabel.setFont(new Font("Quicksand", Font.PLAIN, 16));
        FirstNameLabel.setText("First Name :");
        FirstNameLabel.setVisible(true);

        // First Name Field (JTextField) Decorations.
        final int FirstNameFieldLocationX = 400;
        final int FirstNameFieldLocationY = 150;
        final int FirstNameFieldWidth = 430;
        final int FirstNameFieldHeight = 35;

        AddRecordBackground.add(FirstNameField);
        FirstNameField.setBounds(FirstNameFieldLocationX, FirstNameFieldLocationY, FirstNameFieldWidth, FirstNameFieldHeight);
        FirstNameField.setBackground(new Color(237, 242, 244, 255));
        FirstNameField.setForeground(new Color(0, 0, 0));
        FirstNameField.setEditable(true);
        FirstNameField.setOpaque(true);
        FirstNameField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        FirstNameField.setVisible(true);

        // Middle Name Label (JLabel) Decorations.
        final int MiddleNameLabelLocationX = 300;
        final int MiddleNameLabelLocationY = 200;
        final int MiddleNameLabelWidth = 130;
        final int MiddleNameLabelHeight = 35;

        AddRecordBackground.add(MiddleNameLabel);
        MiddleNameLabel.setBounds(MiddleNameLabelLocationX, MiddleNameLabelLocationY, MiddleNameLabelWidth, MiddleNameLabelHeight);
        MiddleNameLabel.setForeground(new Color(255, 255, 255));
        MiddleNameLabel.setFont(new Font("Quicksand", Font.PLAIN, 16));
        MiddleNameLabel.setText("Middle Name :");
        MiddleNameLabel.setVisible(true);

        // Middle Name Field (JTextField) Decorations.
        final int MiddleNameFieldLocationX = 415;
        final int MiddleNameFieldLocationY = 200;
        final int MiddleNameFieldWidth = 415;
        final int MiddleNameFieldHeight = 35;

        AddRecordBackground.add(MiddleNameField);
        MiddleNameField.setBounds(MiddleNameFieldLocationX, MiddleNameFieldLocationY, MiddleNameFieldWidth, MiddleNameFieldHeight);
        MiddleNameField.setBackground(new Color(237, 242, 244, 255));
        MiddleNameField.setForeground(new Color(0, 0, 0));
        MiddleNameField.setEditable(true);
        MiddleNameField.setOpaque(true);
        MiddleNameField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        MiddleNameField.setVisible(true);

        // Home Address Label (JLabel) Decorations.
        final int HomeAddressLabelLocationX = 300;
        final int HomeAddressLabelLocationY = 250;
        final int HomeAddressLabelWidth = 130;
        final int HomeAddressLabelHeight = 35;

        AddRecordBackground.add(HomeAddressLabel);
        HomeAddressLabel.setBounds(HomeAddressLabelLocationX, HomeAddressLabelLocationY, HomeAddressLabelWidth, HomeAddressLabelHeight);
        HomeAddressLabel.setForeground(new Color(255, 255, 255));
        HomeAddressLabel.setFont(new Font("Quicksand", Font.PLAIN, 16));
        HomeAddressLabel.setText("Home Address :");
        HomeAddressLabel.setVisible(true);

        // Home Address Field (JTextField) Decorations.
        final int HomeAddressFieldLocationX = 430;
        final int HomeAddressFieldLocationY = 250;
        final int HomeAddressFieldWidth = 400;
        final int HomeAddressFieldHeight = 35;

        AddRecordBackground.add(HomeAddressField);
        HomeAddressField.setBounds(HomeAddressFieldLocationX, HomeAddressFieldLocationY, HomeAddressFieldWidth, HomeAddressFieldHeight);
        HomeAddressField.setBackground(new Color(237, 242, 244, 255));
        HomeAddressField.setForeground(new Color(0, 0, 0));
        HomeAddressField.setEditable(true);
        HomeAddressField.setOpaque(true);
        HomeAddressField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        HomeAddressField.setVisible(true);

        // Age List Label (JLabel) Decorations.
        final int AgeLabelLocationX = 300;
        final int AgeLabelLocationY = 300;
        final int AgeLabelWidth = 130;
        final int AgeLabelHeight = 35;

        AddRecordBackground.add(AgeLabel);
        AgeLabel.setBounds(AgeLabelLocationX, AgeLabelLocationY, AgeLabelWidth, AgeLabelHeight);
        AgeLabel.setForeground(new Color(255, 255, 255));
        AgeLabel.setFont(new Font("Quicksand", Font.PLAIN, 16));
        AgeLabel.setText("Age :");
        AgeLabel.setVisible(true);

        // AgeList (JComboBox) Decorations.
        final int AgeListLabelLocationX = 345;
        final int AgeListLabelLocationY = 300;
        final int AgeListLabelWidth = 60;
        final int AgeListLabelHeight = 35;

        AddRecordBackground.add(AgeList);
        AgeList.setBounds(AgeListLabelLocationX, AgeListLabelLocationY, AgeListLabelWidth, AgeListLabelHeight);
        AgeList.setBackground(new Color(237, 242, 244));
        AgeList.setForeground(new Color(0, 0, 0));
        AgeList.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        AgeList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"-0-", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
            "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44",
            "45", "46", "47", "48", "48", "50", "51", "52", "53", "54", "55", "56", "57", "58",
            "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72",
            "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "83", "85", "86",
            "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100",}));

        // Gender List Label (JLabel) Decorations.
        final int GenderListLabelLocationX = 410;
        final int GenderListLabelLocationY = 300;
        final int GenderListLabelWidth = 130;
        final int GenderListLabelHeight = 35;

        AddRecordBackground.add(GenderLabel);
        GenderLabel.setBounds(GenderListLabelLocationX, GenderListLabelLocationY, GenderListLabelWidth, GenderListLabelHeight);
        GenderLabel.setForeground(new Color(255, 255, 255));
        GenderLabel.setFont(new Font("Quicksand", Font.PLAIN, 16));
        GenderLabel.setText("Gender :");
        GenderLabel.setVisible(true);

        // Gender List (JComboBox) Decorations.
        final int GenderListChooserLocationX = 478;
        final int GenderListChooserLocationY = 300;
        final int GenderListChooserWidth = 100;
        final int GenderListChooserHeight = 35;

        AddRecordBackground.add(GenderList);
        GenderList.setBounds(GenderListChooserLocationX, GenderListChooserLocationY, GenderListChooserWidth, GenderListChooserHeight);
        GenderList.setBackground(new Color(237, 242, 244));
        GenderList.setForeground(new Color(0, 0, 0));
        GenderList.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        GenderList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Male", "Female"}));

        // Origin List Label (JLabel) Decorations.
        final int OriginListLabelLocationX = 588;
        final int OriginListLabelLocationY = 300;
        final int OriginListLabelWidth = 150;
        final int OriginListLabelHeight = 35;

        AddRecordBackground.add(OriginLabel);
        OriginLabel.setBounds(OriginListLabelLocationX, OriginListLabelLocationY, OriginListLabelWidth, OriginListLabelHeight);
        OriginLabel.setForeground(new Color(255, 255, 255));
        OriginLabel.setFont(new Font("Quicksand", Font.PLAIN, 16));
        OriginLabel.setText("Province of Origin :");
        OriginLabel.setVisible(true);

        // Origin List (JComboBox) Decorations.
        final int OriginListChooserLocationX = 730;
        final int OriginLabelListChooserLocationY = 300;
        final int OriginLabelListChooserWidth = 100;
        final int OriginLabelListChooserHeight = 35;

        AddRecordBackground.add(OriginList);
        OriginList.setBounds(OriginListChooserLocationX, OriginLabelListChooserLocationY, OriginLabelListChooserWidth, OriginLabelListChooserHeight);
        OriginList.setBackground(new Color(237, 242, 244));
        OriginList.setForeground(new Color(0, 0, 0));
        OriginList.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        OriginList.setModel(new DefaultComboBoxModel<>(new String[]{"Tarlac", "Zambales", "Bulacan", "Nueva Ejica", "Pampanga", "Bataan", "Aurora"}));

        // DateOfArrestLabel (JLabel) Decorations.
        final int DOALabelLocationX = 300;
        final int DOALabelLocationY = 350;
        final int DOALabelWidth = 150;
        final int DOALabelHeight = 35;

        AddRecordBackground.add(DOALabel);
        DOALabel.setBounds(DOALabelLocationX, DOALabelLocationY, DOALabelWidth, DOALabelHeight);
        DOALabel.setForeground(new Color(255, 255, 255));
        DOALabel.setFont(new Font("Quicksand", Font.PLAIN, 16));
        DOALabel.setText("Date Arrested :");
        DOALabel.setVisible(true);

        // DateOfArrestChooser (JDateChooser) Decorations.
        final int DOADateChooserLocationX = 420;
        final int DOADateChooserLocationY = 350;
        final int DOADateChooserWidth = 410;
        final int DOADateChooserHeight = 35;

        AddRecordBackground.add(DateOfArrestChooser);
        DateOfArrestChooser.setBounds(DOADateChooserLocationX, DOADateChooserLocationY, DOADateChooserWidth, DOADateChooserHeight);
        DateOfArrestChooser.setForeground(new Color(0, 0, 0));
        DateOfArrestChooser.setBackground(new Color(237, 242, 244));
        DateOfArrestChooser.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        DateOfArrestChooser.setVisible(true);

        // Date Of Release Label (JLabel) Decorations.
        final int DORLabelLocationX = 300;
        final int DORLabelLocationY = 400;
        final int DORLabelWidth = 150;
        final int DORLabelHeight = 35;

        AddRecordBackground.add(DORLabel);
        DORLabel.setBounds(DORLabelLocationX, DORLabelLocationY, DORLabelWidth, DORLabelHeight);
        DORLabel.setForeground(new Color(255, 255, 255));
        DORLabel.setFont(new Font("Quicksand", Font.PLAIN, 16));
        DORLabel.setText("Date of Release :");
        DORLabel.setVisible(true);

        // Date Of Release Chooser (JDateChooser) Decorations.
        final int DORDateChooserLocationX = 438;
        final int DORDateChooserLocationY = 400;
        final int DORDateChooserWidth = 391;
        final int DORDateChooserHeight = 35;

        AddRecordBackground.add(DateOfReleaseChooser);
        DateOfReleaseChooser.setBounds(DORDateChooserLocationX, DORDateChooserLocationY, DORDateChooserWidth, DORDateChooserHeight);
        DateOfReleaseChooser.setForeground(new Color(0, 0, 0));
        DateOfReleaseChooser.setBackground(new Color(237, 242, 244));
        DateOfReleaseChooser.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        DateOfReleaseChooser.setVisible(true);

        // Reason List Label (JLabel) Decorations.
        final int ReasonListLabelLocationX = 300;
        final int ReasonListLabelLocationY = 450;
        final int ReasonListLabelWidth = 200;
        final int ReasonListLabelHeight = 35;

        AddRecordBackground.add(ReasonListLabel);
        ReasonListLabel.setBounds(ReasonListLabelLocationX, ReasonListLabelLocationY, ReasonListLabelWidth, ReasonListLabelHeight);
        ReasonListLabel.setForeground(new Color(255, 255, 255));
        ReasonListLabel.setFont(new Font("Quicksand", Font.PLAIN, 16));
        ReasonListLabel.setText("Reason of Apprehension :");
        ReasonListLabel.setVisible(true);

        // Reason List (JComboBox) Decorations.
        final int ReasonListChooserLocationX = 500;
        final int ReasonListChooserLocationY = 450;
        final int ReasonListChooserWidth = 330;
        final int ReasonListChooserHeight = 35;

        AddRecordBackground.add(ReasonList);
        ReasonList.setBounds(ReasonListChooserLocationX, ReasonListChooserLocationY, ReasonListChooserWidth, ReasonListChooserHeight);
        ReasonList.setBackground(new Color(237, 242, 244));
        ReasonList.setForeground(new Color(0, 0, 0));
        ReasonList.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        ReasonList.setModel(new DefaultComboBoxModel<>(new String[]{"-SELECT-", "Murder", "Assault", "Possession of Illegal Drugs",
            "Illegal possession of firearms and ammunition", "Human Trafficking",
            "Drug Trafficking", "Disobedience of a Person in Authority", "Assault of a Person in Authority",
            "Illegal Detention", "Drunk Driving", "Extortion", "Forgery", "Fraud", "Harassment",
            "Identity Theft", "Rape", "Traffic Rage", "Theft", "Vandalism", "Homicide",
            "Damage to Property", "Bribery", "Child Abuse", "Cyber Crime", "Grave Misconduct"}));

        // BrowsePictureButton (JButton) Decorations.
        final int BrowsePictureButtonLocationX = 70;
        final int BrowsePictureButtonLocationY = 300;
        final int BrowsePictureButtonWidth = 180;
        final int BrowsePictureButtonHeight = 35;

        AddRecordBackground.add(BrowsePictureButton);
        BrowsePictureButton.setBounds(BrowsePictureButtonLocationX, BrowsePictureButtonLocationY, BrowsePictureButtonWidth, BrowsePictureButtonHeight);
        BrowsePictureButton.setBackground(new Color(248, 249, 250));
        BrowsePictureButton.setFont(new Font("Quicksand", Font.PLAIN, 14));
        BrowsePictureButton.setFocusPainted(false);
        BrowsePictureButton.setHorizontalAlignment(SwingConstants.CENTER);
        BrowsePictureButton.setOpaque(false);
        BrowsePictureButton.setForeground(new Color(0, 0, 0));
        BrowsePictureButton.setText("Browse Picture");
        BrowsePictureButton.setVisible(true);

        BrowsePictureButton.setContentAreaFilled(true);
        BrowsePictureButton.setBorderPainted(false);
        BrowsePictureButton.setIconTextGap(-2);

        BrowsePictureButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                BrowsePictureButton.setBackground(new Color(0, 0, 0));
                BrowsePictureButton.setForeground(new Color(255, 255, 255));

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                BrowsePictureButton.setBackground(new Color(248, 249, 250));
                BrowsePictureButton.setForeground(new Color(0, 0, 0));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                BrowsePictureButton.setBackground(new Color(150, 150, 150));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                BrowsePictureButton.setBackground(new Color(248, 249, 250));
                BrowsePictureButton.setForeground(new Color(0, 0, 0));
            }

        });

        BrowsePictureButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BrowsePictureButtonFunction(evt);
            }
        });

        // AddRecords (JButton) Decorations.
        final int AddRecordButtonLocationX = 70;
        final int AddRecordButtonLocationY = 350;
        final int AddRecordButtonWidth = 180;
        final int AddRecordButtonHeight = 35;

        AddRecordBackground.add(AddRecordButton);
        AddRecordButton.setBounds(AddRecordButtonLocationX, AddRecordButtonLocationY, AddRecordButtonWidth, AddRecordButtonHeight);
        AddRecordButton.setBackground(new Color(248, 249, 250));
        AddRecordButton.setFont(new Font("Quicksand", Font.PLAIN, 14));
        AddRecordButton.setFocusPainted(false);
        AddRecordButton.setHorizontalAlignment(SwingConstants.CENTER);
        AddRecordButton.setOpaque(false);
        AddRecordButton.setForeground(new Color(0, 0, 0));
        AddRecordButton.setText("Add Record");
        AddRecordButton.setVisible(true);

        AddRecordButton.setContentAreaFilled(true);
        AddRecordButton.setBorderPainted(false);
        AddRecordButton.setIconTextGap(-2);

        AddRecordButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                AddRecordButton.setBackground(new Color(0, 0, 0));
                AddRecordButton.setForeground(new Color(255, 255, 255));

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                AddRecordButton.setBackground(new Color(248, 249, 250));
                AddRecordButton.setForeground(new Color(0, 0, 0));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                AddRecordButton.setBackground(new Color(150, 150, 150));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                AddRecordButton.setBackground(new Color(248, 249, 250));
                AddRecordButton.setForeground(new Color(0, 0, 0));
            }

        });

        AddRecordButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AddRecordButtonFunction(evt);
            }
        });

        // ResetFieldsButton (JButton) Decorations.
        final int ClearFieldsButtonLocationX = 70;
        final int ClearFieldsButtonLocationY = 400;
        final int ClearFieldsButtonWidth = 180;
        final int ClearFieldsButtonHeight = 35;

        AddRecordBackground.add(ClearFieldsButton);
        ClearFieldsButton.setBounds(ClearFieldsButtonLocationX, ClearFieldsButtonLocationY, ClearFieldsButtonWidth, ClearFieldsButtonHeight);
        ClearFieldsButton.setBackground(new Color(248, 249, 250));
        ClearFieldsButton.setFont(new Font("Quicksand", Font.PLAIN, 14));
        ClearFieldsButton.setFocusPainted(false);
        ClearFieldsButton.setHorizontalAlignment(SwingConstants.CENTER);
        ClearFieldsButton.setOpaque(false);
        ClearFieldsButton.setForeground(new Color(0, 0, 0));
        ClearFieldsButton.setText("Clear Fields");
        ClearFieldsButton.setVisible(true);

        ClearFieldsButton.setContentAreaFilled(true);
        ClearFieldsButton.setBorderPainted(false);
        ClearFieldsButton.setIconTextGap(-2);

        ClearFieldsButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                ClearFieldsButton.setBackground(new Color(0, 0, 0));
                ClearFieldsButton.setForeground(new Color(255, 255, 255));

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                ClearFieldsButton.setBackground(new Color(248, 249, 250));
                ClearFieldsButton.setForeground(new Color(0, 0, 0));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                ClearFieldsButton.setBackground(new Color(150, 150, 150));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                ClearFieldsButton.setBackground(new Color(248, 249, 250));
                ClearFieldsButton.setForeground(new Color(0, 0, 0));
            }

        });

        ClearFieldsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ClearFieldsButtonFunction(evt);
            }
        });

        // BackButton (JButton) Decorations.
        final int BackButtonLocationX = 20;
        final int BackButtonLocationY = 20;
        final int BackButtonWidth = 100;
        final int BackButtonHeight = 35;

        AddRecordBackground.add(BackButton);
        BackButton.setBounds(BackButtonLocationX, BackButtonLocationY, BackButtonWidth, BackButtonHeight);
        BackButton.setBackground(new Color(248, 249, 250));
        BackButton.setFont(new Font("Quicksand", Font.PLAIN, 14));
        BackButton.setFocusPainted(false);
        BackButton.setHorizontalAlignment(SwingConstants.CENTER);
        BackButton.setOpaque(false);
        BackButton.setForeground(new Color(0, 0, 0));
        BackButton.setText("Back");
        BackButton.setVisible(true);

        BackButton.setContentAreaFilled(true);
        BackButton.setBorderPainted(false);
        BackButton.setIconTextGap(-2);

        BackButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                BackButton.setBackground(new Color(0, 0, 0));
                BackButton.setForeground(new Color(255, 255, 255));

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                BackButton.setBackground(new Color(248, 249, 250));
                BackButton.setForeground(new Color(0, 0, 0));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                BackButton.setBackground(new Color(150, 150, 150));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                BackButton.setBackground(new Color(248, 249, 250));
                BackButton.setForeground(new Color(0, 0, 0));
            }

        });

        BackButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BackButtonFunction(evt);
            }
        });

        pack();
        setLocationRelativeTo(null);
    }

    // PRMSAddRecord CLASS FUNCTIONS.
    
    // This uses a Exception Handling in getting a Picture.
    private void BrowsePictureButtonFunction(ActionEvent evt) {
        // USER PICTURE
        JFileChooser pictureChooser = new JFileChooser();
        pictureChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

        // File Extension
        FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("*Images", ".jpg", ".png", ".gif");
        pictureChooser.addChoosableFileFilter(fileFilter);

        int fileState = pictureChooser.showSaveDialog(null);

        // USER SELECTED FILE
        if (fileState == JFileChooser.APPROVE_OPTION) {

            File selectedFile = pictureChooser.getSelectedFile();
            String Path = selectedFile.getAbsolutePath();
            ImagePath = Path;

            // FROM HERE, DISPLAY IMAGE IN JLABEL
            AddMugShot.setIcon(ResizePicture(Path));

        } else if (fileState == JFileChooser.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(this, "No Image Selected! Please Fill up the form properly.", "POLICE DATABASE", JOptionPane.ERROR_MESSAGE);
        }
    }     

    // Converts the Util date into SQL date that is used in the Database.
    public static java.sql.Date convertUtilDateToSqlDate(Date date) {

        if (date != null) {
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            return sqlDate;
        }

        return null;

    } 

    /* This Method adds the Records that were inputted by the User. as well as establishes the connection between the 
       Class and the Database. If the Forms are Complete, the program will show a Dialog box showing that the record
       has been added into the database. */
    private void AddRecordToDatabaseFunction(String Lname, String Fname, String Mname, String rAddress) throws FileNotFoundException {

        java.util.Date date1 = DateOfArrestChooser.getDate();
        java.util.Date date2 = DateOfReleaseChooser.getDate();

        java.sql.Date DoArrest = convertUtilDateToSqlDate(date1);
        java.sql.Date DoRelease = convertUtilDateToSqlDate(date2);

        Connection dbconn = DBConnection.connectDB();

        if (dbconn != null) {
            try {
                PreparedStatement st = (PreparedStatement) dbconn.prepareStatement("INSERT INTO prmscriminalrecords (txtLname, txtFname, txtMname, txtAddress, doa, dor, txtAge, txtGender, txtCrime, txtOrigin, crimPicture) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

                st.setString(1, Lname);
                st.setString(2, Fname);
                st.setString(3, Mname);
                st.setString(4, rAddress);
                st.setDate(5, DoArrest);
                st.setDate(6, DoRelease);
                st.setString(7, AgeList.getSelectedItem().toString());
                st.setString(8, GenderList.getSelectedItem().toString());
                st.setString(9, ReasonList.getSelectedItem().toString());
                st.setString(10, OriginList.getSelectedItem().toString());
                InputStream ProfPicture = new FileInputStream(new File(ImagePath));
                st.setBlob(11, ProfPicture);

                st.executeUpdate();
                JOptionPane.showMessageDialog(this, "Success! Criminal Record has been created.", "PRMS DATABASE ", JOptionPane.INFORMATION_MESSAGE);

                LastNameField.setText("");
                FirstNameField.setText("");
                MiddleNameField.setText("");
                HomeAddressField.setText("");
                this.DateOfArrestChooser.toString();
                this.DateOfReleaseChooser.toString();
                AgeList.getSelectedItem().toString();
                GenderList.getSelectedItem().toString();
                OriginList.getSelectedItem().toString();
                ReasonList.getSelectedItem().toString();

            } catch (SQLException ex) {
                Logger.getLogger(PRMSAddRecord.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("Police Database connection Unavailable! Check your JDBC Connector");
            JOptionPane.showMessageDialog(this, "Police database connection unavailable!\r\n"
                    + "Please Check your JDBC Connector!", "POLICE DATABASE", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    
    /* This sets the Function of the JButton where if the JTextfields are empty, the program will show a Dialog box warning the user. 
       that the form is incomplete either because the Fields, Last name, Middle name, First name, Home Address and the ImagePath is null or has no data
       inputted. */
    private void AddRecordButtonFunction(ActionEvent evt) {
        //NAME
        String Lname = LastNameField.getText();
        String Fname = FirstNameField.getText();
        String Mname = MiddleNameField.getText();
        String rAddress = HomeAddressField.getText();

        if (Lname.isEmpty() || Fname.isEmpty() || Mname.isEmpty() || rAddress.isEmpty() || ImagePath == null) {
            JOptionPane.showMessageDialog(this, "Fields are incomplete! Please Fill up the form properly.", "PRMS DATABASE", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                AddRecordToDatabaseFunction(Lname, Fname, Mname, rAddress);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(PRMSAddRecord.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    // Clears all of the JTextField and JLabels that are used by the user.
    private void ClearFieldsButtonFunction(ActionEvent evt) {

        LastNameField.setText("");
        FirstNameField.setText("");
        MiddleNameField.setText("");
        HomeAddressField.setText("");
        AgeList.setSelectedIndex(0);
        GenderList.setSelectedIndex(0);
        ReasonList.setSelectedIndex(0);
        OriginList.setSelectedIndex(0);
        HomeAddressField.setText("");
        ImageIcon imageIcon = new ImageIcon("src\\PRMS Files\\icons\\Mugshot180x.png");
        Image imagePicture = imageIcon.getImage();

        Image resizeImage = imagePicture.getScaledInstance(180, 180, Image.SCALE_SMOOTH);
        ImageIcon myPicture = new ImageIcon(resizeImage);
        AddMugShot.setIcon(myPicture);
    }
    
    /* Sets that the ImagePath of the JLabel is null, meaning it is incomplete, if user sets the Image path by browsing the Image (Method: 
       BrowsePictureButtonFunction), it will set the Imagepath by that picture and will proceed in adding a record. */
    String ImagePath = null;

    // Fits the Image inside the JLabel (2x2).
    public ImageIcon ResizePicture(String picPath) {

        ImageIcon ProfilePicture = new ImageIcon(picPath);
        Image ProfPicture = ProfilePicture.getImage();
        Image resizeImage = ProfPicture.getScaledInstance(180, 180, Image.SCALE_SMOOTH);
        ImageIcon myPicture = new ImageIcon(resizeImage);
        return myPicture;
    }

    // Disposes the Window.
    private void BackButtonFunction(ActionEvent evt) {
        dispose();
    }
    
    // Sets the Component Look and Feel ex. Nimbus, Windows, Default.
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
    
    // Sets the Icon of the JFrame and the TaskBar Icon of the Program, instead of a Java Icon.
    private void setIconImage() {
                setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("BTSLogo.png")));
    }
}
