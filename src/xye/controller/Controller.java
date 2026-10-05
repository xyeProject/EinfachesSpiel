package xye.controller;

import xye.model.GewinnModel;
import xye.view.MyFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements ActionListener, KeyListener {
    MyFrame myFrame;
    GewinnModel gewinnModel;

    public static void main(String[] args) {
        new Controller();
    }

    public Controller() {
        myFrame = new MyFrame(this);
        gewinnModel = new GewinnModel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("nocheinmal")) {
            myFrame.spielerZahlDeaktivieren(false);
            myFrame.nochEinmalDeaktivieren(true);
            gewinnModel = new GewinnModel();
            myFrame.setComputerZahl("");
            myFrame.setRundenErgebnis("Tippe eine Zahl von 1 bis 9");
            myFrame.spielerZahlLoeschen();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            gewinnModel.berechneComputerZahl();
            gewinnModel.berechneRunde(myFrame.getSpielerZahl());
            myFrame.setComputerZahl(""+gewinnModel.getComputerZahl());
            myFrame.setGesamtPunkte(""+gewinnModel.getGesamtPunkte());
            myFrame.setRundenErgebnis(""+gewinnModel.getRundenErgebnis());

            myFrame.spielerZahlDeaktivieren(true);
            myFrame.nochEinmalDeaktivieren(false);

            if (gewinnModel.hatGewonnen()) {
                myFrame.setRundenErgebnis("Gewonnen");
            } else if (gewinnModel.hatVerloren()) {
                myFrame.setRundenErgebnis("Verloren");
            }
        }
    }

    public void keyReleased(KeyEvent e) {

    }
}
