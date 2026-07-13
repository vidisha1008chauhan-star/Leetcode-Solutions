class Solution {
    public int numberOfSubstrings(String s) {

        int[] freq = new int[3];
        int  i = 0, ans = 0, k = 2;

        for(int j = 0; j < s.length(); j++){

            char ch = s.charAt(j);
            if(freq[ch - 'a'] == 0) k--;
            freq[ch - 'a']++;

            while(k < 0){
                freq[s.charAt(i) - 'a']--;
                if(freq[s.charAt(i) - 'a'] == 0) k++;
                i++;
            }
            ans += j - i + 1;
        }
        int n = s.length();
        long total = (long) n * (n + 1) / 2;

        return (int)(total - ans);
    }
}