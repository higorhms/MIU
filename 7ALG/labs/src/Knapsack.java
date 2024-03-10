import java.util.ArrayList;
import java.util.List;

public class Knapsack {

    public static int[] knapsack(int[] S, int[] val, int[] wt, int W) {
        int n = S.length;
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                if (wt[i-1] <= w) {
                    dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-wt[i-1]] + val[i-1]);
                } else {
                    dp[i][w] = dp[i-1][w];
                }
            }
        }

        // To reconstruct the solution:
        int res = dp[n][W];
        int w = W;
        int[] selectedItems = new int[n]; // 0 means item is not selected, 1 means item is selected

        for (int i = n; i > 0 && res > 0; i--) {
            if (res != dp[i-1][w]) {
                selectedItems[i-1] = 1;
                res -= val[i-1];
                w -= wt[i-1];
            }
        }

        return selectedItems;
    }

    public static void main(String[] args) {
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int W = 50;
        int n = values.length;

        int[] selectedItems = knapsack(values, weights, n, W);

        System.out.println("Selected items: ");
        for (Integer item : selectedItems) {
            System.out.println("s" + item);
        }
    }
}




