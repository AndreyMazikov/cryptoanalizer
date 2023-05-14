package com.andymazik.cryptoanalizer.service;


public class Encoder extends AbstractActionImpl{
    @Override
    public String execute(String[] params) {
        int key = Integer.parseInt(params[2]);
        return convertMessage(params[0], params[1], key);
    }
}
