package org.lessons.java.christmas;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Create the arrayList
        List<String> gifts = new ArrayList<>();

        boolean stop = false;

        do {
            System.out.println("What gift do you want to add to the list? (stop to quit) ");
            String gift = scanner.nextLine();

            gifts.add(gift);
            System.out.println("Partial list length: " + gifts.size());
            System.out.println("do you want to continue adding gifts? (yes/no) ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("no")) {
                stop = true;
            }

        } while (!stop);

        Collections.sort(gifts);

        System.out.println("Total list length: " + gifts.size());
        for (String gift: gifts ){
            System.out.println("- " + gift);
        }

    }
}
