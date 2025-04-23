package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("logs.txt"));

            writer.write(LocalDateTime.now() + " -Launch\n");
            boolean keepRunning = true;
            while(keepRunning) {
                int choice = Integer.parseInt(Utils.messageAndResponse("What would you like to do?\n(1) Search\n(2) Quit\n"));
                switch (choice) {
                    case 1:
                        String search = Utils.messageAndResponse("Search: ");
                        System.out.println("Not found in database.");
                        writer.write(LocalDateTime.now() + " -Search: " + search + "\n");
                        break;
                    case 2:
                        writer.write(LocalDateTime.now() + " -Exit");
                        keepRunning = false;
                        break;
                }
            }
            writer.close();
        }
        catch (IOException e) {
            System.out.println("Unable to access file" + e.getMessage());
        }
    }
}
