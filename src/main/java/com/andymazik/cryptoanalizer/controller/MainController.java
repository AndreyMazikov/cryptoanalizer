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

    public String doAction(String actionName, String[] parameters) {
        Action action = actions.get(actionName.toUpperCase());
        return action.execute(parameters);
    }
}
