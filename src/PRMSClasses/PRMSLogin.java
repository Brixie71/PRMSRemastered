package PRMSClasses;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

public class PRMSLogin extends JFrame {
    
    public PRMSLogin(){
        MainGUIComponents();
    }
    
    private void MainGUIComponents(){
        
        // JFrame Declaration
        final int FrameSizeX = 800;
        final int FrameSizeY = 490;

        //JFrame Size.
        setSize(FrameSizeX, FrameSizeY);
        setMinimumSize(new java.awt.Dimension(FrameSizeX, FrameSizeY));
        setPreferredSize(new java.awt.Dimension(FrameSizeX, FrameSizeY));

        //JFrame Decoration.
        setUndecorated(true);
        setOpacity(1.0f);
        setTitle("PRMS : Brion Tactical Systems");
        setLayout(null);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // CENTER POPUP MAIN WINDOW.
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dimension.width / 2 - this.getWidth() / 2, dimension.height / 2 - this.getHeight() / 2);
        
        // Login Pane (JPanel) Declarations.
        
        final int loginPaneLocationX    = 10;
        final int loginPaneLocationY    = 10;
        final int loginPaneWidth        = 380;
        final int loginPaneHeight       = 470;
        
        JPanel loginPane = new JPanel();
        
        // Login Pane (JPanel) Decoration.
        
        loginPane.setBounds(loginPaneLocationX, loginPaneLocationY, loginPaneWidth, loginPaneHeight);
        add(loginPane, new AbsoluteConstraints(loginPaneLocationX, loginPaneLocationY, loginPaneWidth, loginPaneHeight));
        loginPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        loginPane.setVisible(true);
        
            // Login Title (JLabel) Declarations.

            final int loginTitleLocationX   = 161;
            final int loginTitleLocationY   = 20;
            final int loginTitleWidth       = 100;
            final int loginTitleHeight      = 30;

            JLabel loginTitle = new JLabel();

            // Login Title (JLabel) Decorations.

            loginTitle.setBounds(loginTitleLocationX, loginTitleLocationY, loginTitleWidth, loginTitleHeight);
            loginPane.add(loginTitle, new AbsoluteConstraints(loginTitleLocationX, loginTitleLocationY, loginTitleWidth, loginTitleHeight));
            loginTitle.setForeground(new java.awt.Color(255,255,255));
            loginTitle.setFont(new java.awt.Font("Impact", 0, 25));
            loginTitle.setText("LOGIN");
            loginTitle.setVisible(true);
            
            // Personel Picture (JLabel) Declarations.
            
            final int personelPictureLocationX = 125;
            final int personelPictureLocationY = 70;
            final int personelPictureWidth     = 130;
            final int personelPictureHeight    = 130;
            
            JLabel personelPicture = new JLabel();
            
            // Personel Picture (JLabel) Decorations.
            personelPicture.setBounds(personelPictureLocationX, personelPictureLocationY, personelPictureWidth, personelPictureHeight);
            loginPane.add(personelPicture, new AbsoluteConstraints(personelPictureLocationX, personelPictureLocationY, personelPictureWidth, personelPictureHeight));
            personelPicture.setBackground(new java.awt.Color(255,255,255));
            personelPicture.setOpaque(true);
            personelPicture.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            personelPicture.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
            personelPicture.setVisible(true);

