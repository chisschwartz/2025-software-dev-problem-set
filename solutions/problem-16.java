// Brute Force //

public class Solution {
    public boolean valid(String s) {

        int open = 0;
        for (char c : s.toCharArray()) {
            open += c == '(' ? 1 : -1;
            if (open < 0) return false;
        }
        return open == 0;
    }

    void dfs(String s, List<String> res, int n) {

        if (n * 2 == s.length()) {
            if (valid(s)) res.add(s);
            return;
        }

        dfs(s + '(', res, n);
        dfs(s + ')', res, n);
    }

    public List<String> generateParenthesis(int n) {
        
        List<String> res = new ArrayList<>();
        dfs("", res, n);
        return res;
    }
}

// Backtracking //

public class Solution {
    private void backtrack(int openN, int closedN, int n, List<String> res, StringBuilder stack) {
        
        if (openN == closedN && openN == n) {
            res.add(stack.toString());
            return;
        }

        if (openN < n) {
            stack.append('(');
            backtrack(openN + 1, closedN, n, res, stack);
            stack.deleteCharAt(stack.length() - 1);
        }

        if (closedN < openN) {
            stack.append(')');
            backtrack(openN, closedN + 1, n, res, stack);
            stack.deleteCharAt(stack.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();
        StringBuilder stack = new StringBuilder();
        backtrack(0, 0, n, res, stack);
        return res;
    }
}

// Dynamic Programming //

class Solution {
    public List<String> generateParenthesis(int n) {

        List<List<String>> res = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            res.add(new ArrayList<>());
        }

        res.get(0).add("");

        for (int k = 0; k <= n; k++) {
            for (int i = 0; i < k; i++) {
                for (String left : res.get(i)) {
                    for (String right : res.get(k - i - 1)) {
                        res.get(k).add("(" + left + ")" + right);
                    }
                }
            }
        }

        return res.get(n);
        
    }
}