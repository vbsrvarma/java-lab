class ShareTrader {
    private static int maxProfit;
     // Method to find maximum profit with at most two transactions
    public static int findMaxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int n = prices.length;
        int[] firstTransactionProfit = new int[n];
        int[] secondTransactionProfit = new int[n];
// Calculate max profit achievable with the first transaction up to each day
        int minPriceSoFar = prices[0];
        for (int i = 1; i < n; i++) {
            firstTransactionProfit[i] = Math.max(firstTransactionProfit[i - 1], prices[i] - minPriceSoFar);
            minPriceSoFar = Math.min(minPriceSoFar, prices[i]);
        }
 // Calculate max profit achievable with the second transaction from each day to end
        int maxPriceSoFar = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            secondTransactionProfit[i] = Math.max(secondTransactionProfit[i + 1], maxPriceSoFar - prices[i]);
            maxPriceSoFar = Math.max(maxPriceSoFar, prices[i]);
        }
 // Calculate maximum profit by summing profits of two transactions at each point
        maxProfit = 0;
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, firstTransactionProfit[i] + secondTransactionProfit[i]);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        // test case 1
        int[] prices1 = {10, 22, 5, 75, 65, 80};
        System.out.println("Max Profit: " + findMaxProfit(prices1));

        // test case 2
        int[] prices2 = {2, 30, 15, 10, 8, 25, 80};
        System.out.println("Max Profit: " + findMaxProfit(prices2));
    }
}
