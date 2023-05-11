package com.andymazik.cryptoanalizer.service;

import com.andymazik.cryptoanalizer.constants.Alphabet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Analyzer extends AbstractActionImpl {
    @Override
    public String execute(String[] params) {
        String encryptedFilename = params[0];
        String dictionaryFilename = params[1];
        String analyzedFilename = params[2];

        List<Character> dictionaryChars = getSortedChars(dictionaryFilename);
        List<Character> sourceChars = getSortedChars(encryptedFilename);

        Path source = getPath(encryptedFilename);
        Path target = getPath(analyzedFilename);

        String result = analyzedFilename;
        try (BufferedReader reader = Files.newBufferedReader(source);
             BufferedWriter writer = Files.newBufferedWriter(target))
        {
            int value;
            while ((value = reader.read()) > -1) {
                char character = (char) value;
                int index = sourceChars.indexOf(character);
                Character characterDecrypted = dictionaryChars.get(index);
                writer.write(
                        characterDecrypted != null
                                ? characterDecrypted
                                : character);
            }
        } catch (RuntimeException | IOException e) {
            //throw new RuntimeException(e);
            result = "";
        }
        return result;
    }

    private List<Character> getSortedChars(String fileName) {
        Map<Character, Integer> map = createStartMap();
        Path path = getPath(fileName);
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            int value;
            while ((value = reader.read()) > -1) {
                char character = Character.toLowerCase((char) value);
                if (map.containsKey(character)) {
                    Integer i = map.get(character) + 1;
                    map.put(character, i);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return map.entrySet()
                .stream()
                .sorted(Comparator.comparingInt(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .toList();
    }

    //Этот метод создает мапу, в которую будет записываться статистика.
    // Ключ это символ, а значение - частота его появления в тексте
    private Map<Character, Integer> createStartMap() {
        Set<Character> characters = Alphabet.index.keySet();
        Map<Character, Integer> map = new HashMap<>();
        for (Character character : characters) {
            map.put(character, 0);
        }
        return map;
    }
}
