import java.util.Scanner;

public class SafePasswordChecker {

    public static boolean hasDigit(String s) {
        for (var i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                return true;
            }
        }

        return false;
    }

    public static boolean hasUpperCase(String s) {
        for (var i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                return true;
            }
        }

        return false;
    }

    public static boolean hasLowerCase(String s) {
        for (var i = 0; i < s.length(); i++) {
            if (Character.isLowerCase(s.charAt(i))) {
                return true;
            }
        }

        return false;
    }

    public static boolean hasNonAlphanumeric(String s) {
        for (var i = 0; i < s.length(); i++) {
            if (!Character.isAlphabetic(s.charAt(i)) && !Character.isDigit(s.charAt(i))) {
                return true;
            }
        }

        return false;
    }

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

    public static boolean isSafePassword2(String password) {
        return password.length() >= 8
                && password.matches("\\d+")
                && password.matches("\\p{Lower}")
                && password.matches("\\p{Upper}")
                && password.matches("\\W");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Password: ");
        String password = scanner.next();
        
        scanner.close();
        System.out.println(isSafePassword(password) ? "Safe" : "Not safe");
    
    }
}
