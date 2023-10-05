package org.metable.citenavix.application;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TokenizerMain {

    public static void main(String[] args) {

        String[] inputs = new String[] { "/a/b/c", "token1/token2/token3/token4", "./../new/name='f1', type=Project/../!" };

        for (String input : inputs) {
            // Split the string based on the '/' character
            String[] tokens = input.split("/");

            // Print the tokens
            for (String token : tokens) {
                System.out.println(token);
            }
        }

        String input = "name1 = \"value 1\", name2=12345, name3  = valueThree, name4 = 1.345, name5 = \"a/b/c\"";
        String regex = "(\\w+)\\s*=\\s*(\"[^\"]*\"|\\w+|\\d+(?:\\.\\d+)?)(?:,\\s*|$)";
        // String regex = "(\\w+)\\s*=\\s*(\"[^\"]*\"|\\w+|\\d+)(?:,\\s*|$)";

        // String regex = "([^\\s,=]+)\\s*=\\s*(\"[^\"]*\"|\\w+|\\d+)";
        // String input = "name1 = \"value one\" name2 =12345 name3 = valueThree";
        // String regex = "(\\w+)=(\\w+|\\d+)";
        // String regex = "(\\w+)\\s*=\\s*(\"[^\"]*\"|\\w+|\\d+)";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            System.out.println("Name: " + matcher.group(1) + ", Value: " + matcher.group(2));
        }
    }
}
