package com.andymazik.cryptoanalizer.service;


public class Encoder extends AbstractActionImpl{
    @Override
    public String execute(String[] params) {
        //TODO: System.out.println("HELLO from encoder");
        int key = Integer.parseInt(params[2]);
        return convertMessage(params[0], params[1], key);
    }
}
