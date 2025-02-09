package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    return;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();

        dc.registerNewDish(dishType,dishName);
    }

    private static void generateDishCombo() {
        if(!dc.hasDishes()){
            System.out.println("Добавьте хотя бы одно блюдо.");
            return;
        }

        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        if(numberOfCombos < 1){
            System.out.println("Неправильное число наборов (Должно быть больше нуля). Генерация не удалась");
            return;
        }

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        String nextItem  = "placeholder";

        ArrayList<String> dishTypesInputList = new ArrayList<>();

        while (!nextItem.isEmpty()) {
            nextItem = scanner.nextLine();

            if(!nextItem.isEmpty()){
                if(!dc.hasDishType(nextItem)){
                    System.out.println("Такого типа нет. Пожалуйста выберите другой тип блюда");
                    continue;
                }
                dishTypesInputList.add(nextItem);
            }
        }

        if(dishTypesInputList.isEmpty()){
            System.out.println("Список пустой. Генерация не получится");
            return;
        }

        for (int i = 0; i < numberOfCombos; i++) {
            System.out.println("Комбо "+ (i + 1));
            System.out.println(dc.generateDishCombo(dishTypesInputList));
        }
    }
}
