// Package, sets the Directory path of the class and its Dependencies.
package PRMSClasses;

// Swing, IO, AWT, SQL, and util imports of the Java Program.
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableColumn;
import net.proteanit.sql.DbUtils;

public class PRMSRegister extends JFrame {
    
    // Component Declarations
    
    JPanel RegisterBackground;
    
    JLabel RegTitleLabel, RegPoliceID, RegPolicePicture, RegFirstNameLabel, RegMiddleNameLabel, RegLastNameLabel,
           RegHomeAddressLabel, RegAgeLabel, RegContactNoLabel,
           RegStationLabel, RegRankLabel, RegUsernameLabel,
           RegPasswordLabel, RegPrivilegesLabel, RegSearchLabel;
    
    JButton RegBackButton, RegBrowseButton, RegUpdateAccountButton, RegDeleteAccountButton, RegClearFieldButton,
            RegCreateAccountButton;
    
    JTextField RegFNField, RegMNField, RegLNField, 
               RegHAField, RegAField, RegCNField, RegSField,
               RegRField, RegUNField, RegPWField, RegSearchField;
    
    JComboBox AccountPriveleges;        
    
    JTable RegAccountTable;
    
    JScrollPane RegAccountScrollPane;
            
            
    
    // FRAME DRAGGER
    int xMouse;
    int yMouse;
    
    // Calling Method
    public PRMSRegister(){
        
        SetComponentLookAndFeel();
        
        RegisterComponents();
        
        GetDataFromDatabase();
        
        setIconImage();
        
    }
    
    // // Component Instantiations and Decorations. The UI (Java Swing) design of the class.
    private void RegisterComponents() {
        
        // <editor-fold defaultstate="collapsed" desc="<<< JFrame Container.">
        // JFrame Declaration
        final int FrameSizeX = 1300;
        final int FrameSizeY = 650;

        //JFrame Size.
        setSize(FrameSizeX, FrameSizeY);
        setMinimumSize(new java.awt.Dimension(FrameSizeX, FrameSizeY));
        setPreferredSize(new java.awt.Dimension(FrameSizeX, FrameSizeY));

        //JFrame Decoration.
        setUndecorated(true);
        setOpacity(1.0f);
        setTitle("PRMS : Register Police Account");
        setLayout(null);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // CENTER POPUP MAIN WINDOW.
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dimension.width / 2 - this.getWidth() / 2, dimension.height / 2 - this.getHeight() / 2);

        // </editor-fold>
        
       
        // <editor-fold defaultstate="collapsed" desc="<<< Component Instantiations.">
        
        
        RegisterBackground = new JPanel();
    
        RegTitleLabel = new JLabel();
        RegPoliceID = new JLabel();
        RegPolicePicture = new JLabel();
        RegFirstNameLabel = new JLabel();
        RegMiddleNameLabel = new JLabel();
        RegLastNameLabel = new JLabel();
        RegHomeAddressLabel = new JLabel();
        RegAgeLabel = new JLabel(); 
        RegContactNoLabel = new JLabel();
        RegStationLabel = new JLabel();
        RegRankLabel = new JLabel(); 
        RegUsernameLabel = new JLabel();
        RegPasswordLabel = new JLabel();
        RegPrivilegesLabel = new JLabel();
        RegSearchLabel = new JLabel();
    
        RegBackButton = new JButton();
        RegBrowseButton = new JButton();
        RegUpdateAccountButton = new JButton(); 
        RegDeleteAccountButton = new JButton();
        RegClearFieldButton = new JButton();
        RegCreateAccountButton = new JButton();
    
        RegFNField = new JTextField();
        RegMNField = new JTextField();
        RegLNField = new JTextField();
        RegHAField = new JTextField();
        RegAField = new JTextField(); 
        RegCNField = new JTextField();
        RegSField = new JTextField();
        RegRField = new JTextField(); 
        RegUNField = new JTextField(); 
        RegPWField = new JTextField();
    
        AccountPriveleges = new JComboBox();  
        
        RegAccountTable = new JTable();
        
        RegAccountScrollPane = new JScrollPane();
        
        // </editor-fold>
        
