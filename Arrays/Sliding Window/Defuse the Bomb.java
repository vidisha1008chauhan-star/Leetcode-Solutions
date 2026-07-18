1. Brute Force

class Solution {
    public int[] decrypt(int[] code, int k) {

        int[] arr = new int[code.length];
        if(k == 0) return arr;

        for(int i = 0; i < code.length; i++){
            if(k > 0){
                int count = 0, j = i;
                while(count < k){
                    count++;
                    j++;
                    arr[i] += code[j % code.length];
                }
            }
            else{
                int count = k, j = 1;
                while(count < 0){
                    count++;
                    arr[i] += code[(i - j + code.length) % code.length];
                    j++;
                }
            }
        }
        return arr;
    }
}

2. Optimal I

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

3. Optimal II

class Solution {
    public int[] decrypt(int[] code, int k) {

        int[] arr = new int[code.length];  
        int sum = 0, left = 0, n = code.length;

        if (k == 0) return arr;

        int start = (k > 0) ? 1 : n + k;
        int end = (k > 0) ? k : n - 1;

        for(int i = start; i <= end; i++){
            sum += code[i % n];
        }

        for(int i = 0; i < n; i++){
            arr[i] = sum;
            sum -= code[(start + i) % n];
            sum += code[(end + i + 1) % n];
        }
        return arr;
    }
}