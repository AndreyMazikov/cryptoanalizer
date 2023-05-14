package com.andymazik.cryptoanalizer.view.console;

@SuppressWarnings("unused")
public interface Messages {
    String ANSI_RESET = "\u001B[0m";
    String ANSI_BLUE = "\u001B[34m";
    String ANSI_CYAN = "\u001B[36m";
    String ANSI_RED = "\u001B[31m";
    String ANSI_GREEN = "\u001B[32m";

    String LINE = "-".repeat(20);

    String START_MESSAGE = LINE +
            ANSI_GREEN + "\nВыберете режим работы:\n" + ANSI_CYAN + """
            1. Закодировать
            2. Раскодировать
            3. Брутфорс
            4. Статистический анализ
            5. Выход
            """ + ANSI_RESET + LINE;


    String ENCODE_MESSAGE = ANSI_BLUE + """
            Укажите файл с исходным текстом (абсолютный путь ИЛИ только имя файла), затем нажмите ENTER
            Укажите файл для записи результата (абсолютный путь ИЛИ только имя файла), затем нажмите ENTER
            Укажите ключ шифрования (любое целое число), затем нажмите ENTER
            """;

    String DECODE_MESSAGE = ANSI_BLUE + """
            Укажите файл с зашифрованным текстом (абсолютный путь ИЛИ только имя файла), затем нажмите ENTER
            Укажите файл для записи результата (абсолютный путь ИЛИ только имя файла), затем нажмите ENTER
            Укажите ключ шифрования (любое целое число), затем нажмите ENTER
            """;

    String BRUTEFORCE_MESSAGE = ANSI_BLUE + """
            Укажите файл с зашифрованным текстом (абсолютный путь ИЛИ только имя файла), затем нажмите ENTER
            Укажите файл для записи результата (абсолютный путь ИЛИ только имя файла), затем нажмите ENTER
            """;

    String ANALYZE_MESSAGE = ANSI_BLUE + """
            Укажите файл с зашифрованным текстом (абсолютный путь ИЛИ только имя файла), затем нажмите ENTER
            Укажите файл словаря (абсолютный путь ИЛИ только имя файла), затем нажмите ENTER
            Укажите файл для записи результата (абсолютный путь ИЛИ только имя файла), затем нажмите ENTER
            """;

    String[][] MENU = {
            {"ENCODE", ENCODE_MESSAGE},
            {"DECODE", DECODE_MESSAGE},
            {"BRUTEFORCE", BRUTEFORCE_MESSAGE},
            {"ANALYZE", ANALYZE_MESSAGE},
            {"EXIT"}
    };


    String INCORRECT_SELECTION = "Неверный выбор";

    String OK_MESSAGE = ANSI_GREEN + """
                Операция выполнена
                Результат: %s
            """ + ANSI_RESET;

    String ERROR_MESSAGE = ANSI_RED + "ПРОИЗОШЛА ОШИБКА" + ANSI_RESET;
}
