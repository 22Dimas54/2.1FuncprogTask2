package ru.netology.honeybadger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private final static int SIZE_FACTOR = 100;
    private final static int PRICE_FACTOR = 1_000_000;
    private final static int COUNT_DEALS = 10;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите рекомендованную цену за квадратный метр:");
            int pricePerSquareMeter = Integer.parseInt(scanner.nextLine());
            List<Deal> dealList = new ArrayList<>();
            generatingDefaultDeals(pricePerSquareMeter, dealList);
            printingDeals(dealList);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    private static void printingDeals(List<Deal> dealList) {
        dealList.stream()
                .filter(w ->w.isHonesty())
                .forEach(System.out::println);
    }

    private static void generatingDefaultDeals(int pricePerSquareMeter, List<Deal> dealList) {
        for (int i = 0; i < COUNT_DEALS; i++) {
            Deal deal = new Deal(generatingDefaultParameters(SIZE_FACTOR), generatingDefaultParameters(SIZE_FACTOR), generatingDefaultParameters(PRICE_FACTOR));
            deal.setHonesty(checkingTheIntegrityOfTheTransaction(pricePerSquareMeter, pricePerSquareMeterDeal(deal.getCost(), deal.getWidth(), deal.getLength())));
            dealList.add(deal);
        }
    }

    private static int pricePerSquareMeterDeal(int cost, int width, int length) {
        try {
            return cost / (width * length);
        } catch (RuntimeException e) {
            return 0;
        }
    }

    private static boolean checkingTheIntegrityOfTheTransaction(int pricePerSquareMeter, int transactionPrice) {
        return pricePerSquareMeter <= transactionPrice;
    }

    private static int generatingDefaultParameters(int factor) {
        return (int) (Math.random() * factor);
    }

}
