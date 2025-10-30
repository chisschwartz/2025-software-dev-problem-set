// Brute Force //

class Solution {
    public int search(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        
        return -1;
    }
}

// Binary Search (One Pass) //
// Other searches do exist this just takes up less interview time and makes sense in my brain //

class Solution {
    public int search(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = (l + r) / 2;

            if (nums[m] == target) {
                return m;
            }

            if (nums[l] <= nums[m]) {
                if (target > nums[m] || target < nums[l]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else {
                
                if (target < nums[m] || target > nums [r]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }

        return - 1;
    }
}