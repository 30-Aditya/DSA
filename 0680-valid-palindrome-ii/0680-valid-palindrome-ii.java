class Solution {
    public boolean palindromeHelper(int i, int j,String s){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;

    }
    public boolean validPalindrome(String s) {
        int n  = s.length();
        int i = 0;
        int j = s.length() - 1;

        while(i < j){
            int left = s.charAt(i);
            int right = s.charAt(j);
            
            if(left != right){
                // use our superpower
                return palindromeHelper(i+1,j,s) || palindromeHelper(i,j-1,s);
            }else{
                i++;
                j--;
            }
        }
        return  true;
    }
}