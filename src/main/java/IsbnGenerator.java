public class IsbnGenerator {

    private static String genIsbn() {
        var partial = IsbnUtils.genRandomCode(9);

        return String.format("%s-%s", partial, IsbnUtils.genCheckDigit(partial));
    }

    public static void main(String[] args) {
        System.out.println(genIsbn());
    }
}
