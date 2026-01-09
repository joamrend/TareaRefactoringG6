package simplejavacalculator;

import javax.swing.JTextArea;

public class CalculatorController {

    private final Calculator calculator;
    private final JTextArea text;

    public CalculatorController(JTextArea text) {
        this.calculator = new Calculator();
        this.text = text;
    }

    public void handleInput(String input) {
        try {
            if (isNumber(input)) {
                text.append(input);
                return;
            }

            Double value = Double.valueOf(text.getText());

            switch (input) {
                case "+" -> write(calculator.calculateBi(Calculator.BiOperatorModes.add, value));
                case "-" -> write(calculator.calculateBi(Calculator.BiOperatorModes.minus, value));
                case "*" -> write(calculator.calculateBi(Calculator.BiOperatorModes.multiply, value));
                case "/" -> write(calculator.calculateBi(Calculator.BiOperatorModes.divide, value));
                case "=" -> write(calculator.calculateEqual(value));
                case "C" -> write(calculator.reset());
            }

        } catch (NumberFormatException ex) {
            text.setText("");
        }
    }

    private boolean isNumber(String s) {
        return s.matches("\\d");
    }

    private void write(Double num) {
        text.setText(Double.isNaN(num) ? "" : num.toString());
    }
}
