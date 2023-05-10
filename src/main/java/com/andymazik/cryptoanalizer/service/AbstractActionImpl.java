package com.andymazik.cryptoanalizer.service;

@SuppressWarnings("unused")
public abstract class AbstractActionImpl implements Action{
    //TODO: Данный метод будет являться общим для трех из четырех действий
    // (кодирование, декодирование, брутфорс). Он конвертирует текст, сдвигая
    // его на значение заданное ключом.
    public String convertMessage(String message, int key) {
        return null;
    }
}
