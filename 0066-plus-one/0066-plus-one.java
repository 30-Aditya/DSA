class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        digits[n-1]++;

        for(int i = n-1; i >= 0; i--){
            if(digits[i] == 10){
                digits[i] = 0;
                if(i > 0)
                    digits[i-1]++;
                else{
                    int[] ans = new int[n+1];
                    ans[0] = 1;
                    return ans;
                }
            }
            else{
                break;
            }
        }
        return digits;
    }
}