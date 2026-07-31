class Solution {
    public int[] runningSum(int[] nums) {
        for(int j=1;j<nums.length;j++)
        {
            nums[j]=nums[j]+nums[j-1];
        }
        return nums;
    }
}