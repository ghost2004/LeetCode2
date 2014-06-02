/*
 * Say you have an array for which the ith element
 *  is the price of a given stock on day i.

Design an algorithm to find the maximum profit. 
You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the 
same time (ie, you must sell the stock before you buy again).
 */
public class StockBuySellBestIII {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int max = 0;
        int length = prices.length;
        int i;
        int profitLeft[] = new int[length];
        int profitRight[] = new int[length];
        // Scan from left to right
        profitLeft[0] = 0;
        int curMin = prices[0];
        for (i = 1; i < length; i++) {
            profitLeft[i] = Math.max(profitLeft[i-1], prices[i] - curMin);
            curMin = Math.min(curMin, prices[i]);
        }
        // Scan from right to left
        profitRight[length-1] = 0;
        int curMax = prices[length-1];
        for (i = length - 2; i >= 0; i--) {
            profitRight[i] = Math.max(profitRight[i+1], curMax - prices[i]);
            curMax = Math.max(curMax, prices[i]);
        }
        
        for (i = 0; i < length; i++){
            max = Math.max(max, profitLeft[i]+profitRight[i]);
        }
        return max;
    }
    
    public static void main(String args[]) {
        StockBuySellBestIII s =  new StockBuySellBestIII();
        int t1[] = {1, 2};
        
        System.out.println(s.maxProfit(t1));
        
    }
}
