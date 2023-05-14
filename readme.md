Задание на итоговый проект модуля 1
====================================

Введение
--------------------------------------------

Шифр Цезаря
Это один из самых простых и известных методов шифрования. Назвали его, само собой, в честь императора Гая Юлия Цезаря, применявшего его для секретной переписки с генералами.

Шифр Цезаря — это шифр подстановки: в нем каждый символ в открытом тексте заменяют на символ, который находится на некотором постоянном числе позиций левее или правее него в алфавите.

Допустим, мы устанавливаем сдвиг на 3. В таком случае А заменится на Г, Б станет Д, и так далее.


**Задача: написать программу, которая работает с шифром Цезаря.**

За основу криптографического алфавита берем все буквы русского алфавита и знаки пунктуации (. , ”” : - ! ? ПРОБЕЛ). Если попадаются символы, которые не входят в наш криптографический алфавит, просто пропускаем их.

Минимальный набор требований:
   ----------------------

### 1. Шифрование / расшифровка. 

Программа должна зашифровывать и расшифровывать текст, используя заданный криптографический ключ.

Программа должна получать путь к текстовому файлу с исходным текстом и на его основе создавать файл с зашифрованным текстом.

### 2. Криптоанализ методом brute force

Программа должна взламывать зашифрованный текст, переданный в виде текстового файла.

Если пользователь выбирает brute force (брутфорс, поиск грубой силой), программа должна самостоятельно, путем перебора, подобрать ключ и расшифровать текст.


Дополнительные фичи:
--------------------

### 1. Криптоанализ методом статистического анализа

У пользователя программы должна быть возможность выбрать один из двух методов криптоанализа. Если пользователь выбирает метод статистического анализа, ему нужно предложить загрузить еще один дополнительный файл с текстом, желательно— того же автора и той же стилистики. На основе загруженного файла программа должна составить статистику вхождения символов и после этого попытаться использовать полученную статистику для криптоанализа зашифрованного текста.

### 2. User Interface

Возможны различные вариации пользовательского интерфейса. В данном проекте используются обычный ввод/вывод в консоль и Swing.




