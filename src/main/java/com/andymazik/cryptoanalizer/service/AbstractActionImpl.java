package com.andymazik.cryptoanalizer.service;

import com.andymazik.cryptoanalizer.constants.Alphabet;
import com.andymazik.cryptoanalizer.util.PathBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public abstract class AbstractActionImpl implements Action{
    public String convertMessage(String sourceFile, String convertedFile, int key) {
        Path source = PathBuilder.getPath(sourceFile);
        Path target = PathBuilder.getPath(convertedFile);

        try (BufferedReader reader = Files.newBufferedReader(source);
             BufferedWriter writer = Files.newBufferedWriter(target))
        {

            int value;
            int length = Alphabet.CHARS.length;
            while ((value = reader.read()) > -1) {
                char character = (char) value;
                character = Character.toLowerCase(character);

                if (Alphabet.index.containsKey(character)) {
                    Integer index = Alphabet.index.get(character);
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

}
