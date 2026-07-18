class Solution {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length, product = 1;
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = product;
            product *= nums[i];
        }

        product = 1;

        for(int i = n - 1; i >= 0; i--){
            arr[i] *= product;
            product *= nums[i];
        }

        return arr;
    }
}