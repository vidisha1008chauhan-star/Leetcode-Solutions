class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int x = 0, n = arr.length;
        for(int i = 0; i < n; i++){
            x += ((i + 1) * (n - i) + 1) / 2 * arr[i];
        }
        return x;
    }
}