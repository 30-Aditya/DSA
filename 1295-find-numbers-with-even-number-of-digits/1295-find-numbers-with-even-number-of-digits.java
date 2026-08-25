class Solution {
    public int findNumbers(int[] nums) {
        int result = 0;
        for(int num : nums){
            int length = String.valueOf(num).length();
            if(length % 2 == 0){
                result++;
            }
        }
        return result;
    }
}