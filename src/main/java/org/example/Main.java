package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Задание 1, 2, 3: Массив 4x4 ===");

        // 1. Правильный массив (должен посчитаться)
        String[][] validArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        // 2. Массив неверного размера (вызовет MyArraySizeException)
        String[][] invalidSizeArray = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}
        };

        // 3. Массив с текстом вместо числа (вызовет MyArrayDataException)
        String[][] invalidDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "Привет", "12"},
                {"13", "14", "15", "16"}
        };

        // Вызываем метод и обрабатываем возможные исключения
        try {
            int result1 = sumArray(validArray);
            System.out.println("Сумма элементов правильного массива: " + result1);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            int result2 = sumArray(invalidSizeArray);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            int result3 = sumArray(invalidDataArray);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }


        System.out.println("\n=== Задание 4: ArrayIndexOutOfBoundsException ===");

        // Генерация и поимка ошибки выхода за пределы массива
        try {
            int[] arr = new int[5];
            System.out.println("Пытаемся обратиться к 10-му элементу массива из 5 элементов...");
            System.out.println(arr[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймали исключение: ArrayIndexOutOfBoundsException! Выход за границы массива.");
        }
    }

    // Метод, который проверяет размер, парсит числа и суммирует
    public static int sumArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        // 1. Проверка размера (должно быть 4x4)
        if (array.length != 4) {
            throw new MyArraySizeException("Неверный размер массива. Ожидается 4 строки, получено: " + array.length);
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("Неверный размер массива. В строке " + i + " ожидается 4 столбца, получено: " + array[i].length);
            }
        }

        // 2. Суммирование с проверкой данных
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    // Если не удалось преобразовать в int, бросаем наше исключение с указанием ячейки
                    throw new MyArrayDataException("Неверные данные в ячейке [" + i + "][" + j + "]: '" + array[i][j] + "'");
                }
            }
        }
        return sum;
    }
}