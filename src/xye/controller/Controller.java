package xye.controller;

import xye.model.GewinnModel;
import xye.view.MyFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
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

    }
}
