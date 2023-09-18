public class BestTimeTobuy {
    public int maxProfit(int[] prices) {
        int maxProf = 0, minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProf = Math.max(maxProf, prices[i] - minPrice);
        }
        return maxProf;
    }
}
