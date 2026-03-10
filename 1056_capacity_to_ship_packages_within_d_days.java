class Solution {
    public boolean valid(int[] weights , int days , int capacity){
        int current = 0;
        int result = 1;


        for(int i =0 ; i<weights.length ; i++){

            if(weights[i]>capacity){
                return false ;
            }
            current += weights[i];
            if(current > capacity){
                current = weights[i];
                result++;
            }
        }

        if(result <=days){
            return true;
        }

        return false;

        
    }
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;

        int right =0;

        for(int i =0 ; i<weights.length ; i++){
            right += weights[i];
        }

        while(left <= right){
            int mid = left + (right - left)/2;

            if(valid(weights , days , mid)){
                right = mid-1;
            }

            else{
                left = mid+1;
            }
        }

        return left ;
        
    }
}