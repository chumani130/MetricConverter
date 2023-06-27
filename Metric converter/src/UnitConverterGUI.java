import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UnitConverterGUI extends JFrame {
    private JLabel fromLabel, toLabel, quantityLabel, resultLabel;
    private JTextField quantityField, resultField;
    private JComboBox<String> fromComboBox, toComboBox;
    private JButton convertButton;

    public UnitConverterGUI() {
        setTitle("Unit Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        fromLabel = new JLabel("From:");
        toLabel = new JLabel("To:");
        quantityLabel = new JLabel("Quantity:");
        resultLabel = new JLabel("Result:");

        quantityField = new JTextField(10);
        resultField = new JTextField(10);
        resultField.setEditable(false);

        fromComboBox = new JComboBox<>(new String[]{"Feet", "Pounds", "Fahrenheit"});
        toComboBox = new JComboBox<>(new String[]{"Meters", "Kilograms", "Celsius"});

        convertButton = new JButton("Convert");
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convert();
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 5, 5));
        panel.add(fromLabel);
        panel.add(fromComboBox);
        panel.add(toLabel);
        panel.add(toComboBox);
        panel.add(quantityLabel);
        panel.add(quantityField);
        panel.add(resultLabel);
        panel.add(resultField);
        panel.add(convertButton);

        add(panel);
    }

    private void convert() {
        String fromUnit = fromComboBox.getSelectedItem().toString();
        String toUnit = toComboBox.getSelectedItem().toString();
        double quantity = Double.parseDouble(quantityField.getText());

        double result = 0.0;

        if (fromUnit.equals("Feet") && toUnit.equals("Meters")) {
            result = feetToMeters(quantity);
        } else if (fromUnit.equals("Pounds") && toUnit.equals("Kilograms")) {
            result = poundsToKilograms(quantity);
        } else if (fromUnit.equals("Fahrenheit") && toUnit.equals("Celsius")) {
            result = fahrenheitToCelsius(quantity);
        }

        resultField.setText(String.valueOf(result));
    }

    private double feetToMeters(double feet) {
        return feet * 0.3048;
    }

    private double poundsToKilograms(double pounds) {
        return pounds * 0.45359237;
    }

    private double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                UnitConverterGUI converterGUI = new UnitConverterGUI();
                converterGUI.setVisible(true);
            }
        });
    }
}
