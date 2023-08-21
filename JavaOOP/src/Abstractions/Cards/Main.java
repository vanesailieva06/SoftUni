package Abstractions.Cards;

import Abstractions.Cards.CardSuit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Card Suits:");
//        for (CardSuit cardSuit : CardSuit.values()) {
//            System.out.printf("Ordinal value: %d; Name value: %s%n", cardSuit.ordinal(), cardSuit.name());
//        }
//        System.out.println("Card Ranks:");
//        for (CardRank cardRank : CardRank.values()) {
//            System.out.printf("Ordinal value: %d; Name value: %s%n", cardRank.ordinal(),cardRank.name());
//        }
        Scanner scanner = new Scanner(System.in);
        String rankCard = scanner.nextLine();
        String suitCard = scanner.nextLine();
        CardRank rank = CardRank.valueOf(rankCard);
        CardSuit suit = CardSuit.valueOf(suitCard);
        int sum = rank.getPower() + suit.getPower();
        System.out.printf("Card name: %s of %s; Card power: %d", rank.name(), suit.name(), sum);

    }
}
