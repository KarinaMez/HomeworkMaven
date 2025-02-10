import java.util.*;

class PhoneBook {
    // Словарь, где ключ - фамилия, значение - список телефонных номеров
    private final Map<String, List<String>> phoneDict;

    // Конструктор
    public PhoneBook() {
        this.phoneDict = new HashMap<>();
    }

    // Метод добавления записи
    public void add(String surname, String phoneNumber) {
        // Если фамилия уже существует, добавляем номер в список, иначе создаем новый список
        phoneDict.computeIfAbsent(surname, k -> new ArrayList<>()).add(phoneNumber);
    }

    // Метод получения номеров по фамилии
    public List<String> get(String surname) {
        // Если фамилия найдена, возвращаем список номеров, иначе null
        return phoneDict.getOrDefault(surname, Collections.emptyList());
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Demchenko", "123-456-789");
        phoneBook.add("Mezentceva", "987-654-321");
        phoneBook.add("Kareva", "555-555-555");

        // Получаем номера по фамилии
        System.out.println("Номера для Demchenko: " + phoneBook.get("Demchenko"));
        System.out.println("Номера для Mezentceva: " + phoneBook.get("Mezentceva"));
        System.out.println("Номера для Kareva: " + phoneBook.get("Kareva"));
    }
}