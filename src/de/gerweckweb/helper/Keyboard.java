package de.gerweckweb.helper;

import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author domininic gerweck/daniel neubieser
 */
public final class Keyboard {
    public static final String BETWEEN = "Number between ";
    static final Scanner INPUT = new Scanner(System.in);
    static String strInput;

        //region Methods for Integer
    /**
     * Ask the user to input a number from console. Returns an integer value.
     *
     * @param errorMsg  Output tells user the error
     * @return num The valid whole number entry
     * @author domininic gerweck
     */
    public static int readInteger(String errorMsg,String input) {

        // keep looking until valid userinput
        return tryToParsoToIntBetweenMinMax(errorMsg, Integer.MIN_VALUE, Integer.MAX_VALUE, input);
    }

    /**
     * Asks the user to input a number from console in a given range. returns an integer value.
     *
     * @param errorMsg  Output tells user the errors
     * @param low       determines the smallest number
     * @param high      determines the largest number
     * @return num The valid whole number entry
     * @author domininic gerweck
     */
    public static int readInteger(String errorMsg, int low, int high, String input) {
        // keep looking until valid userinput
        return tryToParsoToIntBetweenMinMax(errorMsg, low, high, input);
    }

    /**
     * @param textField check this textField for valid Input (Integer) between min
     *                  and max
     * @return only Integer are possible
     * @author daniel neubieser
     */
    public static int guiReadInt(JTextField textField, int min, int max) {
        //check for keyword
        tryKeyword(textField.getText().toUpperCase());
        // keep looking until valid userinput
        tryGuiValueBetweenMinMax(textField, min, max);
        return Integer.parseInt(textField.getText());
    }

