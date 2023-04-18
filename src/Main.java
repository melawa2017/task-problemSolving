
/*

 * @Created 2023/04/17 - 4:53 AM
 * @Project problemSolving
 * @Author Mahmoud Elewa

 */

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        reverseString("abd(jnb)asdf");
        reverseString("abdjnbasdf");
        reverseString("dd(df)a(ghhh)");
    }


    public static void reverseString(String inputString) {
        // declaration
        String original = inputString;
        //validation: accepted length
        if (inputString.length() >= 1 && inputString.length() <= 2000) {
            //validation: only lowercase that contains parentheses
            if (inputString.matches("^[a-z()]*$")) {
                // declaration
                List<Integer> parenthesesPosition = new ArrayList<>();
                String substringToBeReversed;
                StringBuilder stringBuilder = new StringBuilder();
                // find all parentheses
                for (int i = 0; i < inputString.length(); i++) {
                    if (inputString.charAt(i) == '(')
                        parenthesesPosition.add(i);
                    if (inputString.charAt(i) == ')')
                        parenthesesPosition.add(i);
                }
                // reverse substrings between each pair of parentheses
                for (int i = 0; i < parenthesesPosition.size(); i+=2) {
                    //clear stringBuilder
                    stringBuilder.setLength(0);
                    // get substring to be reversed
                    substringToBeReversed = inputString.substring(parenthesesPosition.get(i) + 1, parenthesesPosition.get(i+1));
                    stringBuilder.append(substringToBeReversed);
                    // reverse by stringBuilder
                    inputString = inputString.substring(0, parenthesesPosition.get(i) + 1) + stringBuilder.reverse() + inputString.substring(parenthesesPosition.get(i+1));
                }
            }
        }
        // print the original
        System.out.println("Input: " + original);
        // print the reversed
        System.out.println("Output: " + inputString);
        System.out.println();
    }

}