        // PRMSRegister Frame dragging Declaration.
        RegisterBackground.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent evt) {

                int x = evt.getXOnScreen();
                int y = evt.getYOnScreen();

                setLocation(x - xMouse, y - yMouse);

            }
        });

        RegisterBackground.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {

                xMouse = evt.getX();
                yMouse = evt.getY();

            }
        });   
        
        // Registration Background (JPanel) Decorations.
        final int RegistrationBackgroundLocationX = 0;
        final int RegistrationBackgroundLocationY = 0;
        final int RegistrationBackgroundWidth = 1300;
        final int RegistrationBackgroundHeigth = 650;

        add(RegisterBackground);
        RegisterBackground.setBounds(RegistrationBackgroundLocationX, RegistrationBackgroundLocationY, RegistrationBackgroundWidth, RegistrationBackgroundHeigth);
        RegisterBackground.setBackground(new Color(0, 29, 61));
        RegisterBackground.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(255, 208, 0)));
        RegisterBackground.setLayout(null);
        RegisterBackground.setVisible(true);
        
        // Registration Title (JLabel) Decorations.
        final int AddRecordLabelLocationX = 0;
        final int AddRecordLabelLocationY = 50;
        final int AddRecordLabelWidth = 1300;
        final int AddRecordLabelHeight = 35;

        RegisterBackground.add(RegTitleLabel);
        RegTitleLabel.setBounds(AddRecordLabelLocationX, AddRecordLabelLocationY, AddRecordLabelWidth, AddRecordLabelHeight);
        RegTitleLabel.setBackground(new Color(0, 0, 0, 0));
        RegTitleLabel.setForeground(new Color(255, 255, 255));
        RegTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        RegTitleLabel.setText("PERSONEL REGISTRATION");
        RegTitleLabel.setOpaque(false);
        RegTitleLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(237, 242, 244)));
        RegTitleLabel.setFont(new Font("Quicksand", Font.BOLD, 26));
        RegTitleLabel.setVisible(true);

        // AddMugshot Picture (JLabel) Decorations.
        final int AddMugshotLocationX = 70;
        final int AddMugshotLocationY = 100;
        final int AddMugshotWidth = 180;
        final int AddMugshotHeight = 180;

        RegisterBackground.add(RegPolicePicture);
        RegPolicePicture.setBounds(AddMugshotLocationX, AddMugshotLocationY, AddMugshotWidth, AddMugshotHeight);
        RegPolicePicture.setBackground(new Color(237, 242, 244));
        RegPolicePicture.setOpaque(true);
        RegPolicePicture.setHorizontalAlignment(SwingConstants.CENTER);
        RegPolicePicture.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(255, 208, 0)));
        RegPolicePicture.setLayout(null);
        RegPolicePicture.setVisible(true);

        ImageIcon findMugshot = new ImageIcon("src\\PRMS Files\\icons\\Mugshot180x.png");
        Image importMugshot = findMugshot.getImage();
        Image scaleMugshot = importMugshot.getScaledInstance(RegPolicePicture.getWidth(), RegPolicePicture.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledMugshot = new ImageIcon(scaleMugshot);
        RegPolicePicture.setIcon(scaledMugshot);

        // First Name Label (JLabel) Decorations.
        final int FirstNameLabelLocationX = 300;
        final int FirstNameLabelLocationY = 100;
        final int FirstNameLabelWidth = 130;
        final int FirstNameLabelHeight = 35;

        RegisterBackground.add(RegFirstNameLabel);
        RegFirstNameLabel.setBounds(FirstNameLabelLocationX, FirstNameLabelLocationY, FirstNameLabelWidth, FirstNameLabelHeight);
        RegFirstNameLabel.setForeground(new Color(255, 255, 255));
        RegFirstNameLabel.setFont(new Font("Quicksand", Font.PLAIN, 16));
        RegFirstNameLabel.setText("First Name :");
        RegFirstNameLabel.setVisible(true);

        // First Name Field (JTextField) Decorations.
        final int FirstNameFieldLocationX = 400;
        final int FirstNameFieldLocationY = 100;
        final int FirstNameFieldWidth = 430;
        final int FirstNameFieldHeight = 35;

        RegisterBackground.add(RegFNField);
        RegFNField.setBounds(FirstNameFieldLocationX, FirstNameFieldLocationY, FirstNameFieldWidth, FirstNameFieldHeight);
        RegFNField.setBackground(new Color(237, 242, 244, 255));
        RegFNField.setForeground(new Color(0, 0, 0));
        RegFNField.setEditable(true);
        RegFNField.setOpaque(true);
        RegFNField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        RegFNField.setVisible(true);

        // Middle Name Label (JLabel) Decorations.
        final int MiddleNameLabelLocationX = 300;
        final int MiddleNameLabelLocationY = 150;
        final int MiddleNameLabelWidth = 130;
        final int MiddleNameLabelHeight = 35;

        RegisterBackground.add(RegMiddleNameLabel);
        RegMiddleNameLabel.setBounds(MiddleNameLabelLocationX, MiddleNameLabelLocationY, MiddleNameLabelWidth, MiddleNameLabelHeight);
        RegMiddleNameLabel.setForeground(new Color(255, 255, 255));
        RegMiddleNameLabel.setFont(new Font("Quicksand", Font.PLAIN, 16));
        RegMiddleNameLabel.setText("Middle Name :");
        RegMiddleNameLabel.setVisible(true);

        // Middle Name Field (JTextField) Decorations.
        final int MiddleNameFieldLocationX = 415;
        final int MiddleNameFieldLocationY = 150;
        final int MiddleNameFieldWidth = 415;
        final int MiddleNameFieldHeight = 35;

        RegisterBackground.add(RegMNField);
        RegMNField.setBounds(MiddleNameFieldLocationX, MiddleNameFieldLocationY, MiddleNameFieldWidth, MiddleNameFieldHeight);
        RegMNField.setBackground(new Color(237, 242, 244, 255));
        RegMNField.setForeground(new Color(0, 0, 0));
        RegMNField.setEditable(true);
        RegMNField.setOpaque(true);
        RegMNField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        RegMNField.setVisible(true);
        
        // Last Name Label (JLabel) Decorations.
        final int LastNameLabelLocationX = 300;
        final int LastNameLabelLocationY = 200;
        final int LastNameLabelWidth = 130;
        final int LastNameLabelHeight = 35;

        RegisterBackground.add(RegLastNameLabel);
        RegLastNameLabel.setBounds(LastNameLabelLocationX, LastNameLabelLocationY, LastNameLabelWidth, LastNameLabelHeight);
        RegLastNameLabel.setForeground(new Color(255, 255, 255));
        RegLastNameLabel.setFont(new Font("Quicksand", Font.PLAIN, 16));
        RegLastNameLabel.setText("Last Name :");
        RegLastNameLabel.setVisible(true);

        // Last Name Field (JTextField) Decorations.
        final int LastNameFieldLocationX = 400;
        final int LastNameLocationY = 200;
        final int LastNameWidth = 430;
        final int LastNameHeight = 35;

        RegisterBackground.add(RegLNField);
        RegLNField.setBounds(LastNameFieldLocationX, LastNameLocationY, LastNameWidth, LastNameHeight);
        RegLNField.setBackground(new Color(237, 242, 244, 255));
        RegLNField.setForeground(new Color(0, 0, 0));
        RegLNField.setEditable(true);
        RegLNField.setOpaque(true);
        RegLNField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        RegLNField.setVisible(true);

        // Home Address Label (JLabel) Decorations.
        final int HomeAddressLabelLocationX = 300;
        final int HomeAddressLabelLocationY = 250;
        final int HomeAddressLabelWidth = 130;
        final int HomeAddressLabelHeight = 35;

        RegisterBackground.add(RegHomeAddressLabel);
        RegHomeAddressLabel.setBounds(HomeAddressLabelLocationX, HomeAddressLabelLocationY, HomeAddressLabelWidth, HomeAddressLabelHeight);
        RegHomeAddressLabel.setForeground(new Color(255, 255, 255));
        RegHomeAddressLabel.setFont(new Font("Quicksand", Font.PLAIN, 16));
        RegHomeAddressLabel.setText("Home Address :");
        RegHomeAddressLabel.setVisible(true);

        // Home Address Field (JTextField) Decorations.
        final int HomeAddressFieldLocationX = 430;
        final int HomeAddressFieldLocationY = 250;
        final int HomeAddressFieldWidth = 400;
        final int HomeAddressFieldHeight = 35;

        RegisterBackground.add(RegHAField);
        RegHAField.setBounds(HomeAddressFieldLocationX, HomeAddressFieldLocationY, HomeAddressFieldWidth, HomeAddressFieldHeight);
        RegHAField.setBackground(new Color(237, 242, 244, 255));
        RegHAField.setForeground(new Color(0, 0, 0));
        RegHAField.setEditable(true);
        RegHAField.setOpaque(true);
        RegHAField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        RegHAField.setVisible(true);
        
        // Age Label (JLabel) Decorations.
        
        final int AgeLabelLocationX = 300;
        final int AgeLabelLocationY = 300;
        final int AgeLabelWidth = 100;
        final int AgeLabelHeight = 35;

        RegisterBackground.add(RegAgeLabel);
        RegAgeLabel.setBounds(AgeLabelLocationX, AgeLabelLocationY, AgeLabelWidth, AgeLabelHeight);
        RegAgeLabel.setForeground(new Color(255, 255, 255));
        RegAgeLabel.setFont(new Font("Quicksand", Font.PLAIN, 16));
        RegAgeLabel.setText("Age :");
        RegAgeLabel.setVisible(true);
        
        // Age Field (JTextField) Decorations.
        final int AgeFieldLocationX = 350;
        final int AgeLocationY = 300;
        final int AgeFieldWidth = 70;
        final int AgeFieldHeight = 35;

        RegisterBackground.add(RegAField);
        RegAField.setBounds(AgeFieldLocationX, AgeLocationY, AgeFieldWidth, AgeFieldHeight);
        RegAField.setBackground(new Color(237, 242, 244, 255));
        RegAField.setForeground(new Color(0, 0, 0));
        RegAField.setEditable(true);
        RegAField.setOpaque(true);
        RegAField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        RegAField.setVisible(true);
        
        // Contact Number Label (JLabel) Decorations.
        
        final int ContactLabelLocationX = 440;
        final int ContactLabelLocationY = 300;
        final int ContactLabelWidth = 200;
        final int ContactLabelHeight = 35;

        RegisterBackground.add(RegContactNoLabel);
        RegContactNoLabel.setBounds(ContactLabelLocationX, ContactLabelLocationY, ContactLabelWidth, ContactLabelHeight);
        RegContactNoLabel.setForeground(new Color(255, 255, 255));
        RegContactNoLabel.setFont(new Font("Quicksand", Font.PLAIN, 16));
        RegContactNoLabel.setText("Contact Number :");
        RegContactNoLabel.setVisible(true);
        
        // Contact Number Field (JTextField) Decorations.
        final int ContactFieldLocationX = 580;
        final int ContactFieldLocationY = 300;
        final int ContactFieldWidth = 250;
        final int ContactFieldHeight = 35;

        RegisterBackground.add(RegCNField);
        RegCNField.setBounds(ContactFieldLocationX, ContactFieldLocationY, ContactFieldWidth, ContactFieldHeight);
        RegCNField.setBackground(new Color(237, 242, 244, 255));
        RegCNField.setForeground(new Color(0, 0, 0));
        RegCNField.setEditable(true);
        RegCNField.setOpaque(true);
        RegCNField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        RegCNField.setVisible(true);
        
        // Station Label (JLabel) Decorations.
        
        final int StationLabelLocationX = 300;
        final int StationLabelLocationY = 350;
        final int StationLabelWidth = 100;
        final int StationLabelHeight = 35;

        RegisterBackground.add(RegStationLabel);
        RegStationLabel.setBounds(StationLabelLocationX, StationLabelLocationY, StationLabelWidth, StationLabelHeight);
        RegStationLabel.setForeground(new Color(255, 255, 255));
        RegStationLabel.setFont(new Font("Quicksand", Font.PLAIN, 16));
        RegStationLabel.setText("Station :");
        RegStationLabel.setVisible(true);
        
        // Station Field (JTextField) Decorations.
        final int StationFieldLocationX = 370;
        final int StationLocationY = 350;
        final int StationFieldWidth = 460;
        final int StationFieldHeight = 35;

        RegisterBackground.add(RegSField);
        RegSField.setBounds(StationFieldLocationX, StationLocationY, StationFieldWidth, StationFieldHeight);
        RegSField.setBackground(new Color(237, 242, 244, 255));
        RegSField.setForeground(new Color(0, 0, 0));
        RegSField.setEditable(true);
        RegSField.setOpaque(true);
        RegSField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        RegSField.setVisible(true);
        
        // Rank Label (JLabel) Decorations.
        
        final int RankLabelLocationX = 300;
        final int RankLabelLocationY = 400;
        final int RankLabelWidth = 100;
        final int RankLabelHeight = 35;

        RegisterBackground.add(RegRankLabel);
        RegRankLabel.setBounds(RankLabelLocationX, RankLabelLocationY, RankLabelWidth, RankLabelHeight);
        RegRankLabel.setForeground(new Color(255, 255, 255));
        RegRankLabel.setFont(new Font("Quicksand", Font.PLAIN, 16));
        RegRankLabel.setText("Rank :");
        RegRankLabel.setVisible(true);
        
        // Rank Field (JTextField) Decorations.
        final int RankFieldLocationX = 370;
        final int RankFieldLocationY = 400;
        final int RankFieldWidth = 460;
        final int RankFieldHeight = 35;

        RegisterBackground.add(RegRField);
        RegRField.setBounds(RankFieldLocationX, RankFieldLocationY, RankFieldWidth, RankFieldHeight);
        RegRField.setBackground(new Color(237, 242, 244, 255));
        RegRField.setForeground(new Color(0, 0, 0));
        RegRField.setEditable(true);
        RegRField.setOpaque(true);
        RegRField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        RegRField.setVisible(true);
        
        // Username Label (JLabel) Decorations.
        
        final int UsernameLabelLocationX = 300;
        final int UsernameLabelLocationY = 450;
        final int UsernameLabelWidth = 100;
        final int UsernameLabelHeight = 35;

        RegisterBackground.add(RegUsernameLabel);
        RegUsernameLabel.setBounds(UsernameLabelLocationX, UsernameLabelLocationY, UsernameLabelWidth, UsernameLabelHeight);
        RegUsernameLabel.setForeground(new Color(255, 255, 255));
        RegUsernameLabel.setFont(new Font("Quicksand", Font.PLAIN, 16));
        RegUsernameLabel.setText("Username :");
        RegUsernameLabel.setVisible(true);
        
        // Username Field (JTextField) Decorations.
        final int UsernameFieldLocationX = 400;
        final int UsernameFieldLocationY = 450;
        final int UsernameFieldWidth     = 430;
        final int UsernameFieldHeight    = 35;

        RegisterBackground.add(RegUNField);
        RegUNField.setBounds(UsernameFieldLocationX, UsernameFieldLocationY, UsernameFieldWidth, UsernameFieldHeight);
        RegUNField.setBackground(new Color(237, 242, 244, 255));
        RegUNField.setForeground(new Color(0, 0, 0));
        RegUNField.setEditable(true);
        RegUNField.setOpaque(true);
        RegUNField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        RegUNField.setVisible(true);
        
        // Password Label (JLabel) Decorations.
        
        final int PasswordLabelLocationX = 300;
        final int PasswordLabelLocationY = 500;
        final int PasswordLabelWidth = 100;
        final int PasswordLabelHeight = 35;

        RegisterBackground.add(RegPasswordLabel);
        RegPasswordLabel.setBounds(PasswordLabelLocationX, PasswordLabelLocationY, PasswordLabelWidth, PasswordLabelHeight);
        RegPasswordLabel.setForeground(new Color(255, 255, 255));
        RegPasswordLabel.setFont(new Font("Quicksand", Font.PLAIN, 16));
        RegPasswordLabel.setText("Password :");
        RegPasswordLabel.setVisible(true);
        
        // Password Field (JTextField) Decorations.
        final int PasswordLocationX = 400;
        final int PasswordLocationY = 500;
        final int PasswordWidth     = 430;
        final int PasswordFieldHeight    = 35;

        RegisterBackground.add(RegPWField);
        RegPWField.setBounds(PasswordLocationX, PasswordLocationY, PasswordWidth, PasswordFieldHeight);
        RegPWField.setBackground(new Color(237, 242, 244, 255));
        RegPWField.setForeground(new Color(0, 0, 0));
        RegPWField.setEditable(true);
        RegPWField.setOpaque(true);
        RegPWField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        RegPWField.setVisible(true);
        
        // Account Privelege Label (JLabel) Decorations.
        final int PrivilegeLocationX = 300;
        final int PrivilegeLabelLocationY = 550;
        final int PrivilegeLabelWidth = 150;
        final int PrivilegeLabelHeight = 35;

        RegisterBackground.add(RegPrivilegesLabel);
        RegPrivilegesLabel.setBounds(PrivilegeLocationX, PrivilegeLabelLocationY, PrivilegeLabelWidth, PrivilegeLabelHeight);
        RegPrivilegesLabel.setForeground(new Color(255, 255, 255));
        RegPrivilegesLabel.setFont(new Font("Quicksand", Font.PLAIN, 16));
        RegPrivilegesLabel.setText("Account Privelege :");
        RegPrivilegesLabel.setVisible(true);

        // Account Privelege List (JComboBox) Decorations.
        final int AgeListLabelLocationX = 450;
        final int AgeListLabelLocationY = 550;
        final int AgeListLabelWidth = 200;
        final int AgeListLabelHeight = 35;

        RegisterBackground.add(AccountPriveleges);
        AccountPriveleges.setBounds(AgeListLabelLocationX, AgeListLabelLocationY, AgeListLabelWidth, AgeListLabelHeight);
        AccountPriveleges.setBackground(new Color(237, 242, 244));
        AccountPriveleges.setForeground(new Color(0, 0, 0));
        AccountPriveleges.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        AccountPriveleges.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Dispatcher","Police Officer"}));

        
        // Registration Back Button (JButton) Decorations.
        
        final int BackButtonLocationX = 20;
        final int BackButtonLocationY = 20;
        final int BackButtonWidth = 100;
        final int BackButtonHeight = 35;

        RegisterBackground.add(RegBackButton);
        RegBackButton.setBounds(BackButtonLocationX, BackButtonLocationY, BackButtonWidth, BackButtonHeight);
        RegBackButton.setBackground(new Color(248, 249, 250));
        RegBackButton.setFont(new Font("Quicksand", Font.PLAIN, 14));
        RegBackButton.setFocusPainted(false);
        RegBackButton.setHorizontalAlignment(SwingConstants.CENTER);
        RegBackButton.setOpaque(false);
        RegBackButton.setForeground(new Color(0, 0, 0));
        RegBackButton.setText("Back");
        RegBackButton.setVisible(true);

        RegBackButton.setContentAreaFilled(true);
        RegBackButton.setBorderPainted(false);
        RegBackButton.setIconTextGap(-2);

        RegBackButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                RegBackButton.setBackground(new Color(0, 0, 0));
                RegBackButton.setForeground(new Color(255, 255, 255));

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                RegBackButton.setBackground(new Color(248, 249, 250));
                RegBackButton.setForeground(new Color(0, 0, 0));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                RegBackButton.setBackground(new Color(150, 150, 150));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                RegBackButton.setBackground(new Color(248, 249, 250));
                RegBackButton.setForeground(new Color(0, 0, 0));
            }

        });

        RegBackButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                RegBackButtonFunction(evt);
            }
        });
        
        // RegBrowseButton (JButton) Decorations.
        final int RegBrowseButtonLocationX = 70;
        final int RegBrowseButtonLocationY = 300;
        final int RegBrowseButtonWidth = 180;
        final int RegBrowseButtonHeight = 35;

        RegisterBackground.add(RegBrowseButton);
        RegBrowseButton.setBounds(RegBrowseButtonLocationX, RegBrowseButtonLocationY, RegBrowseButtonWidth, RegBrowseButtonHeight);
        RegBrowseButton.setBackground(new Color(248, 249, 250));
        RegBrowseButton.setFont(new Font("Quicksand", Font.PLAIN, 14));
        RegBrowseButton.setFocusPainted(false);
        RegBrowseButton.setHorizontalAlignment(SwingConstants.CENTER);
        RegBrowseButton.setOpaque(false);
        RegBrowseButton.setForeground(new Color(0, 0, 0));
        RegBrowseButton.setText("Browse Picture");
        RegBrowseButton.setVisible(true);

        RegBrowseButton.setContentAreaFilled(true);
        RegBrowseButton.setBorderPainted(false);
        RegBrowseButton.setIconTextGap(-2);

        RegBrowseButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                RegBrowseButton.setBackground(new Color(0, 0, 0));
                RegBrowseButton.setForeground(new Color(255, 255, 255));

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                RegBrowseButton.setBackground(new Color(248, 249, 250));
                RegBrowseButton.setForeground(new Color(0, 0, 0));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                RegBrowseButton.setBackground(new Color(150, 150, 150));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                RegBrowseButton.setBackground(new Color(248, 249, 250));
                RegBrowseButton.setForeground(new Color(0, 0, 0));
            }

        });

        RegBrowseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                RegBrowseButtonFunction(evt);
            }
        });
        
        // Create Account (JButton) Decorations.
        final int AddRecordButtonLocationX = 70;
        final int AddRecordButtonLocationY = 350;
        final int AddRecordButtonWidth = 180;
        final int AddRecordButtonHeight = 35;

        RegisterBackground.add(RegCreateAccountButton);
        RegCreateAccountButton.setBounds(AddRecordButtonLocationX, AddRecordButtonLocationY, AddRecordButtonWidth, AddRecordButtonHeight);
        RegCreateAccountButton.setBackground(new Color(248, 249, 250));
        RegCreateAccountButton.setFont(new Font("Quicksand", Font.PLAIN, 14));
        RegCreateAccountButton.setFocusPainted(false);
        RegCreateAccountButton.setHorizontalAlignment(SwingConstants.CENTER);
        RegCreateAccountButton.setOpaque(false);
        RegCreateAccountButton.setForeground(new Color(0, 0, 0));
        RegCreateAccountButton.setText("Add Record");
        RegCreateAccountButton.setVisible(true);

        RegCreateAccountButton.setContentAreaFilled(true);
        RegCreateAccountButton.setBorderPainted(false);
        RegCreateAccountButton.setIconTextGap(-2);

        RegCreateAccountButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                RegCreateAccountButton.setBackground(new Color(0, 0, 0));
                RegCreateAccountButton.setForeground(new Color(255, 255, 255));

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                RegCreateAccountButton.setBackground(new Color(248, 249, 250));
                RegCreateAccountButton.setForeground(new Color(0, 0, 0));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                RegCreateAccountButton.setBackground(new Color(150, 150, 150));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                RegCreateAccountButton.setBackground(new Color(248, 249, 250));
                RegCreateAccountButton.setForeground(new Color(0, 0, 0));
            }

        });

        RegCreateAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                RegCreateAccountButtonFunction(evt);
            }
        });
        
        // Clear Fields Button (JButton) Decorations.
        final int ModifyAccountButtonLocationX = 70;
        final int ModifyAccountButtonLocationY = 400;
        final int ModifyAccountButtonWidth = 180;
        final int ModifyAccountButtonHeight = 35;

        RegisterBackground.add(RegUpdateAccountButton);
        RegUpdateAccountButton.setBounds(ModifyAccountButtonLocationX, ModifyAccountButtonLocationY, ModifyAccountButtonWidth, ModifyAccountButtonHeight);
        RegUpdateAccountButton.setBackground(new Color(248, 249, 250));
        RegUpdateAccountButton.setFont(new Font("Quicksand", Font.PLAIN, 14));
        RegUpdateAccountButton.setFocusPainted(false);
        RegUpdateAccountButton.setHorizontalAlignment(SwingConstants.CENTER);
        RegUpdateAccountButton.setOpaque(false);
        RegUpdateAccountButton.setForeground(new Color(0, 0, 0));
        RegUpdateAccountButton.setText("Update Account");
        RegUpdateAccountButton.setVisible(true);

        RegUpdateAccountButton.setContentAreaFilled(true);
        RegUpdateAccountButton.setBorderPainted(false);
        RegUpdateAccountButton.setIconTextGap(-2);

        RegUpdateAccountButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                RegUpdateAccountButton.setBackground(new Color(0, 0, 0));
                RegUpdateAccountButton.setForeground(new Color(255, 255, 255));

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                RegUpdateAccountButton.setBackground(new Color(248, 249, 250));
                RegUpdateAccountButton.setForeground(new Color(0, 0, 0));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                RegUpdateAccountButton.setBackground(new Color(150, 150, 150));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                RegUpdateAccountButton.setBackground(new Color(248, 249, 250));
                RegUpdateAccountButton.setForeground(new Color(0, 0, 0));
            }

        });

        RegUpdateAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                RegUpdateAccountButtonFunction(evt);
            }
        });
        
        // Delete Button (JButton) Decorations.
        final int DeleteAccountButtonLocationX = 70;
        final int DeleteAccountButtonLocationY = 450;
        final int DeleteAccountButtonWidth = 180;
        final int DeleteAccountButtonHeight = 35;

        RegisterBackground.add(RegDeleteAccountButton);
        RegDeleteAccountButton.setBounds(DeleteAccountButtonLocationX, DeleteAccountButtonLocationY, DeleteAccountButtonWidth, DeleteAccountButtonHeight);
        RegDeleteAccountButton.setBackground(new Color(248, 249, 250));
        RegDeleteAccountButton.setFont(new Font("Quicksand", Font.PLAIN, 14));
        RegDeleteAccountButton.setFocusPainted(false);
        RegDeleteAccountButton.setHorizontalAlignment(SwingConstants.CENTER);
        RegDeleteAccountButton.setOpaque(false);
        RegDeleteAccountButton.setForeground(new Color(0, 0, 0));
        RegDeleteAccountButton.setText("Delete Account");
        RegDeleteAccountButton.setVisible(true);

        RegDeleteAccountButton.setContentAreaFilled(true);
        RegDeleteAccountButton.setBorderPainted(false);
        RegDeleteAccountButton.setIconTextGap(-2);

        RegDeleteAccountButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                RegDeleteAccountButton.setBackground(new Color(0, 0, 0));
                RegDeleteAccountButton.setForeground(new Color(255, 255, 255));

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                RegDeleteAccountButton.setBackground(new Color(248, 249, 250));
                RegDeleteAccountButton.setForeground(new Color(0, 0, 0));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                RegDeleteAccountButton.setBackground(new Color(150, 150, 150));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                RegDeleteAccountButton.setBackground(new Color(248, 249, 250));
                RegDeleteAccountButton.setForeground(new Color(0, 0, 0));
            }

        });

        RegDeleteAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                RegDeleteAccountButtonFunction(evt);
            }
        });
        
        // Clear Fields Button (JButton) Decorations.
        final int ClearFieldsButtonLocationX = 70;
        final int ClearFieldsButtonLocationY = 500;
        final int ClearFieldsButtonWidth = 180;
        final int ClearFieldsButtonHeight = 35;

        RegisterBackground.add(RegClearFieldButton);
        RegClearFieldButton.setBounds(ClearFieldsButtonLocationX, ClearFieldsButtonLocationY, ClearFieldsButtonWidth, ClearFieldsButtonHeight);
        RegClearFieldButton.setBackground(new Color(248, 249, 250));
        RegClearFieldButton.setFont(new Font("Quicksand", Font.PLAIN, 14));
        RegClearFieldButton.setFocusPainted(false);
        RegClearFieldButton.setHorizontalAlignment(SwingConstants.CENTER);
        RegClearFieldButton.setOpaque(false);
        RegClearFieldButton.setForeground(new Color(0, 0, 0));
        RegClearFieldButton.setText("Clear Fields");
        RegClearFieldButton.setVisible(true);

        RegClearFieldButton.setContentAreaFilled(true);
        RegClearFieldButton.setBorderPainted(false);
        RegClearFieldButton.setIconTextGap(-2);

        RegClearFieldButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                RegClearFieldButton.setBackground(new Color(0, 0, 0));
                RegClearFieldButton.setForeground(new Color(255, 255, 255));

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                RegClearFieldButton.setBackground(new Color(248, 249, 250));
                RegClearFieldButton.setForeground(new Color(0, 0, 0));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                RegClearFieldButton.setBackground(new Color(150, 150, 150));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                RegClearFieldButton.setBackground(new Color(248, 249, 250));
                RegClearFieldButton.setForeground(new Color(0, 0, 0));
            }

        });

        RegClearFieldButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                RegClearFieldsButtonFunction(evt);
            }
        });
        
        // List of Records (JTable) Decorations.
        final int AccountListLocationX = 865;
        final int AccountListLocationY = 98;
        final int AccountListWidth = 400;
        final int AccountListListHeight = 440;

        RegisterBackground.add(RegAccountTable);
        RegAccountTable.setBounds(AccountListLocationX, AccountListLocationY, AccountListWidth, AccountListListHeight);
        RegAccountTable.setForeground(new Color(0, 0, 0));
        RegAccountTable.setBackground(new Color(237, 242, 244));
        RegAccountTable.setFont(new Font("Tahoma", 0, 14));
        RegAccountTable.setShowHorizontalLines(true);
        RegAccountTable.setGridColor(Color.BLACK);
        RegAccountTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        RegAccountTable.enableInputMethods(false);
        RegAccountTable.setLayout(null);
        RegAccountTable.setVisible(true);

        RegAccountTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RegAccountTableFunction(evt);
            }
        });

        // List of Records (JScrollpane) Decorations.
        RegisterBackground.add(RegAccountScrollPane);
        RegAccountScrollPane.setBounds(AccountListLocationX, AccountListLocationY, AccountListWidth, AccountListListHeight);
        RegAccountScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        RegAccountScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        RegAccountScrollPane.setViewportBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
        RegAccountScrollPane.setAutoscrolls(true);
        RegAccountScrollPane.setEnabled(true);
        RegAccountScrollPane.setWheelScrollingEnabled(true);
        RegAccountScrollPane.setFocusable(true);
        RegAccountScrollPane.getViewport().add(RegAccountTable);
        
        


        
        pack();
        setLocationRelativeTo(null);
    }
    
    // PRMSRegister CLASS FUNCTIONS
    
    // This Method sets the Back Button function. (Disposes the JFrame Window)
    private void RegBackButtonFunction(ActionEvent evt) {
        
        dispose();
        
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
    
    // This uses a Exception Handling in getting a Picture.
    private void RegBrowseButtonFunction(ActionEvent evt) {
        
        // USER PICTURE 
        JFileChooser pictureChooser = new JFileChooser();
        pictureChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        
        // File Extension
        FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("*Images",".jpg",".png",".gif");
        pictureChooser.addChoosableFileFilter(fileFilter);
        
        int fileState = pictureChooser.showSaveDialog(null);
        
        // USER SELECTED FILE
        if(fileState == JFileChooser.APPROVE_OPTION){
            
            File selectedFile = pictureChooser.getSelectedFile();
            String Path = selectedFile.getAbsolutePath();
            ImagePath = Path;
            
            // FROM HERE, DISPLAY IMAGE IN JLABEL\
            
            RegPolicePicture.setIcon(ResizePicture(Path));
            
        }else if(fileState == JFileChooser.CANCEL_OPTION){
        }
        
    }
    
    /* Gets the data that is stored from the Database and Displays it into the JTable. */
    private void GetDataFromDatabase(){
        
        Connection dbconn = DBConnection.connectDB();
            String sqlQuery = "SELECT * FROM policedatabaseaccounts ";
            if(dbconn != null){
                try {
                    Statement st = (Statement)            
                            dbconn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                            ResultSet rs = st.executeQuery(sqlQuery);
                            RegAccountTable.setModel(DbUtils.resultSetToTableModel(rs));
                            RegAccountTable.getColumnModel().getColumn(0).setPreferredWidth(50);
                            RegAccountTable.getColumnModel().getColumn(1).setPreferredWidth(150);
                            RegAccountTable.getColumnModel().getColumn(2).setPreferredWidth(150);
                            RegAccountTable.getColumnModel().getColumn(3).setPreferredWidth(150);
                            RegAccountTable.getColumnModel().getColumn(4).setPreferredWidth(400);
                            RegAccountTable.getColumnModel().getColumn(5).setPreferredWidth(50);
                            RegAccountTable.getColumnModel().getColumn(6).setPreferredWidth(150);
                            RegAccountTable.getColumnModel().getColumn(7).setPreferredWidth(400);
                            RegAccountTable.getColumnModel().getColumn(8).setPreferredWidth(300);
                            RegAccountTable.getColumnModel().getColumn(9).setPreferredWidth(100);
                            RegAccountTable.getColumnModel().getColumn(10).setPreferredWidth(150);
                            RegAccountTable.getColumnModel().getColumn(11).setPreferredWidth(150);
                            RegAccountTable.getColumnModel().getColumn(12).setPreferredWidth(150);
                            TableColumn tcol = RegAccountTable.getColumnModel().getColumn(12);
                            RegAccountTable.removeColumn(tcol);

                            String header[] = {"ID","FIRST NAME", "MIDDLE NAME", "LAST NAME", "AGE", "CONTACT NUMBER", "ADDRESS", "STATION", "RANK", "USERNAME", "PASSWORD", "ACCOUNT TYPE",""};

                            for(int i=0;i<RegAccountTable.getColumnCount();i++)
                            {
                            TableColumn column1 = RegAccountTable.getTableHeader().getColumnModel().getColumn(i);

                            column1.setHeaderValue(header[i]);
                            } 
                } catch (SQLException ex) {
                Logger.getLogger(PRMSRegister.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                System.out.println("Police Database connection Unavailable! Check your JDBC Connector");
                JOptionPane.showMessageDialog(this, "Police database connection unavailable!\r\n"
                   + "Please Check your JDBC Connector!", "POLICE DATABASE", JOptionPane.INFORMATION_MESSAGE);
        
            }
    }
    
    /* This sets the Function of the "Create Account" JButton where if the JTextfields are empty, the program will show a Dialog box warning the user. 
       that the form is incomplete either because the Fields, Last name, Middle name, First name, Home Address and the ImagePath is null or has no data
       inputted. It is associated with the method "createAccount()" */
    private void RegCreateAccountButtonFunction(ActionEvent evt) {
        
        String fName = RegFNField.getText();
        String mName = RegMNField.getText();
        String lName = RegLNField.getText();
        String userAge = RegAField.getText();
        String conNum = RegCNField.getText();
        String userAddress = RegHAField.getText();
        String polStation = RegSField.getText();
        String polRank = RegRField.getText();
        String username = RegUNField.getText();
        String password = RegPWField.getText();
        if(ImagePath == null){
            
            JOptionPane.showMessageDialog(this, "No picture! Please insert a Picture!");
        }

        if(fName.isEmpty() || mName.isEmpty() || lName.isEmpty() || userAge.isEmpty() 
                || conNum.isEmpty() || userAddress.isEmpty() || polStation.isEmpty() 
                || polRank.isEmpty() || username.isEmpty() || password.isEmpty()){
            
            JOptionPane.showMessageDialog(this, "Form Fill is incomplete! Please Fill up the form properly.", "PRMS DATABASE", JOptionPane.ERROR_MESSAGE);      
        }else if(ImagePath == null){
            JOptionPane.showMessageDialog(this, "You must update user picture to update user account", "PRMS DATABASE", JOptionPane.ERROR_MESSAGE);
        }else{
            try {
                createAccount(fName, mName, lName, userAge, conNum, userAddress, polStation, polRank, username, password);
            } catch (FileNotFoundException | SQLException ex) {
                Logger.getLogger(PRMSRegister.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        GetDataFromDatabase();
        
    }
    
    // Creates a new User Data on the Database based on the user input in the Fields.
    private void createAccount(String fName, String mName, String lName, String userAge, String conNum, 
            String userAddress, String polStation, String polRank, String username, String password) 
            throws FileNotFoundException, SQLException {
        Connection dbconn = DBConnection.connectDB();
        if(dbconn != null){ 
            try {
                PreparedStatement st = (PreparedStatement)
                        dbconn.prepareStatement("INSERT INTO policedatabaseaccounts (firstname, middlename, lastname, age, contactnumber, address, station, rank, username, password, userType, userPicture) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");

                        st.setString(1, fName);
                        st.setString(2, mName);
                        st.setString(3, lName);
                        st.setString(4, userAge);
                        st.setString(5, conNum);
                        st.setString(6, userAddress);
                        st.setString(7, polStation);
                        st.setString(8, polRank);
                        st.setString(9, username);
                        st.setString(10, password);
                        st.setString(11, String.valueOf(AccountPriveleges.getSelectedItem().toString()));

                        InputStream ProfPicture = new FileInputStream(new File(ImagePath));
                        st.setBlob(12, ProfPicture);

                        st.executeUpdate();
                        JOptionPane.showMessageDialog(this, "Success! User Account has been created.", "PRMS DATABASE ", JOptionPane.INFORMATION_MESSAGE);

                        RegFNField.setText("");
                        RegMNField.setText("");
                        RegLNField.setText("");
                        RegAField.setText("");
                        RegCNField.setText("");
                        RegHAField.setText("");
                        RegSField.setText("");
                        RegRField.setText("");
                        RegUNField.setText("");
                        RegPWField.setText("");
                        AccountPriveleges.getSelectedItem().toString();
                        RegPolicePicture.getIcon();

            } catch (SQLException ex) {
                Logger.getLogger(PRMSRegister.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            System.out.println("Police Database connection Unavailable! Check your JDBC Connector");
            JOptionPane.showMessageDialog(this, "Police database connection unavailable!\r\n"
               + "Please Check your JDBC Connector!", "POLICE DATABASE", JOptionPane.INFORMATION_MESSAGE);
        }     
    }
    
    // Updates the User Data on the Database based on the user input in the Fields.
    private void updateAccount(String fName, String mName, String lName, String userAge, String conNum, 
            String userAddress, String polStation, String polRank, String username, String password, String userID) 
            throws FileNotFoundException {
        Connection dbconn = DBConnection.connectDB();
        if(dbconn != null){ 
            try {
                PreparedStatement st = (PreparedStatement)
                        dbconn.prepareStatement("UPDATE policedatabaseaccounts SET firstname=?, middlename=?, lastname=?, age=?, contactnumber=?, address=?, station=?, rank=?, username=?, password=?, userType=?, userPicture=? WHERE id='"+userID+"'");
                
                st.setString(12, userID);
                st.setString(1, fName);
                st.setString(2, mName);
                st.setString(3, lName);
                st.setString(4, userAge);
                st.setString(5, conNum);
                st.setString(6, userAddress);
                st.setString(7, polStation);
                st.setString(8, polRank);
                st.setString(9, username);
                st.setString(10, password);
                st.setString(11, String.valueOf(AccountPriveleges.getSelectedItem().toString()));
                
                InputStream ProfPicture = new FileInputStream(new File(ImagePath));
                st.setBlob(12, ProfPicture);
            
                st.executeUpdate();
                JOptionPane.showMessageDialog(this, "Success! User Account has been Updated!.", "PRMS DATABASE ", JOptionPane.INFORMATION_MESSAGE);
            
                        RegFNField.setText("");
                        RegMNField.setText("");
                        RegLNField.setText("");
                        RegAField.setText("");
                        RegCNField.setText("");
                        RegHAField.setText("");
                        RegSField.setText("");
                        RegRField.setText("");
                        RegUNField.setText("");
                        RegPWField.setText("");
                        AccountPriveleges.getSelectedItem().toString();
                        RegPolicePicture.getIcon();
                
                try {
                    Thread.sleep(1 * 1000);
                } catch (InterruptedException ex) {
                }   
            } catch (SQLException ex) {
                Logger.getLogger(PRMSRegister.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            System.out.println("Police Database connection Unavailable! Check your JDBC Connector");
            JOptionPane.showMessageDialog(this, "Police database connection unavailable!\r\n"
               + "Please Check your JDBC Connector!", "POLICE DATABASE", JOptionPane.INFORMATION_MESSAGE);
        }     
    }
    
    /* This sets the Function of the "Update Account" JButton where if the JTextfields are empty, the program will show a Dialog box warning the user. 
       that the form is incomplete either because the Fields, Last name, Middle name, First name, Home Address and the ImagePath is null or has no data
       inputted. It is associated with the method "updateAccount()" */
    private void RegUpdateAccountButtonFunction(ActionEvent evt) {
        
        String fName = RegFNField.getText();
        String mName = RegMNField.getText();
        String lName = RegLNField.getText();
        String userAge = RegAField.getText();
        String conNum = RegCNField.getText();
        String userAddress = RegHAField.getText();
        String polStation = RegSField.getText();
        String polRank = RegRField.getText();
        String username = RegUNField.getText();
        String password = RegPWField.getText();
        String userID = RegPoliceID.getText();
        
        if(fName.isEmpty() || mName.isEmpty() || lName.isEmpty() || userAge.isEmpty() 
                || conNum.isEmpty() || userAddress.isEmpty() || polStation.isEmpty() 
                || polRank.isEmpty() || username.isEmpty() || password.isEmpty()) {
            
            JOptionPane.showMessageDialog(this, "Form Fill is incomplete! Please Fill up the form properly.", "PRMS DATABASE", JOptionPane.ERROR_MESSAGE);
        }else if(userID.isEmpty()){
            
            JOptionPane.showMessageDialog(this, "The User you are trying to modify did not match any\r\n"
                    + "accounts in our Database. ", "PRMS DATABASE", JOptionPane.ERROR_MESSAGE);
        }else if(ImagePath == null){
            
            JOptionPane.showMessageDialog(this, "You must update user picture to update user account", "PRMS DATABASE", JOptionPane.ERROR_MESSAGE);
        }else{
            try {
                updateAccount(fName, mName, lName, userAge, conNum, userAddress, polStation, polRank, username, password, userID);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(PRMSRegister.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        GetDataFromDatabase();
        
    }
    
    /* This sets the Function of the "Delete Button" JButton where it deletes the selected User in the JTable (RegAccountTableFunction()) and Updates 
       the database.*/
    private void RegDeleteAccountButtonFunction(ActionEvent evt) {
        
        String fName = RegFNField.getText();
        String mName = RegMNField.getText();
        String lName = RegLNField.getText();
        String userAge = RegAField.getText();
        String conNum = RegCNField.getText();
        String userAddress = RegHAField.getText();
        String polStation = RegSField.getText();
        String polRank = RegRField.getText();
        String username = RegUNField.getText();
        String password = RegPWField.getText();
        String userID = RegPoliceID.getText();
        
        if(fName.isEmpty() || mName.isEmpty() || lName.isEmpty() || userAge.isEmpty() 
                || conNum.isEmpty() || userAddress.isEmpty() || polStation.isEmpty() 
                || polRank.isEmpty() || username.isEmpty() || password.isEmpty()) {
            
            JOptionPane.showMessageDialog(this, "You did not select any accounts to be deleted", "PRMS DATABASE", JOptionPane.ERROR_MESSAGE);
        }else if(userID.isEmpty()){
            
            JOptionPane.showMessageDialog(this, "The User you are trying to delete did not match any\r\n"
                    + "accounts in our Database. ", "PRMS DATABASE", JOptionPane.ERROR_MESSAGE);
        }else{
            
            int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this account?","Confirm Deletion",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if(response==JOptionPane.YES_OPTION) {
            Connection conn = DBConnection.connectDB();
            if(conn != null){
                try{
                    PreparedStatement ps = (PreparedStatement) 
                            conn.prepareStatement("DELETE FROM policedatabaseaccounts WHERE id = ?");
                    ps.setInt(1, Integer.parseInt(RegPoliceID.getText()));
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Success! User Accout has been deleted");
                    RegPoliceID.setText("");
                    RegFNField.setText("");
                    RegMNField.setText("");
                    RegLNField.setText("");
                    RegAField.setText("");
                    RegCNField.setText("");
                    RegHAField.setText("");
                    RegSField.setText("");
                    RegRField.setText("");
                    RegUNField.setText("");
                    RegPWField.setText("");
                    AccountPriveleges.getSelectedItem().toString();
                    RegPolicePicture.getIcon();

                } catch (SQLException ex) {
                    Logger.getLogger(PRMSRegister.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                System.out.println("Police Database connection Unavailable! Check your JDBC Connector");
                JOptionPane.showMessageDialog(this, "Police database connection unavailable!\r\n"
                   + "Please Check your JDBC Connector!", "POLICE DATABASE", JOptionPane.INFORMATION_MESSAGE);
            }     
        }else if (response==JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(this, "User cancelled Account Deletion!", "POLICE DATABASE", JOptionPane.INFORMATION_MESSAGE);
        }
        
        GetDataFromDatabase();
        
            
        }
    }
    
    // Clears all of the JTextField and JLabels that are used by the user.
    private void RegClearFieldsButtonFunction(ActionEvent evt) {
        
        RegFNField.setText("");
        RegMNField.setText("");
        RegLNField.setText("");
        RegAField.setText("");
        RegCNField.setText("");
        RegHAField.setText("");
        RegSField.setText("");
        RegRField.setText("");
        RegUNField.setText("");
        RegPWField.setText("");
        
        // RESET Picture
        ImageIcon imageIcon = new ImageIcon("src\\PRMS Files\\icons\\Mugshot180x.png");
        Image imagePicture = imageIcon.getImage();
        Image resizeImage = imagePicture.getScaledInstance(180,180, Image.SCALE_SMOOTH);
        ImageIcon myPicture = new ImageIcon(resizeImage);
        RegPolicePicture.setIcon(myPicture);
        
    }
    
    /* Sets the Function of the JTable where if the user Clicks the data displayed on the Table it will fill up the Forms in the Registration.
       Here the user can Update and Delete Specific data in the Database using the Program.*/
    public void RegAccountTableFunction(MouseEvent evt) {
        
        RegAccountTable.setCellSelectionEnabled(false);
        RegAccountTable.setRowSelectionAllowed(true);

        int number = RegAccountTable.getSelectedRow();
        RegPoliceID.setText(RegAccountTable.getValueAt(number, 0).toString());
        RegFNField.setText(RegAccountTable.getValueAt(number, 1).toString());
        RegMNField.setText(RegAccountTable.getValueAt(number, 2).toString());
        RegLNField.setText(RegAccountTable.getValueAt(number, 3).toString());
        RegAField.setText(RegAccountTable.getValueAt(number, 4).toString());
        RegCNField.setText(RegAccountTable.getValueAt(number, 5).toString());
        RegHAField.setText(RegAccountTable.getValueAt(number, 6).toString());
        RegSField.setText(RegAccountTable.getValueAt(number, 7).toString());
        RegRField.setText(RegAccountTable.getValueAt(number, 8).toString());
        RegUNField.setText(RegAccountTable.getValueAt(number, 9).toString());
        RegPWField.setText(RegAccountTable.getValueAt(number, 10).toString());
        AccountPriveleges.getSelectedItem().toString();
        RegPolicePicture.getIcon();
        Connection conn = DBConnection.connectDB();
        if(conn != null){
            try{
                String username = RegPoliceID.getText();
                PreparedStatement ps = (PreparedStatement) conn.prepareStatement("SELECT userPicture FROM policedatabaseaccounts WHERE id = ?");
                ps.setString(1, username);
                ResultSet rs = ps.executeQuery();
                
                if(rs.next()){
                    byte[] imageBytes = rs.getBytes("userPicture");
                    ImageIcon imageIcon = new ImageIcon(imageBytes);
                    Image imagePicture = imageIcon.getImage();
                    Image resizeImage = imagePicture.getScaledInstance(180,180, Image.SCALE_SMOOTH);
                    ImageIcon myPicture = new ImageIcon(resizeImage);
                    RegPolicePicture.setIcon(myPicture);
                }
            } catch (SQLException ex) {
                Logger.getLogger(PRMSRegister.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            System.out.println("Police Database connection Unavailable! Check your JDBC Connector");
            JOptionPane.showMessageDialog(this, "Police database connection unavailable!\r\n"
               + "Please Check your JDBC Connector!", "POLICE DATABASE", JOptionPane.INFORMATION_MESSAGE);
        }
        
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
