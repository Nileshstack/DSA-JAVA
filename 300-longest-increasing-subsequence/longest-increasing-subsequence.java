class Solution {
    public int lengthOfLIS(int[] nums) {
        //using Ptience sort
        ArrayList<Integer> sorted = new ArrayList<>();

        for (int num : nums) {
            int idx = lowerBound(sorted, num);

            if (idx == sorted.size()) {
                sorted.add(num);
            } else {
                sorted.set(idx, num);
            }
        }

        return sorted.size();
    }

    private int lowerBound(ArrayList<Integer> list, int target) {
        int left = 0, right = list.size();

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}