public class Main{
    // Класс Person
    static class Person {
        private final String fullName;
        private final String position;
        private final String email;
        private final String phone;
        private final double salary;
        private final int age;

        //Конструктор класса
        public Person(String fullName, String position, String email, String phone, double salary, int age) {
            this.fullName = fullName;
            this.position = position;
            this.email = email;
            this.phone = phone;
            this.salary = salary;
            this.age = age;
        }

        public void printInfo() {
            System.out.println("ФИО: " + fullName);
            System.out.println("Должность: " + position);
            System.out.println("E-mail: " + email);
            System.out.println("Телефон: " + phone);
            System.out.println("Зарплата: " + salary);
            System.out.println("Возраст: " + age);
        }

        // Метод для создания массива сотрудников и вывода информации о них
        public static void createAndPrintPersons() {
            Person[] persArray = new Person[5];
            persArray[0] = new Person("Иванов Иван Иванович", "Инженер поддержки", "ivanov@mail.com", "1234567890", 55555.2, 55);
            persArray[1] = new Person("Петров Станислав Петрович", "Менеджер", "petrov@mail.com", "0987654321", 66660.1, 44);
            persArray[2] = new Person("Владимиров Сергей Владимирович", "Разработчик", "vladimirov@mail.com", "1122334455", 77777.3, 24);
            persArray[3] = new Person("Васильев Василий Васильевич", "Аналитик данных", "vasiliev@mail.com", "5566778899", 88888.4, 34);
            persArray[4] = new Person("Смирнова Мария Ивановна", "Тестировщик", "smirnova@mail.com", "6677889900", 55666.5, 24);

            for (Person person : persArray) {
                person.printInfo();
                System.out.println();
            }
        }
    }

    // Класс Park
    static class Park {
        private final Attraction[] attractions;
        private int count;
        public Park(int size) {
            attractions = new Attraction[size];
            count = 0;
        }

        public void addAttraction(String name, String workingHours, double price) {
            if (count < attractions.length) {
                attractions[count] = new Attraction(name, workingHours, price);
                count++;
            }
        }

        public void printAttractions() {
            for (int i = 0; i < count; i++) {
                attractions[i].printInfo();
                System.out.println();
            }
        }

        // Вложенный класс Attraction
        static class Attraction {
            private final String name;
            private final String workHours;
            private final double price;

            public Attraction(String name, String workingHours, double price) {
                this.name = name;
                this.workHours = workingHours;
                this.price = price;
            }

            public void printInfo() {
                System.out.println("Название аттракциона: " + name);
                System.out.println("Время работы: " + workHours);
                System.out.println("Стоимость: " + price);
            }
        }

        // Метод для создания парка и вывода информации об аттракционах
        public static void createAndPrintPark() {
            Park park = new Park(3);
            park.addAttraction("Колесо обозрения", "10:00 - 21:00", 200);
            park.addAttraction("Американские горки", "10:00 - 22:00", 300);
            park.addAttraction("Комната кривых зеркал", "10:00 - 22:00", 250);

            park.printAttractions();
        }
    }
    //Проверка вывода в консоль
    public static void main(String[] args) {
        // Создание массива сотрудников и вывод информации о них
        Person.createAndPrintPersons();

        // Создание парка и вывод информации об аттракционах
        Park.createAndPrintPark();
    }
}
