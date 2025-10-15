// Stack //

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        int[][] pair = new int[position.length][2];
        for (int i = 0; i <  position.length; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }

        Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));
        Stack<Double> stack = new Stack<>();

        for (int[] p : pair) {
            stack.push((double) (target - p[0]) / p[1]);

            if (stack.size() >= 2 &&
                stack.peek() <= stack.get(stack.size() - 2))
        {
            stack.pop();
            }
        }

        return stack.size();
    }
}

// Iteration //

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        int n = position.length;
        int[][] pair = new int[n][2];

        for (int i = 0; i < n; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }

        Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));

        int fleets = 1;
        double prevTime = (double)(target - pair [0][0]) / pair [0][1];
        
        for (int i = 1; i < n; i++) {
            double currTime = (double)(target - pair[i][0]) / pair[i][1];

            if (currTime > prevTime) {
                fleets++;
                prevTime = currTime;
            }
        }
        
        return fleets;
    }
}
