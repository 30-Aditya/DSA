class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(ans, "", 2 * n);
        return ans;
    }

    public void generate(List<String> ans, String s, int length) {
        if (s.length() == length) {
            if (isValid(s)) {
                ans.add(s);
            }
            return;
        }

        generate(ans, s + "(", length);
        generate(ans, s + ")", length);
    }

    public boolean isValid(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }

            if (count < 0) {
                return false;
            }
        }

        return count == 0;
    }
}