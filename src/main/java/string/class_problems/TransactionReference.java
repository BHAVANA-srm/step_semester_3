package string.class_problems;
public class TransactionReference {

    static String normalizeReference(String raw) {

        // Remove leading and trailing spaces
        String reference = raw.trim();

        // Convert only first 3 characters to uppercase
        if (reference.length() >= 3) {

            reference = reference.substring(0, 3).toUpperCase()
                    + reference.substring(3);
        }

        return reference;
    }


    static String validateAndFormat(String reference) {

        // Check length
        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }


        // Check first 3 characters are letters
        for (int i = 0; i < 3; i++) {

            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }


        // Check remaining 11 characters are digits
        for (int i = 3; i < 14; i++) {

            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: body must contain only digits";
            }
        }


        // Extract values
        String bankCode = reference.substring(0, 3);

        String date = reference.substring(3, 9);

        String day = date.substring(0, 2);
        String month = date.substring(2, 4);
        String year = date.substring(4, 6);

        String sequence = reference.substring(9, 14);


        // Build formatted output
        StringBuilder result = new StringBuilder();

        result.append("[");
        result.append(bankCode);
        result.append("] DATE: ");

        result.append(day);
        result.append("/");
        result.append(month);
        result.append("/");
        result.append(year);

        result.append(" | SEQ: ");
        result.append(sequence);

        return result.toString();
    }


    public static void main(String[] args) {

        String raw = " hdf03022600042 ";

        String normalized = normalizeReference(raw);

        System.out.println(validateAndFormat(normalized));
    }
}
