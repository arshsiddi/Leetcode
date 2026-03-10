class Solution {
    public int helper(int amount , int[] coins , int[][] dp , int index){
        if(index >= coins.length || amount < 0){
            return 0;
        }

        if(amount == 0){
            return 1;
        }


        if(dp[index][amount] != -1){
            return dp[index][amount];
        }

        int nottake = helper(amount  , coins , dp , index+1);
        int take = 0;
        if(coins[index] <= amount){
            take = helper(amount - coins[index] , coins , dp , index);
        }

        return dp[index][amount] = take + nottake;
    }
    public int change(int amount, int[] coins) {

        int[][] dp = new int[coins.length+1][amount+1];

        for(int i =0 ; i<= coins.length ; i++){
            for(int j=0 ; j<=amount ; j++){
                dp[i][j] = -1;
            }
        }

        return helper(amount , coins , dp , 0);
        
    }
}