package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class Store {
    // the key is the product id, the value is a product object
    static HashMap<String, Product> inventory =
            new HashMap<>();
    public static void main(String[] args) {
// this method loads product objects into inventory
        loadInventory();
        Scanner scanner = new Scanner(System.in);
        boolean keeprunning = true;
        while(keeprunning) {
            System.out.print("What item are you interested in? ");
            String productName = scanner.nextLine();
            Product matchedProduct = inventory.get(productName);
            if (matchedProduct == null) {
                System.out.println("We don't carry that product");
                return;
            }
            System.out.printf("We carry %s and the price is $%.2f",
                    matchedProduct.getName(), matchedProduct.getPrice());
            int choice = 0;
            System.out.println("Would you like to search again?\n(1) Yes\n(2) No");
            choice = Integer.parseInt(scanner.nextLine());

            if (choice == 1) {
                continue;
            }
            if (choice == 2) {
                keeprunning = false;
            }
        }
    }

    private static void loadInventory() {
        try {
            String input;
            BufferedReader reader = new BufferedReader(new FileReader("C:/Users/ru551/pluralsight/workbook-3/Mod03/DataFiles/products.csv"));
            while ((input = reader.readLine()) != null) {
                String[] parts = input.split("\\|");
                if(parts[0].equals("SKU")) {
                    continue;
                }

                String sku = parts[0];
                String name = parts[1];
                double price = Double.parseDouble(parts[2]);
                String department = parts[3];

                inventory.put(name, new Product(sku, name, price));
            }
        } catch (FileNotFoundException e) {
            System.out.println("There was a problem reading the file. " + e.getMessage());
        } catch (Exception e) {
            System.out.println("something went wrong " + e.getMessage());
        }
    }


}

