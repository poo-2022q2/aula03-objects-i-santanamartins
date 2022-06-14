import java.util.Random;
import java.util.Scanner;

public class SafePasswordGenerator {
    private static char randomChar() {
        String ascii = " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";
        Random random = new Random();

        return ascii.charAt(random.nextInt(ascii.length()));
    }

    private static String genPassword(int size) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < size; i++) {
            builder.append(randomChar());
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Password length: ");

        int passwordSize = scanner.nextInt();

        scanner.close();

        String password = "";
        
        while (!SafePasswordChecker.isSafePassword(password)) {
            password = genPassword(passwordSize);
        }

        System.out.println(password);

    }    
}
