class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int i = 0, ans = 0, max = 0;

        for(int j = 0; j < s.length(); j++){
            freq[s.charAt(j) - 'A']++;
            max = Math.max(freq[s.charAt(j) - 'A'], max);

            while((j - i + 1) - max > k){
                freq[s.charAt(i) - 'A']--;
                i++;
            }
            ans = Math.max(ans, j - i + 1);
        }

        return ans;
    }
}