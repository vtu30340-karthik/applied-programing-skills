import java.util.Stack;
public class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[i] <= prices[stack.peek()]) {
                int prevIndex = stack.pop();
                answer[prevIndex] = prices[prevIndex] - prices[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int remainingIndex = stack.pop();
            answer[remainingIndex] = prices[remainingIndex];
        }   
        return answer;
    }
}
