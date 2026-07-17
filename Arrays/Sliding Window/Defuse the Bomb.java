class Solution {
    public int[] decrypt(int[] code, int k) {

        int[] arr = new int[code.length];  
        int sum = 0, left = 0;

        if (k == 0) return arr;

        for(int right = 0; right < code.length + Math.abs(k); right++){
            sum += code[right % code.length];
            if(right - left + 1 > Math.abs(k)){
                sum -= code[left % code.length];
                left = (left + 1) % code.length;
            }

            if(right - left + 1 == Math.abs(k)){
                if(k > 0) arr[(left - 1 + code.length) % code.length] = sum;
                else arr[(right + 1) % code.length] = sum;
            }
        }
        return arr;
    }
}