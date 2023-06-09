package org.lessons.java.christmas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    private final static String FILE_PATH = "./resources/gifts.txt";

    public static void main(String[] args)  {

        Scanner reader = null;
        try {
            reader = new Scanner(new File(FILE_PATH));
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } finally {
            if (reader != null) {
                reader.close();
            }
        }

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

        scanner.close();

        File file = new File(FILE_PATH);
        boolean fileExists = file.exists();

        // Open FileWriter
        FileWriter writer = null;
        try {
            if (!fileExists) {
                writer = new FileWriter(FILE_PATH);
                writer.write("GIFTS LIST \n");
            } else {
                writer = new FileWriter(FILE_PATH, true);
            }

            for (String gift: gifts ){
                writer.write("- " + gift.toString() + "\n");
            }
        } catch (IOException e) {
            System.out.println("unable to write file");
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
