/** A small runnable demonstration of the Stock model. */
public class StockDemo {
    public static void main(String[] args) {
        Stock apple = new Stock("AAPL", "Apple Inc.", 234.57, 231.41);
        System.out.println("Stock Information");
        System.out.println(apple);
    }
}
