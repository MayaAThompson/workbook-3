package com.pluralsight;

public class Quotes {

    private static String quoteList(int index) {
        String[] quotes = new String[10];
        quotes[0] = "Road work ahead... uh, yeah I sure hope it does.";
        quotes[1] = "It is Wednesday my dudes... AAAAHHHHHHH!!!!!!";
        quotes[2] = "2 bros chillin' in a hot tub, 5 feet apart, cuz they're not gay.";
        quotes[3] = "Oh my god... He on X-games mode.";
        quotes[4] = "I wanna be a cowboy baby!";
        quotes[5] = "My main goal is to blow up, then act like I don't know nobody. hnahnahnahnahna!";
        quotes[6] = "I said whoever threw that paper, your mom's a hoe!";
        quotes[7] = "AAAAHHHHH! Stop! I coulda dropped my croissant.";
        quotes[8] = "Oh god, and they were room mates.";
        quotes[9] = "Look at all those chickens.";
        return quotes[index];
    }
    public static void getQuote() {

        int i = 0;
        try {
            i = Integer.parseInt(Utils.messageAndResponse("Which quote do you want to hear? (1-10): ") + 1);
        } catch (NumberFormatException e) {
            System.out.println("Hey... that's not a number\n");
        }
        System.out.println("\n" + Quotes.quoteList(i));
    }

    public static void getRandomQuote() {
        int i = (int)(Math.random() * 10) ;
        System.out.println("\n" + Quotes.quoteList(i));
    }

}
