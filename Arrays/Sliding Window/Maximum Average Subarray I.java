class Solution {
    public double findMaxAverage(int[] nums, int k) {

        int i = 0, max = 0;

        for(int x = 0; x < k; x++){
            max += nums[x];
        }

        int sum = max;

        for(int j = k; j < nums.length; j++){
            sum = sum - nums[i++] + nums[j];
            max = Math.max(max, sum);
        }

        return (double)max / k;
    }
}