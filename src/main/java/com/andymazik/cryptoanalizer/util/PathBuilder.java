package com.andymazik.cryptoanalizer.util;

import java.io.File;
import java.nio.file.Path;

public class PathBuilder {
    private static final String TEXT_FOLDER = System.getProperty("user.dir") +
            File.separator +
            "text" +
            File.separator;

    private PathBuilder() {
    }

    public static Path getPath(String filename) {
        Path path = Path.of(filename);
        return path.isAbsolute()
                ? path
                : Path.of(TEXT_FOLDER + filename);
    }
}