            ImageIcon findPersonelPicture = new ImageIcon("src\\res\\icons8_user_130px_1.png");
            Image importPersonelPicture = findPersonelPicture.getImage();
            Image scalePersonelPicture= importPersonelPicture.getScaledInstance(personelPicture.getWidth(), personelPicture.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon scaledPersonelPicture = new ImageIcon(scalePersonelPicture);
            personelPicture.setIcon(scaledPersonelPicture);
            
            // Username Text (JLabel) Declarations.
            
            final int usernameTextLocationX = 30;
            final int usernameTextLocationY = 270;
            final int usernameTextWidth     = 130;
            final int usernameTextHeight    = 35;
            
            JLabel usernameText = new JLabel();
            
            // Username Text (JLabel) Decorations.
            
            usernameText.setBounds(usernameTextLocationX, usernameTextLocationY, usernameTextWidth, usernameTextHeight);
            loginPane.add(usernameText, new AbsoluteConstraints(usernameTextLocationX, usernameTextLocationY, usernameTextWidth, usernameTextHeight));
            usernameText.setForeground(new java.awt.Color(255,255,255));
            usernameText.setFont(new java.awt.Font("Tahoma", 0, 14));
            usernameText.setText("USERNAME  :");
            usernameText.setVisible(true);
            
            // Username Input (JTextField) Declarations.
            
            final int userInputLocationX = 120;
            final int userInputLocationY = 270;
            final int userInputWidth     = 225;
            final int userInputHeight    = 35;
            
            JTextField userInput = new JTextField();
            
            // Username Input (JTextField).
            
            userInput.setBounds(userInputLocationX, userInputLocationY, userInputWidth, userInputHeight);
            loginPane.add(userInput, new AbsoluteConstraints(userInputLocationX, userInputLocationY, userInputWidth, userInputHeight));
            userInput.setForeground(new java.awt.Color(255,255,255));
            userInput.setOpaque(false);
            userInput.setCaretColor(new java.awt.Color(255,255,255));
            userInput.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255,255,255)));
            userInput.setFont(new java.awt.Font("Tahoma", 0, 14));
            userInput.setVisible(true);
            
            // Password Text (JLabel) Declarations.
            
            final int passwordTextLocationX = 30;
            final int passwordTextLocationY = 320;
            final int passwordTextWidth     = 130;
            final int passwordTextHeight    = 35;
            
            JLabel passwordText = new JLabel();
            
            // Password Text (JLabel) Decorations.
            
            passwordText.setBounds(passwordTextLocationX, passwordTextLocationY, passwordTextWidth, passwordTextHeight);
            loginPane.add(passwordText, new AbsoluteConstraints(passwordTextLocationX, passwordTextLocationY, passwordTextWidth, passwordTextHeight));
            passwordText.setForeground(new java.awt.Color(255,255,255));
            passwordText.setFont(new java.awt.Font("Tahoma", 0, 14));
            passwordText.setText("PASSWORD :");
            passwordText.setVisible(true);
            
            // Password Input (JPasswordField) Declarations.
            
            final int passwordInputLocationX = 120;
            final int passwordInputLocationY = 320;
            final int passwordInputWidth     = 225;
            final int passwordInputHeight    = 35;
            
            JPasswordField passwordInput = new JPasswordField();
            
            // Password Input (JPasswordField) Decorations.
            
            passwordInput.setBounds(passwordInputLocationX, passwordInputLocationY, passwordInputWidth, passwordInputHeight);
            loginPane.add(passwordInput, new AbsoluteConstraints(passwordInputLocationX, passwordInputLocationY, passwordInputWidth, passwordInputHeight));
            passwordInput.setForeground(new java.awt.Color(255,255,255));
            passwordInput.setOpaque(false);
            passwordInput.setCaretColor(new java.awt.Color(255,255,255));
            passwordInput.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255,255,255)));
            passwordInput.setFont(new java.awt.Font("Tahoma", 0, 14));
            passwordInput.setVisible(true);
            
            // Login Button (JButton) Declarations.
            
            final int loginButtonLocationX = 230;
            final int loginButtonLocationY = 380;
            final int loginButtonWidth     = 100;
            final int loginButtonHeight    = 40;
            
            JButton loginButton = new JButton();
            
            // Login Button (JButton) Decorations.
            
            loginButton.setBounds(loginButtonLocationX, loginButtonLocationY, loginButtonWidth, loginButtonHeight);
            loginPane.add(loginButton, new AbsoluteConstraints(loginButtonLocationX, loginButtonLocationY, loginButtonWidth, loginButtonHeight));
            loginButton.setBackground(new java.awt.Color(237, 242, 244));
            loginButton.setFont(new java.awt.Font("Impact", 0, 16));
            loginButton.setDefaultCapable(false);
            loginButton.setDoubleBuffered(true);
            loginButton.setFocusPainted(false);
            loginButton.setRolloverEnabled(true);
            loginButton.setRequestFocusEnabled(true);
            loginButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            loginButton.setHorizontalTextPosition(javax.swing.SwingConstants.TRAILING);
            loginButton.setForeground(new java.awt.Color(0,0,0));
            loginButton.setText("LOGIN");
            loginButton.setVisible(true);
            
            
            
                // Login Pane Background (JLabel) Declarations.

                final int loginPaneBackgroundLocationX  = 0;
                final int loginPaneBackgroundLocationY  = 0;
                final int loginPaneBackgroundWidth      = 380;
                final int loginPaneBackgroundHeight     = 470;

                JLabel loginPaneBackground = new JLabel();

                // Login Pane Background (JLabel) Decorations.

                loginPaneBackground.setBounds(loginPaneBackgroundLocationX, loginPaneBackgroundLocationY, loginPaneBackgroundWidth, loginPaneBackgroundHeight);
                loginPane.add(loginPaneBackground, new AbsoluteConstraints(loginPaneBackgroundLocationX, loginPaneBackgroundLocationY, loginPaneBackgroundWidth, loginPaneBackgroundHeight));
                loginPaneBackground.setBackground(null);
                loginPaneBackground.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, false));
                loginPaneBackground.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                loginPaneBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
                loginPaneBackground.setVisible(true);

                ImageIcon icon = new ImageIcon("src\\res\\carbonbackground.jpg");
                Image homeBackground = icon.getImage();
                Image imgScale = homeBackground.getScaledInstance(loginPaneBackground.getWidth(), loginPaneBackground.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon scaledIcon = new ImageIcon(imgScale);
                loginPaneBackground.setIcon(scaledIcon);
                
        
      
        
        // Company Logo (JLabel) Declarations.
        
        final int companyLogoLocationX = 415;
        final int companyLogoLocationY = 40;
        final int companyLogoWidth = 370;
        final int companyLogoHeight = 370;
        
        JLabel companyLogo = new JLabel();
        
        // Company Logo (JLabel) Decorations.
        
        companyLogo.setBounds(companyLogoLocationX, companyLogoLocationY, companyLogoWidth, companyLogoHeight);
        add(companyLogo, new AbsoluteConstraints(companyLogoLocationX, companyLogoLocationY, companyLogoWidth, companyLogoHeight));
        companyLogo.setBackground(null);
        companyLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        companyLogo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        companyLogo.setVisible(true);
        
        ImageIcon findLogo = new ImageIcon("src\\res\\Brion Technological Systems3.png");
        Image importLogo = findLogo.getImage();
        Image scaleLogo = importLogo.getScaledInstance(companyLogo.getWidth(), companyLogo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledLogo = new ImageIcon(scaleLogo);
        companyLogo.setIcon(scaledLogo);
        
        // Company Name (JLabel) Declarations.
        Font IronShark;

        final int companyNameLocationX = 410;
        final int companyNameLocationY = 315;
        final int companyNameWidth = 380;
        final int companyNameHeight = 30;
        
        JLabel companyName = new JLabel();

        final int cNameShadowLocationY = 320;

        JLabel cNameShadow = new JLabel();
        
        // Company Name (JLabel) Declarations.

        companyName.setBounds(companyNameLocationX, companyNameLocationY, companyNameWidth, companyNameHeight);
        add(companyName, new AbsoluteConstraints(companyNameLocationX, companyNameLocationY, companyNameWidth, companyNameHeight));
        companyName.setForeground(new java.awt.Color(255, 208, 0));
        companyName.setFont(new java.awt.Font("Iron Shark", 0, 18));

        cNameShadow.setBounds(companyNameLocationX, cNameShadowLocationY, companyNameWidth, companyNameHeight);
        add(cNameShadow, new AbsoluteConstraints(companyNameLocationX, cNameShadowLocationY, companyNameWidth, companyNameHeight));
        cNameShadow.setForeground(new java.awt.Color(0, 0, 0));
        cNameShadow.setFont(new java.awt.Font("Iron Shark", 0, 18));

        try {

            IronShark = Font.createFont(Font.TRUETYPE_FONT, new File("src\\res\\Iron-Shark.ttf")).deriveFont(18f);
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

        final int programNameLocationX = 410;
        final int programNameLocationY = 350;
        final int programNameWidth = 370;
        final int programNameHeight = 30;
        
        JLabel programName = new JLabel();

        final int pNameShadowLocationY = 355;

        JLabel pNameShadow = new JLabel();
        
        // Program Name (JLabel) Declarations.

        programName.setBounds(programNameLocationX, programNameLocationY, programNameWidth, programNameHeight);
        add(programName, new AbsoluteConstraints(programNameLocationX, programNameLocationY, programNameWidth, programNameHeight));
        programName.setForeground(new java.awt.Color(255, 255, 255));
        programName.setFont(new java.awt.Font("Impact", 0, 18));

        pNameShadow.setBounds(programNameLocationX, pNameShadowLocationY, programNameWidth, programNameHeight);
        add(pNameShadow, new AbsoluteConstraints(programNameLocationX, pNameShadowLocationY, programNameWidth, programNameHeight));
        pNameShadow.setForeground(new java.awt.Color(0, 0, 0));
        pNameShadow.setFont(new java.awt.Font("Impact", 0, 18));

        programName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        programName.setText("POLICE RECORD MANAGEMENT SYSTEM");
        programName.setVisible(true);

        pNameShadow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pNameShadow.setText("POLICE RECORD MANAGEMENT SYSTEM");
        pNameShadow.setVisible(true);
        
        // Login Background (JPanel) Declaration.
        
        final int loginBackgroundLocationX  = 0;
        final int loginBackgroundLocationY  = 0;
        final int loginBackgroundWidth      = 800;
        final int lofinBackgroundHeigth     = 490;
        
        JPanel loginBackground = new JPanel();
        
        // Login Background (JPanel) Decorations.
        
        loginBackground.setBounds(loginBackgroundLocationX, loginBackgroundLocationY, loginBackgroundWidth, lofinBackgroundHeigth);
        add(loginBackground, new AbsoluteConstraints(loginBackgroundLocationX, loginBackgroundLocationY, loginBackgroundWidth, lofinBackgroundHeigth));
        loginBackground.setBackground(new java.awt.Color(0, 0, 50));
        loginBackground.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 200, 0), 1, false));
        loginBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        loginBackground.setVisible(true);
        
        // Login Frame dragging Declaration.
        loginBackground.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                loginBackgroundMouseDragged(evt);
            }
        });

        loginBackground.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                loginBackgroundMousePressed(evt);
            }
        });
        
        
        
        pack();
        setLocationRelativeTo(null);
    }
    
    // FRAME DRAGGER
    int xMouse;
    int yMouse;

    private void loginBackgroundMouseDragged(java.awt.event.MouseEvent evt) {
        // JFRAME DRAGGER
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xMouse, y - yMouse);
    }

    private void loginBackgroundMousePressed(java.awt.event.MouseEvent evt) {
        // JFRAME DRAGGER PART 2
        xMouse = evt.getX();
        yMouse = evt.getY();
    }
    
    public static void main(String[] args) {
        PRMSLogin Open = new PRMSLogin();
        Open.setVisible(true);
    }
    
}
