
package PRMSClasses;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;

public class PRMSPrint extends JFrame {
    
    JPanel PrintBackground, Document;
    
    JLabel  PrintLabel, PrintSearchLabel,
            CompanyName, ROPLabel, ReportSheetLabel, CaseNumber, HeaderTop,
            
            GenderLabel, AgeLabel, HomeAddressLabel, ProvinceOfOriginLabel, DateArrestedLabel, DateOfReleaseLabel,
            ReasonOfApprehensionLabel, MugShot,
            
            LineOne,
            
            ArrestInfoLabel, DateLabel, ChargeLabel, TermLabel,
            
            HeaderButtom, FingerPrintLabel, FPRightThumbBox, FPLeftThumbBox, FPRightIndex, FPLeftIndex,
            FPRightThumbLabel, FPLeftThumbLabel, FPRightIndexLabel, FPLeftIndexLabel,
            
            SignatureLine, SignatureLabel,
            
            OtherInfoLabel, OtherInfoLineOne, OtherInfoLineTwo, OtherInfoLinethree, OtherInfoLinefour,
            OtherINfoLineFive, OtherInfoLineSix;
                    
    JButton BackButton, ClearDocument, PrintDocument;
    
    JTextField PrintSearch, CaseNumLine,
               NameField, GenderField, AgeField, HomeAddressField, DateArrestedField, ReleaseDateField,
               ReasonOfApprehensionField, MugShotField;
    
    JTable PoliceDatabase;
    
    JScrollPane ListScrollbar;
    
    Font IronShark, Quicksand, Gepestev;
    
    // FRAME DRAGGER
    int xMouse;
    int yMouse;
    
    
    public PRMSPrint(){
     
        PrintComponents();
        
        GetDataFromDatabase();
        
    }
    
    private void PrintComponents() {
        
        
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
        setTitle("BTS : Print Record");
        setLayout(null);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // CENTER POPUP MAIN WINDOW.
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dimension.width / 2 - this.getWidth() / 2, dimension.height / 2 - this.getHeight() / 2);
        
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

        // <editor-fold defaultstate="collapsed" desc="<<< Component Instantiations.">
        
        PrintBackground = new JPanel();
        Document = new JPanel();
        
        CompanyName = new JLabel();
        ROPLabel = new JLabel();
        ReportSheetLabel = new JLabel();
        CaseNumber = new JLabel();
        HeaderTop = new JLabel();
        
        GenderLabel = new JLabel();
        AgeLabel = new JLabel(); 
        HomeAddressLabel = new JLabel(); 
        ProvinceOfOriginLabel = new JLabel(); 
        DateArrestedLabel= new JLabel(); 
        DateOfReleaseLabel = new JLabel();
        ReasonOfApprehensionLabel = new JLabel(); 
        MugShot = new JLabel();

        LineOne = new JLabel();
        ArrestInfoLabel = new JLabel();
        DateLabel = new JLabel();
        ChargeLabel = new JLabel();  
        TermLabel = new JLabel();

        HeaderButtom = new JLabel(); 
        FingerPrintLabel = new JLabel(); 
        FPRightThumbBox = new JLabel(); 
        FPLeftThumbBox = new JLabel(); 
        FPRightIndex = new JLabel(); 
        FPLeftIndex = new JLabel();
        FPRightThumbLabel = new JLabel(); 
        FPLeftThumbLabel = new JLabel();
        FPRightIndexLabel = new JLabel();
        FPLeftIndexLabel = new JLabel();

        SignatureLine = new JLabel(); 
        SignatureLabel = new JLabel();

        OtherInfoLabel = new JLabel();
        OtherInfoLineOne = new JLabel(); 
        OtherInfoLineTwo = new JLabel();
        OtherInfoLinethree = new JLabel();
        OtherInfoLinefour = new JLabel();
        OtherINfoLineFive = new JLabel();
        OtherInfoLineSix = new JLabel();

        PrintLabel = new JLabel();
        PrintSearchLabel = new JLabel();
        
        BackButton = new JButton();
        ClearDocument = new JButton();
        PrintDocument = new JButton();
        
        PrintSearch = new JTextField();
        
