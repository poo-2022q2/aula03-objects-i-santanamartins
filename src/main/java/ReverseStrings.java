import java.util.Scanner;

public class ReverseStrings {
    public static String reverse(String s) {
        var builder = new StringBuilder();

        for (var i = s.length() - 1; i >= 0; i--) {
            builder.append(s.charAt(i));
        }

        return builder.toString();
    }

    public static String[] reverse(String[] strArray) {
        var result = new String[strArray.length];

        for (var i = 0; i < result.length; i++) {
            result[i] = reverse(strArray[i]);
        }

        return result;
    }

    public static String[] loadArray() {
        var scanner = new Scanner(System.in);
        var strArray = new String[scanner.nextInt()];

        scanner.close();
        for (int i = 0; i < strArray.length; i++) {
            strArray[i] = scanner.next();
        }

        return strArray;
    }

    public static String toString(String[] strArray) {
        var builder = new StringBuilder();

        for (int i = 0; i < strArray.length; i++) {
            builder.append(String.format("%d\t%s\n", i, strArray[i]));
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(toString(reverse(loadArray())));
    }
}
