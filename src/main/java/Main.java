// Исключение для неверного размера массива
class MyArraySizeException extends Exception {
    public MyArraySizeException(String message) {
        super(message);
    }
}

// Исключение для проблем с данными в массиве
class MyArrayDataException extends Exception {
    public MyArrayDataException(String message) {
        super(message);
    }
}

public class Main {

    // Метод для обработки двумерного массива
    public static int Array(String[][] array) throws MyArraySizeException, MyArrayDataException {
        // Проверяем, что массив имеет размер 4x4
        if (array.length != 4 || array[0].length != 4) {
            throw new MyArraySizeException("Размер массива не 4х4");
        }

        int sum = 0;
        // Проходим по всем элементам массива
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    // Пытаемся преобразовать элемент массива в целое число и добавить к сумме
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    // Если не удалось, выбрасываем исключение MyArrayDataException
                    throw new MyArrayDataException("Неверные данные в ячейке (" + i + ", " + j + "): " + array[i][j]);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        // Пример правильного массива 4x4
        String[][] validArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        // Пример массива 4x4 с неверными данными
        String[][] invalidDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "X", "12"},
                {"13", "14", "15", "16"}
        };

        // Пример массива с неверным размером
        String[][] invalidSizeArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"}
        };

        try {
            // Вызываем метод для правильного массива и выводим сумму
            System.out.println("Сумма: " + Array(validArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            // Обрабатываем возможные исключения и выводим сообщение об ошибке
            System.out.println(e.getMessage());
        }

        try {
            // Вызываем метод для массива с неверными данными
            System.out.println("Сумма: " + Array(invalidDataArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            // Обрабатываем возможные исключения и выводим сообщение об ошибке
            System.out.println(e.getMessage());
        }

        try {
            // Вызываем метод для массива с неверным размером
            System.out.println("Сумма: " + Array(invalidSizeArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            // Обрабатываем возможные исключения и выводим сообщение об ошибке
            System.out.println(e.getMessage());
        }
    }
}