
package PRMSClasses;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
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
            
            ArrestInfoLabel,
            
            HeaderButtom, FingerPrintLabel, FPRightThumbBox, FPLeftThumbBox, FPRightIndexBox, FPLeftIndexBox,
            FPRightThumbLabel, FPLeftThumbLabel, FPRightIndexLabel, FPLeftIndexLabel,
            
             SignatureLabel,
            
            OtherInfoLabel;
    
    JButton BackButton, ClearDocument, PrintDocument;
    
    JTextField PrintSearch, CaseNumLine,
               IDField, NameField, GenderField, AgeField, ProvinceOfOriginField, HomeAddressField, DateArrestedField, ReleaseDateField,
               ReasonOfApprehensionField,
               SignatureLine,
               OtherInfoLineOne, OtherInfoLineTwo, OtherInfoLineThree, OtherInfoLineFour,
               OtherInfoLineFive, OtherInfoLineSix, OtherInfoLineSeven, OtherInfoLineEight,
               OtherInfoLineNine, OtherInfoLineTen;
                
    
    JTable PoliceDatabase, ArrestInfoDocument;
    
    JScrollPane ListScrollbar;
    
    Font IronShark, Quicksand, Gepestev;
    
    // FRAME DRAGGER
    int xMouse;
    int yMouse;
    
    
    public PRMSPrint(){
        
        SetComponentLookAndFeel();
     
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
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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

        HeaderButtom = new JLabel(); 
        FingerPrintLabel = new JLabel(); 
        FPRightThumbBox = new JLabel(); 
        FPLeftThumbBox = new JLabel(); 
        FPRightIndexBox = new JLabel(); 
        FPLeftIndexBox = new JLabel();
        FPRightThumbLabel = new JLabel(); 
        FPLeftThumbLabel = new JLabel();
        FPRightIndexLabel = new JLabel();
        FPLeftIndexLabel = new JLabel();

        SignatureLine = new JTextField(); 
        SignatureLabel = new JLabel();

        OtherInfoLabel = new JLabel();
        OtherInfoLineOne = new JTextField(); 
        OtherInfoLineTwo = new JTextField();
        OtherInfoLineThree = new JTextField();
        OtherInfoLineFour = new JTextField();
        OtherInfoLineFive = new JTextField();
        OtherInfoLineSix = new JTextField();
        OtherInfoLineSeven = new JTextField();
        OtherInfoLineEight = new JTextField();
        OtherInfoLineNine = new JTextField();
        OtherInfoLineTen = new JTextField();

        PrintLabel = new JLabel();
        PrintSearchLabel = new JLabel();
        
        BackButton = new JButton();
        ClearDocument = new JButton();
        PrintDocument = new JButton();
        
        PrintSearch = new JTextField();
        
        CaseNumLine = new JTextField();
        IDField = new JTextField();
        NameField = new JTextField();
        GenderField = new JTextField();
        AgeField = new JTextField();
        HomeAddressField = new JTextField();
        ProvinceOfOriginField = new JTextField();
        DateArrestedField = new JTextField(); 
        ReleaseDateField = new JTextField();
        ReasonOfApprehensionField = new JTextField(); 
        
        PoliceDatabase = new JTable(){

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        
        ListScrollbar = new JScrollPane();
        
        // </editor-fold>
        
        // PRMS Print Frame dragging Declaration.
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
            Document.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(0, 0, 0)));
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
                    ReportSheetLabel.setText("POLICE  REPORT");
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
                    
                    // Gender Field (JTextField) Decorations.
                    final int GenderFieldLocationX = 100;
                    final int GenderFieldLocationY = 160;
                    final int GenderFieldWidth = 60;
                    final int GenderFieldHeight = 11;

                    Document.add(GenderField);
                    GenderField.setBounds(GenderFieldLocationX, GenderFieldLocationY, GenderFieldWidth, GenderFieldHeight);
                    GenderField.setBackground(new Color(0, 0, 0, 0));
                    GenderField.setForeground(new Color(0, 0, 0));
                    GenderField.setEditable(false);
                    GenderField.setOpaque(false);
                    GenderField.setCaretColor(new Color(0, 0, 0, 0));
                    GenderField.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(0, 0, 0)));
                    GenderField.setFont(new Font("Times New Roman", Font.BOLD, 11));
                    GenderField.setVisible(true);
                    
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
                    
                    // Print Age Field  (JTextField) Decorations.
                    final int PrintAgeFieldLocationX = 200;
                    final int PrintAgeFieldLocationY = 160;
                    final int PrintAgeFieldWidth = 45;
                    final int PrintAgeFieldHeight = 11;

                    Document.add(AgeField);
                    AgeField.setBounds(PrintAgeFieldLocationX, PrintAgeFieldLocationY, PrintAgeFieldWidth, PrintAgeFieldHeight);
                    AgeField.setBackground(new Color(0, 0, 0, 0));
                    AgeField.setForeground(new Color(0, 0, 0));
                    AgeField.setEditable(false);
                    AgeField.setOpaque(false);
                    AgeField.setCaretColor(new Color(0, 0, 0, 0));
                    AgeField.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(0, 0, 0)));
                    AgeField.setFont(new Font("Times New Roman", Font.BOLD, 11));
                    AgeField.setVisible(true);
  
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
                    
                    // Print Home Address Field  (JTextField) Decorations.
                    final int HomeAddressFieldLocationX = 130;
                    final int HomeAddressFieldLocationY = 180;
                    final int HomeAddressFieldWidth = 180;
                    final int HomeAddressFieldHeight = 11;

                    Document.add(HomeAddressField);
                    HomeAddressField.setBounds(HomeAddressFieldLocationX, HomeAddressFieldLocationY, HomeAddressFieldWidth, HomeAddressFieldHeight);
                    HomeAddressField.setBackground(new Color(0, 0, 0, 0));
                    HomeAddressField.setForeground(new Color(0, 0, 0));
                    HomeAddressField.setEditable(false);
                    HomeAddressField.setOpaque(false);
                    HomeAddressField.setCaretColor(new Color(0, 0, 0, 0));
                    HomeAddressField.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(0, 0, 0)));
                    HomeAddressField.setFont(new Font("Times New Roman", Font.BOLD, 11));
                    HomeAddressField.setVisible(true);
                    
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
                    
                    // Print Province Of Origin Field  (JTextField) Decorations.
                    final int ProvinceOfOriginFieldLocationX = 155;
                    final int ProvinceOfOriginFieldLocationY = 200;
                    final int ProvinceOfOriginFieldWidth = 250;
                    final int ProvinceOfOriginFieldHeight = 11;

                    Document.add(ProvinceOfOriginField);
                    ProvinceOfOriginField.setBounds(ProvinceOfOriginFieldLocationX, ProvinceOfOriginFieldLocationY, ProvinceOfOriginFieldWidth, ProvinceOfOriginFieldHeight);
                    ProvinceOfOriginField.setBackground(new Color(0, 0, 0, 0));
                    ProvinceOfOriginField.setForeground(new Color(0, 0, 0));
                    ProvinceOfOriginField.setEditable(false);
                    ProvinceOfOriginField.setOpaque(false);
                    ProvinceOfOriginField.setCaretColor(new Color(0, 0, 0, 0));
                    ProvinceOfOriginField.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(0, 0, 0)));
                    ProvinceOfOriginField.setFont(new Font("Times New Roman", Font.BOLD, 11));
                    ProvinceOfOriginField.setVisible(true);
                
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
                    
                    // Print Date Arrested Field  (JTextField) Decorations.
                    final int DateArrestedFieldLocationX = 130;
                    final int DateArrestedFieldLocationY = 220;
                    final int DateArrestedFieldWidth = 200;
                    final int DateArrestedFieldHeight = 11;

                    Document.add(DateArrestedField);
                    DateArrestedField.setBounds(DateArrestedFieldLocationX, DateArrestedFieldLocationY, DateArrestedFieldWidth, DateArrestedFieldHeight);
                    DateArrestedField.setBackground(new Color(0, 0, 0, 0));
                    DateArrestedField.setForeground(new Color(0, 0, 0));
                    DateArrestedField.setEditable(false);
                    DateArrestedField.setOpaque(false);
                    DateArrestedField.setCaretColor(new Color(0, 0, 0, 0));
                    DateArrestedField.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(0, 0, 0)));
                    DateArrestedField.setFont(new Font("Times New Roman", Font.BOLD, 11));
                    DateArrestedField.setVisible(true);
                    
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
                    
                    // Print Release Date Field  (JTextField) Decorations.
                    final int DateReleaseDateLocationX = 125;
                    final int DateReleaseDateLocationY = 240;
                    final int DateReleaseDateFieldWidth = 200;
                    final int DateReleaseDateFieldHeight = 11;

                    Document.add(ReleaseDateField);
                    ReleaseDateField.setBounds(DateReleaseDateLocationX, DateReleaseDateLocationY, DateReleaseDateFieldWidth, DateReleaseDateFieldHeight);
                    ReleaseDateField.setBackground(new Color(0, 0, 0, 0));
                    ReleaseDateField.setForeground(new Color(0, 0, 0));
                    ReleaseDateField.setEditable(false);
                    ReleaseDateField.setOpaque(false);
                    ReleaseDateField.setCaretColor(new Color(0, 0, 0, 0));
                    ReleaseDateField.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(0, 0, 0)));
                    ReleaseDateField.setFont(new Font("Times New Roman", Font.BOLD, 11));
                    ReleaseDateField.setVisible(true);
                    
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
                    
                    // Print Reason Of Apprehension Field (JTextField) Decorations.
                    final int ReasonOfApprehensionFieldLocationX = 180;
                    final int ReasonOfApprehensionFieldLocationY = 260;
                    final int ReasonOfApprehensionFieldWidth = 130;
                    final int ReasonOfApprehensionFieldHeight = 11;

                    Document.add(ReasonOfApprehensionField);
                    ReasonOfApprehensionField.setBounds(ReasonOfApprehensionFieldLocationX, ReasonOfApprehensionFieldLocationY, ReasonOfApprehensionFieldWidth, ReasonOfApprehensionFieldHeight);
                    ReasonOfApprehensionField.setBackground(new Color(0, 0, 0, 0));
                    ReasonOfApprehensionField.setForeground(new Color(0, 0, 0));
                    ReasonOfApprehensionField.setEditable(false);
                    ReasonOfApprehensionField.setOpaque(false);
                    ReasonOfApprehensionField.setCaretColor(new Color(0, 0, 0, 0));
                    ReasonOfApprehensionField.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(0, 0, 0)));
                    ReasonOfApprehensionField.setFont(new Font("Times New Roman", Font.BOLD, 11));
                    ReasonOfApprehensionField.setVisible(true);
                
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
                    ArrestInfoLabel.setText("Arrest and Sentencing Information");
                    ArrestInfoLabel.setVisible(true);
                    
                // Arrest Info Table (JTable) Decorations.
                
                    final int ArrestInfoLocationX = 50;
                    final int ArrestInfoLocationY = 340;
                    final int ArrestInfoWidth     = 401;
                    final int ArrestInfoHeight    = 48;
                    
                    String[][] data = {
                        {"                DATE","             CHARGES","                 TERM"},
                        {"","",""},
                        {"","",""}
                    };

                    String[] header = {"","",""};
                    
                    ArrestInfoDocument = new JTable(data,header) {

                        @Override
                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }

                    };

                    Document.add(ArrestInfoDocument);
                    ArrestInfoDocument.setBounds(ArrestInfoLocationX,ArrestInfoLocationY, ArrestInfoWidth, ArrestInfoHeight);
                    ArrestInfoDocument.setOpaque(false);
                    ArrestInfoDocument.setFont(new Font("Times New Roman", Font.PLAIN, 11));
                    ArrestInfoDocument.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
                    ArrestInfoDocument.setBackground(new Color(0,0,0,0));
                    ArrestInfoDocument.setForeground(new Color(0,0,0,255));
                    ArrestInfoDocument.setEnabled(false);
                    ArrestInfoDocument.setShowGrid(true);
                    ArrestInfoDocument.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                    ArrestInfoDocument.enableInputMethods(false);
                    ArrestInfoDocument.setLayout(null);
                    ArrestInfoDocument.setGridColor(Color.BLACK);
                    ArrestInfoDocument.setShowHorizontalLines(true);
                    ArrestInfoDocument.setShowVerticalLines(true);
                    ArrestInfoDocument.getColumnModel().getColumn(0).setPreferredWidth(100);
                    ArrestInfoDocument.getColumnModel().getColumn(1).setPreferredWidth(100);
                    ArrestInfoDocument.getColumnModel().getColumn(2).setPreferredWidth(100);

                    ArrestInfoDocument.setAutoCreateColumnsFromModel(true);
                    ArrestInfoDocument.setVisible(true);
                    
                    // Header Top Label (JLabel) Decorations.
                
                    final int HeaderButtomLocationX = 0;
                    final int HeaderButtomLocationY = 400;
                    final int HeaderButtomWidth     = 500;
                    final int HeaderButtomHeight    = 11;

                    Document.add(HeaderButtom);
                    HeaderButtom.setBounds(HeaderButtomLocationX, HeaderButtomLocationY, HeaderButtomWidth, HeaderButtomHeight);
                    HeaderButtom.setForeground(new Color(0, 0, 0));
                    HeaderButtom.setFont(new Font("Times New Roman", Font.PLAIN, 11));
                    HeaderButtom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    HeaderButtom.setText("------------------------------------------------------------------------------------------------------");
                    HeaderButtom.setVisible(true);
                    
                    // Finger Print Label (JLabel) Decorations.
                
                    final int FingerPrintLabelLocationX = 0;
                    final int FingerPrintLabelLocationY = 420;
                    final int FingerPrintLabelWidth     = 328;
                    final int FingerPrintLabelHeight    = 11;

                    Document.add(FingerPrintLabel);
                    FingerPrintLabel.setBounds(FingerPrintLabelLocationX, FingerPrintLabelLocationY, FingerPrintLabelWidth, FingerPrintLabelHeight);
                    FingerPrintLabel.setForeground(new Color(0, 0, 0));
                    FingerPrintLabel.setFont(new Font("Times New Roman", Font.PLAIN, 11));
                    FingerPrintLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    FingerPrintLabel.setText("- FINGERPRINTS -");
                    FingerPrintLabel.setVisible(true);
                    
                    // Person's Right Thumb FingerPrint shot (JLabel) Decorations.
                    final int FPRightThumbBoxLocationX = 50;
                    final int FPRightThumbBoxLocationY = 440;
                    final int FPRightThumbBoxWidth = 50;
                    final int FPRightThumbBoxHeight = 70;

                    Document.add(FPRightThumbBox);
                    FPRightThumbBox.setBounds(FPRightThumbBoxLocationX, FPRightThumbBoxLocationY, FPRightThumbBoxWidth, FPRightThumbBoxHeight);
                    FPRightThumbBox.setBackground(new Color(237, 242, 244));
                    FPRightThumbBox.setOpaque(false);
                    FPRightThumbBox.setHorizontalAlignment(SwingConstants.CENTER);
                    FPRightThumbBox.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
                    FPRightThumbBox.setLayout(null);
                    FPRightThumbBox.setVisible(true);
                    
                    // Person's Left Thumb FingerPrint shot (JLabel) Decorations.
                    final int FPLeftThumbBoxLocationX = 110;
                    final int FPLeftThumbBoxLocationY = 440;
                    final int FPLeftThumbBoxWidth = 50;
                    final int FPLeftThumbBoxHeight = 70;

                    Document.add(FPLeftThumbBox);
                    FPLeftThumbBox.setBounds(FPLeftThumbBoxLocationX, FPLeftThumbBoxLocationY, FPLeftThumbBoxWidth, FPLeftThumbBoxHeight);
                    FPLeftThumbBox.setBackground(new Color(237, 242, 244));
                    FPLeftThumbBox.setOpaque(false);
                    FPLeftThumbBox.setHorizontalAlignment(SwingConstants.CENTER);
                    FPLeftThumbBox.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
                    FPLeftThumbBox.setLayout(null);
                    FPLeftThumbBox.setVisible(true);
                    
                    // Person's Right Index FingerPrint shot (JLabel) Decorations.
                    final int FPRightIndexBoxLocationX = 170;
                    final int FPRightIndexBoxLocationY = 440;
                    final int FPRightIndexBoxWidth = 50;
                    final int FPRightIndexBoxHeight = 70;

                    Document.add(FPRightIndexBox);
                    FPRightIndexBox.setBounds(FPRightIndexBoxLocationX, FPRightIndexBoxLocationY, FPRightIndexBoxWidth, FPRightIndexBoxHeight);
                    FPRightIndexBox.setBackground(new Color(237, 242, 244));
                    FPRightIndexBox.setOpaque(false);
                    FPRightIndexBox.setHorizontalAlignment(SwingConstants.CENTER);
                    FPRightIndexBox.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
                    FPRightIndexBox.setLayout(null);
                    FPRightIndexBox.setVisible(true);
                    
                    // Person's Left Index FingerPrint shot (JLabel) Decorations.
                    final int FPLeftIndexBoxLocationX = 230;
                    final int FPLeftIndexBoxLocationY = 440;
                    final int FPLeftIndexBoxWidth = 50;
                    final int FPLeftIndexBoxHeight = 70;

                    Document.add(FPLeftIndexBox);
                    FPLeftIndexBox.setBounds(FPLeftIndexBoxLocationX, FPLeftIndexBoxLocationY, FPLeftIndexBoxWidth, FPLeftIndexBoxHeight);
                    FPLeftIndexBox.setBackground(new Color(237, 242, 244));
                    FPLeftIndexBox.setOpaque(false);
                    FPLeftIndexBox.setHorizontalAlignment(SwingConstants.CENTER);
                    FPLeftIndexBox.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
                    FPLeftIndexBox.setLayout(null);
                    FPLeftIndexBox.setVisible(true);

                    // Signature Line (JTextField) Decorations.
                    final int SignatureLineLocationX = 68;
                    final int SignatureLineLocationY = 530;
                    final int SignatureLineWidth = 200;
                    final int SignatureLineHeight = 35;

                    Document.add(SignatureLine);
                    SignatureLine.setBounds(SignatureLineLocationX, SignatureLineLocationY, SignatureLineWidth, SignatureLineHeight);
                    SignatureLine.setBackground(new Color(0, 0, 0, 0));
                    SignatureLine.setForeground(new Color(0,0,0));
                    SignatureLine.setOpaque(false);
                    SignatureLine.setCaretColor(new Color(0,0,0,0));
                    SignatureLine.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0, 0, 0)));
                    SignatureLine.setFont(new Font("Times New Roman", Font.PLAIN, 18));
                    SignatureLine.setVisible(true);

                    // Signature Label (JTextField) Decorations.
                    final int SignatureLabelLocationX = 68;
                    final int SignatureLabelLocationY = 560;
                    final int SignatureLabelWidth = 200;
                    final int SignatureLabelHeight = 35;

                    Document.add(SignatureLabel);
                    SignatureLabel.setBounds(SignatureLabelLocationX, SignatureLabelLocationY, SignatureLabelWidth, SignatureLabelHeight);
                    SignatureLabel.setBackground(new Color(0,0,0,0));
                    SignatureLabel.setForeground(new Color(0, 0, 0));
                    SignatureLabel.setFont(new Font("Times New Roman", Font.PLAIN, 11));
                    SignatureLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    SignatureLabel.setText("SIGNATURE/PRINTED NAME");
                    SignatureLabel.setVisible(true);

                    // Other Info Label (JTextField) Decorations.
                    final int OtherInfoLabelLocationX = 275;
                    final int OtherInfoLabelLocationY = 408;
                    final int OtherInfoLabelWidth = 200;
                    final int OtherInfoLabelHeight = 35;

                    Document.add(OtherInfoLabel);
                    OtherInfoLabel.setBounds(OtherInfoLabelLocationX, OtherInfoLabelLocationY, OtherInfoLabelWidth, OtherInfoLabelHeight);
                    OtherInfoLabel.setBackground(new Color(0,0,0,0));
                    OtherInfoLabel.setForeground(new Color(0, 0, 0));
                    OtherInfoLabel.setFont(new Font("Times New Roman", Font.PLAIN, 11));
                    OtherInfoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    OtherInfoLabel.setText("- Other Information -");
                    OtherInfoLabel.setVisible(true);
                    
                    // Other Info Line One (JTextField) Decorations.
                    final int OtherInfoLineOneLocationX = 300;
                    final int OtherInfoLineOneLocationY = 416;
                    final int OtherInfoLineOneWidth = 150;
                    final int OtherInfoLineOneHeight = 35;

                    Document.add(OtherInfoLineOne);
                    OtherInfoLineOne.setBounds(OtherInfoLineOneLocationX, OtherInfoLineOneLocationY, OtherInfoLineOneWidth, OtherInfoLineOneHeight);
                    OtherInfoLineOne.setBackground(new Color(0, 0, 0, 0));
                    OtherInfoLineOne.setForeground(new Color(0,0,0));
                    OtherInfoLineOne.setOpaque(false);
                    OtherInfoLineOne.setCaretColor(new Color(0,0,0,0));
                    OtherInfoLineOne.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0, 0, 0)));
                    OtherInfoLineOne.setFont(new Font("Times New Roman", Font.PLAIN, 18));
                    OtherInfoLineOne.setVisible(true);
                    
                    // Other Info Line Two (JTextField) Decorations.
                    final int OtherInfoLineTwoLocationX = 300;
                    final int OtherInfoLineTwoLocationY = 431;
                    final int OtherInfoLineTwoWidth = 150;
                    final int OtherInfoLineTwoHeight = 35;

                    Document.add(OtherInfoLineTwo);
                    OtherInfoLineTwo.setBounds(OtherInfoLineTwoLocationX, OtherInfoLineTwoLocationY, OtherInfoLineTwoWidth, OtherInfoLineTwoHeight);
                    OtherInfoLineTwo.setBackground(new Color(0, 0, 0, 0));
                    OtherInfoLineTwo.setForeground(new Color(0,0,0));
                    OtherInfoLineTwo.setOpaque(false);
                    OtherInfoLineTwo.setCaretColor(new Color(0,0,0,0));
                    OtherInfoLineTwo.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0, 0, 0)));
                    OtherInfoLineTwo.setFont(new Font("Times New Roman", Font.PLAIN, 18));
                    OtherInfoLineTwo.setVisible(true);
                    
                    // Other Info Line Three (JTextField) Decorations.
                    final int OtherInfoLineThreeLocationX = 300;
                    final int OtherInfoLineThreeLocationY = 446;
                    final int OtherInfoLineThreeWidth = 150;
                    final int OtherInfoLineThreeHeight = 35;

                    Document.add(OtherInfoLineThree);
                    OtherInfoLineThree.setBounds(OtherInfoLineThreeLocationX, OtherInfoLineThreeLocationY, OtherInfoLineThreeWidth, OtherInfoLineThreeHeight);
                    OtherInfoLineThree.setBackground(new Color(0, 0, 0, 0));
                    OtherInfoLineThree.setForeground(new Color(0,0,0));
                    OtherInfoLineThree.setOpaque(false);
                    OtherInfoLineThree.setCaretColor(new Color(0,0,0,0));
                    OtherInfoLineThree.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0, 0, 0)));
                    OtherInfoLineThree.setFont(new Font("Times New Roman", Font.PLAIN, 18));
                    OtherInfoLineThree.setVisible(true);
                    
                    // Other Info Line Four (JTextField) Decorations.
                    final int OtherInfoLineFourLocationX = 300;
                    final int OtherInfoLineFourLocationY = 461;
                    final int OtherInfoLineFourWidth = 150;
                    final int OtherInfoLineFourHeight = 35;

                    Document.add(OtherInfoLineFour);
                    OtherInfoLineFour.setBounds(OtherInfoLineFourLocationX, OtherInfoLineFourLocationY, OtherInfoLineFourWidth, OtherInfoLineFourHeight);
                    OtherInfoLineFour.setBackground(new Color(0, 0, 0, 0));
                    OtherInfoLineFour.setForeground(new Color(0,0,0));
                    OtherInfoLineFour.setOpaque(false);
                    OtherInfoLineFour.setCaretColor(new Color(0,0,0,0));
                    OtherInfoLineFour.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0, 0, 0)));
                    OtherInfoLineFour.setFont(new Font("Times New Roman", Font.PLAIN, 18));
                    OtherInfoLineFour.setVisible(true);
                    
                    // Other Info Line Five (JTextField) Decorations.
                    final int OtherInfoLineFiveLocationX = 300;
                    final int OtherInfoLineFivLocationY = 476;
                    final int OtherInfoLineFivWidth = 150;
                    final int OtherInfoLineFivHeight = 35;

                    Document.add(OtherInfoLineFive);
                    OtherInfoLineFive.setBounds(OtherInfoLineFiveLocationX, OtherInfoLineFivLocationY, OtherInfoLineFivWidth, OtherInfoLineFivHeight);
                    OtherInfoLineFive.setBackground(new Color(0, 0, 0, 0));
                    OtherInfoLineFive.setForeground(new Color(0,0,0));
                    OtherInfoLineFive.setOpaque(false);
                    OtherInfoLineFive.setCaretColor(new Color(0,0,0,0));
                    OtherInfoLineFive.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0, 0, 0)));
                    OtherInfoLineFive.setFont(new Font("Times New Roman", Font.PLAIN, 18));
                    OtherInfoLineFive.setVisible(true);
                    
                    // Other Info Line Six (JTextField) Decorations.
                    final int OtherInfoLineSixLocationX = 300;
                    final int OtherInfoLineSixLocationY = 491;
                    final int OtherInfoLineSixWidth = 150;
                    final int OtherInfoLineSixHeight = 35;

                    Document.add(OtherInfoLineSix);
                    OtherInfoLineSix.setBounds(OtherInfoLineSixLocationX, OtherInfoLineSixLocationY, OtherInfoLineSixWidth, OtherInfoLineSixHeight);
                    OtherInfoLineSix.setBackground(new Color(0, 0, 0, 0));
                    OtherInfoLineSix.setForeground(new Color(0,0,0));
                    OtherInfoLineSix.setOpaque(false);
                    OtherInfoLineSix.setCaretColor(new Color(0,0,0,0));
                    OtherInfoLineSix.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0, 0, 0)));
                    OtherInfoLineSix.setFont(new Font("Times New Roman", Font.PLAIN, 18));
                    OtherInfoLineSix.setVisible(true);
                    
                    // Other Info Line Seven (JTextField) Decorations.
                    final int OtherInfoLineSevenLocationX = 300;
                    final int OtherInfoLineSevenLocationY = 506;
                    final int OtherInfoLineSevenWidth = 150;
                    final int OtherInfoLineSevenHeight = 35;

                    Document.add(OtherInfoLineSeven);
                    OtherInfoLineSeven.setBounds(OtherInfoLineSevenLocationX, OtherInfoLineSevenLocationY, OtherInfoLineSevenWidth, OtherInfoLineSevenHeight);
                    OtherInfoLineSeven.setBackground(new Color(0, 0, 0, 0));
                    OtherInfoLineSeven.setForeground(new Color(0,0,0));
                    OtherInfoLineSeven.setOpaque(false);
                    OtherInfoLineSeven.setCaretColor(new Color(0,0,0,0));
                    OtherInfoLineSeven.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0, 0, 0)));
                    OtherInfoLineSeven.setFont(new Font("Times New Roman", Font.PLAIN, 18));
                    OtherInfoLineSeven.setVisible(true);
                    
                    // Other Info Line Eight (JTextField) Decorations.
                    final int OtherInfoLineEightLocationX = 300;
                    final int OtherInfoLineEightLocationY = 521;
                    final int OtherInfoLineEightWidth = 150;
                    final int OtherInfoLineEightHeight = 35;

                    Document.add(OtherInfoLineEight);
                    OtherInfoLineEight.setBounds(OtherInfoLineEightLocationX, OtherInfoLineEightLocationY, OtherInfoLineEightWidth, OtherInfoLineEightHeight);
                    OtherInfoLineEight.setBackground(new Color(0, 0, 0, 0));
                    OtherInfoLineEight.setForeground(new Color(0,0,0));
                    OtherInfoLineEight.setOpaque(false);
                    OtherInfoLineEight.setCaretColor(new Color(0,0,0,0));
                    OtherInfoLineEight.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0, 0, 0)));
                    OtherInfoLineEight.setFont(new Font("Times New Roman", Font.PLAIN, 18));
                    OtherInfoLineEight.setVisible(true);
                    
                    // Other Info Line Eight (JTextField) Decorations.
                    final int OtherInfoLineNineLocationX = 300;
                    final int OtherInfoLineNineLocationY = 521;
                    final int OtherInfoLineNineWidth = 150;
                    final int OtherInfoLineNineHeight = 35;

                    Document.add(OtherInfoLineNine);
                    OtherInfoLineNine.setBounds(OtherInfoLineNineLocationX, OtherInfoLineNineLocationY, OtherInfoLineNineWidth, OtherInfoLineNineHeight);
                    OtherInfoLineNine.setBackground(new Color(0, 0, 0, 0));
                    OtherInfoLineNine.setForeground(new Color(0,0,0));
                    OtherInfoLineNine.setOpaque(false);
                    OtherInfoLineNine.setCaretColor(new Color(0,0,0,0));
                    OtherInfoLineNine.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0, 0, 0)));
                    OtherInfoLineNine.setFont(new Font("Times New Roman", Font.PLAIN, 18));
                    OtherInfoLineNine.setVisible(true);
                    
                    // Other Info Line Ten (JTextField) Decorations.
                    final int OtherInfoLineTenLocationX = 300;
                    final int OtherInfoLineTenLocationY = 536;
                    final int OtherInfoLineTenWidth = 150;
                    final int OtherInfoLineTenHeight = 35;

                    Document.add(OtherInfoLineTen);
                    OtherInfoLineTen.setBounds(OtherInfoLineTenLocationX, OtherInfoLineTenLocationY, OtherInfoLineTenWidth, OtherInfoLineTenHeight);
                    OtherInfoLineTen.setBackground(new Color(0, 0, 0, 0));
                    OtherInfoLineTen.setForeground(new Color(0,0,0));
                    OtherInfoLineTen.setOpaque(false);
                    OtherInfoLineTen.setCaretColor(new Color(0,0,0,0));
                    OtherInfoLineTen.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0, 0, 0)));
                    OtherInfoLineTen.setFont(new Font("Times New Roman", Font.PLAIN, 18));
                    OtherInfoLineTen.setVisible(true);
            
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

            PoliceDatabase.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    PoliceRecordsFunction(evt);
                }
            });

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

        // Clear Fields (JButton) Decorations
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

            ClearDocument.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    ClearButtonFunction(evt);
                }
            });
        
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

            PrintDocument.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    PrintButtonFunction(evt);
                }
            });
            
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
                TableColumn RemovePictureColumn = PoliceDatabase.getColumnModel().getColumn(11);
                PoliceDatabase.removeColumn(RemovePictureColumn);

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
    
    private void PoliceRecordsFunction(MouseEvent evt){
        
        PoliceDatabase.setCellSelectionEnabled(false);
        PoliceDatabase.setRowSelectionAllowed(true);

        int number = PoliceDatabase.getSelectedRow();
        IDField.setText(PoliceDatabase.getValueAt(number, 0).toString());
        String conCat = PoliceDatabase.getValueAt(number, 1).toString() + ", " + PoliceDatabase.getValueAt(number, 2).toString()
                + " " + PoliceDatabase.getValueAt(number, 3).toString();
        String upperCase = conCat.toUpperCase();
        NameField.setText(upperCase);
        HomeAddressField.setText(PoliceDatabase.getValueAt(number, 4).toString());
        DateArrestedField.setText(PoliceDatabase.getValueAt(number, 5).toString());
        ReleaseDateField.setText(PoliceDatabase.getValueAt(number, 6).toString());
        AgeField.setText(PoliceDatabase.getValueAt(number, 7).toString());
        GenderField.setText(PoliceDatabase.getValueAt(number, 8).toString());
        ReasonOfApprehensionField.setText(PoliceDatabase.getValueAt(number, 9).toString());
        ProvinceOfOriginField.setText(PoliceDatabase.getValueAt(number, 10).toString());

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
                    Image resizeImage = imagePicture.getScaledInstance(130, 130, Image.SCALE_SMOOTH);
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

        DefaultTableModel table = (DefaultTableModel) PoliceDatabase.getModel();
        String search = PrintSearch.getText();
        @SuppressWarnings("Convert2Diamond")
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        PoliceDatabase.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));

    }
    
    private void ClearButtonFunction(ActionEvent evt) {
        
        
        NameField.setText("- REPORT SHEET -");
        AgeField.setText("");
        GenderField.setText("");
        HomeAddressField.setText("");
        ProvinceOfOriginField.setText("");
        DateArrestedField.setText("");
        ReleaseDateField.setText("");
        ReasonOfApprehensionField.setText("");
        ImageIcon imageIcon = new ImageIcon("src\\PRMS Files\\icons\\USER-ICON.png");
        Image imagePicture = imageIcon.getImage();

        Image resizeImage = imagePicture.getScaledInstance(130, 130, Image.SCALE_SMOOTH);
        ImageIcon myPicture = new ImageIcon(resizeImage);
        MugShot.setIcon(myPicture);

        
    }
    
    private void PrintButtonFunction(ActionEvent evt){
        
        PrintRecord(Document);
        
    }
    
    private void PrintRecord(JPanel PDFCreator){
        
       // create printer job
       PrinterJob printerjob=PrinterJob.getPrinterJob();
       //Set printer job name
       printerjob.setJobName("Print Record");
       // Set printable
       printerjob.setPrintable(new Printable() {
           @Override
           public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
              //check if no ptrintable content
              if(pageIndex > 0){
               return Printable.NO_SUCH_PAGE;
           }
           Graphics2D graphics2d = (Graphics2D)graphics;
           graphics2d.translate(pageFormat.getImageableX()*1080,pageFormat.getImageableY()*1920);
           graphics2d.scale(1.25,1.25);
           
           // 1.59 x 1.70 for Tabloid.
           
           PDFCreator.paint(graphics2d);
                   
               return Printable.PAGE_EXISTS;

           }
       });
       
       boolean returningResult = printerjob.printDialog();
       
       if (returningResult) {
           
           try{
               
               printerjob.print();
               
           }catch(PrinterException printerexception){
               JOptionPane.showMessageDialog(this,"Printing Cancelled" );
           }
       }
    }
    
    private void BackButtonFunction(ActionEvent evt){
        dispose();
    }   
    
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
}
