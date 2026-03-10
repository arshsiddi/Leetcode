class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer , Integer> mp = new HashMap<>();
        List<Integer>[] count = new List[nums.length+1];

        for(int num : nums){
            mp.put(num , mp.getOrDefault(num , 0)+1);
        }

        mp.forEach((key , value)->{
            if(count[value] == null){
                count[value] = new ArrayList<>();
            }

            count[value].add(key);
        });
        int counter = 0;;
        int[] result = new int[k];
        for(int i= count.length-1 ; i>=0 && counter<k ; i--){
            if(count[i] != null){
                for(int x : count[i]){
                    result[counter] = x;
                    counter++;
                    if(counter == k){
                        return result;
                    }
                }
            }

        }

        return result;

    }
}