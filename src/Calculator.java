import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Calculator implements ActionListener {
    // Declaring Objects
    Frame f = new Frame();
    Label l1 = new Label("First Number");
    Label l2 = new Label("Second Number");
    Label l3 = new Label("Result");
    TextField t1 = new TextField();
    TextField t2 = new TextField();
    TextField t3 = new TextField();
    Button b1 = new Button("Add");
    Button b2 = new Button("Sub");
    Button b3 = new Button("Multi");
    Button b4 = new Button("Div");
    Button b5 = new Button("Clear");

    Calculator() {
        // Set frame background color
        f.setBackground(Color.LIGHT_GRAY);

        // Giving Coordinates
        l1.setBounds(50, 100, 100, 20);
        l2.setBounds(50, 140, 100, 20);
        l3.setBounds(50, 180, 100, 20);
        t1.setBounds(200, 100, 100, 20);
        t2.setBounds(200, 140, 100, 20);
        t3.setBounds(200, 180, 100, 20);
        b1.setBounds(50, 250, 50, 20);
        b2.setBounds(110, 250, 50, 20);
        b3.setBounds(170, 250, 50, 20);
        b4.setBounds(230, 250, 50, 20);
        b5.setBounds(290, 250, 50, 20);

        // Set fonts for labels and text fields
        Font labelFont = new Font("Serif", Font.BOLD, 14);
        l1.setFont(labelFont);
        l2.setFont(labelFont);
        l3.setFont(labelFont);
        t1.setFont(new Font("Arial", Font.PLAIN, 14));
        t2.setFont(new Font("Arial", Font.PLAIN, 14));
        t3.setFont(new Font("Arial", Font.PLAIN, 14));

        // Set background and foreground color for text fields
        t1.setBackground(Color.WHITE);
        t2.setBackground(Color.WHITE);
        t3.setBackground(Color.LIGHT_GRAY);
        t3.setEditable(false); // Make the result field non-editable

        // Set background and foreground color for buttons
        b1.setBackground(Color.GREEN);
        b2.setBackground(Color.ORANGE);
        b3.setBackground(Color.CYAN);
        b4.setBackground(Color.MAGENTA);
        b5.setBackground(Color.RED);

        b1.setForeground(Color.BLACK);
        b2.setForeground(Color.BLACK);
        b3.setForeground(Color.BLACK);
        b4.setForeground(Color.BLACK);
        b5.setForeground(Color.WHITE);

        // Adding Components to the frame
        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(t1);
        f.add(t2);
        f.add(t3);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(b5);

        // Adding action listeners to buttons
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);

        // Setting frame properties
        f.setLayout(null);
        f.setVisible(true);
        f.setSize(400, 350);

        // Handling window close event
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    // Handling button actions
    public void actionPerformed(ActionEvent e) {
        try {
            int n1 = Integer.parseInt(t1.getText());
            int n2 = Integer.parseInt(t2.getText());

            if (e.getSource() == b1) {
                t3.setText(String.valueOf(n1 + n2));
            } else if (e.getSource() == b2) {
                t3.setText(String.valueOf(n1 - n2));
            } else if (e.getSource() == b3) {
                t3.setText(String.valueOf(n1 * n2));
            } else if (e.getSource() == b4) {
                if (n2 != 0) {
                    t3.setText(String.valueOf(n1 / n2));
                } else {
                    t3.setText("Cannot Divide by Zero");
                }
            } else if (e.getSource() == b5) {
                t1.setText("");
                t2.setText("");
                t3.setText("");
            }
        } catch (NumberFormatException ex) {
            t3.setText("Invalid Input");
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
