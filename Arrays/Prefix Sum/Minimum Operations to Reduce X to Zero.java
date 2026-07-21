class Solution {
    public int minOperations(int[] nums, int x) {

        int total = 0, max = -1;

        for(int num: nums) total += num;

        int target = total - x;

        if(target < 0) return -1;
        if(target == 0) return nums.length;

        int i = 0, sum = 0;

        for(int j = 0; j < nums.length; j++){
            sum += nums[j];
            while(sum > target) sum -= nums[i++];
            if(sum == target) max = Math.max(max, j - i + 1);
        }

        if(max == -1) return -1;

        return nums.length - max;
    }
}