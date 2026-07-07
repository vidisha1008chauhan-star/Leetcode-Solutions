class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0; i<nums.length-3; i++){
            if(i > 0 && nums[i-1] == nums[i]) continue;
            for(int j=i+1; j<nums.length-2; j++){
                if(j > i + 1 && nums[j-1] == nums[j]) continue;
                int start = j + 1;
                int end = nums.length - 1;

                while(start < end){
                    long sum = (long)nums[i] + (long)nums[j] + (long)nums[start] + (long)nums[end];
                    if(sum < target) start++;
                    else if(sum > target) end--;
                    else {
                        list.add(Arrays.asList(nums[i],nums[j],nums[start],nums[end]));
                        while((start < end) && nums[start + 1] == nums[start]) start++;
                        while((start < end) && nums[end - 1] == nums[end]) end--;
                        start++;
                        end--;
                    }
                }
            }
        }
        return list;
    }
}