package com.pluralsight;

import java.util.*;
import java.io.InputStream;

public class BedtimeStories {

    public static String chooseStory() {

        System.out.println("Time for a bedtime story.\nGoldilocks\nHansel and Gretel\nMary Had a Little Lamb");
        String story = Utils.messageAndResponse("What story would you like to hear?");

        int storyInt = 0;
        if (story.equalsIgnoreCase("Goldilocks")) {
            storyInt = 1;
        }
        if (story.equalsIgnoreCase("Hansel and Gretel")) {
            storyInt = 2;
        }
        if (story.equalsIgnoreCase("Mary Had a Little Lamb")) {
            storyInt = 3;
        }

       String storyFile = null;
        switch(storyInt) {
            case 1:
                storyFile = "/goldilocks.txt";
                break;
            case 2:
                storyFile = "/hansel_and_gretel.txt";
                break;
            case 3:
                storyFile = "/mary_had_a_little_lamb.txt";
                break;
            default:
                System.out.println("Choose one of the available stories. :)");
        }
        return storyFile;
    }

    public static void readStory(String story) {

        InputStream is = BedtimeStories.class.getResourceAsStream(story);

        if (is == null) {
            System.out.println("story not found on classpath!");
            return;
        }

        try (Scanner scanner = new Scanner(is)) {
            int i = 1;
            while (scanner.hasNextLine()) {
                System.out.println(i + ". " + scanner.nextLine());
                i++;
            }
        }
    }


}
