package com.andymazik.cryptoanalizer.view;

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

    //TODO: С этого метода будет начинаться выполнение программы.
    // В нем же будут считываться параметры с консоли.
    public void run() throws IOException {
        String[] args = getArgs();

        //Данная проверка нужна для реализации пункта меню "Exit"
        if (args.length != 0) {
            String result = getResult(args);
            printResult(result);
        }
    }

    //TODO: В этом методе считанные параметры будут отправляться в контроллер.
    private String getResult(String[] args) {
        String actionName = args[0];
        String[] argsOfAction = Arrays.copyOfRange(args, 1, args.length);

        return mainController.doAction(actionName, argsOfAction);
    }

    //TODO: В этом методе полученный результат будет выводиться в консоль.
    private void printResult(String result) {
        if (!result.equals("")) {
            System.out.printf(Messages.OK_MESSAGE, result);
        } else {
            System.out.println(Messages.ERROR_MESSAGE);
        }
    }

    //TODO: В этом методе выводится в консоль меню, а ответы пользователей записываются в массив.
    private String[] getArgs() throws IOException {
        //Получаем номер дейcтвия
        int mode = getMode(bufferedReader);
        String[] args;

        //Данная проверка нужна для реализации пункта меню "Exit"
        if (mode == 5) {
            args = new String[0];
        } else {
            //Создаем массив соответствующий номеру
            args = mode == 3 ? new String[3] : new String[4];
            //Первым значением в массив указываем тип операции
            args[0] = Messages.MENU[mode - 1][0];

            //Выводим меню соответствующее номеру
            System.out.println(Messages.MENU[mode - 1][1]);

            //Цикл для записи параметров в этот массив
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
