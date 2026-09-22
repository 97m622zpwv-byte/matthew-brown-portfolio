import java.util.Scanner;

public class Assessment04 {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        final String SPECIAL_CHARACTERS = "!@#$%^&*()-_+=[]{}|\\:;\"'<>,.?/~";

        boolean hasValidLength = false;
        boolean hasUppercaseLetter = false;
        boolean hasDigit = false;
        boolean hasSpecialCharacter = false;
        boolean hasWhitespace = false;

        System.out.println("Password Security Checker");
        System.out.println("Your password must have at least 8 characters, no spaces,");
        System.out.println("at least 1 uppercase letter, 1 digit, and 1 allowed special character.");
        System.out.print("Enter a password: ");
        String passwordEntry = inputScanner.nextLine();

        if (passwordEntry.length() >= 8) {
            hasValidLength = true;
        }

        // Enhanced for loop examines each character in the password once.
        for (char currentCharacter : passwordEntry.toCharArray()) {
            if (Character.isLetter(currentCharacter)
                    && Character.isUpperCase(currentCharacter)) {
                hasUppercaseLetter = true;
            }

            if (Character.isDigit(currentCharacter)) {
                hasDigit = true;
            }

            if (Character.isWhitespace(currentCharacter)) {
                hasWhitespace = true;
            }

            if (SPECIAL_CHARACTERS.indexOf(currentCharacter) >= 0) {
                hasSpecialCharacter = true;
            }
        }

        boolean isPasswordValid = hasValidLength
                && hasUppercaseLetter
                && hasDigit
                && hasSpecialCharacter
                && !hasWhitespace;

        if (isPasswordValid) {
            System.out.println("Result: Valid password. All security requirements are met.");
        } else {
            System.out.println("Result: Invalid password.");

            if (!hasValidLength) {
                System.out.println("- Use at least 8 characters.");
            }
            if (!hasUppercaseLetter) {
                System.out.println("- Include at least 1 uppercase letter.");
            }
            if (!hasDigit) {
                System.out.println("- Include at least 1 digit.");
            }
            if (!hasSpecialCharacter) {
                System.out.println("- Include at least 1 allowed special character.");
            }
            if (hasWhitespace) {
                System.out.println("- Remove all spaces and other whitespace.");
            }
        }

        inputScanner.close();
    }
}
