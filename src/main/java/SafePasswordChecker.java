import java.util.Scanner;

/**
 * Check if a password is safe according to fixed criteria.
 */
public final class SafePasswordChecker {

    private SafePasswordChecker() {

    }

    private static boolean hasDigit(String s) {
        for (var i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                return true;
            }
        }

        return false;
    }

    private static boolean hasUpperCase(String s) {
        for (var i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                return true;
            }
        }

        return false;
    }

    private static boolean hasLowerCase(String s) {
        for (var i = 0; i < s.length(); i++) {
            if (Character.isLowerCase(s.charAt(i))) {
                return true;
            }
        }

        return false;
    }

    private static boolean hasNonAlphanumeric(String s) {
        for (var i = 0; i < s.length(); i++) {
            if (!Character.isAlphabetic(s.charAt(i)) && !Character.isDigit(s.charAt(i))) {
                return true;
            }
        }

        return false;
    }

    /**
     * Check if the password is safe.
     * Version that uses multi-pass strategy with helper methods.
     *
     * @param password the password
     * @return true if it is valid, false otherwise
     */
    public static boolean isSafePassword(String password) {
        if (password.length() < 8) {
            return false;
        }

        if (!hasDigit(password)) {
            return false;
        }

        if (!hasLowerCase(password)) {
            return false;
        }

        if (!hasUpperCase(password)) {
            return false;
        }

        return hasNonAlphanumeric(password);
    }

    /**
     * Check if the password is safe.
     * This version uses regular expressions.
     *
     * @param password the password
     * @return true if it is valid, false otherwise
     */
    public static boolean isSafePassword2(String password) {
        return password.length() >= 8
                && password.matches("\\d+")
                && password.matches("\\p{Lower}+")
                && password.matches("\\p{Upper}+")
                && password.matches("\\W+");
    }

    /**
     * The main method.
     *
     * @param args the args
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);) {
            System.out.println("Password: ");
            var password = scanner.next();

            System.out.println(isSafePassword(password) ? "Safe" : "Not safe");
        } catch (Exception e) {
            throw e;
        }
    }
}
