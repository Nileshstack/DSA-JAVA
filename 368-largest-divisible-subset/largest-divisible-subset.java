class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int[] idx = new int[n];
        Arrays.fill(idx, -1);

        int last = 0;
        int max = 1;

        // Build DP
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {

                if (nums[i] % nums[j] == 0) {

                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        idx[i] = j;
                    }

                    if (dp[i] > max) {
                        max = dp[i];
                        last = i;
                    }
                }
            }
        }

        // Reconstruct answer
        List<Integer> ans = new LinkedList<>();

        while (last != -1) {
            ans.add(nums[last]);
            last = idx[last];
        }

        return ans;
    }
}