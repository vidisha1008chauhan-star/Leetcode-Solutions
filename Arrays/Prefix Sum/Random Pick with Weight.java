class Solution {

    int[] arr;
    Random random = new Random();

    public Solution(int[] w) {
        arr = new int[w.length];
        arr[0] = w[0];

        for(int i = 1; i < w.length; i++){
            arr[i] = w[i] + arr[i - 1];
        }
    }
    
    public int pickIndex() {
        int target = random.nextInt(arr[arr.length - 1]) + 1;
        int left = 0, right = arr.length - 1;

        while(left < right){
            int mid = left + (right - left) / 2;
            if(arr[mid] >= target) right = mid;
            else left = mid + 1;
        }

        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */