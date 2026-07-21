class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        int[] arr = new int[k];
        int sum = 0, count = 0;

        arr[0]++;

        for(int num: nums){
            sum += num;
            int rem = sum % k;

            if(rem < 0) rem += k;

            count += arr[rem];
            arr[rem]++;
        }

        return count;
    }
}