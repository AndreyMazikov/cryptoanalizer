package com.andymazik.cryptoanalizer;

import com.andymazik.cryptoanalizer.controller.MainController;
import com.andymazik.cryptoanalizer.view.ConsoleApp;

public class Runner {
    public static void main(String[] args) {
        MainController mainController = new MainController();
        ConsoleApp consoleApp = new ConsoleApp(mainController);

        consoleApp.run();
    }
}
