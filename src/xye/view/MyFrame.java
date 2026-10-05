package xye.view;

import xye.controller.Controller;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    JLabel rundenErgebnis;
    JTextField spielerZahl;
    JLabel gesamtPunkte;
    JLabel computerZahl;
    JButton nochEinmal;

    public MyFrame(Controller controller) {
        super("Zahlen-Gewinnspiel");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel basisLayout = new JPanel();
        basisLayout.setLayout(new BoxLayout(basisLayout, BoxLayout.Y_AXIS));

        JPanel gridLayout = new JPanel(new GridLayout(1,2,16,16));
        JPanel boxLayout1 = new JPanel();
        JPanel boxLayout2 = new JPanel();
        boxLayout1.setLayout(new BoxLayout(boxLayout1, BoxLayout.Y_AXIS));
        boxLayout2.setLayout(new BoxLayout(boxLayout2, BoxLayout.Y_AXIS));

        //BoxLayout1
        Dimension dimension = new Dimension(300,16);

        JLabel rundenLabel = new JLabel("Rundenergebnis");
        rundenLabel.setPreferredSize(dimension);
        rundenLabel.setMaximumSize(dimension);
        boxLayout1.add(rundenLabel);

        boxLayout1.add(Box.createVerticalStrut(4));

        rundenErgebnis = new JLabel("Tippe eine Zahl von 1 bis 9");
        rundenErgebnis.setOpaque(true);
        rundenErgebnis.setPreferredSize(dimension);
        rundenErgebnis.setMaximumSize(dimension);
        rundenErgebnis.setBackground(Color.WHITE);
        boxLayout1.add(rundenErgebnis);

        boxLayout1.add(Box.createVerticalStrut(12));

        JLabel spielerZahlLabel = new JLabel("Deine Zahl");
        spielerZahlLabel.setPreferredSize(dimension);
        spielerZahlLabel.setMaximumSize(dimension);
        boxLayout1.add(spielerZahlLabel);

        boxLayout1.add(Box.createVerticalStrut(4));

        spielerZahl = new JTextField();
        spielerZahl.setBackground(Color.WHITE);
        spielerZahl.setPreferredSize(new Dimension(16,200));
        spielerZahl.setMaximumSize(new Dimension(600,200));
        spielerZahl.addKeyListener(controller);
        boxLayout1.add(spielerZahl);
        gridLayout.add(boxLayout1);

        //BoxLayout2
        JLabel gesamtpunkteLabel = new JLabel("Gesamtpunkte");
        gesamtpunkteLabel.setPreferredSize(dimension);
        gesamtpunkteLabel.setMaximumSize(dimension);
        boxLayout2.add(gesamtpunkteLabel);

        boxLayout2.add(Box.createVerticalStrut(4));

        gesamtPunkte = new JLabel("30");
        gesamtPunkte.setOpaque(true);
        gesamtPunkte.setBackground(Color.WHITE);
        gesamtPunkte.setPreferredSize(dimension);
        gesamtPunkte.setMaximumSize(dimension);
        boxLayout2.add(gesamtPunkte);

        boxLayout2.add(Box.createVerticalStrut(12));

        JLabel computerLabel = new JLabel("Computer");
        computerLabel.setMaximumSize(dimension);
        computerLabel.setPreferredSize(dimension);
        boxLayout2.add(computerLabel);

        boxLayout2.add(Box.createVerticalStrut(4));

        computerZahl = new JLabel();
        computerZahl.setOpaque(true);
        computerZahl.setBackground(Color.WHITE);
        computerZahl.setPreferredSize(new Dimension(16,200));
        computerZahl.setMaximumSize(new Dimension(600, 200));
        boxLayout2.add(computerZahl);
        gridLayout.add(boxLayout2);

        //Texte in die Mitte legen
        rundenLabel.setHorizontalAlignment(JLabel.CENTER);
        rundenErgebnis.setHorizontalAlignment(JLabel.CENTER);
        spielerZahlLabel.setHorizontalAlignment(JLabel.CENTER);
        spielerZahl.setHorizontalAlignment(JTextField.CENTER);
        gesamtpunkteLabel.setHorizontalAlignment(JLabel.CENTER);
        gesamtPunkte.setHorizontalAlignment(JLabel.CENTER);
        computerLabel.setHorizontalAlignment(JLabel.CENTER);
        computerZahl.setHorizontalAlignment(JLabel.CENTER);

        nochEinmal = new JButton("Noch einmal!");
        nochEinmal.setAlignmentX(JButton.CENTER_ALIGNMENT);
        nochEinmal.setActionCommand("nocheinmal");
        nochEinmal.addActionListener(controller);

        basisLayout.add(gridLayout);
        basisLayout.add(Box.createVerticalStrut(16));
        basisLayout.add(nochEinmal);
        basisLayout.add(Box.createVerticalStrut(16));
        this.add(basisLayout);
        this.pack();
        this.setVisible(true);
    }

    public void setRundenErgebnis(String rundenErgebnis) {

        this.rundenErgebnis.setText(rundenErgebnis == null? "":rundenErgebnis);
    }

    public void setGesamtPunkte(String gesamtPunkte) {
        this.gesamtPunkte.setText(gesamtPunkte);
    }

    public void setComputerZahl(String computerZahl) {
        this.computerZahl.setText(computerZahl);
    }

    public int getSpielerZahl() {
        int zahl = -1;
        try {
            zahl = Integer.parseInt(spielerZahl.getText());
        } catch (NumberFormatException e) {

        }
        return zahl;
    }

    public void spielerZahlLoeschen() {
        this.spielerZahl.setText("");
    }

    public void spielerZahlDeaktivieren(boolean deaktivieren) {
        this.spielerZahl.setEnabled(!deaktivieren);
    }

    public void nochEinmalDeaktivieren(boolean deaktivieren) {
        this.nochEinmal.setEnabled(!deaktivieren);
    }

    public void faerben(Color color) {
        this.spielerZahl.setBackground(color);
        this.rundenErgebnis.setBackground(color);
        this.computerZahl.setBackground(color);
        this.gesamtPunkte.setBackground(color);
    }
}
