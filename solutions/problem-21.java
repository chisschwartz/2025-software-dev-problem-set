// Brute Force //

class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int speed = 1;

        while (true) {
            long totalTime = 0;

            for (int pile: piles) {
                totalTime += (int) Math.ceil((double) pile/speed);
            }

            if (totalTime <= h) {
                return speed;
            }

            speed++;
        }
        
    }
}

// Binary Search //

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int res = r;

        while (l <= r) {
            int k = (l + r) / 2;

            long totalTime = 0;

            for (int p : piles) {
                totalTime += Math.ceil((double) p / k);
            }

            if (totalTime <= h) {
                res = k;
                r = k - 1;
            } else {
                l = k + 1;
            }
        }

        return res;
    }
}