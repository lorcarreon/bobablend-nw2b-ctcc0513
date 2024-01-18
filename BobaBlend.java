package CaseStudy;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class BobaBlend extends JFrame implements ActionListener {
    
    JLabel usernameLabel, passwordLabel, welcomeLabel;
    JTextField usernameTextfield;
    JPasswordField passwordField;
    JButton loginButton;
    String userInput, passwordInput;
    
    BobaBlend() {
        
        //title of the first window
        super("Log In");
        //background color of first window
        getContentPane().setBackground(new Color(230, 230, 250));
        //all button color white
        UIManager.put("Button.background", Color.WHITE);

        welcomeLabel = new JLabel("Welcome to BobaBlend!");
        welcomeLabel.setBounds(105, 35, 200, 15);
        welcomeLabel.setFont(new Font("Century Gothic", Font.BOLD, 15));
        add(welcomeLabel);
        
        //username label
        usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(45, 95, 65, 15);
        usernameLabel.setFont(new Font("Century Gothic", Font.BOLD, 12));
        add(usernameLabel);

        //password label
        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(45, 135, 65, 15);
        passwordLabel.setFont(new Font("Century Gothic", Font.BOLD, 12));
        add(passwordLabel);

        //username textfield
        usernameTextfield = new JTextField();
        usernameTextfield.setBounds(135, 90, 215, 30);
        usernameTextfield.setFont(new Font("Century Gothic", Font.BOLD, 12));
        add(usernameTextfield);

        //password passwordfield
        passwordField = new JPasswordField();
        passwordField.setBounds(135, 130, 215, 30);
        passwordField.setFont(new Font("Century Gothic", Font.BOLD, 12));
        add(passwordField);

        //log in button
        loginButton = new JButton("Log In");
        loginButton.setBounds(110, 210, 170, 30);
        loginButton.setFont(new Font("Century Gothic", Font.BOLD, 12));
        add(loginButton);
        
        loginButton.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent w) {
                System.exit(0);
            }
        });

        setSize(410, 320);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
        
    }
    
    //function of the log in button
    public void actionPerformed(ActionEvent e) {

        userInput = usernameTextfield.getText();
        passwordInput = passwordField.getText();
        
        if (userInput.equals("admin") && passwordInput.equals("1234")) {
            //second window
            new BobaBlend2();
            super.dispose();
        } else if (userInput.equals("admin") && !passwordInput.equals("1234")) {
            JOptionPane.showMessageDialog(this, "Incorrect password.","Error", JOptionPane.ERROR_MESSAGE);
        } else if (!userInput.equals("admin") && passwordInput.equals("1234")) {
            JOptionPane.showMessageDialog(this, "Incorrect username.","Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Incorrect username and password.","Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //second window
    class BobaBlend2 {
        
        JFrame frame;
        JLabel menuLabel, bobablendsLabel, allflavorLabel, drinksizeLabel, sugarlevelLabel, 
                quantityLabel, processingorderLabel, collectorderLabel, sortLabel;
        JSeparator horizontal1Separator, horizontal2Separator, horizontal3Separator;
        JRadioButton scdRadioButton, rviRadioButton, bbsRadioButton, mstRadioButton, 
                mvdRadioButton, tctRadioButton, smRadioButton, tidRadioButton, 
                csdRadioButton, chRadioButton, psRadioButton, mtRadioButton, 
                brRadioButton, vcRadioButton, bbwRadioButton, largesizeRadioButton, 
                mediumsizeRadioButton, regularsizeRadioButton, sugarlevel100RadioButton, 
                sugarlevel75RadioButton, sugarlevel50RadioButton, sugarlevel25RadioButton, 
                sugarlevel0RadioButton;
        ButtonGroup flavorButtonGroup, sizeButtonGroup, sugarlevelButtonGroup;
        JSpinner quantitySpinner;
        JButton processorderButton, processedButton, claimedButton;
        String flavor, size, sugarlevel, customernameInput, customerpaymentInput, officialreceipt, 
                processnumber;
        int sizeprice, flavorprice, quantity, totalprice, total, payment, change, ordernumber;
        Queue<String> processorders, collectorders;
        JTextArea processingorderTextArea, collectorderTextArea;
        JComboBox sortComboBox;
    
        BobaBlend2() {
            
            //title of the window
            frame = new JFrame("BobaBlend Milktea");
            frame.setResizable(false);
            frame.getContentPane().setBackground(new Color(230, 230, 250));
            frame.setBounds(100, 100, 733, 538);
            frame.setLayout(null);
            //close the window
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            //menu label
            menuLabel = new JLabel("MENU");
            menuLabel.setBounds(30, 12, 100, 34);
            menuLabel.setFont(new Font("Century Gothic", Font.BOLD, 34));
            frame.add(menuLabel);

            //bobablend milktea label
            bobablendsLabel = new JLabel("BOBABLENDS");
            bobablendsLabel.setBounds(130, 30, 890, 14);
            bobablendsLabel.setFont(new Font("Century Gothic", Font.BOLD, 14));
            frame.add(bobablendsLabel);

            //all flavor label
            allflavorLabel = new JLabel("ALL FLAVOR");
            allflavorLabel.setFont(new Font("Century Gothic", Font.BOLD, 14));
            allflavorLabel.setBounds(30, 78, 100, 14);
            frame.add(allflavorLabel);

            //salted caramel drift radio button
            scdRadioButton = new JRadioButton("Salted Caramel Drift | (Php 199)");
            scdRadioButton.setFont(new Font("Century Gothic", Font.PLAIN, 12));
            scdRadioButton.setBackground(new Color(230, 230, 250));
            scdRadioButton.setBounds(30, 103, 230, 23);
            frame.add(scdRadioButton);

            //red velvet indulgence radio button
            rviRadioButton = new JRadioButton("Red Velvet Indulgence | (Php 189)"); 
            rviRadioButton.setFont(new Font("Century Gothic", Font.PLAIN, 12));
            rviRadioButton.setBackground(new Color(230, 230, 250));
            rviRadioButton.setBounds(30, 126, 230, 23);
            frame.add(rviRadioButton);

            //butterscotch bliss sip radio button
            bbsRadioButton = new JRadioButton("Butterscotch Bliss Sip | (Php 189)");
            bbsRadioButton.setFont(new Font("Century Gothic", Font.PLAIN, 12));
            bbsRadioButton.setBackground(new Color(230, 230, 250));
            bbsRadioButton.setBounds(30, 149, 230, 23);
            frame.add(bbsRadioButton);

            //maple syrup tea radio button
            mstRadioButton = new JRadioButton("Maple Syrup Tea | (Php 189)");
            mstRadioButton.setFont(new Font("Century Gothic", Font.PLAIN, 12));
            mstRadioButton.setBackground(new Color(230, 230, 250));
            mstRadioButton.setBounds(30, 172, 230, 23);
            frame.add(mstRadioButton);

            //matcha velvet dream radio button
            mvdRadioButton = new JRadioButton("Matcha Velvet Dream | (Php 189)");
            mvdRadioButton.setFont(new Font("Century Gothic", Font.PLAIN, 12));
            mvdRadioButton.setBackground(new Color(230, 230, 250));
            mvdRadioButton.setBounds(30, 195, 230, 23);
            frame.add(mvdRadioButton);

            //pumpkin spice radio button
            psRadioButton = new JRadioButton("Pumpkin Spice | (Php 179)");
            psRadioButton.setFont(new Font("Century Gothic", Font.PLAIN, 12));
            psRadioButton.setBackground(new Color(230, 230, 250));
            psRadioButton.setBounds(274, 103, 230, 23);
            frame.add(psRadioButton);

            //strawberry mint radio button
            smRadioButton = new JRadioButton("Stawberry Mint | (Php 179)");
            smRadioButton.setFont(new Font("Century Gothic", Font.PLAIN, 12));
            smRadioButton.setBackground(new Color(230, 230, 250));
            smRadioButton.setBounds(274, 127, 230, 23);
            frame.add(smRadioButton);

            //taro ice delight radio button
            tidRadioButton = new JRadioButton("Taro Ice Delight | (Php 179)");
            tidRadioButton.setFont(new Font("Century Gothic", Font.PLAIN, 12));
            tidRadioButton.setBackground(new Color(230, 230, 250));
            tidRadioButton.setBounds(274, 150, 230, 23);
            frame.add(tidRadioButton);

            //cocoa splash delight radio button
            csdRadioButton = new JRadioButton("Cocoa Splash Delight | (Php 169)");
            csdRadioButton.setFont(new Font("Century Gothic", Font.PLAIN, 12));
            csdRadioButton.setBackground(new Color(230, 230, 250));
            csdRadioButton.setBounds(274, 173, 230, 23);
            frame.add(csdRadioButton);

            //choco hazelnut radio button
            chRadioButton = new JRadioButton("Choco Hazelnut | (Php 169)");
            chRadioButton.setFont(new Font("Century Gothic", Font.PLAIN, 12));
            chRadioButton.setBackground(new Color(230, 230, 250));
            chRadioButton.setBounds(274, 195, 230, 23);
            frame.add(chRadioButton);

            //toffee caramek twist radio button
            tctRadioButton = new JRadioButton("Toffee Caramel Twist | (Php 169)");
            tctRadioButton.setFont(new Font("Century Gothic", Font.PLAIN, 12));
            tctRadioButton.setBackground(new Color(230, 230, 250));
            tctRadioButton.setBounds(502, 103, 230, 23);
            frame.add(tctRadioButton);

            //mango tango radio button
            mtRadioButton = new JRadioButton("Mango Tango | (Php 159)");
            mtRadioButton.setFont(new Font("Century Gothic", Font.PLAIN, 12));
            mtRadioButton.setBackground(new Color(230, 230, 250));
            mtRadioButton.setBounds(502, 126, 230, 23);
            frame.add(mtRadioButton);

            //blueberyy ripple radio button
            brRadioButton = new JRadioButton("Blueberry Ripple | (Php 159)");
            brRadioButton.setFont(new Font("Century Gothic", Font.PLAIN, 12));
            brRadioButton.setBackground(new Color(230, 230, 250));
            brRadioButton.setBounds(502, 149, 230, 23);
            frame.add(brRadioButton);

            //vanilla cloud radio button
            vcRadioButton = new JRadioButton("Vanilla Cloud | (Php 149)");
            vcRadioButton.setFont(new Font("Century Gothic", Font.PLAIN, 12));
            vcRadioButton.setBackground(new Color(230, 230, 250));
            vcRadioButton.setBounds(502, 172, 230, 23);
            frame.add(vcRadioButton);

            //biscoff bliss whip radio button
            bbwRadioButton = new JRadioButton("Biscoff Bliss Whip | (Php 149)");
            bbwRadioButton.setFont(new Font("Century Gothic", Font.PLAIN, 12));
            bbwRadioButton.setBackground(new Color(230, 230, 250));
            bbwRadioButton.setBounds(502, 195, 230, 23);
            frame.add(bbwRadioButton);

            //flavor button group
            flavorButtonGroup = new ButtonGroup();

            //add flavor radio button to flavor button group
            flavorButtonGroup.add(scdRadioButton);
            flavorButtonGroup.add(rviRadioButton);
            flavorButtonGroup.add(bbsRadioButton);
            flavorButtonGroup.add(mstRadioButton);
            flavorButtonGroup.add(mvdRadioButton);
            flavorButtonGroup.add(tctRadioButton);
            flavorButtonGroup.add(smRadioButton);
            flavorButtonGroup.add(tidRadioButton);
            flavorButtonGroup.add(csdRadioButton);
            flavorButtonGroup.add(chRadioButton);
            flavorButtonGroup.add(psRadioButton);
            flavorButtonGroup.add(mtRadioButton);
            flavorButtonGroup.add(brRadioButton);
            flavorButtonGroup.add(vcRadioButton);
            flavorButtonGroup.add(bbwRadioButton);

            //horizontal 1 separator
            horizontal1Separator = new JSeparator();
            horizontal1Separator.setBounds(23, 57, 690, 2);
            horizontal1Separator.setBackground(Color.BLACK);
            frame.add(horizontal1Separator);

            //horizontal 2 separator
            horizontal2Separator = new JSeparator();
            horizontal2Separator.setBounds(23, 235, 690, 2);
            horizontal2Separator.setBackground(Color.BLACK);
            frame.add(horizontal2Separator);

            //horizontal 3 separator
            horizontal3Separator = new JSeparator();
            horizontal3Separator.setBounds(23, 410, 690, 2);
            horizontal3Separator.setBackground(Color.BLACK);
            frame.add(horizontal3Separator);

            //drink size label
            drinksizeLabel = new JLabel("DRINK SIZE");
            drinksizeLabel.setFont(new Font("Century Gothic", Font.BOLD, 14));
            drinksizeLabel.setBounds(38, 249, 74, 14);
            frame.add(drinksizeLabel);

            //large size radio button
            largesizeRadioButton = new JRadioButton("     Large (add Php 30)");
            largesizeRadioButton.setFont(new Font("Century Gothic", Font.PLAIN, 12));
            largesizeRadioButton.setBackground(new Color(230, 230, 250));
            largesizeRadioButton.setBounds(38, 274, 180, 23);
            frame.add(largesizeRadioButton);

            //medium size radio button
            mediumsizeRadioButton = new JRadioButton("     Medium (add Php 15)");
            mediumsizeRadioButton.setFont(new Font("Century Gothic", Font.PLAIN, 12));
            mediumsizeRadioButton.setBackground(new Color(230, 230, 250));
            mediumsizeRadioButton.setBounds(38, 297, 180, 23);
            frame.add(mediumsizeRadioButton);

            //regular size radio button
            regularsizeRadioButton = new JRadioButton("     Regular");
            regularsizeRadioButton.setFont(new Font("Century Gothic", Font.PLAIN, 12));
            regularsizeRadioButton.setBackground(new Color(230, 230, 250));
            regularsizeRadioButton.setBounds(38, 320, 180, 23);
            frame.add(regularsizeRadioButton);

            //size button group
            sizeButtonGroup = new ButtonGroup();

            //add size radio button to size button group
            sizeButtonGroup.add(largesizeRadioButton);
            sizeButtonGroup.add(mediumsizeRadioButton);
            sizeButtonGroup.add(regularsizeRadioButton);

            //sugar level label
            sugarlevelLabel = new JLabel("SUGAR LEVEL");
            sugarlevelLabel.setFont(new Font("Century Gothic", Font.BOLD, 14));
            sugarlevelLabel.setBounds(274, 249, 103, 14);
            frame.add(sugarlevelLabel);

            //sugar level 100 radio button
            sugarlevel100RadioButton = new JRadioButton("     100%");
            sugarlevel100RadioButton.setFont(new Font("Century Gothic", Font.PLAIN, 12));
            sugarlevel100RadioButton.setBackground(new Color(230, 230, 250));
            sugarlevel100RadioButton.setBounds(274, 274, 103, 23);
            frame.add(sugarlevel100RadioButton);

            //sugar level 75 radio button
            sugarlevel75RadioButton = new JRadioButton("     75%");
            sugarlevel75RadioButton.setFont(new Font("Century Gothic", Font.PLAIN, 12));
            sugarlevel75RadioButton.setBackground(new Color(230, 230, 250));
            sugarlevel75RadioButton.setBounds(274, 297, 103, 23);
            frame.add(sugarlevel75RadioButton);

            //sugar level 50 radio button
            sugarlevel50RadioButton = new JRadioButton("     50%");
            sugarlevel50RadioButton.setFont(new Font("Century Gothic", Font.PLAIN, 12));
            sugarlevel50RadioButton.setBackground(new Color(230, 230, 250));
            sugarlevel50RadioButton.setBounds(274, 320, 103, 23);
            frame.add(sugarlevel50RadioButton);

            //sugar level 25 radio button
            sugarlevel25RadioButton = new JRadioButton("     25%");
            sugarlevel25RadioButton.setFont(new Font("Century Gothic", Font.PLAIN, 12));
            sugarlevel25RadioButton.setBackground(new Color(230, 230, 250));
            sugarlevel25RadioButton.setBounds(379, 274, 103, 23);
            frame.add(sugarlevel25RadioButton);

            //sugar level 0 radio button
            sugarlevel0RadioButton = new JRadioButton("     No Sugar");
            sugarlevel0RadioButton.setFont(new Font("Century Gothic", Font.PLAIN, 12));
            sugarlevel0RadioButton.setBackground(new Color(230, 230, 250));
            sugarlevel0RadioButton.setBounds(379, 297, 103, 23);
            frame.add(sugarlevel0RadioButton);

            //sugar level button group
            sugarlevelButtonGroup = new ButtonGroup();

            //add sugar level radio button to size button group
            sugarlevelButtonGroup.add(sugarlevel100RadioButton);
            sugarlevelButtonGroup.add(sugarlevel75RadioButton);
            sugarlevelButtonGroup.add(sugarlevel50RadioButton);
            sugarlevelButtonGroup.add(sugarlevel25RadioButton);
            sugarlevelButtonGroup.add(sugarlevel0RadioButton);

            //quantity label
            quantityLabel = new JLabel("QUANTITY");
            quantityLabel.setFont(new Font("Century Gothic", Font.BOLD, 14));
            quantityLabel.setBounds(550, 249, 103, 14);
            frame.add(quantityLabel);

            //quantity spinner
            quantitySpinner = new JSpinner();
            quantitySpinner.setBounds(550, 276, 65, 20);
            frame.add(quantitySpinner);

            //process order button
            processorderButton = new JButton("PROCESS ORDER");
            processorderButton.setFont(new Font("Century Gothic", Font.BOLD, 12));
            processorderButton.setBounds(284, 370, 148, 23);
            frame.add(processorderButton);

            //order queue
            processorders = new LinkedList<>();
            collectorders = new LinkedList<>();

            //order number
            ordernumber = 1;    

            //processing order label
            processingorderLabel = new JLabel("PROCESSING ORDERS");
            processingorderLabel.setBounds(38, 433, 310, 25);
            processingorderLabel.setFont(new Font("Century Gothic", Font.BOLD, 16));
            //set label background color 
            processingorderLabel.setOpaque(true);
            processingorderLabel.setBackground(new Color(108, 159, 250));
            //set lebel text color white
            processingorderLabel.setForeground(Color.WHITE);
            //center the label
            processingorderLabel.setHorizontalAlignment(SwingConstants.CENTER);
            frame.add(processingorderLabel);

            //processing order text area
            processingorderTextArea = new JTextArea();
            processingorderTextArea.setBounds(38, 458, 310, 230);
            processingorderTextArea.setFont(new Font("Century Gothic", Font.BOLD, 20));
            processingorderTextArea.setEditable(false);
            processingorderTextArea.setForeground(new Color(108, 159, 250));
            frame.add(processingorderTextArea);

            //order processed button
            processedButton = new JButton("PROCESSED");
            processedButton.setFont(new Font("Century Gothic", Font.BOLD, 12));
            processedButton.setBounds(123, 710, 148, 23);
            frame.add(processedButton);

            //collect order label
            collectorderLabel = new JLabel("COLLECT ORDERS");
            collectorderLabel.setBounds(383, 433, 310, 25);
            collectorderLabel.setFont(new Font("Century Gothic", Font.BOLD, 16));
            //set label background color 
            collectorderLabel.setOpaque(true);
            collectorderLabel.setBackground(new Color(0, 166, 101));
            //set lebel text color white
            collectorderLabel.setForeground(Color.WHITE);
            //center the label
            collectorderLabel.setHorizontalAlignment(SwingConstants.CENTER);
            frame.add(collectorderLabel);

            //completed order text area
            collectorderTextArea = new JTextArea();
            collectorderTextArea.setBounds(383, 458, 310, 230);
            collectorderTextArea.setFont(new Font("Century Gothic", Font.BOLD, 20));
            collectorderTextArea.setEditable(false);
            collectorderTextArea.setForeground(new Color(0, 166, 101));
            frame.add(collectorderTextArea);
            
            //sort label
            sortLabel = new JLabel("SORT BY:");
            sortLabel.setFont(new Font("Century Gothic", Font.BOLD, 14));
            sortLabel.setBounds(274, 78, 100, 14);
            frame.add(sortLabel);
            
            //array of sort
            String sort[] = {"Name (A-Z)", "Name (Z-A)", "Price (↑↓)", "Price (↓↑)"};
            //sort combobox
            sortComboBox = new JComboBox(sort);
            sortComboBox.setBounds(335, 78, 100, 18);
            frame.add(sortComboBox);
            
            //claimed button
            claimedButton = new JButton("CLAIMED");
            claimedButton.setFont(new Font("Century Gothic", Font.BOLD, 12));
            claimedButton.setBounds(463, 710, 148, 23);
            frame.add(claimedButton);
            
            //function of claimed button
            claimedButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        //if the collect orders queue is not empty
                        if (!collectorders.isEmpty()) {

                            //remove the head of the queue 
                            collectorders.poll();

                            //will update the process orders queue
                            //processing order text area display the value of the process orders queue
                            processingorderTextArea.setText(String.join("\n", processorders));

                            //after getting the value of the process orders
                            //collect order text area display the value of the collect orders queue
                            collectorderTextArea.setText(String.join("\n", collectorders));
                        } else {
                            //show if the process orders queue is empty
                            JOptionPane.showMessageDialog(null, "No claimed orders.");
                        }
                    }
            });
            
            //function of sort combobox
            sortComboBox.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        //remove all flavor radio button in frame 
                        frame.remove(scdRadioButton);
                        frame.remove(rviRadioButton);
                        frame.remove(bbsRadioButton);
                        frame.remove(mstRadioButton);
                        frame.remove(mvdRadioButton);
                        frame.remove(psRadioButton);
                        frame.remove(smRadioButton);
                        frame.remove(tidRadioButton);
                        frame.remove(csdRadioButton);
                        frame.remove(chRadioButton);
                        frame.remove(tctRadioButton);
                        frame.remove(mtRadioButton);
                        frame.remove(brRadioButton);
                        frame.remove(vcRadioButton);
                        frame.remove(bbwRadioButton);
                        
                        //if name (a-z) combobox is selected will add all flavor button
                        if ("Name (A-Z)".equals(sortComboBox.getSelectedItem())) {
                            //a-z
                            bbwRadioButton.setBounds(30, 103, 230, 23);
                            frame.add(bbwRadioButton);
                            
                            brRadioButton.setBounds(30, 126, 230, 23);
                            frame.add(brRadioButton);
                            
                            bbsRadioButton.setBounds(30, 149, 230, 23);
                            frame.add(bbsRadioButton);
                            
                            chRadioButton.setBounds(30, 172, 230, 23);
                            frame.add(chRadioButton);
                            
                            csdRadioButton.setBounds(30, 195, 230, 23);
                            frame.add(csdRadioButton);
                            
                            mtRadioButton.setBounds(274, 103, 230, 23);
                            frame.add(mtRadioButton);
                            
                            mstRadioButton.setBounds(274, 127, 230, 23);
                            frame.add(mstRadioButton);
                            
                            mvdRadioButton.setBounds(274, 150, 230, 23);
                            frame.add(mvdRadioButton);
                            
                            psRadioButton.setBounds(274, 173, 230, 23);
                            frame.add(psRadioButton);
                            
                            rviRadioButton.setBounds(274, 195, 230, 23);
                            frame.add(rviRadioButton);
                            
                            scdRadioButton.setBounds(502, 103, 230, 23);
                            frame.add(scdRadioButton);
                            
                            smRadioButton.setBounds(502, 126, 230, 23);
                            frame.add(smRadioButton);
                            
                            tidRadioButton.setBounds(502, 149, 230, 23);
                            frame.add(tidRadioButton);
                            
                            tctRadioButton.setBounds(502, 172, 230, 23);
                            frame.add(tctRadioButton);
                            
                            vcRadioButton.setBounds(502, 195, 230, 23);
                            frame.add(vcRadioButton);
                        }
                        //if name (z-a) combobox is selected will add all flavor button
                        else if ("Name (Z-A)".equals(sortComboBox.getSelectedItem())) {
                            //z-a
                            vcRadioButton.setBounds(30, 103, 230, 23);
                            frame.add(vcRadioButton);
                                                        
                            tctRadioButton.setBounds(30, 126, 230, 23);
                            frame.add(tctRadioButton);
                            
                            tidRadioButton.setBounds(30, 149, 230, 23);
                            frame.add(tidRadioButton);
                            
                            smRadioButton.setBounds(30, 172, 230, 23);
                            frame.add(smRadioButton);
                            
                            scdRadioButton.setBounds(30, 195, 230, 23);
                            frame.add(scdRadioButton);
                            
                            rviRadioButton.setBounds(274, 103, 230, 23);
                            frame.add(rviRadioButton);
                            
                            psRadioButton.setBounds(274, 127, 230, 23);
                            frame.add(psRadioButton);
                            
                            mstRadioButton.setBounds(274, 173, 230, 23);
                            frame.add(mstRadioButton);
                            
                            mvdRadioButton.setBounds(274, 150, 230, 23);
                            frame.add(mvdRadioButton);
                            
                            mtRadioButton.setBounds(274, 195, 230, 23);
                            frame.add(mtRadioButton);
                            
                            csdRadioButton.setBounds(502, 103, 230, 23);
                            frame.add(csdRadioButton);
                            
                            chRadioButton.setBounds(502, 126, 230, 23);
                            frame.add(chRadioButton);
                            
                            bbsRadioButton.setBounds(502, 149, 230, 23);
                            frame.add(bbsRadioButton);

                            brRadioButton.setBounds(502, 172, 230, 23);
                            frame.add(brRadioButton);
                            
                            bbwRadioButton.setBounds(502, 195, 230, 23);
                            frame.add(bbwRadioButton);
                        }
                        //if price (↑↓) combobox is selected will add all flavor button 
                        else if("Price (↑↓)".equals(sortComboBox.getSelectedItem())){
                            //high to low
                            scdRadioButton.setBounds(30, 103, 230, 23);
                            frame.add(scdRadioButton);
                            
                            rviRadioButton.setBounds(30, 126, 230, 23);
                            frame.add(rviRadioButton);
                            
                            bbsRadioButton.setBounds(30, 149, 230, 23);
                            frame.add(bbsRadioButton);
                            
                            mstRadioButton.setBounds(30, 172, 230, 23);
                            frame.add(mstRadioButton);
                            
                            mvdRadioButton.setBounds(30, 195, 230, 23);
                            frame.add(mvdRadioButton);
                            
                            psRadioButton.setBounds(274, 103, 230, 23);
                            frame.add(psRadioButton);
                            
                            smRadioButton.setBounds(274, 127, 230, 23);
                            frame.add(smRadioButton);
                            
                            tidRadioButton.setBounds(274, 150, 230, 23);
                            frame.add(tidRadioButton);
                            
                            csdRadioButton.setBounds(274, 173, 230, 23);
                            frame.add(csdRadioButton);
                            
                            chRadioButton.setBounds(274, 195, 230, 23);
                            frame.add(chRadioButton);
                            
                            tctRadioButton.setBounds(502, 103, 230, 23);
                            frame.add(tctRadioButton);
                            
                            mtRadioButton.setBounds(502, 126, 230, 23);
                            frame.add(mtRadioButton);
                            
                            brRadioButton.setBounds(502, 149, 230, 23);
                            frame.add(brRadioButton);
                            
                            vcRadioButton.setBounds(502, 172, 230, 23);
                            frame.add(vcRadioButton);
                            
                            bbwRadioButton.setBounds(502, 195, 230, 23);
                            frame.add(bbwRadioButton);
                        } 
                        //if price (↓↑) combobox is selected will add all flavor button
                        else if ("Price (↓↑)".equals(sortComboBox.getSelectedItem())) {
                            //low to high
                            scdRadioButton.setBounds(502, 195, 230, 23);
                            frame.add(scdRadioButton);
                            
                            rviRadioButton.setBounds(502, 172, 230, 23);
                            frame.add(rviRadioButton);
                            
                            bbsRadioButton.setBounds(502, 149, 230, 23);
                            frame.add(bbsRadioButton);
                            
                            mstRadioButton.setBounds(502, 126, 230, 23);
                            frame.add(mstRadioButton);
                            
                            mvdRadioButton.setBounds(502, 103, 230, 23);
                            frame.add(mvdRadioButton);
                            
                            psRadioButton.setBounds(274, 195, 230, 23);
                            frame.add(psRadioButton);
                            
                            smRadioButton.setBounds(274, 173, 230, 23);
                            frame.add(smRadioButton);
                            
                            tidRadioButton.setBounds(274, 150, 230, 23);
                            frame.add(tidRadioButton);
                            
                            csdRadioButton.setBounds(274, 127, 230, 23);
                            frame.add(csdRadioButton);
                            
                            chRadioButton.setBounds(274, 103, 230, 23);
                            frame.add(chRadioButton);
                            
                            tctRadioButton.setBounds(30, 195, 230, 23);
                            frame.add(tctRadioButton);
                            
                            mtRadioButton.setBounds(30, 172, 230, 23);
                            frame.add(mtRadioButton);
                            
                            brRadioButton.setBounds(30, 149, 230, 23);
                            frame.add(brRadioButton);
                            
                            vcRadioButton.setBounds(30, 126, 230, 23);
                            frame.add(vcRadioButton);
                            
                            bbwRadioButton.setBounds(30, 103, 230, 23);
                            frame.add(bbwRadioButton);
                        }
                        //repaint the frame to see the changes
                        frame.repaint();
                    }    
            });

            //function of order processed button
            processedButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        //if the process orders queue is not empty
                        if (!processorders.isEmpty()) {

                            //remove the head of the queue and collect orders queue get the value of the process orders queue
                            collectorders.add(processorders.poll());

                            //will update the process orders queue
                            //processing order text area display the value of the process orders queue
                            processingorderTextArea.setText(String.join("\n", processorders));

                            //after getting the value of the process orders
                            //collect order text area display the value of the collect orders queue
                            collectorderTextArea.setText(String.join("\n", collectorders));
                        } else {
                            //show if the process orders queue is empty
                            JOptionPane.showMessageDialog(null, "No orders ready to collect.");
                        }
                    }
            });

            //function of process order button
            processorderButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        //loop if the user no select 
                        while(true) {

                            //get selected flavor checkbox
                            if (scdRadioButton.isSelected() || rviRadioButton.isSelected() || 
                                    bbsRadioButton.isSelected() || mstRadioButton.isSelected() || 
                                    mvdRadioButton.isSelected() || psRadioButton.isSelected() || 
                                    smRadioButton.isSelected() || tidRadioButton.isSelected() || 
                                    csdRadioButton.isSelected() || chRadioButton.isSelected() || 
                                    tctRadioButton.isSelected() || mtRadioButton.isSelected() || 
                                    brRadioButton.isSelected() || vcRadioButton.isSelected() || 
                                    bbwRadioButton.isSelected()) {

                                //get selected flavor checkbox into string
                                if (scdRadioButton.isSelected()) {
                                    flavor = "Salted Caramel Drift";
                                    flavorprice = 199;
                                } else if (rviRadioButton.isSelected()) {
                                    flavor = "Red Velvet Indulgence";
                                    flavorprice = 189;
                                } else if (bbsRadioButton.isSelected()) {
                                    flavor = "Butterscotch Bliss Slip";
                                    flavorprice = 189;
                                } else if (mstRadioButton.isSelected()) {
                                    flavor = "Red Velvet Indulgence";
                                    flavorprice = 189;
                                } else if(mvdRadioButton.isSelected()) {
                                    flavor = "Matcha Velvet Dream";
                                    flavorprice = 189;
                                } else if (psRadioButton.isSelected()) {
                                    flavor = "Pumpkin Spice";
                                    flavorprice = 179;
                                } else if(smRadioButton.isSelected()) {
                                    flavor = "Strawberry Mint";
                                    flavorprice = 179;
                                } else if(tidRadioButton.isSelected()) {
                                    flavor = "Taro Ice Delight";
                                    flavorprice = 179;
                                } else if(csdRadioButton.isSelected()) {
                                    flavor = "Cocoa Splash Delight";
                                    flavorprice = 169;
                                } else if(chRadioButton.isSelected()) {
                                    flavor = "Choco Hazelnut";
                                    flavorprice = 169;
                                } else if (tctRadioButton.isSelected()) {
                                    flavor = "Toffee Caramel Twist";
                                    flavorprice = 169;
                                } else if (mtRadioButton.isSelected()) { 
                                    flavor = "Mango Tango";
                                    flavorprice = 159;
                                } else if (brRadioButton.isSelected()) {
                                    flavor = "Blueberry Ripple";
                                    flavorprice = 159;
                                } else if (vcRadioButton.isSelected()) {
                                    flavor = "Vanilla Cloud";
                                    flavorprice = 149;
                                } else if (bbwRadioButton.isSelected()) {
                                    flavor = "Biscoff Bliss Whip";
                                    flavorprice = 149;
                                } 

                                //get selected size button into string
                                if (largesizeRadioButton.isSelected()) { 
                                    size = "Large";
                                } else if (mediumsizeRadioButton.isSelected()) { 
                                    size = "Medium";
                                } else if (regularsizeRadioButton.isSelected()) {
                                    size = "Regular";
                                } else { 
                                    //show if user no select size
                                    JOptionPane.showMessageDialog(frame, "Please select a size.", "Error", JOptionPane.ERROR_MESSAGE);
                                    break;
                                }

                                //get selected size button into string
                                if (largesizeRadioButton.isSelected()) { 
                                    sizeprice = 30;
                                } else if (mediumsizeRadioButton.isSelected()) { 
                                    sizeprice = 15;
                                } else if (regularsizeRadioButton.isSelected()) {
                                    sizeprice = 0;
                                }

                                //get selected sugar level button into string
                                if (sugarlevel100RadioButton.isSelected()) {
                                    sugarlevel = "100%";
                                } else if (sugarlevel75RadioButton.isSelected()) {
                                    sugarlevel = "75%";
                                } else if (sugarlevel50RadioButton.isSelected()) {
                                    sugarlevel = "50%";
                                } else if (sugarlevel25RadioButton.isSelected()) {
                                    sugarlevel = "25%";
                                } else if (sugarlevel0RadioButton.isSelected()) {
                                    sugarlevel = "0%";
                                } else {
                                    //show if user no select sugar level
                                    JOptionPane.showMessageDialog(frame, "Please select a sugar level.", "Error", JOptionPane.ERROR_MESSAGE);
                                    break;
                                }

                                //get the value of the spinner into int
                                quantity = (int) quantitySpinner.getValue();

                                //get the total price
                                if (quantity <= 0) {
                                    //show if the spinner is 0 or -1
                                    JOptionPane.showMessageDialog(frame, "Please add number of quantity.", "Error", JOptionPane.ERROR_MESSAGE);
                                    break;
                                } else {
                                    //add size price and flavor price
                                    totalprice = flavorprice+sizeprice;

                                    //multiply totalprice and quantity
                                    total = totalprice*quantity;

                                    //loop the input name of the customer
                                    while(true) {

                                    //user input name
                                    customernameInput = JOptionPane.showInputDialog(frame, "Name: ","Customer Name", JOptionPane.QUESTION_MESSAGE);

                                    //after input the name it will direct into payment option pane
                                    if (customernameInput == null) {
                                        break;
                                    } else if (customernameInput.isEmpty()) {
                                        //show if user no input name
                                        JOptionPane.showMessageDialog(frame, "Please enter your name", "Error", JOptionPane.ERROR_MESSAGE);
                                        continue;
                                    } 

                                    //loop the input the amount of payment
                                    while(true) {

                                    //user input the amount of payment
                                    customerpaymentInput = JOptionPane.showInputDialog(frame, "Order Number: 000" +  ordernumber
                                            + "\nName: " + customernameInput
                                            + "\nFlavor: " + flavor
                                            + "\nSize: " + size 
                                            + "\nSugar Level: " + sugarlevel 
                                            + "\nQuantity: " + quantity
                                            + "\nTotal: ₱" + total 
                                            + "\nAmount Tendered: ","Order Details", JOptionPane.INFORMATION_MESSAGE);

                                            //if the user click the cancel, return to the second window
                                            if (customerpaymentInput == null) {
                                                break;
                                            }

                                            //if the user click the ok but the amount is empty
                                            if (customerpaymentInput.isEmpty()) {
                                                //show error message if the input dialog is empty
                                                JOptionPane.showMessageDialog(frame, "Please enter a sufficient amount", "Error", JOptionPane.ERROR_MESSAGE);
                                                //continue the loop for input payment
                                                continue; 
                                            }

                                            //convert the payment from the input dialog box to int
                                            payment = Integer.parseInt(customerpaymentInput);

                                            //if the payment of the user is greater than total, proceed to the official receipt
                                            if (payment >= total) {

                                            //minus the payment and the price of the selected product
                                            change = payment-total;

                                            //add order to the queue
                                            officialreceipt = "Order Number: 000" + ordernumber
                                                    + "\nName: " + customernameInput
                                                    + "\nFlavor: " + flavor
                                                    + "\nSize: " + size 
                                                    + "\nSugar Level: " + sugarlevel 
                                                    + "\nQuantity: " + quantity
                                                    + "\nPrice: ₱" + total 
                                                    + "\nAmount Tendered: ₱" + payment 
                                                    + "\nChange: ₱" + change;

                                            //show official receipt of the customer
                                            JOptionPane.showMessageDialog(frame, officialreceipt,"Official Receipt", JOptionPane.INFORMATION_MESSAGE);

                                            //processnumber is equal to order number with length of 4 numbers
                                            processnumber = String.format("%04d", ordernumber);

                                            //order number add process number to the queue
                                            processorders.add(processnumber);

                                            //show order number in the text area
                                            processingorderTextArea.setText(String.join("\n", processorders));
                                            
                                            //reset the button and spinner
                                            flavorButtonGroup.clearSelection();
                                            sizeButtonGroup.clearSelection();
                                            sugarlevelButtonGroup.clearSelection();
                                            quantitySpinner.setValue(0);

                                            //order number increase
                                            ordernumber++;
                                            break;
                                            } else { 
                                                //show error message if the payment is less than total
                                                JOptionPane.showMessageDialog(frame, "Not enough amount. \nPlease enter a sufficient amount", "Error", JOptionPane.ERROR_MESSAGE);
                                                //continue the loop for input payment
                                                continue;
                                            }
                                    }
                                    //stop the loop
                                    break;
                                    }
                                    //stop the loop
                                    break;
                                }
                            } else {
                                //show if the user no select flavor
                                JOptionPane.showMessageDialog(frame, "Please select a flavor.", "Error", JOptionPane.ERROR_MESSAGE);
                                break;
                            }
                        }
                    }
            });

            frame.setSize(750, 800);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }
        }
    
    //call the constructor
    public static void main(String[] args) {
        new BobaBlend();
    }
}