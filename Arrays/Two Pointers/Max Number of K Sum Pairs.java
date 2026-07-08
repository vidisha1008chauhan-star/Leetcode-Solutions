class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int operations = 0, i = 0, j = nums.length - 1;
        while(i < j){
            int sum = nums[i] + nums[j];
            if(sum == k){
                operations++;
                i++;
                j--;
            }
            else if(sum > k) j--;
            else i++;
        }
        return operations;
    }
}