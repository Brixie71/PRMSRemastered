
package PRMSClasses;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

import org.netbeans.lib.awtextra.AbsoluteConstraints;

public class PRMSRegister extends JFrame {
    
    private JLabel registerBackgroundPicture;
    
    public PRMSRegister(){
        MainGUIWindow();
    }

    private void MainGUIWindow(){
        
        registerBackgroundPicture = new JLabel();
        
        // JFrame Declaration
        final int FrameSizeX = 1123;
        final int FrameSizeY = 700;

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
        
        // First Name Label (JLabel) Declarations.
        
            final int firstNameLocationX = 170;
            final int firstNameLocationY = 270;
            final int firstNameWidth     = 130;
            final int firstNameHeight    = 35;
            
            JLabel firstName = new JLabel();
            
            // First Name Label (JLabel) Decorations.
            
                firstName.setBounds(firstNameLocationX, firstNameLocationY, firstNameWidth, firstNameHeight);
                add(firstName, new AbsoluteConstraints(firstNameLocationX, firstNameLocationY, firstNameWidth, firstNameHeight));
                firstName.setForeground(new java.awt.Color(0, 0, 0));
                firstName.setFont(new java.awt.Font("Tahoma", 0, 14));

                firstName.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
                firstName.setText("FIRST NAME      :");
                firstName.setVisible(true);
                
                // First Name Input (JTextField) Declarations.
            
                    final int firstNameInputLocationX = 280;
                    final int firstNameInputLocationY = 270;
                    final int firstNameInputWidth     = 230;
                    final int firstNameInputHeight    = 35;

                    JTextField firstNameInput = new JTextField();

                    // First Name Input (JTextField).

                        firstNameInput.setBounds(firstNameInputLocationX, firstNameInputLocationY, firstNameInputWidth, firstNameInputHeight);
                        add(firstNameInput, new AbsoluteConstraints(firstNameInputLocationX, firstNameInputLocationY, firstNameInputWidth, firstNameInputHeight));
                        firstNameInput.setForeground(new java.awt.Color(0,0,0));
                        firstNameInput.setBackground(new java.awt.Color(0,0,0,0));
                        firstNameInput.setOpaque(false);
                        firstNameInput.setCaretColor(new java.awt.Color(0,0,0));
                        firstNameInput.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0,0,0)));
                        firstNameInput.setFont(new java.awt.Font("Tahoma", 0, 14));
                        firstNameInput.setVisible(true);
                
                
            
        // Middle Name Label (JLabel) Declarations.
        
            final int middleNameLocationX = 170;
            final int middleNameLocationY = 310;
            final int middleNameWidth     = 130;
            final int middleNameHeight    = 35;
            
            JLabel middleName = new JLabel();
            
            // Middle Name Label (JLabel) Decorations.
            
                middleName.setBounds(middleNameLocationX, middleNameLocationY, middleNameWidth, middleNameHeight);
                add(middleName, new AbsoluteConstraints(middleNameLocationX, middleNameLocationY, middleNameWidth, middleNameHeight));
                middleName.setForeground(new java.awt.Color(0, 0, 0));
                middleName.setFont(new java.awt.Font("Tahoma", 0, 14));

                middleName.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
                middleName.setText("MIDDLE NAME   :");
                middleName.setVisible(true);
                
                // Middle Name Input (JTextField) Declarations.
            
                    final int middleNameInputLocationX = 280;
                    final int middleNameInputLocationY = 310;
                    final int middleNameInputWidth     = 230;
                    final int middleNameInputHeight    = 35;

                    JTextField middleNameInput = new JTextField();

                    // Middle Name Input (JTextField).

                        middleNameInput.setBounds(middleNameInputLocationX, middleNameInputLocationY, middleNameInputWidth, middleNameInputHeight);
                        add(middleNameInput, new AbsoluteConstraints(middleNameInputLocationX, middleNameInputLocationY, middleNameInputWidth, middleNameInputHeight));
                        middleNameInput.setForeground(new java.awt.Color(0,0,0));
                        middleNameInput.setBackground(new java.awt.Color(0,0,0,0));
                        middleNameInput.setOpaque(false);
                        middleNameInput.setCaretColor(new java.awt.Color(0,0,0));
                        middleNameInput.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0,0,0)));
                        middleNameInput.setFont(new java.awt.Font("Tahoma", 0, 14));
                        middleNameInput.setVisible(true);
        
        // Last Name Label (JLabel) Declarations.
        
            final int lastNameLocationX = 170;
            final int lastNameLocationY = 350;
            final int lastNameWidth     = 130;
            final int lastNameHeight    = 35;
            
            JLabel lastName = new JLabel();
            
            // Last Name Label (JLabel) Decorations.
            
                lastName.setBounds(lastNameLocationX, lastNameLocationY, lastNameWidth, lastNameHeight);
                add(lastName, new AbsoluteConstraints(lastNameLocationX, lastNameLocationY, lastNameWidth, lastNameHeight));
                lastName.setForeground(new java.awt.Color(0, 0, 0));
                lastName.setFont(new java.awt.Font("Tahoma", 0, 14));

                lastName.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
                lastName.setText("LAST NAME       :");
                lastName.setVisible(true);
                
                // Last Name Input (JTextField) Declarations.
            
                    final int lastNameInputLocationX = 280;
                    final int lastNameInputLocationY = 350;
                    final int lastNameInputWidth     = 230;
                    final int lastNameInputHeight    = 35;

                    JTextField lastNameInput = new JTextField();

                    // Last Name Input (JTextField).

                        lastNameInput.setBounds(lastNameInputLocationX, lastNameInputLocationY, lastNameInputWidth, lastNameInputHeight);
                        add(lastNameInput, new AbsoluteConstraints(lastNameInputLocationX, lastNameInputLocationY, lastNameInputWidth, lastNameInputHeight));
                        lastNameInput.setForeground(new java.awt.Color(0,0,0));
                        lastNameInput.setBackground(new java.awt.Color(0,0,0,0));
                        lastNameInput.setOpaque(false);
                        lastNameInput.setCaretColor(new java.awt.Color(0,0,0));
                        lastNameInput.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0,0,0)));
                        lastNameInput.setFont(new java.awt.Font("Tahoma", 0, 14));
                        lastNameInput.setVisible(true);
            
        
        // Gender Label (JLabel) Declarations.
        
            final int genderLocationX = 170;
            final int genderLocationY = 390;
            final int genderWidth     = 130;
            final int genderHeight    = 35;
            
            JLabel gender = new JLabel();
            
            // Gender Label (JLabel) Decorations.
            
                gender.setBounds(genderLocationX, genderLocationY, genderWidth, genderHeight);
                add(gender, new AbsoluteConstraints(genderLocationX, genderLocationY, genderWidth, genderHeight));
                gender.setForeground(new java.awt.Color(0, 0, 0));
                gender.setFont(new java.awt.Font("Tahoma", 0, 14));

                gender.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
                gender.setText("GENDER            :");
                gender.setVisible(true);
                
                // Gender Name Input (JTextField) Declarations.
            
                    final int genderInputLocationX = 280;
                    final int genderInputLocationY = 390;
                    final int genderInputWidth     = 230;
                    final int genderInputHeight    = 35;

                    JTextField genderInput = new JTextField();

                    // Gender Name Input (JTextField).

                        genderInput.setBounds(genderInputLocationX, genderInputLocationY, genderInputWidth, genderInputHeight);
                        add(genderInput, new AbsoluteConstraints(genderInputLocationX, genderInputLocationY, genderInputWidth, genderInputHeight));
                        genderInput.setForeground(new java.awt.Color(0,0,0));
                        genderInput.setBackground(new java.awt.Color(0,0,0,0));
                        genderInput.setOpaque(false);
                        genderInput.setCaretColor(new java.awt.Color(0,0,0));
                        genderInput.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0,0,0)));
                        genderInput.setFont(new java.awt.Font("Tahoma", 0, 14));
                        genderInput.setVisible(true);
        
        // Religion Label (JLabel) Declarations.
        
            final int religionLocationX = 170;
            final int religionLocationY = 430;
            final int religionWidth     = 130;
            final int religionHeight    = 35;
            
            JLabel religion = new JLabel();
            
            // Religion Label (JLabel) Decorations.
            
                religion.setBounds(religionLocationX, religionLocationY, religionWidth, religionHeight);
                add(religion, new AbsoluteConstraints(religionLocationX, religionLocationY, religionWidth, religionHeight));
                religion.setForeground(new java.awt.Color(0, 0, 0));
                religion.setFont(new java.awt.Font("Tahoma", 0, 14));

                religion.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
                religion.setText("RELIGION          :");
                religion.setVisible(true);
                
                // Religion Input (JTextField) Declarations.
            
                    final int religionInputLocationX = 280;
                    final int religionInputLocationY = 430;
                    final int religionInputWidth     = 230;
                    final int religionInputHeight    = 35;

                    JTextField religionInput = new JTextField();

                    // Religion Input (JTextField).

                        religionInput.setBounds(religionInputLocationX, religionInputLocationY, religionInputWidth, religionInputHeight);
                        add(religionInput, new AbsoluteConstraints(religionInputLocationX, religionInputLocationY, religionInputWidth, religionInputHeight));
                        religionInput.setForeground(new java.awt.Color(0,0,0));
                        religionInput.setBackground(new java.awt.Color(0,0,0,0));
                        religionInput.setOpaque(false);
                        religionInput.setCaretColor(new java.awt.Color(0,0,0));
                        religionInput.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0,0,0)));
                        religionInput.setFont(new java.awt.Font("Tahoma", 0, 14));
                        religionInput.setVisible(true);
                        
        // Nationality Label (JLabel) Declarations.
        
            final int nationalityLocationX = 550;
            final int nationalityLocationY = 390;
            final int nationalityWidth     = 130;
            final int nationalityHeight    = 35;
            
            JLabel nationality = new JLabel();
            
            // Nationality Label (JLabel) Decorations.
            
                nationality.setBounds(nationalityLocationX, nationalityLocationY, nationalityWidth, nationalityHeight);
                add(nationality, new AbsoluteConstraints(nationalityLocationX, nationalityLocationY, nationalityWidth, nationalityHeight));
                nationality.setForeground(new java.awt.Color(0, 0, 0));
                nationality.setFont(new java.awt.Font("Tahoma", 0, 14));

                nationality.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
                nationality.setText("NATIONALITY   :");
                nationality.setVisible(true);
                
                // Nationality Input (JTextField) Declarations.
            
                    final int nationalityInputLocationX = 655;
                    final int nationalityInputLocationY = 390;
                    final int nationalityInputWidth     = 275;
                    final int nationalityInputHeight    = 35;

                    JTextField nationalityInput = new JTextField();

                    // Nationality Input (JTextField).

                        nationalityInput.setBounds(nationalityInputLocationX, nationalityInputLocationY, nationalityInputWidth, nationalityInputHeight);
                        add(nationalityInput, new AbsoluteConstraints(nationalityInputLocationX, nationalityInputLocationY, nationalityInputWidth, nationalityInputHeight));
                        nationalityInput.setForeground(new java.awt.Color(0,0,0));
                        nationalityInput.setBackground(new java.awt.Color(0,0,0,0));
                        nationalityInput.setOpaque(false);
                        nationalityInput.setCaretColor(new java.awt.Color(0,0,0));
                        nationalityInput.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0,0,0)));
                        nationalityInput.setFont(new java.awt.Font("Tahoma", 0, 14));
                        nationalityInput.setVisible(true);
            
        // Username Label (JLabel) Declarations.
        
            final int usernameLocationX = 170;
            final int usernameLocationY = 470;
            final int usernameWidth     = 130;
            final int usernameHeight    = 35;
            
            JLabel username = new JLabel();
            
            // Username Label (JLabel) Decorations.
            
                username.setBounds(usernameLocationX, usernameLocationY, usernameWidth, usernameHeight);
                add(username, new AbsoluteConstraints(usernameLocationX, usernameLocationY, usernameWidth, usernameHeight));
                username.setForeground(new java.awt.Color(0, 0, 0));
                username.setFont(new java.awt.Font("Tahoma", 0, 14));

                username.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
                username.setText("USERNAME        :");
                username.setVisible(true);
                
                // Username Input (JTextField) Declarations.
            
                    final int usernameInputLocationX = 280;
                    final int usernameInputLocationY = 470;
                    final int usernameInputWidth     = 230;
                    final int usernameInputHeight    = 35;

                    JTextField usernameInput = new JTextField();

                    // Username Input (JTextField).

                        usernameInput.setBounds(usernameInputLocationX, usernameInputLocationY, usernameInputWidth, usernameInputHeight);
                        add(usernameInput, new AbsoluteConstraints(usernameInputLocationX, usernameInputLocationY, usernameInputWidth, usernameInputHeight));
                        usernameInput.setForeground(new java.awt.Color(0,0,0));
                        usernameInput.setBackground(new java.awt.Color(0,0,0,0));
                        usernameInput.setOpaque(false);
                        usernameInput.setCaretColor(new java.awt.Color(0,0,0));
                        usernameInput.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0,0,0)));
                        usernameInput.setFont(new java.awt.Font("Tahoma", 0, 14));
                        usernameInput.setVisible(true);
            
        // Email Label (JLabel) Declarations.
        
            final int emailLocationX = 550;
            final int emailLocationY = 430;
            final int emailWidth     = 130;
            final int emailHeight    = 35;
            
            JLabel email = new JLabel();
            
            // Email Label (JLabel) Decorations.
            
                email.setBounds(emailLocationX, emailLocationY, emailWidth, emailHeight);
                add(email, new AbsoluteConstraints(emailLocationX, emailLocationY, emailWidth, emailHeight));
                email.setForeground(new java.awt.Color(0, 0, 0));
                email.setFont(new java.awt.Font("Tahoma", 0, 14));

                email.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
                email.setText("EMAIL              :");
                email.setVisible(true);
                
                // Email Address Input (JTextField) Declarations.
            
                    final int emailInputLocationX = 655;
                    final int emailInputLocationY = 430;
                    final int emailInputWidth     = 275;
                    final int emailInputHeight    = 35;

                    JTextField emailInput = new JTextField();

                    // Email Address Input (JTextField).

                        emailInput.setBounds(emailInputLocationX, emailInputLocationY, emailInputWidth, emailInputHeight);
                        add(emailInput, new AbsoluteConstraints(emailInputLocationX, emailInputLocationY, emailInputWidth, emailInputHeight));
                        emailInput.setForeground(new java.awt.Color(0,0,0));
                        emailInput.setBackground(new java.awt.Color(0,0,0,0));
                        emailInput.setOpaque(false);
                        emailInput.setCaretColor(new java.awt.Color(0,0,0));
                        emailInput.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0,0,0)));
                        emailInput.setFont(new java.awt.Font("Tahoma", 0, 14));
                        emailInput.setVisible(true);
        
        // Password Label (JLabel) Declarations.
        
            final int passwordLocationX = 170;
            final int passwordLocationY = 510;
            final int passwordWidth     = 130;
            final int passwordHeight    = 35;
            
            JLabel passwordLocation = new JLabel();
            
            // Password Label (JLabel) Decorations.
            
                passwordLocation.setBounds(passwordLocationX, passwordLocationY, passwordWidth, passwordHeight);
                add(passwordLocation, new AbsoluteConstraints(passwordLocationX, passwordLocationY, passwordWidth, passwordHeight));
                passwordLocation.setForeground(new java.awt.Color(0, 0, 0));
                passwordLocation.setFont(new java.awt.Font("Tahoma", 0, 14));

                passwordLocation.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
                passwordLocation.setText("PASSWORD      :");
                passwordLocation.setVisible(true);
                
                // Password Input (JPasswordField) Declarations.
            
                    final int passwordInputLocationX = 280;
                    final int passwordInputLocationY = 510;
                    final int passwordInputWidth     = 230;
                    final int passwordInputHeight    = 35;

                    JPasswordField passwordInput = new JPasswordField();

                    // Password Input (JPasswordField).

                        passwordInput.setBounds(passwordInputLocationX, passwordInputLocationY, passwordInputWidth, passwordInputHeight);
                        add(passwordInput, new AbsoluteConstraints(passwordInputLocationX, passwordInputLocationY, passwordInputWidth, passwordInputHeight));
                        passwordInput.setForeground(new java.awt.Color(0,0,0));
                        passwordInput.setBackground(new java.awt.Color(0,0,0,0));
                        passwordInput.setOpaque(false);
                        passwordInput.setCaretColor(new java.awt.Color(0,0,0));
                        passwordInput.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0,0,0)));
                        passwordInput.setFont(new java.awt.Font("Tahoma", 0, 14));
                        passwordInput.setVisible(true);

        // Confirm Pass Label (JLabel) Declarations.
        
            final int confirmPassLocationX = 550;
            final int confirmPassLocationY = 510;
            final int confirmPassWidth     = 150;
            final int confirmPassHeight    = 35;
            
            JLabel confirmPass = new JLabel();
            
            // Confirm Pass Label (JLabel) Decorations.
            
                confirmPass.setBounds(confirmPassLocationX, confirmPassLocationY, confirmPassWidth, confirmPassHeight);
                add(confirmPass, new AbsoluteConstraints(confirmPassLocationX, confirmPassLocationY, confirmPassWidth, confirmPassHeight));
                confirmPass.setForeground(new java.awt.Color(0, 0, 0));
                confirmPass.setFont(new java.awt.Font("Tahoma", 0, 14));

                confirmPass.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
                confirmPass.setText("CONFIRM PASSWORD :");
                confirmPass.setVisible(true);
                
                // Confirm Password Input (JPasswordField) Declarations.
            
                    final int confirmPasswordInputLocationX = 702;
                    final int confirmPasswordInputLocationY = 510;
                    final int confirmPasswordInputWidth     = 230;
                    final int confirmPasswordInputHeight    = 35;

                    JPasswordField confirmPasswordInput = new JPasswordField();

                    // Confirm Password Input (JPasswordField).

                        confirmPasswordInput.setBounds(confirmPasswordInputLocationX, confirmPasswordInputLocationY, confirmPasswordInputWidth, confirmPasswordInputHeight);
                        add(confirmPasswordInput, new AbsoluteConstraints(confirmPasswordInputLocationX, confirmPasswordInputLocationY, confirmPasswordInputWidth, confirmPasswordInputHeight));
                        confirmPasswordInput.setForeground(new java.awt.Color(0,0,0));
                        confirmPasswordInput.setBackground(new Color(0,0,0,0));
                        confirmPasswordInput.setOpaque(false);
                        confirmPasswordInput.setCaretColor(new java.awt.Color(0,0,0));
                        confirmPasswordInput.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0,0,0)));
                        confirmPasswordInput.setFont(new java.awt.Font("Tahoma", 0, 14));
                        confirmPasswordInput.setVisible(true);
   
        // Register Title (JLabel) Declarations.

        final int registerTitleLocationX = 170;
        final int registerTitleLocationY = 30;
        final int registerTitleWidth = 370;
        final int registerTitleHeight = 30;
        
        JLabel registerTitle = new JLabel();
        
        // Register Title (JLabel) Decorations.

        registerTitle.setBounds(registerTitleLocationX, registerTitleLocationY, registerTitleWidth, registerTitleHeight);
        add(registerTitle, new AbsoluteConstraints(registerTitleLocationX, registerTitleLocationY, registerTitleWidth, registerTitleHeight));
        registerTitle.setForeground(new java.awt.Color(0, 0, 0));
        registerTitle.setFont(new java.awt.Font("Impact", 0, 30));
        
        registerTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        registerTitle.setText("REGISTER ACCOUNT");
        registerTitle.setVisible(true);
        
        // Register Button (JButton) Declarations.
        
        final int registerButtonLocationX = 900;
        final int registerButtonLocationY = 600;
        final int registerButtonWidth     = 100;
        final int registerButtonHeigth    = 50;
        
        JButton registerButton = new JButton();
        
        // Register Button (JButton) Decorations.
        
        registerButton.setBounds(registerButtonLocationX, registerButtonLocationY, registerButtonWidth, registerButtonHeigth);
        add(registerButton, new AbsoluteConstraints(registerButtonLocationX, registerButtonLocationY, registerButtonWidth, registerButtonHeigth));
        registerButton.setBackground(new java.awt.Color(248, 249, 250));
        registerButton.setFont(new java.awt.Font("Impact", 0, 16));
        registerButton.setFocusPainted(false);
        registerButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        registerButton.setHorizontalTextPosition(javax.swing.SwingConstants.TRAILING);
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
        
        // Register Background Picture Frame (JPanel) Declaration.
        
        final int registerBackgroundLocationX  = 0;
        final int registerBackgroundLocationY  = 0;
        final int registerBackgroundWidth      = 1123;
        final int registerBackgroundHeigth     = 700;
        
        JPanel registerBackground = new JPanel();
        
        // Register Background Picture Frame (JPanel) Decorations.
        
            registerBackground.setBounds(registerBackgroundLocationX, registerBackgroundLocationY, registerBackgroundWidth, registerBackgroundHeigth);
            add(registerBackground, new AbsoluteConstraints(registerBackgroundLocationX, registerBackgroundLocationY, registerBackgroundWidth, registerBackgroundHeigth));
            registerBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
            registerBackground.setVisible(true);
            //loginBackground.setBackground(new java.awt.Color(237, 242, 244));

            // Register Background Picture Decorations.
        
                final int RBPictureLocationX = 0;
                final int RBPictureLocationY = 0;
                final int RBPictureWidth     = 1123;
                final int RBPictureHeight    = 700;

                registerBackgroundPicture.setBounds(RBPictureLocationX, RBPictureLocationY, RBPictureWidth, RBPictureHeight);

                registerBackgroundPicture.setBounds(RBPictureLocationX, RBPictureLocationY, RBPictureWidth, RBPictureHeight);
                registerBackground.add(registerBackgroundPicture, new AbsoluteConstraints(RBPictureLocationX, RBPictureLocationY, RBPictureWidth, RBPictureHeight));
                registerBackgroundPicture.setBackground(null);
                registerBackgroundPicture.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, false));
                registerBackgroundPicture.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                registerBackgroundPicture.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
                registerBackgroundPicture.setVisible(true);

                ImageIcon icon = new ImageIcon("src\\PRMS Files\\backgrounds\\RegistrationBack.png");
                Image homeBackground = icon.getImage();
                Image imgScale = homeBackground.getScaledInstance(registerBackgroundPicture.getWidth(), registerBackgroundPicture.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon scaledIcon = new ImageIcon(imgScale);
                registerBackgroundPicture.setIcon(scaledIcon);

        // Login Frame dragging Declaration.
        registerBackground.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            @Override
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                loginBackgroundMouseDragged(evt);
            }
        });

        registerBackground.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
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

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PRMSRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }/*/ /*/


        PRMSRegister Open = new PRMSRegister();
        Open.setVisible(true);
    }
    
}
