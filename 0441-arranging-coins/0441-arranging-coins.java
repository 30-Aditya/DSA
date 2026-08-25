class Solution {
    public int arrangeCoins(int n) {
        int row = 1;
        int completeRows = 0;

        while (n >= row) {
            n = n - row;
            completeRows++;
            row++;
        }

        return completeRows;
    }
}