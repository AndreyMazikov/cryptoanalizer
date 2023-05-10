package com.andymazik.cryptoanalizer.view;

import com.andymazik.cryptoanalizer.controller.MainController;

@SuppressWarnings("unused")
public class ConsoleApp {
    private final MainController mainController;

    public ConsoleApp(MainController mainController) {
        this.mainController = mainController;
    }

    //TODO: С этого метода будет начинаться выполнение программы.
    // В нем же будут считываться параметры с консоли.
    public void run() {
    }

    //TODO: В этом методе считанные параметры будут отправляться в контроллер.
    private String getResult() {
        return null;
    }

    //TODO: В этом методе полученный результат будет выводиться в консоль.
    private void printResult(String result) {

    }

    //TODO: В этом методе выводится в консоль меню, а ответы пользователей записываются в массив.
    private String[] getArgs() {
        return null;
    }
}
