class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longest = 0, i = 0;
        Map<Character, Integer> map = new HashMap<>();

        for(int j=0; j<s.length(); j++){
            if(map.containsKey(s.charAt(j)) && map.get(s.charAt(j)) >= i){
                i = map.get(s.charAt(j)) + 1; 
                map.put(s.charAt(j), j);
            }
            else{
                map.put(s.charAt(j), j);
                longest = Math.max(longest, j - i + 1); 
            }
        }
        return longest;
    }
}