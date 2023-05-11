package com.andymazik.cryptoanalizer.service;

import com.andymazik.cryptoanalizer.constants.Alphabet;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BruteForcer extends AbstractActionImpl{
    //Логика работы метода строится на предположении, что самый часто встречающийся
    // символ это пробел. Соответственно нужно найти в зашифрованном файле
    // самые частый символ, поставить его в соответствие пробелу и найти ключ.
    @Override
    public String execute(String[] params) {
        String encryptedFilename = params[0];
        String decryptedFilename = params[1];
        int bestKey = 0;
        int bestSpaceCount = 0;
        char space = ' ';
        for (int key = 0; key < Alphabet.CHARS.length; key++) {
            int spaceCount = countCharInFileWithKey(encryptedFilename, key, space);
            if (spaceCount > bestSpaceCount) {
                bestSpaceCount = spaceCount;
                bestKey = key;
            }
        }
        return convertMessage(encryptedFilename, decryptedFilename, bestKey);
    }

    //Этот метод подсчитывает количество определенных символов в файле
    private int countCharInFileWithKey(String encryptedFilename, int key, char fixChar) {
        int spaceCount = 0;
        Path path = getPath(encryptedFilename);
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            int value;
            while ((value = reader.read()) > -1) {
                char character = (char) value;
                if (Alphabet.index.containsKey(character)) {
                    int index = Alphabet.index.get(character);
                    index = (index + key + Alphabet.CHARS.length) % Alphabet.CHARS.length;
                    if (Alphabet.CHARS[index] == fixChar) {
                        spaceCount++;
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return spaceCount;
    }
}
