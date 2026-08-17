class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit=0;
        for(int i=0;i<prices.length;i++){
            int temp=prices[i];
            for(int j=i+1;j<prices.length;j++){
                if(prices[j]-temp>maxprofit){
                    maxprofit=prices[j]-temp;
                }
            }

        }
        return maxprofit;
    }
}
