import java.util.Arrays;
import java.util.concurrent.*;

public class CoinChangeMultithreaded {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Check if the required arguments are provided
        if (args.length < 2) {
            System.out.println("Usage: java CoinChangeMultithreaded <sum> <coin1> <coin2> ... <coinN>");
            return;
        }

        // Parse the sum and coins from command-line arguments
        int sum = Integer.parseInt(args[0]);
        int[] coins = new int[args.length - 1];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(args[i + 1]);
        }

        System.out.println("Input Coins: " + Arrays.toString(coins));
        System.out.println("Target Sum: " + sum);

        // Use a thread pool to calculate the total number of ways
        ExecutorService executor = Executors.newFixedThreadPool(coins.length);
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> countWays(coins, sum), executor);

        // Retrieve and display the result
        int totalWays = future.get();
        executor.shutdown();
        System.out.println("Total ways to make sum " + sum + ": " + totalWays);
    }

    private static int countWays(int[] coins, int sum) {
        int[] dp = new int[sum + 1];
        dp[0] = 1; // Base case: There's one way to make sum 0

        // Build the dp array iteratively
        for (int coin : coins) {
            for (int i = coin; i <= sum; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[sum];
    }
}
