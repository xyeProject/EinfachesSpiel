package xye.model;

import java.util.Random;

public class GewinnModel {
    private int gesamtPunkte;
    private int spielerZahl;
    private int computerZahl;
    private int rundenErgebnis;

    public GewinnModel() {
        gesamtPunkte = 30;
    }

    public int getGesamtPunkte() {
        return gesamtPunkte;
    }

    public int getRundenErgebnis() {
        return rundenErgebnis;
    }

    public int getComputerZahl() {
        return computerZahl;
    }

    public void berechneComputerZahl() {
        Random random = new Random();
        computerZahl = random.nextInt(1,10);
    }

    public void berechneRunde(int spielerZahl) {
        if (spielerZahl < 1 || spielerZahl > 9) {
            throw new IllegalArgumentException("Ungültige Eingabe: Eingegebene Zahl muss zwischen 1 und 9 liegen");
        }

        this.spielerZahl = spielerZahl;
        if (spielerZahl == computerZahl) {
            rundenErgebnis = 20;
        } else if (Math.abs(spielerZahl - computerZahl) == 1) {
            rundenErgebnis = 5;
        } else {
            rundenErgebnis = -10;
        }
        gesamtPunkte += rundenErgebnis;
    }

    public boolean hatGewonnen() {
        if (gesamtPunkte >= 100) {
            return true;
        }
        return false;
    }

    public boolean hatVerloren() {
        if (gesamtPunkte <= 0) {
            return true;
        }
        return false;
    }
}
