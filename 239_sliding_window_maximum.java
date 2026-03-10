class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] nge = new int[nums.length];

        LinkedList<Integer> st = new LinkedList<>();

        Arrays.fill(nge , Integer.MAX_VALUE);

        for(int i =0 ; i<nums.length ; i++){

            int curr = nums[i];

            while(!st.isEmpty() && curr > nums[st.peek()]){
                nge[st.peek()] = i;
                st.pop();
            }

            st.push(i);
        }

        int[] ans = new int[nums.length - k + 1];

        int insert = 0;
        int j =0;

        for(int i =0 ; i<=nums.length - k && insert < nums.length-k+1; i++){
            if(j<i){
                j=i;
            }
            while(nge[j] < i+k){
                j = nge[j];
            }

            ans[insert] = nums[j];
            insert++;
        }

        return ans ;
    }
}