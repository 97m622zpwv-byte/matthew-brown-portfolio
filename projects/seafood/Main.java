import java.util.Scanner;

/**
 * Collects information for three seafood products and displays a summary.
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // A fixed-size array is appropriate because exactly three items are required.
        SeafoodItem[] seafoodItems = new SeafoodItem[3];

        // The outer loop creates and stores each SeafoodItem object.
        for (int i = 0; i < seafoodItems.length; i++) {
            System.out.println("Enter information for seafood item " + (i + 1) + ":");

            String productName;
            do {
                System.out.print("Product name: ");
                productName = input.nextLine().trim();
                if (productName.isEmpty()) {
                    System.out.println("Product name cannot be blank. Please try again.");
                }
            } while (productName.isEmpty());

            // This nested validation loop repeats until the user enters a positive price.
            double pricePerPound = 0.0;
            boolean validPrice = false;
            while (!validPrice) {
                System.out.print("Price per pound: $");
                String priceText = input.nextLine().trim();
                try {
                    pricePerPound = Double.parseDouble(priceText);
                    if (pricePerPound > 0) {
                        validPrice = true;
                    } else {
                        System.out.println("Price must be greater than zero. Please try again.");
                    }
                } catch (NumberFormatException exception) {
                    System.out.println("Invalid entry. Please enter a number greater than zero.");
                }
            }

            // A second nested validation loop prevents zero, negative, or nonnumeric weights.
            double weightInPounds = 0.0;
            boolean validWeight = false;
            while (!validWeight) {
                System.out.print("Weight in pounds: ");
                String weightText = input.nextLine().trim();
                try {
                    weightInPounds = Double.parseDouble(weightText);
                    if (weightInPounds > 0) {
                        validWeight = true;
                    } else {
                        System.out.println("Weight must be greater than zero. Please try again.");
                    }
                } catch (NumberFormatException exception) {
                    System.out.println("Invalid entry. Please enter a number greater than zero.");
                }
            }

            seafoodItems[i] = new SeafoodItem(productName, pricePerPound, weightInPounds);
            System.out.println();
        }

        System.out.println("SEAFOOD ORDER SUMMARY");
        System.out.println("=====================");

        // This loop relies on each object's toString() method for formatted output.
        for (int i = 0; i < seafoodItems.length; i++) {
            System.out.println("Item " + (i + 1));
            System.out.println(seafoodItems[i]);
            System.out.println();
        }

        input.close();
    }
}
