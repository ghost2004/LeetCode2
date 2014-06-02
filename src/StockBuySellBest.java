/*
 * Say you have an array for which the ith element is the 
 * price of a given stock on day i.

If you were only permitted to complete at most one 
transaction (ie, buy one and sell one share of the stock), 
design an algorithm to find the maximum profit.
 */
public class StockBuySellBest {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int max = 0;
        int curMin = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > curMin) {
                max = Math.max(max, prices[i] - curMin);
            } else {
                curMin = prices[i];
            }
        }
        
        return max;
    }
}
