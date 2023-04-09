// Задание 1:
// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1
// человек может иметь несколько телефонов.
// Добавить функции: 1) Добавление номера, 2) Вывод всего.
// Пример:
// Я ввожу: 1
// К: Введите фамилию
// Я: Иванов
// К: Введите номер
// Я: 1242353
// К: Введите 1) Добавление номера, 2) Вывод всего
// Я ввожу: 1
// К: Введите фамилию
// Я: Иванов
// К: Введите номер
// Я: 547568
// К: Введите 1) Добавление номера, 2) Вывод всего
// Я: 2
// Иванов: 1242353, 547568

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class z1 {
    public static void main(String[] args) {
        Map<String, List<String>> phonBook = new HashMap<>();
        phonBook.put("Ivanov", List.of("111-111-111", "222-222-222"));
        phonBook.put("Petrov", List.of("333-333-333", "444-444-444"));
        phonBook.put("Sidorov", List.of("555-555-555", "666-666-666"));

        menu(phonBook);

    }

    public static String scanner() {
        Scanner scanner = new Scanner(System.in);
        String scan = scanner.nextLine();
        // scanner.close();
        return scan;
    }

    public static void find(Map<String, List<String>> phonBook) {
        System.out.println("Введите имя: ");
        String name = scanner();
        System.out.println(phonBook.get(name));
    }

    public static void allBook(Map<String, List<String>> phonBook) {
        System.out.println(phonBook);

    }

    public static Map<String, List<String>> add(Map<String, List<String>> phonBook) {
        System.out.println("Введите имя: ");
        System.out.println("Если хотите перестать вводить номера введите 'stop'");
        String name = scanner();
        List<String> number = new ArrayList<>();
        while (true) {
            System.out.println("Введите номер: ");
            String phon = scanner();
            if (phon.equals("stop")) {
                break;
            } else {
                number.add(phon);
            }
        }
        phonBook.put(name, number);

        return phonBook;
    }

    public static Map<String, List<String>> menu(Map<String, List<String>> phonBook) {
        System.out.println(
                "Введите команду из списка: find - найти контакт, add - добавить контакт, all - показать всю телефонную книгу, exit - выйти");
        while (true) {
            String comands = scanner();
            if (comands.equals("exit")) {
                break;
            } else {
                switch (comands) {
                    case "find":
                        find(phonBook);
                        break;
                    case "add":
                        add(phonBook);
                        break;
                    case "all":
                        allBook(phonBook);
                        break;
                    default:
                        break;
                }
            }
        }
        return phonBook;
    }
}