package com.pluralsight;

public class Main {
    public static void main(String[] args) {

       int choice = 0;

            while (choice < 3) {
                try {
                    choice = Integer.parseInt(Utils.messageAndResponse("What would you like to do?\n(1) Choose a quote.\n(2) Hear a random quote.\n(3) Exit.\nChoose: "));
                    if (choice == 1) {
                        try {
                            Quotes.getQuote();
                            Utils.pauseReturn();
                        } catch (Exception e) {
                            System.out.println("That is not a number 1-10. Try again. \n");
                            //                   e.printStackTrace();
                        }
                    }
                    if (choice == 2) {
                        Quotes.getRandomQuote();
                        Utils.pauseReturn();
                    }
                } catch (Exception e) {
                    System.out.println("Stop it, bffr.\n");
                }

            }

    }
}
