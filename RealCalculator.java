import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RealCalculator extends JFrame implements ActionListener {

    JTextField display;
    String operator = "";
    double num1 = 0, num2 = 0;

    public RealCalculator() {
        setTitle("Real Calculator");
        setSize(350, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Display
        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 30));
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        // Buttons panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String buttons[] = {
            "C", "←", "/", "*",
            "7", "8", "9", "-",
            "4", "5", "6", "+",
            "1", "2", "3", "=",
            "0", ".", "", ""
        };

        for (String btnText : buttons) {
            if (btnText.equals("")) {
                panel.add(new JLabel("")); 
                continue;
            }
            JButton btn = new JButton(btnText);
            btn.setFont(new Font("Arial", Font.BOLD, 22));
            btn.addActionListener(this);
            panel.add(btn);
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String btn = e.getActionCommand();

        if (btn.matches("[0-9]")) {
            display.setText(display.getText() + btn);
        } 
        else if (btn.equals(".")) {
            if (!display.getText().contains(".")) {
                display.setText(display.getText() + ".");
            }
        } 
        else if (btn.equals("C")) {
            display.setText("");
            num1 = num2 = 0;
            operator = "";
        } 
        else if (btn.equals("←")) {
            String text = display.getText();
            if (!text.isEmpty())
                display.setText(text.substring(0, text.length() - 1));
        } 
        else if (btn.equals("=")) {
            num2 = Double.parseDouble(display.getText());
            double result = 0;

            switch (operator) {
                case "+": result = num1 + num2; break;
                case "-": result = num1 - num2; break;
                case "*": result = num1 * num2; break;
                case "/": 
                    if (num2 == 0) {
                        display.setText("Error");
                        return;
                    }
                    result = num1 / num2; 
                    break;
            }

            display.setText(String.valueOf(result));
        } 
        else {  
            num1 = Double.parseDouble(display.getText());
            operator = btn;
            display.setText("");
        }
    }

    public static void main(String[] args) {
        new RealCalculator();
    }
}
