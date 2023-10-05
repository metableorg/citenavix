package org.metable.citenavix.application;

import java.util.regex.Pattern;

import java.util.regex.Matcher;

/*
* This regex matches any string that starts with a forward slash (/), followed by one or more alphanumeric characters, underscores (_), periods (.), hyphens (-), or slashes (/), optionally followed by one or more additional path segments, or a string that does not start with a forward slash and consists of one or more alphanumeric characters, underscores (_), periods (.), hyphens (-), or slashes (/).
* The | character is used to represent the OR operator. This means that the regex will match either a string that starts with a forward slash and is followed by one or more path segments, or a string that does not start with a forward slash.
* The * character is used to represent the zero or more quantifier. This means that the regex will match zero or more occurrences of the preceding character or group.
* The + character is used to represent the one or more quantifier. This means that the regex will match one or more occurrences of the preceding character or group.
* The [] character is used to represent a character class. This means that the regex will match any character that is inside the character class.
* The ^ character is used to represent the start of the string.
* The $ character is used to represent the end of the string.
*/

public class RegexExample {
    public static void main(String[] args) {
        // String regex = "^(?:/[a-zA-Z0-9_.-]+(/[a-zA-Z0-9_.-]+)*)|(?:[a-zA-Z0-9_.-]+)$";

        String regex = "^(?:/[a-zA-Z0-9_.-\\/]+(/[a-zA-Z0-9_.-\\/]+)*)|(?:[a-zA-Z0-9_.-\\/]+)$";

        /// String regex =
        /// "^(?:/?(?:[a-zA-Z0-9_.-]+|\\.\\.|\\.)(?:/?)(?:[a-zA-Z0-9_.-]+|\\.\\.|\\.)*/*$)|(?:[a-zA-Z0-9_.-]+)$";

        Pattern pattern = Pattern.compile(regex);

        String[] testPaths = { "/dir", "/dir1/dir2/dir3", "filename", "/dir/file", "/dir/file/dir2", "dir/",
                "/dir//file", ".", "..", "../dir1/dir2/dir3", "../././../../dir1/dir2/dir3", "../dir1/dir2/.././dir3",
                "../dir1/dir2/.././dir3!", };

        for (String path : testPaths) {
            Matcher matcher = pattern.matcher(path);
            if (matcher.matches()) {
                System.out.println(path + " matches the pattern.");
                String[] components = new String[matcher.groupCount()];
                for (int i = 0; i < components.length; i++) {
                    components[i] = matcher.group(i);
                }
                for (String component : components) {
                    System.out.println(component);
                }
            } else {
                System.out.println(path + " does not match the pattern.");
            }
        }
    }
}
