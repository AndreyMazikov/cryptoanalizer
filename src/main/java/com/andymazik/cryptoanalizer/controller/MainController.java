package com.andymazik.cryptoanalizer.controller;

import com.andymazik.cryptoanalizer.service.*;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class MainController {
    private final Map<String, Action> actions;

    public MainController() {
        actions = new HashMap<>();
        actions.put("ENCODE", new Encoder());
        actions.put("DECODE", new Decoder());
        actions.put("BRUTEFORCE", new BruteForcer());
        actions.put("ANALYZE", new Analyzer());
    }
    //TODO: В этом методе будет прописана логика вызова определенного действия и передачи
    // в него параметров. По первому параметру мы определяем какое это действие, после чего
    // вызываем метод execute() у необходимого класса.
    public String doAction(String actionName, String[] parameters) {
        //Получение объекта через мапу нужно для того чтобы избавиться от if'ов
        Action action = actions.get(actionName.toUpperCase());
        return action.execute(parameters);
    }
}
