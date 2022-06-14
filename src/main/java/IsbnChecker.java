import java.util.Scanner;

/**
 * Check if a ISBN code is valid.
 */
public final class IsbnChecker {

    private IsbnChecker() {

    }

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var isbn = scanner.next();

        scanner.close();
        System.out.println((IsbnUtils.isValidIsbn(isbn)) ? "Valid" : "Invalid");
    }
}
