class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap();
        int cnt = 0;
        int n = nums.length;
        map.put(0, 1);
        int presum = 0;
        for (int i = 0; i < n; i++) {
            presum += nums[i];
            int rem = presum - k;
            cnt += map.getOrDefault(rem, 0);
            map.put(presum, map.getOrDefault(presum, 0) + 1);

        }
        return cnt;

    }
}