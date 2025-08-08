// Brute Force //

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            int prod = 1;

            for (int j = 0; j < n; j++) {
                if (i != j) {
                    prod *= nums[j];
                }
            }

            res[i] = prod;
        }
        
        return res;
    }
}

// Division //

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod =1, zeroCount = 0;

        for(int num : nums) {
            if (num != 0) {
                prod *= num;
            } else {
                zeroCount++;
            }
        }

        if (zeroCount > 1) {
            return new int[nums.length];
        }

        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (zeroCount > 0) {
                res[i] = (nums[i] == 0) ? prod : 0;
            } else {
                res[i] = prod / nums[i];
            }
        }

        return res;
    }
}

// Prefix & Suffix //

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] pref = new int[n];
        int[] suff = new int[n];

        pref[0] = 1;
        suff[n - 1] = 1;

        for (int i = 1; i < n; i++) {
            pref[i] = nums[i - 1] * pref[i - 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            suff[i] = nums[i + 1] * suff[i + 1];
        }

        for (int i = 0; i < n; i++) {
            res[i] = pref[i] * suff[i];
        }

        return res;
    }
}

// Prefix & Suffix (Optimal) //

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        res[0] = 1;

        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int postfix = 1;

        for (int i = n - 1; i >= 0; i--) {
            res[i] *= postfix;
            postfix *= nums[i];
        }

        return res;
    }
}
