import java.util.*;

public class Morse {

    private static String[] alphabet = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
                "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
                "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8",
                "9", "0"};
    
    private static String[] morseCodes = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
            "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
            "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
            "-.--", "--..", ".----", "..---", "...--", "....-", ".....",
            "-....", "--...", "---..", "----.", "-----"};

    public static ArrayList<String> decodeMorse(String encMessage) {
        /**
         * HINT: use your own methods to execute your recursion
         *       (feel free to add as many methods as you need),
         *       you CANNOT change the number of arguments in
         *       this `decodeMorse` method
         */
        ArrayList<String> result = new ArrayList<>();

        for (int i = 1; i <= encMessage.length(); i++) {
            String temp = findAlphaString(encMessage.substring(0, i));
            if (!temp.equals("")) {
                match(encMessage.substring(i), result, temp);
            }
        }

        return result;
    }

    public static String match(String message, ArrayList<String> result, String temp) {
        if (message.length() == 0) {
            result.add(temp);
            return temp;
        }
        for (int i = 1; i <= message.length(); i++) {
            String start = message.substring(0, i);
            String end = message.substring(i);
            String letter = findAlphaString(start);
            if (!letter.equals("")) {
                match(end, result, temp + letter);
            }
        }
        return temp; 
    }

    public static String findAlphaString(String checkedMessage){
        for (int i = 0; i < morseCodes.length; i++) {
            if (checkedMessage.equals(morseCodes[i])) {
                return alphabet[i];
            }
        }
        return "";
    }

    public static void main(String[] args) {
        /**
         * The `decoded` array list should contain 
         * ["tet", "ta", "nt", "k"] in any order
         * if you pass "-.-" as an argument
         */
        ArrayList<String> decoded = decodeMorse("-.-..");
        System.out.println(decoded);
    }
}
