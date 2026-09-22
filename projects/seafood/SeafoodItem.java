/**
 * Represents a seafood product sold by weight.
 * The class stores product details and calculates the total purchase price.
 */
public class SeafoodItem {
    private String productName;
    private double pricePerPound;
    private double weightInPounds;

    /**
     * Creates a SeafoodItem with a name, price per pound, and weight.
     *
     * @param productName the name of the seafood product
     * @param pricePerPound the price of one pound
     * @param weightInPounds the selected weight in pounds
     */
    public SeafoodItem(String productName, double pricePerPound, double weightInPounds) {
        this.productName = productName;
        this.pricePerPound = pricePerPound;
        this.weightInPounds = weightInPounds;
    }

    // Returns the product name.
    public String getProductName() {
        return productName;
    }

    // Updates the product name.
    public void setProductName(String productName) {
        this.productName = productName;
    }

    // Returns the price per pound.
    public double getPricePerPound() {
        return pricePerPound;
    }

    // Updates the price per pound.
    public void setPricePerPound(double pricePerPound) {
        this.pricePerPound = pricePerPound;
    }

    // Returns the selected weight in pounds.
    public double getWeightInPounds() {
        return weightInPounds;
    }

    // Updates the selected weight in pounds.
    public void setWeightInPounds(double weightInPounds) {
        this.weightInPounds = weightInPounds;
    }

    /**
     * Calculates the total price by multiplying price per pound by weight.
     *
     * @return the total purchase price
     */
    public double calculateTotalPrice() {
        return pricePerPound * weightInPounds;
    }

    /**
     * Returns a formatted description that includes the calculated total.
     */
    @Override
    public String toString() {
        return String.format(
                "Product: %s%nPrice per pound: $%.2f%nWeight: %.2f lb%nTotal price: $%.2f",
                productName, pricePerPound, weightInPounds, calculateTotalPrice());
    }
}
