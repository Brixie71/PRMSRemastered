package PRMSClasses;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

public class PMDSLogin extends JFrame {
    
    // Java Swing Components Declarations.
    
    private JPanel loginPane, loginBackground;
    private JLabel loginTitle, personelPicture, usernameText, passwordText, loginPaneBackground;
    private JLabel companyLogo, companyName, cNameShadow, programName, pNameShadow;
    protected JTextField userInput;
    protected JPasswordField passwordInput;
    protected JButton loginButton;
    protected JButton registerButton;

    public PMDSLogin(){
        MainGUIComponents();
    }

    private void MainGUIComponents(){

        // Calling Method for Java Swing Components.

        loginBackground = new JPanel();
        loginPane = new JPanel();

        loginPaneBackground = new JLabel();
        loginTitle = new JLabel();
        personelPicture = new JLabel();
        usernameText = new JLabel();
        passwordText = new JLabel();
        companyLogo = new JLabel();
        companyName = new JLabel();
        cNameShadow = new JLabel();
        programName = new JLabel();
        pNameShadow = new JLabel();

        userInput = new JTextField();
        passwordInput = new JPasswordField();
        loginButton = new JButton();
        registerButton = new JButton();


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
        setTitle("PMDS : Brion Tactical Systems");
        setLayout(null);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // CENTER POPUP MAIN WINDOW.
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dimension.width / 2 - this.getWidth() / 2, dimension.height / 2 - this.getHeight() / 2);

        // Login Pane (JPanel) Declarations.

        final int loginPaneLocationX    = 10;
        final int loginPaneLocationY    = 10;
        final int loginPaneWidth        = 380;
        final int loginPaneHeight       = 470;

        // Login Pane (JPanel) Decoration.

        loginPane.setBounds(loginPaneLocationX, loginPaneLocationY, loginPaneWidth, loginPaneHeight);
        add(loginPane, new AbsoluteConstraints(loginPaneLocationX, loginPaneLocationY, loginPaneWidth, loginPaneHeight));
        loginPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        loginPane.setVisible(true);

            // Login Title (JLabel) Decorations.

            final int loginTitleLocationX   = 161;
            final int loginTitleLocationY   = 20;
            final int loginTitleWidth       = 100;
            final int loginTitleHeight      = 30;

            loginTitle.setBounds(loginTitleLocationX, loginTitleLocationY, loginTitleWidth, loginTitleHeight);
            loginPane.add(loginTitle, new AbsoluteConstraints(loginTitleLocationX, loginTitleLocationY, loginTitleWidth, loginTitleHeight));
            loginTitle.setForeground(new java.awt.Color(255,255,255));
            loginTitle.setFont(new java.awt.Font("Impact", Font.PLAIN, 25));
            loginTitle.setText("LOGIN");
            loginTitle.setVisible(true);

            // Personel Picture (JLabel) Decorations.

            final int personelPictureLocationX = 125;
            final int personelPictureLocationY = 70;
            final int personelPictureWidth     = 130;
            final int personelPictureHeight    = 130;

            personelPicture.setBounds(personelPictureLocationX, personelPictureLocationY, personelPictureWidth, personelPictureHeight);
            loginPane.add(personelPicture, new AbsoluteConstraints(personelPictureLocationX, personelPictureLocationY, personelPictureWidth, personelPictureHeight));
            personelPicture.setBackground(new java.awt.Color(255,255,255));
            personelPicture.setOpaque(true);
            personelPicture.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            personelPicture.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
            personelPicture.setVisible(true);

