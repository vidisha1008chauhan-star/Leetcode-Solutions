class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";

        Map<Character, Integer> map = new HashMap<>();
        for(char ch : t.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int left = 0, count = t.length();
        int[] window = {0, Integer.MAX_VALUE};

        for(int right = 0; right < s.length(); right++){
            
            char ch = s.charAt(right);
            if(map.containsKey(ch) && map.get(ch) > 0) count--;
            map.put(ch, map.getOrDefault(ch, 0) - 1);

            if(count == 0){
                while(true){
                    char chLeft = s.charAt(left);
                    if(map.containsKey(chLeft) && map.get(chLeft) == 0) break;
                    map.put(chLeft, map.getOrDefault(chLeft, 0) + 1);
                    left++;
                } 

                if(right - left < window[1] - window[0]){
                    window[0] = left;
                    window[1] = right;
                }

                map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0) + 1);
                count++;
                left++;
            }
        }
        return window[1] >= s.length() ? "" : s.substring(window[0], window[1] + 1);
    }
}