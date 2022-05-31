package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RatioUtils {
    public static ArrayList<Integer> getRatio(String newRatio) {

        // Parsing string to Arraylist of Integers
        String cutRatio = newRatio.substring(1, newRatio.length() - 1); // Cuts the ( ) brackets
        String[] elements = cutRatio.split(","); // converts to array of strings
        List<String> elementsAsList = Arrays.asList(elements); // converts to List
        ArrayList<String> listOfString = new ArrayList<String>(elementsAsList); // converts to ArrayList
        ArrayList<Integer> ratio = new ArrayList<Integer>(); // creates ArrayList of Integers
        // adds int value of strings from ArrayList listOfStrings to ArrayList ratio
        for (int i = 0; i < listOfString.size(); i++) {
            ratio.add(Integer.parseInt(listOfString.get(i)));
        }

        return ratio;
    }
}
