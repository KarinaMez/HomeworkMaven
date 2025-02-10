import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nЗадание 1:");
        printThreeWords();
        System.out.println("\nЗадание 2:");
        checkSumSign();
        System.out.println("\nЗадание 3:");
        printColor();
        System.out.println("\nЗадание 4:");
        compareNumbers();
        System.out.println("\nЗадание 5:");
        //примеры использования метода
        System.out.println(sumInRange(7, 10));
        System.out.println(sumInRange(-1, -10));
        System.out.println(sumInRange(5, 20));
        System.out.println(sumInRange(9, 1));
        System.out.println("\nЗадание 6:");
        //примеры использования метода
        checkTheNumber(9);
        checkTheNumber(0);
        checkTheNumber(-10);
        System.out.println("\nЗадание 7:");
        //примеры использования метода
        System.out.println(checkNumberSign(7));
        System.out.println(checkNumberSign(-5));
        System.out.println(checkNumberSign(0));
        System.out.println("\nЗадание 8:");
        printStringAndRepet("Хочу в Aston!", 5);
        System.out.println("\nЗадание 9:");
        //примеры использования метода
        System.out.println(checkingTheLeapYear(2024));
        System.out.println(checkingTheLeapYear(2025));
        System.out.println(checkingTheLeapYear(200));
        System.out.println("\nЗадание 10:");
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        invertArray(array);
        System.out.println(Arrays.toString(array));
        System.out.println("\nЗадание 11:");
        int[] array2 = new int[100];
        fillEmptyArray(array2);
        System.out.println(Arrays.toString(array2));
        System.out.println("Задание 12: \n");
        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        changeArray(array3);
        System.out.println(Arrays.toString(array3));
        System.out.println("\nЗадание 13:");
        diagonalArray(10); // Создаем массив 10x10
        System.out.println("\nЗадание 14:");
        int len = 5;
        int initialValue = 10;
        int[] resultArray = createArray(len, initialValue);
        System.out.println(Arrays.toString(resultArray));
    }

    /* 1. Создайте метод printThreeWords(),который при вызове должен
отпечатать в столбец три слова: Orange, Banana, Apple.
*/
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    /* 2. Создайте метод checkSumSign(), в теле которого объявите две
int переменные a и b, и инициализируйте их любыми значениями,
которыми захотите. Далее метод должен просуммировать эти переменные
и если их сумма больше или равна 0, то вывести в консоль сообщение.
“Сумма положительная”,в противном случае - “Сумма отрицательная”;
*/
    public static void checkSumSign() {
        int a = -5;
        int b = 4;
        int sum = a + b;

        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }


    }

    /* 3. Создайте метод printColor() в теле которого задайте int переменную value
и инициализируйте ее любым значением. Если value меньше 0 (0 включительно),
то в консоль метод должен вывести сообщение “Красный”, если лежит в пределах
от 0 (0 исключительно) до 100 (100 включительно), то “Желтый”,
если больше 100 (100 исключительно) - “Зеленый”;
*/
    public static void printColor() {
        int value = 7;

        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else if (value > 100) {
            System.out.println("Зеленый");
        }

    }

    /* 4. Создайте метод compareNumbers(), в теле которого объявите две int переменные a и b,
и инициализируйте их любыми значениями, которыми захотите. Если a больше или равно b,
то необходимо вывести в консоль сообщение “a >= b”, в противном случае “a < b”;
*/
    public static void compareNumbers() {
        int a = 9;
        int b = 3;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }

    }

    /* 5. Напишите метод, принимающий на вход два целых числа и проверяющий,
что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true,
в противном случае – false.
*/
    public static boolean sumInRange(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;

    }

    /* 6. Напишите метод, которому в качестве параметра передается целое число,
метод должен напечатать в консоль, положительное ли число передали или отрицательное.
Замечание: ноль считаем положительным числом.
*/
    public static void checkTheNumber(int number) {
        if (number >= 0) {
            System.out.println("Положительное");
        } else {
            System.out.println("Отрицательное");
        }
    }

    /* 7. Напишите метод, которому в качестве параметра передается целое число.
    Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
    Замечание: ноль считаем положительным числом.
    */
    public static boolean checkNumberSign(int number) {
        if (number < 0) {
            return true;
        } else {
            return false;
        }
    }

    /* 8. Напишите метод, которому в качестве аргументов передается строка и число,
метод должен отпечатать в консоль указанную строку, указанное количество раз;
*/
    public static void printStringAndRepet(String text, int repet) {

        for (int i = 0; i < repet; i++) {
            System.out.println(text);
        }

    }
    /*  9. Напишите метод, который определяет, является ли год високосным,
     и возвращает boolean (високосный - true, не високосный - false).
     Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
     */


    public static boolean checkingTheLeapYear(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }


     /* 10. Задать целочисленный массив, состоящий из элементов 0 и 1.
    Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
     */

    public static void invertArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = 1 - array[i];
        }
    }

    /* 11. Задать пустой целочисленный массив длиной 100.
     С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 ... 100;
     */

    public static void fillEmptyArray(int[] array) {

        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
    }
    // 12. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом,
    // и числа меньшие 6 умножить на 2;

    public static void changeArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] = array[i] * 2;
            }
        }

    }

    /* 13. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей,если обе сложно).
    Определить элементы одной из диагоналей можно по следующему принципу:
    индексы таких элементов равны, то есть [0][0], [1][1], [2][2], ..., [n][n];
    */
    public static void diagonalArray(int size) {
        int[][] array = new int[size][size]; // Создаем массив size x size
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == j || i + j == array.length - 1) { // Главная или побочная диагональ
                    array[i][j] = 1;
                }
                System.out.print(array[i][j] + " "); // Вывод элемента
            }
            System.out.println(); // Переход на новую строку
        }
    }

    // 14. Написать метод, принимающий на вход два аргумента: len и initialValue,
    // и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue.

    public static int[] createArray(int len, int initialValue) {
        if (len < 0) {
            throw new IllegalArgumentException("Длина массива не может быть отрицательной.");
        }

        int[] array = new int[len];
        Arrays.fill(array, initialValue); // Заполнение массива
        return array;
    }
}



