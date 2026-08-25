class Solution {
    public int findNumbers(int[] nums) {
        int result = 0;
        for (int num : nums) {
            if(10 <= num && num <= 99 || 1000 <=num && num <= 9999 || num == 100000){
                result++;
            }
        }
        return result;
    }
}