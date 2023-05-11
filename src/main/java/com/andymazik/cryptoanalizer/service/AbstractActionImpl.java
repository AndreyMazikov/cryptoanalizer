package com.andymazik.cryptoanalizer.service;

import com.andymazik.cryptoanalizer.constants.Alphabet;

import java.io.*;
import java.nio.file.Path;

public abstract class AbstractActionImpl implements Action{
    String TEXT_FOLDER = System.getProperty("user.dir") +
            File.separator +
            "text" +
            File.separator;


    //TODO: Данный метод будет являться общим для трех из четырех действий
    // (кодирование, декодирование, брутфорс). Он конвертирует текст, сдвигая
    // его на значение заданное ключом.
    public String convertMessage(String sourceFile, String convertedFile, int key) {
        Path source = getPath(sourceFile);
        Path target = getPath(convertedFile);

        //TODO:
        try (BufferedReader reader = new BufferedReader(new FileReader(source.toFile()));
             BufferedWriter writer = new BufferedWriter(new FileWriter(target.toFile())))
        {

            int value;
            int length = Alphabet.CHARS.length;
            while ((value = reader.read()) > -1) {
                char character = (char) value;
                character = Character.toLowerCase(character);

                if (Alphabet.index.containsKey(character)) {
                    Integer index = Alphabet.index.get(character);
                    //Это нужно для того, чтобы ключ "ходил по кругу"
                    index = (index + key + Math.abs(key) * length) % length;
                    writer.write(Alphabet.CHARS[index]);
                }
                else if (character == '\n') {
                    writer.write(character);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return convertedFile;
    }

    public Path getPath(String fileName) {
        Path path = Path.of(fileName);
        if (!path.isAbsolute()) {
            path = Path.of(TEXT_FOLDER + fileName);
        }

        return path;
    }
}
