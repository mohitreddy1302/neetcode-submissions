class Solution {
    public int maxProfit(int[] prices) {
       /*int maxprofit=0;
        for(int i=0;i<prices.length;i++){
            int temp=prices[i];
            for(int j=i+1;j<prices.length;j++){
                if(prices[j]-temp>maxprofit){
                    maxprofit=prices[j]-temp;
                }
            }

        }
        return maxprofit;*/

        // left = day we buy
        int left = 0;

        // right = day we sell
        int right = 1;

        // Best profit found so far
        int maxProfit = 0;

        // Keep moving the selling day forward
        while (right < prices.length) {

            // If selling price is greater than buying price,
            // we can make a profit
            if (prices[right] > prices[left]) {

                // Calculate profit for this window
                int profit = prices[right] - prices[left];

                // Update maximum profit
                maxProfit = Math.max(maxProfit, profit);

            } else {

                // Today's price is cheaper than our current buying price.
                // So this is now a better day to buy.
                left = right;
            }

            // Move selling day forward
            right++;
        }

        return maxProfit;
    }
}
