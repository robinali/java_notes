class Solution {
    // 209
    // Reference: cspiration
    public int minSubArrayLen(int s, int[] nums) {
        // Time: O(n) Space: O(1)
        int res = Integer.MAX_VALUE;
        int left = 0, sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while(left <= i && sum >= s) {
                res = Math.min(res, i - left + 1);
                sum -= nums[left++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}