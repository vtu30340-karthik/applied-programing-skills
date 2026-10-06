import java.util.Stack;
class StockSpanner {
    private Stack<int[]> stack;
    public StockSpanner() {
        stack = new Stack<>();
    }
    public int next(int price) {
        int span = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }
        stack.push(new int[]{price, span});
        return span;
    }
    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        System.out.print("Output: [null, ");
        for (int i = 0; i < prices.length; i++) {
            System.out.print(stockSpanner.next(prices[i]));
            if (i < prices.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
