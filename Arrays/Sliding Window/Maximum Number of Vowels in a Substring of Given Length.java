class Solution {
    public int maxVowels(String s, int k) {

        int max = 0, i = 0, curr = 0;

        for(int j = 0; j< s.length(); j++){
            char ch1 = s.charAt(j);
            if(ch1 == 'a' || ch1 == 'e' || ch1 == 'i' || ch1 == 'o' || ch1 == 'u') curr++;
            if(j - i >= k){
                char ch2 = s.charAt(i);
                if(ch2 == 'a' || ch2 == 'e' || ch2 == 'i' || ch2 == 'o' || ch2 == 'u')curr--;
                i++;
            }
            max = Math.max(curr, max);
            if(max == k) return k;
        }
        return max;
    }
}