            ImageIcon findPersonelPicture = new ImageIcon("src\\PRMS Files\\icons\\USER-ICON.png");
            Image importPersonelPicture = findPersonelPicture.getImage();
            Image scalePersonelPicture= importPersonelPicture.getScaledInstance(personelPicture.getWidth(), personelPicture.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon scaledPersonelPicture = new ImageIcon(scalePersonelPicture);
            personelPicture.setIcon(scaledPersonelPicture);

            // Username Text (JLabel) Decorations.

            final int usernameTextLocationX = 30;
            final int usernameTextLocationY = 270;
            final int usernameTextWidth     = 130;
            final int usernameTextHeight    = 35;

            usernameText.setBounds(usernameTextLocationX, usernameTextLocationY, usernameTextWidth, usernameTextHeight);
            loginPane.add(usernameText, new AbsoluteConstraints(usernameTextLocationX, usernameTextLocationY, usernameTextWidth, usernameTextHeight));
            usernameText.setForeground(new java.awt.Color(255,255,255));
            usernameText.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14));
            usernameText.setText("USERNAME  :");
            usernameText.setVisible(true);

            // Username Input (JTextField) Decorations.

            final int userInputLocationX = 120;
            final int userInputLocationY = 270;
            final int userInputWidth     = 225;
            final int userInputHeight    = 35;

            userInput.setBounds(userInputLocationX, userInputLocationY, userInputWidth, userInputHeight);
            loginPane.add(userInput, new AbsoluteConstraints(userInputLocationX, userInputLocationY, userInputWidth, userInputHeight));
            userInput.setBackground(new java.awt.Color(0,0,0,0));
            userInput.setForeground(new java.awt.Color(255,255,255));
            userInput.setOpaque(false);
            userInput.setCaretColor(new java.awt.Color(255,255,255));
            userInput.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255,255,255)));
            userInput.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14));
            userInput.setVisible(true);

            // Password Text (JLabel) Decorations.

            final int passwordTextLocationX = 30;
            final int passwordTextLocationY = 320;
            final int passwordTextWidth     = 130;
            final int passwordTextHeight    = 35;

            passwordText.setBounds(passwordTextLocationX, passwordTextLocationY, passwordTextWidth, passwordTextHeight);
            loginPane.add(passwordText, new AbsoluteConstraints(passwordTextLocationX, passwordTextLocationY, passwordTextWidth, passwordTextHeight));
            passwordText.setForeground(new java.awt.Color(255,255,255));
            passwordText.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14));
            passwordText.setText("PASSWORD :");
            passwordText.setVisible(true);

            // Password Input (JPasswordField) Decorations.

            final int passwordInputLocationX = 120;
            final int passwordInputLocationY = 320;
            final int passwordInputWidth     = 225;
            final int passwordInputHeight    = 35;

            passwordInput.setBounds(passwordInputLocationX, passwordInputLocationY, passwordInputWidth, passwordInputHeight);
            loginPane.add(passwordInput, new AbsoluteConstraints(passwordInputLocationX, passwordInputLocationY, passwordInputWidth, passwordInputHeight));
            passwordInput.setBackground(new java.awt.Color(0,0,0,0));
            passwordInput.setOpaque(false);
            passwordInput.setForeground(new java.awt.Color(255,255,255));
            passwordInput.setCaretColor(new java.awt.Color(255,255,255));
            passwordInput.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255,255,255)));
            passwordInput.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14));
            passwordInput.setVisible(true);

            // Login Button (JButton) Declarations.

            final int loginButtonLocationX = 230;
            final int loginButtonLocationY = 380;
            final int loginButtonWidth     = 100;
            final int loginButtonHeight    = 40;

            // Login Button (JButton) Decorations.

            loginButton.setBounds(loginButtonLocationX, loginButtonLocationY, loginButtonWidth, loginButtonHeight);
            loginPane.add(loginButton, new AbsoluteConstraints(loginButtonLocationX, loginButtonLocationY, loginButtonWidth, loginButtonHeight));
            loginButton.setBackground(new java.awt.Color(248, 249, 250));
            loginButton.setFont(new java.awt.Font("Impact", Font.PLAIN, 16));
            loginButton.setFocusPainted(false);
            loginButton.setHorizontalAlignment(SwingConstants.TRAILING);
            loginButton.setOpaque(false);
            loginButton.setForeground(new java.awt.Color(0,0,0));
            loginButton.setText("LOGIN");
            loginButton.setVisible(true);

            loginButton.setContentAreaFilled(true);
            loginButton.setBorderPainted(false);
            loginButton.setIconTextGap(-2);

            loginButton.addMouseListener(new MouseAdapter(){

            @Override
            public void mousePressed(MouseEvent e) {
                loginButton.setBackground(new java.awt.Color(0, 0, 0));
                loginButton.setForeground(new java.awt.Color(255,255,255));
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                loginButton.setBackground(new java.awt.Color(248, 249, 250));
                loginButton.setForeground(new java.awt.Color(0,0,0));
            }

            @Override
            public void mouseEntered(MouseEvent e){
                loginButton.setBackground(new java.awt.Color(150,150,150));
            }

            @Override
            public void mouseExited(MouseEvent e){
                loginButton.setBackground(new java.awt.Color(248, 249, 250));
                loginButton.setForeground(new java.awt.Color(0,0,0));
            }

            });
            
            // Register Button (JButton) Declarations.

            final int registerButtonLocationX = 50;
            final int registerButtonLocationY = 380;
            final int registerButtonWidth     = 120;
            final int registerButtonHeight    = 40;

            // Register Button (JButton) Decorations.

            registerButton.setBounds(registerButtonLocationX, registerButtonLocationY, registerButtonWidth, registerButtonHeight);
            loginPane.add(registerButton, new AbsoluteConstraints(registerButtonLocationX, registerButtonLocationY, registerButtonWidth, registerButtonHeight));
            registerButton.setBackground(new java.awt.Color(248, 249, 250));
            registerButton.setFont(new java.awt.Font("Impact", Font.PLAIN, 16));
            registerButton.setFocusPainted(false);
            registerButton.setHorizontalAlignment(SwingConstants.TRAILING);

            registerButton.setOpaque(false);
            registerButton.setForeground(new java.awt.Color(0,0,0));
            registerButton.setText("REGISTER");
            registerButton.setVisible(true);

            registerButton.setContentAreaFilled(true);
            registerButton.setBorderPainted(false);
            registerButton.setIconTextGap(-2);

            registerButton.addMouseListener(new MouseAdapter(){

                    @Override
                    public void mousePressed(MouseEvent e) {
                        registerButton.setBackground(new java.awt.Color(0, 0, 0));
                        registerButton.setForeground(new java.awt.Color(255,255,255));

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        registerButton.setBackground(new java.awt.Color(248, 249, 250));
                        registerButton.setForeground(new java.awt.Color(0,0,0));
                    }

                    @Override
                    public void mouseEntered(MouseEvent e){

                        registerButton.setBackground(new java.awt.Color(150,150,150));
                    }

                    @Override
                    public void mouseExited(MouseEvent e){
                        registerButton.setBackground(new java.awt.Color(248, 249, 250));
                        registerButton.setForeground(new java.awt.Color(0,0,0));
                    }

                });

                // Login Pane Background (JLabel) Decorations.

                final int loginPaneBackgroundLocationX  = 0;
                final int loginPaneBackgroundLocationY  = 0;
                final int loginPaneBackgroundWidth      = 380;
                final int loginPaneBackgroundHeight     = 470;

                loginPaneBackground.setBounds(loginPaneBackgroundLocationX, loginPaneBackgroundLocationY, loginPaneBackgroundWidth, loginPaneBackgroundHeight);
                loginPane.add(loginPaneBackground, new AbsoluteConstraints(loginPaneBackgroundLocationX, loginPaneBackgroundLocationY, loginPaneBackgroundWidth, loginPaneBackgroundHeight));
                loginPaneBackground.setBackground(null);
                loginPaneBackground.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, false));
                loginPaneBackground.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                loginPaneBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
                loginPaneBackground.setVisible(true);

                ImageIcon icon = new ImageIcon("src\\PRMS Files\\backgrounds\\carbonbackground.jpg");
                Image homeBackground = icon.getImage();
                Image imgScale = homeBackground.getScaledInstance(loginPaneBackground.getWidth(), loginPaneBackground.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon scaledIcon = new ImageIcon(imgScale);
                loginPaneBackground.setIcon(scaledIcon);



        // Company Logo (JLabel) Decorations.

        final int companyLogoLocationX = 415;
        final int companyLogoLocationY = 40;
        final int companyLogoWidth = 370;
        final int companyLogoHeight = 370;

        companyLogo.setBounds(companyLogoLocationX, companyLogoLocationY, companyLogoWidth, companyLogoHeight);
        add(companyLogo, new AbsoluteConstraints(companyLogoLocationX, companyLogoLocationY, companyLogoWidth, companyLogoHeight));
        companyLogo.setBackground(null);
        companyLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        companyLogo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        companyLogo.setVisible(true);

        ImageIcon findLogo = new ImageIcon("src\\PRMS Files\\logo\\BTSLogo1.png");
        Image importLogo = findLogo.getImage();
        Image scaleLogo = importLogo.getScaledInstance(companyLogo.getWidth(), companyLogo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledLogo = new ImageIcon(scaleLogo);
        companyLogo.setIcon(scaledLogo);

        // Company Name (JLabel) Decorations.
        Font IronShark;

        final int companyNameLocationX = 410;
        final int companyNameLocationY = 315;
        final int companyNameWidth = 380;
        final int companyNameHeight = 30;

        final int cNameShadowLocationY = 320;

        companyName.setBounds(companyNameLocationX, companyNameLocationY, companyNameWidth, companyNameHeight);
        add(companyName, new AbsoluteConstraints(companyNameLocationX, companyNameLocationY, companyNameWidth, companyNameHeight));
        companyName.setForeground(new java.awt.Color(255, 208, 0));
        companyName.setFont(new java.awt.Font("Iron Shark", Font.PLAIN, 18));

        cNameShadow.setBounds(companyNameLocationX, cNameShadowLocationY, companyNameWidth, companyNameHeight);
        add(cNameShadow, new AbsoluteConstraints(companyNameLocationX, cNameShadowLocationY, companyNameWidth, companyNameHeight));
        cNameShadow.setForeground(new java.awt.Color(0, 0, 0));
        cNameShadow.setFont(new java.awt.Font("Iron Shark", Font.PLAIN, 18));

        try {

            IronShark = Font.createFont(Font.TRUETYPE_FONT, new File("src\\PRMS Files\\fonts\\Iron-Shark.ttf")).deriveFont(18f);
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

        final int programNameLocationX = 410;
        final int programNameLocationY = 350;
        final int programNameWidth = 370;
        final int programNameHeight = 30;

        final int pNameShadowLocationY = 355;

        // Program Name (JLabel) Declarations.

        programName.setBounds(programNameLocationX, programNameLocationY, programNameWidth, programNameHeight);
        add(programName, new AbsoluteConstraints(programNameLocationX, programNameLocationY, programNameWidth, programNameHeight));
        programName.setForeground(new java.awt.Color(255, 255, 255));
        programName.setFont(new java.awt.Font("Impact", Font.PLAIN, 18));

        pNameShadow.setBounds(programNameLocationX, pNameShadowLocationY, programNameWidth, programNameHeight);
        add(pNameShadow, new AbsoluteConstraints(programNameLocationX, pNameShadowLocationY, programNameWidth, programNameHeight));
        pNameShadow.setForeground(new java.awt.Color(0, 0, 0));
        pNameShadow.setFont(new java.awt.Font("Impact", Font.PLAIN, 18));

        programName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        programName.setText("POLICE MOBILE AND DISPATCH SYSTEM");
        programName.setVisible(true);

        pNameShadow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pNameShadow.setText("POLICE MOBILE AND DISPATCH SYSTEM");
        pNameShadow.setVisible(true);

        // Login Background (JPanel) Decorations.

        final int loginBackgroundLocationX  = 0;
        final int loginBackgroundLocationY  = 0;
        final int loginBackgroundWidth      = 800;
        final int lofinBackgroundHeigth     = 490;

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
    
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PMDSLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }/*/ /*/
        
        PMDSLogin Open = new PMDSLogin();
        Open.setVisible(true);
    }
}
