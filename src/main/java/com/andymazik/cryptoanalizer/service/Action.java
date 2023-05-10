package com.andymazik.cryptoanalizer.service;

@SuppressWarnings("unused")
public interface Action {
    //TODO: В классах реализующих этот метод будет прописана логика
    // кодирования, декодирования, брутфорса и статистического анализа
    String execute(String[] params);
}
