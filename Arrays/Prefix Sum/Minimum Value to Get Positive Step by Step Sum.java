class Solution {
    public int minStartValue(int[] nums) {
        int sum = 0, min = 0;
        for(int num : nums){
            sum += num;
            min = Math.min(min, sum);
        }
        return 1 - min;
    }
}