class Solution {
    public int helper(int[] nums , int index , int target , int[][] dp){
        if(index == nums.length){
            if(target == 0){
                return 1;
            }
            else{
                return 0;
            }
        }

        if(dp[index][target] != -1){
            return dp[index][target];
        }

        int nottake = helper(nums , index+1 , target , dp);

        int take = 0;

        if(nums[index] <= target){
            take = helper(nums , index+1 , target-nums[index] , dp);
        }

        int result = take + nottake;

        return dp[index][target] = result;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        int newtarget = (sum + target)/2;
        if(newtarget < 0){
            return 0 ;
        }
        int[][] dp = new int[nums.length+1][newtarget+1];
        
        for(int i =0 ; i<=nums.length ; i++){
            for(int j = 0; j<=newtarget ; j++){
                dp[i][j] = -1;
            }
        }


        if((sum+target)%2 == 0){
            return helper(nums , 0 , newtarget , dp);
        }

        else{
            return 0;
        }
        
    }
}