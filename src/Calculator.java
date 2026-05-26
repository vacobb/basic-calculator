import java.awt.*;
import java.awt.event.*;

public class Calculator extends Frame {

    static TextField display;
    static double operand = 0.0;
    static String operator = "";

    private static void evaluateRunningTotal() {
        // If there's no operator active, there's no math to do!
        if (operator.isEmpty()) {
            return;
        }

        double currentNumber = Double.parseDouble(display.getText());

        if (operator.equals("+")) {
            operand = operand + currentNumber;
        } else if (operator.equals("-")) {
            operand = operand - currentNumber;
        } else if (operator.equals("*")) {
            operand = operand * currentNumber;
        } else if (operator.equals("/")) {
            if (currentNumber == 0) {
                display.setText("Error");
                operand = 0.0;
                operator = "";
            } else {
                operand = operand / currentNumber;
            }
        }
    }

    public static void main(String[] args) {

        // Declare buttons
        Button zeroButton = new Button("0");
        Button oneButton = new Button("1");
        Button twoButton = new Button("2");
        Button threeButton = new Button("3");
        Button fourButton = new Button("4");
        Button fiveButton = new Button("5");
        Button sixButton = new Button("6");
        Button sevenButton = new Button("7");
        Button eightButton = new Button("8");
        Button nineButton = new Button("9");
        Button plusButton = new Button("+");
        Button minusButton = new Button("-");
        Button divideButton = new Button("*");
        Button multiplyButton = new Button("/");
        Button equalButton = new Button("=");
        Button clearButton = new Button("clear");

        // Create frame
        Frame frame = new Frame("Calculator");
        frame.setSize(300, 500);
        frame.setLayout(new BorderLayout());

        // Create display panel - use panel to break up areas of GUI
        Panel displayPanel = new Panel();
        displayPanel.setLayout(new BorderLayout());
        display = new TextField(4);
        display.setText("0");
        displayPanel.add(display, BorderLayout.CENTER); // Helps display span the width of the calculator
        display.setFont(new Font("Arial", Font.PLAIN, 50)); // Determines size of display
        display.setEditable(false);

        // Create button panel
        Panel buttonPanel = new Panel();
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        buttonPanel.setLayout(layout);

        frame.add(displayPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);

        // Make components expand
        gbc.fill = GridBagConstraints.BOTH;

        // Allow resizing behavior
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        buttonPanel.add(nineButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        buttonPanel.add(eightButton, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        buttonPanel.add(sevenButton, gbc);

        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        buttonPanel.add(divideButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        buttonPanel.add(sixButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        buttonPanel.add(fiveButton, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        buttonPanel.add(fourButton, gbc);

        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        buttonPanel.add(multiplyButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        buttonPanel.add(threeButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        buttonPanel.add(twoButton, gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        buttonPanel.add(oneButton, gbc);

        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        buttonPanel.add(minusButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        buttonPanel.add(zeroButton, gbc);

        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        buttonPanel.add(equalButton, gbc);

        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        buttonPanel.add(plusButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 4;
        buttonPanel.add(clearButton, gbc);

        // Event listener - button press
        ActionListener buttonPressed = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                Button clickedButton = (Button) e.getSource();
                String text = clickedButton.getLabel();

                if (text.equals("+") || text.equals("-") || text.equals("*") || text.equals("/")) {

                    if (!operator.isEmpty()) {
                        evaluateRunningTotal();
                        if (display.getText().equals("Error")) {
                            return;
                        }
                    }
                    else {
                            operand = Double.parseDouble(display.getText());
                        }
                    operator = text;
                    display.setText("");
                } else if (text.equals("=")) {
                    evaluateRunningTotal();
                    if (display.getText().equals("Error")) {
                        return;
                    }
                    display.setText(String.valueOf(operand));
                    operator = "";
                } else if (text.equals("clear")) {
                    operand = 0.0;
                    operator = "";
                    display.setText("");
                } else {
                    if (display.getText().equals("0")) {
                        display.setText("");
                    }
                    display.setText(display.getText() + e.getActionCommand());
                }
            }
        };

        // Attach listeners to buttons
        zeroButton.addActionListener(buttonPressed);
        oneButton.addActionListener(buttonPressed);
        twoButton.addActionListener(buttonPressed);
        threeButton.addActionListener(buttonPressed);
        fourButton.addActionListener(buttonPressed);
        fiveButton.addActionListener(buttonPressed);
        sixButton.addActionListener(buttonPressed);
        sevenButton.addActionListener(buttonPressed);
        eightButton.addActionListener(buttonPressed);
        nineButton.addActionListener(buttonPressed);
        plusButton.addActionListener(buttonPressed);
        minusButton.addActionListener(buttonPressed);
        divideButton.addActionListener(buttonPressed);
        multiplyButton.addActionListener(buttonPressed);
        equalButton.addActionListener(buttonPressed);
        clearButton.addActionListener(buttonPressed);

        // Make frame visible
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}