import java.util.*;

public class BestTimeToBuyOrSellAStock {

    public static int maximumProfit(ArrayList<Integer> prices){
        // We shall apply an iterative approach here, where we initialise a zero profit and keep updating values as we go further
        int min = prices.get(0);
        int profit = 0;
        //now looping from 1 onwards
        for(int i = 1; i < prices.size(); i++) {
            int diff = prices.get(i) - min;
            profit = Math.max(profit, diff);
            min = Math.min(min, prices.get(i));
        }
        return profit;
    }


    public static void main(String[] args) {}
}
