package com.andymazik.cryptoanalizer;

import com.andymazik.cryptoanalizer.controller.MainController;
import com.andymazik.cryptoanalizer.view.swing.MainForm;

public class SwingRunner {
    public static void main(String[] args) {
        MainController controller = new MainController();
        MainForm mainForm = new MainForm(controller);

        mainForm.initialization();
    }
}
