/**
 * Represents a company's stock and its current and previous closing prices.
 */
public class Stock {
    private String tickerSymbol;
    private String companyName;
    private double currentPrice;
    private double lastClosingPrice;

    /**
     * Creates a Stock object with identifying information and price data.
     */
    public Stock(String tickerSymbol, String companyName,
                 double currentPrice, double lastClosingPrice) {
        this.tickerSymbol = tickerSymbol;
        this.companyName = companyName;
        this.currentPrice = currentPrice;
        this.lastClosingPrice = lastClosingPrice;
    }

    /**
     * Calculates the dollar change from the last closing price.
     */
    public double getPriceChange() {
        return currentPrice - lastClosingPrice;
    }

    /**
     * Calculates the percentage change from the last closing price.
     */
    public double getPercentageChange() {
        return (getPriceChange() / lastClosingPrice) * 100;
    }

    /**
     * Returns a clearly labeled, human-readable description of the stock.
     * Monetary values and the percentage change are formatted to two decimals.
     */
    @Override
    public String toString() {
        return String.format(
                "Ticker symbol: %s%n" +
                "Company name: %s%n" +
                "Current price: $%.2f%n" +
                "Last closing price: $%.2f%n" +
                "Price change: $%.2f%n" +
                "Percentage change: %.2f%%",
                tickerSymbol, companyName, currentPrice, lastClosingPrice,
                getPriceChange(), getPercentageChange());
    }
}
