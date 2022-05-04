package PRMSClasses;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class PRMSLogin extends JFrame {
    
    // Java Swing Components Declarations.
    
    JPanel loginPane, loginBackground;
    JLabel loginTitle, personelPicture, usernameText, passwordText, loginPaneBackground,
           companyLogo, companyName, cNameShadow, programName, pNameShadow;
           
    JTextField userInput;
    JPasswordField passwordInput;
    JButton loginButton, registerButton, exit;
    static JButton minimize;
    
    static Font IronShark, Quicksand, Gepestev;
    
    // FRAME DRAGGER
        int xMouse;
        int yMouse;

    public PRMSLogin(){
        PRMSLoginComponents();
        
    }
    
    private void PRMSLoginComponents(){

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
            exit = new JButton();
            minimize = new JButton();


        // JFrame Declaration
            final int FrameSizeX = 800;
            final int FrameSizeY = 490;

        //JFrame Size.
            setSize(FrameSizeX, FrameSizeY);
            setMinimumSize(new Dimension(FrameSizeX, FrameSizeY));
            setPreferredSize(new Dimension(FrameSizeX, FrameSizeY));

        //JFrame Decoration.
            setUndecorated(true);
            setOpacity(1.0f);
            setTitle("PRMS : Brion Tactical Systems - Login");
            setLayout(null);
            setResizable(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // CENTER POPUP MAIN WINDOW.
            Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
            setLocation(dimension.width / 2 - this.getWidth() / 2, dimension.height / 2 - this.getHeight() / 2);
           
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

        // Login Box Group (JPanel) Decoration.

            final int loginPaneLocationX    = 10;
            final int loginPaneLocationY    = 1;
            final int loginPaneWidth        = 380;
            final int loginPaneHeight       = 488;

            add(loginPane);
            loginPane.setBounds(loginPaneLocationX, loginPaneLocationY, loginPaneWidth, loginPaneHeight);
            loginPane.setBackground(new Color(10, 10, 10));
            loginPane.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, new Color(255,208,0)));
            loginPane.setLayout(null);
            loginPane.setVisible(true);

            // Login Title (JLabel) Decorations.

                final int loginTitleLocationX   = 161;
                final int loginTitleLocationY   = 20;
                final int loginTitleWidth       = 100;
                final int loginTitleHeight      = 30;

                loginPane.add(loginTitle);
                loginTitle.setBounds(loginTitleLocationX, loginTitleLocationY, loginTitleWidth, loginTitleHeight);
                loginTitle.setForeground(new Color(255,255,255));
                loginTitle.setFont(new Font("Gepestev", Font.PLAIN, 25));
                loginTitle.setText("LOGIN");
                loginTitle.setVisible(true);

            // Personel Picture (JLabel) Decorations.

                final int personelPictureLocationX = 125;
                final int personelPictureLocationY = 70;
                final int personelPictureWidth     = 130;
                final int personelPictureHeight    = 130;

                loginPane.add(personelPicture);
                personelPicture.setBounds(personelPictureLocationX, personelPictureLocationY, personelPictureWidth, personelPictureHeight);
                personelPicture.setBackground(new Color(255,255,255));
                personelPicture.setOpaque(true);
                personelPicture.setHorizontalAlignment(SwingConstants.CENTER);
                personelPicture.setLayout(null);
                personelPicture.setVisible(true);

                ImageIcon findPersonelPicture = new ImageIcon("src\\PRMS Files\\icons\\USER-ICON.png");
                Image importPersonelPicture = findPersonelPicture.getImage();
                Image scalePersonelPicture= importPersonelPicture.getScaledInstance(personelPicture.getWidth(), personelPicture.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon scaledPersonelPicture = new ImageIcon(scalePersonelPicture);
                personelPicture.setIcon(scaledPersonelPicture);

            // Username Text (JLabel) Decorations.

                final int usernameTextLocationX = 28;
                final int usernameTextLocationY = 270;
                final int usernameTextWidth     = 130;
                final int usernameTextHeight    = 35;

                loginPane.add(usernameText);
                usernameText.setBounds(usernameTextLocationX, usernameTextLocationY, usernameTextWidth, usernameTextHeight);
                usernameText.setForeground(new Color(255,255,255));
                usernameText.setFont(new Font("Quicksand", Font.PLAIN, 14));
                usernameText.setText("USERNAME  :");
                usernameText.setVisible(true);

            // Username Input (JTextField) Decorations.

                final int userInputLocationX = 122;
                final int userInputLocationY = 270;
                final int userInputWidth     = 225;
                final int userInputHeight    = 35;

                loginPane.add(userInput);
                userInput.setBounds(userInputLocationX, userInputLocationY, userInputWidth, userInputHeight);
                userInput.setBackground(new Color(0,0,0,0));
                userInput.setForeground(new Color(255,255,255));
                userInput.setOpaque(false);
                userInput.setCaretColor(new java.awt.Color(255,255,255));
                userInput.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(255,255,255)));
                userInput.setFont(new Font("Quicksand", Font.PLAIN, 14));
                userInput.setVisible(true);

            // Password Text (JLabel) Decorations.

                final int passwordTextLocationX = 28;
                final int passwordTextLocationY = 320;
                final int passwordTextWidth     = 130;
                final int passwordTextHeight    = 35;

                loginPane.add(passwordText);
                passwordText.setBounds(passwordTextLocationX, passwordTextLocationY, passwordTextWidth, passwordTextHeight);
                passwordText.setForeground(new Color(255,255,255));
                passwordText.setFont(new Font("Quicksand", Font.PLAIN, 14));
                passwordText.setText("PASSWORD :");
                passwordText.setVisible(true);

            // Password Input (JPasswordField) Decorations.

                final int passwordInputLocationX = 122;
                final int passwordInputLocationY = 320;
                final int passwordInputWidth     = 225;
                final int passwordInputHeight    = 35;

                loginPane.add(passwordInput);
                passwordInput.setBounds(passwordInputLocationX, passwordInputLocationY, passwordInputWidth, passwordInputHeight);
                passwordInput.setBackground(new Color(0,0,0,0));
                passwordInput.setOpaque(false);
                passwordInput.setForeground(new Color(255,255,255));
                passwordInput.setCaretColor(new Color(255,255,255));
                passwordInput.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(255,255,255)));
                passwordInput.setFont(new Font("Quicksand", Font.PLAIN, 14));
                passwordInput.setVisible(true);

            // Login Button (JButton) Decorations.

                final int loginButtonLocationX = 230;
                final int loginButtonLocationY = 380;
                final int loginButtonWidth     = 100;
                final int loginButtonHeight    = 40;

                loginPane.add(loginButton);
                loginButton.setBounds(loginButtonLocationX, loginButtonLocationY, loginButtonWidth, loginButtonHeight);
                loginButton.setBackground(new Color(248, 249, 250));
                loginButton.setFont(new Font("Quicksand", Font.PLAIN, 16));
                loginButton.setFocusPainted(false);
                loginButton.setHorizontalAlignment(SwingConstants.CENTER);
                loginButton.setOpaque(false);
                loginButton.setForeground(new Color(0,0,0));
                loginButton.setText("LOGIN");
                loginButton.setVisible(true);

                loginButton.setContentAreaFilled(true);
                loginButton.setBorderPainted(false);
                loginButton.setIconTextGap(-2);

                loginButton.addMouseListener(new MouseAdapter(){

                        @Override
                        public void mousePressed(MouseEvent e) {
                            loginButton.setBackground(new Color(0, 0, 0));
                            loginButton.setForeground(new Color(255,255,255));

                        }

                        @Override
                        public void mouseReleased(MouseEvent e) {
                            loginButton.setBackground(new Color(248, 249, 250));
                            loginButton.setForeground(new Color(0,0,0));
                        }

                        @Override
                        public void mouseEntered(MouseEvent e){
                            loginButton.setBackground(new Color(150,150,150));
                        }

                        @Override
                        public void mouseExited(MouseEvent e){
                            loginButton.setBackground(new Color(248, 249, 250));
                            loginButton.setForeground(new Color(0,0,0));
                        }

                });
            
            // Register Button (JButton) Decorations.

                final int registerButtonLocationX = 50;
                final int registerButtonLocationY = 380;
                final int registerButtonWidth     = 120;
                final int registerButtonHeight    = 40;

                loginPane.add(registerButton);
                registerButton.setBounds(registerButtonLocationX, registerButtonLocationY, registerButtonWidth, registerButtonHeight);
                registerButton.setBackground(new Color(248, 249, 250));
                registerButton.setFont(new Font("Quicksand", Font.PLAIN, 16));
                registerButton.setFocusPainted(false);
                registerButton.setHorizontalAlignment(SwingConstants.CENTER);

                registerButton.setOpaque(false);
                registerButton.setForeground(new Color(0,0,0));
                registerButton.setText("REGISTER");
                registerButton.setVisible(true);

                registerButton.setContentAreaFilled(true);
                registerButton.setBorderPainted(false);
                registerButton.setIconTextGap(-2);

                registerButton.addMouseListener(new MouseAdapter(){

                        @Override
                        public void mousePressed(MouseEvent e) {
                            registerButton.setBackground(new Color(0, 0, 0));
                            registerButton.setForeground(new Color(255,255,255));

                        }

                        @Override
                        public void mouseReleased(MouseEvent e) {
                            registerButton.setBackground(new Color(248, 249, 250));
                            registerButton.setForeground(new Color(0,0,0));
                        }

                        @Override
                        public void mouseEntered(MouseEvent e){

                            registerButton.setBackground(new Color(150,150,150));
                        }

                        @Override
                        public void mouseExited(MouseEvent e){
                            registerButton.setBackground(new Color(248, 249, 250));
                            registerButton.setForeground(new Color(0,0,0));
                        }

                    });

        // Company Logo (JLabel) Decorations.

            final int companyLogoLocationX = 415;
            final int companyLogoLocationY = 40;
            final int companyLogoWidth = 370;
            final int companyLogoHeight = 370;

            add(companyLogo);
            companyLogo.setBounds(companyLogoLocationX, companyLogoLocationY, companyLogoWidth, companyLogoHeight);
            companyLogo.setBackground(null);
            companyLogo.setHorizontalAlignment(SwingConstants.CENTER);
            companyLogo.setLayout(null);
            companyLogo.setVisible(true);

            ImageIcon findLogo = new ImageIcon("src\\PRMS Files\\logo\\BTSLogo1.png");
            Image importLogo = findLogo.getImage();
            Image scaleLogo = importLogo.getScaledInstance(companyLogo.getWidth(), companyLogo.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon scaledLogo = new ImageIcon(scaleLogo);
            companyLogo.setIcon(scaledLogo);

        // Company Name (JLabel) Decorations.
        

            final int companyNameLocationX = 410;
            final int companyNameLocationY = 315;
            final int companyNameWidth = 380;
            final int companyNameHeight = 30;

            final int cNameShadowLocationY = 320;

            add(companyName);
            companyName.setBounds(companyNameLocationX, companyNameLocationY, companyNameWidth, companyNameHeight);
            companyName.setForeground(new Color(255, 208, 0));
            companyName.setFont(new Font("Iron Shark", Font.PLAIN, 18));

            add(cNameShadow);
            cNameShadow.setBounds(companyNameLocationX, cNameShadowLocationY, companyNameWidth, companyNameHeight);
            cNameShadow.setForeground(new Color(0, 0, 0));
            cNameShadow.setFont(new Font("Iron Shark", Font.PLAIN, 18));

            companyName.setHorizontalAlignment(SwingConstants.LEADING);
            companyName.setText("Brion Tactical Systems");
            companyName.setVisible(true);

            cNameShadow.setHorizontalAlignment(SwingConstants.LEADING);
            cNameShadow.setText("Brion Tactical Systems");
            cNameShadow.setVisible(true);

        // Program Name (JLabel) Declarations.

            final int programNameLocationX = 410;
            final int programNameLocationY = 350;
            final int programNameWidth = 370;
            final int programNameHeight = 30;

            final int pNameShadowLocationY = 355;

            // Program Name (JLabel) Declarations.

            add(programName);
            programName.setBounds(programNameLocationX, programNameLocationY, programNameWidth, programNameHeight);
            programName.setForeground(new Color(255, 255, 255));
            programName.setFont(new Font("Gepestev", Font.BOLD, 18));

            add(pNameShadow);
            pNameShadow.setBounds(programNameLocationX, pNameShadowLocationY, programNameWidth, programNameHeight);
            pNameShadow.setForeground(new Color(0, 0, 0));
            pNameShadow.setFont(new Font("Gepestev", Font.BOLD, 18));

            programName.setHorizontalAlignment(SwingConstants.CENTER);
            programName.setText("POLICE RECORD MANAGEMENT SYSTEM");
            programName.setVisible(true);

            pNameShadow.setHorizontalAlignment(SwingConstants.CENTER);
            pNameShadow.setText("POLICE RECORD MANAGEMENT SYSTEM");
            pNameShadow.setVisible(true);

        // Main Window Login Background (JPanel) Decorations.

            final int loginBackgroundLocationX  = 0;
            final int loginBackgroundLocationY  = 0;
            final int loginBackgroundWidth      = 800;
            final int lofinBackgroundHeigth     = 490;

            add(loginBackground);
            loginBackground.setBounds(loginBackgroundLocationX, loginBackgroundLocationY, loginBackgroundWidth, lofinBackgroundHeigth);
            loginBackground.setBackground(new Color(0, 29, 61));
            loginBackground.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(255, 208, 0)));
            loginBackground.setLayout(null);
            loginBackground.setVisible(true);

            // Login Frame dragging Declaration.
            
            loginBackground.addMouseMotionListener(new MouseMotionAdapter() {
                public void mouseDragged(MouseEvent evt) {
                    
                    int x = evt.getXOnScreen();
                    int y = evt.getYOnScreen();

                    setLocation(x - xMouse, y - yMouse);
                    
                }
            });

            loginBackground.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent evt) {
                    
                    xMouse = evt.getX();
                    yMouse = evt.getY();
                    
                }
            });
            
        // Exit Button.
        final int exitButtonLocationX = 765;
        final int exitButtonLocationY = 10;
        final int exitButtonWidth     = 24;
        final int exitButtonHeight    = 24;
        
        loginBackground.add(exit);
        exit.setBounds(exitButtonLocationX, exitButtonLocationY, exitButtonWidth, exitButtonHeight);
        exit.setForeground(new Color(0,0,0));
        exit.setBackground(new Color(248, 249, 250));
        exit.setBorder(null);
        exit.setFocusPainted(false);
        exit.setHorizontalAlignment(SwingConstants.CENTER);
        exit.setOpaque(false);
        exit.setVisible(true);
        exit.setContentAreaFilled(false);
        exit.setBorderPainted(false);
        exit.setIconTextGap(0);
        
        ImageIcon exitIcon = new ImageIcon("src\\PRMS Files\\icons\\DehoveredExit.png");
        Image importExitIcon = exitIcon.getImage();
        ImageIcon scaledExitIcon = new ImageIcon(importExitIcon);
        exit.setIcon(scaledExitIcon);
        
        ImageIcon exitSelectedIcon = new ImageIcon("src\\PRMS Files\\icons\\HoveredExit.png");
        Image importExitSelectedIcon = exitSelectedIcon.getImage();
        ImageIcon GetExitSelectedIcon = new ImageIcon(importExitSelectedIcon);
        exit.setSelectedIcon(GetExitSelectedIcon);
        
        ImageIcon exitRolloverIcon = new ImageIcon("src\\PRMS Files\\icons\\ClickedExit.png");
        Image importExitRolloverIcon = exitRolloverIcon.getImage();
        ImageIcon scaledExitRolloverIcon = new ImageIcon(importExitRolloverIcon);
        exit.setRolloverIcon(scaledExitRolloverIcon);
        
        // Exit Function 
        exit.addActionListener((ActionEvent evt) -> {
            
            ExitButtonFunction(evt);
            
        });
        
        // Minimize Button.
        final int minimizeButtonLocationX = 735;
        final int minimizeButtonLocationY = 10;
        final int minimizeButtonWidth     = 24;
        final int minimizeButtonHeight    = 24;
        
        loginBackground.add(minimize);
        minimize.setBounds(minimizeButtonLocationX, minimizeButtonLocationY, minimizeButtonWidth, minimizeButtonHeight);
        minimize.setForeground(new Color(0,0,0));
        minimize.setBackground(new Color(248, 249, 250));
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
        minimize.addActionListener((ActionEvent evt) -> {
                
            MinimizeButtonFunction(evt);
            
        });

        pack();
        setLocationRelativeTo(null);
    }
    
    // CLASS FUNCTIONS //
    
    private void ExitButtonFunction(ActionEvent evt){
        
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
            
            int Question_YES  = JOptionPane.showConfirmDialog(null, "Do you want to close the Program?","BTS : PRMS - Confirmation",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            
            if (Question_YES==JOptionPane.YES_OPTION) {

                System.exit(0);

            } else if (Question_YES==JOptionPane.NO_OPTION) {

                String message = "Program Closure Aborted";
                String title1 = "BTS : PRMS - Confirmation";
                
                JOptionPane.showMessageDialog(null, message, title1, JOptionPane.INFORMATION_MESSAGE);

            }
    }
    
    private void MinimizeButtonFunction(ActionEvent evt){
        
            setState(PRMSLogin.ICONIFIED);
            
    }
    
    public static void main(String[] args) {

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PRMSLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        PRMSLogin Launch = new PRMSLogin();
        Launch.setVisible(true);
        Launch.setOpacity(0.98f);
        

    }
}
