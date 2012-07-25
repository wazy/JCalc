package jcalc;
//Imports
import java.awt.GridLayout;
import javax.swing.*;

/**
 * Daniel B. 
 * Version 0.04
 * Last Revision Date: 7/01/2012
 *
 * This revision entitles a beginning interface.
 * TODO: Order of operations, button layout, etc?
 * ***BUG: NEGATIVE NUMBERS PRODUCE EMPTY STRING***
 */

public class JCalc extends JFrame {

    public static void main(String[] args) {
        //Makes it visible.
        new JCalc().setVisible(true);
        //JCalc().setSize(300, 300);
    }
    //buttons
    private JButton plusButton;
    private JButton subtractButton;
    private JButton divideButton;
    private JButton multiplicationButton;
    private JButton equalsButton;
    private JButton clear;
    private JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9;
    //panels
    private JPanel middlePanel;
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JPanel buttonsPanel;
    //labels
    private JLabel equationLabel;
    //jtextfield
    private JTextField equationField;
    //menus
    private JMenuBar mainMenu;
    private JMenuItem exitMenuItem;
    private JMenu fileMenu;
    private JMenuItem aboutMenuItem;
    
    double value = 0.0;

    public JCalc() {
        System.out.println("Initializing...");
        initComponents();
    }

    private void initComponents() {

        //buttons
        b0 = new javax.swing.JButton();
        b1 = new javax.swing.JButton();
        b2 = new javax.swing.JButton();
        b3 = new javax.swing.JButton();
        b4 = new javax.swing.JButton();
        b5 = new javax.swing.JButton();
        b6 = new javax.swing.JButton();
        b7 = new javax.swing.JButton();
        b8 = new javax.swing.JButton();
        b9 = new javax.swing.JButton();
        
        plusButton = new javax.swing.JButton();
        subtractButton = new javax.swing.JButton();
        divideButton = new javax.swing.JButton();
        multiplicationButton = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        equalsButton = new javax.swing.JButton();

        //field
        equationField = new javax.swing.JTextField();

        //panels
        middlePanel = new javax.swing.JPanel();
        bottomPanel = new javax.swing.JPanel();
        topPanel = new javax.swing.JPanel();
        buttonsPanel = new javax.swing.JPanel();

        //labels
        equationLabel = new javax.swing.JLabel();

        //menus
        mainMenu = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();

        setTitle("JCalc");
        //when pressing the x to close
        addWindowListener(new java.awt.event.WindowAdapter() {

            public void windowClosing(java.awt.event.WindowEvent evt) {
                System.out.println("Terminating...");
                System.exit(0);
            }
        });

        //topPanel.setSize(297, 200);
        //mainPanel.setMinimumSize(new java.awt.Dimension(297, 200));
        equationLabel.setText("Enter an equation: ");
        equationField.setColumns(10);

        topPanel.add(equationLabel);
        topPanel.add(equationField);

        //buttonsPanel.setLayout(new java.awt.GridBagLayout());

        // Numbers 0-9
        b0.setText("0");
        b1.setText("1");
        b2.setText("2");
        b3.setText("3");
        b4.setText("4");
        b5.setText("5");
        b6.setText("6");
        b7.setText("7");
        b8.setText("8");
        b9.setText("9");
        
        //Rest
        plusButton.setText("+");
        subtractButton.setText("-");
        divideButton.setText("/");
        multiplicationButton.setText("*");
        equalsButton.setText("=");
        clear.setText("C");

        plusButton.setToolTipText("Adds");
        subtractButton.setToolTipText("Subtracts");
        divideButton.setToolTipText("Divides");
        multiplicationButton.setToolTipText("Multiplies");
        equalsButton.setToolTipText("Find the answer!");
        clear.setToolTipText("Clear");

        plusButton.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String part1 = equationField.getText();
                System.out.println(part1);
                double part2 = Double.parseDouble(part1);
                value = value + part2;
                String equation = equationField.getText();
                equation = Double.toString(value);
                equationField.setText(equation);
                equationField.requestFocusInWindow();
            }
        });
        subtractButton.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String equation = equationField.getText();
                equation = equation.concat("-");
                equationField.setText(equation);
                equationField.requestFocusInWindow();
            }
        });
        divideButton.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String equation = equationField.getText();
                equation = equation.concat("/");
                equationField.setText(equation);
                equationField.requestFocusInWindow();
            }
        });
        multiplicationButton.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String equation = equationField.getText();
                equation = equation.concat("*");
                equationField.setText(equation);
                equationField.requestFocusInWindow();
            }
        });
        equalsButton.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String equation = equationField.getText();
                System.out.println(equation);
                calculateRequested(evt);
                equationField.requestFocusInWindow();
            }
        });
        clear.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equationField.setText("");
                equationField.requestFocusInWindow();
            }        
        });
        b0.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String equation = equationField.getText();
                equation = equation.concat("0");
                equationField.setText(equation);
                equationField.requestFocusInWindow();
            }        
        });
        b1.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String equation = equationField.getText();
                equation = equation.concat("1");
                equationField.setText(equation);
                equationField.requestFocusInWindow();
            }        
        });
        b2.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String equation = equationField.getText();
                equation = equation.concat("2");
                equationField.setText(equation);
                equationField.requestFocusInWindow();
            }        
        });
        b3.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String equation = equationField.getText();
                equation = equation.concat("3");
                equationField.setText(equation);
                equationField.requestFocusInWindow();
            }        
        });
        b4.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String equation = equationField.getText();
                equation = equation.concat("4");
                equationField.setText(equation);
                equationField.requestFocusInWindow();
            }
        });        
        b5.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String equation = equationField.getText();
                equation = equation.concat("5");
                equationField.setText(equation);
                equationField.requestFocusInWindow();
            }        
        });        
        b6.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String equation = equationField.getText();
                equation = equation.concat("6");
                equationField.setText(equation);
                equationField.requestFocusInWindow();
            }        
        });        
        b7.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String equation = equationField.getText();
                equation = equation.concat("7");
                equationField.setText(equation);
                equationField.requestFocusInWindow();
            }        
        });        
        b8.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String equation = equationField.getText();
                equation = equation.concat("8");
                equationField.setText(equation);
                equationField.requestFocusInWindow();
            }        
        });        
        b9.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String equation = equationField.getText();
                equation = equation.concat("9");
                equationField.setText(equation);
                equationField.requestFocusInWindow();
            }        
        });        
        
        buttonsPanel.setLayout(new GridLayout(4,1,2,2));
        
        buttonsPanel.add(b0);
        buttonsPanel.add(b1);
        buttonsPanel.add(b2);
        buttonsPanel.add(b3);
        buttonsPanel.add(b4);
        buttonsPanel.add(b5);
        buttonsPanel.add(b6);
        buttonsPanel.add(b7);
        buttonsPanel.add(b8);
        buttonsPanel.add(b9);
        
        buttonsPanel.add(plusButton);
        buttonsPanel.add(subtractButton);
        buttonsPanel.add(divideButton);
        buttonsPanel.add(multiplicationButton);
        buttonsPanel.add(equalsButton);
        buttonsPanel.add(clear);

        middlePanel.add(buttonsPanel);

        //add the panels to the main frame
        getContentPane().add(topPanel, java.awt.BorderLayout.NORTH);
        getContentPane().add(middlePanel, java.awt.BorderLayout.CENTER);
        //getContentPane().add(bottomPanel, java.awt.BorderLayout.SOUTH);

        fileMenu.setMnemonic('F');
        fileMenu.setText("File");
        aboutMenuItem.setMnemonic('A');
        aboutMenuItem.setText("About");
        aboutMenuItem.setToolTipText("About");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.out.println("About requested.");
            }
        });

        fileMenu.add(aboutMenuItem);

        exitMenuItem.setMnemonic('E');
        exitMenuItem.setText("Exit");
        exitMenuItem.setToolTipText("Exits program.");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.out.println("Exiting.");
                System.exit(0);
            }
        });

        fileMenu.add(exitMenuItem);
        mainMenu.add(fileMenu);
        setJMenuBar(mainMenu);
    }

    private void calculateRequested(java.awt.event.ActionEvent evt) {
        try {
            //Just going to take this as a string and go from there.
            String readInput = equationField.getText();
            int lengthOfString = readInput.length();
            //Rather hacky here and the last substring isn't even read.
            //Good thing expressions aren't evaluated that way!
            for (int counter = 0; counter < lengthOfString; counter++) {
                //This has to be done to get a string of one length.
                String char1 = readInput.substring(counter, counter + 1);
                //Just in case somebody tries to do 5x5 or 5X5 and wonders
                //why it doesn't work.
                if (char1.equals("X") || char1.equals("x")) {
                    equationField.setText("If you are trying to multiply use * instead.");
                }
                if (char1.equals("+") || char1.equals("-") || char1.equals("/") || char1.equals("*")) {
                    //This is probably going to go into a class to be called.
                    //Currently this switch checks which method to use.
                    switch (char1) {
                        case "+":
                            String[] temp;
                            String delimiter = "\\+";
                            temp = readInput.split(delimiter);
                            double first = Double.parseDouble(temp[0]);
                            double second = Double.parseDouble(temp[1]);
                            double result = first + second;
                            String answer = String.valueOf(result);
                            equationField.setText(answer);
                            break;
                        case "-":
                            delimiter = "-";
                            temp = readInput.split(delimiter);
                            first = Double.parseDouble(temp[0]);
                            second = Double.parseDouble(temp[1]);
                            result = first - second;
                            answer = String.valueOf(result);
                            equationField.setText(answer);
                            break;
                        case "/":
                            delimiter = "/";
                            temp = readInput.split(delimiter);
                            first = Double.parseDouble(temp[0]);
                            second = Double.parseDouble(temp[1]);
                            result = first / second;
                            answer = String.valueOf(result);
                            equationField.setText(answer);
                            break;
                        case "*":
                            delimiter = "\\*";
                            temp = readInput.split(delimiter);
                            first = Double.parseDouble(temp[0]);
                            second = Double.parseDouble(temp[1]);
                            result = first * second;
                            answer = String.valueOf(result);
                            equationField.setText(answer);
                            break;
                        default:
                            System.out.println("Unsupported or invalid method!");
                            System.out.println("Something went really wrong if you got here.");
                            break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Fatal error has occurred."+e);
            equationField.setText("Error");
        }
    }
}