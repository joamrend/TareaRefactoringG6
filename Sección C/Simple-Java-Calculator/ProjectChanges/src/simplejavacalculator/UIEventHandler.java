package simplejavacalculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class UIEventHandler implements ActionListener {

    private final CalculatorController controller;
    private final JButton button;

    public UIEventHandler(CalculatorController controller, JButton button) {
        this.controller = controller;
        this.button = button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controller.handleInput(button.getText());
    }
}

