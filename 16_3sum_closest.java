class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int min = nums[0]+nums[1]+nums[2];
        int len = nums.length;

        Arrays.sort(nums);

        for(int i = 0 ; i<len-2 ; i++){
            int left = i+1;
            int right = len-1;

            while(left < right){
                int sum = nums[left] + nums[right] + nums[i];
                
                if(sum == target){
                    return target;
                }

                if(Math.abs(sum - target) < Math.abs(min-target)){
                    min = sum;
                }
                
                if(sum > target){
                    right--;
                }
                
                else{
                    left++;
                }
            }
        }
        
        return min;
        
    }
}