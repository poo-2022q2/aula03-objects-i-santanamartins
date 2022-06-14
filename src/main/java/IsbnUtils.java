import java.util.Random;

public class IsbnUtils {
    public static char genCheckDigit(String partial) {
        if (partial.length() < 9) {
            throw new IllegalArgumentException("Input code must have 9 digits");
        }

        var sum = 0;
        var coeff = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};

        for (var i = 0; i < coeff.length; i++) {
            sum += Character.getNumericValue(partial.charAt(i)) * coeff[i];
        }

        if (sum % 11 > 9) {
            return 'X';
        }

        return (Character.forDigit(sum % 11, 10));
    }

    private static boolean isValidFormat(String isbn) {
        if (isbn.length() != 11) {
            return false;
        }

        for (var i = 0; i < 9; i++) {
            if (!Character.isDigit(isbn.charAt(i))) {
                return false;
            }
        }

        if (isbn.charAt(9) != '-') {
            return false;
        }

        return Character.isDigit(isbn.charAt(10)) || isbn.charAt(10) == 'X';
    }

    public static String extractId(String isbn) {
        return isbn.substring(0,9);
    }

    public static char extractCheckDigit(String isbn) {
        return isbn.charAt(isbn.length() - 1);
    }

    public static boolean isValidIsbn(String isbn) {
        if (!isValidFormat(isbn)) {
            throw new IllegalArgumentException("Illegal ISBN");
        }

        return genCheckDigit(extractId(isbn)) == extractCheckDigit(isbn);
    }

    public static String genRandomCode(int length) {
        var builder = new StringBuilder();
        var random = new Random();

        for (int i = 0; i < length; i++) {
            builder.append(random.nextInt(10));
        }

        return builder.toString();
    }
}
