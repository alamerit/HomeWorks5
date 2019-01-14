package java_core;

import java.util.Random;

/**
 * 1. Написать программу по возведению числа в степень с помощью рекурсии.
 * 2. Написать программу «Задача о рюкзаке» с помощью рекурсии.
 */

public class Main {
    private static final int MAX_WEIGHT = 75;

    private static Metal[] goods = {
            new Metal(15, 30),
            new Metal(30, 40),
            new Metal(50, 50),
            new Metal(40, 25),
            new Metal(10, 20)
    };

    private static int s;

    public static void main(String[] args) {

        task1();
        System.out.println("Task 2 . Вес рюкзака " + MAX_WEIGHT);
        System.out.println(" Ценности ");
        System.out.print(findBestRes(goods.length - 1, MAX_WEIGHT)); //Task 2
    }

    private static int findBestRes(int i, int weigth) {
        if (i < 0) {
            return 0;
        }
        if (goods[i].getWeight() > weigth) {
            return findBestRes(i - 1, weigth);
        } else {
            return Math.max(findBestRes(i - 1, weigth), findBestRes(i - 1, weigth - goods[i].getWeight()) + goods[i].getValue());
        }


    }

    private static void task1() {
        Random random = new Random();
        int degree = random.nextInt(10);
        int number = random.nextInt(10);
        System.out.println(" Degree  " + degree + "\n Number " + number);
        s = number;
        calculation(number, degree);
    }

    private static void calculation(int number, int degree) {

        if (degree > 1) {
            calculation(number * s, degree - 1);
        } else {
            System.out.println(number); // Значение актуально только здесь.
        }

    }

    public static class Metal {
        private int weight;
        private int value;

        Metal(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        int getWeight() {
            return weight;
        }

        int getValue() {
            return value;
        }


    }


}
