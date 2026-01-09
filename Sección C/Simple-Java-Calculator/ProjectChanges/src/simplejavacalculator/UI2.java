package simplejavacalculator;

public class UI2 {

    private final JFrame frame;
    private final JPanel panel;
    private final JTextArea text;
    private final JButton[] buttons;
    private final CalculatorController controller;

    public UI2() throws IOException {
        frame = new JFrame("Calculator PH");
        panel = new JPanel();
        text = new JTextArea(1, 30);
        buttons = new JButton[10];

        controller = new CalculatorController(text);

        initComponents();
    }

    private void initComponents() {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        for (int i = 0; i < 10; i++) {
            buttons[i] = new JButton(String.valueOf(i));
            buttons[i].addActionListener(new UIEventHandler(controller, buttons[i]));
            panel.add(buttons[i]);
        }

        frame.add(panel);
        frame.setSize(450, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public JTextArea getText() {
        return text;
    }
}

