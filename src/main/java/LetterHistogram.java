import java.util.Scanner;

public class LetterHistogram {
    private static final String ascii = " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";

    private static int[] buildHistogram(String s) {
        var histogram = new int[ascii.length()];

        for (var i = 0; i < s.length(); i++) {
            var pos = ascii.indexOf(s.charAt(i));

            if (pos >= 0) {
                histogram[pos]++;
            }
        }

        return histogram;
    }

    private static String loadText() {
        var scanner = new Scanner(System.in);
        var builder = new StringBuilder();

        scanner.useDelimiter("\n");
        while (scanner.hasNext()) {
            builder.append(scanner.next());
        }
        scanner.close();
        
        return builder.toString();
    }

    private static String formatHistogram(int[] histogram) {
        if (histogram.length != ascii.length()) {
            throw new IllegalArgumentException("Invalid histogram size");
        }

        var builder = new StringBuilder();

        for (var i = 0; i < ascii.length(); i++) {
            if (histogram[i] > 0) {
                builder.append(String.format("%s\t%d\n", ascii.charAt(i), histogram[i]));
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.print(formatHistogram(buildHistogram(loadText())));
    }
}
