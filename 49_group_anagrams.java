class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        Map<String , List<String>> mp = new HashMap<>();


        for(String x : strs){
            String copy = x;
            char[] arr = copy.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);

            if(!mp.containsKey(sorted)){
                mp.put(sorted , new ArrayList<>());
            }

            mp.get(sorted).add(x);
        }

        mp.forEach((key , list)->{
            result.add(list);
        });

        return result ;
    }
}