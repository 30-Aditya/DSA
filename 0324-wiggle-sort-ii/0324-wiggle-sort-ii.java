class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);

        int[] temp = nums.clone();

        int n = nums.length;
        int l = (n - 1) / 2;
        int r = n - 1;
        for (int i = 0; i < n; i += 2) {
            nums[i] = temp[l--];
        }
        for (int i = 1; i < n; i += 2) {
            nums[i] = temp[r--];
        }
    }
}