// Brute Force //

class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;

        for (int i = 0; i < prices.length; i++) {
            int buy = prices[i];
            
            for (int j = i + 1; j < prices.length; j++) {
                int sell = prices[j];
                res = Math.max(res, sell - buy);
            }
        }

        return res;
    }
}

// Pointers //

class Solution {
    public int maxProfit(int[] prices) {
        int l = 0, r = 1;
        int maxP = 0;

        while (r < prices.length) {
            if (prices[l] < prices[r]) {
                int profit = prices[r] - prices[l];
                maxP = Math.max(maxP, profit);
            } else {
                l = r;
            }
            r++;
        }
        
        return maxP;
    }
}

// Dynamic Programming //

class Solution {
    public int maxProfit(int[] prices) {
        int maxP = 0;
        //stores our max profit
        int minBuy = prices[0];
        //stores our minimum price we can buy

        for (int sell : prices) {
            maxP = Math.max(maxP, sell - minBuy);
            //subtracts our bought price from the sell price, letting us determine the max profit
            minBuy = Math.min(minBuy, sell);
            //stores sell price and minBuy price, minBuy price for holding the lowest possible number while sell being the price of the day
        }
        
        return maxP;
        //returns the max profit we can secure from our analysis
    }
}