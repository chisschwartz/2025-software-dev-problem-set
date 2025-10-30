// Brute Force //

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            int count = 1;
            int j = i + 1;
            while (j < n) {
            if (temperatures[j] > temperatures[i]) {
                break;
            }
            j++;
            count++;
        }

        count= (j == n) ? 0 : count;
        res[i] = count;
    }

    return res;
    }
}

// Stack //

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int[] res = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            int t = temperatures[i];
            
            while (!stack.isEmpty() && t > stack.peek()[0]) {
                int[] pair = stack.pop();
                res[pair[1]] = i - pair[1]; 
            }

            stack.push(new int[]{t, i});
        }
        
        return res;
    }
}

// Dynamic Programming //

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        int[] res = new int[n];
        //Initializes the result array with the same length as temperatures

        for (int i = n - 2; i >= 0; i--) {
            
            int j = i + 1;

            while (j < n && temperatures[j] <= temperatures[i]) {
                if (res[j] == 0) {
                    j = n;
                    break;
                }

                j += res[j];
            }

            if (j < n) {
                res[i] = j - i;
            }
        }

        return res;
    }
}