        CaseNumLine = new JTextField();
        NameField = new JTextField();
        GenderField = new JTextField();
        AgeField = new JTextField();
        HomeAddressField = new JTextField();
        DateArrestedField = new JTextField(); 
        ReleaseDateField = new JTextField();
        ReasonOfApprehensionField = new JTextField(); 
        MugShotField = new JTextField();
        
        PoliceDatabase = new JTable();
        
        ListScrollbar = new JScrollPane();
        
        // </editor-fold>
        
        // Login Frame dragging Declaration.
        PrintBackground.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent evt) {

                int x = evt.getXOnScreen();
                int y = evt.getYOnScreen();

                setLocation(x - xMouse, y - yMouse);

            }
        });

        PrintBackground.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {

                xMouse = evt.getX();
                yMouse = evt.getY();

            }
        });
        
        
        // Print Background (JPanel) Decorations.
            final int printBackgroundLocationX = 0;
            final int printBackgroundLocationY = 0;
            final int printBackgroundWidth = 1000;
            final int printBackgroundHeigth = 700;

            add(PrintBackground);
            PrintBackground.setBounds(printBackgroundLocationX, printBackgroundLocationY, printBackgroundWidth, printBackgroundHeigth);
            PrintBackground.setBackground(new Color(0, 29, 61));
            PrintBackground.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(255, 208, 0)));
            PrintBackground.setLayout(null);
            PrintBackground.setVisible(true);
            
        // Print Label (JLabel) Decorations.
        
            final int PrintLabelLocationX = 0;
            final int PrintLabelLocationY = 100;
            final int PrintLabelWidth = 480;
            final int PrintLabelHeight = 35;

            PrintBackground.add(PrintLabel);
            PrintLabel.setBounds(PrintLabelLocationX, PrintLabelLocationY, PrintLabelWidth, PrintLabelHeight);
            PrintLabel.setBackground(new Color(0, 0, 0, 0));
            PrintLabel.setForeground(new Color(255, 255, 255));
            PrintLabel.setHorizontalAlignment(SwingConstants.CENTER);
            PrintLabel.setText("PRINT DATABASE RECORD");
            PrintLabel.setOpaque(false);
            PrintLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(237, 242, 244)));
            PrintLabel.setFont(new Font("Quicksand", Font.BOLD, 26));
            PrintLabel.setVisible(true);
        

        // Document (JPanel) Decorations. 
        
            final int DocumentLocationX = 480;
            final int DocumentLocationY = 25;
            final int DocumentWidth = 500;
            final int DocumentHeigth = 650;

            PrintBackground.add(Document);
            Document.setBounds(DocumentLocationX, DocumentLocationY, DocumentWidth, DocumentHeigth);
            Document.setBackground(new Color(255, 255, 255));
            Document.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
            Document.setLayout(null);
            Document.setVisible(true);
            
            // DOCUMENT CONTENTS.
            
                // Company Name (JLabel) Decorations.
                
                    final int CompanyNameLocationX = 0;
                    final int CompanyNameLocationY = 20;
                    final int CompanyNameWidth     = 500;
                    final int CompanyNameHeight    = 14;

                    Document.add(CompanyName);
                    CompanyName.setBounds(CompanyNameLocationX, CompanyNameLocationY, CompanyNameWidth, CompanyNameHeight);
                    CompanyName.setForeground(new Color(0, 0, 0));
                    CompanyName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
                    CompanyName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    CompanyName.setText("BRION TACTICAL SYSTEMS");
                    CompanyName.setVisible(true);
                
                // Republic of the Philippines Label (JLabel) Decorations.
                
                    final int ROPLabelLocationX = 0;
                    final int ROPLabelLocationY = 40;
                    final int ROPLabelWidth     = 500;
                    final int ROPLabelHeight    = 14;

                    Document.add(ROPLabel);
                    ROPLabel.setBounds(ROPLabelLocationX, ROPLabelLocationY, ROPLabelWidth, ROPLabelHeight);
                    ROPLabel.setForeground(new Color(0, 0, 0));
                    ROPLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
                    ROPLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    ROPLabel.setText("Republic of the Philippines");
                    ROPLabel.setVisible(true);
                    
                // Police Report Sheet Label (JLabel) Decorations.
                
                    final int PoliceReportSheetLabelLocationX = 0;
                    final int PoliceReportSheetLabelLocationY = 70;
                    final int PoliceReportSheetLabelWidth     = 500;
                    final int PoliceReportSheetLabelHeight    = 16;

                    Document.add(ReportSheetLabel);
                    ReportSheetLabel.setBounds(PoliceReportSheetLabelLocationX, PoliceReportSheetLabelLocationY, PoliceReportSheetLabelWidth, PoliceReportSheetLabelHeight);
                    ReportSheetLabel.setForeground(new Color(0, 0, 0));
                    ReportSheetLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
                    ReportSheetLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    ReportSheetLabel.setText("POLICE REPORT SHEET");
                    ReportSheetLabel.setVisible(true);
                
                // Case Number Label (JLabel) Decorations.
                
                    final int CaseNumberLocationX = 50;
                    final int CaseNumberLocationY = 100;
                    final int CaseNumberWidth     = 45;
                    final int CaseNumberHeight    = 11;

                    Document.add(CaseNumber);
                    CaseNumber.setBounds(CaseNumberLocationX, CaseNumberLocationY, CaseNumberWidth, CaseNumberHeight);
                    CaseNumber.setForeground(new Color(0, 0, 0));
                    CaseNumber.setFont(new Font("Times New Roman", Font.PLAIN, 11));
                    CaseNumber.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
                    CaseNumber.setText("Case No :");
                    CaseNumber.setVisible(true);
                
                // Header Top Label (JLabel) Decorations.
                
                    final int HeaderTopLocationX = 0;
                    final int HeaderTopLocationY = 110;
                    final int HeaderTopWidth     = 500;
                    final int HeaderTopHeight    = 11;

                    Document.add(HeaderTop);
                    HeaderTop.setBounds(HeaderTopLocationX, HeaderTopLocationY, HeaderTopWidth, HeaderTopHeight);
                    HeaderTop.setForeground(new Color(0, 0, 0));
                    HeaderTop.setFont(new Font("Times New Roman", Font.PLAIN, 11));
                    HeaderTop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    HeaderTop.setText("------------------------------------------------------------------------------------------------------");
                    HeaderTop.setVisible(true);
                    
                // Person's Name (JTextField) Decorations.
                final int NameFieldLocationX = 0;
                final int NameFieldLocationY = 130;
                final int NameFieldWidth = 500;
                final int NameFieldHeight = 18;

                Document.add(NameField);
                NameField.setBounds(NameFieldLocationX, NameFieldLocationY, NameFieldWidth, NameFieldHeight);
                NameField.setBackground(new Color(0, 0, 0, 0));
                NameField.setForeground(new Color(0,0,0));
                NameField.setHorizontalAlignment(SwingConstants.CENTER);
                NameField.setEditable(false);
                NameField.setText("- REPORT SHEET -");
                NameField.setOpaque(false);
                NameField.setCaretColor(new Color(237, 242, 244));
                NameField.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(237, 242, 244)));
                NameField.setFont(new Font("Quicksand", Font.BOLD, 18));
                NameField.setVisible(true);
                
                // Case Number Label (JLabel) Decorations.
                
                    final int GenderLabelLocationX = 50;
                    final int GenderLabelLocationY = 160;
                    final int GenderLabelWidth     = 45;
                    final int GenderLabelHeight    = 11;

                    Document.add(GenderLabel);
                    GenderLabel.setBounds(GenderLabelLocationX, GenderLabelLocationY, GenderLabelWidth, GenderLabelHeight);
                    GenderLabel.setForeground(new Color(0, 0, 0));
                    GenderLabel.setFont(new Font("Times New Roman", Font.PLAIN, 11));
                    GenderLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
                    GenderLabel.setText("Gender :");
                    GenderLabel.setVisible(true);
                    
                // Age Label (JLabel) Decorations.
                
                    final int AgeLabelLocationX = 170;
                    final int AgeLabelLocationY = 160;
                    final int AgeLabelWidth     = 45;
                    final int AgeLabelHeight    = 11;

                    Document.add(AgeLabel);
                    AgeLabel.setBounds(AgeLabelLocationX, AgeLabelLocationY, AgeLabelWidth, AgeLabelHeight);
                    AgeLabel.setForeground(new Color(0, 0, 0));
                    AgeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 11));
                    AgeLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
                    AgeLabel.setText("Age :");
                    AgeLabel.setVisible(true);
                    
                // Home Address Label (JLabel) Decorations.
                
                    final int HomeAddressLocationX = 50;
                    final int HomeAddressLocationY = 180;
                    final int HomeAddressWidth     = 80;
                    final int HomeAddressHeight    = 11;

                    Document.add(HomeAddressLabel);
                    HomeAddressLabel.setBounds(HomeAddressLocationX, HomeAddressLocationY, HomeAddressWidth, HomeAddressHeight);
                    HomeAddressLabel.setForeground(new Color(0, 0, 0));
                    HomeAddressLabel.setFont(new Font("Times New Roman", Font.PLAIN, 11));
                    HomeAddressLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
                    HomeAddressLabel.setText("Home Address :");
                    HomeAddressLabel.setVisible(true);
                    
                // Province of Origin Label (JLabel) Decorations.
                
                    final int ProvinceOfOriginLabelLocationX = 50;
                    final int ProvinceOfOriginLabelLocationY = 200;
                    final int ProvinceOfOriginLabelWidth     = 130;
                    final int ProvinceOfOriginLabelHeight    = 11;

                    Document.add(ProvinceOfOriginLabel);
                    ProvinceOfOriginLabel.setBounds(ProvinceOfOriginLabelLocationX, ProvinceOfOriginLabelLocationY, ProvinceOfOriginLabelWidth, ProvinceOfOriginLabelHeight);
                    ProvinceOfOriginLabel.setForeground(new Color(0, 0, 0));
                    ProvinceOfOriginLabel.setFont(new Font("Times New Roman", Font.PLAIN, 11));
                    ProvinceOfOriginLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
                    ProvinceOfOriginLabel.setText("Province of Origin :");
                    ProvinceOfOriginLabel.setVisible(true);
                
                // Date Arrested Label (JLabel) Decorations.
                
                    final int DateArresedLocationX = 50;
                    final int DateArresedLabelLocationY = 220;
                    final int DateArresedLabelWidth     = 130;
                    final int DateArresedLabelHeight    = 11;

                    Document.add(DateArrestedLabel);
                    DateArrestedLabel.setBounds(DateArresedLocationX, DateArresedLabelLocationY, DateArresedLabelWidth, DateArresedLabelHeight);
                    DateArrestedLabel.setForeground(new Color(0, 0, 0));
                    DateArrestedLabel.setFont(new Font("Times New Roman", Font.PLAIN, 11));
                    DateArrestedLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
                    DateArrestedLabel.setText("Date Arrested :");
                    DateArrestedLabel.setVisible(true);
                    
                // Date Of Release Label (JLabel) Decorations.
                
                    final int DateOfReleaseLabelLocationX = 50;
                    final int DateOfReleaseLabelLocationY = 240;
                    final int DateOfReleaseLabelWidth     = 130;
                    final int DateOfReleaseLabelHeight    = 11;

                    Document.add(DateOfReleaseLabel);
                    DateOfReleaseLabel.setBounds(DateOfReleaseLabelLocationX, DateOfReleaseLabelLocationY, DateOfReleaseLabelWidth, DateOfReleaseLabelHeight);
                    DateOfReleaseLabel.setForeground(new Color(0, 0, 0));
                    DateOfReleaseLabel.setFont(new Font("Times New Roman", Font.PLAIN, 11));
                    DateOfReleaseLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
                    DateOfReleaseLabel.setText("Release Date :");
                    DateOfReleaseLabel.setVisible(true);
                    
                // Reason of Apprehension Label (JLabel) Decorations.
                
                    final int ReasonOfApprehensionLabelLocationX = 50;
                    final int ReasonOfApprehensionLabelLocationY = 260;
                    final int ReasonOfApprehensionLabelWidth     = 150;
                    final int ReasonOfApprehensionLabelHeight    = 11;

                    Document.add(ReasonOfApprehensionLabel);
                    ReasonOfApprehensionLabel.setBounds(ReasonOfApprehensionLabelLocationX, ReasonOfApprehensionLabelLocationY, ReasonOfApprehensionLabelWidth, ReasonOfApprehensionLabelHeight);
                    ReasonOfApprehensionLabel.setForeground(new Color(0, 0, 0));
                    ReasonOfApprehensionLabel.setFont(new Font("Times New Roman", Font.PLAIN, 11));
                    ReasonOfApprehensionLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
                    ReasonOfApprehensionLabel.setText("Reason of Apprehension :");
                    ReasonOfApprehensionLabel.setVisible(true);
                
                // Person's Mug shot (JLabel) Decorations.
                    final int MugshotLocationX = 323;
                    final int MugshotLocationY = 160;
                    final int MugshotWidth = 130;
                    final int MugshotHeight = 130;

                    Document.add(MugShot);
                    MugShot.setBounds(MugshotLocationX, MugshotLocationY, MugshotWidth, MugshotHeight);
                    MugShot.setBackground(new Color(237, 242, 244));
                    MugShot.setOpaque(true);
                    MugShot.setHorizontalAlignment(SwingConstants.CENTER);
                    MugShot.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
                    MugShot.setLayout(null);
                    MugShot.setVisible(true);

                    ImageIcon findMugshot = new ImageIcon("src\\PRMS Files\\icons\\USER-ICON.png");
                    Image importMugshot = findMugshot.getImage();
                    Image scaleMugshot = importMugshot.getScaledInstance(MugShot.getWidth(), MugShot.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon scaledMugshot = new ImageIcon(scaleMugshot);
                    MugShot.setIcon(scaledMugshot);
                
                // Header Top Label (JLabel) Decorations.
                
                    final int LineOneLocationX = 0;
                    final int LineOneLocationY = 300;
                    final int LineOneWidth     = 500;
                    final int LineOneHeight    = 11;

                    Document.add(LineOne);
                    LineOne.setBounds(LineOneLocationX, LineOneLocationY, LineOneWidth, LineOneHeight);
                    LineOne.setForeground(new Color(0, 0, 0));
                    LineOne.setFont(new Font("Times New Roman", Font.PLAIN, 11));
                    LineOne.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    LineOne.setText("------------------------------------------------------------------------------------------------------");
                    LineOne.setVisible(true);
                    
                // Arrest Information Label (JLabel) Decorations.
                
                    final int ArrestInfoLabelLocationX = 0;
                    final int ArrestInfoLabelLocationY = 320;
                    final int ArrestInfoLabelWidth     = 500;
                    final int ArrestInfoLabelHeight    = 11;

                    Document.add(ArrestInfoLabel);
                    ArrestInfoLabel.setBounds(ArrestInfoLabelLocationX, ArrestInfoLabelLocationY, ArrestInfoLabelWidth, ArrestInfoLabelHeight);
                    ArrestInfoLabel.setForeground(new Color(0, 0, 0));
                    ArrestInfoLabel.setFont(new Font("Times New Roman", Font.PLAIN, 11));
                    ArrestInfoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    ArrestInfoLabel.setText("Arrest and Sentencing Inforamation");
                    ArrestInfoLabel.setVisible(true);
            
            // List of Records (JTable) Decorations.
            final int RecordsListLocationX = 20;
            final int RecordsListLocationY = 200;
            final int RecordsListWidth = 440;
            final int RecordsListHeight = 220;

            PrintBackground.add(PoliceDatabase);
            PoliceDatabase.setBounds(RecordsListLocationX, RecordsListLocationY, RecordsListWidth, RecordsListHeight);
            PoliceDatabase.setForeground(new Color(0, 0, 0));
            PoliceDatabase.setBackground(new Color(237, 242, 244));
            PoliceDatabase.setFont(new Font("Tahoma", 0, 14));
            PoliceDatabase.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            PoliceDatabase.enableInputMethods(false);
            PoliceDatabase.setLayout(null);
            PoliceDatabase.setVisible(true);

            /*PoliceDatabase.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    PoliceRecordsFunction(evt);
                }
            });*/

            // List of Records (JScrollpane) Decorations.
            PrintBackground.add(ListScrollbar);
            ListScrollbar.setBounds(RecordsListLocationX, RecordsListLocationY, RecordsListWidth, RecordsListHeight);
            ListScrollbar.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            ListScrollbar.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
            ListScrollbar.setViewportBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
            ListScrollbar.setAutoscrolls(true);
            ListScrollbar.setEnabled(true);
            ListScrollbar.setWheelScrollingEnabled(true);
            ListScrollbar.setFocusable(true);
            ListScrollbar.getViewport().add(PoliceDatabase);
            
            // Search Records (JLabel) Decorations.
        final int SearchLabelLocationX = 40;
        final int SearchLabelLocationY = 450;
        final int SearchLabelWidth = 130;
        final int SearchLabelHeight = 35;

        PrintBackground.add(PrintSearchLabel);
        PrintSearchLabel.setBounds(SearchLabelLocationX, SearchLabelLocationY, SearchLabelWidth, SearchLabelHeight);
        PrintSearchLabel.setForeground(new Color(255, 255, 255));
        PrintSearchLabel.setFont(new Font("Quicksand", Font.PLAIN, 16));
        PrintSearchLabel.setText("Search :");
        PrintSearchLabel.setVisible(true);

        // Search Bar (JTextField) Decorations.
        final int SearchBarLocationX = 110;
        final int SearchBarLocationY = 455;
        final int SearchBarWidth = 300;
        final int SearchBarHeight = 35;

        PrintBackground.add(PrintSearch);
        PrintSearch.setBounds(SearchBarLocationX, SearchBarLocationY, SearchBarWidth, SearchBarHeight);
        PrintSearch.setBackground(new Color(0, 0, 0, 0));
        PrintSearch.setForeground(new Color(237, 242, 244));
        PrintSearch.setOpaque(false);
        PrintSearch.setCaretColor(new Color(237, 242, 244));
        PrintSearch.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(237, 242, 244)));
        PrintSearch.setFont(new Font("Quicksand", Font.PLAIN, 18));
        PrintSearch.setVisible(true);

        PrintSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchBarKeyPressed(evt);
            }
        });

        // Reset Fields (JButton) Decorations
            final int ResetDocumentLocationX = 100;
            final int ResetDocumentLocationY = 550;
            final int ResetDocumentButtonWidth = 120;
            final int ResetDocumentHeight = 35;

            PrintBackground.add(ClearDocument);
            ClearDocument.setBounds(ResetDocumentLocationX, ResetDocumentLocationY, ResetDocumentButtonWidth, ResetDocumentHeight);
            ClearDocument.setBackground(new Color(248, 249, 250));
            ClearDocument.setFont(new Font("Quicksand", Font.PLAIN, 14));
            ClearDocument.setFocusPainted(false);
            ClearDocument.setHorizontalAlignment(SwingConstants.CENTER);
            ClearDocument.setOpaque(false);
            ClearDocument.setForeground(new Color(0, 0, 0));
            ClearDocument.setText("CLEAR");
            ClearDocument.setVisible(true);

            ClearDocument.setContentAreaFilled(true);
            ClearDocument.setBorderPainted(false);
            ClearDocument.setIconTextGap(-2);

            ClearDocument.addMouseListener(new MouseAdapter() {

                @Override
                public void mousePressed(MouseEvent e) {
                    ClearDocument.setBackground(new Color(0, 0, 0));
                    ClearDocument.setForeground(new Color(255, 255, 255));

                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    ClearDocument.setBackground(new Color(248, 249, 250));
                    ClearDocument.setForeground(new Color(0, 0, 0));
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    ClearDocument.setBackground(new Color(150, 150, 150));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    ClearDocument.setBackground(new Color(248, 249, 250));
                    ClearDocument.setForeground(new Color(0, 0, 0));
                }

            });

            /*ClearDocument.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    ResetButtonFunction(evt);
                }
            });*/
        
        // Print Document (JButton) Decorations
            final int PrintDocumentButtonLocationX = 270;
            final int PrintDocumentButtonLocationY = 550;
            final int PrintDocumentButtonWidth = 120;
            final int PrintDocumentButtonHeight = 35;

            PrintBackground.add(PrintDocument);
            PrintDocument.setBounds(PrintDocumentButtonLocationX, PrintDocumentButtonLocationY, PrintDocumentButtonWidth, PrintDocumentButtonHeight);
            PrintDocument.setBackground(new Color(248, 249, 250));
            PrintDocument.setFont(new Font("Quicksand", Font.PLAIN, 14));
            PrintDocument.setFocusPainted(false);
            PrintDocument.setHorizontalAlignment(SwingConstants.CENTER);
            PrintDocument.setOpaque(false);
            PrintDocument.setForeground(new Color(0, 0, 0));
            PrintDocument.setText("PRINT");
            PrintDocument.setVisible(true);

            PrintDocument.setContentAreaFilled(true);
            PrintDocument.setBorderPainted(false);
            PrintDocument.setIconTextGap(-2);

            PrintDocument.addMouseListener(new MouseAdapter() {

                @Override
                public void mousePressed(MouseEvent e) {
                    PrintDocument.setBackground(new Color(0, 0, 0));
                    PrintDocument.setForeground(new Color(255, 255, 255));

                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    PrintDocument.setBackground(new Color(248, 249, 250));
                    PrintDocument.setForeground(new Color(0, 0, 0));
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    PrintDocument.setBackground(new Color(150, 150, 150));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    PrintDocument.setBackground(new Color(248, 249, 250));
                    PrintDocument.setForeground(new Color(0, 0, 0));
                }

            });

            /*ClearDocument.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    ResetButtonFunction(evt);
                }
            });*/    
            
            // BackButton (JButton) Decorations.
        final int BackButtonLocationX = 20;
        final int BackButtonLocationY = 20;
        final int BackButtonWidth = 100;
        final int BackButtonHeight = 35;

        PrintBackground.add(BackButton);
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
    
    // CLASS FUNCTIONS
    
    private void GetDataFromDatabase() {
        Connection dbconn = DBConnection.connectDB();
        String sqlQuery = "SELECT * FROM prmscriminalrecords";
        if (dbconn != null) {
            try {
                Statement st = (Statement) dbconn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = st.executeQuery(sqlQuery);
                PoliceDatabase.setModel(DbUtils.resultSetToTableModel(rs));
                PoliceDatabase.getColumnModel().getColumn(0).setPreferredWidth(50);
                PoliceDatabase.getColumnModel().getColumn(1).setPreferredWidth(150);
                PoliceDatabase.getColumnModel().getColumn(2).setPreferredWidth(150);
                PoliceDatabase.getColumnModel().getColumn(3).setPreferredWidth(150);
                PoliceDatabase.getColumnModel().getColumn(4).setPreferredWidth(400);
                PoliceDatabase.getColumnModel().getColumn(5).setPreferredWidth(150);
                PoliceDatabase.getColumnModel().getColumn(6).setPreferredWidth(150);
                PoliceDatabase.getColumnModel().getColumn(7).setPreferredWidth(150);
                PoliceDatabase.getColumnModel().getColumn(8).setPreferredWidth(150);
                PoliceDatabase.getColumnModel().getColumn(9).setPreferredWidth(150);
                PoliceDatabase.getColumnModel().getColumn(10).setPreferredWidth(150);
                TableColumn tcol = PoliceDatabase.getColumnModel().getColumn(11);
                PoliceDatabase.removeColumn(tcol);

                String header[] = {"ID", "LAST NAME", "FIRST NAME", "MIDDLE NAME", "ADDRESS", "DATE OF ARREST", "DATE OF RELEASE", "AGE", "GENDER", "STATUS", "ORIGIN", ""};

                for (int i = 0; i < PoliceDatabase.getColumnCount(); i++) {
                    TableColumn column1 = PoliceDatabase.getTableHeader().getColumnModel().getColumn(i);

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
    
    private void SearchBarKeyPressed(KeyEvent evt) {

        DefaultTableModel table = (DefaultTableModel) PoliceDatabase.getModel();
        String search = PrintSearch.getText();
        @SuppressWarnings("Convert2Diamond")
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        PoliceDatabase.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));

    }
    
    private void BackButtonFunction(ActionEvent evt){
        dispose();
    }
    
    public static void main(String args[]){
        
        PRMSPrint Open = new PRMSPrint();
        Open.setVisible(true);
        
    }
}
