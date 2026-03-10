class Solution {
    public int numberOfSubstrings(String s) {
        int left = 0;
         
        Map<Character , Integer> mp = new HashMap<>();
        int count = 0;
        for(int right = 0 ; right < s.length() ; right++){
            mp.put(s.charAt(right) , mp.getOrDefault(s.charAt(right) , 0)+1);

            while(mp.size() == 3){
                count += s.length()-right ; 
                mp.put(s.charAt(left) , mp.get(s.charAt(left))-1);
                if(mp.get(s.charAt(left)) == 0){
                    mp.remove(s.charAt(left));
                }

                left++;

            }
        }

        return count ;
        
    }
}