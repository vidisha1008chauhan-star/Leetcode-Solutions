class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atmost(nums, goal) - atmost(nums, goal - 1);
    }
    private int atmost(int[] nums, int goal){
        int i = 0, sum = 0, ans = 0;
        for(int j = 0; j < nums.length; j++){
            sum += nums[j];
            while(i <= j && sum > goal) sum -= nums[i++];
            ans += j - i + 1;
        }
        return ans;
    }
}