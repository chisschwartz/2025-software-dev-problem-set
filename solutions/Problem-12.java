// Brute Force //

class Solution {
    public int maxArea(int[] height) {
        int res = 0;
        
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                res = Math.max(res, Math.min(height[i], height[j]) * (j - i));
            }
        }
        
        return res;
    }
}

// Two Pointers //

class Solution {
    public int maxArea(int[] height) {
        int res = 0;
        int l = 0;
        int r = height.length - 1;
        //intializes starting pointers

        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            //calculates the area

            res = Math.max(res, area);
            //picks between the stored result and area being evaluated
            //chooses the greater of the two

            if (height[l] <= height[r]) {
                l++;
                //increases left pointer
            } else {
                r--;
                //decreases right pointer
            }
        }

        return res;
    }
}
