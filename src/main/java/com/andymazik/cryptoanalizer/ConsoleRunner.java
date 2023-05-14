package com.andymazik.cryptoanalizer;

import com.andymazik.cryptoanalizer.controller.MainController;
import com.andymazik.cryptoanalizer.view.console.ConsoleApp;

import java.io.File;
import java.io.IOException;

public class ConsoleRunner {
    public static void main(String[] args) throws IOException {
        MainController mainController = new MainController();
        ConsoleApp consoleApp = new ConsoleApp(mainController);

        String TXT_FOLDER = System.getProperty("user.dir") +
                File.separator +
                "text" +
                File.separator;

        System.out.println(TXT_FOLDER);

        consoleApp.run();
    }
}
