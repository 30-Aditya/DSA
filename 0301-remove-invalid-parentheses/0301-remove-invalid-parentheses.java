class Solution {
    Set<String> ans = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {
        int leftRemove = 0;
        int rightRemove = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                leftRemove++;
            } else if (ch == ')') {
                if (leftRemove > 0) {
                    leftRemove--;
                } else {
                    rightRemove++;
                }
            }
        }

        dfs(s, 0, leftRemove, rightRemove, 0, new StringBuilder());

        return new ArrayList<>(ans);
    }

    void dfs(String s, int index, int leftRemove, int rightRemove,
             int balance, StringBuilder path) {

        if (balance < 0) {
            return;
        }

        if (index == s.length()) {
            if (leftRemove == 0 && rightRemove == 0 && balance == 0) {
                ans.add(path.toString());
            }
            return;
        }

        char ch = s.charAt(index);

        if (ch == '(') {

            if (leftRemove > 0) {
                dfs(s, index + 1, leftRemove - 1, rightRemove,
                    balance, path);
            }

            path.append(ch);

            dfs(s, index + 1, leftRemove, rightRemove,
                balance + 1, path);

            path.deleteCharAt(path.length() - 1);

        } else if (ch == ')') {

            if (rightRemove > 0) {
                dfs(s, index + 1, leftRemove, rightRemove - 1,
                    balance, path);
            }

            if (balance > 0) {
                path.append(ch);

                dfs(s, index + 1, leftRemove, rightRemove,
                    balance - 1, path);

                path.deleteCharAt(path.length() - 1);
            }

        } else {

            path.append(ch);

            dfs(s, index + 1, leftRemove, rightRemove,
                balance, path);

            path.deleteCharAt(path.length() - 1);
        }
    }
}