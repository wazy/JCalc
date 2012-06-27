package jcalc;
//Imports
import javax.swing.*;

/**
 * Daniel B. 
 * Version 0.03 
 * Last Revision Date: 6/27/2012
 *
 * This revision entitles a beginning interface.
 * TODO: Order of operations, button layout, etc?
 *  
 */

public class JCalc extends JFrame {

    public static void main(String[] args) {
        //Makes it visible.
        new JCalc().setVisible(true);
    }
    //buttons
    private JButton plusButton;
    private JButton subtractButton;
    private JButton divideButton;
    private JButton multiplicationButton;
    private JButton equalsButton;
    private JButton clear;
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

    public JCalc() {
        System.out.println("Initializing...");
        initComponents();
    }

    private void initComponents() {

        //buttons
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

        buttonsPanel.setLayout(new java.awt.GridBagLayout());

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
                String equation = equationField.getText();
                equation = equation.concat("+");
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

        buttonsPanel.add(plusButton);
        buttonsPanel.add(subtractButton);
        buttonsPanel.add(divideButton);
        buttonsPanel.add(multiplicationButton);
        buttonsPanel.add(equalsButton);
        //buttonsPanel.add(clear);

        middlePanel.add(buttonsPanel);
        bottomPanel.add(clear);

        //add the panels to the main frame
        getContentPane().add(topPanel, java.awt.BorderLayout.NORTH);
        getContentPane().add(middlePanel, java.awt.BorderLayout.CENTER);
        getContentPane().add(bottomPanel, java.awt.BorderLayout.SOUTH);

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
                    System.out.println("If you are trying to multiply use * instead.");
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
            //System.out.println("Fatal error has occurred."+e);
            equationField.setText("Error");
        }
    }
}