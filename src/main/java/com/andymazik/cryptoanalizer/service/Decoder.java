package com.andymazik.cryptoanalizer.service;

public class Decoder extends AbstractActionImpl{
    @Override
    public String execute(String[] params) {
        int key = -1 * Integer.parseInt(params[2]);
        return convertMessage(params[0], params[1], key);
    }
}
