package com.andymazik.cryptoanalizer.view.console;

import com.andymazik.cryptoanalizer.controller.MainController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ConsoleApp {
    private final MainController mainController;
    BufferedReader bufferedReader =  new BufferedReader(new InputStreamReader(System.in));

    public ConsoleApp(MainController mainController) {
        this.mainController = mainController;
    }

    public void run() throws IOException {
        String[] args = getArgs();

        if (args.length != 0) {
            String result = getResult(args);
            printResult(result);
        }
    }

    private String getResult(String[] args) {
        String actionName = args[0];
        String[] argsOfAction = Arrays.copyOfRange(args, 1, args.length);

        return mainController.doAction(actionName, argsOfAction);
    }

    private void printResult(String result) {
        if (!result.equals("")) {
            System.out.printf(Messages.OK_MESSAGE, result);
        } else {
            System.out.println(Messages.ERROR_MESSAGE);
        }
    }

    private String[] getArgs() throws IOException {
        int mode = getMode(bufferedReader);
        String[] args;

        if (mode == 5) {
            args = new String[0];
        } else {
            args = mode == 3 ? new String[3] : new String[4];
            args[0] = Messages.MENU[mode - 1][0];

            System.out.println(Messages.MENU[mode - 1][1]);

            for (int i = 1; i < args.length; i++) {
                args[i] = bufferedReader.readLine();
            }
        }

        return args;
    }

    private int getMode(BufferedReader bufferedReader) {
        int mode;

        while (true) {
            try {
                System.out.println(Messages.START_MESSAGE);
                mode = Integer.parseInt(bufferedReader.readLine());
                if (!(mode > 0 && mode <= 5)) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException | IOException e) {
                System.out.println(Messages.INCORRECT_SELECTION);
            }
        }
        return mode;
    }
}
