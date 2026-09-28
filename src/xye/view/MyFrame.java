package xye.view;

import xye.controller.Controller;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    JLabel rundenErgebnis;
    JTextField textField;

    public MyFrame(Controller controller) {
        super("Zahlen-Gewinnspiel");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel basisLayout = new JPanel();
        basisLayout.setLayout(new BoxLayout(basisLayout, BoxLayout.Y_AXIS));

        JPanel gridLayout = new JPanel(new GridLayout(1,2));
        JPanel boxLayout1 = new JPanel();
        JPanel boxLayout2 = new JPanel();
        boxLayout1.setLayout(new BoxLayout(boxLayout1, BoxLayout.Y_AXIS));
        boxLayout2.setLayout(new BoxLayout(boxLayout2, BoxLayout.Y_AXIS));

        //BoxLayout1
        boxLayout1.add(new JLabel("Rundenergebnis:"));
        rundenErgebnis = new JLabel("Tippe eine Zahl von 1 bis 9");
        rundenErgebnis.setBackground(Color.WHITE);
        boxLayout1.add(rundenErgebnis);
        boxLayout1.add(new JLabel("Deine Zahl:"));
        textField = new JTextField();
        textField.setBackground(Color.WHITE);
        boxLayout1.add(textField);
        gridLayout.add(boxLayout1);


        basisLayout.add(gridLayout);
        //basisLayout.add();
        this.add(basisLayout);
        this.pack();
        this.setVisible(true);
    }

    public void setRundenErgebnis(JLabel rundenErgebnis) {
        if (rundenErgebnis == null) {
            throw new IllegalArgumentException("rundenErgebnis darf nicht 'null' sein!");
        }

        this.rundenErgebnis = rundenErgebnis;
    }
}
