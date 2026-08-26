class Solution {

    public int[] searchRange(int[] nums, int target) {
        int first = binarySearch(nums, target, true);
        int last = binarySearch(nums, target, false);
        return new int[]{first, last};
    }

    public int binarySearch(int[] nums, int target, boolean firstValue) {
        int low = 0;
        int high = nums.length - 1;
        int result = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target == nums[mid]) {
                result = mid;
                if (firstValue) {
                    high = mid - 1; // first occurrence ke liye left
                } else {
                    low = mid + 1;  // last occurrence ke liye right
                }
            } 
            else if (target > nums[mid]) {
                low = mid + 1;
            } 
            else {
                high = mid - 1;
            }
        }
        return result;
    }
}