    /**
     * @param textField check this textField for valid Input (Integer)
     * @return only Integer are possible
     * @author daniel neubieser
     */
    public static int guiReadInt(JTextField textField) {
        //check for keyword
        tryKeyword(textField.getText().toUpperCase());
        // keep looking until valid userinput
        tryGuiValueBetweenMinMax(textField, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return Integer.parseInt(textField.getText());
    }
    //endregion
                //region submethods for Integermethods
    private static int tryToParsoToIntBetweenMinMax(String errorMsg, int low, int high, String input) {
        int num = 0;
        boolean isValid = false;
        while (!isValid) {
            // try to convert String to int
            try {
                num = Integer.parseInt(input);
                // check if input is in the right range
                isValid = isValueBetweenMinMax(low, high, num);
            } catch (NumberFormatException e) {
                System.out.println(errorMsg);
            }
        }
        return num;
    }




    private static void tryGuiValueBetweenMinMax(JTextField textField, int min, int max) {
        // try to convert String to int
        String toCheck = tryToParseGuiValueToInt(textField, min, max);

        if (Integer.parseInt(toCheck) < min || Integer.parseInt(toCheck) > max) {
            textField.setText(BETWEEN + min + " & " + max);
        }
    }

    private static String tryToParseGuiValueToInt(JTextField textField, int min, int max) {
        try {
            return String.valueOf(Integer.parseInt(textField.getText()));

        } catch (NumberFormatException e) {
            return BETWEEN + min + " & " + max;
        }
    }
    //endregion


        //region for Doubles

    public static double readDouble(String errorMsg, double low, double high, String input) {
        return printValueAfterCheckForValid(errorMsg, low, high, input);
    }

    /**
     * @param errorMsg  Output tells user the errors
     * @return returns the valid whole number entry(double)
     * @author domininic gerweck/daniel neubieser
     */
    public static double readDouble(String errorMsg, String input) {
        return printValueAfterCheckForValid(errorMsg, Double.MIN_VALUE, Double.MAX_VALUE, input);
    }

    /**
     * @param textField check this textField for valid Input (Double) between min, max
     * @param min       determines the smallest number
     * @param max       determines the largest number
     * @author daniel neubieser
     */
    public static void readDoubleFromGui(JTextField textField, double min, double max) {
        //check for keyword
        tryKeyword(textField.getText().toUpperCase());
        // keep looking until valid userinput
        parseGuiValueToDouble(textField, min, max);
    }

    /**
     * @param textField check this textField for valid Input (Double)
     * @return only Integer are possible
     * @author daniel neubieser
     */
    public static double readDoubleFromGui(JTextField textField) {
        //check for keyword
        tryKeyword(textField.getText().toUpperCase());
        // keep looking until valid userinput
        parseGuiValueToDouble(textField, Double.MIN_VALUE, Double.MAX_VALUE);
        return Double.parseDouble(textField.getText());
    }
    //endregion
                //region Submethods for DoubleMethods

    /**
     * @param errorMsg  Output tells user the errors
     * @param low       determines the smallest number
     * @param high      determines the largest number
     * @return returns the valid whole number entry(double)
     * @author domininic gerweck/daniel neubieser
     */
    private static double printValueAfterCheckForValid(String errorMsg, double low, double high, String input) {
        double num = 0;
        boolean isValid = false;
        // keep looking until valid userinput
        while (!isValid) {
            // try to convert String to int
            try {
                num = Double.parseDouble(input);
                // check if input is in the right range
                isValid = isValueBetweenMinMax(low, high, num);
                if (!isValid) {
                    System.out.println(errorMsg);
                }
            } catch (NumberFormatException e) {
                System.out.println(errorMsg);
            }
        }
        return num;
    }

    private static boolean isValueBetweenMinMax(double low, double high, double num) {
        return num >= low && num <= high;
    }


    private static void parseGuiValueToDouble(JTextField textField, double min, double max) {
        parseOnlyWhenDoubleInRange(textField, min, max);
    }

    /**
     * check text box entry for is double in valid range
     *
     * @param textField check this textField for valid Input (Double) between min, max
     * @param min       determines the smallest number
     * @param max       determines the largest number
     */
    private static void parseOnlyWhenDoubleInRange(JTextField textField, double min, double max) {
        if (Double.parseDouble(textField.getText()) < min || Double.parseDouble(textField.getText()) > max) {
            System.out.println(Double.parseDouble(textField.getText()));
            tryParseTextFieldToDouble(textField, min, max);
        }
    }

    private static void tryParseTextFieldToDouble(JTextField textField, double min, double max) {
        try {
            Double.parseDouble(textField.getText());
        } catch (NumberFormatException e) {
            textField.setText(BETWEEN + min + " & " + max);
        }
    }

    //endregion

        //region Characters
    public static boolean getCharacter(String promptMsg, String errorMsg, Character character1){
        return false;
        //return getValueAfterCheckForValid(promptMsg, errorMsg, low, high);
    }
    //endregion
        //region KeywordHandling

    /**
     * tryKeyword takes over the param text and checks whether it is a keyword
     * in order to then start the Keyword - method doAnything()
     *
     * @param text input is checked for keywords
     * @author daniel neubieser
     */
    public static void tryKeyword(String text) {
        if (containsKeyword(text.toUpperCase())) {
            try {
                Keywords.valueOf(text.toUpperCase()).doAnything();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    /**
     * @param text Input is checked for keywords
     * @return is present in keywords
     * @author daniel neubieser
     */
    public static boolean containsKeyword(String text) {
        for (Keywords c : Keywords.values()) {
            if (c.name().equals(text)) {
                return true;
            }
        }
        return false;
    }
    //endregion

        //region other Methods
    /**
     * Method for get UserInput and check this for valid Keywords
     *
     * @param promptMsg Output for request a specified Input
     */
    public static String userInput(String promptMsg) {
        System.out.println(promptMsg);
        // grab input from Keyboard
        strInput = INPUT.nextLine();
        //check for keyword
        tryKeyword(strInput.toUpperCase());
        return strInput;
    }

    /**
     * Method for get UserInput and check this for valid Keywords
     * print min & max values
     *
     * @param promptMsg Output for request a specified Input
     */
    public static String userInput(String promptMsg, int low, int high) {
        System.out.printf(promptMsg + "\n(%d - %d)\n", low, high);
        // grab input from Keyboard
        strInput = INPUT.nextLine();
        //check for keyword
        tryKeyword(strInput.toUpperCase());
        return strInput;
    }
    //endregion
}
