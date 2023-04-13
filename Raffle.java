package drawingOfToys;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import drawingOfToys.Toys.Car;
import drawingOfToys.Toys.Doll;
import drawingOfToys.Toys.Gun;
import drawingOfToys.Toys.Ball;
import drawingOfToys.Toys.Horse;

/**
 * Розыгрыш
 */
public class Raffle {

    public static void main(String[] args) throws IOException {
        try (Scanner readScanner = new Scanner(System.in)) {

            Case box = new Case();
            boolean menuOn = true;
            box.FillBox();
            System.out.println("Игровой автомат Игрушки");
            while (menuOn) {
                System.out.println("______________________________________________________________");

                System.out.println(
                        "Выберите действие\n1-Посмотреть cписок игрушек\n2-Обновить cписок игрушек \n3-Собрать свой cписок игрушек\n4-Выиграть приз\n5-Выйти\n");
                System.out.println("Ваша команда:");
                int command = readScanner.nextInt();
                switch (command) {
                    case 1 -> System.out.println(box.printBox());
                    case 2 -> {
                        box.clearBox();
                        box.FillBox();
                    }

                    case 3 -> {
                        box.clearBox();
                        Boolean edit = true;
                        while (edit) {
                            System.out.println("Список призовых игрушек:");
                            System.out.println(box.printBox());
                            System.out.println("______________________________________________________________");
                            System.out.println(
                                    "Что хотите добавить\n1-Мяч\n2-Машинку\n3-Куклу\n4-Пистолет\n5-Лошадку\n6-Закончить набор игрушек");
                            System.out.println("Ваша команда:");
                            int whatToAdd = readScanner.nextInt();
                            switch (whatToAdd) {
                                case 1 -> box.addToy(new Ball());
                                case 2 -> box.addToy(new Car());
                                case 3 -> box.addToy(new Doll());
                                case 4 -> box.addToy(new Gun());
                                case 5 -> box.addToy(new Horse());
                                case 6 -> {
                                    edit = false;
                                    System.out.println("Список призовых игрушек:");
                                    System.out.println(box.printBox());
                                }
                                default -> System.out.println("Неверная команда");
                            }

                        }
                    }
                    case 4 -> {
                        int prizeIndex = box.dropPrize();
                        if (prizeIndex == -1) {
                            System.out.println("Список призовых игрушек пустой");
                            break;
                        }
                        try (FileWriter writer = new FileWriter("YourPrize.txt")) {
                            writer.write(box.getInside().get(prizeIndex).getTitle());
                        }
                        System.out.println("Вы выиграли " + box.getInside().get(prizeIndex).getTitle());
                        System.out.println("Он находится в YourPrize");
                        box.removeItem(prizeIndex);
                    }


                    case 5 -> {
                        System.out.println("До свидания!");
                        menuOn = false;
                    }
                    default -> System.out.println("Неверная команда, повторите");

                }

            }
        }

    }
}